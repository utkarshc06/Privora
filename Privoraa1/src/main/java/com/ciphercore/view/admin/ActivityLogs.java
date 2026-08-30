package com.ciphercore.view.admin;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ActivityLogs {

    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public VBox getContent() {

        VBox content = new VBox(22);

        content.setPadding(
                new Insets(30)
        );

        content.setStyle(
                "-fx-background-color: #070D18;"
        );

        // =====================================================
        // HEADING
        // =====================================================

        Label title = new Label(
                "Activity Logs"
        );

        title.setStyle(
                "-fx-text-fill: #F8FAFC;" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Monitor important activities across the Privora platform."
        );

        subtitle.setStyle(
                "-fx-text-fill: #8D99AA;" +
                "-fx-font-size: 14px;"
        );

        VBox heading = new VBox(
                5,
                title,
                subtitle
        );

        // =====================================================
        // FILTER BAR
        // =====================================================

        HBox filterBar = new HBox(12);

        filterBar.setAlignment(
                Pos.CENTER_LEFT
        );

        filterBar.setPadding(
                new Insets(16)
        );

        filterBar.setStyle(
                "-fx-background-color: #101927;" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: #1D2939;" +
                "-fx-border-radius: 16;"
        );

        Button allButton = createFilterButton(
                "All Activities",
                true
        );

        Button userButton = createFilterButton(
                "Users",
                false
        );

        Button documentButton = createFilterButton(
                "Documents",
                false
        );

        Button securityButton = createFilterButton(
                "Security",
                false
        );

        HBox.setHgrow(
                allButton,
                Priority.NEVER
        );

        filterBar.getChildren().addAll(
                allButton,
                userButton,
                documentButton,
                securityButton
        );

        // =====================================================
        // ACTIVITY CARD
        // =====================================================

        VBox activityCard = new VBox();

        activityCard.setStyle(
                "-fx-background-color: #101927;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #1D2939;" +
                "-fx-border-radius: 18;"
        );

        // =====================================================
        // CARD HEADER
        // =====================================================

        HBox cardHeader = new HBox();

        cardHeader.setPadding(
                new Insets(20)
        );

        cardHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        Label activityTitle = new Label(
                "Recent Activity"
        );

        activityTitle.setStyle(
                "-fx-text-fill: #F8FAFC;" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );

        HBox.setHgrow(
                activityTitle,
                Priority.ALWAYS
        );

        Label count = new Label(
                "24 events"
        );

        count.setStyle(
                "-fx-text-fill: #6FAEFF;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        cardHeader.getChildren().addAll(
                activityTitle,
                count
        );

        activityCard.getChildren().add(
                cardHeader
        );

        // =====================================================
        // LOG 1
        // =====================================================

        VBox log1 = createLog(
                "U",
                "New user registered",
                "Aditi Sharma created a new User account.",
                "User Management",
                "2 minutes ago",
                "#2494F4"
        );

        // =====================================================
        // LOG 2
        // =====================================================

        VBox log2 = createLog(
                "D",
                "Document uploaded",
                "A secure document was uploaded to Privora.",
                "Documents",
                "8 minutes ago",
                "#2494F4"
        );

        // =====================================================
        // LOG 3
        // =====================================================

        VBox log3 = createLog(
                "C",
                "Centre verification completed",
                "Sharma Xerox Point was successfully verified.",
                "Centre Management",
                "21 minutes ago",
                "#00C897"
        );

        // =====================================================
        // LOG 4
        // =====================================================

        VBox log4 = createLog(
                "S",
                "Security setting updated",
                "Two-factor authentication was enabled for admins.",
                "Security",
                "35 minutes ago",
                "#A78BFA"
        );

        // =====================================================
        // LOG 5
        // =====================================================

        VBox log5 = createLog(
                "P",
                "Print session completed",
                "A secure printing session was completed successfully.",
                "Printing",
                "1 hour ago",
                "#00C897"
        );

        // =====================================================
        // LOG 6
        // =====================================================

        VBox log6 = createLog(
                "X",
                "Centre registration rejected",
                "A registered centre was rejected by the administrator.",
                "Centre Management",
                "2 hours ago",
                "#F05252"
        );

        // =====================================================
        // LOG 7
        // =====================================================

        VBox log7 = createLog(
                "A",
                "Admin login",
                "Admin Kapoor signed into the administration panel.",
                "Authentication",
                "3 hours ago",
                "#2494F4"
        );

        // =====================================================
        // LOG 8
        // =====================================================

        VBox log8 = createLog(
                "R",
                "Report generated",
                "A weekly platform report was generated.",
                "Reports",
                "5 hours ago",
                "#A78BFA"
        );

        activityCard.getChildren().addAll(
                log1,
                log2,
                log3,
                log4,
                log5,
                log6,
                log7,
                log8
        );

        // =====================================================
        // SECURITY INFORMATION
        // =====================================================

        HBox securityBox = new HBox(
                15
        );

        securityBox.setAlignment(
                Pos.CENTER_LEFT
        );

        securityBox.setPadding(
                new Insets(18)
        );

        securityBox.setStyle(
                "-fx-background-color: #0D1925;" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: #1B3345;" +
                "-fx-border-radius: 16;"
        );

        Circle securityCircle = new Circle(
                18
        );

        securityCircle.setFill(
                Color.web("#123E3B")
        );

        Label securityIcon = new Label(
                "✓"
        );

        securityIcon.setStyle(
                "-fx-text-fill: #00D7A3;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        VBox securityIconBox = new VBox(
                securityIcon
        );

        securityIconBox.setAlignment(
                Pos.CENTER
        );

        securityIconBox.setPrefWidth(
                36
        );

        securityIconBox.setPrefHeight(
                36
        );

        securityIconBox.setStyle(
                "-fx-background-color: #123E3B;" +
                "-fx-background-radius: 50%;"
        );

        VBox securityText = new VBox(
                3
        );

        Label securityTitle = new Label(
                "Security monitoring active"
        );

        securityTitle.setStyle(
                "-fx-text-fill: #F8FAFC;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        Label securityDescription = new Label(
                "All important platform activities are recorded for audit purposes."
        );

        securityDescription.setStyle(
                "-fx-text-fill: #7F8B9C;" +
                "-fx-font-size: 11px;"
        );

        securityText.getChildren().addAll(
                securityTitle,
                securityDescription
        );

        securityBox.getChildren().addAll(
                securityIconBox,
                securityText
        );

        // =====================================================
        // ADD CONTENT
        // =====================================================

        content.getChildren().addAll(
                heading,
                filterBar,
                activityCard,
                securityBox
        );

        return content;
    }

    // =========================================================
    // CREATE LOG
    // =========================================================

    private VBox createLog(
            String iconText,
            String title,
            String description,
            String category,
            String time,
            String iconColor
    ) {

        VBox container = new VBox();

        container.setPadding(
                new Insets(17, 20, 17, 20)
        );

        container.setSpacing(
                10
        );

        container.setStyle(
                "-fx-border-color: #1D2939;" +
                "-fx-border-width: 1 0 0 0;"
        );

        HBox row = new HBox(
                15
        );

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        // =====================================================
        // ICON
        // =====================================================

        VBox iconBox = new VBox();

        iconBox.setAlignment(
                Pos.CENTER
        );

        iconBox.setMinWidth(
                42
        );

        iconBox.setMaxWidth(
                42
        );

        iconBox.setMinHeight(
                42
        );

        iconBox.setMaxHeight(
                42
        );

        iconBox.setStyle(
                "-fx-background-color: " + iconColor + ";" +
                "-fx-background-radius: 50%;"
        );

        Label icon = new Label(
                iconText
        );

        icon.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        iconBox.getChildren().add(
                icon
        );

        // =====================================================
        // TEXT
        // =====================================================

        VBox textBox = new VBox(
                4
        );

        Label titleLabel = new Label(
                title
        );

        titleLabel.setStyle(
                "-fx-text-fill: #E9EEF5;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        Label descriptionLabel = new Label(
                description
        );

        descriptionLabel.setStyle(
                "-fx-text-fill: #7E8999;" +
                "-fx-font-size: 11px;"
        );

        textBox.getChildren().addAll(
                titleLabel,
                descriptionLabel
        );

        HBox.setHgrow(
                textBox,
                Priority.ALWAYS
        );

        // =====================================================
        // RIGHT SIDE
        // =====================================================

        VBox rightBox = new VBox(
                5
        );

        rightBox.setAlignment(
                Pos.CENTER_RIGHT
        );

        Label categoryLabel = new Label(
                category
        );

        categoryLabel.setStyle(
                "-fx-background-color: #182438;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: #9AA8BA;" +
                "-fx-font-size: 9px;" +
                "-fx-padding: 5 9;"
        );

        Label timeLabel = new Label(
                time
        );

        timeLabel.setStyle(
                "-fx-text-fill: #657285;" +
                "-fx-font-size: 9px;"
        );

        rightBox.getChildren().addAll(
                categoryLabel,
                timeLabel
        );

        row.getChildren().addAll(
                iconBox,
                textBox,
                rightBox
        );

        container.getChildren().add(
                row
        );

        return container;
    }

    // =========================================================
    // FILTER BUTTON
    // =========================================================

    private Button createFilterButton(
            String text,
            boolean selected
    ) {

        Button button = new Button(
                text
        );

        button.setPadding(
                new Insets(9, 16, 9, 16)
        );

        if (selected) {

            button.setStyle(
                    "-fx-background-color: #168DF5;" +
                    "-fx-background-radius: 10;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 11px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-cursor: hand;"
            );

        } else {

            button.setStyle(
                    "-fx-background-color: #141F31;" +
                    "-fx-background-radius: 10;" +
                    "-fx-text-fill: #8C98A9;" +
                    "-fx-font-size: 11px;" +
                    "-fx-cursor: hand;"
            );
        }

        return button;
    }
}