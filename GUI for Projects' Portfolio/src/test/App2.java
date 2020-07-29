package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

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
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

public class App2 implements ActionListener{
	private JFrame frame1 =new JFrame("Graph Plotter");
	private JTextField txtfield1=new JTextField("Type Here");
	private JTextField txtfield2=new JTextField();
	private JTextField txtfield3=new JTextField();
	
	private Container c;
	
	private JButton b1=new JButton("Graph 1");
	private JButton b2=new JButton("Graph 2");
	private JButton b3=new JButton("Graph 3");
	private JButton b4=new JButton("Graph 4");
	private JButton b5=new JButton("Graph 5");
	private JButton b6=new JButton("Graph 6");
	
	public App2()
	{
		frame1.setVisible(true);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(400,100,990,700);
		frame1.setResizable(false);
		c=frame1.getContentPane();
		c.setLayout(null);
		
		Font f0=new Font("arial",Font.BOLD,25);
		Font f1=new Font("arial",Font.BOLD,15);
		Font f2=new Font("arial",Font.ITALIC,12);
		Font f3=new Font("arial",Font.ITALIC,18);
		Font f4=new Font("arial",Font.ITALIC,15);
		
		Label h1=new Label("Development of a Graphical Display of Projects Portfolio using Java and MS-Excel");
		c.add(h1);
		h1.setBounds(10, 10, 990, 50);
		h1.setFont(f0);
		Label h2=new Label("Graph 1: Showing trend between different number of projects.");
		Label h3=new Label("Graph 2: Comparison between projects only Started & Started-&-Ended in the year.");
		Label h4=new Label("Graph 3: Comparison between process and products of projects Started.");
		Label h5=new Label("Graph 4: Comparison between process and products of projects Started-&-Ended.");
		Label h6=new Label("Graph 5: Groupwise distribution of projects in Process Area for each individual sheet(as per the sheet no. entered).");
		Label h7=new Label("Graph 6: Groupwise distribution of projects in Product Area for each individual sheet(as per the sheet no. entered).");
		String txt="Enter the File Location (eg: D:\\\\Folder\\\\FileName.extension)";
		Label h8=new Label(txt);
		Label h10=new Label("Enter Sheet no. for Graph 5 & 6:");
		Label h9=new Label("NOTE:The Graphs will be generated and available for further use(eg.:printing,presentation,etc) in the form of '.jpeg' files.");
		c.add(h2);
		c.add(h3);
		c.add(h4);
		c.add(h5);
		c.add(h6);
		c.add(h7);
		c.add(h8);
		c.add(h9);
		c.add(h10);
		h2.setBounds(10,60,990,25);
		h3.setBounds(10,85,990,25);
		h4.setBounds(10,110,990,25);
		h5.setBounds(10, 135, 990, 25);
		h6.setBounds(10,160,990,25);
		h7.setBounds(10,185, 990, 25);
		h8.setBounds(10,220,990,30);
		h10.setBounds(10, 290, 250, 20);
		h2.setFont(f3);
		h3.setFont(f3);
		h4.setFont(f3);
		h5.setFont(f3);
		h6.setFont(f3);
		h7.setFont(f3);
		h8.setFont(f1);
		h9.setFont(f2);
		h10.setFont(f1);
		h2.setForeground(Color.GRAY);
		h3.setForeground(Color.GRAY);
		h4.setForeground(Color.GRAY);
		h5.setForeground(Color.GRAY);
		h6.setForeground(Color.GRAY);
		h7.setForeground(Color.GRAY);
		h8.setForeground(Color.BLACK);
		h9.setForeground(Color.BLACK);
		
		
		txtfield1.setBounds(10, 240, 950, 40);
		c.add(txtfield1);
		txtfield1.setFont(f3);
		txtfield1.setBackground(Color.BLACK);
		txtfield1.setForeground(Color.GRAY);
		
		txtfield3.setBounds(260,290,40,20);
		c.add(txtfield3);
		txtfield3.setFont(f3);
		txtfield3.setBackground(Color.BLACK);
		txtfield3.setForeground(Color.GRAY);
		
		b1.setBounds(20, 320, 150, 25);
		b2.setBounds(200,320,150,25);
		b3.setBounds(380,320,150,25);
		b4.setBounds(20,370,150,25);
		b5.setBounds(200,370,150,25);
		b6.setBounds(380,370,150,25);
		h9.setBounds(10,400,990,20);
		c.add(b1);
		c.add(b2);
		c.add(b3);
		c.add(b4);
		c.add(b5);
		c.add(b6);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		
		
		
		txtfield2.setBounds(10, 450, 950, 100);
		c.add(txtfield2);
		
		txtfield2.setFont(f3);
		txtfield2.setBackground(Color.BLACK);
		txtfield2.setForeground(Color.WHITE);
		
		//txtfield3.setBounds(10,500,350,40);
		//c.add(txtfield3);
		
		//txtfield3.setFont(f2);
		//txtfield3.setBackground(Color.WHITE);
		//txtfield3.setForeground(Color.BLACK);
		//txtfield3.setText("Made by: Soumya S. Acharya");
		Label l1 =new Label("Made by: Soumya S. Acharya");
		Label l2=new Label("Guide: Mr. P.S. Mitra"); 
		c.add(l1);
		c.add(l2);
		l1.setBounds(750, 600, 350, 20);
		l2.setBounds(750,610,350,40);
		l1.setFont(f4);
		l2.setFont(f4);
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App2 ob=new App2();

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src=e.getSource();
		txtfield1.setEditable(true);
		txtfield2.setEditable(false);
		txtfield3.setEditable(true);
		String t;
		Scanner sc=new Scanner(System.in);
		t=txtfield1.getText();
		try
		{
			FileInputStream file=new FileInputStream(t);
			XSSFWorkbook wb=new XSSFWorkbook(file);
			
			
			if(src==b1 || src==b2)
			{
				int ABP[]= {0,0,0,0,0},BU[]= {0,0,0,0,0},DEP[]= {0,0,0,0,0},TAP[]= {0,0,0,0,0};
				
				for(int i=0;i<wb.getNumberOfSheets();i++)
				{
					XSSFSheet sheet=wb.getSheetAt(i);
					ABP[i]=search(sheet,"ABP");
					BU[i]=search(sheet,"BU");
					DEP[i]=search(sheet,"DEP");
					TAP[i]=search(sheet,"TAP");
					
				}
				if(src==b1)
				{
					ConstructGraph1(wb,ABP,BU,DEP,TAP);
					txtfield2.setText("Graph 1 has been constructed");
				}
				if(src==b2)
				{
					ConstructGraph2(wb,ABP,BU,DEP,TAP);
					txtfield2.setText("Graph 2 has been constructed.");
				}
			}
			if(src==b3|| src==b4)
			{
				int pABP[]= {0,0},pBU[]= {0,0},pDEP[]= {0,0},pTAP[]= {0,0};
				int pdABP[]= {0,0},pdBU[]= {0,0},pdDEP[]= {0,0},pdTAP[]= {0,0};
				
				for(int i=1,j=0;i<=wb.getNumberOfSheets();i+=3,j++)
				{
					XSSFSheet sheet=wb.getSheetAt(i);
					pABP[j]=process_search(sheet,"ABP");
					pBU[j]=process_search(sheet,"BU");
					pDEP[j]=process_search(sheet,"DEP");
					pTAP[j]=process_search(sheet,"TAP");
					
				}
				
				for(int i=1,j=0;i<=wb.getNumberOfSheets();i+=3,j++)
				{
					XSSFSheet sheet=wb.getSheetAt(i);
					pdABP[j]=product_search(sheet,"ABP");
					pdBU[j]=product_search(sheet,"BU");
					pdDEP[j]=product_search(sheet,"DEP");
					pdTAP[j]=product_search(sheet,"TAP");
					
				}
								
	
				if(src==b3)
				{
					int ch=3;
					txtfield2.setText("Please Wait");
					ConstructGraph3_or_4(ch,wb,pABP,pBU,pDEP,pTAP,pdABP,pdBU,pdDEP,pdTAP);
					txtfield2.setText("Graph 3 has been constructed.");
				}
				else
				{
					int ch=4;
					txtfield2.setText("Please Wait");
					ConstructGraph3_or_4(ch,wb,pABP,pBU,pDEP,pTAP,pdABP,pdBU,pdDEP,pdTAP);
					txtfield2.setText("Graph 4 has been constructed.");
				}
			}
			if(src==b5||src==b6)
			{
				int process[][]=new int[10][4];
				int product[][]=new int[10][4];
				String pname[]= {"SMC", "IM", "FAM", "CCM", "RM", "ENV", "IFA", "AGGLO", "RC/", "RC-PCAC"};
				String pdname[]= {"PROD", "PA", "MCJ", "MC/", "MWJ", "MMPD", "SE", "NDTS", "RA-PROD", "CP"};
				
				String s=txtfield3.getText();
				int ch=Integer.parseInt(s);
				for(int i=0;i<10;i++)
				{
					process[i][0]=0;
					process[i][1]=0;
					process[i][2]=0;
					process[i][3]=0;
					
					
						XSSFSheet sheet=wb.getSheetAt(ch-1);
						process[i][0]+=project_search(sheet,"ABP",pname[i]);
						process[i][1]+=project_search(sheet,"BU",pname[i]);
						process[i][2]+=project_search(sheet,"DEP",pname[i]);
						process[i][3]+=project_search(sheet,"TAP",pname[i]);
					
				}
				for(int i=0;i<10;i++)
				{
					product[i][0]=0;
					product[i][1]=0;
					product[i][2]=0;
					product[i][3]=0;
		
						XSSFSheet sheet=wb.getSheetAt(ch-1);
						product[i][0]+=project_search(sheet,"ABP",pdname[i]);
						product[i][1]+=project_search(sheet,"BU",pdname[i]);
						product[i][2]+=project_search(sheet,"DEP",pdname[i]);
						product[i][3]+=project_search(sheet,"TAP",pdname[i]);
					
				}
				
				if(src==b5)
				{
					ConstructGraph5_or_6(wb,process,pname,5,ch-1); 
					txtfield2.setText("Graph 5 for sheet:"+wb.getSheetName(ch-1)+" has been constructed.");
				}
				if(src==b6)
				{
					ConstructGraph5_or_6(wb,product,pdname,6,ch-1); 
					txtfield2.setText("Graph 6 for sheet:"+wb.getSheetName(ch-1)+" has been constructed.");
				}
			}
			
		}
		
		catch(Exception f)
		{
			f.printStackTrace();
		}
	}
	
	


	


	


