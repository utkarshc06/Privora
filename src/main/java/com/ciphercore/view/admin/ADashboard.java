package com.ciphercore.view.admin;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ADashboard {

    // =========================================================
    // COLORS
    // =========================================================

    private final String BACKGROUND = "#0B0910";
    private final String CARD = "#15131F";
    private final String CARD_BORDER = "#2A2538";

    private final String PURPLE = "#8B5CF6";
    private final String VIOLET = "#A78BFA";
    private final String DEEP_PURPLE = "#6D28D9";

    private final String TEXT = "#F5F3FF";
    private final String SECONDARY_TEXT = "#9D96B5";
    private final String MUTED_TEXT = "#827A96";


    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public ScrollPane getContent() {

        VBox main = new VBox();

        main.setSpacing(20);

        main.setPadding(
                new Insets(5, 5, 40, 5)
        );

        main.setStyle(
                "-fx-background-color: " + BACKGROUND + ";"
        );


        // =====================================================
        // HEADER
        // =====================================================

        HBox header = new HBox();

        header.setAlignment(
                Pos.CENTER_LEFT
        );


        VBox headingBox = new VBox(4);


        Label welcome = new Label(
                "Welcome back, Admin 👋"
        );

        welcome.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 26px;" +
                "-fx-font-weight: bold;"
        );


        Label subtitle = new Label(
                "Here's what's happening across PRIVORA today."
        );

        subtitle.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 13px;"
        );


        headingBox.getChildren().addAll(
                welcome,
                subtitle
        );


        HBox.setHgrow(
                headingBox,
                Priority.ALWAYS
        );


        // =====================================================
        // STATUS
        // =====================================================

        HBox statusBox = new HBox(8);

        statusBox.setAlignment(
                Pos.CENTER
        );


        StackPane statusCircle =
                new StackPane();

        statusCircle.setPrefSize(
                10,
                10
        );

        statusCircle.setMaxSize(
                10,
                10
        );

        statusCircle.setStyle(
                "-fx-background-color: #22D3A5;" +
                "-fx-background-radius: 50%;"
        );


        Label statusText =
                new Label("System Online");

        statusText.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );


        statusBox.getChildren().addAll(
                statusCircle,
                statusText
        );


        header.getChildren().addAll(
                headingBox,
                statusBox
        );


        // =====================================================
        // STATISTICS ROW 1
        // =====================================================

        HBox statisticsRow1 =
                new HBox(14);


        VBox usersCard =
                createStatCard(
                        "TOTAL USERS",
                        "1,284",
                        "+42 this month"
                );


        VBox centresCard =
                createStatCard(
                        "PRINT CENTRES",
                        "47",
                        "3 pending approval"
                );


        statisticsRow1.getChildren().addAll(
                usersCard,
                centresCard
        );


        HBox.setHgrow(
                usersCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                centresCard,
                Priority.ALWAYS
        );


        // =====================================================
        // STATISTICS ROW 2
        // =====================================================

        HBox statisticsRow2 =
                new HBox(14);


        VBox documentsCard =
                createStatCard(
                        "DOCUMENTS TODAY",
                        "312",
                        "+18% from yesterday"
                );


        VBox sessionsCard =
                createStatCard(
                        "ACTIVE SESSIONS",
                        "264",
                        "12 expiring soon"
                );


        statisticsRow2.getChildren().addAll(
                documentsCard,
                sessionsCard
        );


        HBox.setHgrow(
                documentsCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                sessionsCard,
                Priority.ALWAYS
        );


        // =====================================================
        // RECENT ACTIVITY
        // =====================================================

        VBox recentActivity =
                new VBox();

        recentActivity.setSpacing(0);

        recentActivity.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + CARD_BORDER + ";" +
                "-fx-border-radius: 18;" +
                "-fx-background-radius: 18;"
        );


        // -----------------------------------------------------
        // ACTIVITY HEADER
        // -----------------------------------------------------

        VBox activityHeader =
                new VBox(4);

        activityHeader.setPadding(
                new Insets(18, 22, 14, 22)
        );


        Label activityTitle =
                new Label("Recent activity");

        activityTitle.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );


        Label activitySubtitle =
                new Label(
                        "Latest events across the PRIVORA platform"
                );

        activitySubtitle.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 12px;"
        );


        activityHeader.getChildren().addAll(
                activityTitle,
                activitySubtitle
        );


        // -----------------------------------------------------
        // SEPARATOR
        // -----------------------------------------------------

        HBox separator =
                new HBox();

        separator.setPrefHeight(1);

        separator.setStyle(
                "-fx-background-color: " + CARD_BORDER + ";"
        );


        // -----------------------------------------------------
        // ACTIVITY LIST
        // -----------------------------------------------------

        VBox activityList =
                new VBox(3);

        activityList.setPadding(
                new Insets(12, 22, 16, 22)
        );


        activityList.getChildren().addAll(

                createActivity(
                        "♙",
                        "New user registered",
                        "Aditi Sharma",
                        "2 min ago"
                ),

                createActivity(
                        "▥",
                        "Centre approved",
                        "Sharma Xerox Point",
                        "15 min ago"
                ),

                createActivity(
                        "▤",
                        "Document uploaded",
                        "Secure document session",
                        "28 min ago"
                ),

                createActivity(
                        "▣",
                        "Print session completed",
                        "QuickPrint Hub",
                        "1 hr ago"
                )
        );


        recentActivity.getChildren().addAll(
                activityHeader,
                separator,
                activityList
        );


        // =====================================================
        // SYSTEM OVERVIEW
        // =====================================================

        VBox systemOverview =
                new VBox();

        systemOverview.setSpacing(0);

        systemOverview.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + CARD_BORDER + ";" +
                "-fx-border-radius: 18;" +
                "-fx-background-radius: 18;"
        );


        Label overviewTitle =
                new Label("System overview");

        overviewTitle.setPadding(
                new Insets(18, 22, 14, 22)
        );

        overviewTitle.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );


        HBox overviewSeparator =
                new HBox();

        overviewSeparator.setPrefHeight(1);

        overviewSeparator.setStyle(
                "-fx-background-color: " + CARD_BORDER + ";"
        );


        VBox overviewList =
                new VBox(3);

        overviewList.setPadding(
                new Insets(12, 22, 16, 22)
        );


        overviewList.getChildren().addAll(

                createOverviewRow(
                        "User accounts",
                        "1,284",
                        "Healthy"
                ),

                createOverviewRow(
                        "Registered centres",
                        "47",
                        "3 pending"
                ),

                createOverviewRow(
                        "Active document sessions",
                        "264",
                        "Normal"
                ),

                createOverviewRow(
                        "Privacy scans today",
                        "198",
                        "Secure"
                )
        );


        systemOverview.getChildren().addAll(
                overviewTitle,
                overviewSeparator,
                overviewList
        );


        // =====================================================
        // ADMIN TIP
        // =====================================================

        VBox adminTip =
                new VBox(7);

        adminTip.setPadding(
                new Insets(18, 22, 18, 22)
        );

        adminTip.setStyle(
                "-fx-background-color: linear-gradient(to right, "
                        + "#24134A, #32165E, #173C38);" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #4C3575;" +
                "-fx-border-radius: 18;"
        );


        Label tipIcon =
                new Label("✧");

        tipIcon.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 20px;"
        );


        Label tipTitle =
                new Label("Admin Tip");

        tipTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );


        Label tipText =
                new Label(
                        "Regularly review activity logs and pending centre "
                        + "approvals to keep the PRIVORA network secure."
                );

        tipText.setWrapText(true);

        tipText.setStyle(
                "-fx-text-fill: #D8D0EA;" +
                "-fx-font-size: 12px;"
        );


        adminTip.getChildren().addAll(
                tipIcon,
                tipTitle,
                tipText
        );


        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        main.getChildren().addAll(

                header,

                statisticsRow1,

                statisticsRow2,

                recentActivity,

                systemOverview,

                adminTip
        );


        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane();

        scrollPane.setContent(
                main
        );

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
                "-fx-background-color: " + BACKGROUND + ";" +
                "-fx-border-color: transparent;"
        );


        return scrollPane;
    }


    // =========================================================
    // STATISTICS CARD
    // =========================================================

    private VBox createStatCard(
            String title,
            String number,
            String bottomText) {


        VBox card =
                new VBox();

        card.setSpacing(4);

        card.setPadding(
                new Insets(16)
        );

        card.setMinHeight(105);

        card.setPrefHeight(105);

        card.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + CARD_BORDER + ";" +
                "-fx-border-radius: 16;" +
                "-fx-background-radius: 16;"
        );


        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: #9E96B1;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );


        Label numberLabel =
                new Label(number);

        numberLabel.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 25px;" +
                "-fx-font-weight: bold;"
        );


        Label bottomLabel =
                new Label(bottomText);

        bottomLabel.setStyle(
                "-fx-text-fill: " + VIOLET + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );


        card.getChildren().addAll(
                titleLabel,
                numberLabel,
                bottomLabel
        );


        return card;
    }


    // =========================================================
    // ACTIVITY ROW
    // =========================================================

    private HBox createActivity(
            String icon,
            String action,
            String person,
            String time) {


        HBox row =
                new HBox(12);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(7, 0, 7, 0)
        );


        // -----------------------------------------------------
        // ICON
        // -----------------------------------------------------

        StackPane iconBox =
                new StackPane();

        iconBox.setPrefSize(
                30,
                30
        );

        iconBox.setStyle(
                "-fx-background-color: #211B32;" +
                "-fx-background-radius: 8;"
        );


        Label iconLabel =
                new Label(icon);

        iconLabel.setStyle(
                "-fx-text-fill: " + VIOLET + ";" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );


        iconBox.getChildren().add(
                iconLabel
        );


        // -----------------------------------------------------
        // TEXT
        // -----------------------------------------------------

        VBox textBox =
                new VBox(2);


        Label actionLabel =
                new Label(action);

        actionLabel.setStyle(
                "-fx-text-fill: #E9E5F2;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );


        Label personLabel =
                new Label(person);

        personLabel.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 11px;"
        );


        textBox.getChildren().addAll(
                actionLabel,
                personLabel
        );


        HBox.setHgrow(
                textBox,
                Priority.ALWAYS
        );


        // -----------------------------------------------------
        // TIME
        // -----------------------------------------------------

        Label timeLabel =
                new Label(time);

        timeLabel.setStyle(
                "-fx-text-fill: " + MUTED_TEXT + ";" +
                "-fx-font-size: 11px;"
        );


        row.getChildren().addAll(
                iconBox,
                textBox,
                timeLabel
        );


        return row;
    }


    // =========================================================
    // SYSTEM OVERVIEW ROW
    // =========================================================

    private HBox createOverviewRow(
            String title,
            String value,
            String status) {


        HBox row =
                new HBox(12);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(8, 0, 8, 0)
        );


        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: #E9E5F2;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );


        HBox.setHgrow(
                titleLabel,
                Priority.ALWAYS
        );


        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );


        Label statusLabel =
                new Label(status);

        statusLabel.setStyle(
                "-fx-text-fill: " + VIOLET + ";" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );


        row.getChildren().addAll(
                titleLabel,
                valueLabel,
                statusLabel
        );


        return row;
    }
}