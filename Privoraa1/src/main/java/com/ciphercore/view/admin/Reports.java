package com.ciphercore.view.admin;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Reports {

    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public VBox getContent() {

        VBox root = new VBox(
                25
        );

        root.setPadding(
                new Insets(30, 38, 40, 38)
        );

        root.setStyle(
                "-fx-background-color: #080E18;"
        );

        // =====================================================
        // HEADING
        // =====================================================

        Label title = new Label(
                "Reports"
        );

        title.setStyle(
                "-fx-text-fill: #F8FAFC;" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Generate and export network reports."
        );

        subtitle.setStyle(
                "-fx-text-fill: #94A3B8;" +
                "-fx-font-size: 15px;"
        );

        VBox heading = new VBox(
                5,
                title,
                subtitle
        );

        // =====================================================
        // REPORT CARDS
        // =====================================================

        HBox reportCards = new HBox(
                20
        );

        VBox daily = createReportCard(
                "▣",
                "Daily Report",
                "Yesterday's activity\nsummary"
        );

        VBox weekly = createReportCard(
                "▤",
                "Weekly Report",
                "Last 7 days performance"
        );

        VBox monthly = createReportCard(
                "▥",
                "Monthly Report",
                "30-day comprehensive\nanalysis"
        );

        HBox.setHgrow(
                daily,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                weekly,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                monthly,
                Priority.ALWAYS
        );

        reportCards.getChildren().addAll(
                daily,
                weekly,
                monthly
        );

        // =====================================================
        // CUSTOM REPORT
        // =====================================================

        VBox customCard = new VBox();

        customCard.setStyle(
                "-fx-background-color: #111927;" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #202B3C;" +
                "-fx-border-radius: 22;"
        );

        // Header

        VBox customHeader = new VBox(
                5
        );

        customHeader.setPadding(
                new Insets(22, 28, 20, 28)
        );

        Label customTitle = new Label(
                "Custom report"
        );

        customTitle.setStyle(
                "-fx-text-fill: #F1F5F9;" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );

        Label customSubtitle = new Label(
                "Build a report with the metrics you need"
        );

        customSubtitle.setStyle(
                "-fx-text-fill: #7F8DA1;" +
                "-fx-font-size: 13px;"
        );

        customHeader.getChildren().addAll(
                customTitle,
                customSubtitle
        );

        customHeader.setStyle(
                "-fx-border-color: #202B3C;" +
                "-fx-border-width: 0 0 1 0;"
        );

        // -----------------------------------------------------
        // CUSTOM FORM
        // -----------------------------------------------------

        HBox form = new HBox(
                20
        );

        form.setPadding(
                new Insets(25, 28, 28, 28)
        );

        VBox fromBox = createComboBox(
                "From"
        );

        VBox toBox = createComboBox(
                "To"
        );

        VBox segmentBox = createSegmentCombo();

        Button generateButton = new Button(
                "↓   Generate"
        );

        generateButton.setPrefHeight(
                55
        );

        generateButton.setPrefWidth(
                175
        );

        generateButton.setStyle(
                "-fx-background-color: linear-gradient(to right, #168DF5, #22A7FF);" +
                "-fx-background-radius: 18;" +
                "-fx-text-fill: #06111F;" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );

        generateButton.setOnMouseEntered(e ->
                generateButton.setStyle(
                        "-fx-background-color: #38BDF8;" +
                        "-fx-background-radius: 18;" +
                        "-fx-text-fill: #06111F;" +
                        "-fx-font-size: 15px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;"
                )
        );

        generateButton.setOnMouseExited(e ->
                generateButton.setStyle(
                        "-fx-background-color: linear-gradient(to right, #168DF5, #22A7FF);" +
                        "-fx-background-radius: 18;" +
                        "-fx-text-fill: #06111F;" +
                        "-fx-font-size: 15px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-cursor: hand;"
                )
        );

        HBox.setHgrow(
                fromBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                toBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                segmentBox,
                Priority.ALWAYS
        );

        form.getChildren().addAll(
                fromBox,
                toBox,
                segmentBox,
                generateButton
        );

        customCard.getChildren().addAll(
                customHeader,
                form
        );

        // =====================================================
        // ROOT
        // =====================================================

        root.getChildren().addAll(
                heading,
                reportCards,
                customCard
        );

        return root;
    }

    // =========================================================
    // REPORT CARD
    // =========================================================

    private VBox createReportCard(
            String icon,
            String title,
            String description
    ) {

        VBox card = new VBox(
                12
        );

        card.setPadding(
                new Insets(25, 25, 25, 25)
        );

        card.setPrefHeight(
                275
        );

        card.setStyle(
                "-fx-background-color: #111927;" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #202B3C;" +
                "-fx-border-radius: 22;"
        );

        // -----------------------------------------------------
        // ICON
        // -----------------------------------------------------

        Label iconLabel = new Label(
                icon
        );

        iconLabel.setAlignment(
                Pos.CENTER
        );

        iconLabel.setPrefSize(
                55,
                55
        );

        iconLabel.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #168DF5, #22A7FF);" +
                "-fx-background-radius: 18;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;"
        );

        // -----------------------------------------------------
        // TITLE
        // -----------------------------------------------------

        Label titleLabel = new Label(
                title
        );

        titleLabel.setStyle(
                "-fx-text-fill: #F1F5F9;" +
                "-fx-font-size: 19px;" +
                "-fx-font-weight: bold;"
        );

        // -----------------------------------------------------
        // DESCRIPTION
        // -----------------------------------------------------

        Label descriptionLabel = new Label(
                description
        );

        descriptionLabel.setStyle(
                "-fx-text-fill: #7F8DA1;" +
                "-fx-font-size: 13px;"
        );

        // -----------------------------------------------------
        // BUTTONS
        // -----------------------------------------------------

        HBox buttons = new HBox(
                10
        );

        Button pdfButton = new Button(
                "▣  PDF"
        );

        pdfButton.setPrefHeight(
                40
        );

        pdfButton.setStyle(
                "-fx-background-color: #080E18;" +
                "-fx-border-color: #263449;" +
                "-fx-border-radius: 14;" +
                "-fx-background-radius: 14;" +
                "-fx-text-fill: #E2E8F0;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        Button excelButton = new Button(
                "▦  Excel"
        );

        excelButton.setPrefHeight(
                40
        );

        excelButton.setStyle(
                "-fx-background-color: #06C993;" +
                "-fx-background-radius: 14;" +
                "-fx-text-fill: #031B14;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        buttons.getChildren().addAll(
                pdfButton,
                excelButton
        );

        card.getChildren().addAll(
                iconLabel,
                titleLabel,
                descriptionLabel,
                buttons
        );

        addHover(
                card
        );

        return card;
    }

    // =========================================================
    // COMBO BOX
    // =========================================================

    private VBox createComboBox(
            String title
    ) {

        VBox box = new VBox(
                7
        );

        Label label = new Label(
                title
        );

        label.setStyle(
                "-fx-text-fill: #E2E8F0;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        ComboBox<String> combo = new ComboBox<>();

        combo.getItems().addAll(
                "Today",
                "Yesterday",
                "Last 7 days",
                "Last 30 days"
        );

        combo.setPrefHeight(
                55
        );

        combo.setMaxWidth(
                Double.MAX_VALUE
        );

        combo.setStyle(
                "-fx-background-color: #111927;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #2A374A;" +
                "-fx-border-radius: 18;" +
                "-fx-text-fill: #CBD5E1;"
        );

        box.getChildren().addAll(
                label,
                combo
        );

        return box;
    }

    // =========================================================
    // SEGMENT
    // =========================================================

    private VBox createSegmentCombo() {

        VBox box = new VBox(
                7
        );

        Label label = new Label(
                "Segment"
        );

        label.setStyle(
                "-fx-text-fill: #E2E8F0;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        ComboBox<String> combo = new ComboBox<>();

        combo.getItems().addAll(
                "All users",
                "Users",
                "Centres",
                "Admins"
        );

        combo.setValue(
                "All users"
        );

        combo.setPrefHeight(
                55
        );

        combo.setMaxWidth(
                Double.MAX_VALUE
        );

        combo.setStyle(
                "-fx-background-color: #111927;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #2A374A;" +
                "-fx-border-radius: 18;" +
                "-fx-text-fill: #CBD5E1;"
        );

        box.getChildren().addAll(
                label,
                combo
        );

        return box;
    }

    // =========================================================
    // HOVER
    // =========================================================

    private void addHover(
            VBox card
    ) {

        card.setOnMouseEntered(e ->
                card.setStyle(
                        "-fx-background-color: #141F30;" +
                        "-fx-background-radius: 22;" +
                        "-fx-border-color: #28517A;" +
                        "-fx-border-radius: 22;"
                )
        );

        card.setOnMouseExited(e ->
                card.setStyle(
                        "-fx-background-color: #111927;" +
                        "-fx-background-radius: 22;" +
                        "-fx-border-color: #202B3C;" +
                        "-fx-border-radius: 22;"
                )
        );
    }
}