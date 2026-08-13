package com.finalproj.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyDocuments {

    private Scene documentsScene;

    public Scene getDocumentsScene(Runnable backToDashboard) {

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

        topBar.setAlignment(
                Pos.CENTER_LEFT
        );

        Label logo = new Label("PRIVORA");

        logo.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );

        Label pageTitle = new Label(
                "My Documents"
        );

        pageTitle.setStyle(
                "-fx-text-fill: #8C9BB0;" +
                "-fx-font-size: 13px;"
        );

        HBox titleBox = new HBox(
                15,
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
                "-fx-text-fill: white;" +
                "-fx-padding: 8 18 8 18;"
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
        // SIDEBAR
        // =========================================================

        VBox sidebar = new VBox(12);

        sidebar.setPadding(
                new Insets(25, 15, 25, 15)
        );

        sidebar.setPrefWidth(
                210
        );

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

        HBox headingBox = new HBox();

        headingBox.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox headingText = new VBox(5);

        Label heading =
                new Label("My Documents");

        heading.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;"
        );

        Label description =
                new Label(
                        "Manage your secure document sessions."
                );

        description.setStyle(
                "-fx-text-fill: #8291A7;" +
                "-fx-font-size: 13px;"
        );

        headingText.getChildren().addAll(
                heading,
                description
        );

        HBox.setHgrow(
                headingText,
                Priority.ALWAYS
        );

        Button uploadButtonTop =
                new Button("+ Upload Document");

        uploadButtonTop.setStyle(
                "-fx-background-color: linear-gradient(to right, #2188FF, #19B5F1);" +
                "-fx-background-radius: 18;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 18 10 18;"
        );

        headingBox.getChildren().addAll(
                headingText,
                uploadButtonTop
        );

        // =========================================================
        // SEARCH BAR
        // =========================================================

        TextField searchField =
                new TextField();

        searchField.setPromptText(
                "Search documents..."
        );

        searchField.setStyle(
                "-fx-background-color: #071226;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #24354E;" +
                "-fx-border-radius: 18;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #66758A;" +
                "-fx-padding: 10 15 10 15;"
        );

        // =========================================================
        // FILTER
        // =========================================================

        ComboBox<String> filterBox =
                new ComboBox<>();

        filterBox.getItems().addAll(
                "All Documents",
                "Active",
                "Expired"
        );

        filterBox.setValue(
                "All Documents"
        );

        filterBox.setStyle(
                "-fx-background-color: #071226;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #24354E;" +
                "-fx-border-radius: 18;" +
                "-fx-text-fill: white;"
        );

        HBox searchBox =
                new HBox(
                        12,
                        searchField,
                        filterBox
                );

        HBox.setHgrow(
                searchField,
                Priority.ALWAYS
        );

        // =========================================================
        // DOCUMENT LIST
        // =========================================================

        VBox documentList =
                new VBox(12);

        // =========================================================
        // SAMPLE DOCUMENTS
        // =========================================================

        VBox document1 =
                createDocumentCard(
                        "Aadhaar-Card.pdf",
                        "Active",
                        "12 minutes left",
                        "Print 2 / 3",
                        true
                );

        VBox document2 =
                createDocumentCard(
                        "PAN-Card.pdf",
                        "Active",
                        "42 minutes left",
                        "Print 1 / 2",
                        true
                );

        VBox document3 =
                createDocumentCard(
                        "College-ID.pdf",
                        "Expired",
                        "Expired",
                        "Print 3 / 3",
                        false
                );

        documentList.getChildren().addAll(
                document1,
                document2,
                document3
        );

        // =========================================================
        // SEARCH FUNCTION
        // =========================================================

        searchField.textProperty().addListener(
                (observable, oldValue, newValue) -> {

                    String search =
                            newValue.toLowerCase();

                    document1.setVisible(
                            "Aadhaar-Card.pdf"
                                    .toLowerCase()
                                    .contains(search)
                    );

                    document2.setVisible(
                            "PAN-Card.pdf"
                                    .toLowerCase()
                                    .contains(search)
                    );

                    document3.setVisible(
                            "College-ID.pdf"
                                    .toLowerCase()
                                    .contains(search)
                    );
                }
        );

        // =========================================================
        // ADD CONTENT
        // =========================================================

        content.getChildren().addAll(
                headingBox,
                searchBox,
                documentList
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

        documentsScene =
                new Scene(
                        root,
                        1300,
                        700
                );

        return documentsScene;
    }

    // =============================================================
    // DOCUMENT CARD
    // =============================================================

    private VBox createDocumentCard(
            String fileName,
            String status,
            String expiry,
            String printLimit,
            boolean active) {

        HBox card =
                new HBox(15);

        card.setPadding(
                new Insets(18)
        );

        card.setAlignment(
                Pos.CENTER_LEFT
        );

        card.setStyle(
                "-fx-background-color: #091428;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 18;"
        );

        // =========================================================
        // FILE ICON
        // =========================================================

        Label fileIcon =
                new Label("▣");

        fileIcon.setStyle(
                "-fx-background-color: #10294A;" +
                "-fx-background-radius: 12;" +
                "-fx-text-fill: #39A5FF;" +
                "-fx-font-size: 20px;" +
                "-fx-padding: 10 13 10 13;"
        );

        // =========================================================
        // FILE INFORMATION
        // =========================================================

        VBox fileInfo =
                new VBox(4);

        Label name =
                new Label(fileName);

        name.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        Label security =
                new Label(
                        "Secure document session"
                );

        security.setStyle(
                "-fx-text-fill: #718198;" +
                "-fx-font-size: 11px;"
        );

        fileInfo.getChildren().addAll(
                name,
                security
        );

        // =========================================================
        // STATUS
        // =========================================================

        Label statusLabel =
                new Label(status);

        if (active) {

            statusLabel.setStyle(
                    "-fx-background-color: rgba(19,214,163,0.15);" +
                    "-fx-background-radius: 15;" +
                    "-fx-text-fill: #19D6A3;" +
                    "-fx-padding: 6 12 6 12;" +
                    "-fx-font-size: 11px;"
            );

        } else {

            statusLabel.setStyle(
                    "-fx-background-color: rgba(255,107,107,0.15);" +
                    "-fx-background-radius: 15;" +
                    "-fx-text-fill: #FF6B6B;" +
                    "-fx-padding: 6 12 6 12;" +
                    "-fx-font-size: 11px;"
            );
        }

        // =========================================================
        // EXPIRY
        // =========================================================

        Label expiryLabel =
                new Label(
                        "⏱ " + expiry
                );

        expiryLabel.setStyle(
                "-fx-text-fill: #9AA9BE;" +
                "-fx-font-size: 11px;"
        );

        // =========================================================
        // PRINT
        // =========================================================

        Label printLabel =
                new Label(
                        "🖨 " + printLimit
                );

        printLabel.setStyle(
                "-fx-text-fill: #9AA9BE;" +
                "-fx-font-size: 11px;"
        );

        VBox sessionInfo =
                new VBox(
                        6,
                        statusLabel,
                        expiryLabel,
                        printLabel
                );

        // =========================================================
        // ACTION BUTTONS
        // =========================================================

        Button viewButton =
                new Button("View");

        viewButton.setStyle(
                "-fx-background-color: #0E1D33;" +
                "-fx-background-radius: 12;" +
                "-fx-text-fill: #4CA8FF;" +
                "-fx-padding: 7 13 7 13;"
        );

        viewButton.setOnAction(e -> {

            System.out.println(
                    "View clicked: " +
                    fileName
            );
        });

        Button deleteButton =
                new Button("Delete");

        deleteButton.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: #FF6B6B;" +
                "-fx-padding: 7 10 7 10;"
        );

        deleteButton.setOnAction(e -> {

            System.out.println(
                    "Delete clicked: " +
                    fileName
            );
        });

        HBox actions =
                new HBox(
                        5,
                        viewButton,
                        deleteButton
                );

        actions.setAlignment(
                Pos.CENTER_RIGHT
        );

        HBox.setHgrow(
                fileInfo,
                Priority.ALWAYS
        );

        card.getChildren().addAll(
                fileIcon,
                fileInfo,
                sessionInfo,
                actions
        );

        VBox wrapper =
                new VBox(card);

        return wrapper;
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