package com.ciphercore.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.scene.shape.Circle;

public class RequestStatus {

    // =========================================================
    // COLORS - PRIVORA THEME
    // =========================================================

    private final String BACKGROUND = "#0B0A0F";
    private final String CARD = "#15131F";
    private final String CARD_BORDER = "#2A2538";

    private final String PURPLE = "#8B5CF6";
    private final String VIOLET = "#A78BFA";
    private final String DEEP_PURPLE = "#6D28D9";

    private final String GREEN = "#22D3A5";

    private final String TEXT = "#F5F3FF";
    private final String SECONDARY_TEXT = "#9D96B5";
    private final String MUTED_TEXT = "#756A86";

    private final String INACTIVE = "#25283A";


    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public ScrollPane getContent() {

        VBox main = new VBox(22);

        main.setPadding(
                new Insets(28, 35, 40, 35)
        );

        main.setStyle(
                "-fx-background-color: " + BACKGROUND + ";"
        );


        // =====================================================
        // HEADER
        // =====================================================

        HBox header = new HBox();

        header.setAlignment(
                Pos.CENTER_LEFT
        );


        VBox headingBox = new VBox(5);


        Label title = new Label(
                "Request status"
        );

        title.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );


        Label subtitle = new Label(
                "Live progress of your active session."
        );

