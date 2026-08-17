package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Settings {

    public Scene getScene() {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:#061126;"
        );

        XeroxSideBar sideBar =
                new XeroxSideBar(
                        "Settings"
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
                new Label("Settings");

        heading.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:32px;" +
                "-fx-font-weight:bold;"
        );

        Label subtitle =
                new Label(
                        "Manage Xerox Centre settings."
                );

        subtitle.setStyle(
                "-fx-text-fill:#8C9BB0;"
        );

        VBox centreSettings =
                createBox(
                        "Centre Settings",
                        "Centre information",
                        "Printer configuration",
                        "Privacy configuration"
                );

        VBox security =
                createBox(
                        "Security",
                        "Session timeout",
                        "Print limits",
                        "Access controls"
                );

        main.getChildren().addAll(
                heading,
                subtitle,
                centreSettings,
                security
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
            String... options) {

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

        for (String option : options) {

            Label label =
                    new Label(option);

            label.setStyle(
                    "-fx-text-fill:#8C9BB0;" +
                    "-fx-font-size:14px;"
            );

            box.getChildren().add(
                    label
            );
        }

        return box;
    }
}