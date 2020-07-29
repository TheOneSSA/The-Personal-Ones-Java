package test;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		String fiat="FIAT",audi="AUDI",bmw="BMW",speed="Speed",mileage="Mileage",safety="Safety",user="User Rating";
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		dataset.addValue(1, speed,fiat);
		dataset.addValue(3,mileage,fiat);
		dataset.addValue(2, user, fiat);
		dataset.addValue(5, safety, fiat);
		
		dataset.addValue(4, speed,audi);
		dataset.addValue(3,mileage,audi);
		dataset.addValue(5, user, audi);
		dataset.addValue(6, safety, audi);
		
		dataset.addValue(5, speed,bmw);
		dataset.addValue(5,mileage,bmw);
		dataset.addValue(9, user, bmw);
		dataset.addValue(8, safety, bmw);
		
		JFreeChart barchart= ChartFactory.createBarChart("Car Statistics", "Category", "Ratings", dataset,PlotOrientation.VERTICAL,true,true,false);
		
		CategoryPlot plot = barchart.getCategoryPlot();
		BarRenderer br=(BarRenderer)plot.getRenderer();
		br.setItemMargin(0);
		
		int width =640,height=480;
		File file=new File("D:\\BarChart.jpeg");
		ChartUtilities.saveChartAsJPEG(file, barchart, width, height);
		

	}

}
