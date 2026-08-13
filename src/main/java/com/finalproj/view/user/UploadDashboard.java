package com.finalproj.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class UploadDashboard {

    private Scene uploadScene;

    public Scene getUploadScene(Runnable backToDashboard) {

        // =========================================================
        // MAIN ROOT
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

        Label pageTitle = new Label(
                "Upload Document"
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

        Button backButton = new Button(
                "← Dashboard"
        );

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

        sidebar.setPrefWidth(210);

        sidebar.setStyle(
                "-fx-background-color: rgba(5,15,32,0.9);" +
                "-fx-border-color: #172942;"
        );

        Label menuTitle = new Label(
                "DOCUMENT"
        );

        menuTitle.setStyle(
                "-fx-text-fill: #64758D;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        Button uploadButton =
                createMenuButton(
                        "Upload Document"
                );

        Button documentsButton =
                createMenuButton(
                        "My Documents"
                );

        Button activityButton =
                createMenuButton(
                        "Activity"
                );

        Button profileButton =
                createMenuButton(
                        "Profile"
                );

        sidebar.getChildren().addAll(
                menuTitle,
                uploadButton,
                documentsButton,
                activityButton,
                profileButton
        );

        // =========================================================
        // MAIN CONTENT
        // =========================================================

        VBox content = new VBox(18);

        content.setPadding(
                new Insets(30)
        );

        // =========================================================
        // HEADING
        // =========================================================

        Label heading = new Label(
                "Create Secure Document Session"
        );

        heading.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 27px;" +
                "-fx-font-weight: bold;"
        );

        Label description = new Label(
                "Upload your document and define exactly how it can be accessed."
        );

        description.setStyle(
                "-fx-text-fill: #8291A7;" +
                "-fx-font-size: 13px;"
        );

        // =========================================================
        // UPLOAD AREA
        // =========================================================

        VBox uploadArea = new VBox(12);

        uploadArea.setAlignment(
                Pos.CENTER
        );

        uploadArea.setPadding(
                new Insets(30)
        );

        uploadArea.setPrefHeight(
                180
        );

        uploadArea.setStyle(
                "-fx-background-color: #091428;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #263B58;" +
                "-fx-border-radius: 20;"
        );

        Label uploadIcon = new Label(
                "↑"
        );

        uploadIcon.setStyle(
                "-fx-background-color: #10294A;" +
                "-fx-background-radius: 50%;" +
                "-fx-text-fill: #39A5FF;" +
                "-fx-font-size: 25px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 16 10 16;"
        );

        Label uploadTitle = new Label(
                "Upload your document"
        );

        uploadTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );

        Label uploadDescription = new Label(
                "PDF, DOCX, JPG or PNG • Maximum 10 MB"
        );

        uploadDescription.setStyle(
                "-fx-text-fill: #73849A;" +
                "-fx-font-size: 11px;"
        );

        Button chooseFileButton =
                new Button("Choose File");

        chooseFileButton.setStyle(
                "-fx-background-color: linear-gradient(to right, #2188FF, #19B5F1);" +
                "-fx-background-radius: 18;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 9 20 9 20;"
        );

        Label selectedFile =
                new Label("No file selected");

        selectedFile.setStyle(
                "-fx-text-fill: #8999AF;" +
                "-fx-font-size: 11px;"
        );

        chooseFileButton.setOnAction(e -> {

            FileChooser fileChooser =
                    new FileChooser();

            fileChooser.setTitle(
                    "Select Document"
            );

            fileChooser.getExtensionFilters().addAll(

                    new FileChooser.ExtensionFilter(
                            "Supported Files",
                            "*.pdf",
                            "*.docx",
                            "*.jpg",
                            "*.jpeg",
                            "*.png"
                    )
            );

            Stage stage =
                    (Stage) chooseFileButton
                            .getScene()
                            .getWindow();

            java.io.File file =
                    fileChooser.showOpenDialog(stage);

            if (file != null) {

                selectedFile.setText(
                        "Selected: " +
                        file.getName()
                );

                selectedFile.setStyle(
                        "-fx-text-fill: #19D6A3;" +
                        "-fx-font-size: 11px;"
                );

                System.out.println(
                        "File selected: " +
                        file.getAbsolutePath()
                );
            }
        });

        uploadArea.getChildren().addAll(
                uploadIcon,
                uploadTitle,
                uploadDescription,
                chooseFileButton,
                selectedFile
        );

        // =========================================================
        // SECURITY SETTINGS
        // =========================================================

        HBox settingsBox = new HBox(15);

        // ---------------------------------------------------------
        // ACCESS SETTINGS
        // ---------------------------------------------------------

        VBox accessCard =
                createSettingsCard();

        Label accessTitle =
                createSectionTitle(
                        "Access Rules"
                );

        Label expiryLabel =
                createSmallLabel(
                        "Document expiry"
                );

        ComboBox<String> expiryBox =
                new ComboBox<>();

        expiryBox.getItems().addAll(
                "5 minutes",
                "15 minutes",
                "30 minutes",
                "1 hour",
                "24 hours"
        );

        expiryBox.setValue(
                "30 minutes"
        );

        styleComboBox(expiryBox);

        Label printLabel =
                createSmallLabel(
                        "Print limit"
                );

        Spinner<Integer> printSpinner =
                new Spinner<>(
                        1,
                        20,
                        3
                );

        printSpinner.setMaxWidth(
                Double.MAX_VALUE
        );

        accessCard.getChildren().addAll(
                accessTitle,
                expiryLabel,
                expiryBox,
                printLabel,
                printSpinner
        );

        // ---------------------------------------------------------
        // PRIVACY SETTINGS
        // ---------------------------------------------------------

        VBox privacyCard =
                createSettingsCard();

        Label privacyTitle =
                createSectionTitle(
                        "Privacy Protection"
                );

        CheckBox watermark =
                new CheckBox(
                        "Add watermark"
                );

        watermark.setSelected(true);

        styleCheckBox(watermark);

        CheckBox preventDownload =
                new CheckBox(
                        "Prevent download"
                );

        preventDownload.setSelected(true);

        styleCheckBox(preventDownload);

        CheckBox privacyScan =
                new CheckBox(
                        "AI privacy scan"
                );

        privacyScan.setSelected(true);

        styleCheckBox(privacyScan);

        privacyCard.getChildren().addAll(
                privacyTitle,
                watermark,
                preventDownload,
                privacyScan
        );

        HBox.setHgrow(
                accessCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                privacyCard,
                Priority.ALWAYS
        );

        settingsBox.getChildren().addAll(
                accessCard,
                privacyCard
        );

        // =========================================================
        // STATUS MESSAGE
        // =========================================================

        Label statusLabel =
                new Label();

        statusLabel.setStyle(
                "-fx-text-fill: #FF6B6B;" +
                "-fx-font-size: 12px;"
        );

        // =========================================================
        // CREATE SESSION BUTTON
        // =========================================================

        Button createSession =
                new Button(
                        "Create Secure Session  →"
                );

        createSession.setMaxWidth(
                Double.MAX_VALUE
        );

        createSession.setStyle(
                "-fx-background-color: linear-gradient(to right, #2188FF, #19B5F1);" +
                "-fx-background-radius: 20;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 12 20 12 20;" +
                "-fx-effect: dropshadow(gaussian, rgba(33,136,255,0.45), 20, 0.5, 0, 4);"
        );

        createSession.setOnAction(e -> {

            System.out.println(
                    "Create Secure Session clicked"
            );

            if (selectedFile.getText()
                    .equals("No file selected")) {

                statusLabel.setStyle(
                        "-fx-text-fill: #FF6B6B;" +
                        "-fx-font-size: 12px;"
                );

                statusLabel.setText(
                        "Please select a document first."
                );

                return;
            }

            statusLabel.setStyle(
                    "-fx-text-fill: #19D6A3;" +
                    "-fx-font-size: 12px;"
            );

            statusLabel.setText(
                    "Secure session created successfully!"
            );

            System.out.println(
                    "Expiry: " +
                    expiryBox.getValue()
            );

            System.out.println(
                    "Print limit: " +
                    printSpinner.getValue()
            );

            System.out.println(
                    "Watermark: " +
                    watermark.isSelected()
            );

            System.out.println(
                    "Prevent Download: " +
                    preventDownload.isSelected()
            );

            System.out.println(
                    "AI Scan: " +
                    privacyScan.isSelected()
            );

            /*
             * Firebase/API connection
             * will be added here later.
             */
        });

        // =========================================================
        // ADD CONTENT
        // =========================================================

        content.getChildren().addAll(
                heading,
                description,
                uploadArea,
                settingsBox,
                statusLabel,
                createSession
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

        uploadScene =
                new Scene(
                        root,
                        1300,
                        700
                );

        return uploadScene;
    }

    // =============================================================
    // SETTINGS CARD
    // =============================================================

    private VBox createSettingsCard() {

        VBox card =
                new VBox(12);

        card.setPadding(
                new Insets(20)
        );

        card.setPrefHeight(
                190
        );

        card.setStyle(
                "-fx-background-color: #091428;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 18;"
        );

        return card;
    }

    // =============================================================
    // SECTION TITLE
    // =============================================================

    private Label createSectionTitle(
            String text) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;"
        );

        return label;
    }

    // =============================================================
    // SMALL LABEL
    // =============================================================

    private Label createSmallLabel(
            String text) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-text-fill: #8291A7;" +
                "-fx-font-size: 11px;"
        );

        return label;
    }

    // =============================================================
    // COMBO BOX STYLE
    // =============================================================

    private void styleComboBox(
            ComboBox<String> comboBox) {

        comboBox.setMaxWidth(
                Double.MAX_VALUE
        );

        comboBox.setStyle(
                "-fx-background-color: #071226;" +
                "-fx-background-radius: 15;" +
                "-fx-border-color: #24354E;" +
                "-fx-border-radius: 15;" +
                "-fx-text-fill: white;"
        );
    }

    // =============================================================
    // CHECKBOX STYLE
    // =============================================================

    private void styleCheckBox(
            CheckBox checkBox) {

        checkBox.setStyle(
                "-fx-text-fill: #B8C5D6;" +
                "-fx-font-size: 12px;"
        );
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