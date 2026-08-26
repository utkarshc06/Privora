package com.ciphercore.view.user;

import java.io.File;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

public class UploadDocument {

    // =========================================================
    // COLORS
    // =========================================================

    private final String BACKGROUND = "#0B0A0F";
    private final String CARD = "#15131F";
    private final String CARD_BORDER = "#2A2538";

    private final String PURPLE = "#8B5CF6";
    private final String DEEP_PURPLE = "#6D28D9";
    private final String BLUE = "#3B82F6";

    private final String TEXT = "#F5F3FF";
    private final String SECONDARY_TEXT = "#9D96B5";


    // =========================================================
    // USER DASHBOARD REFERENCE
    // =========================================================

    private final UserDashboard dashboard;


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public UploadDocument(UserDashboard dashboard) {

        this.dashboard = dashboard;

    }


    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public ScrollPane getContent() {

        VBox main = new VBox(24);

        main.setPadding(
                new Insets(28, 35, 40, 35)
        );

        main.setStyle(
                "-fx-background-color: " + BACKGROUND + ";"
        );


        // =====================================================
        // PAGE HEADER
        // =====================================================

        VBox header = new VBox(5);


        Label title = new Label(
                "Upload document"
        );

        title.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );


        Label subtitle = new Label(
                "Upload a document securely to PRIVORA."
        );

