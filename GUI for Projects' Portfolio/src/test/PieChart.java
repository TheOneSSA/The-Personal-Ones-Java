package test;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PieChart {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DefaultPieDataset dataset =new DefaultPieDataset();
		dataset.setValue("IPhone7s",20);
		dataset.setValue("Samsung",20);
		dataset.setValue("Xiomi", 40);
		dataset.setValue("Nokia", 10);
		
		JFreeChart chart= ChartFactory.createPieChart("Mobile Sales",dataset, true, true, false);
		int width=640;
		int height=480;
		File piechart=new File("PieChart.jpeg");
		ChartUtilities.saveChartAsJPEG(piechart, chart, width, height);

	}

}
