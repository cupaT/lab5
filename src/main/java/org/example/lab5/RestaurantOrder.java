package org.example.lab5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RestaurantOrder extends Application {

    @Override
    public void start(Stage stage) {
        CheckBox dish1 = new CheckBox("Pizza (10$)");
        TextField food1 = new TextField("1");

        CheckBox dish2 = new CheckBox("Burger (5$)");
        TextField food2 = new TextField("1");

        CheckBox dish3 = new CheckBox("Pasta (7$)");
        TextField food3 = new TextField("1");

        Button calculateButton = new Button("Calculate Total");
        calculateButton.setOnAction(e -> showOrderSummary(stage, dish1, food1, dish2, food2, dish3, food3));

        VBox root = new VBox(10, dish1, food1, dish2, food2, dish3, food3, calculateButton);
        Scene scene = new Scene(root, 300, 250);
        stage.setScene(scene);
        stage.setTitle("Restaurant Order");
        stage.show();
    }

    private void showOrderSummary(Stage owner, CheckBox dish1, TextField food1, CheckBox dish2, TextField food2, CheckBox dish3, TextField food3) {
        Stage summaryStage = new Stage();
        summaryStage.initModality(Modality.WINDOW_MODAL);
        summaryStage.initOwner(owner);

        VBox summaryBox = new VBox(10);

        double total = 0;
        StringBuilder summaryText = new StringBuilder();

        if (dish1.isSelected()) {
            int food = Integer.parseInt(food1.getText());
            double price = food * 10;
            total += price;
            summaryText.append("Pizza: ").append(food).append(" x 10$ = ").append(price).append("$\n");
        }

        if (dish2.isSelected()) {
            int food = Integer.parseInt(food2.getText());
            double price = food * 5;
            total += price;
            summaryText.append("Burger: ").append(food).append(" x 5$ = ").append(price).append("$\n");
        }

        if (dish3.isSelected()) {
            int food = Integer.parseInt(food3.getText());
            double price = food * 7;
            total += price;
            summaryText.append("Pasta: ").append(food).append(" x 7$ = ").append(price).append("$\n");
        }

        summaryText.append("\nTotal: ").append(total).append("$");

        Label summaryLabel = new Label(summaryText.toString());
        summaryBox.getChildren().add(summaryLabel);

        Scene summaryScene = new Scene(summaryBox, 300, 200);
        summaryStage.setScene(summaryScene);
        summaryStage.setTitle("Order Summary");
        summaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

