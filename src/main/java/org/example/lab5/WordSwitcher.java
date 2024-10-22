package org.example.lab5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WordSwitcher extends Application {
    private boolean isForward = true;

    @Override
    public void start(Stage stage) {
        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        Button switchButton = new Button("->");
        textField2.setEditable(false);


        switchButton.setOnAction(e -> {
            if (isForward) {
                textField2.setText(textField1.getText());
                textField1.clear();
                switchButton.setText("<-");
                textField1.setEditable(false);
                textField2.setEditable(true);

            } else {
                textField1.setText(textField2.getText());
                textField2.clear();
                switchButton.setText("->");
                textField2.setEditable(false);
                textField1.setEditable(true);
            }
            isForward = !isForward;
        });

        HBox root = new HBox(10, textField1, switchButton, textField2);
        Scene scene = new Scene(root, 400, 100);
        stage.setScene(scene);
        stage.setTitle("Word Switcher");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
