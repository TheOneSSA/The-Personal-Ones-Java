package test;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.TextAnchor;

public class Attempt1  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter file location:");
			String s=sc.nextLine();
			FileInputStream file=new FileInputStream(s);
			XSSFWorkbook wb=new XSSFWorkbook(file);
			int ABP[]= {0,0,0,0,0},BU[]= {0,0,0,0,0},DEP[]= {0,0,0,0,0},TAP[]= {0,0,0,0,0};
			for(int i=0;i<wb.getNumberOfSheets();i++)
			{
				XSSFSheet sheet=wb.getSheetAt(i);
				ABP[i]=search(sheet,"ABP");
				BU[i]=search(sheet,"BU");
				DEP[i]=search(sheet,"DEP");
				TAP[i]=search(sheet,"TAP");
				
			}
			
			int pABP[]= {0,0},pBU[]= {0,0},pDEP[]= {0,0},pTAP[]= {0,0};
			int pdABP[]= {0,0},pdBU[]= {0,0},pdDEP[]= {0,0},pdTAP[]= {0,0};
			int j=0;
			for(int i=1;i<5;i+=3)
			{
				
				XSSFSheet sheet=wb.getSheetAt(i);
				pABP[j]=process_search(sheet,"ABP");
				pBU[j]=process_search(sheet,"BU");
				pDEP[j]=process_search(sheet,"DEP");
				pTAP[j]=process_search(sheet,"TAP");
				j++;
				
			}
			
			j=0;
			for(int i=1;i<5;i+=3)
			{
				
				XSSFSheet sheet=wb.getSheetAt(i);
				pdABP[j]=product_search(sheet,"ABP");
				pdBU[j]=product_search(sheet,"BU");
				pdDEP[j]=product_search(sheet,"DEP");
				pdTAP[j]=product_search(sheet,"TAP");
				j++;
			}
			
			System.out.println("Hello");

			
				
				
			
			
		
			System.out.println("Enter choice:");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				ConstructStackBar(wb,ABP,BU,DEP,TAP);
				System.out.println("Graph 1 image has been created at your desktop");
				break;
			case 2:
				ConstructCompareBar(wb,ABP,BU,DEP,TAP);
				System.out.println("Comparing graph image has been created at your desktop");
				break;
			case 3:
				ConstructGraph3_or_4(ch,wb,pABP,pBU,pDEP,pTAP,pdABP,pdBU,pdDEP,pdTAP);
				System.out.println(" DONE");
				break;
			case 4:
				ConstructGraph3_or_4(ch,wb,pABP,pBU,pDEP,pTAP,pdABP,pdBU,pdDEP,pdTAP);
				System.out.println(" DONE");
				break;
				default:
					System.out.println("Invalid choice");
			}
			
			
			
			
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

