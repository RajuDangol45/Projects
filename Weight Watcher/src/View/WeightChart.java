package View;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class WeightChart{
    
    public JPanel getWeightChart(ArrayList<Double> weights){
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0;i<weights.size();i++){
            dataset.addValue(weights.get(i), "", ""+(i+1));
        }
        JFreeChart lineChart = ChartFactory.createLineChart("Daily Weight Record", "Days", "Weights", dataset,PlotOrientation.VERTICAL,true,true,false);
        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new Dimension(650,250));
        return chartPanel;
    }
    
}
