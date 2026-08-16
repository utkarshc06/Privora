package com.finalproj.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PrivacyReceipt {

    private Scene privacyReceiptScene;

    public Scene getPrivacyReceiptScene(Runnable backToDashboard) {

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #020713, #06152D, #020713);"
        );

        // =========================================================
        // TOP BAR
        // =========================================================

        HBox topBar = new HBox();

        topBar.setPadding(
                new Insets(15, 28, 15, 28)
        );

        topBar.setAlignment(
                Pos.CENTER_LEFT
        );

        Label logo = new Label("PRIVORA");

        logo.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );

        Label pageTitle = new Label(
                "  /  Privacy Receipt"
        );

        pageTitle.setStyle(
                "-fx-text-fill: #7E8DA3;" +
                "-fx-font-size: 13px;"
        );

        HBox titleBox = new HBox(
                5,
                logo,
                pageTitle
        );

        titleBox.setAlignment(
                Pos.CENTER_LEFT
        );

        // =========================================================
        // BACK BUTTON
        // =========================================================

        Button backButton = new Button(
                "← Dashboard"
        );

        backButton.setStyle(
                "-fx-background-color: #0B162A;" +
                "-fx-border-color: #263653;" +
                "-fx-border-radius: 15;" +
                "-fx-background-radius: 15;" +
                "-fx-text-fill: #B8C5D6;" +
                "-fx-padding: 8 16 8 16;"
        );

        backButton.setOnAction(e -> {
            backToDashboard.run();
        });

        HBox.setHgrow(
                titleBox,
                Priority.ALWAYS
        );

        topBar.getChildren().addAll(
                titleBox,
                backButton
        );

        // =========================================================
        // MAIN CONTENT
        // =========================================================

        VBox content = new VBox();

        content.setAlignment(
                Pos.CENTER
        );

        Label privacyReceiptLabel = new Label(
                "Privacy Receipt"
        );

        privacyReceiptLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );

        content.getChildren().add(
                privacyReceiptLabel
        );

        // =========================================================
        // ROOT
        // =========================================================

        root.setTop(topBar);
        root.setCenter(content);

        // =========================================================
        // SCENE
        // =========================================================

        privacyReceiptScene = new Scene(
                root,
                1300,
                700
        );

        return privacyReceiptScene;
    }
}