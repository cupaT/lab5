package org.example.lab5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FlagApp extends Application {

    @Override
    public void start(Stage stage) {
        ToggleGroup group1 = new ToggleGroup();
        RadioButton red1 = new RadioButton("Red");
        RadioButton blue1 = new RadioButton("Blue");
        RadioButton green1 = new RadioButton("Green");
        red1.setToggleGroup(group1);
        blue1.setToggleGroup(group1);
        green1.setToggleGroup(group1);

        ToggleGroup group2 = new ToggleGroup();
        RadioButton red2 = new RadioButton("Red");
        RadioButton blue2 = new RadioButton("Blue");
        RadioButton green2 = new RadioButton("Green");
        red2.setToggleGroup(group2);
        blue2.setToggleGroup(group2);
        green2.setToggleGroup(group2);

        ToggleGroup group3 = new ToggleGroup();
        RadioButton red3 = new RadioButton("Red");
        RadioButton blue3 = new RadioButton("Blue");
        RadioButton green3 = new RadioButton("Green");
        red3.setToggleGroup(group3);
        blue3.setToggleGroup(group3);
        green3.setToggleGroup(group3);

        Button drawButton = new Button("Draw Flag");
        Label resultLabel = new Label();

        drawButton.setOnAction(e -> {
            String color1 = getSelectedColor(group1);
            String color2 = getSelectedColor(group2);
            String color3 = getSelectedColor(group3);

            if (color1 == null || color2 == null || color3 == null) {
                resultLabel.setText("Please select a color for each stripe.");
            } else {
                resultLabel.setText("Flag colors: " + color1 + ", " + color2 + ", " + color3);
            }
        });

        VBox root = new VBox(10, red1, blue1, green1, red2, blue2, green2, red3, blue3, green3, drawButton, resultLabel);
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Flag App");
        stage.setResizable(false);
        stage.show();
    }

    private String getSelectedColor(ToggleGroup group) {
        if (group.getSelectedToggle() != null) {
            return ((RadioButton) group.getSelectedToggle()).getText();
        } else {
            return null;  // Возвращаем null, если не выбрана ни одна опция
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
