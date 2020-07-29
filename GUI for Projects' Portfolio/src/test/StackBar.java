package test;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

import org.jfree.data.general.DatasetUtilities;

public class StackBar {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		double[][] data=new double[][] {{200,120,300,140},{150,450,40,200},{20,30,50,45}};
		CategoryDataset dataset=DatasetUtilities.createCategoryDataset("Team","Match",data);
		JFreeChart stackBar=ChartFactory.createStackedBarChart("Stacked Bar Chart", "Matches", "Score", dataset, PlotOrientation.VERTICAL, true,true,false);
		int width=640;
		int height=480;
		File file=new File("StackedBarChart.jpeg");
		ChartUtilities.saveChartAsJPEG(file, stackBar, width, height);

	}

}
