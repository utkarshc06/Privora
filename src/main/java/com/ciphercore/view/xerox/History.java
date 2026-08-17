package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class History {

    public Scene getScene() {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:#061126;"
        );

        XeroxSideBar sideBar =
                new XeroxSideBar(
                        "History"
                );

        root.setLeft(
                sideBar.getSideBar()
        );

        VBox main =
                new VBox(22);

        main.setPadding(
                new Insets(32)
        );

        Label heading =
                new Label("History");

        heading.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:32px;" +
                "-fx-font-weight:bold;"
        );

        Label subtitle =
                new Label(
                        "Complete history of document activity."
                );

        subtitle.setStyle(
                "-fx-text-fill:#8C9BB0;"
        );

        VBox table =
                new VBox();

        table.setPadding(
                new Insets(22)
        );

        table.setStyle(
                "-fx-background-color:#0B192D;" +
                "-fx-background-radius:18;" +
                "-fx-border-color:#22354F;" +
                "-fx-border-radius:18;"
        );

        GridPane header =
                new GridPane();

        header.setHgap(110);

        String[] titles = {
                "EVENT",
                "DOCUMENT",
                "DATE",
                "STATUS"
        };

        for (int i = 0; i < titles.length; i++) {

            Label label =
                    new Label(titles[i]);

            label.setStyle(
                    "-fx-text-fill:#8C9BB0;" +
                    "-fx-font-size:12px;" +
                    "-fx-font-weight:bold;"
            );

            header.add(
                    label,
                    i,
                    0
            );
        }

        VBox empty =
                new VBox(8);

        empty.setAlignment(
                Pos.CENTER
        );

        empty.setPrefHeight(350);

        Label title =
                new Label(
                        "No history available"
                );

        title.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:17px;" +
                "-fx-font-weight:bold;"
        );

        Label text =
                new Label(
                        "Activity history will appear here."
                );

        text.setStyle(
                "-fx-text-fill:#71829A;"
        );

        empty.getChildren().addAll(
                title,
                text
        );

        table.getChildren().addAll(
                header,
                empty
        );

        main.getChildren().addAll(
                heading,
                subtitle,
                table
        );

        root.setCenter(main);

        return new Scene(
                root,
                1300,
                750
        );
    }
}