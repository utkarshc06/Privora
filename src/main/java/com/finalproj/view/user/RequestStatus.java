package com.finalproj.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class RequestStatus {

    private Scene requestStatusScene;

    public Scene getRequestStatusScene(Runnable backToDashboard) {

        // =========================================================
        // ROOT
        // =========================================================

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color: #F5FAFE;"
        );

        // =========================================================
        // TOP BAR
        // =========================================================

        HBox topBar = new HBox();

        topBar.setPadding(
                new Insets(15, 25, 15, 25)
        );

        topBar.setAlignment(
                Pos.CENTER_LEFT
        );

        topBar.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #E1E8F0;" +
                "-fx-border-width: 0 0 1 0;"
        );

        Label logo = new Label("PRIVORA");

        logo.setStyle(
                "-fx-text-fill: #101828;" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );

        Label pageTitle = new Label(
                "  /  Request Status"
        );

        pageTitle.setStyle(
                "-fx-text-fill: #718096;" +
                "-fx-font-size: 13px;"
        );

        HBox titleBox = new HBox(
                5,
                logo,
                pageTitle
        );

        titleBox.setAlignment(
                Pos.CENTER_LEFT
        );

        // =========================================================
        // SEARCH BAR
        // =========================================================

        TextField searchField = new TextField();

        searchField.setPromptText(
                "Search documents, sessions, users..."
        );

        searchField.setPrefWidth(400);
        searchField.setPrefHeight(40);

        searchField.setStyle(
                "-fx-background-color: #F3F6FA;" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #E2E8F0;" +
                "-fx-border-radius: 22;" +
                "-fx-text-fill: #1A202C;" +
                "-fx-prompt-text-fill: #718096;" +
                "-fx-padding: 0 18 0 18;"
        );

        // =========================================================
        // USER
        // =========================================================

        Label userIcon = new Label("U");

        userIcon.setAlignment(
                Pos.CENTER
        );

        userIcon.setStyle(
                "-fx-background-color: #3182F6;" +
                "-fx-background-radius: 50%;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-min-width: 38px;" +
                "-fx-min-height: 38px;"
        );

        Label userName = new Label("User");

        userName.setStyle(
                "-fx-text-fill: #172033;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        Label userRole = new Label(
                "User"
        );

        userRole.setStyle(
                "-fx-text-fill: #718096;" +
                "-fx-font-size: 10px;"
        );

        VBox userInfo = new VBox(
                1,
                userName,
                userRole
        );

        HBox userBox = new HBox(
                10,
                userInfo,
                userIcon
        );

        userBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        HBox.setHgrow(
                titleBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                searchField,
                Priority.NEVER
        );

        topBar.getChildren().addAll(
                titleBox,
                searchField,
                new Region(),
                userBox
        );

        // =========================================================
        // SIDEBAR
        // =========================================================

        VBox sidebar = new VBox(8);

        sidebar.setPadding(
                new Insets(25, 10, 25, 10)
        );

        sidebar.setPrefWidth(220);

        sidebar.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #E1E8F0;" +
                "-fx-border-width: 0 1 0 0;"
        );

        Label menuTitle = new Label(
                "USER PANEL"
        );

        menuTitle.setPadding(
                new Insets(0, 10, 10, 10)
        );

        menuTitle.setStyle(
                "-fx-text-fill: #718096;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        Button dashboardButton =
                createMenuButton("▦   Dashboard");

        Button uploadButton =
                createMenuButton("⇧   Upload Document");

        Button purposeButton =
                createMenuButton("▣   Purpose");

        Button privacyButton =
                createMenuButton("⌗   Privacy Scan");

        Button redactButton =
                createMenuButton("✣   Smart Redaction");

        Button permissionsButton =
                createMenuButton("♢   Permissions");

        Button centreButton =
                createMenuButton("▥   Select Centre");

        Button qrButton =
                createMenuButton("▦   QR & Session");

        Button requestButton =
                createMenuButton("◷   Request Status");

        Button documentsButton =
                createMenuButton("▤   My Documents");

        Button activityButton =
                createMenuButton("〽   Activity");

        Button receiptButton =
                createMenuButton("▣   Privacy Receipt");

        Button notificationButton =
                createMenuButton("♧   Notifications");

        Button profileButton =
                createMenuButton("♙   Profile");

        sidebar.getChildren().addAll(
                menuTitle,
                dashboardButton,
                uploadButton,
                purposeButton,
                privacyButton,
                redactButton,
                permissionsButton,
                centreButton,
                qrButton,
                requestButton,
                documentsButton,
                activityButton,
                receiptButton,
                notificationButton,
                profileButton
        );

        // =========================================================
        // ACTIVE BUTTON
        // =========================================================

        requestButton.setStyle(
                "-fx-background-color: #3182F6;" +
                "-fx-background-radius: 20;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 11 15 11 15;"
        );

        // =========================================================
        // SIDEBAR ACTIONS
        // =========================================================

        dashboardButton.setOnAction(e ->
                backToDashboard.run()
        );

        // Other buttons can be connected later.

        // =========================================================
        // MAIN CONTENT
        // =========================================================

        VBox mainContent = new VBox(20);

        mainContent.setPadding(
                new Insets(35)
        );

        // =========================================================
        // HEADER
        // =========================================================

        HBox headingBox = new HBox();

        VBox headingText = new VBox(5);

        Label heading = new Label(
                "Request status"
        );

        heading.setStyle(
                "-fx-text-fill: #101828;" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );

        Label description = new Label(
                "Live progress of your active session."
        );

        description.setStyle(
                "-fx-text-fill: #607089;" +
                "-fx-font-size: 14px;"
        );

        headingText.getChildren().addAll(
                heading,
                description
        );

        Region headingSpacer = new Region();

        HBox.setHgrow(
                headingSpacer,
                Priority.ALWAYS
        );

        // =========================================================
        // LIVE STATUS
        // =========================================================

        Circle liveCircle = new Circle(
                5,
                Color.web("#19C99A")
        );

        Label liveLabel = new Label(
                "Live"
        );

        liveLabel.setStyle(
                "-fx-text-fill: #263448;" +
                "-fx-font-size: 13px;"
        );

        HBox liveBox = new HBox(
                8,
                liveCircle,
                liveLabel
        );

        liveBox.setAlignment(
                Pos.CENTER
        );

        headingBox.getChildren().addAll(
                headingText,
                headingSpacer,
                liveBox
        );

        // =========================================================
        // STATUS CARD
        // =========================================================

        VBox statusCard = new VBox();

        statusCard.setPadding(
                new Insets(28)
        );

        statusCard.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #DCE5EE;" +
                "-fx-border-radius: 20;"
        );

        // =========================================================
        // PROGRESS AREA
        // =========================================================

        HBox progress = new HBox();

        progress.setAlignment(
                Pos.TOP_CENTER
        );

        progress.setPrefHeight(
                150
        );

        // STEP 1
        VBox step1 = createStep(
                "✓",
                "Uploaded",
                "10:12 AM",
                "completed"
        );

        // STEP 2
        VBox step2 = createStep(
                "✓",
                "Centre Accepted",
                "10:14 AM",
                "completed"
        );

        // STEP 3
        VBox step3 = createStep(
                "✓",
                "Waiting Approval",
                "10:16 AM",
                "completed"
        );

        // STEP 4
        VBox step4 = createStep(
                "4",
                "Printing",
                "In progress",
                "active"
        );

        // STEP 5
        VBox step5 = createStep(
                "5",
                "Completed",
                "Pending",
                "pending"
        );

        HBox.setHgrow(
                step1,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                step2,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                step3,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                step4,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                step5,
                Priority.ALWAYS
        );

        progress.getChildren().addAll(
                step1,
                step2,
                step3,
                step4,
                step5
        );

        statusCard.getChildren().add(
                progress
        );

        // =========================================================
        // SESSION INFORMATION
        // =========================================================

        VBox sessionCard = new VBox(15);

        sessionCard.setPadding(
                new Insets(20)
        );

        sessionCard.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: #DCE5EE;" +
                "-fx-border-radius: 16;"
        );

        Label sessionTitle = new Label(
                "Active Session"
        );

        sessionTitle.setStyle(
                "-fx-text-fill: #172033;" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );

        Label document = new Label(
                "Document: Aadhaar-Card.pdf"
        );

        document.setStyle(
                "-fx-text-fill: #506078;" +
                "-fx-font-size: 13px;"
        );

        Label centre = new Label(
                "Xerox Centre: Quick Xerox Centre"
        );

        centre.setStyle(
                "-fx-text-fill: #506078;" +
                "-fx-font-size: 13px;"
        );

        Label printStatus = new Label(
                "Print Status: 2 / 3"
        );

        printStatus.setStyle(
                "-fx-text-fill: #3182F6;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        Label timer = new Label(
                "Session expires in: 12:44"
        );

        timer.setStyle(
                "-fx-text-fill: #E55B5B;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        sessionCard.getChildren().addAll(
                sessionTitle,
                document,
                centre,
                printStatus,
                timer
        );

        // =========================================================
        // BACK BUTTON
        // =========================================================

        Button backDashboard =
                new Button("← Back to Dashboard");

        backDashboard.setStyle(
                "-fx-background-color: #EDF4FF;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: #2878D8;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 9 18 9 18;"
        );

        backDashboard.setOnAction(
                e -> backToDashboard.run()
        );

        // =========================================================
        // ADD CONTENT
        // =========================================================

        mainContent.getChildren().addAll(
                headingBox,
                statusCard,
                sessionCard,
                backDashboard
        );

        // =========================================================
        // SCROLL
        // =========================================================

        ScrollPane scrollPane =
                new ScrollPane(mainContent);

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);

        scrollPane.setStyle(
                "-fx-background-color: #F5FAFE;" +
                "-fx-background: #F5FAFE;"
        );

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        // =========================================================
        // ROOT
        // =========================================================

        root.setTop(topBar);
        root.setLeft(sidebar);
        root.setCenter(scrollPane);

        // =========================================================
        // SCENE
        // =========================================================

        requestStatusScene =
                new Scene(
                        root,
                        1300,
                        700
                );

        return requestStatusScene;
    }

    // =============================================================
    // CREATE STEP
    // =============================================================

    private VBox createStep(
            String number,
            String title,
            String time,
            String state) {

        VBox container =
                new VBox(8);

        container.setAlignment(
                Pos.TOP_CENTER
        );

        // =========================================================
        // CIRCLE
        // =========================================================

        Label circle =
                new Label(number);

        circle.setAlignment(
                Pos.CENTER
        );

        circle.setMinSize(
                46,
                46
        );

        circle.setMaxSize(
                46,
                46
        );

        if (state.equals("completed")) {

            circle.setStyle(
                    "-fx-background-color: #19C99A;" +
                    "-fx-background-radius: 50%;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 16px;" +
                    "-fx-font-weight: bold;"
            );

        } else if (state.equals("active")) {

            circle.setStyle(
                    "-fx-background-color: #3182F6;" +
                    "-fx-background-radius: 50%;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 16px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-effect: dropshadow(gaussian, rgba(49,130,246,0.35), 15, 0.5, 0, 0);"
            );

        } else {

            circle.setStyle(
                    "-fx-background-color: #F1F5F9;" +
                    "-fx-background-radius: 50%;" +
                    "-fx-border-color: #D5DFEA;" +
                    "-fx-border-radius: 50%;" +
                    "-fx-text-fill: #64748B;" +
                    "-fx-font-size: 15px;" +
                    "-fx-font-weight: bold;"
            );
        }

        // =========================================================
        // TITLE
        // =========================================================

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: #182235;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        // =========================================================
        // TIME
        // =========================================================

        Label timeLabel =
                new Label(time);

        timeLabel.setStyle(
                "-fx-text-fill: #718096;" +
                "-fx-font-size: 11px;"
        );

        container.getChildren().addAll(
                circle,
                titleLabel,
                timeLabel
        );

        return container;
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
                "-fx-text-fill: #182235;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 11 15 11 15;"
        );

        button.setOnMouseEntered(e -> {

            if (!button.getStyle().contains("#3182F6")) {

                button.setStyle(
                        "-fx-background-color: #EDF4FF;" +
                        "-fx-background-radius: 20;" +
                        "-fx-text-fill: #2878D8;" +
                        "-fx-font-size: 13px;" +
                        "-fx-padding: 11 15 11 15;"
                );
            }
        });

        button.setOnMouseExited(e -> {

            if (!button.getStyle().contains("#3182F6")) {

                button.setStyle(
                        "-fx-background-color: transparent;" +
                        "-fx-text-fill: #182235;" +
                        "-fx-font-size: 13px;" +
                        "-fx-padding: 11 15 11 15;"
                );
            }
        });

        return button;
    }
}