        subtitle.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 14px;"
        );


        headingBox.getChildren().addAll(
                title,
                subtitle
        );


        HBox.setHgrow(
                headingBox,
                Priority.ALWAYS
        );


        // =====================================================
        // LIVE INDICATOR
        // =====================================================

        HBox liveBox = new HBox(8);

        liveBox.setAlignment(
                Pos.CENTER
        );

        liveBox.setPadding(
                new Insets(8, 15, 8, 15)
        );

        liveBox.setStyle(
                "-fx-background-color: #211A2E;" +
                "-fx-border-color: #352752;" +
                "-fx-border-radius: 18;" +
                "-fx-background-radius: 18;"
        );


        Circle liveCircle =
                new Circle(5);

        liveCircle.setFill(
                Color.web(PURPLE)
        );


        Label liveText =
                new Label("Live");

        liveText.setStyle(
                "-fx-text-fill: " + VIOLET + ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );


        liveBox.getChildren().addAll(
                liveCircle,
                liveText
        );


        header.getChildren().addAll(
                headingBox,
                liveBox
        );


        // =====================================================
        // REQUEST STATUS CARD
        // =====================================================

        VBox statusCard =
                new VBox();

        statusCard.setPadding(
                new Insets(35, 25, 35, 25)
        );

        statusCard.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + CARD_BORDER + ";" +
                "-fx-border-radius: 22;" +
                "-fx-background-radius: 22;"
        );


        // =====================================================
        // STATUS TRACKER
        // =====================================================

        HBox tracker =
                new HBox();

        tracker.setAlignment(
                Pos.TOP_CENTER
        );


        // =====================================================
        // STEP 1 - UPLOADED
        // =====================================================

        VBox uploaded =
                createCompletedStep(
                        "1",
                        "Uploaded",
                        "10:12 AM"
                );


        // =====================================================
        // STEP 2 - CENTRE ACCEPTED
        // =====================================================

        VBox centreAccepted =
                createCompletedStep(
                        "2",
                        "Centre\nAccepted",
                        "10:14 AM"
                );


        // =====================================================
        // STEP 3 - WAITING APPROVAL
        // =====================================================

        VBox waitingApproval =
                createCompletedStep(
                        "3",
                        "Waiting\nApproval",
                        "10:16 AM"
                );


        // =====================================================
        // STEP 4 - CURRENT
        // =====================================================

        VBox printing =
                createCurrentStep(
                        "4",
                        "Printing",
                        "In progress"
                );


        // =====================================================
        // STEP 5 - PENDING
        // =====================================================

        VBox completed =
                createPendingStep(
                        "5",
                        "Completed",
                        "Pending"
                );


        // =====================================================
        // ADD TRACKER
        // =====================================================

        tracker.getChildren().addAll(

                createStepContainer(uploaded),

                createConnector(true),

                createStepContainer(centreAccepted),

                createConnector(true),

                createStepContainer(waitingApproval),

                createConnector(false),

                createStepContainer(printing),

                createConnector(false),

                createStepContainer(completed)
        );


        statusCard.getChildren().add(
                tracker
        );


        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        main.getChildren().addAll(
                header,
                statusCard
        );


        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane(main);

        scrollPane.setFitToWidth(
                true
        );

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle(
                "-fx-background-color: " + BACKGROUND + ";" +
                "-fx-background: " + BACKGROUND + ";" +
                "-fx-border-color: transparent;"
        );


        return scrollPane;
    }


    // =========================================================
    // COMPLETED STEP
    // =========================================================

    private VBox createCompletedStep(
            String number,
            String title,
            String time) {

        VBox box =
                new VBox(8);

        box.setAlignment(
                Pos.CENTER
        );

        box.setPrefWidth(
                145
        );


        // =====================================================
        // CIRCLE
        // =====================================================

        StackPane circleBox =
                new StackPane();

        circleBox.setPrefSize(
                50,
                50
        );

        circleBox.setMaxSize(
                50,
                50
        );

        circleBox.setStyle(
                "-fx-background-color: " + GREEN + ";" +
                "-fx-background-radius: 50%;" +
                "-fx-effect: dropshadow(" +
                "gaussian, " +
                "rgba(34,211,165,0.30), " +
                "16, " +
                "0.4, " +
                "0, " +
                "2);"
        );


        Label check =
                new Label("✓");

        check.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );


        circleBox.getChildren().add(
                check
        );


        // =====================================================
        // TITLE
        // =====================================================

        Label titleLabel =
                new Label(title);

        titleLabel.setAlignment(
                Pos.CENTER
        );

        titleLabel.setTextAlignment(
                TextAlignment.CENTER
        );

        titleLabel.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );


        // =====================================================
        // TIME
        // =====================================================

        Label timeLabel =
                new Label(time);

        timeLabel.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 12px;"
        );


        box.getChildren().addAll(
                circleBox,
                titleLabel,
                timeLabel
        );


        return box;
    }


    // =========================================================
    // CURRENT STEP
    // =========================================================

    private VBox createCurrentStep(
            String number,
            String title,
            String status) {

        VBox box =
                new VBox(8);

        box.setAlignment(
                Pos.CENTER
        );

        box.setPrefWidth(
                145
        );


        // =====================================================
        // PURPLE CIRCLE
        // =====================================================

        StackPane circleBox =
                new StackPane();

        circleBox.setPrefSize(
                50,
                50
        );

        circleBox.setMaxSize(
                50,
                50
        );

        circleBox.setStyle(
                "-fx-background-color: linear-gradient(" +
                "to bottom right, " +
                PURPLE + ", " +
                DEEP_PURPLE +
                ");" +
                "-fx-background-radius: 50%;" +
                "-fx-effect: dropshadow(" +
                "gaussian, " +
                "rgba(139,92,246,0.50), " +
                "22, " +
                "0.5, " +
                "0, " +
                "2);"
        );


        Label numberLabel =
                new Label(number);

        numberLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );


        circleBox.getChildren().add(
                numberLabel
        );


        // =====================================================
        // TITLE
        // =====================================================

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: " + VIOLET + ";" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );


        // =====================================================
        // STATUS
        // =====================================================

        Label statusLabel =
                new Label(status);

        statusLabel.setStyle(
                "-fx-text-fill: " + PURPLE + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );


        box.getChildren().addAll(
                circleBox,
                titleLabel,
                statusLabel
        );


        return box;
    }


    // =========================================================
    // PENDING STEP
    // =========================================================

    private VBox createPendingStep(
            String number,
            String title,
            String status) {

        VBox box =
                new VBox(8);

        box.setAlignment(
                Pos.CENTER
        );

        box.setPrefWidth(
                145
        );


        // =====================================================
        // INACTIVE CIRCLE
        // =====================================================

        StackPane circleBox =
                new StackPane();

        circleBox.setPrefSize(
                50,
                50
        );

        circleBox.setMaxSize(
                50,
                50
        );

        circleBox.setStyle(
                "-fx-background-color: " + INACTIVE + ";" +
                "-fx-border-color: #3A3548;" +
                "-fx-border-width: 1;" +
                "-fx-background-radius: 50%;" +
                "-fx-border-radius: 50%;"
        );


        Label numberLabel =
                new Label(number);

        numberLabel.setStyle(
                "-fx-text-fill: #756A86;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );


        circleBox.getChildren().add(
                numberLabel
        );


        // =====================================================
        // TITLE
        // =====================================================

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );


        // =====================================================
        // STATUS
        // =====================================================

        Label statusLabel =
                new Label(status);

        statusLabel.setStyle(
                "-fx-text-fill: " + MUTED_TEXT + ";" +
                "-fx-font-size: 12px;"
        );


        box.getChildren().addAll(
                circleBox,
                titleLabel,
                statusLabel
        );


        return box;
    }


    // =========================================================
    // STEP CONTAINER
    // =========================================================

    private VBox createStepContainer(
            VBox step) {

        VBox container =
                new VBox();

        container.setAlignment(
                Pos.TOP_CENTER
        );

        container.setPrefWidth(
                145
        );

        container.getChildren().add(
                step
        );


        return container;
    }


    // =========================================================
    // CONNECTOR
    // =========================================================

    private StackPane createConnector(
            boolean completed) {

        StackPane connector =
                new StackPane();

        connector.setPrefWidth(
                65
        );

        connector.setMinWidth(
                40
        );

        connector.setMaxWidth(
                75
        );

        connector.setPrefHeight(
                50
        );


        HBox line =
                new HBox();

        line.setPrefHeight(
                5
        );

        line.setMaxHeight(
                5
        );

        line.setMaxWidth(
                Double.MAX_VALUE
        );


        if (completed) {

            line.setStyle(
                    "-fx-background-color: " +
                    GREEN + ";" +
                    "-fx-background-radius: 4;"
            );

        } else {

            line.setStyle(
                    "-fx-background-color: #302A40;" +
                    "-fx-background-radius: 4;"
            );
        }


        connector.getChildren().add(
                line
        );


        return connector;
    }
}