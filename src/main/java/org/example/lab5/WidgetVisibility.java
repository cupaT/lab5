package org.example.lab5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WidgetVisibility extends Application {

    @Override
    public void start(Stage stage) {
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");
        Button button3 = new Button("Button 3");

        CheckBox checkBox1 = new CheckBox("Show Button 1");
        CheckBox checkBox2 = new CheckBox("Show Button 2");
        CheckBox checkBox3 = new CheckBox("Show Button 3");

        checkBox1.setSelected(true);
        checkBox1.setOnAction(e -> button1.setVisible(checkBox1.isSelected()));
        checkBox2.setSelected(true);
        checkBox2.setOnAction(e -> button2.setVisible(checkBox2.isSelected()));
        checkBox3.setSelected(true);
        checkBox3.setOnAction(e -> button3.setVisible(checkBox3.isSelected()));

        VBox root = new VBox(10, checkBox1, button1, checkBox2, button2, checkBox3, button3);
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.setTitle("Widget Visibility");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

