package com.finalproj.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Activity {

    private Scene activityScene;

    public Scene getActivityScene(Runnable backToDashboard) {

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
                new Insets(15, 25, 15, 25)
        );

        topBar.setAlignment(Pos.CENTER_LEFT);

        Label logo = new Label("PRIVORA");

        logo.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );

        Label pageTitle = new Label("Activity");

        pageTitle.setStyle(
                "-fx-text-fill: #8C9BB0;" +
                "-fx-font-size: 13px;"
        );

        HBox titleBox = new HBox(
                15,
                logo,
                pageTitle
        );

        titleBox.setAlignment(Pos.CENTER_LEFT);

        Button backButton =
                new Button("← Dashboard");

        backButton.setStyle(
                "-fx-background-color: #0B162A;" +
                "-fx-border-color: #263653;" +
                "-fx-border-radius: 15;" +
                "-fx-background-radius: 15;" +
                "-fx-text-fill: white;" +
                "-fx-padding: 8 18 8 18;"
        );

        backButton.setOnAction(e -> {
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
        // SIDEBAR
        // =========================================================

        VBox sidebar = new VBox(12);

        sidebar.setPadding(
                new Insets(25, 15, 25, 15)
        );

        sidebar.setPrefWidth(210);

        sidebar.setStyle(
                "-fx-background-color: rgba(5,15,32,0.9);" +
                "-fx-border-color: #172942;"
        );

        Label menuTitle =
                new Label("DOCUMENT");

        menuTitle.setStyle(
                "-fx-text-fill: #64758D;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        Button dashboardButton =
                createMenuButton("Dashboard");

        Button uploadButton =
                createMenuButton("Upload Document");

        Button documentsButton =
                createMenuButton("My Documents");

        Button activityButton =
                createMenuButton("Activity");

        Button profileButton =
                createMenuButton("Profile");

        sidebar.getChildren().addAll(
                menuTitle,
                dashboardButton,
                uploadButton,
                documentsButton,
                activityButton,
                profileButton
        );

        // =========================================================
        // MAIN CONTENT
        // =========================================================

        VBox content = new VBox(20);

        content.setPadding(
                new Insets(30)
        );

        // =========================================================
        // HEADER
        // =========================================================

        Label heading =
                new Label("Activity");

        heading.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;"
        );

        Label description =
                new Label(
                        "Track all activity related to your secure documents."
                );

        description.setStyle(
                "-fx-text-fill: #8291A7;" +
                "-fx-font-size: 13px;"
        );

        // =========================================================
        // ACTIVITY SUMMARY
        // =========================================================

        HBox summaryBox =
                new HBox(15);

        VBox totalCard =
                createSummaryCard(
                        "Total Activity",
                        "24",
                        "#39A5FF"
                );

        VBox accessCard =
                createSummaryCard(
                        "Documents Accessed",
                        "12",
                        "#19D6A3"
                );

        VBox printCard =
                createSummaryCard(
                        "Print Actions",
                        "8",
                        "#C084FC"
                );

        VBox expiredCard =
                createSummaryCard(
                        "Expired Sessions",
                        "4",
                        "#FF6B6B"
                );

        HBox.setHgrow(totalCard, Priority.ALWAYS);
        HBox.setHgrow(accessCard, Priority.ALWAYS);
        HBox.setHgrow(printCard, Priority.ALWAYS);
        HBox.setHgrow(expiredCard, Priority.ALWAYS);

        summaryBox.getChildren().addAll(
                totalCard,
                accessCard,
                printCard,
                expiredCard
        );

        // =========================================================
        // RECENT ACTIVITY
        // =========================================================

        Label recentTitle =
                new Label("Recent Activity");

        recentTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );

        VBox activityList =
                new VBox(10);

        activityList.getChildren().addAll(

                createActivityCard(
                        "Document Viewed",
                        "Aadhaar-Card.pdf",
                        "Today, 03:42 PM",
                        "VIEW"
                ),

                createActivityCard(
                        "Document Printed",
                        "PAN-Card.pdf",
                        "Today, 03:25 PM",
                        "PRINT"
                ),

                createActivityCard(
                        "Secure Session Created",
                        "College-ID.pdf",
                        "Today, 02:48 PM",
                        "CREATE"
                ),

                createActivityCard(
                        "Document Expired",
                        "Old-Document.pdf",
                        "Today, 01:15 PM",
                        "EXPIRED"
                ),

                createActivityCard(
                        "Document Viewed",
                        "Resume.pdf",
                        "Yesterday, 06:30 PM",
                        "VIEW"
                )
        );

        // =========================================================
        // ADD CONTENT
        // =========================================================

        content.getChildren().addAll(
                heading,
                description,
                summaryBox,
                recentTitle,
                activityList
        );

        // =========================================================
        // ROOT
        // =========================================================

        root.setTop(topBar);
        root.setLeft(sidebar);
        root.setCenter(content);

        // =========================================================
        // SCENE
        // =========================================================

        activityScene =
                new Scene(
                        root,
                        1300,
                        700
                );

        return activityScene;
    }

    // =============================================================
    // SUMMARY CARD
    // =============================================================

    private VBox createSummaryCard(
            String title,
            String value,
            String color) {

        VBox card =
                new VBox(8);

        card.setPadding(
                new Insets(18)
        );

        card.setPrefHeight(100);

        card.setStyle(
                "-fx-background-color: #091428;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 18;"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: #8291A7;" +
                "-fx-font-size: 11px;"
        );

        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-text-fill: " + color + ";" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );

        card.getChildren().addAll(
                titleLabel,
                valueLabel
        );

        return card;
    }

    // =============================================================
    // ACTIVITY CARD
    // =============================================================

    private HBox createActivityCard(
            String action,
            String document,
            String time,
            String type) {

        HBox card =
                new HBox(15);

        card.setPadding(
                new Insets(15)
        );

        card.setAlignment(
                Pos.CENTER_LEFT
        );

        card.setStyle(
                "-fx-background-color: #091428;" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 16;"
        );

        // ---------------------------------------------------------
        // ICON
        // ---------------------------------------------------------

        Label icon =
                new Label(getIcon(type));

        icon.setStyle(
                "-fx-background-color: #10294A;" +
                "-fx-background-radius: 12;" +
                "-fx-text-fill: #39A5FF;" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 12 10 12;"
        );

        // ---------------------------------------------------------
        // INFORMATION
        // ---------------------------------------------------------

        VBox information =
                new VBox(4);

        Label actionLabel =
                new Label(action);

        actionLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        Label documentLabel =
                new Label(document);

        documentLabel.setStyle(
                "-fx-text-fill: #718198;" +
                "-fx-font-size: 11px;"
        );

        information.getChildren().addAll(
                actionLabel,
                documentLabel
        );

        HBox.setHgrow(
                information,
                Priority.ALWAYS
        );

        // ---------------------------------------------------------
        // TIME
        // ---------------------------------------------------------

        Label timeLabel =
                new Label(time);

        timeLabel.setStyle(
                "-fx-text-fill: #8291A7;" +
                "-fx-font-size: 11px;"
        );

        card.getChildren().addAll(
                icon,
                information,
                timeLabel
        );

        return card;
    }

    // =============================================================
    // ICON
    // =============================================================

    private String getIcon(String type) {

        switch (type) {

            case "VIEW":
                return "V";

            case "PRINT":
                return "P";

            case "CREATE":
                return "+";

            case "EXPIRED":
                return "!";

            default:
                return "•";
        }
    }

    // =============================================================
    // MENU BUTTON
    // =============================================================

    private Button createMenuButton(
            String text) {

        Button button =
                new Button(text);

        button.setMaxWidth(
                Double.MAX_VALUE
        );

        button.setAlignment(
                Pos.CENTER_LEFT
        );

        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: #B8C5D6;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 10 15 10 15;"
        );

        button.setOnMouseEntered(e -> {

            button.setStyle(
                    "-fx-background-color: #0E1D33;" +
                    "-fx-background-radius: 10;" +
                    "-fx-text-fill: #4CA8FF;" +
                    "-fx-font-size: 13px;" +
                    "-fx-padding: 10 15 10 15;"
            );
        });

        button.setOnMouseExited(e -> {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: #B8C5D6;" +
                    "-fx-font-size: 13px;" +
                    "-fx-padding: 10 15 10 15;"
            );
        });

        return button;
    }
}