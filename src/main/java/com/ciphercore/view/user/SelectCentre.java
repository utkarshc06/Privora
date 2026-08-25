package com.ciphercore.view.user;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SelectCentre {

    public VBox getContent() {

        VBox box = new VBox(10);

        box.setPadding(
                new Insets(40, 35, 40, 35)
        );

        box.setStyle(
                "-fx-background-color: #070E1A;"
        );


        Label title = new Label(
                "Select Centre"
        );

        title.setStyle("""
                -fx-text-fill: white;
                -fx-font-size: 32px;
                -fx-font-weight: bold;
                """);


        Label subtitle = new Label(
                "Choose a secure printing or service centre."
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