package com.ciphercore.view.admin;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Documents {

    // =========================================================
    // COLORS - SAME PRIVORA USER THEME
    // =========================================================

    private final String BACKGROUND = "#0B0A0F";
    private final String CARD = "#111722";
    private final String CARD_HOVER = "#171426";
    private final String BORDER = "#262137";

    private final String PURPLE = "#8B5CF6";
    private final String DEEP_PURPLE = "#6D28D9";
    private final String LIGHT_PURPLE = "#A78BFA";

    private final String TEXT = "#F5F3FF";
    private final String SECONDARY = "#9E94AD";

    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public ScrollPane getContent() {

        VBox main = new VBox(24);

        main.setPadding(
                new Insets(35, 40, 40, 40)
        );

        main.setStyle(
                "-fx-background-color: " + BACKGROUND + ";"
        );

        // =====================================================
        // HEADER
        // =====================================================

        Label title = new Label(
                "Document management"
        );

        title.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Monitor documents, sessions and privacy status across PRIVORA."
        );

        subtitle.setStyle(
                "-fx-text-fill: " + SECONDARY + ";" +
                "-fx-font-size: 16px;"
        );

        VBox heading = new VBox(5);

        heading.getChildren().addAll(
                title,
                subtitle
        );

        // =====================================================
        // STATISTICS
        // =====================================================

        HBox stats = new HBox(15);

        VBox totalDocuments =
                createStatCard(
                        "24",
                        "Total Documents",
                        "Uploaded documents"
                );

        VBox activeDocuments =
                createStatCard(
                        "08",
                        "Active",
                        "Currently available"
                );

        VBox printedDocuments =
                createStatCard(
                        "31",
                        "Printed",
                        "Completed prints"
                );

        VBox expiredDocuments =
                createStatCard(
                        "05",
                        "Expired",
                        "Sessions expired"
                );

        HBox.setHgrow(
                totalDocuments,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                activeDocuments,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                printedDocuments,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                expiredDocuments,
                Priority.ALWAYS
        );

        stats.getChildren().addAll(
                totalDocuments,
                activeDocuments,
                printedDocuments,
                expiredDocuments
        );

        // =====================================================
        // DOCUMENT CARD
        // =====================================================

        VBox documentCard = new VBox(18);

        documentCard.setPadding(
                new Insets(25)
        );

        documentCard.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-width: 1;" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;"
        );

        // =====================================================
        // SEARCH
        // =====================================================

        HBox searchRow = new HBox(12);

        searchRow.setAlignment(
                Pos.CENTER_LEFT
        );

        TextField searchField = new TextField();

        searchField.setPromptText(
                "Search documents by name or owner..."
        );

        searchField.setStyle(
                "-fx-background-color: #171D2B;" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #302A43;" +
                "-fx-border-radius: 22;" +
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-prompt-text-fill: #777084;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 11 18 11 18;"
        );

        HBox.setHgrow(
                searchField,
                Priority.ALWAYS
        );

        Button filterButton = new Button(
                "☰   Filter"
        );

        filterButton.setStyle(
                "-fx-background-color: #17131F;" +
                "-fx-border-color: #39304D;" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;" +
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 12px;" +
                "-fx-padding: 10 18;" +
                "-fx-cursor: hand;"
        );

        filterButton.setOnMouseEntered(e -> {

            filterButton.setStyle(
                    "-fx-background-color: #241A32;" +
                    "-fx-border-color: " + PURPLE + ";" +
                    "-fx-border-radius: 20;" +
                    "-fx-background-radius: 20;" +
                    "-fx-text-fill: " + LIGHT_PURPLE + ";" +
                    "-fx-font-size: 12px;" +
                    "-fx-padding: 10 18;" +
                    "-fx-cursor: hand;"
            );
        });

        filterButton.setOnMouseExited(e -> {

            filterButton.setStyle(
                    "-fx-background-color: #17131F;" +
                    "-fx-border-color: #39304D;" +
                    "-fx-border-radius: 20;" +
                    "-fx-background-radius: 20;" +
                    "-fx-text-fill: " + TEXT + ";" +
                    "-fx-font-size: 12px;" +
                    "-fx-padding: 10 18;" +
                    "-fx-cursor: hand;"
            );
        });

        searchRow.getChildren().addAll(
                searchField,
                filterButton
        );

        // =====================================================
        // COLUMN HEADERS
        // =====================================================

        HBox headerRow = new HBox();

        headerRow.setPadding(
                new Insets(8, 15, 8, 15)
        );

        Label documentHeader =
                createHeader("DOCUMENT");

        Label ownerHeader =
                createHeader("OWNER");

        Label centreHeader =
                createHeader("CENTRE");

        Label statusHeader =
                createHeader("STATUS");

        Label uploadedHeader =
                createHeader("UPLOADED");

        Label actionsHeader =
                createHeader("ACTIONS");

        documentHeader.setPrefWidth(220);
        ownerHeader.setPrefWidth(150);
        centreHeader.setPrefWidth(160);
        statusHeader.setPrefWidth(120);
        uploadedHeader.setPrefWidth(130);
        actionsHeader.setPrefWidth(100);

        headerRow.getChildren().addAll(
                documentHeader,
                ownerHeader,
                centreHeader,
                statusHeader,
                uploadedHeader,
                actionsHeader
        );

        // =====================================================
        // SEPARATOR
        // =====================================================

        HBox separator = new HBox();

        separator.setPrefHeight(1);

        separator.setStyle(
                "-fx-background-color: " + BORDER + ";"
        );

        // =====================================================
        // DOCUMENT LIST
        // =====================================================

        VBox documentList = new VBox();

        documentList.setSpacing(0);

        documentList.getChildren().addAll(

                createDocumentRow(
                        "▤",
                        "Aadhaar-Card.pdf",
                        "Aditi Sharma",
                        "Sharma Xerox",
                        "Active",
                        "10:12 AM"
                ),

                createDocumentRow(
                        "▤",
                        "PAN-Card.pdf",
                        "Rahul Verma",
                        "QuickPrint",
                        "Active",
                        "09:45 AM"
                ),

                createDocumentRow(
                        "▤",
                        "College-Documents.pdf",
                        "Priya Nair",
                        "Sharma Xerox",
                        "Printed",
                        "Yesterday"
                ),

                createDocumentRow(
                        "▤",
                        "Passport.pdf",
                        "Aditi Sharma",
                        "QuickPrint",
                        "Active",
                        "Yesterday"
                ),

                createDocumentRow(
                        "▤",
                        "Resume.pdf",
                        "Rahul Verma",
                        "Sharma Xerox",
                        "Expired",
                        "2 days ago"
                ),

                createDocumentRow(
                        "▤",
                        "Application-Form.pdf",
                        "Vikram Deshmukh",
                        "QuickPrint",
                        "Printed",
                        "3 days ago"
                )
        );

        // =====================================================
        // ADD CARD CONTENT
        // =====================================================

        documentCard.getChildren().addAll(
                searchRow,
                headerRow,
                separator,
                documentList
        );

        // =====================================================
        // ADD MAIN CONTENT
        // =====================================================

        main.getChildren().addAll(
                heading,
                stats,
                documentCard
        );

        // =====================================================
        // SCROLL
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
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;" +
                "-fx-border-color: transparent;"
        );

        return scrollPane;
    }

    // =========================================================
    // STAT CARD
    // =========================================================

    private VBox createStatCard(
            String value,
            String title,
            String description) {

        VBox card = new VBox(7);

        card.setPadding(
                new Insets(20)
        );

        card.setMinHeight(
                110
        );

        card.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 18;" +
                "-fx-background-radius: 18;"
        );

        Label valueLabel = new Label(
                value
        );

        valueLabel.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 25px;" +
                "-fx-font-weight: bold;"
        );

        Label titleLabel = new Label(
                title
        );

        titleLabel.setStyle(
                "-fx-text-fill: #D7D0E1;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        Label descriptionLabel = new Label(
                description
        );

        descriptionLabel.setStyle(
                "-fx-text-fill: " + SECONDARY + ";" +
                "-fx-font-size: 10px;"
        );

        card.getChildren().addAll(
                valueLabel,
                titleLabel,
                descriptionLabel
        );

        return card;
    }

    // =========================================================
    // DOCUMENT ROW
    // =========================================================

    private HBox createDocumentRow(
            String icon,
            String documentName,
            String owner,
            String centre,
            String status,
            String uploaded) {

        HBox row = new HBox();

        row.setMinHeight(
                78
        );

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(10, 15, 10, 15)
        );

        row.setStyle(
                "-fx-background-color: transparent;"
        );

        // =====================================================
        // DOCUMENT
        // =====================================================

        Label iconLabel = new Label(
                icon
        );

        iconLabel.setAlignment(
                Pos.CENTER
        );

        iconLabel.setMinSize(
                38,
                38
        );

        iconLabel.setMaxSize(
                38,
                38
        );

        iconLabel.setStyle(
                "-fx-background-color: #2B2040;" +
                "-fx-background-radius: 11;" +
                "-fx-text-fill: " + LIGHT_PURPLE + ";" +
                "-fx-font-size: 15px;"
        );

        Label documentLabel =
                new Label(documentName);

        documentLabel.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        VBox documentInfo =
                new VBox(
                        documentLabel
                );

        HBox documentBox =
                new HBox(
                        12,
                        iconLabel,
                        documentInfo
                );

        documentBox.setAlignment(
                Pos.CENTER_LEFT
        );

        documentBox.setPrefWidth(
                220
        );

        // =====================================================
        // OWNER
        // =====================================================

        Label ownerLabel =
                new Label(owner);

        ownerLabel.setStyle(
                "-fx-text-fill: #C5BDCE;" +
                "-fx-font-size: 11px;"
        );

        ownerLabel.setPrefWidth(
                150
        );

        // =====================================================
        // CENTRE
        // =====================================================

        Label centreLabel =
                new Label(centre);

        centreLabel.setStyle(
                "-fx-text-fill: " + SECONDARY + ";" +
                "-fx-font-size: 11px;"
        );

        centreLabel.setPrefWidth(
                160
        );

        // =====================================================
        // STATUS
        // =====================================================

        Label statusLabel =
                new Label(status);

        if (status.equals("Active")) {

            statusLabel.setStyle(
                    "-fx-background-color: #17352F;" +
                    "-fx-background-radius: 14;" +
                    "-fx-text-fill: #4ADE80;" +
                    "-fx-font-size: 10px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 6 12;"
            );

        } else if (status.equals("Printed")) {

            statusLabel.setStyle(
                    "-fx-background-color: #29213B;" +
                    "-fx-background-radius: 14;" +
                    "-fx-text-fill: " + LIGHT_PURPLE + ";" +
                    "-fx-font-size: 10px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 6 12;"
            );

        } else {

            statusLabel.setStyle(
                    "-fx-background-color: #292735;" +
                    "-fx-background-radius: 14;" +
                    "-fx-text-fill: #9CA3AF;" +
                    "-fx-font-size: 10px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 6 12;"
            );
        }

        HBox statusBox =
                new HBox(statusLabel);

        statusBox.setPrefWidth(
                120
        );

        statusBox.setAlignment(
                Pos.CENTER_LEFT
        );

        // =====================================================
        // UPLOADED
        // =====================================================

        Label uploadedLabel =
                new Label(uploaded);

        uploadedLabel.setStyle(
                "-fx-text-fill: " + SECONDARY + ";" +
                "-fx-font-size: 10px;"
        );

        uploadedLabel.setPrefWidth(
                130
        );

        // =====================================================
        // ACTIONS
        // =====================================================

        Button viewButton =
                new Button("◉");

        Button deleteButton =
                new Button("⌫");

        styleActionButton(
                viewButton,
                LIGHT_PURPLE
        );

        styleActionButton(
                deleteButton,
                "#EF6B73"
        );

        viewButton.setOnAction(e ->
                showMessage(
                        "View Document",
                        "Viewing: " + documentName
                )
        );

        deleteButton.setOnAction(e ->
                showMessage(
                        "Delete Document",
                        "Delete action for: " + documentName
                )
        );

        HBox actions =
                new HBox(
                        8,
                        viewButton,
                        deleteButton
                );

        actions.setPrefWidth(
                100
        );

        actions.setAlignment(
                Pos.CENTER_LEFT
        );

        // =====================================================
        // ADD ROW
        // =====================================================

        row.getChildren().addAll(
                documentBox,
                ownerLabel,
                centreLabel,
                statusBox,
                uploadedLabel,
                actions
        );

        // =====================================================
        // HOVER
        // =====================================================

        row.setOnMouseEntered(e -> {

            row.setStyle(
                    "-fx-background-color: " + CARD_HOVER + ";" +
                    "-fx-background-radius: 12;"
            );
        });

        row.setOnMouseExited(e -> {

            row.setStyle(
                    "-fx-background-color: transparent;"
            );
        });

        return row;
    }

    // =========================================================
    // HEADER
    // =========================================================

    private Label createHeader(
            String text) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-text-fill: #81758F;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        return label;
    }

    // =========================================================
    // ACTION BUTTON
    // =========================================================

    private void styleActionButton(
            Button button,
            String textColor) {

        button.setMinSize(
                32,
                32
        );

        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + textColor + ";" +
                "-fx-font-size: 16px;" +
                "-fx-padding: 4;" +
                "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e -> {

            button.setStyle(
                    "-fx-background-color: #241A32;" +
                    "-fx-background-radius: 10;" +
                    "-fx-text-fill: " + textColor + ";" +
                    "-fx-font-size: 16px;" +
                    "-fx-padding: 4;" +
                    "-fx-cursor: hand;"
            );
        });

        button.setOnMouseExited(e -> {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: " + textColor + ";" +
                    "-fx-font-size: 16px;" +
                    "-fx-padding: 4;" +
                    "-fx-cursor: hand;"
            );
        });
    }

    // =========================================================
    // MESSAGE
    // =========================================================

    private void showMessage(
            String title,
            String message) {

        Alert alert =
                new Alert(
                        Alert.AlertType.INFORMATION
                );

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}