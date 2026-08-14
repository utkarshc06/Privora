package com.finalproj.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class PrivacyReceipt {

    private Scene privacyReceiptScene;

    public Scene getPrivacyReceiptScene(Runnable backToDashboard) {

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
                new Insets(15, 28, 15, 28)
        );

        topBar.setAlignment(Pos.CENTER_LEFT);

        Label logo = new Label("PRIVORA");

        logo.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );

        Label pageTitle = new Label(
                "  /  Privacy Receipt"
        );

        pageTitle.setStyle(
                "-fx-text-fill: #7E8DA3;" +
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

        Button backButton =
                new Button("← Dashboard");

        backButton.setStyle(
                "-fx-background-color: #0B162A;" +
                "-fx-border-color: #263653;" +
                "-fx-border-radius: 15;" +
                "-fx-background-radius: 15;" +
                "-fx-text-fill: #B8C5D6;" +
                "-fx-padding: 8 16 8 16;"
        );

        backButton.setOnAction(e ->
                backToDashboard.run()
        );

        HBox.setHgrow(
                titleBox,
                Priority.ALWAYS
        );

        topBar.getChildren().addAll(
                titleBox,
                backButton
        );

        // =========================================================
        // CONTENT
        // =========================================================

        VBox content = new VBox(18);

        content.setPadding(
                new Insets(30, 40, 40, 40)
        );

        // =========================================================
        // HEADING
        // =========================================================

        Label heading =
                new Label("Privacy Receipt");

        heading.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );

        Label description =
                new Label(
                        "View the complete privacy and security record of your document."
                );

        description.setStyle(
                "-fx-text-fill: #8291A7;" +
                "-fx-font-size: 13px;"
        );

        // =========================================================
        // RECEIPT CARD
        // =========================================================

        VBox receiptCard =
                new VBox(18);

        receiptCard.setPadding(
                new Insets(25)
        );

        receiptCard.setStyle(
                "-fx-background-color: #091428;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 18;"
        );

        // =========================================================
        // DOCUMENT HEADER
        // =========================================================

        HBox documentHeader =
                new HBox(15);

        documentHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        Label documentIcon =
                new Label("▣");

        documentIcon.setStyle(
                "-fx-background-color: #0E2C4C;" +
                "-fx-background-radius: 12;" +
                "-fx-text-fill: #39A5FF;" +
                "-fx-font-size: 22px;" +
                "-fx-padding: 10 14 10 14;"
        );

        VBox documentInfo =
                new VBox(4);

        Label documentName =
                new Label("Aadhaar-Card.pdf");

        documentName.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );

        Label documentStatus =
                new Label("Privacy protected");

        documentStatus.setStyle(
                "-fx-text-fill: #19D6A3;" +
                "-fx-font-size: 11px;"
        );

        documentInfo.getChildren().addAll(
                documentName,
                documentStatus
        );

        documentHeader.getChildren().addAll(
                documentIcon,
                documentInfo
        );

        // =========================================================
        // PRIVACY SCORE
        // =========================================================

        HBox scoreBox =
                new HBox(20);

        scoreBox.setPadding(
                new Insets(18)
        );

        scoreBox.setAlignment(
                Pos.CENTER_LEFT
        );

        scoreBox.setStyle(
                "-fx-background-color: #071226;" +
                "-fx-background-radius: 14;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 14;"
        );

        Label score =
                new Label("94%");

        score.setStyle(
                "-fx-text-fill: #19D6A3;" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;"
        );

        VBox scoreInfo =
                new VBox(4);

        Label scoreTitle =
                new Label("Privacy Score");

        scoreTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        Label scoreDescription =
                new Label(
                        "Document passed the privacy protection checks."
                );

        scoreDescription.setStyle(
                "-fx-text-fill: #71829A;" +
                "-fx-font-size: 11px;"
        );

        scoreInfo.getChildren().addAll(
                scoreTitle,
                scoreDescription
        );

        scoreBox.getChildren().addAll(
                score,
                scoreInfo
        );

        // =========================================================
        // SECURITY DETAILS TITLE
        // =========================================================

        Label securityTitle =
                new Label("Security Details");

        securityTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );

        // =========================================================
        // SECURITY DETAILS
        // =========================================================

        VBox details =
                new VBox(10);

        details.getChildren().addAll(
                createDetailRow(
                        "Watermark",
                        "Enabled",
                        "#19D6A3"
                ),

                createDetailRow(
                        "Download Protection",
                        "Enabled",
                        "#19D6A3"
                ),

                createDetailRow(
                        "AI Privacy Scan",
                        "Completed",
                        "#19D6A3"
                ),

                createDetailRow(
                        "Document Expiry",
                        "30 minutes",
                        "#39A5FF"
                ),

                createDetailRow(
                        "Print Limit",
                        "3 prints",
                        "#39A5FF"
                ),

                createDetailRow(
                        "Privacy Scan",
                        "5 sensitive items detected",
                        "#FFB84D"
                )
        );

        // =========================================================
        // SESSION INFORMATION
        // =========================================================

        Label sessionTitle =
                new Label("Session Information");

        sessionTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );

        VBox sessionInfo =
                new VBox(10);

        sessionInfo.getChildren().addAll(
                createDetailRow(
                        "Session ID",
                        "PRV-2026-00127",
                        "#8291A7"
                ),

                createDetailRow(
                        "Created",
                        "14 Aug 2026, 10:12 AM",
                        "#8291A7"
                ),

                createDetailRow(
                        "Centre",
                        "Quick Xerox Centre",
                        "#8291A7"
                ),

                createDetailRow(
                        "Status",
                        "Active",
                        "#19D6A3"
                )
        );

        // =========================================================
        // FOOTER MESSAGE
        // =========================================================

        Label footer =
                new Label(
                        "This receipt records the privacy settings applied to your document."
                );

        footer.setWrapText(true);

        footer.setStyle(
                "-fx-text-fill: #71829A;" +
                "-fx-font-size: 11px;" +
                "-fx-padding: 10 0 0 0;"
        );

        // =========================================================
        // ADD CONTENT
        // =========================================================

        receiptCard.getChildren().addAll(
                documentHeader,
                scoreBox,
                securityTitle,
                details,
                sessionTitle,
                sessionInfo,
                footer
        );

        content.getChildren().addAll(
                heading,
                description,
                receiptCard
        );

        // =========================================================
        // SCROLL PANE
        // =========================================================

        ScrollPane scrollPane =
                new ScrollPane(content);

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);

        scrollPane.setStyle(
                "-fx-background: transparent;" +
                "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;"
        );

        // =========================================================
        // ROOT
        // =========================================================

        root.setTop(topBar);
        root.setCenter(scrollPane);

        // =========================================================
        // SCENE
        // =========================================================

        privacyReceiptScene =
                new Scene(
                        root,
                        1300,
                        700
                );

        return privacyReceiptScene;
    }

    // =============================================================
    // DETAIL ROW
    // =============================================================

    private HBox createDetailRow(
            String title,
            String value,
            String valueColor) {

        HBox row =
                new HBox();

        row.setPadding(
                new Insets(12, 14, 12, 14)
        );

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setStyle(
                "-fx-background-color: #071226;" +
                "-fx-background-radius: 10;"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: #B8C5D6;" +
                "-fx-font-size: 12px;"
        );

        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-text-fill: " + valueColor + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        HBox.setHgrow(
                titleLabel,
                Priority.ALWAYS
        );

        row.getChildren().addAll(
                titleLabel,
                valueLabel
        );

        return row;
    }
}