package com.finalproj.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

public class PrivacyScan {

    private Scene privacyScanScene;

    public Scene getPrivacyScanScene(Runnable backToDashboard) {

        // =========================================================
        // ROOT
        // =========================================================

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color: #F7FAFC;"
        );

        // =========================================================
        // TOP BAR
        // =========================================================

        HBox topBar = new HBox();

        topBar.setPadding(
                new Insets(15, 28, 15, 28)
        );

        topBar.setAlignment(
                Pos.CENTER_LEFT
        );

        topBar.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #E1E7EF;" +
                "-fx-border-width: 0 0 1 0;"
        );

        Label logo = new Label("PRIVORA");

        logo.setStyle(
                "-fx-text-fill: #111827;" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );

        Label pageTitle =
                new Label("  /  Privacy Scan");

        pageTitle.setStyle(
                "-fx-text-fill: #718096;" +
                "-fx-font-size: 13px;"
        );

        HBox titleBox =
                new HBox(
                        5,
                        logo,
                        pageTitle
                );

        titleBox.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                titleBox,
                Priority.ALWAYS
        );

        // User information

        Label userIcon =
                new Label("U");

        userIcon.setAlignment(
                Pos.CENTER
        );

        userIcon.setStyle(
                "-fx-background-color: #3B82F6;" +
                "-fx-background-radius: 50%;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-min-width: 34px;" +
                "-fx-min-height: 34px;"
        );

        Label userName =
                new Label("User");

        userName.setStyle(
                "-fx-text-fill: #111827;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        Label userRole =
                new Label("Document Owner");

        userRole.setStyle(
                "-fx-text-fill: #718096;" +
                "-fx-font-size: 10px;"
        );

        VBox userInfo =
                new VBox(
                        1,
                        userName,
                        userRole
                );

        HBox profileBox =
                new HBox(
                        10,
                        userIcon,
                        userInfo
                );

        profileBox.setAlignment(
                Pos.CENTER_LEFT
        );

        Button backButton =
                new Button("← Dashboard");

        backButton.setStyle(
                "-fx-background-color: #F1F5F9;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: #334155;" +
                "-fx-padding: 8 15 8 15;"
        );

        backButton.setOnAction(e -> {

            System.out.println(
                    "Back to Dashboard clicked"
            );

            backToDashboard.run();
        });

        HBox rightTop =
                new HBox(
                        15,
                        profileBox,
                        backButton
                );

        rightTop.setAlignment(
                Pos.CENTER_RIGHT
        );

        topBar.getChildren().addAll(
                titleBox,
                rightTop
        );

        // =========================================================
        // SIDEBAR
        // =========================================================

        VBox sidebar =
                new VBox(8);

        sidebar.setPadding(
                new Insets(25, 12, 25, 12)
        );

        sidebar.setPrefWidth(220);

        sidebar.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #E1E7EF;" +
                "-fx-border-width: 0 1 0 0;"
        );

        Label workspace =
                new Label("USER PANEL");

        workspace.setStyle(
                "-fx-text-fill: #718096;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 0 10 10 10;"
        );

        Button dashboardButton =
                createSidebarButton("⌂   Dashboard");

        Button uploadButton =
                createSidebarButton("↑   Upload Document");

        Button purposeButton =
                createSidebarButton("▣   Purpose");

        Button privacyButton =
                createSidebarButton("◉   Privacy Scan");

        Button redactionButton =
                createSidebarButton("✎   Smart Redaction");

        Button centreButton =
                createSidebarButton("▣   Select Centre");

        Button requestButton =
                createSidebarButton("◷   Request Status");

        Button documentsButton =
                createSidebarButton("▣   My Documents");

        Button activityButton =
                createSidebarButton("⌁   Activity");

        Button receiptButton =
                createSidebarButton("▤   Privacy Receipt");

        Button profileButton =
                createSidebarButton("♙   Profile");

        setActiveSidebarButton(
                privacyButton
        );

        sidebar.getChildren().addAll(
                workspace,
                dashboardButton,
                uploadButton,
                purposeButton,
                privacyButton,
                redactionButton,
                centreButton,
                requestButton,
                documentsButton,
                activityButton,
                receiptButton,
                profileButton
        );

        VBox.setVgrow(
                profileButton,
                Priority.NEVER
        );

        // =========================================================
        // MAIN CONTENT
        // =========================================================

        VBox content =
                new VBox(18);

        content.setPadding(
                new Insets(30)
        );

        // =========================================================
        // HEADER
        // =========================================================

        Label heading =
                new Label("Privacy Scan");

        heading.setStyle(
                "-fx-text-fill: #111827;" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;"
        );

        Label description =
                new Label(
                        "AI detected sensitive information in your document."
                );

        description.setStyle(
                "-fx-text-fill: #64748B;" +
                "-fx-font-size: 13px;"
        );

        // =========================================================
        // PRIVACY SCORE CARD
        // =========================================================

        HBox scoreCard =
                new HBox();

        scoreCard.setAlignment(
                Pos.CENTER
        );

        scoreCard.setPrefHeight(
                190
        );

        scoreCard.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #DCE3EC;" +
                "-fx-border-radius: 18;"
        );

        VBox scoreContent =
                new VBox(10);

        scoreContent.setAlignment(
                Pos.CENTER
        );

        // Score circle

        StackPane scoreCircle =
                new StackPane();

        Circle outerCircle =
                new Circle(
                        62
                );

        outerCircle.setFill(
                Color.TRANSPARENT
        );

        outerCircle.setStroke(
                Color.web("#E7EEF7")
        );

        outerCircle.setStrokeWidth(
                10
        );

        Circle progressCircle =
                new Circle(
                        62
                );

        progressCircle.setFill(
                Color.TRANSPARENT
        );

        progressCircle.setStroke(
                Color.web("#10B981")
        );

        progressCircle.setStrokeWidth(
                10
        );

        progressCircle.setStrokeLineCap(
                javafx.scene.shape.StrokeLineCap.ROUND
        );

        progressCircle.getStrokeDashArray().add(
                292.0
        );

        progressCircle.setStrokeDashOffset(
                82
        );

        Label score =
                new Label("72");

        score.setStyle(
                "-fx-text-fill: #111827;" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;"
        );

        Label scoreText =
                new Label("PRIVACY SCORE");

        scoreText.setStyle(
                "-fx-text-fill: #64748B;" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;"
        );

        VBox scoreLabels =
                new VBox(
                        0,
                        score,
                        scoreText
                );

        scoreLabels.setAlignment(
                Pos.CENTER
        );

        scoreCircle.getChildren().addAll(
                outerCircle,
                progressCircle,
                scoreLabels
        );

        Label risk =
                new Label(
                        "◉  Medium Risk • 5 items found"
                );

        risk.setStyle(
                "-fx-background-color: #FFF3D6;" +
                "-fx-background-radius: 12;" +
                "-fx-text-fill: #8A5A00;" +
                "-fx-font-size: 10px;" +
                "-fx-padding: 6 12 6 12;"
        );

        scoreContent.getChildren().addAll(
                scoreCircle,
                risk
        );

        scoreCard.getChildren().add(
                scoreContent
        );

        // =========================================================
        // SENSITIVE INFORMATION CARD
        // =========================================================

        VBox sensitiveCard =
                new VBox();

        sensitiveCard.setStyle(
                "-fx-background-color: white;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #DCE3EC;" +
                "-fx-border-radius: 18;"
        );

        // Header

        VBox sensitiveHeader =
                new VBox(4);

        sensitiveHeader.setPadding(
                new Insets(18, 20, 15, 20)
        );

        Label sensitiveTitle =
                new Label(
                        "Sensitive information detected"
                );

        sensitiveTitle.setStyle(
                "-fx-text-fill: #111827;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        Label sensitiveDescription =
                new Label(
                        "Review, then redact or continue."
                );

        sensitiveDescription.setStyle(
                "-fx-text-fill: #64748B;" +
                "-fx-font-size: 10px;"
        );

        sensitiveHeader.getChildren().addAll(
                sensitiveTitle,
                sensitiveDescription
        );

        // =========================================================
        // INFORMATION LIST
        // =========================================================

        VBox informationList =
                new VBox();

        informationList.getChildren().addAll(

                createSensitiveRow(
                        "A",
                        "Aadhaar Number",
                        "XXXX XXXX 8342",
                        "High",
                        "#FEE2E2",
                        "#EF4444"
                ),

                createSensitiveRow(
                        "P",
                        "PAN",
                        "ABCPX••••K",
                        "High",
                        "#FEE2E2",
                        "#EF4444"
                ),

                createSensitiveRow(
                        "@",
                        "Email",
                        "aditi••••@gmail.com",
                        "Medium",
                        "#FEF3C7",
                        "#D97706"
                ),

                createSensitiveRow(
                        "☎",
                        "Phone Number",
                        "+91 98••••4210",
                        "Medium",
                        "#FEF3C7",
                        "#D97706"
                ),

                createSensitiveRow(
                        "⌂",
                        "Address",
                        "Sector 12, Noida",
                        "Low",
                        "#D1FAE5",
                        "#059669"
                )
        );

        // =========================================================
        // ACTION BUTTONS
        // =========================================================

        HBox actionBox =
                new HBox(10);

        actionBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        actionBox.setPadding(
                new Insets(15, 20, 18, 20)
        );

        Button continueButton =
                new Button(
                        "Continue as-is"
                );

        continueButton.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #D7E0EA;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: #1E293B;" +
                "-fx-padding: 8 16 8 16;"
        );

        Button redactButton =
                new Button(
                        "✎  Redact document"
                );

        redactButton.setStyle(
                "-fx-background-color: #3182F6;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 8 18 8 18;"
        );

        Label resultLabel =
                new Label();

        resultLabel.setStyle(
                "-fx-text-fill: #10B981;" +
                "-fx-font-size: 11px;"
        );

        continueButton.setOnAction(e -> {

            resultLabel.setText(
                    "Document will continue without redaction."
            );

            System.out.println(
                    "Continue as-is selected"
            );
        });

        redactButton.setOnAction(e -> {

            resultLabel.setText(
                    "Redaction process started."
            );

            System.out.println(
                    "Redact document clicked"
            );
        });

        actionBox.getChildren().addAll(
                resultLabel,
                continueButton,
                redactButton
        );

        sensitiveCard.getChildren().addAll(
                sensitiveHeader,
                informationList,
                actionBox
        );

        // =========================================================
        // ADD CONTENT
        // =========================================================

        content.getChildren().addAll(
                heading,
                description,
                scoreCard,
                sensitiveCard
        );

        // =========================================================
        // SCROLL
        // =========================================================

        ScrollPane scrollPane =
                new ScrollPane(content);

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: #F7FAFC;"
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

        privacyScanScene =
                new Scene(
                        root,
                        1300,
                        700
                );

        return privacyScanScene;
    }

    // =============================================================
    // SENSITIVE INFORMATION ROW
    // =============================================================

    private HBox createSensitiveRow(
            String iconText,
            String title,
            String value,
            String risk,
            String iconBackground,
            String iconColor) {

        HBox row =
                new HBox(15);

        row.setPadding(
                new Insets(12, 20, 12, 20)
        );

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setMinHeight(
                60
        );

        row.setStyle(
                "-fx-border-color: #E2E8F0;" +
                "-fx-border-width: 1 0 0 0;"
        );

        Label icon =
                new Label(iconText);

        icon.setAlignment(
                Pos.CENTER
        );

        icon.setStyle(
                "-fx-background-color: " +
                iconBackground + ";" +
                "-fx-background-radius: 50%;" +
                "-fx-text-fill: " +
                iconColor + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-min-width: 30px;" +
                "-fx-min-height: 30px;"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: #172033;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-text-fill: #64748B;" +
                "-fx-font-size: 10px;"
        );

        VBox information =
                new VBox(
                        2,
                        titleLabel,
                        valueLabel
                );

        HBox.setHgrow(
                information,
                Priority.ALWAYS
        );

        Label riskLabel =
                new Label(risk);

        riskLabel.setStyle(
                "-fx-background-color: white;" +
                "-fx-border-color: #D7E0EA;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: #334155;" +
                "-fx-font-size: 10px;" +
                "-fx-padding: 3 9 3 9;"
        );

        row.getChildren().addAll(
                icon,
                information,
                riskLabel
        );

        return row;
    }

    // =============================================================
    // SIDEBAR BUTTON
    // =============================================================

    private Button createSidebarButton(
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
                "-fx-text-fill: #26364A;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 10 10 10 10;"
        );

        button.setOnMouseEntered(e -> {

            if (!button.getStyle()
                    .contains("#3182F6")) {

                button.setStyle(
                        "-fx-background-color: #EFF6FF;" +
                        "-fx-background-radius: 10;" +
                        "-fx-text-fill: #1767C9;" +
                        "-fx-font-size: 13px;" +
                        "-fx-padding: 10 10 10 10;"
                );
            }
        });

        button.setOnMouseExited(e -> {

            if (!button.getStyle()
                    .contains("#3182F6")) {

                button.setStyle(
                        "-fx-background-color: transparent;" +
                        "-fx-text-fill: #26364A;" +
                        "-fx-font-size: 13px;" +
                        "-fx-padding: 10 10 10 10;"
                );
            }
        });

        return button;
    }

    // =============================================================
    // ACTIVE SIDEBAR BUTTON
    // =============================================================

    private void setActiveSidebarButton(
            Button button) {

        button.setStyle(
                "-fx-background-color: #3182F6;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 10 10 10;"
        );
    }
}