private static void ConstructGraph3_or_4(int ch, XSSFWorkbook wb, int[] pABP, int[] pBU, int[] pDEP, int[] pTAP,
		int[] pdABP, int[] pdBU, int[] pdDEP, int[] pdTAP) throws IOException {
	// TODO Auto-generated method stub
	
	if (ch==3)
	{
		String abp="ABP",bu="BU",dep="DEP",tap="TAP";
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		dataset.addValue(pABP[0],abp,"Process");
		dataset.addValue(pBU[0],bu,"Process");
		dataset.addValue(pDEP[0],dep, "Process");
		dataset.addValue(pTAP[0], tap,"Process");
		
		dataset.addValue(pdABP[0],abp,"Product");
		dataset.addValue(pdBU[0],bu,"Product");
		dataset.addValue(pdDEP[0],dep,"Product");
		dataset.addValue(pdTAP[0],tap,"Product");
		
		JFreeChart chart =ChartFactory.createBarChart3D("", "Started and Completed in FY-19", "Number of Projects", dataset,PlotOrientation.VERTICAL,true,true,false);
		CategoryPlot plot=chart.getCategoryPlot();
		BarRenderer br=(BarRenderer)plot.getRenderer();
		br.setItemMargin(0);
		
		plot.getRenderer().setSeriesPaint(0,new Color(85,107,47));
		plot.getRenderer().setSeriesPaint(0, new Color(128,128,0));
		
		CategoryItemRenderer renderer = ((CategoryPlot)chart.getPlot()).getRenderer();

        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, 
        		TextAnchor.BOTTOM_CENTER);
        renderer.setBasePositiveItemLabelPosition(position);
		int width=1080;
		int height=800;
		File file=new File("Graph3.jpeg");
		ChartUtilities.saveChartAsJPEG(file, chart, width, height);
	}
	else if(ch==4)
	{
		String abp="ABP",bu="BU",dep="DEP",tap="TAP";
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		System.out.println(pABP[1]);
		dataset.addValue(pABP[1],abp,"Process");
		dataset.addValue(pBU[1],bu,"Process");
		dataset.addValue(pDEP[1],dep, "Process");
		dataset.addValue(pTAP[1], tap,"Process");
		
		dataset.addValue(pdABP[1],abp,"Product");
		dataset.addValue(pdBU[1],bu,"Product");
		dataset.addValue(pdDEP[1],dep,"Product");
		dataset.addValue(pdTAP[1],tap,"Product");
		
		JFreeChart chart =ChartFactory.createBarChart3D("", "Started and Completed in FY-19", "Number of Projects", dataset,PlotOrientation.VERTICAL,true,true,false);
		CategoryPlot plot=chart.getCategoryPlot();
		BarRenderer br=(BarRenderer)plot.getRenderer();
		br.setItemMargin(0);
		
		plot.getRenderer().setSeriesPaint(0,new Color(85,107,47));
		plot.getRenderer().setSeriesPaint(0, new Color(128,128,0));
		
		CategoryItemRenderer renderer = ((CategoryPlot)chart.getPlot()).getRenderer();

        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, 
        		TextAnchor.BOTTOM_CENTER);
        renderer.setBasePositiveItemLabelPosition(position);
		int width=1080;
		int height=800;
		File file=new File("Graph4.jpeg");
		ChartUtilities.saveChartAsJPEG(file, chart, width, height);	
	}
}
	

private static int product_search(XSSFSheet sheet, String string) {
	// TODO Auto-generated method stub
	int count=0;
	for(Row row:sheet)
		for(Cell cell:row)
		{
			switch(cell.getCellType())
			{
			case STRING:
				String s=cell.getStringCellValue();
				if(s.contains(string) && (s.contains("PROD")||s.contains("PA")||s.contains("MCJ")||s.contains("MC")||s.contains("MWJ")||s.contains("MMPD")||s.contains("SE")||
						s.contains("NDTS")||s.contains("RA-PROD")||s.contains("CP")))
					count++;
				break;
			}
			break;
		}
	return count;
}