        subtitle.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 14px;"
        );


        header.getChildren().addAll(
                title,
                subtitle
        );


        // =====================================================
        // UPLOAD CARD
        // =====================================================

        VBox uploadCard = new VBox(20);

        uploadCard.setPadding(
                new Insets(25)
        );

        uploadCard.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + CARD_BORDER + ";" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;"
        );


        // =====================================================
        // DROP AREA
        // =====================================================

        VBox dropArea = new VBox(12);

        dropArea.setAlignment(
                Pos.CENTER
        );

        dropArea.setMinHeight(250);

        dropArea.setMaxWidth(
                Double.MAX_VALUE
        );

        dropArea.setStyle(
                "-fx-background-color: #111827;" +
                "-fx-border-color: #3B4A68;" +
                "-fx-border-width: 2;" +
                "-fx-border-style: dashed;" +
                "-fx-border-radius: 18;" +
                "-fx-background-radius: 18;"
        );


        // =====================================================
        // UPLOAD ICON
        // =====================================================

        Label uploadIcon = new Label(
                "⇧"
        );

        uploadIcon.setAlignment(
                Pos.CENTER
        );

        uploadIcon.setMinSize(
                65,
                65
        );

        uploadIcon.setStyle(
                "-fx-background-color: linear-gradient(to right, "
                        + BLUE + ", #06B6D4);" +
                "-fx-background-radius: 18;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;"
        );


        // =====================================================
        // DROP TEXT
        // =====================================================

        Label dropText = new Label(
                "Drop your file here"
        );

        dropText.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );


        Label browseText = new Label(
                "or browse to upload • PDF, JPG, PNG up to 20MB"
        );

        browseText.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 13px;"
        );


        // =====================================================
        // CHOOSE FILE BUTTON
        // =====================================================

        Button chooseFileButton = new Button(
                "Choose File"
        );

        chooseFileButton.setStyle(
                "-fx-background-color: linear-gradient(to right, "
                        + BLUE + ", #06B6D4);" +
                "-fx-background-radius: 22;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 11 25 11 25;" +
                "-fx-cursor: hand;"
        );


        // =====================================================
        // SELECTED FILE LABEL
        // =====================================================

        Label selectedFile = new Label(
                "No file selected"
        );

        selectedFile.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 13px;"
        );


        // =====================================================
        // FILE CHOOSER
        // =====================================================

        chooseFileButton.setOnAction(e -> {

            FileChooser fileChooser =
                    new FileChooser();

            fileChooser.setTitle(
                    "Select Document"
            );


            FileChooser.ExtensionFilter filter =
                    new FileChooser.ExtensionFilter(
                            "Supported Files (*.pdf, *.jpg, *.jpeg, *.png)",
                            "*.pdf",
                            "*.jpg",
                            "*.jpeg",
                            "*.png"
                    );


            fileChooser.getExtensionFilters()
                    .add(filter);


            File file =
                    fileChooser.showOpenDialog(
                            chooseFileButton.getScene()
                                    .getWindow()
                    );


            if (file != null) {

                selectedFile.setText(
                        "Selected: " + file.getName()
                );

                selectedFile.setStyle(
                        "-fx-text-fill: #A78BFA;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;"
                );

            }

        });


        // =====================================================
        // DROP AREA CLICK
        // =====================================================

        dropArea.setOnMouseClicked(e -> {

            chooseFileButton.fire();

        });


        dropArea.getChildren().addAll(
                uploadIcon,
                dropText,
                browseText,
                chooseFileButton,
                selectedFile
        );


        // =====================================================
        // DOCUMENT DETAILS
        // =====================================================

        VBox detailsCard = new VBox(18);

        detailsCard.setPadding(
                new Insets(25)
        );

        detailsCard.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + CARD_BORDER + ";" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;"
        );


        Label detailsTitle = new Label(
                "Document details"
        );

        detailsTitle.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );


        // =====================================================
        // DOCUMENT NAME
        // =====================================================

        Label nameLabel = new Label(
                "Document name"
        );

        nameLabel.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );


        TextField documentName =
                new TextField();

        documentName.setPromptText(
                "Enter document name"
        );

        documentName.setStyle(
                "-fx-background-color: #11101A;" +
                "-fx-border-color: #29243A;" +
                "-fx-border-radius: 14;" +
                "-fx-background-radius: 14;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #756A86;" +
                "-fx-padding: 12 15 12 15;" +
                "-fx-font-size: 14px;"
        );


        // =====================================================
        // DESCRIPTION
        // =====================================================

        Label descriptionLabel = new Label(
                "Description"
        );

        descriptionLabel.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );


        TextArea description =
                new TextArea();

        description.setPromptText(
                "Optional note for the print shop..."
        );

        description.setPrefRowCount(3);

        description.setWrapText(true);

        description.setStyle(
                "-fx-control-inner-background: #11101A;" +
                "-fx-background-color: #11101A;" +
                "-fx-border-color: #29243A;" +
                "-fx-border-radius: 14;" +
                "-fx-background-radius: 14;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #756A86;" +
                "-fx-font-size: 14px;"
        );


        // =====================================================
        // CATEGORY
        // =====================================================

        Label categoryLabel = new Label(
                "Category"
        );

        categoryLabel.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );


        HBox categoryRow1 =
                new HBox(10);

        HBox categoryRow2 =
                new HBox(10);


        Button idProof =
                createCategoryButton(
                        "ID Proof"
                );

        Button certificate =
                createCategoryButton(
                        "Certificate"
                );

        Button form =
                createCategoryButton(
                        "Form"
                );

        Button other =
                createCategoryButton(
                        "Other"
                );


        HBox.setHgrow(
                idProof,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                certificate,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                form,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                other,
                Priority.ALWAYS
        );


        categoryRow1.getChildren().addAll(
                idProof,
                certificate
        );

        categoryRow2.getChildren().addAll(
                form,
                other
        );


        // =====================================================
        // CATEGORY SELECTION
        // =====================================================

        idProof.setOnAction(e -> {

            selectCategory(
                    idProof,
                    certificate,
                    form,
                    other
            );

        });


        certificate.setOnAction(e -> {

            selectCategory(
                    certificate,
                    idProof,
                    form,
                    other
            );

        });


        form.setOnAction(e -> {

            selectCategory(
                    form,
                    idProof,
                    certificate,
                    other
            );

        });


        other.setOnAction(e -> {

            selectCategory(
                    other,
                    idProof,
                    certificate,
                    form
            );

        });


        // ID Proof selected by default

        selectCategory(
                idProof,
                certificate,
                form,
                other
        );


        // =====================================================
        // CONTINUE BUTTON
        // =====================================================

        Button continueButton =
                new Button(
                        "Continue     →"
                );

        continueButton.setMaxWidth(
                Double.MAX_VALUE
        );

        continueButton.setPrefHeight(
                50
        );

        continueButton.setStyle(
                "-fx-background-color: linear-gradient(to right, "
                        + BLUE + ", #06B6D4);" +
                "-fx-background-radius: 15;" +
                "-fx-text-fill: #06111F;" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );


        // =====================================================
        // CONTINUE ACTION
        // =====================================================

        continueButton.setOnAction(e -> {

            if (dashboard != null) {

                dashboard.openPurposePage();

            }

        });


        // =====================================================
        // ADD DETAILS
        // =====================================================

        detailsCard.getChildren().addAll(

                detailsTitle,

                nameLabel,
                documentName,

                descriptionLabel,
                description,

                categoryLabel,

                categoryRow1,
                categoryRow2,

                continueButton

        );


        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        uploadCard.getChildren().add(
                dropArea
        );


        main.getChildren().addAll(
                header,
                uploadCard,
                detailsCard
        );


        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane(main);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle(
                "-fx-background-color: " + BACKGROUND + ";" +
                "-fx-background: " + BACKGROUND + ";"
        );


        return scrollPane;
    }


    // =========================================================
    // CATEGORY BUTTON
    // =========================================================

    private Button createCategoryButton(
            String text) {

        Button button =
                new Button(text);

        button.setMaxWidth(
                Double.MAX_VALUE
        );

        button.setPrefHeight(
                42
        );

        button.setStyle(
                "-fx-background-color: #11101A;" +
                "-fx-border-color: #29243A;" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;" +
                "-fx-text-fill: #D8D2E2;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );


        return button;
    }


    // =========================================================
    // SELECT CATEGORY
    // =========================================================

    private void selectCategory(
            Button selected,
            Button other1,
            Button other2,
            Button other3) {


        selected.setStyle(
                "-fx-background-color: #111827;" +
                "-fx-border-color: #3B82F6;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;" +
                "-fx-text-fill: #60A5FA;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );


        setNormalCategory(other1);
        setNormalCategory(other2);
        setNormalCategory(other3);
    }


    // =========================================================
    // NORMAL CATEGORY
    // =========================================================

    private void setNormalCategory(
            Button button) {

        button.setStyle(
                "-fx-background-color: #11101A;" +
                "-fx-border-color: #29243A;" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;" +
                "-fx-text-fill: #D8D2E2;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );
    }
}