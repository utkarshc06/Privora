package com.ciphercore.view.admin;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Centres {

    public VBox getContent() {

        VBox box = new VBox(10);

        box.setPadding(
                new Insets(5)
        );

        Label title = new Label(
                "Centres"
        );

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Manage registered Xerox and printing centres."
        );

        subtitle.setStyle(
                "-fx-text-fill: #9AAEC4;" +
                "-fx-font-size: 15px;"
        );

        box.getChildren().addAll(
                title,
                subtitle
        );

        return box;
    }
}