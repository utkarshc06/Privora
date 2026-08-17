package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SecureViewer {

    public Scene getScene() {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:#061126;"
        );

        XeroxSideBar sideBar =
                new XeroxSideBar(
                        "SecureViewer"
                );

        root.setLeft(
                sideBar.getSideBar()
        );

        VBox main =
                new VBox(18);

        main.setPadding(
                new Insets(32)
        );

        Label heading =
                new Label(
                        "Secure Viewer"
                );

        heading.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:32px;" +
                "-fx-font-weight:bold;"
        );

        Label subtitle =
                new Label(
                        "Read-only, watermarked document view."
                );

        subtitle.setStyle(
                "-fx-text-fill:#8C9BB0;"
        );

        // Restrictions

        HBox restrictions =
                new HBox(25);

        restrictions.setPadding(
                new Insets(18)
        );

        restrictions.setStyle(
                "-fx-background-color:#170F19;" +
                "-fx-background-radius:15;" +
                "-fx-border-color:#6B2630;" +
                "-fx-border-radius:15;"
        );

        Label active =
                new Label(
                        "Restrictions Active"
                );

        Label download =
                new Label(
                        "Download Disabled"
                );

        Label copy =
                new Label(
                        "Copy Disabled"
                );

        active.setStyle(
                "-fx-text-fill:#FF5555;"
        );

        download.setStyle(
                "-fx-text-fill:#FF8888;"
        );

        copy.setStyle(
                "-fx-text-fill:#FF8888;"
        );

        restrictions.getChildren().addAll(
                active,
                download,
                copy
        );

        // Document

        VBox document =
                new VBox();

        document.setAlignment(
                Pos.CENTER
        );

        document.setPrefHeight(350);

        document.setStyle(
                "-fx-background-color:#111C2D;" +
                "-fx-background-radius:18;" +
                "-fx-border-color:#22354F;" +
                "-fx-border-radius:18;"
        );

        Label documentText =
                new Label(
                        "SECURE DOCUMENT\n\n" +
                        "READ ONLY VIEW"
                );

        documentText.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:20px;"
        );

        document.getChildren().add(
                documentText
        );

        // Controls

        HBox controls =
                new HBox(15);

        Button print =
                new Button("Print");

        Button approval =
                new Button("Request Approval");

        Button close =
                new Button("Close Session");

        print.setStyle(
                "-fx-background-color:#2196F3;" +
                "-fx-text-fill:white;"
        );

        approval.setStyle(
                "-fx-background-color:#0B192D;" +
                "-fx-text-fill:white;"
        );

        close.setStyle(
                "-fx-background-color:#30141A;" +
                "-fx-text-fill:#FF5555;"
        );

        controls.getChildren().addAll(
                print,
                approval,
                close
        );

        main.getChildren().addAll(
                heading,
                subtitle,
                restrictions,
                document,
                controls
        );

        root.setCenter(main);

        return new Scene(
                root,
                1300,
                750
        );
    }
}