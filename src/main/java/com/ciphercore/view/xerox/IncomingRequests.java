package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class IncomingRequests {

    public Scene getScene() {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:#061126;"
        );

        XeroxSideBar sideBar =
                new XeroxSideBar(
                        "IncomingRequests"
                );

        root.setLeft(
                sideBar.getSideBar()
        );

        // =====================================================
        // TOP
        // =====================================================

        HBox top =
                createTopBar();

        // =====================================================
        // MAIN
        // =====================================================

        VBox main =
                new VBox(22);

        main.setPadding(
                new Insets(32)
        );

        Label heading =
                new Label(
                        "Incoming Requests"
                );

        heading.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:32px;" +
                "-fx-font-weight:bold;"
        );

        Label subtitle =
                new Label(
                        "Accept or reject requests coming in from users."
                );

        subtitle.setStyle(
                "-fx-text-fill:#8C9BB0;"
        );

        // =====================================================
        // TABLE
        // =====================================================

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

        header.setHgap(100);

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

        VBox.setVgrow(
                empty,
                Priority.ALWAYS
        );

        Label emptyTitle =
                new Label(
                        "No incoming requests"
                );

        emptyTitle.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:17px;" +
                "-fx-font-weight:bold;"
        );

        Label emptyText =
                new Label(
                        "New requests will appear here."
                );

        emptyText.setStyle(
                "-fx-text-fill:#71829A;"
        );

        empty.getChildren().addAll(
                emptyTitle,
                emptyText
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

        root.setTop(top);
        root.setCenter(main);

        return new Scene(
                root,
                1300,
                750
        );
    }

    private HBox createTopBar() {

        HBox top =
                new HBox();

        top.setPadding(
                new Insets(18, 28, 18, 28)
        );

        top.setAlignment(
                Pos.CENTER_RIGHT
        );

        top.setStyle(
                "-fx-background-color:#09172B;"
        );

        Label label =
                new Label(
                        "●  Centre Online"
                );

        label.setStyle(
                "-fx-text-fill:#20D6A1;"
        );

        top.getChildren().add(
                label
        );

        return top;
    }
}