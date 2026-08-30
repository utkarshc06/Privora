package com.ciphercore.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SelectCentre {

    // =========================================================
    // COLORS - PRIVORA THEME
    // =========================================================

    private final String BACKGROUND = "#0B0A0F";
    private final String CARD = "#15131F";
    private final String CARD_BORDER = "#2A2538";

    private final String PURPLE = "#8B5CF6";
    private final String VIOLET = "#A78BFA";
    private final String DEEP_PURPLE = "#6D28D9";

    private final String TEXT = "#F5F3FF";
    private final String SECONDARY_TEXT = "#9D96B5";


    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public VBox getContent() {

        VBox main = new VBox(22);

        main.setPadding(
                new Insets(32, 40, 40, 40)
        );

        main.setStyle(
                "-fx-background-color: " + BACKGROUND + ";"
        );


        // =====================================================
        // TITLE
        // =====================================================

        Label title = new Label(
                "Select a xerox centre"
        );

        title.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;"
        );


        Label subtitle = new Label(
                "Choose a verified centre near you."
        );

        subtitle.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 15px;"
        );


        VBox heading = new VBox(5);

        heading.getChildren().addAll(
                title,
                subtitle
        );


        // =====================================================
        // SEARCH BOX
        // =====================================================

        HBox searchBox = new HBox(12);

        searchBox.setAlignment(
                Pos.CENTER_LEFT
        );

        searchBox.setPadding(
                new Insets(0, 18, 0, 18)
        );

        searchBox.setMaxWidth(650);

        searchBox.setPrefHeight(58);

        searchBox.setStyle(
                "-fx-background-color: #151827;" +
                "-fx-background-radius: 30;" +
                "-fx-border-color: #252B3D;" +
                "-fx-border-radius: 30;"
        );


        Label searchIcon = new Label("⌕");

        searchIcon.setStyle(
                "-fx-text-fill: #9D96B5;" +
                "-fx-font-size: 27px;"
        );


        TextField searchField =
                new TextField();

        searchField.setPromptText(
                "Search by name or area..."
        );

        searchField.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-prompt-text-fill: #81798F;" +
                "-fx-font-size: 16px;" +
                "-fx-border-width: 0;"
        );

        HBox.setHgrow(
                searchField,
                Priority.ALWAYS
        );


        searchBox.getChildren().addAll(
                searchIcon,
                searchField
        );


        // =====================================================
        // CENTRE GRID
        // =====================================================

        GridPane centreGrid =
                new GridPane();

        centreGrid.setHgap(20);
        centreGrid.setVgap(20);

        centreGrid.setMaxWidth(
                Double.MAX_VALUE
        );


        // =====================================================
        // CENTRES
        // =====================================================

        VBox centre1 = createCentreCard(
                "Sharma Xerox",
                "4.8",
                "0.4 km",
                "Active"
        );


        VBox centre2 = createCentreCard(
                "QuickPrint Hub",
                "4.6",
                "0.9 km",
                "Active"
        );


        VBox centre3 = createCentreCard(
                "City Copy Centre",
                "4.4",
                "1.2 km",
                "Pending"
        );


        VBox centre4 = createCentreCard(
                "PrintZone Express",
                "4.2",
                "2.0 km",
                "Active"
        );


        centreGrid.add(
                centre1,
                0,
                0
        );

        centreGrid.add(
                centre2,
                1,
                0
        );

        centreGrid.add(
                centre3,
                0,
                1
        );

        centreGrid.add(
                centre4,
                1,
                1
        );


        // =====================================================
        // COLUMN WIDTH
        // =====================================================

        javafx.scene.layout.ColumnConstraints column1 =
                new javafx.scene.layout.ColumnConstraints();

        column1.setPercentWidth(50);

        column1.setHgrow(
                Priority.ALWAYS
        );


        javafx.scene.layout.ColumnConstraints column2 =
                new javafx.scene.layout.ColumnConstraints();

        column2.setPercentWidth(50);

        column2.setHgrow(
                Priority.ALWAYS
        );


        centreGrid.getColumnConstraints().addAll(
                column1,
                column2
        );


        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane(centreGrid);

        scrollPane.setFitToWidth(true);

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

        VBox.setVgrow(
                scrollPane,
                Priority.ALWAYS
        );


        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        main.getChildren().addAll(
                heading,
                searchBox,
                scrollPane
        );


        return main;
    }


    // =========================================================
    // CENTRE CARD
    // =========================================================

    private VBox createCentreCard(
            String centreName,
            String rating,
            String distance,
            String status) {


        VBox card =
                new VBox(14);

        card.setPadding(
                new Insets(22)
        );

        card.setMinHeight(145);

        card.setMaxWidth(
                Double.MAX_VALUE
        );


        card.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + CARD_BORDER + ";" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;"
        );


        // =====================================================
        // TOP ROW
        // =====================================================

        HBox topRow =
                new HBox(15);

        topRow.setAlignment(
                Pos.CENTER_LEFT
        );


        // =====================================================
        // ICON
        // =====================================================

        Circle iconCircle =
                new Circle(27);

        iconCircle.setFill(
                Color.web(DEEP_PURPLE)
        );


        Label icon =
                new Label("▥");

        icon.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 19px;" +
                "-fx-font-weight: bold;"
        );


        StackPane iconBox =
                new StackPane();

        iconBox.setPrefSize(
                54,
                54
        );

        iconBox.getChildren().addAll(
                iconCircle,
                icon
        );


        // =====================================================
        // NAME
        // =====================================================

        Label name =
                new Label(centreName);

        name.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );


        HBox.setHgrow(
                name,
                Priority.ALWAYS
        );


        // =====================================================
        // VERIFIED ICON
        // =====================================================

        Label verified =
                new Label("✓");

        verified.setStyle(
                "-fx-text-fill: " + VIOLET + ";" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );


        topRow.getChildren().addAll(
                iconBox,
                name,
                verified
        );


        // =====================================================
        // INFORMATION ROW
        // =====================================================

        HBox infoRow =
                new HBox(16);

        infoRow.setAlignment(
                Pos.CENTER_LEFT
        );


        Label ratingLabel =
                new Label("★ " + rating);

        ratingLabel.setStyle(
                "-fx-text-fill: #F4C95D;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );


        Label distanceLabel =
                new Label("⌖ " + distance);

        distanceLabel.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 13px;"
        );


        Label statusLabel =
                new Label(status);

        statusLabel.setPadding(
                new Insets(5, 12, 5, 12)
        );


        if (status.equals("Active")) {

            statusLabel.setStyle(
                    "-fx-background-color: #241C36;" +
                    "-fx-text-fill: " + VIOLET + ";" +
                    "-fx-background-radius: 15;" +
                    "-fx-font-size: 12px;" +
                    "-fx-font-weight: bold;"
            );

        } else {

            statusLabel.setStyle(
                    "-fx-background-color: #30271A;" +
                    "-fx-text-fill: #D8A84E;" +
                    "-fx-background-radius: 15;" +
                    "-fx-font-size: 12px;" +
                    "-fx-font-weight: bold;"
            );
        }


        // =====================================================
        // SELECT BUTTON
        // =====================================================

        Button selectButton =
                new Button("Select");


        selectButton.setStyle(
                "-fx-background-color: linear-gradient(to right, "
                        + PURPLE + ", " + DEEP_PURPLE + ");" +
                "-fx-background-radius: 18;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 9 17 9 17;" +
                "-fx-cursor: hand;"
        );


        selectButton.setOnMouseEntered(e -> {

            selectButton.setStyle(
                    "-fx-background-color: linear-gradient(to right, "
                            + VIOLET + ", " + PURPLE + ");" +
                    "-fx-background-radius: 18;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 13px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 9 17 9 17;" +
                    "-fx-cursor: hand;"
            );

            selectButton.setScaleX(1.04);
            selectButton.setScaleY(1.04);
        });


        selectButton.setOnMouseExited(e -> {

            selectButton.setStyle(
                    "-fx-background-color: linear-gradient(to right, "
                            + PURPLE + ", " + DEEP_PURPLE + ");" +
                    "-fx-background-radius: 18;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 13px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 9 17 9 17;" +
                    "-fx-cursor: hand;"
            );

            selectButton.setScaleX(1);
            selectButton.setScaleY(1);
        });


        // =====================================================
        // SELECT ACTION
        // =====================================================

        selectButton.setOnAction(e -> {

            selectButton.setText("Selected ✓");

            selectButton.setStyle(
                    "-fx-background-color: #3B2A5A;" +
                    "-fx-background-radius: 18;" +
                    "-fx-text-fill: " + VIOLET + ";" +
                    "-fx-font-size: 13px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 9 17 9 17;" +
                    "-fx-cursor: hand;"
            );

        });


        // =====================================================
        // INFORMATION + BUTTON
        // =====================================================

        HBox bottomRow =
                new HBox(14);

        bottomRow.setAlignment(
                Pos.CENTER_LEFT
        );


        HBox.setHgrow(
                infoRow,
                Priority.ALWAYS
        );


        infoRow.getChildren().addAll(
                ratingLabel,
                distanceLabel,
                statusLabel
        );


        bottomRow.getChildren().addAll(
                infoRow,
                selectButton
        );


        // =====================================================
        // ADD TO CARD
        // =====================================================

        card.getChildren().addAll(
                topRow,
                bottomRow
        );


        // =====================================================
        // CARD HOVER
        // =====================================================

        card.setOnMouseEntered(e -> {

            card.setStyle(
                    "-fx-background-color: #1B1828;" +
                    "-fx-border-color: " + PURPLE + ";" +
                    "-fx-border-radius: 20;" +
                    "-fx-background-radius: 20;" +
                    "-fx-effect: dropshadow("
                            + "gaussian, "
                            + "rgba(139,92,246,0.22), "
                            + "18, 0.3, 0, 3);"
            );

            card.setScaleX(1.01);
            card.setScaleY(1.01);
        });


        card.setOnMouseExited(e -> {

            card.setStyle(
                    "-fx-background-color: " + CARD + ";" +
                    "-fx-border-color: " + CARD_BORDER + ";" +
                    "-fx-border-radius: 20;" +
                    "-fx-background-radius: 20;"
            );

            card.setScaleX(1);
            card.setScaleY(1);
        });


        return card;
    }
}