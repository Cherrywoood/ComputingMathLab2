package drawingGraph;

import functions.Function;
import functions.SystemOfFunction;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public class FunctionGraph {
    private final int number;

    public FunctionGraph(int number) {
        this.number = number;
    }

    public void drawGraphFunction(String fStr) {
        final XYSeries series1 = new XYSeries(fStr);
        for (double x = - 50; x <= 50; x += 0.1) {
             series1.add(x, Function.getFunctionValue(number,x));
        }

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);


        final JFreeChart chart = ChartFactory.createXYLineChart(
                "Function Graph",
                "X",                        // x axis label
                "Y",                        // y axis label
                null,                        // data
                PlotOrientation.VERTICAL,
                true,                        // include legend
                false,                       // tooltips
                false                        // urls
        );



        final XYPlot plot = chart.getXYPlot();
        plot.getDomainAxis().setRange(-5, 5);
        plot.getRangeAxis().setRange(-5, 5);
        plot.setDomainZeroBaselineVisible(true);
        plot.setRangeZeroBaselineVisible(true);

        plot.setDataset(0, dataset);

        JFrame jf = new JFrame();
        jf.setContentPane(new ChartPanel(chart));
        jf.pack();
        jf.setVisible(true);
    }


    public void drawGraphSystem(String f1, String f2) {

        List<XYSeries> series = new ArrayList<>(4);
        series.add(new XYSeries(f1));
        series.add(new XYSeries(f2));

            for (double x = - 50; x < 50; x += 0.1) {
                series.get(0).add(x, SystemOfFunction.getFunction(number,x)[0]);
                series.get(1).add(x, SystemOfFunction.getFunction(number,x)[1]);
            }


        XYSeriesCollection dataset = new XYSeriesCollection();

        for (XYSeries s: series) {
            dataset.addSeries(s);
        }

        final JFreeChart chart = ChartFactory.createXYLineChart(
                "System Graph",
                "X1",                        // x axis label
                "X2",                        // y axis label
                null,                        // data
                PlotOrientation.VERTICAL,
                true,                        // include legend
                false,                       // tooltips
                false                        // urls
        );

        final XYPlot plot = chart.getXYPlot();

        plot.getDomainAxis().setRange(-5, 5);
        plot.getRangeAxis().setRange(-5, 5);
        plot.setDomainZeroBaselineVisible(true);
        plot.setRangeZeroBaselineVisible(true);

        XYSplineRenderer r = new XYSplineRenderer();
        r.setSeriesShapesVisible(0, false);
        r.setSeriesShapesVisible(1, false);
        r.setSeriesLinesVisible(0, true);
        r.setSeriesLinesVisible(1, true);

        r.setSeriesPaint(0, Color.RED);
        r.setSeriesPaint(1, Color.BLUE);

        plot.setDataset(0, dataset);
        plot.setRenderer(r);

        JFrame jf = new JFrame();
        jf.setContentPane(new ChartPanel(chart));
        jf.pack();
        jf.setVisible(true);
    }
}
