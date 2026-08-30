package com.ciphercore.view.admin;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Settings {

    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public VBox getContent() {

        VBox root = new VBox(22);

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
                "Platform settings"
        );

        title.setStyle(
                "-fx-text-fill: #F8FAFC;" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Defaults applied across the whole network."
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
        // DEFAULTS CARD
        // =====================================================

        VBox defaultsCard = new VBox();

        defaultsCard.setStyle(
                "-fx-background-color: #111927;" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #202B3C;" +
                "-fx-border-radius: 22;"
        );

        // -----------------------------------------------------
        // CARD HEADER
        // -----------------------------------------------------

        Label defaultsTitle = new Label(
                "Defaults"
        );

        defaultsTitle.setStyle(
                "-fx-text-fill: #F1F5F9;" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );

        HBox defaultsHeader = new HBox(
                defaultsTitle
        );

        defaultsHeader.setPadding(
                new Insets(20, 28, 20, 28)
        );

        defaultsHeader.setStyle(
                "-fx-border-color: #202B3C;" +
                "-fx-border-width: 0 0 1 0;"
        );

        // -----------------------------------------------------
        // INPUT AREA
        // -----------------------------------------------------

        VBox defaultContent = new VBox(
                20
        );

        defaultContent.setPadding(
                new Insets(25, 28, 28, 28)
        );

        // Row 1

        VBox expiryBox = createInputBox(
                "Default expiry (minutes)",
                "15"
        );

        VBox printLimitBox = createInputBox(
                "Maximum print limit",
                "5"
        );

        HBox row1 = new HBox(
                22,
                expiryBox,
                printLimitBox
        );

        HBox.setHgrow(
                expiryBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                printLimitBox,
                Priority.ALWAYS
        );

        // Row 2

        VBox watermarkBox = createInputBox(
                "Default watermark text",
                "VanishFile · {session}"
        );

        defaultContent.getChildren().addAll(
                row1,
                watermarkBox
        );

        defaultsCard.getChildren().addAll(
                defaultsHeader,
                defaultContent
        );

        // =====================================================
        // SECURITY OPTIONS CARD
        // =====================================================

        VBox securityCard = new VBox();

        securityCard.setStyle(
                "-fx-background-color: #111927;" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #202B3C;" +
                "-fx-border-radius: 22;"
        );

        // -----------------------------------------------------
        // HEADER
        // -----------------------------------------------------

        Label securityTitle = new Label(
                "Security options"
        );

        securityTitle.setStyle(
                "-fx-text-fill: #F1F5F9;" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );

        HBox securityHeader = new HBox(
                securityTitle
        );

        securityHeader.setPadding(
                new Insets(20, 28, 20, 28)
        );

        securityHeader.setStyle(
                "-fx-border-color: #202B3C;" +
                "-fx-border-width: 0 0 1 0;"
        );

        // -----------------------------------------------------
        // SECURITY ROWS
        // -----------------------------------------------------

        VBox securityContent = new VBox();

        securityContent.setPadding(
                new Insets(8, 28, 8, 28)
        );

        HBox option1 = createSecurityOption(
                "Enforce 2FA on admin accounts",
                "Required for all admin sign-ins",
                true
        );

        HBox option2 = createSecurityOption(
                "Block screen capture in viewer",
                "Client-side prevention on all sessions",
                true
        );

        HBox option3 = createSecurityOption(
                "Auto-suspend on 5 failed logins",
                "Temporary lock for 15 minutes",
                true
        );

        HBox option4 = createSecurityOption(
                "Require centre re-verification yearly",
                "Renewal prompts every 12 months",
                true
        );

        securityContent.getChildren().addAll(
                option1,
                option2,
                option3,
                option4
        );

        securityCard.getChildren().addAll(
                securityHeader,
                securityContent
        );

        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        root.getChildren().addAll(
                heading,
                defaultsCard,
                securityCard
        );

        return root;
    }

    // =========================================================
    // INPUT BOX
    // =========================================================

    private VBox createInputBox(
            String title,
            String value
    ) {

        VBox box = new VBox(
                8
        );

        Label label = new Label(
                title
        );

        label.setStyle(
                "-fx-text-fill: #E2E8F0;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        TextField field = new TextField(
                value
        );

        field.setPrefHeight(
                52
        );

        field.setStyle(
                "-fx-background-color: #111927;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #2A374A;" +
                "-fx-border-radius: 18;" +
                "-fx-text-fill: #E2E8F0;" +
                "-fx-prompt-text-fill: #64748B;" +
                "-fx-font-size: 14px;" +
                "-fx-padding: 0 16;"
        );

        box.getChildren().addAll(
                label,
                field
        );

        HBox.setHgrow(
                box,
                Priority.ALWAYS
        );

        return box;
    }

    // =========================================================
    // SECURITY OPTION
    // =========================================================

    private HBox createSecurityOption(
            String title,
            String description,
            boolean selected
    ) {

        HBox row = new HBox();

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(16, 0, 16, 0)
        );

        Label titleLabel = new Label(
                title
        );

        titleLabel.setStyle(
                "-fx-text-fill: #E2E8F0;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        Label descriptionLabel = new Label(
                description
        );

        descriptionLabel.setStyle(
                "-fx-text-fill: #7F8DA1;" +
                "-fx-font-size: 12px;"
        );

        VBox textBox = new VBox(
                4,
                titleLabel,
                descriptionLabel
        );

        HBox.setHgrow(
                textBox,
                Priority.ALWAYS
        );

        CheckBox toggle = new CheckBox();

        toggle.setSelected(
                selected
        );

        toggle.setStyle(
                "-fx-cursor: hand;"
        );

        row.getChildren().addAll(
                textBox,
                toggle
        );

        return row;
    }
}