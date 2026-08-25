package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class IncomingRequests {

    public VBox getContent() {

        VBox box = new VBox(10);

        box.setPadding(
                new Insets(40, 35, 40, 35)
        );

        box.setStyle(
                "-fx-background-color: #070E1A;"
        );


        Label title = new Label(
                "Incoming Requests"
        );

        title.setStyle("""
                -fx-text-fill: white;
                -fx-font-size: 32px;
                -fx-font-weight: bold;
                """);


        Label subtitle = new Label(
                "View new document requests from users."
        );

        subtitle.setStyle("""
                -fx-text-fill: #9AAEC4;
                -fx-font-size: 15px;
                """);


        box.getChildren().addAll(
                title,
                subtitle
        );


        return box;
    }
}