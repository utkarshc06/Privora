package com.finalproj.view.user;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class PurposePage {

    private Scene purposeScene;

    public Scene getPurposeScene(Runnable backToDashboard) {

        StackPane root = new StackPane();

        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #020713, #06152D, #020713);"
        );

        Label title = new Label("Purpose");

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );

        StackPane.setAlignment(title, Pos.CENTER);

        root.getChildren().add(title);

        purposeScene = new Scene(root, 1300, 700);

        return purposeScene;
    }
}