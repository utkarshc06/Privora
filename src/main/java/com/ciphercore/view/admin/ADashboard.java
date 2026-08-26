
package com.ciphercore.view.admin;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ADashboard {

    public VBox getContent() {

        VBox box = new VBox(10);

        box.setPadding(
                new Insets(5)
        );

        Label title = new Label(
                "Admin Dashboard"
        );

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Monitor and manage the PRIVORA platform."
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