package test;

import java.awt.Color;
import java.text.DecimalFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;



public class StackedBarChart extends ApplicationFrame {
	
	public StackedBarChart(String title)
	{
		super(title);
		final CategoryDataset dataset=createDataset();
		final JFreeChart chart=createChart(dataset);
		final ChartPanel chartPanel=new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500,350));
		setContentPane(chartPanel);		
	}

	private JFreeChart createChart(final CategoryDataset dataset) {
		// TODO Auto-generated method stub
		final JFreeChart stackchart=ChartFactory.createStackedBarChart("Stacked BarChart","Matches","Score",dataset,PlotOrientation.VERTICAL,true,true,false);
		stackchart.setBackgroundPaint(new Color(249,231,236));
		CategoryPlot plot=stackchart.getCategoryPlot();
		plot.getRenderer().setSeriesPaint(0,new Color(128,0,0));
		plot.getRenderer().setSeriesPaint(0, new Color(0,0,225));
		BarRenderer ren = (BarRenderer)plot.getRenderer();
		DecimalFormat dec=new DecimalFormat("#");

		CategoryItemRenderer renderer = ((CategoryPlot)stackchart.getPlot()).getRenderer();

        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelsVisible(true);
        ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, 
                TextAnchor.TOP_CENTER);
        renderer.setBasePositiveItemLabelPosition(position);

		return stackchart;
	}

	private CategoryDataset createDataset() {
		// TODO Auto-generated method stub
		double[][] data=new double[][] {{210,300,320,260},{160,200,240,500}};
		
		return DatasetUtilities.createCategoryDataset("Team", "Match",data);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackedBarChart demo =new StackedBarChart("Stacked Bar Chart");
		demo.pack();
		RefineryUtilities.centerFrameOnScreen(demo);
		demo.setVisible(true);
	}

}
