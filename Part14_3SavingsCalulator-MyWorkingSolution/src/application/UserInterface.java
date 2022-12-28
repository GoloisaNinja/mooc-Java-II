package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Formatter;

public class UserInterface {
    private Savings savings;
    private Chart chart;
    public UserInterface(Savings savings, Chart chart) {
        this.savings = savings;
        this.chart = chart;
    }
    public Parent getView() {
        VBox uiContainer = new VBox();
        uiContainer.setMinWidth(600);
        Parent savingsSlider = getSavingsSlider();
        Parent interestSlider = getInterestSlider();
        uiContainer.getChildren().add(savingsSlider);
        uiContainer.getChildren().add(interestSlider);
        return uiContainer;
    }
    private Parent getSavingsSlider() {
        BorderPane savingsLayout = new BorderPane();
        savingsLayout.setPrefWidth(600);
        HBox container = new HBox();
        container.setPrefWidth(600);
        container.setAlignment(Pos.CENTER);
        container.setSpacing(15);
        Label text = new Label("Monthly savings");
        Slider savingsSlider = new Slider(25, 250, 25);
        savingsSlider.setMinWidth(400);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setMajorTickUnit(25);
        savingsSlider.setBlockIncrement(25);
        Label amount = new Label(Double.toString(this.savings.getSavingsAmount()));
        container.getChildren().addAll(text, savingsSlider, amount);
        container.setPadding(new Insets(20, 20, 20, 20));
        savingsLayout.setCenter(container);
        savingsSlider.setOnMouseClicked(event -> {
            Formatter formatter = new Formatter();
            amount.setText(formatter.format("%.2f", savingsSlider.getValue()).toString());
            savings.setSavingsAmount(savingsSlider.getValue());
            this.recalculateAndBuild();
        });
        return savingsLayout;
    }

    private Parent getInterestSlider() {
        BorderPane interestLayout = new BorderPane();
        interestLayout.setPrefWidth(600);
        HBox container = new HBox();
        container.setPrefWidth(600);
        container.setAlignment(Pos.CENTER);
        container.setSpacing(15);
        Label rateText = new Label("Interest rate");
        Slider interestRateSlider = new Slider(0, 10, 0);
        interestRateSlider.setMinWidth(400);
        interestRateSlider.setBlockIncrement(0.5);
        interestRateSlider.setShowTickMarks(true);
        interestRateSlider.setShowTickLabels(true);
        interestRateSlider.setMajorTickUnit(10);
        Label rate = new Label(Double.toString(this.savings.getInterestRate()));
        container.getChildren().addAll(rateText, interestRateSlider, rate);
        container.setPadding(new Insets(20, 20, 20, 20));
        interestLayout.setCenter(container);
        interestRateSlider.setOnMouseClicked(event -> {
            Formatter formatter = new Formatter();
            rate.setText(formatter.format("%.2f", interestRateSlider.getValue()).toString());
            savings.setInterestRate(interestRateSlider.getValue());
            this.recalculateAndBuild();
        });
        return interestLayout;
    }
    private void recalculateAndBuild() {
        savings.calculateSavings();
        savings.calculateSavingsWithInterest();
        chart.buildLineChart(savings);
    }
}