private static int process_search(XSSFSheet sheet, String string) {
	// TODO Auto-generated method stub
	
	int count=0;
	for(Row row:sheet)
		for(Cell cell:row)
		{
			switch(cell.getCellType())
			{
			case STRING:
				String s=cell.getStringCellValue();
				if(s.contains(string) )
					if((s.contains("SMC")||s.contains("IM")||s.contains("FAM")||s.contains("CCM")||s.contains("RM")||s.contains("ENV")||s.contains("IFA")||
						s.contains("AGGLO")||s.contains("RC")||s.contains("RC-PCAC")))
						count++;
				break;
			}
			break;
		}
	System.out.println(count);
	return count;
}


	private static void ConstructCompareBar(XSSFWorkbook wb, int[] ABP, int[] BU, int[] DEP, int[] TAP) throws IOException {
		// TODO Auto-generated method stub
		String abp="ABP",bu="BU",dep="DEP",tap="TAP";
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		dataset.addValue(ABP[1],"Started in FY-19",abp);
		dataset.addValue(BU[1],"Started in FY-19",bu);
		dataset.addValue(DEP[1], "Started in FY-19",dep);
		dataset.addValue(TAP[1],"Started in FY-19",tap);
		
		dataset.addValue(ABP[4],"Started and Completed in FY-19",abp);
		dataset.addValue(BU[4],"Started and Completed in FY-19",bu);
		dataset.addValue(DEP[4],"Started and Completed in FY-19",dep);
		dataset.addValue(TAP[4],"Started and Completed in FY-19",tap);

		JFreeChart chart =ChartFactory.createBarChart3D("", "", "Number of Projects", dataset,PlotOrientation.VERTICAL,true,true,false);
		CategoryPlot plot=chart.getCategoryPlot();
		plot.getRenderer().setSeriesPaint(0,new Color(85,107,47));
		plot.getRenderer().setSeriesPaint(0, new Color(128,128,0));
		
		CategoryItemRenderer renderer = ((CategoryPlot)chart.getPlot()).getRenderer();

        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, 
        		TextAnchor.BOTTOM_CENTER);
        renderer.setBasePositiveItemLabelPosition(position);
		int width=1080;
		int height=800;
		File file=new File("ComparingGraph.jpeg");
		ChartUtilities.saveChartAsJPEG(file, chart, width, height);
		
	}

	private static void ConstructStackBar(XSSFWorkbook wb, int[] ABP, int[] BU, int[] DEP, int[] TAP) throws IOException {
		// TODO Auto-generated method stub
		
			String abp="ABP",bu="BU",dep="DEP",tap="TAP";
			DefaultCategoryDataset dataset=new DefaultCategoryDataset();
			dataset.addValue(ABP[0],abp,"Previous FY Rolling Projects");
			dataset.addValue(BU[0],bu,"Previous FY Rolling Projects");
			dataset.addValue(DEP[0],dep,"Previous FY Rolling Projects");
			dataset.addValue(TAP[0], tap,"Previous FY Rolling Projects");
			
			dataset.addValue(ABP[1],abp,"Started in FY-19");
			dataset.addValue(BU[1],bu,"Started in FY-19");
			dataset.addValue(DEP[1],dep, "Started in FY-19");
			dataset.addValue(TAP[1], tap,"Started in FY-19");
			
			dataset.addValue(ABP[2],abp,"Completed in FY-19");
			dataset.addValue(BU[2],bu,"Completed in FY-19");
			dataset.addValue(DEP[2],dep,"Completed in FY-19");
			dataset.addValue(TAP[2], tap,"Completed in FY-19");
			
			dataset.addValue(ABP[3],abp,"Rolling to Next FY");
			dataset.addValue(BU[3],bu,"Rolling to Next FY");
			dataset.addValue(DEP[3],dep, "Rolling to Next FY");
			dataset.addValue(TAP[3], tap,"Rolling to Next FY");
			
			JFreeChart chart =ChartFactory.createStackedBarChart3D("", "", "Number of Projects", dataset,PlotOrientation.VERTICAL,true,true,false);
			CategoryPlot plot=chart.getCategoryPlot();
			plot.getRenderer().setSeriesPaint(0,new Color(135,206,250));
			plot.getRenderer().setSeriesPaint(0, new Color(255,140,0));
			plot.getRenderer().setSeriesPaint(0,new Color(85,107,47));
			plot.getRenderer().setSeriesPaint(0, new Color(255,215,0));
			
			CategoryItemRenderer renderer = ((CategoryPlot)chart.getPlot()).getRenderer();

	        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	        renderer.setBaseItemLabelsVisible(true);
	        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.CENTER, 
	        		TextAnchor.TOP_CENTER);
	        renderer.setBasePositiveItemLabelPosition(position);
	        
			int width=1080;
			int height=800;
			File file=new File("D:\\Graph 1.jpeg");
			ChartUtilities.saveChartAsJPEG(file, chart, width, height);
		}
		

	
	private static int search(XSSFSheet sheet, String content) {
		// TODO Auto-generated method stub
		int count=0;
		for(Row row:sheet)
			for(Cell cell:row)
			{
				switch(cell.getCellType())
				{
				case STRING:
					if(cell.getStringCellValue().contains(content))
						count++;
					break;
				}
				break;
			}
				
		return count;
	}

}
