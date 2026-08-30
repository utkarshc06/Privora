package com.ciphercore.view.admin;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
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

    private final String CARD = "#15131F";
    private final String CARD_BORDER = "#2A2538";

    private final String PURPLE = "#8B5CF6";
    private final String VIOLET = "#A78BFA";
    private final String DEEP_PURPLE = "#6D28D9";

    private final String TEXT = "#F5F3FF";
    private final String SECONDARY_TEXT = "#9D96B5";


    // =========================================================
    // BUTTON REFERENCES
    // =========================================================

    private Button manageUsersButton;

    private HBox manageUsersAction;


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
                "-fx-background-color: #09080F;"
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
                "Here's what's happening with Privora today."
        );

        subtitle.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 13px;"
        );


        headingBox.getChildren().addAll(
                welcome,
                subtitle
        );


        // =====================================================
        // MANAGE USERS BUTTON
        // =====================================================

        manageUsersButton = new Button(
                "♙   Manage Users"
        );

        manageUsersButton.setStyle(
                "-fx-background-color: linear-gradient(to right, "
                        + PURPLE + ", " + DEEP_PURPLE + ");" +
                "-fx-background-radius: 22;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 18 10 18;" +
                "-fx-cursor: hand;"
        );


        // =====================================================
        // HOVER
        // =====================================================

        manageUsersButton.setOnMouseEntered(e -> {

            manageUsersButton.setStyle(
                    "-fx-background-color: linear-gradient(to right, "
                            + VIOLET + ", " + PURPLE + ");" +
                    "-fx-background-radius: 22;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 13px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 10 18 10 18;" +
                    "-fx-cursor: hand;"
            );

            manageUsersButton.setScaleX(1.03);
            manageUsersButton.setScaleY(1.03);

        });


        manageUsersButton.setOnMouseExited(e -> {

            manageUsersButton.setStyle(
                    "-fx-background-color: linear-gradient(to right, "
                            + PURPLE + ", " + DEEP_PURPLE + ");" +
                    "-fx-background-radius: 22;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 13px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 10 18 10 18;" +
                    "-fx-cursor: hand;"
            );

            manageUsersButton.setScaleX(1);
            manageUsersButton.setScaleY(1);

        });


        HBox.setHgrow(
                headingBox,
                Priority.ALWAYS
        );


        header.getChildren().addAll(
                headingBox,
                manageUsersButton
        );


        // =====================================================
        // STATISTICS ROW 1
        // =====================================================

        HBox statisticsRow1 = new HBox(14);


        VBox totalUsers = createStatCard(
                "TOTAL USERS",
                "128",
                "+8 this week"
        );


        VBox activeUsers = createStatCard(
                "ACTIVE USERS",
                "96",
                "75% active"
        );


        statisticsRow1.getChildren().addAll(
                totalUsers,
                activeUsers
        );


        HBox.setHgrow(
                totalUsers,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                activeUsers,
                Priority.ALWAYS
        );


        // =====================================================
        // STATISTICS ROW 2
        // =====================================================

        HBox statisticsRow2 = new HBox(14);


        VBox totalDocuments = createStatCard(
                "TOTAL DOCUMENTS",
                "342",
                "+24 this week"
        );


        VBox activeSessions = createStatCard(
                "ACTIVE SESSIONS",
                "12",
                "3 expiring soon"
        );


        statisticsRow2.getChildren().addAll(
                totalDocuments,
                activeSessions
        );


        HBox.setHgrow(
                totalDocuments,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                activeSessions,
                Priority.ALWAYS
        );


        // =====================================================
        // RECENT ACTIVITY
        // =====================================================

        VBox recentActivity = new VBox();

        recentActivity.setSpacing(0);

        recentActivity.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + CARD_BORDER + ";" +
                "-fx-border-radius: 18;" +
                "-fx-background-radius: 18;"
        );


        VBox activityHeader = new VBox(4);

        activityHeader.setPadding(
                new Insets(18, 22, 14, 22)
        );


        Label activityTitle = new Label(
                "Recent activity"
        );

        activityTitle.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );


        Label activitySubtitle = new Label(
                "Latest events across the system"
        );

        activitySubtitle.setStyle(
                "-fx-text-fill: " + SECONDARY_TEXT + ";" +
                "-fx-font-size: 12px;"
        );


        activityHeader.getChildren().addAll(
                activityTitle,
                activitySubtitle
        );


        HBox separator = new HBox();

        separator.setPrefHeight(1);

        separator.setStyle(
                "-fx-background-color: " + CARD_BORDER + ";"
        );


        VBox activityList = new VBox(3);

        activityList.setPadding(
                new Insets(12, 22, 16, 22)
        );


        activityList.getChildren().addAll(

                createActivity(
                        "♙",
                        "New user registered",
                        "5 min ago"
                ),

                createActivity(
                        "▣",
                        "Document uploaded by user",
                        "18 min ago"
                ),

                createActivity(
                        "◉",
                        "Printing session completed",
                        "42 min ago"
                ),

                createActivity(
                        "⚠",
                        "Session expired",
                        "1 hr ago"
                )
        );


        recentActivity.getChildren().addAll(
                activityHeader,
                separator,
                activityList
        );


        // =====================================================
        // QUICK ACTIONS
        // =====================================================

        VBox quickActions = new VBox();

        quickActions.setSpacing(0);

        quickActions.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + CARD_BORDER + ";" +
                "-fx-border-radius: 18;" +
                "-fx-background-radius: 18;"
        );


        Label quickTitle = new Label(
                "Quick actions"
        );

        quickTitle.setPadding(
                new Insets(18, 22, 14, 22)
        );

        quickTitle.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );


        HBox quickSeparator = new HBox();

        quickSeparator.setPrefHeight(1);

        quickSeparator.setStyle(
                "-fx-background-color: " + CARD_BORDER + ";"
        );


        VBox quickList = new VBox(10);

        quickList.setPadding(
                new Insets(15, 22, 20, 22)
        );


        // =====================================================
        // MANAGE USERS
        // =====================================================

        manageUsersAction =
                createQuickAction(
                        "♙",
                        "Manage Users"
                );


        // =====================================================
        // VIEW HISTORY
        // =====================================================

        HBox viewHistory =
                createQuickAction(
                        "〽",
                        "View History"
                );


        quickList.getChildren().addAll(
                manageUsersAction,
                viewHistory
        );


        quickActions.getChildren().addAll(
                quickTitle,
                quickSeparator,
                quickList
        );


        // =====================================================
        // ADMIN TIP
        // =====================================================

        VBox adminTip = new VBox(7);

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


        Label tipIcon = new Label(
                "✧"
        );

        tipIcon.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 20px;"
        );


        Label tipTitle = new Label(
                "Admin Tip"
        );

        tipTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );


        Label tipText = new Label(
                "Regularly review active sessions and expired "
                        + "documents to maintain system privacy."
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

                quickActions,

                adminTip
        );


        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane();

        scrollPane.setContent(main);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle(
                "-fx-background-color: #09080F;" +
                "-fx-border-color: transparent;"
        );


        return scrollPane;
    }


    // =========================================================
    // GET MANAGE USERS BUTTON
    // =========================================================

    public Button getManageUsersButton() {

        return manageUsersButton;
    }


    // =========================================================
    // GET MANAGE USERS ACTION
    // =========================================================

    public HBox getManageUsersAction() {

        return manageUsersAction;
    }


    // =========================================================
    // STATISTICS CARD
    // =========================================================

    private VBox createStatCard(
            String title,
            String number,
            String bottomText) {

        VBox card = new VBox();

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
    // ACTIVITY
    // =========================================================

    private HBox createActivity(
            String icon,
            String title,
            String time) {

        HBox row = new HBox(12);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(7, 0, 7, 0)
        );


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


        VBox textBox =
                new VBox(2);


        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: #E9E5F2;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );


        Label timeLabel =
                new Label(time);

        timeLabel.setStyle(
                "-fx-text-fill: #827A96;" +
                "-fx-font-size: 11px;"
        );


        textBox.getChildren().addAll(
                titleLabel,
                timeLabel
        );


        row.getChildren().addAll(
                iconBox,
                textBox
        );


        return row;
    }


    // =========================================================
    // QUICK ACTION
    // =========================================================

    private HBox createQuickAction(
            String icon,
            String text) {

        HBox row =
                new HBox(12);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(10, 14, 10, 14)
        );


        row.setStyle(
                "-fx-background-color: #11101A;" +
                "-fx-border-color: #29243A;" +
                "-fx-border-radius: 14;" +
                "-fx-background-radius: 14;" +
                "-fx-cursor: hand;"
        );


        StackPane iconBox =
                new StackPane();

        iconBox.setPrefSize(
                34,
                34
        );

        iconBox.setStyle(
                "-fx-background-color: #211B32;" +
                "-fx-background-radius: 9;"
        );


        Label iconLabel =
                new Label(icon);

        iconLabel.setStyle(
                "-fx-text-fill: " + VIOLET + ";" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );


        iconBox.getChildren().add(
                iconLabel
        );


        Label textLabel =
                new Label(text);

        textLabel.setStyle(
                "-fx-text-fill: #E9E5F2;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );


        Label arrow =
                new Label("›");

        arrow.setStyle(
                "-fx-text-fill: #958DA8;" +
                "-fx-font-size: 22px;"
        );


        HBox.setHgrow(
                textLabel,
                Priority.ALWAYS
        );


        row.getChildren().addAll(
                iconBox,
                textLabel,
                arrow
        );


        // =====================================================
        // HOVER
        // =====================================================

        row.setOnMouseEntered(e -> {

            row.setStyle(
                    "-fx-background-color: #1C1830;" +
                    "-fx-border-color: " + PURPLE + ";" +
                    "-fx-border-radius: 14;" +
                    "-fx-background-radius: 14;" +
                    "-fx-cursor: hand;"
            );

            row.setScaleX(1.01);
            row.setScaleY(1.01);

        });


        row.setOnMouseExited(e -> {

            row.setStyle(
                    "-fx-background-color: #11101A;" +
                    "-fx-border-color: #29243A;" +
                    "-fx-border-radius: 14;" +
                    "-fx-background-radius: 14;" +
                    "-fx-cursor: hand;"
            );

            row.setScaleX(1);
            row.setScaleY(1);

        });


        return row;
    }
}