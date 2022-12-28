package application;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {
    Savings savings = new Savings();
    Chart chart = new Chart();
    @Override
    public void start(Stage stage) {
        BorderPane base = new BorderPane();
        base.setPrefSize(600, 480);
        chart.buildLineChart(savings);
        UserInterface ui = new UserInterface(savings, chart);
        Parent uiSliders = ui.getView();
        base.setTop(uiSliders);
        Parent chartView = chart.getChartView();
        base.setCenter(chartView);
        Scene view = new Scene(base);
        stage.setScene(view);
        stage.show();

    }
    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

}
