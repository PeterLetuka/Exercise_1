package com.example.exercise_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private Pane topPane, middlePane, bottomPane;

    @Override
    public void start(Stage primaryStage) {
        Button btnGermany = createCountryButton("Germany", Color.BLACK, Color.RED, Color.YELLOW);
        Button btnItaly = createCountryButton("Italy", Color.GREEN, Color.WHITE, Color.RED);
        Button btnJapan = createCountryButton("Japan", Color.WHITE, Color.RED, Color.WHITE);

        initializePanes();

        HBox buttonBox = new HBox(10, btnGermany, btnItaly, btnJapan);
        VBox layout = new VBox(10, buttonBox, topPane, middlePane, bottomPane);
        Scene scene = new Scene(layout, 320, 150);

        setupStage(primaryStage, scene);
    }

    private Button createCountryButton(String countryName, Color topColor, Color middleColor, Color bottomColor) {
        Button button = new Button(countryName);
        button.setOnAction(event -> updateFlagDisplay(countryName, topColor, middleColor, bottomColor));
        return button;
    }

    private void updateFlagDisplay(String countryName, Color topColor, Color middleColor, Color bottomColor) {
        System.out.println("Selected: " + countryName);
        setPaneBackground(topPane, topColor);
        setPaneBackground(middlePane, middleColor);
        setPaneBackground(bottomPane, bottomColor);
    }

    private void setPaneBackground(Pane pane, Color color) {
        pane.setBackground(new Background(new BackgroundFill(color, null, null)));
    }

    private void initializePanes() {
        topPane = new Pane();
        middlePane = new Pane();
        bottomPane = new Pane();
        setPaneSize(topPane, 100, 30);
        setPaneSize(middlePane, 100, 30);
        setPaneSize(bottomPane, 100, 30);
    }

    private void setPaneSize(Pane pane, double width, double height) {
        pane.setPrefSize(width, height);
    }

    private void setupStage(Stage stage, Scene scene) {
        stage.setScene(scene);
        stage.setTitle("Flag Display");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}