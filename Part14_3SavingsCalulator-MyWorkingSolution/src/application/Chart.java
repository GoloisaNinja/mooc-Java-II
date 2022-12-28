package application;

import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.BorderPane;

import java.util.Map;

public class Chart {
    private LineChart<Number, Number> chart;
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    public Chart() {
        this.xAxis = new NumberAxis(0, 30, 1);
        this.yAxis = new NumberAxis();
        this.chart = new LineChart<>(xAxis, yAxis);
        this.chart.setTitle("Total savings");
        this.chart.setMinHeight(300);
        this.chart.setMinWidth(600);
    }
    public Parent getChartView() {
        BorderPane chartLayout = new BorderPane();
        chartLayout.setCenter(this.chart);
        return chartLayout;
    }
    public void buildLineChart(Savings savings) {
        Map<Integer, Double> savingsValues = savings.getSavingsOverTime();
        Map<Integer, Double> interestSavingsValues = savings.getSavingsWithInterestOverTime();

        XYChart.Series savingsData = new XYChart.Series();
        XYChart.Series interestData = new XYChart.Series();
        savingsData.setName("no interest");
        interestData.setName("with interest");
        savingsValues.keySet().stream().forEach(year -> {
            savingsData.getData().add(new XYChart.Data(year, savingsValues.get(year)));
        });

        interestSavingsValues.keySet().stream().forEach(year -> {
            interestData.getData().add(new XYChart.Data(year, interestSavingsValues.get(year)));
        });
        if (this.chart.getData().size() == 0) {
            this.chart.getData().add(savingsData);
            this.chart.getData().add(interestData);
        } else {
            this.chart.getData().set(0, savingsData);
            this.chart.getData().set(1, interestData);
        }
    }
}
