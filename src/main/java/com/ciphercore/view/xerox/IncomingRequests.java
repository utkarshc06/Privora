package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class IncomingRequests {

    // =========================================================
    // COLORS - PRIVORA PURPLE THEME
    // =========================================================

    private static final String BG = "#09080F";
    private static final String CARD = "#15121F";
    private static final String CARD_HOVER = "#1D172B";
    private static final String PURPLE = "#7C3AED";
    private static final String PURPLE_LIGHT = "#8B5CF6";
    private static final String BORDER = "#2B2438";
    private static final String WHITE = "#FFFFFF";
    private static final String MUTED = "#A8A0B5";
    private static final String GREEN = "#22C55E";

    // =========================================================
    // MAIN CONTENT
    // =========================================================

    private VBox content;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public IncomingRequests() {

        content = new VBox(22);

        content.setPadding(
                new Insets(35, 40, 40, 40)
        );

        content.setStyle(
                "-fx-background-color: " + BG + ";"
        );

        createUI();
    }

    // =========================================================
    // GET CONTENT
    // =========================================================

    public VBox getContent() {
        return content;
    }

    // =========================================================
    // CREATE UI
    // =========================================================

    private void createUI() {

        // =====================================================
        // HEADER
        // =====================================================

        VBox header = new VBox(7);

        Label title =
                new Label("Incoming Requests");

        title.setStyle("""
                -fx-text-fill: white;
                -fx-font-size: 32px;
                -fx-font-weight: bold;
                """);

        Label subtitle =
                new Label(
                        "Review and manage incoming print requests."
                );

        subtitle.setStyle("""
                -fx-text-fill: #A8A0B5;
                -fx-font-size: 15px;
                """);

        header.getChildren().addAll(
                title,
                subtitle
        );

        // =====================================================
        // TOP SUMMARY
        // =====================================================

        HBox summary =
                new HBox(15);

        summary.setMaxWidth(
                Double.MAX_VALUE
        );

        VBox pending =
                createSummaryCard(
                        "Pending Requests",
                        "08",
                        "Waiting for review"
                );

        VBox today =
                createSummaryCard(
                        "Today's Requests",
                        "24",
                        "Requests received today"
                );

        VBox accepted =
                createSummaryCard(
                        "Accepted",
                        "16",
                        "Successfully processed"
                );

        summary.getChildren().addAll(
                pending,
                today,
                accepted
        );

        HBox.setHgrow(
                pending,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                today,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                accepted,
                Priority.ALWAYS
        );

        // =====================================================
        // SECTION TITLE
        // =====================================================

        Label requestTitle =
                new Label("Recent Requests");

        requestTitle.setStyle("""
                -fx-text-fill: white;
                -fx-font-size: 21px;
                -fx-font-weight: bold;
                """);

        // =====================================================
        // REQUEST LIST
        // =====================================================

        VBox requestList =
                new VBox(14);

        requestList.setMaxWidth(
                Double.MAX_VALUE
        );

        requestList.getChildren().addAll(

                createRequestCard(
                        "Print Request",
                        "Document printing request",
                        "Today • 10:32 AM",
                        "Pending"
                ),

                createRequestCard(
                        "Print Request",
                        "Secure document printing",
                        "Today • 10:18 AM",
                        "Pending"
                ),

                createRequestCard(
                        "Print Request",
                        "Multiple pages document",
                        "Today • 09:55 AM",
                        "Pending"
                ),

                createRequestCard(
                        "Print Request",
                        "College document printing",
                        "Today • 09:42 AM",
                        "Pending"
                ),

                createRequestCard(
                        "Print Request",
                        "PDF document",
                        "Today • 09:20 AM",
                        "Pending"
                ),

                createRequestCard(
                        "Print Request",
                        "Confidential document",
                        "Today • 09:05 AM",
                        "Pending"
                )
        );

        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        content.getChildren().addAll(
                header,
                summary,
                requestTitle,
                requestList
        );
    }

    // =========================================================
    // SUMMARY CARD
    // =========================================================

    private VBox createSummaryCard(
            String title,
            String number,
            String description
    ) {

        VBox card =
                new VBox(8);

        card.setPadding(
                new Insets(20)
        );

        card.setMinHeight(125);

        card.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 18;"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle("""
                -fx-text-fill: #A8A0B5;
                -fx-font-size: 13px;
                -fx-font-weight: bold;
                """);

        Label numberLabel =
                new Label(number);

        numberLabel.setStyle(
                "-fx-text-fill: " +
                PURPLE_LIGHT +
                ";" +
                "-fx-font-size: 29px;" +
                "-fx-font-weight: bold;"
        );

        Label descriptionLabel =
                new Label(description);

        descriptionLabel.setStyle("""
                -fx-text-fill: #81788F;
                -fx-font-size: 12px;
                """);

        card.getChildren().addAll(
                titleLabel,
                numberLabel,
                descriptionLabel
        );

        return card;
    }

    // =========================================================
    // REQUEST CARD
    // =========================================================

    private HBox createRequestCard(
            String title,
            String description,
            String time,
            String status
    ) {

        HBox card =
                new HBox(18);

        card.setAlignment(
                Pos.CENTER_LEFT
        );

        card.setPadding(
                new Insets(20)
        );

        card.setMinHeight(105);

        card.setMaxWidth(
                Double.MAX_VALUE
        );

        card.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 18;"
        );

        // =====================================================
        // LEFT ICON
        // =====================================================

        Label icon =
                new Label("▣");

        icon.setAlignment(
                Pos.CENTER
        );

        icon.setMinSize(48, 48);

        icon.setStyle(
                "-fx-background-color: #24183A;" +
                "-fx-background-radius: 14;" +
                "-fx-text-fill: " +
                PURPLE_LIGHT +
                ";" +
                "-fx-font-size: 22px;"
        );

        // =====================================================
        // DETAILS
        // =====================================================

        VBox details =
                new VBox(5);

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle("""
                -fx-text-fill: white;
                -fx-font-size: 16px;
                -fx-font-weight: bold;
                """);

        Label descriptionLabel =
                new Label(description);

        descriptionLabel.setStyle("""
                -fx-text-fill: #A8A0B5;
                -fx-font-size: 13px;
                """);

        Label timeLabel =
                new Label(time);

        timeLabel.setStyle("""
                -fx-text-fill: #746B80;
                -fx-font-size: 12px;
                """);

        details.getChildren().addAll(
                titleLabel,
                descriptionLabel,
                timeLabel
        );

        HBox.setHgrow(
                details,
                Priority.ALWAYS
        );

        // =====================================================
        // STATUS
        // =====================================================

        Label statusLabel =
                new Label(status);

        statusLabel.setPadding(
                new Insets(7, 13, 7, 13)
        );

        statusLabel.setStyle(
                "-fx-background-color: #1C3326;" +
                "-fx-background-radius: 20;" +
                "-fx-text-fill: " + GREEN + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        // =====================================================
        // VIEW BUTTON
        // =====================================================

        Button viewButton =
                new Button("View");

        viewButton.setPrefWidth(80);
        viewButton.setPrefHeight(38);

        viewButton.setStyle(
                "-fx-background-color: " +
                PURPLE +
                ";" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        viewButton.setOnMouseEntered(e ->
                viewButton.setStyle(
                        "-fx-background-color: " +
                        PURPLE_LIGHT +
                        ";" +
                        "-fx-background-radius: 10;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;"
                )
        );

        viewButton.setOnMouseExited(e ->
                viewButton.setStyle(
                        "-fx-background-color: " +
                        PURPLE +
                        ";" +
                        "-fx-background-radius: 10;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;"
                )
        );

        // =====================================================
        // ADD CARD COMPONENTS
        // =====================================================

        card.getChildren().addAll(
                icon,
                details,
                statusLabel,
                viewButton
        );

        // =====================================================
        // HOVER CARD
        // =====================================================

        card.setOnMouseEntered(e -> {

            card.setStyle(
                    "-fx-background-color: " +
                    CARD_HOVER +
                    ";" +
                    "-fx-background-radius: 18;" +
                    "-fx-border-color: " +
                    PURPLE +
                    ";" +
                    "-fx-border-radius: 18;"
            );
        });

        card.setOnMouseExited(e -> {

            card.setStyle(
                    "-fx-background-color: " +
                    CARD +
                    ";" +
                    "-fx-background-radius: 18;" +
                    "-fx-border-color: " +
                    BORDER +
                    ";" +
                    "-fx-border-radius: 18;"
            );
        });

        return card;
    }

    // =========================================================
    // SCROLLABLE CONTENT
    // =========================================================

    public ScrollPane getScrollableContent() {

        ScrollPane scrollPane =
                new ScrollPane(
                        getContent()
                );

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle(
                "-fx-background-color: #09080F;" +
                "-fx-background: #09080F;"
        );

        return scrollPane;
    }
}