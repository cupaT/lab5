package org.example.lab5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculator extends Application {

    @Override
    public void start(Stage stage) {
        TextField num1 = new TextField();
        TextField num2 = new TextField();
        Label resultLabel = new Label();
        Button addButton = new Button("Add (+)");
        Button subButton = new Button("Subtract (-)");
        Button mulButton = new Button("Multiply (*)");
        Button divButton = new Button("Divide (/)");

        addButton.setOnAction(e -> calculate(num1, num2, resultLabel, "+"));
        subButton.setOnAction(e -> calculate(num1, num2, resultLabel, "-"));
        mulButton.setOnAction(e -> calculate(num1, num2, resultLabel, "*"));
        divButton.setOnAction(e -> calculate(num1, num2, resultLabel, "/"));

        VBox root = new VBox(10, num1, num2, addButton, subButton, mulButton, divButton, resultLabel);
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Calculator");
        stage.show();
    }

    private void calculate(TextField num1, TextField num2, Label resultLabel, String operator) {
        try {
            double number1 = Double.parseDouble(num1.getText());
            double number2 = Double.parseDouble(num2.getText());
            double result = 0;

            switch (operator) {
                case "+" -> result = number1 + number2;
                case "-" -> result = number1 - number2;
                case "*" -> result = number1 * number2;
                case "/" -> {
                    if (number2 == 0) {
                        resultLabel.setText("Error: Division by 0");
                        return;
                    }
                    result = number1 / number2;
                }
            }
            resultLabel.setText("Result: " + result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Error: Invalid input");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

