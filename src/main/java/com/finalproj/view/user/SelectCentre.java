package com.finalproj.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class SelectCentre {

    private Scene selectCentreScene;

    public Scene getSelectCentreScene(
            Runnable backToDashboard) {

        // =========================================================
        // ROOT
        // =========================================================

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #020713, #06152D, #020713);"
        );

        // =========================================================
        // TOP BAR
        // =========================================================

        HBox topBar = new HBox();

        topBar.setPadding(
                new Insets(15, 28, 15, 28)
        );

        topBar.setAlignment(
                Pos.CENTER_LEFT
        );

        Label logo =
                new Label("PRIVORA");

        logo.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );

        Label pageTitle =
                new Label("  /  Select Centre");

        pageTitle.setStyle(
                "-fx-text-fill: #7E8DA3;" +
                "-fx-font-size: 13px;"
        );

        HBox titleBox =
                new HBox(
                        5,
                        logo,
                        pageTitle
                );

        titleBox.setAlignment(
                Pos.CENTER_LEFT
        );

        Button backButton =
                new Button("← Dashboard");

        backButton.setStyle(
                "-fx-background-color: #0B162A;" +
                "-fx-border-color: #263653;" +
                "-fx-border-radius: 15;" +
                "-fx-background-radius: 15;" +
                "-fx-text-fill: #B8C5D6;" +
                "-fx-padding: 8 16 8 16;"
        );

        backButton.setOnAction(e -> {

            System.out.println(
                    "Back to Dashboard clicked"
            );

            backToDashboard.run();
        });

        HBox.setHgrow(
                titleBox,
                Priority.ALWAYS
        );

        topBar.getChildren().addAll(
                titleBox,
                backButton
        );

        // =========================================================
        // MAIN CONTENT
        // =========================================================

        VBox content =
                new VBox(18);

        content.setPadding(
                new Insets(40, 80, 40, 80)
        );

        content.setAlignment(
                Pos.TOP_CENTER
        );

        // =========================================================
        // HEADING
        // =========================================================

        Label heading =
                new Label(
                        "Select Xerox Centre"
                );

        heading.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );

        Label description =
                new Label(
                        "Choose a nearby Xerox centre to securely share your document."
                );

        description.setStyle(
                "-fx-text-fill: #8291A7;" +
                "-fx-font-size: 13px;"
        );

        // =========================================================
        // SEARCH BAR
        // =========================================================

        TextField searchField =
                new TextField();

        searchField.setPromptText(
                "Search Xerox centre..."
        );

        searchField.setPrefHeight(42);

        searchField.setMaxWidth(600);

        searchField.setStyle(
                "-fx-background-color: #091428;" +
                "-fx-background-radius: 12;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 12;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #687B93;" +
                "-fx-padding: 0 15 0 15;"
        );

        // =========================================================
        // CENTRE LIST
        // =========================================================

        VBox centreList =
                new VBox(12);

        centreList.setMaxWidth(600);

        VBox centre1 =
                createCentreCard(
                        "Quick Xerox Centre",
                        "Near College Road",
                        "2.1 km",
                        "Open"
                );

        VBox centre2 =
                createCentreCard(
                        "City Digital Xerox",
                        "FC Road",
                        "3.4 km",
                        "Open"
                );

        VBox centre3 =
                createCentreCard(
                        "Smart Print & Xerox",
                        "Shivajinagar",
                        "4.2 km",
                        "Open"
                );

        VBox centre4 =
                createCentreCard(
                        "Campus Xerox Point",
                        "University Road",
                        "5.0 km",
                        "Closed"
                );

        centreList.getChildren().addAll(
                centre1,
                centre2,
                centre3,
                centre4
        );

        // =========================================================
        // ADD CONTENT
        // =========================================================

        content.getChildren().addAll(
                heading,
                description,
                searchField,
                centreList
        );

        // =========================================================
        // SCROLL PANE
        // =========================================================

        ScrollPane scrollPane =
                new ScrollPane(content);

        scrollPane.setFitToWidth(true);

        scrollPane.setFitToHeight(false);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;"
        );

        // =========================================================
        // ROOT
        // =========================================================

        root.setTop(topBar);

        root.setCenter(scrollPane);

        // =========================================================
        // SCENE
        // =========================================================

        selectCentreScene =
                new Scene(
                        root,
                        1300,
                        700
                );

        return selectCentreScene;
    }

    // =============================================================
    // CENTRE CARD
    // =============================================================

    private VBox createCentreCard(
            String name,
            String location,
            String distance,
            String status) {

        VBox card =
                new VBox(8);

        card.setPadding(
                new Insets(18)
        );

        card.setPrefHeight(100);

        card.setStyle(
                "-fx-background-color: #091428;" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 16;"
        );

        Label nameLabel =
                new Label(name);

        nameLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        Label locationLabel =
                new Label(location);

        locationLabel.setStyle(
                "-fx-text-fill: #71829A;" +
                "-fx-font-size: 11px;"
        );

        Label distanceLabel =
                new Label(
                        distance +
                        "     •     " +
                        status
                );

        distanceLabel.setStyle(
                "-fx-text-fill: #39A5FF;" +
                "-fx-font-size: 11px;"
        );

        Button selectButton =
                new Button("Select");

        selectButton.setStyle(
                "-fx-background-color: #1767C9;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 7 18 7 18;"
        );

        HBox bottom =
                new HBox(
                        10,
                        distanceLabel,
                        selectButton
                );

        bottom.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                distanceLabel,
                Priority.ALWAYS
        );

        card.getChildren().addAll(
                nameLabel,
                locationLabel,
                bottom
        );

        // =========================================================
        // HOVER EFFECT
        // =========================================================

        card.setOnMouseEntered(e -> {

            card.setStyle(
                    "-fx-background-color: #0E1D33;" +
                    "-fx-background-radius: 16;" +
                    "-fx-border-color: #2196F3;" +
                    "-fx-border-radius: 16;"
            );
        });

        card.setOnMouseExited(e -> {

            card.setStyle(
                    "-fx-background-color: #091428;" +
                    "-fx-background-radius: 16;" +
                    "-fx-border-color: #1C304A;" +
                    "-fx-border-radius: 16;"
            );
        });

        // =========================================================
        // SELECT BUTTON
        // =========================================================

        selectButton.setOnAction(e -> {

            System.out.println(
                    "Selected Xerox Centre: " +
                    name
            );

            selectButton.setText(
                    "Selected ✓"
            );

            selectButton.setStyle(
                    "-fx-background-color: #19A974;" +
                    "-fx-background-radius: 10;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 7 18 7 18;"
            );
        });

        return card;
    }
}