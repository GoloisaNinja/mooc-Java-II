package application;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PartiesApplication extends Application {
    Map<String, Map<Integer, Double>> values = read("partiesdata.tsv");
    @Override
    public void start(Stage stage) {
        // create the x and y axis that the chart will use
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        // set the title for the axis
        xAxis.setLabel("Years");
        yAxis.setLabel("Relative support (%)");
        // create the line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        // set the title of the chart
        lineChart.setTitle("Relative support in the years 1968-2008");
        // go through the parties and add them to the chart
        values.keySet().stream().forEach(party -> {
            // create a different data set for each party
            XYChart.Series data = new XYChart.Series<>();
            data.setName(party);
            // add the party's support numbers
            values.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });
            lineChart.getData().add(data);
        });
        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }
    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }
    public static Map<String, Map<Integer, Double>> read(String file) {
        Map<String, Map<Integer, Double>> partyData = new HashMap<>();
        List<Integer> years = new ArrayList<>(Arrays.asList(1968, 1972, 1976, 1980, 1984, 1988, 1992, 1996, 2000,
                                                            2004, 2008));
        try {
            Files.lines(Paths.get(file)).map(row -> row.split("\t")).
                    filter(chunk -> !chunk[0].equals("Party")).
                    forEach(partyLine -> {
                        Map<Integer, Double> datapoints = new HashMap<>();
                        int start = 1;
                        int entries = partyLine.length;
                        String partyKey = partyLine[0];
                        while(start < entries) {
                            if (!partyLine[start].equals("-")) {
                                int yearIndex = start - 1;
                                int year = years.get(yearIndex);
                                double votePer = Double.parseDouble(partyLine[start]);
                                datapoints.put(year, votePer);
                            }
                            start++;
                        }
                        partyData.put(partyKey, datapoints);
                    });
            return partyData;
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
