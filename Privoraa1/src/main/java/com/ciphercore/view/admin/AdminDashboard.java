package com.ciphercore.view.admin;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class AdminDashboard {

    private Scene adminDashboardScene;

    // =========================================================
    // COLORS
    // =========================================================

    private final String BG = "#0B0A10";
    private final String CARD = "#15121D";
    private final String CARD2 = "#1B1625";
    private final String PURPLE = "#8B5CF6";
    private final String PURPLE_LIGHT = "#A855F7";
    private final String TEXT = "#FFFFFF";
    private final String MUTED = "#91869F";
    private final String BORDER = "#302640";

    // =========================================================
    // ADMIN DASHBOARD SCENE
    // =========================================================

    public Scene getAdminDashboardScene(Runnable logoutAction) {

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color: " + BG + ";"
        );

        // =====================================================
        // TOP BAR
        // =====================================================

        HBox topBar = new HBox();

        topBar.setPadding(
                new Insets(14, 25, 14, 25)
        );

        topBar.setAlignment(
                Pos.CENTER_LEFT
        );

        topBar.setSpacing(15);

        topBar.setStyle(
                "-fx-background-color: #11101A;" +
                "-fx-border-color: #2B2438;" +
                "-fx-border-width: 0 0 1 0;"
        );

        // LOGO

        Label logo = new Label("PRIVORA");

        logo.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 21px;" +
                "-fx-font-weight: bold;"
        );

        Label adminLabel = new Label("ADMIN");

        adminLabel.setStyle(
                "-fx-text-fill: #C4B5FD;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-color: #211A32;" +
                "-fx-background-radius: 12;" +
                "-fx-padding: 5 10 5 10;"
        );

        HBox logoBox = new HBox(
                10,
                logo,
                adminLabel
        );

        logoBox.setAlignment(
                Pos.CENTER_LEFT
        );

        // SPACER

        HBox spacer = new HBox();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        // ONLINE STATUS

        Label status = new Label(
                "● System Online"
        );

        status.setStyle(
                "-fx-text-fill: #86EFAC;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        // PROFILE

        Label profileLabel = new Label(
                "Administrator"
        );

        profileLabel.setStyle(
                "-fx-text-fill: #C7C1D4;" +
                "-fx-font-size: 12px;"
        );

        // LOGOUT

        Button logoutButton = new Button(
                "Logout"
        );

        logoutButton.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: #F87171;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 15;" +
                "-fx-border-color: #5B2630;" +
                "-fx-border-radius: 15;" +
                "-fx-padding: 7 15 7 15;" +
                "-fx-cursor: hand;"
        );

        logoutButton.setOnMouseEntered(e -> {

            logoutButton.setStyle(
                    "-fx-background-color: #3A1820;" +
                    "-fx-text-fill: #FF8A8A;" +
                    "-fx-font-size: 12px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 15;" +
                    "-fx-border-color: #7F303A;" +
                    "-fx-border-radius: 15;" +
                    "-fx-padding: 7 15 7 15;" +
                    "-fx-cursor: hand;"
            );
        });

        logoutButton.setOnMouseExited(e -> {

            logoutButton.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: #F87171;" +
                    "-fx-font-size: 12px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 15;" +
                    "-fx-border-color: #5B2630;" +
                    "-fx-border-radius: 15;" +
                    "-fx-padding: 7 15 7 15;" +
                    "-fx-cursor: hand;"
            );
        });

        logoutButton.setOnAction(e -> {

            if (logoutAction != null) {
                logoutAction.run();
            }
        });

        topBar.getChildren().addAll(
                logoBox,
                spacer,
                status,
                profileLabel,
                logoutButton
        );

        // =====================================================
        // SIDEBAR
        // =====================================================

        VBox sidebar = new VBox();

        sidebar.setPadding(
                new Insets(25, 15, 25, 15)
        );

        sidebar.setSpacing(8);

        sidebar.setPrefWidth(
                225
        );

        sidebar.setStyle(
                "-fx-background-color: #11101A;" +
                "-fx-border-color: #2B2438;" +
                "-fx-border-width: 0 1 0 0;"
        );

        Label menuTitle = new Label(
                "ADMIN PANEL"
        );

        menuTitle.setPadding(
                new Insets(0, 0, 12, 10)
        );

        menuTitle.setStyle(
                "-fx-text-fill: #746A85;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        Button dashboardButton =
                createMenuButton("▣   Dashboard");

        Button usersButton =
                createMenuButton("♙   Users");

        Button requestsButton =
                createMenuButton("▤   Requests");

        Button centresButton =
                createMenuButton("▥   Xerox Centres");

        Button sessionsButton =
                createMenuButton("◉   Active Sessions");

        Button historyButton =
                createMenuButton("◷   History");

        Button settingsButton =
                createMenuButton("⚙   Settings");

        sidebar.getChildren().addAll(
                menuTitle,
                dashboardButton,
                usersButton,
                requestsButton,
                centresButton,
                sessionsButton,
                historyButton,
                settingsButton
        );

        // =====================================================
        // CONTENT
        // =====================================================

        VBox contentArea = new VBox();

        contentArea.setPadding(
                new Insets(35)
        );

        contentArea.setSpacing(
                20
        );

        contentArea.setStyle(
                "-fx-background-color: #0B0A10;"
        );

        showDashboard(contentArea);

        // =====================================================
        // SCROLL
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane(contentArea);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle(
                "-fx-background-color: #0B0A10;" +
                "-fx-background: #0B0A10;" +
                "-fx-border-width: 0;"
        );

        // =====================================================
        // BUTTON ACTIONS
        // =====================================================

        dashboardButton.setOnAction(e ->
                showDashboard(contentArea)
        );

        usersButton.setOnAction(e ->
                showUsers(contentArea)
        );

        requestsButton.setOnAction(e ->
                showRequests(contentArea)
        );

        centresButton.setOnAction(e ->
                showCentres(contentArea)
        );

        sessionsButton.setOnAction(e ->
                showActiveSessions(contentArea)
        );

        historyButton.setOnAction(e ->
                showHistory(contentArea)
        );

        settingsButton.setOnAction(e ->
                showSettings(contentArea)
        );

        // =====================================================
        // ROOT
        // =====================================================

        root.setTop(topBar);
        root.setLeft(sidebar);
        root.setCenter(scrollPane);

        adminDashboardScene =
                new Scene(
                        root,
                        1300,
                        700
                );

        return adminDashboardScene;
    }

    // =========================================================
    // MENU BUTTON
    // =========================================================

    private Button createMenuButton(String text) {

        Button button = new Button(text);

        button.setMaxWidth(
                Double.MAX_VALUE
        );

        button.setAlignment(
                Pos.CENTER_LEFT
        );

        button.setPadding(
                new Insets(12, 15, 12, 15)
        );

        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: #A9A1B8;" +
                "-fx-font-size: 13px;" +
                "-fx-background-radius: 10;" +
                "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e -> {

            button.setStyle(
                    "-fx-background-color: #241A32;" +
                    "-fx-text-fill: #D8C8FF;" +
                    "-fx-font-size: 13px;" +
                    "-fx-background-radius: 10;" +
                    "-fx-cursor: hand;" +
                    "-fx-border-color: #4C3570;" +
                    "-fx-border-radius: 10;"
            );
        });

        button.setOnMouseExited(e -> {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: #A9A1B8;" +
                    "-fx-font-size: 13px;" +
                    "-fx-background-radius: 10;" +
                    "-fx-cursor: hand;"
            );
        });

        return button;
    }

    // =========================================================
    // DASHBOARD
    // =========================================================

    private void showDashboard(VBox contentArea) {

        contentArea.getChildren().clear();

        HBox heading =
                createPageHeading(
                        "Admin Dashboard",
                        "Monitor and control the PRIVORA platform."
                );

        // =====================================================
        // STAT CARDS
        // =====================================================

        HBox cards = new HBox(15);

        cards.getChildren().addAll(

                createStatCard(
                        "TOTAL USERS",
                        "24",
                        "↑ 12% this month",
                        "♙"
                ),

                createStatCard(
                        "PENDING REQUESTS",
                        "08",
                        "Requires attention",
                        "▤"
                ),

                createStatCard(
                        "XEROX CENTRES",
                        "06",
                        "5 currently online",
                        "▥"
                ),

                createStatCard(
                        "ACTIVE SESSIONS",
                        "03",
                        "Live right now",
                        "◉"
                )
        );

        for (javafx.scene.Node node :
                cards.getChildren()) {

            HBox.setHgrow(
                    node,
                    Priority.ALWAYS
            );
        }

        // =====================================================
        // LOWER SECTION
        // =====================================================

        HBox lower = new HBox(18);

        VBox activity =
                createActivityPanel();

        VBox overview =
                createOverviewPanel();

        HBox.setHgrow(
                activity,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                overview,
                Priority.ALWAYS
        );

        lower.getChildren().addAll(
                activity,
                overview
        );

        // =====================================================
        // QUICK ACTIONS
        // =====================================================

        VBox quickActions =
                createQuickActions(
                        contentArea
                );

        contentArea.getChildren().addAll(
                heading,
                cards,
                lower,
                quickActions
        );
    }

    // =========================================================
    // PAGE HEADING
    // =========================================================

    private HBox createPageHeading(
            String titleText,
            String subtitleText) {

        Label title =
                new Label(titleText);

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(subtitleText);

        subtitle.setStyle(
                "-fx-text-fill: #81778F;" +
                "-fx-font-size: 13px;"
        );

        VBox text =
                new VBox(
                        5,
                        title,
                        subtitle
                );

        HBox box =
                new HBox(text);

        box.setAlignment(
                Pos.CENTER_LEFT
        );

        return box;
    }

    // =========================================================
    // STAT CARD
    // =========================================================

    private VBox createStatCard(
            String titleText,
            String valueText,
            String footerText,
            String iconText) {

        VBox card =
                new VBox(10);

        card.setPadding(
                new Insets(20)
        );

        card.setMinHeight(
                140
        );

        card.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #17131F, #211832);" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #392B4D;" +
                "-fx-border-radius: 18;"
        );

        Label icon =
                new Label(iconText);

        icon.setStyle(
                "-fx-background-color: #2A1D3D;" +
                "-fx-background-radius: 12;" +
                "-fx-text-fill: #C4B5FD;" +
                "-fx-font-size: 18px;" +
                "-fx-padding: 9 12 9 12;"
        );

        Label title =
                new Label(titleText);

        title.setStyle(
                "-fx-text-fill: #8F849F;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        Label value =
                new Label(valueText);

        value.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;"
        );

        Label footer =
                new Label(footerText);

        footer.setStyle(
                "-fx-text-fill: #A78BFA;" +
                "-fx-font-size: 10px;"
        );

        card.getChildren().addAll(
                icon,
                title,
                value,
                footer
        );

        addHover(card);

        return card;
    }

    // =========================================================
    // ACTIVITY PANEL
    // =========================================================

    private VBox createActivityPanel() {

        VBox panel =
                createPanel();

        Label title =
                new Label("Recent Activity");

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "Latest actions across PRIVORA"
                );

        subtitle.setStyle(
                "-fx-text-fill: #81778F;" +
                "-fx-font-size: 11px;"
        );

        VBox list =
                new VBox(12);

        list.getChildren().addAll(

                createActivity(
                        "Raju",
                        "uploaded a document",
                        "2 min ago",
                        "▤"
                ),

                createActivity(
                        "Sujay Xerox",
                        "completed a print request",
                        "8 min ago",
                        "✓"
                ),

                createActivity(
                        "Aarav",
                        "started a secure session",
                        "15 min ago",
                        "◉"
                ),

                createActivity(
                        "Priya",
                        "created an account",
                        "23 min ago",
                        "♙"
                )
        );

        panel.getChildren().addAll(
                title,
                subtitle,
                list
        );

        return panel;
    }

    // =========================================================
    // ACTIVITY ITEM
    // =========================================================

    private HBox createActivity(
            String name,
            String action,
            String time,
            String iconText) {

        Label icon =
                new Label(iconText);

        icon.setStyle(
                "-fx-background-color: #271C3A;" +
                "-fx-background-radius: 50%;" +
                "-fx-text-fill: #C4B5FD;" +
                "-fx-padding: 8;"
        );

        Label main =
                new Label(
                        name + "  " + action
                );

        main.setStyle(
                "-fx-text-fill: #D8D1E3;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        Label timeLabel =
                new Label(time);

        timeLabel.setStyle(
                "-fx-text-fill: #756B82;" +
                "-fx-font-size: 10px;"
        );

        VBox text =
                new VBox(
                        3,
                        main,
                        timeLabel
                );

        HBox row =
                new HBox(
                        10,
                        icon,
                        text
                );

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        return row;
    }

    // =========================================================
    // OVERVIEW
    // =========================================================

    private VBox createOverviewPanel() {

        VBox panel =
                createPanel();

        Label title =
                new Label("Platform Overview");

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "Current platform statistics"
                );

        subtitle.setStyle(
                "-fx-text-fill: #81778F;" +
                "-fx-font-size: 11px;"
        );

        VBox stats =
                new VBox(14);

        stats.getChildren().addAll(

                createProgressRow(
                        "Documents processed",
                        "78%"
                ),

                createProgressRow(
                        "Successful sessions",
                        "91%"
                ),

                createProgressRow(
                        "Centre availability",
                        "84%"
                ),

                createProgressRow(
                        "Privacy compliance",
                        "96%"
                )
        );

        panel.getChildren().addAll(
                title,
                subtitle,
                stats
        );

        return panel;
    }

    // =========================================================
    // PROGRESS ROW
    // =========================================================

    private VBox createProgressRow(
            String text,
            String percentage) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-text-fill: #C5BDD2;" +
                "-fx-font-size: 11px;"
        );

        Label value =
                new Label(percentage);

        value.setStyle(
                "-fx-text-fill: #A78BFA;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        HBox top =
                new HBox(
                        label,
                        value
                );

        HBox.setHgrow(
                label,
                Priority.ALWAYS
        );

        // Fake progress bar

        StackPane bar =
                new StackPane();

        bar.setMinHeight(8);

        bar.setMaxHeight(8);

        bar.setStyle(
                "-fx-background-color: #292231;" +
                "-fx-background-radius: 8;"
        );

        Label progress =
                new Label();

        progress.setStyle(
                "-fx-background-color: linear-gradient(to right, #7C3AED, #A855F7);" +
                "-fx-background-radius: 8;"
        );

        double width =
                Double.parseDouble(
                        percentage.replace("%", "")
                );

        progress.setPrefWidth(
                width * 1.5
        );

        StackPane.setAlignment(
                progress,
                Pos.CENTER_LEFT
        );

        bar.getChildren().add(
                progress
        );

        VBox row =
                new VBox(
                        6,
                        top,
                        bar
                );

        return row;
    }

    // =========================================================
    // QUICK ACTIONS
    // =========================================================

    private VBox createQuickActions(
            VBox contentArea) {

        VBox panel =
                createPanel();

        Label title =
                new Label("Quick Actions");

        title.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );

        HBox buttons =
                new HBox(12);

        Button users =
                createActionButton(
                        "Manage Users"
                );

        Button requests =
                createActionButton(
                        "Review Requests"
                );

        Button centres =
                createActionButton(
                        "View Centres"
                );

        buttons.getChildren().addAll(
                users,
                requests,
                centres
        );

        panel.getChildren().addAll(
                title,
                buttons
        );

        return panel;
    }

    // =========================================================
    // ACTION BUTTON
    // =========================================================

    private Button createActionButton(
            String text) {

        Button button =
                new Button(text);

        button.setPrefWidth(160);

        button.setPrefHeight(42);

        button.setStyle(
                "-fx-background-color: #241A32;" +
                "-fx-text-fill: #CFC3E8;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 12;" +
                "-fx-border-color: #49355F;" +
                "-fx-border-radius: 12;" +
                "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e -> {

            button.setStyle(
                    "-fx-background-color: #7C3AED;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 11px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 12;" +
                    "-fx-border-color: #A855F7;" +
                    "-fx-border-radius: 12;" +
                    "-fx-cursor: hand;"
            );
        });

        button.setOnMouseExited(e -> {

            button.setStyle(
                    "-fx-background-color: #241A32;" +
                    "-fx-text-fill: #CFC3E8;" +
                    "-fx-font-size: 11px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-background-radius: 12;" +
                    "-fx-border-color: #49355F;" +
                    "-fx-border-radius: 12;" +
                    "-fx-cursor: hand;"
            );
        });

        return button;
    }

    // =========================================================
    // USERS
    // =========================================================

    private void showUsers(VBox contentArea) {

        contentArea.getChildren().clear();

        contentArea.getChildren().add(
                createPageHeading(
                        "Users",
                        "Manage PRIVORA user accounts."
                )
        );

        HBox cards =
                new HBox(15);

        cards.getChildren().addAll(
                createUserCard(
                        "Raju",
                        "raju@example.com",
                        "Active"
                ),

                createUserCard(
                        "Aarav",
                        "aarav@example.com",
                        "Active"
                ),

                createUserCard(
                        "Priya",
                        "priya@example.com",
                        "Active"
                )
        );

        contentArea.getChildren().add(cards);
    }

    // =========================================================
    // USER CARD
    // =========================================================

    private VBox createUserCard(
            String name,
            String email,
            String statusText) {

        VBox card =
                createPanel();

        Label avatar =
                new Label(
                        name.substring(0, 1).toUpperCase()
                );

        avatar.setStyle(
                "-fx-background-color: #7C3AED;" +
                "-fx-background-radius: 50%;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 12;"
        );

        Label nameLabel =
                new Label(name);

        nameLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;"
        );

        Label emailLabel =
                new Label(email);

        emailLabel.setStyle(
                "-fx-text-fill: #8F849F;" +
                "-fx-font-size: 11px;"
        );

        Label status =
                new Label(
                        "● " + statusText
                );

        status.setStyle(
                "-fx-text-fill: #86EFAC;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        card.getChildren().addAll(
                avatar,
                nameLabel,
                emailLabel,
                status
        );

        addHover(card);

        return card;
    }

    // =========================================================
    // REQUESTS
    // =========================================================

    private void showRequests(VBox contentArea) {

        contentArea.getChildren().clear();

        contentArea.getChildren().add(
                createPageHeading(
                        "Print Requests",
                        "Review and monitor document printing requests."
                )
        );

        contentArea.getChildren().addAll(

                createRequest(
                        "Raju",
                        "College_Project.pdf",
                        "Sujay Xerox",
                        "Pending"
                ),

                createRequest(
                        "Aarav",
                        "Resume.pdf",
                        "Secure Prints",
                        "Processing"
                ),

                createRequest(
                        "Priya",
                        "Certificate.pdf",
                        "Campus Xerox",
                        "Completed"
                )
        );
    }

    // =========================================================
    // REQUEST CARD
    // =========================================================

    private VBox createRequest(
            String user,
            String document,
            String centre,
            String statusText) {

        VBox card =
                createPanel();

        HBox top =
                new HBox();

        Label doc =
                new Label(
                        "▤  " + document
                );

        doc.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        Label status =
                new Label(statusText);

        status.setStyle(
                "-fx-text-fill: #C4B5FD;" +
                "-fx-background-color: #2B1E40;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 5 10 5 10;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        HBox.setHgrow(
                doc,
                Priority.ALWAYS
        );

        top.getChildren().addAll(
                doc,
                status
        );

        Label details =
                new Label(
                        "User: " + user +
                        "     •     Centre: " + centre
                );

        details.setStyle(
                "-fx-text-fill: #91869F;" +
                "-fx-font-size: 11px;"
        );

        card.getChildren().addAll(
                top,
                details
        );

        addHover(card);

        return card;
    }

    // =========================================================
    // CENTRES
    // =========================================================

    private void showCentres(VBox contentArea) {

        contentArea.getChildren().clear();

        contentArea.getChildren().add(
                createPageHeading(
                        "Xerox Centres",
                        "Monitor registered printing centres."
                )
        );

        HBox cards =
                new HBox(15);

        cards.getChildren().addAll(

                createCentreCard(
                        "Sujay Xerox",
                        "Pune",
                        "Online",
                        "12"
                ),

                createCentreCard(
                        "Campus Xerox",
                        "Sinhgad Road",
                        "Online",
                        "08"
                ),

                createCentreCard(
                        "Secure Prints",
                        "Kothrud",
                        "Offline",
                        "00"
                )
        );

        contentArea.getChildren().add(cards);
    }

    // =========================================================
    // CENTRE CARD
    // =========================================================

    private VBox createCentreCard(
            String name,
            String location,
            String statusText,
            String jobs) {

        VBox card =
                createPanel();

        Label nameLabel =
                new Label(name);

        nameLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );

        Label locationLabel =
                new Label(
                        "⌖ " + location
                );

        locationLabel.setStyle(
                "-fx-text-fill: #91869F;" +
                "-fx-font-size: 11px;"
        );

        Label status =
                new Label(
                        "● " + statusText
                );

        status.setStyle(
                statusText.equals("Online")
                        ? "-fx-text-fill: #86EFAC; -fx-font-size: 11px; -fx-font-weight: bold;"
                        : "-fx-text-fill: #F87171; -fx-font-size: 11px; -fx-font-weight: bold;"
        );

        Label jobsLabel =
                new Label(
                        "Active jobs: " + jobs
                );

        jobsLabel.setStyle(
                "-fx-text-fill: #A78BFA;" +
                "-fx-font-size: 11px;"
        );

        card.getChildren().addAll(
                nameLabel,
                locationLabel,
                status,
                jobsLabel
        );

        addHover(card);

        return card;
    }

    // =========================================================
    // ACTIVE SESSIONS
    // =========================================================

    private void showActiveSessions(VBox contentArea) {

        contentArea.getChildren().clear();

        contentArea.getChildren().add(
                createPageHeading(
                        "Active Sessions",
                        "Monitor live secure document sessions."
                )
        );

        contentArea.getChildren().addAll(

                createSessionCard(
                        "Raju",
                        "College_Project.pdf",
                        "Sujay Xerox",
                        "04:32"
                ),

                createSessionCard(
                        "Aarav",
                        "Resume.pdf",
                        "Campus Xerox",
                        "02:15"
                ),

                createSessionCard(
                        "Priya",
                        "Certificate.pdf",
                        "Secure Prints",
                        "00:58"
                )
        );
    }

    // =========================================================
    // SESSION CARD
    // =========================================================

    private VBox createSessionCard(
            String user,
            String document,
            String centre,
            String time) {

        VBox card =
                createPanel();

        Label session =
                new Label(
                        "● LIVE SESSION"
                );

        session.setStyle(
                "-fx-text-fill: #86EFAC;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        Label doc =
                new Label(
                        document
                );

        doc.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;"
        );

        Label details =
                new Label(
                        "User: " + user +
                        "   •   Centre: " + centre
                );

        details.setStyle(
                "-fx-text-fill: #91869F;" +
                "-fx-font-size: 11px;"
        );

        Label timer =
                new Label(
                        "Session time: " + time
                );

        timer.setStyle(
                "-fx-text-fill: #C4B5FD;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        card.getChildren().addAll(
                session,
                doc,
                details,
                timer
        );

        addHover(card);

        return card;
    }

    // =========================================================
    // HISTORY
    // =========================================================

    private void showHistory(VBox contentArea) {

        contentArea.getChildren().clear();

        contentArea.getChildren().add(
                createPageHeading(
                        "History",
                        "Completed document requests and sessions."
                )
        );

        contentArea.getChildren().addAll(

                createHistoryRow(
                        "College_Project.pdf",
                        "Raju",
                        "Sujay Xerox",
                        "Completed",
                        "Today"
                ),

                createHistoryRow(
                        "Resume.pdf",
                        "Aarav",
                        "Campus Xerox",
                        "Completed",
                        "Today"
                ),

                createHistoryRow(
                        "Certificate.pdf",
                        "Priya",
                        "Secure Prints",
                        "Completed",
                        "Yesterday"
                ),

                createHistoryRow(
                        "Assignment.pdf",
                        "Om",
                        "Sujay Xerox",
                        "Expired",
                        "Yesterday"
                )
        );
    }

    // =========================================================
    // HISTORY ROW
    // =========================================================

    private VBox createHistoryRow(
            String document,
            String user,
            String centre,
            String statusText,
            String date) {

        VBox card =
                createPanel();

        HBox top =
                new HBox();

        Label doc =
                new Label(
                        "▤  " + document
                );

        doc.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        Label status =
                new Label(
                        statusText
                );

        status.setStyle(
                statusText.equals("Completed")
                        ? "-fx-text-fill: #86EFAC; -fx-background-color: #183322; -fx-background-radius: 10; -fx-padding: 5 10 5 10; -fx-font-size: 10px;"
                        : "-fx-text-fill: #FBBF24; -fx-background-color: #352A18; -fx-background-radius: 10; -fx-padding: 5 10 5 10; -fx-font-size: 10px;"
        );

        HBox.setHgrow(
                doc,
                Priority.ALWAYS
        );

        top.getChildren().addAll(
                doc,
                status
        );

        Label details =
                new Label(
                        "User: " + user +
                        "   •   Centre: " + centre +
                        "   •   " + date
                );

        details.setStyle(
                "-fx-text-fill: #91869F;" +
                "-fx-font-size: 11px;"
        );

        card.getChildren().addAll(
                top,
                details
        );

        return card;
    }

    // =========================================================
    // SETTINGS
    // =========================================================

    private void showSettings(VBox contentArea) {

        contentArea.getChildren().clear();

        contentArea.getChildren().add(
                createPageHeading(
                        "Settings",
                        "Configure administrator and platform preferences."
                )
        );

        VBox security =
                createSettingCard(
                        "Security",
                        "Session timeout",
                        "15 minutes"
                );

        VBox privacy =
                createSettingCard(
                        "Privacy",
                        "Automatic document expiry",
                        "Enabled"
                );

        VBox notifications =
                createSettingCard(
                        "Notifications",
                        "Admin alerts",
                        "Enabled"
                );

        contentArea.getChildren().addAll(
                security,
                privacy,
                notifications
        );
    }

    // =========================================================
    // SETTING CARD
    // =========================================================

    private VBox createSettingCard(
            String section,
            String setting,
            String value) {

        VBox card =
                createPanel();

        Label sectionLabel =
                new Label(section);

        sectionLabel.setStyle(
                "-fx-text-fill: #A78BFA;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        Label settingLabel =
                new Label(setting);

        settingLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        Label valueLabel =
                new Label(value);

        valueLabel.setStyle(
                "-fx-text-fill: #C4B5FD;" +
                "-fx-background-color: #271C3A;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 6 12 6 12;" +
                "-fx-font-size: 10px;"
        );

        HBox row =
                new HBox(
                        settingLabel,
                        valueLabel
                );

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        HBox.setHgrow(
                settingLabel,
                Priority.ALWAYS
        );

        card.getChildren().addAll(
                sectionLabel,
                row
        );

        addHover(card);

        return card;
    }

    // =========================================================
    // PANEL
    // =========================================================

    private VBox createPanel() {

        VBox panel =
                new VBox(12);

        panel.setPadding(
                new Insets(20)
        );

        panel.setStyle(
                "-fx-background-color: #15121D;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #302640;" +
                "-fx-border-radius: 18;"
        );

        return panel;
    }

    // =========================================================
    // HOVER
    // =========================================================

    private void addHover(
            VBox node) {

        ScaleTransition up =
                new ScaleTransition(
                        Duration.millis(120),
                        node
                );

        up.setToX(1.02);
        up.setToY(1.02);

        ScaleTransition down =
                new ScaleTransition(
                        Duration.millis(120),
                        node
                );

        down.setToX(1.0);
        down.setToY(1.0);

        node.setOnMouseEntered(e -> {

            down.stop();
            up.playFromStart();

            node.setStyle(
                    "-fx-background-color: #211832;" +
                    "-fx-background-radius: 18;" +
                    "-fx-border-color: #7546B8;" +
                    "-fx-border-radius: 18;" +
                    "-fx-effect: dropshadow(gaussian, rgba(139,92,246,0.35), 20, 0.3, 0, 5);"
            );
        });

        node.setOnMouseExited(e -> {

            up.stop();
            down.playFromStart();

            node.setStyle(
                    "-fx-background-color: #15121D;" +
                    "-fx-background-radius: 18;" +
                    "-fx-border-color: #302640;" +
                    "-fx-border-radius: 18;"
            );
        });
    }
}
