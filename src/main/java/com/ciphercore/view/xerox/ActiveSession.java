package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ActiveSession {

    public Scene getScene() {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:#061126;"
        );

        XeroxSideBar sideBar =
                new XeroxSideBar(
                        "ActiveSession"
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
                new Label(
                        "Active Sessions"
                );

        heading.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:32px;" +
                "-fx-font-weight:bold;"
        );

        Label subtitle =
                new Label(
                        "Currently running print sessions."
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

        GridPane columns =
                new GridPane();

        columns.setHgap(100);

        String[] titles = {
                "CUSTOMER",
                "PURPOSE",
                "TIME",
                "STATUS",
                "ACTIONS"
        };

        for (int i = 0; i < titles.length; i++) {

            Label label =
                    new Label(titles[i]);

            label.setStyle(
                    "-fx-text-fill:#8C9BB0;" +
                    "-fx-font-size:12px;" +
                    "-fx-font-weight:bold;"
            );

            columns.add(
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
                        "No active sessions"
                );

        title.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:17px;" +
                "-fx-font-weight:bold;"
        );

        Label text =
                new Label(
                        "Active sessions will appear here."
                );

        text.setStyle(
                "-fx-text-fill:#71829A;"
        );

        empty.getChildren().addAll(
                title,
                text
        );

        table.getChildren().addAll(
                columns,
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