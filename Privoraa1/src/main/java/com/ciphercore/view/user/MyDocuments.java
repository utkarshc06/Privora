package com.ciphercore.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyDocuments {

    // =========================================================
    // COLORS - PRIVORA PURPLE / VIOLET THEME
    // =========================================================

    private final String BACKGROUND = "#0B0A0F";
    private final String CARD = "#15131F";
    private final String CARD_BORDER = "#29243A";

    private final String PURPLE = "#8B5CF6";
    private final String DEEP_PURPLE = "#6D28D9";
    private final String LIGHT_PURPLE = "#A78BFA";

    private final String TEXT = "#F5F3FF";
    private final String SECONDARY_TEXT = "#9D96B5";


    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public ScrollPane getContent() {

        VBox main = new VBox(22);

        main.setPadding(
                new Insets(28, 38, 40, 38)
        );

        main.setStyle(
                "-fx-background-color: " + BACKGROUND + ";"
        );


        // =====================================================
        // PAGE HEADER
        // =====================================================

        VBox header = new VBox(5);


        Label title = new Label(
                "My documents"
        );

        title.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );


        Label subtitle = new Label(
                "All documents you've ever shared."
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
        // DOCUMENT CARD
        // =====================================================

        VBox documentCard = new VBox();

        documentCard.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + CARD_BORDER + ";" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;"
        );


        // =====================================================
        // TABLE HEADER
        // =====================================================

        HBox tableHeader =
                createTableHeader();


        // =====================================================
        // HEADER SEPARATOR
        // =====================================================

        HBox headerSeparator =
                createSeparator();


        // =====================================================
        // DOCUMENT LIST
        // =====================================================

        VBox documentList =
                new VBox();


        documentList.getChildren().addAll(

                createDocumentRow(
                        "Aadhaar-Card.pdf",
                        "Printing",
                        "Active",
                        "Today, 10:12 AM"
                ),

                createDocumentRow(
                        "PAN-Form.pdf",
                        "Verification",
                        "Completed",
                        "Yesterday"
                ),

                createDocumentRow(
                        "Marksheet.pdf",
                        "Submission",
                        "Expired",
                        "2 days ago"
                ),

                createDocumentRow(
                        "Passport-Copy.pdf",
                        "Verification",
                        "Pending",
                        "3 days ago"
                ),

                createDocumentRow(
                        "Rental-Agreement.pdf",
                        "Submission",
                        "Completed",
                        "Last week"
                )
        );


        documentCard.getChildren().addAll(
                tableHeader,
                headerSeparator,
                documentList
        );


        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        main.getChildren().addAll(
                header,
                documentCard
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
                "-fx-background: " + BACKGROUND + ";" +
                "-fx-border-color: transparent;"
        );


        return scrollPane;
    }


    // =========================================================
    // TABLE HEADER
    // =========================================================

    private HBox createTableHeader() {

        HBox header =
                new HBox();


        header.setAlignment(
                Pos.CENTER_LEFT
        );

        header.setPadding(
                new Insets(20, 25, 16, 25)
        );


        Label document =
                createHeaderLabel("DOCUMENT");


        Label purpose =
                createHeaderLabel("PURPOSE");


        Label status =
                createHeaderLabel("STATUS");


        Label date =
                createHeaderLabel("DATE");


        Label actions =
                createHeaderLabel("ACTIONS");


        // =====================================================
        // COLUMN WIDTHS
        // =====================================================

        document.setPrefWidth(240);

        purpose.setPrefWidth(125);

        status.setPrefWidth(135);

        date.setPrefWidth(155);

        actions.setPrefWidth(100);


        header.getChildren().addAll(
                document,
                purpose,
                status,
                date,
                actions
        );


        return header;
    }


    // =========================================================
    // HEADER LABEL
    // =========================================================

    private Label createHeaderLabel(
            String text) {

        Label label =
                new Label(text);


        label.setStyle(
                "-fx-text-fill: #817990;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );


        return label;
    }


    // =========================================================
    // DOCUMENT ROW
    // =========================================================

    private VBox createDocumentRow(
            String fileName,
            String purpose,
            String status,
            String date) {


        VBox container =
                new VBox();


        HBox row =
                new HBox();


        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(18, 25, 18, 25)
        );


        // =====================================================
        // DOCUMENT
        // =====================================================

        HBox documentBox =
                new HBox(13);


        documentBox.setAlignment(
                Pos.CENTER_LEFT
        );

        documentBox.setPrefWidth(
                240
        );


        StackPane documentIcon =
                createDocumentIcon();


        Label fileLabel =
                new Label(fileName);


        fileLabel.setWrapText(true);

        fileLabel.setMaxWidth(170);


        fileLabel.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );


        documentBox.getChildren().addAll(
                documentIcon,
                fileLabel
        );


        // =====================================================
        // PURPOSE
        // =====================================================

        Label purposeLabel =
                new Label(purpose);


        purposeLabel.setPrefWidth(
                125
        );


        purposeLabel.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 13px;"
        );


        // =====================================================
        // STATUS
        // =====================================================

        StackPane statusBadge =
                createStatusBadge(status);


        statusBadge.setPrefWidth(
                135
        );

        statusBadge.setAlignment(
                Pos.CENTER_LEFT
        );


        // =====================================================
        // DATE
        // =====================================================

        Label dateLabel =
                new Label(date);


        dateLabel.setPrefWidth(
                155
        );

        dateLabel.setWrapText(true);


        dateLabel.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 13px;"
        );


        // =====================================================
        // ACTIONS
        // =====================================================

        VBox actionsBox =
                createActions(fileName);


        actionsBox.setPrefWidth(
                100
        );


        // =====================================================
        // ADD COLUMNS
        // =====================================================

        row.getChildren().addAll(
                documentBox,
                purposeLabel,
                statusBadge,
                dateLabel,
                actionsBox
        );


        // =====================================================
        // ROW HOVER
        // =====================================================

        row.setOnMouseEntered(e -> {

            container.setStyle(
                    "-fx-background-color: #1B1828;"
            );

        });


        row.setOnMouseExited(e -> {

            container.setStyle(
                    "-fx-background-color: transparent;"
            );

        });


        container.getChildren().add(
                row
        );


        // =====================================================
        // SEPARATOR
        // =====================================================

        HBox separator =
                createSeparator();


        container.getChildren().add(
                separator
        );


        return container;
    }


    // =========================================================
    // DOCUMENT ICON
    // =========================================================

    private StackPane createDocumentIcon() {

        StackPane iconBox =
                new StackPane();


        iconBox.setPrefSize(
                42,
                42
        );

        iconBox.setMinSize(
                42,
                42
        );

        iconBox.setMaxSize(
                42,
                42
        );


        // =====================================================
        // PURPLE CIRCLE
        // =====================================================

        Circle circle =
                new Circle(
                        21,
                        Color.web("#211A2E")
                );


        // =====================================================
        // DOCUMENT ICON
        // =====================================================

        Label icon =
                new Label("▤");


        icon.setStyle(
                "-fx-text-fill: " + LIGHT_PURPLE + ";" +
                "-fx-font-size: 19px;" +
                "-fx-font-weight: bold;"
        );


        iconBox.getChildren().addAll(
                circle,
                icon
        );


        return iconBox;
    }


    // =========================================================
    // STATUS BADGE
    // =========================================================

    private StackPane createStatusBadge(
            String status) {


        StackPane badge =
                new StackPane();


        Label label =
                new Label(status);


        String background;
        String border;
        String textColor;


        switch (status) {

            // =================================================
            // ACTIVE
            // =================================================

            case "Active":

                background = "#132E2A";
                border = "#1F6B60";
                textColor = "#5EEAD4";

                break;


            // =================================================
            // COMPLETED
            // =================================================

            case "Completed":

                background = "#211A2E";
                border = "#6D28D9";
                textColor = "#A78BFA";

                break;


            // =================================================
            // PENDING
            // =================================================

            case "Pending":

                background = "#352B1C";
                border = "#6D572B";
                textColor = "#C9A95A";

                break;


            // =================================================
            // EXPIRED
            // =================================================

            case "Expired":

                background = "#1E1B25";
                border = "#3A3545";
                textColor = "#9D96A8";

                break;


            // =================================================
            // DEFAULT
            // =================================================

            default:

                background = "#211A2E";
                border = PURPLE;
                textColor = LIGHT_PURPLE;

                break;
        }


        label.setStyle(
                "-fx-background-color: " + background + ";" +
                "-fx-border-color: " + border + ";" +
                "-fx-border-radius: 15;" +
                "-fx-background-radius: 15;" +
                "-fx-text-fill: " + textColor + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 5 12 5 12;"
        );


        badge.setAlignment(
                Pos.CENTER_LEFT
        );


        badge.getChildren().add(
                label
        );


        return badge;
    }


    // =========================================================
    // ACTIONS
    // =========================================================

    private VBox createActions(
            String fileName) {


        VBox actions =
                new VBox(7);


        actions.setAlignment(
                Pos.CENTER_LEFT
        );


        // =====================================================
        // VIEW
        // =====================================================

        Label view =
                new Label("View");


        view.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );


        // =====================================================
        // SHARE
        // =====================================================

        Label share =
                new Label("Share");


        share.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );


        // =====================================================
        // VIEW HOVER
        // =====================================================

        view.setOnMouseEntered(e -> {

            view.setStyle(
                    "-fx-text-fill: " + LIGHT_PURPLE + ";" +
                    "-fx-font-size: 12px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-cursor: hand;"
            );

        });


        view.setOnMouseExited(e -> {

            view.setStyle(
                    "-fx-text-fill: " + TEXT + ";" +
                    "-fx-font-size: 12px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-cursor: hand;"
            );

        });


        // =====================================================
        // SHARE HOVER
        // =====================================================

        share.setOnMouseEntered(e -> {

            share.setStyle(
                    "-fx-text-fill: " + LIGHT_PURPLE + ";" +
                    "-fx-font-size: 12px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-cursor: hand;"
            );

        });


        share.setOnMouseExited(e -> {

            share.setStyle(
                    "-fx-text-fill: " + TEXT + ";" +
                    "-fx-font-size: 12px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-cursor: hand;"
            );

        });


        // =====================================================
        // VIEW CLICK
        // =====================================================

        view.setOnMouseClicked(e -> {

            System.out.println(
                    "View document: " + fileName
            );

        });


        // =====================================================
        // SHARE CLICK
        // =====================================================

        share.setOnMouseClicked(e -> {

            System.out.println(
                    "Share document: " + fileName
            );

        });


        actions.getChildren().addAll(
                view,
                share
        );


        return actions;
    }


    // =========================================================
    // SEPARATOR
    // =========================================================

    private HBox createSeparator() {

        HBox separator =
                new HBox();


        separator.setPrefHeight(
                1
        );

        separator.setMaxHeight(
                1
        );


        separator.setStyle(
                "-fx-background-color: " + CARD_BORDER + ";"
        );


        return separator;
    }
}