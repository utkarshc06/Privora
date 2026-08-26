package com.ciphercore.view.admin;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ActivityLogs {

    public VBox getContent() {

        VBox box = new VBox(10);

        box.setPadding(
                new Insets(5)
        );

        Label title = new Label(
                "Activity Logs"
        );

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Track administrator and system activity."
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