	private int project_search(XSSFSheet sheet, String string, String string2) {
		// TODO Auto-generated method stub
		int count=0;
		for(Row row:sheet)
			for(Cell cell:row)
			{
				switch(cell.getCellType())
				{
				case STRING:
					String s=cell.getStringCellValue();
					if(s.contains(string2) && s.contains(string))
					{
						if(string2.equals("MC/"))
							{if(!s.contains("SMC"))
								count++;}
						else	
							count++;
					}
					break;
				}
				break;
			}
		return count;
	}



	private int product_search(XSSFSheet sheet, String string) {
		// TODO Auto-generated method stub
		int count=0;
		for(Row row:sheet)
			for(Cell cell:row)
			{
				switch(cell.getCellType())
				{
				case STRING:
					String s=cell.getStringCellValue();
					if(s.contains(string) && (s.contains("PROD")||s.contains("PA")||s.contains("MCJ")||(s.contains("MC/")&& !s.contains("SMC"))||s.contains("MWJ")||s.contains("MMPD")||s.contains("SE")||
							s.contains("NDTS")||s.contains("RA-PROD")||s.contains("CP")))
						count++;
					break;
				}
				break;
			}
		return count;
	}


	private int process_search(XSSFSheet sheet, String string) {
		// TODO Auto-generated method stub
		int count=0;
		for(Row row:sheet)
			for(Cell cell:row)
			{
				switch(cell.getCellType())
				{
				case STRING:
					String s=cell.getStringCellValue();
					if(s.contains(string) && (s.contains("SMC")||s.contains("IM")||s.contains("FAM")||s.contains("CCM")||s.contains("RM")||s.contains("ENV")||s.contains("IFA")||
							s.contains("AGGLO")||s.contains("RC/")||s.contains("RC-PCAC")))
						count++;
					break;
				}
				break;
			}			
		return count;
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

	
	private static void ConstructGraph1(XSSFWorkbook wb, int[] ABP, int[] BU, int[] DEP, int[] TAP) throws IOException {
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
			File file=new File("Graph 1.jpeg");
			ChartUtilities.saveChartAsJPEG(file, chart, width, height);
		}
	
	private static void ConstructGraph2(XSSFWorkbook wb, int[] ABP, int[] BU, int[] DEP, int[] TAP) throws IOException {
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
		File file=new File("Graph 2.jpeg");
		ChartUtilities.saveChartAsJPEG(file, chart, width, height);
		
	}

	

	private void ConstructGraph3_or_4(int ch, XSSFWorkbook wb, int[] pABP, int[] pBU, int[] pDEP, int[] pTAP,
			int[] pdABP, int[] pdBU, int[] pdDEP, int[] pdTAP) throws IOException {
		// TODO Auto-generated method stub
		
		if (ch==3)
		{
			String abp="ABP",bu="BU",dep="DEP",tap="TAP";
			DefaultCategoryDataset dataset=new DefaultCategoryDataset();
			dataset.addValue(pABP[0],"Process",abp);
			dataset.addValue(pBU[0],"Process",bu);
			dataset.addValue(pDEP[0], "Process",dep);
			dataset.addValue(pTAP[0],"Process",tap);
			
			dataset.addValue(pdABP[0],"Product",abp);
			dataset.addValue(pdBU[0],"Product",bu);
			dataset.addValue(pdDEP[0],"Product",dep);
			dataset.addValue(pdTAP[0],"Product",tap);
			
			JFreeChart chart =ChartFactory.createBarChart3D("", "Started in FY-19", "Number of Projects", dataset,PlotOrientation.VERTICAL,true,true,false);
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
			File file=new File("Graph 3.jpeg");
			ChartUtilities.saveChartAsJPEG(file, chart, width, height);
		}
		else if(ch==4)
		{
			String abp="ABP",bu="BU",dep="DEP",tap="TAP";
			DefaultCategoryDataset dataset=new DefaultCategoryDataset();
			dataset.addValue(pABP[1],"Process",abp);
			dataset.addValue(pBU[1],"Process",bu);
			dataset.addValue(pDEP[1], "Process",dep);
			dataset.addValue(pTAP[1], "Process",tap);
			
			dataset.addValue(pdABP[1],"Product",abp);
			dataset.addValue(pdBU[1],"Product",bu);
			dataset.addValue(pdDEP[1],"Product",dep);
			dataset.addValue(pdTAP[1],"Product",tap);
			
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
			File file=new File("Graph 4.jpeg");
			ChartUtilities.saveChartAsJPEG(file, chart, width, height);	
		}		

	}
	
	private void ConstructGraph5_or_6(XSSFWorkbook wb, int[][] data,String[] dname,int ch,int sheetno) throws IOException {
		// TODO Auto-generated method stub
		String abp="ABP",bu="BU",dep="DEP",tap="TAP";
		int total=0;
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(int i=0;i<10;i++)
		{
			dataset.addValue(data[i][0],abp,dname[i]);
			dataset.addValue(data[i][1],bu,dname[i]);
			dataset.addValue(data[i][2],dep,dname[i]);
			dataset.addValue(data[i][3], tap,dname[i]);
			total+=data[i][0]+data[i][1]+data[i][2]+data[i][3];
		}
		
		if(ch==5)
		{
			JFreeChart chart =ChartFactory.createStackedBarChart3D("Process Area (Total-"+total+")", wb.getSheetName(sheetno), "Number of Projects", dataset,PlotOrientation.VERTICAL,true,true,false);
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
			File file=new File("Graph 5 for"+wb.getSheetName(sheetno)+".jpeg");
			ChartUtilities.saveChartAsJPEG(file, chart, width, height);
		}
		
		else
		{
			JFreeChart chart =ChartFactory.createStackedBarChart3D("Product Area (Total-"+total+")", wb.getSheetName(sheetno), "Number of Projects", dataset,PlotOrientation.VERTICAL,true,true,false);
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
			File file=new File("Graph 6 for"+wb.getSheetName(sheetno)+".jpeg");
			ChartUtilities.saveChartAsJPEG(file, chart, width, height);
		}
		
	}

}
