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
import java.util.HashMap;
import java.util.Map;

public class ShanghaiApplication extends Application {
    // create a map from the file to use as a stream for data read
    // will not pass tests but wanted to include anyway
    // Map<Integer, Integer> records = read("helsinki.txt");
    @Override
    public void start(Stage stage) {
        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis(2007, 2017, 1);
        NumberAxis yAxis = new NumberAxis();

        // set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");


        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");

        // create the data set that is going to be added to the line chart
        XYChart.Series helsinkiData = new XYChart.Series();

        // and single points into the data set
        helsinkiData.getData().add(new XYChart.Data(2007, 73));
        helsinkiData.getData().add(new XYChart.Data(2008, 68));
        helsinkiData.getData().add(new XYChart.Data(2009, 72));
        helsinkiData.getData().add(new XYChart.Data(2010, 72));
        helsinkiData.getData().add(new XYChart.Data(2011, 74));
        helsinkiData.getData().add(new XYChart.Data(2012, 73));
        helsinkiData.getData().add(new XYChart.Data(2013, 76));
        helsinkiData.getData().add(new XYChart.Data(2014, 73));
        helsinkiData.getData().add(new XYChart.Data(2015, 67));
        helsinkiData.getData().add(new XYChart.Data(2016, 56));
        helsinkiData.getData().add(new XYChart.Data(2017, 56));


        // read in from file - will not pass test - but I wanted to include it
//        records.keySet().stream().forEach(key -> {
//            helsinkiData.getData().add(new XYChart.Data(key, records.get(key)));
//        });

        // add the data set to the line chart
        lineChart.getData().add(helsinkiData);


        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }
    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }
    // read function to put our txt file data into a map - wont pass tests
    // but i wanted to include it anyway
//    public static Map<Integer, Integer> read(String file) {
//        Map<Integer, Integer> data = new HashMap<>();
//        try {
//            Files.lines(Paths.get("helsinki.txt")).map(line -> line.split(" ")).forEach(year -> {
//                int recordYear = Integer.parseInt(year[0]);
//                int recordRank = Integer.parseInt((year[1]));
//                data.put(recordYear, recordRank);
//            });
//            return data;
//        }
//        catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

}
