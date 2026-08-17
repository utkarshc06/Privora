package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class RequestDetails {

    public Scene getScene() {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:#061126;"
        );

        XeroxSideBar sideBar =
                new XeroxSideBar(
                        "RequestDetails"
                );

        root.setLeft(
                sideBar.getSideBar()
        );

        VBox main =
                new VBox(20);

        main.setPadding(
                new Insets(32)
        );

        Label heading =
                new Label(
                        "Request Details"
                );

        heading.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:32px;" +
                "-fx-font-weight:bold;"
        );

        Label subtitle =
                new Label(
                        "View details of a document request."
                );

        subtitle.setStyle(
                "-fx-text-fill:#8C9BB0;"
        );

        VBox document =
                createBox(
                        "Document Information",
                        "Document",
                        "Purpose",
                        "Customer",
                        "Uploaded"
                );

        VBox privacy =
                createBox(
                        "Privacy Rules",
                        "Print Limit",
                        "Expiry",
                        "Download",
                        "Copy / Forward"
                );

        main.getChildren().addAll(
                heading,
                subtitle,
                document,
                privacy
        );

        root.setCenter(main);

        return new Scene(
                root,
                1300,
                750
        );
    }

    private VBox createBox(
            String title,
            String... items) {

        VBox box =
                new VBox(15);

        box.setPadding(
                new Insets(22)
        );

        box.setStyle(
                "-fx-background-color:#0B192D;" +
                "-fx-background-radius:18;" +
                "-fx-border-color:#22354F;" +
                "-fx-border-radius:18;"
        );

        Label heading =
                new Label(title);

        heading.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:19px;" +
                "-fx-font-weight:bold;"
        );

        box.getChildren().add(
                heading
        );

        for (String item : items) {

            Label label =
                    new Label(item);

            label.setStyle(
                    "-fx-text-fill:#8C9BB0;"
            );

            box.getChildren().add(
                    label
            );
        }

        return box;
    }
}