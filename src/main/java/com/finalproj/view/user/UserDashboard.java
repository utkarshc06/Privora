package com.finalproj.view.user;

import com.finalproj.view.user.Profile;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class UserDashboard {

    private Scene dashboardScene;

    private BorderPane root;
    private VBox contentArea;

    private Button dashboardButton;
    private Button uploadButton;
    private Button documentsButton;
    private Button activityButton;
    private Button profileButton;

    // =========================================================
    // DASHBOARD SCENE
    // =========================================================

    public Scene getDashboardScene(Runnable logout) {

        root = new BorderPane();

        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #020713, #06152D, #020713);"
        );

        // =====================================================
        // TOP BAR
        // =====================================================

        HBox topBar = new HBox();

        topBar.setPadding(
                new Insets(15, 28, 15, 28)
        );

        topBar.setAlignment(
                Pos.CENTER_LEFT
        );

        Label logo = new Label("PRIVORA");

        logo.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );

        Label pageTitle = new Label(
                "  /  User Dashboard"
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

        // =====================================================
        // USER PROFILE
        // =====================================================

        Label userIcon = new Label("U");

        userIcon.setAlignment(Pos.CENTER);

        userIcon.setStyle(
                "-fx-background-color: #1767C9;" +
                "-fx-background-radius: 50%;" +
                "-fx-text-fill: white;" +
                "-fx-font-weight: bold;" +
                "-fx-min-width: 34px;" +
                "-fx-min-height: 34px;"
        );

        Label userName = new Label("User");

        userName.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        Label userRole = new Label("Document Owner");

        userRole.setStyle(
                "-fx-text-fill: #71829A;" +
                "-fx-font-size: 10px;"
        );

        VBox userInfo = new VBox(
                1,
                userName,
                userRole
        );

        HBox profileBox = new HBox(
                10,
                userIcon,
                userInfo
        );

        profileBox.setAlignment(
                Pos.CENTER_LEFT
        );

        // =====================================================
        // LOGOUT
        // =====================================================

        Button logoutButton = new Button("Logout");

        logoutButton.setStyle(
                "-fx-background-color: #0B162A;" +
                "-fx-border-color: #263653;" +
                "-fx-border-radius: 15;" +
                "-fx-background-radius: 15;" +
                "-fx-text-fill: #B8C5D6;" +
                "-fx-padding: 8 16 8 16;"
        );

        logoutButton.setOnAction(e -> {

            System.out.println("Logout clicked");

            logout.run();
        });

        HBox rightTop = new HBox(
                15,
                profileBox,
                logoutButton
        );

        rightTop.setAlignment(
                Pos.CENTER_RIGHT
        );

        HBox.setHgrow(
                titleBox,
                Priority.ALWAYS
        );

        topBar.getChildren().addAll(
                titleBox,
                rightTop
        );

        // =====================================================
        // SIDEBAR
        // =====================================================

        VBox sidebar = new VBox(10);

        sidebar.setPadding(
                new Insets(25, 15, 25, 15)
        );

        sidebar.setPrefWidth(220);

        sidebar.setStyle(
                "-fx-background-color: rgba(5,15,32,0.95);" +
                "-fx-border-color: #172942;" +
                "-fx-border-width: 0 1 0 0;"
        );

        Label menuTitle = new Label("WORKSPACE");

        menuTitle.setStyle(
                "-fx-text-fill: #53657D;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        dashboardButton =
                createMenuButton("⌂   Dashboard");

        uploadButton =
                createMenuButton("↑   Upload Document");

        documentsButton =
                createMenuButton("▣   My Documents");

        activityButton =
                createMenuButton("◷   Activity");

        profileButton =
                createMenuButton("♙   Profile");

        sidebar.getChildren().addAll(
                menuTitle,
                dashboardButton,
                uploadButton,
                documentsButton,
                activityButton,
                profileButton
        );

        // =====================================================
        // CONTENT AREA
        // =====================================================

        contentArea = new VBox();

        contentArea.setPadding(
                new Insets(30, 35, 35, 35)
        );

        // =====================================================
        // BUTTON ACTIONS
        // =====================================================

        dashboardButton.setOnAction(e -> {

            System.out.println("Dashboard clicked");

            showDashboard();
        });

        uploadButton.setOnAction(e -> {

            System.out.println("Upload Document clicked");

            showUploadDashboard();
        });

        documentsButton.setOnAction(e -> {

            System.out.println("My Documents clicked");

            showDocuments();
        });

        activityButton.setOnAction(e -> {

            System.out.println("Activity clicked");

            showActivity();
        });

        profileButton.setOnAction(e -> {

            System.out.println("Profile clicked");

            showProfile();
        });

        // =====================================================
        // ROOT
        // =====================================================

        root.setTop(topBar);
        root.setLeft(sidebar);
        root.setCenter(contentArea);

        // =====================================================
        // DEFAULT PAGE
        // =====================================================

        showDashboard();

        // =====================================================
        // SCENE
        // =====================================================

        dashboardScene = new Scene(
                root,
                1300,
                700
        );

        return dashboardScene;
    }

    // =========================================================
    // DASHBOARD
    // =========================================================

    private void showDashboard() {

        root.setCenter(contentArea);

        contentArea.getChildren().clear();

        setActiveButton(dashboardButton);

        Label heading =
                new Label("Welcome back 👋");

        heading.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );

        Label description =
                new Label(
                        "Manage your documents and control how they are shared."
                );

        description.setStyle(
                "-fx-text-fill: #8291A7;" +
                "-fx-font-size: 14px;"
        );

        // =====================================================
        // STATS
        // =====================================================

        HBox stats = new HBox(15);

        VBox documents =
                createStatCard(
                        "12",
                        "Documents",
                        "Total uploaded"
                );

        VBox active =
                createStatCard(
                        "04",
                        "Active Sessions",
                        "Currently shared"
                );

        VBox prints =
                createStatCard(
                        "27",
                        "Prints",
                        "Print requests"
                );

        VBox privacy =
                createStatCard(
                        "94%",
                        "Privacy Score",
                        "Security status"
                );

        stats.getChildren().addAll(
                documents,
                active,
                prints,
                privacy
        );

        HBox.setHgrow(
                documents,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                active,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                prints,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                privacy,
                Priority.ALWAYS
        );

        // =====================================================
        // QUICK ACTIONS
        // =====================================================

        Label quickTitle =
                new Label("Quick Actions");

        quickTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );

        HBox actions = new HBox(15);

        VBox uploadCard =
                createActionCard(
                        "↑",
                        "Upload Document",
                        "Create a secure document session"
                );

        VBox documentCard =
                createActionCard(
                        "▣",
                        "My Documents",
                        "View your uploaded documents"
                );

        VBox activityCard =
                createActionCard(
                        "◷",
                        "Recent Activity",
                        "Check your document activity"
                );

        uploadCard.setOnMouseClicked(
                e -> showUploadDashboard()
        );

        documentCard.setOnMouseClicked(
                e -> showDocuments()
        );

        activityCard.setOnMouseClicked(
                e -> showActivity()
        );

        actions.getChildren().addAll(
                uploadCard,
                documentCard,
                activityCard
        );

        HBox.setHgrow(
                uploadCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                documentCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                activityCard,
                Priority.ALWAYS
        );

        // =====================================================
        // RECENT SESSION
        // =====================================================

        Label recentTitle =
                new Label("Recent Secure Sessions");

        recentTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );

        VBox session = createSessionCard();

        contentArea.getChildren().addAll(
                heading,
                description,
                stats,
                quickTitle,
                actions,
                recentTitle,
                session
        );

        contentArea.setSpacing(18);
    }

    // =========================================================
    // UPLOAD DASHBOARD
    // =========================================================

    private void showUploadDashboard() {

        setActiveButton(uploadButton);

        UploadDashboard uploadDashboard =
                new UploadDashboard();

        Scene uploadScene =
                uploadDashboard.getUploadScene(
                        () -> {

                            System.out.println(
                                    "Back to Dashboard clicked"
                            );

                            showDashboard();
                        }
                );

        root.setCenter(
                uploadScene.getRoot()
        );
    }

    // =========================================================
    // MY DOCUMENTS
    // =========================================================

    private void showDocuments() {

        setActiveButton(documentsButton);

        System.out.println(
                "Opening My Documents..."
        );

        MyDocuments myDocuments =
                new MyDocuments();

        Scene documentsScene =
                myDocuments.getDocumentsScene(
                        () -> {

                            System.out.println(
                                    "Back to Dashboard clicked"
                            );

                            showDashboard();
                        }
                );

        root.setCenter(
                documentsScene.getRoot()
        );
    }

    // =========================================================
    // ACTIVITY
    // =========================================================

    private void showActivity() {

        root.setCenter(contentArea);

        contentArea.getChildren().clear();

        setActiveButton(activityButton);

        Label heading =
                new Label("Activity");

        heading.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;"
        );

        Label description =
                new Label(
                        "Track access, printing and document sharing events."
                );

        description.setStyle(
                "-fx-text-fill: #8291A7;" +
                "-fx-font-size: 13px;"
        );

        VBox activity1 =
                createActivityRow(
                        "Document uploaded",
                        "Aadhaar-Card.pdf",
                        "2 minutes ago"
                );

        VBox activity2 =
                createActivityRow(
                        "Print request",
                        "Aadhaar-Card.pdf • Print 2/3",
                        "8 minutes ago"
                );

        VBox activity3 =
                createActivityRow(
                        "Document accessed",
                        "PAN-Card.pdf",
                        "15 minutes ago"
                );

        VBox activity4 =
                createActivityRow(
                        "Session created",
                        "College-ID.pdf",
                        "32 minutes ago"
                );

        contentArea.getChildren().addAll(
                heading,
                description,
                activity1,
                activity2,
                activity3,
                activity4
        );

        contentArea.setSpacing(12);
    }

    // =========================================================
    // PROFILE
    // =========================================================

    private void showProfile() {

        setActiveButton(profileButton);

        System.out.println("Opening Profile...");

        Profile profile =
                new Profile();

        Scene profileScene =
                profile.getProfileScene(
                        () -> {

                            System.out.println(
                                    "Back to Dashboard clicked"
                            );

                            showDashboard();
                        }
                );

        root.setCenter(
                profileScene.getRoot()
        );
    }

    // =========================================================
    // STAT CARD
    // =========================================================

    private VBox createStatCard(
            String number,
            String title,
            String description) {

        Label numberLabel =
                new Label(number);

        numberLabel.setStyle(
                "-fx-text-fill: #299BFF;" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        Label descriptionLabel =
                new Label(description);

        descriptionLabel.setStyle(
                "-fx-text-fill: #687B93;" +
                "-fx-font-size: 10px;"
        );

        VBox card =
                new VBox(
                        6,
                        numberLabel,
                        titleLabel,
                        descriptionLabel
                );

        card.setPadding(
                new Insets(18)
        );

        card.setPrefHeight(105);

        card.setStyle(
                "-fx-background-color: #091428;" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 16;"
        );

        return card;
    }

    // =========================================================
    // ACTION CARD
    // =========================================================

    private VBox createActionCard(
            String icon,
            String title,
            String description) {

        Label iconLabel =
                new Label(icon);

        iconLabel.setStyle(
                "-fx-background-color: #0E2C4C;" +
                "-fx-background-radius: 12;" +
                "-fx-text-fill: #36A0FF;" +
                "-fx-font-size: 20px;" +
                "-fx-padding: 8 12 8 12;"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        Label descriptionLabel =
                new Label(description);

        descriptionLabel.setWrapText(true);

        descriptionLabel.setStyle(
                "-fx-text-fill: #71829A;" +
                "-fx-font-size: 11px;"
        );

        VBox card =
                new VBox(
                        10,
                        iconLabel,
                        titleLabel,
                        descriptionLabel
                );

        card.setPadding(
                new Insets(18)
        );

        card.setPrefHeight(125);

        card.setStyle(
                "-fx-background-color: #091428;" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 16;"
        );

        card.setOnMouseEntered(e -> {

            card.setStyle(
                    "-fx-background-color: #0E1D33;" +
                    "-fx-background-radius: 16;" +
                    "-fx-border-color: #2196F3;" +
                    "-fx-border-radius: 16;"
            );
        });

        card.setOnMouseExited(e -> {

            card.setStyle(
                    "-fx-background-color: #091428;" +
                    "-fx-background-radius: 16;" +
                    "-fx-border-color: #1C304A;" +
                    "-fx-border-radius: 16;"
            );
        });

        return card;
    }

    // =========================================================
    // SESSION CARD
    // =========================================================

    private VBox createSessionCard() {

        Label file =
                new Label("Aadhaar-Card.pdf");

        file.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        Label status =
                new Label("● Active");

        status.setStyle(
                "-fx-text-fill: #19D6A3;" +
                "-fx-font-size: 11px;"
        );

        Label details =
                new Label(
                        "Print 2/3     •     12:44 remaining     •     Watermarked"
                );

        details.setStyle(
                "-fx-text-fill: #8191A8;" +
                "-fx-font-size: 11px;"
        );

        HBox top =
                new HBox(
                        15,
                        file,
                        status
                );

        top.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox card =
                new VBox(
                        8,
                        top,
                        details
                );

        card.setPadding(
                new Insets(18)
        );

        card.setStyle(
                "-fx-background-color: #091428;" +
                "-fx-background-radius: 16;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 16;"
        );

        return card;
    }

    // =========================================================
    // ACTIVITY ROW
    // =========================================================

    private VBox createActivityRow(
            String action,
            String document,
            String time) {

        Label actionLabel =
                new Label(action);

        actionLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        Label documentLabel =
                new Label(document);

        documentLabel.setStyle(
                "-fx-text-fill: #8291A7;" +
                "-fx-font-size: 11px;"
        );

        Label timeLabel =
                new Label(time);

        timeLabel.setStyle(
                "-fx-text-fill: #596B83;" +
                "-fx-font-size: 10px;"
        );

        HBox row =
                new HBox(
                        20,
                        actionLabel,
                        documentLabel,
                        timeLabel
                );

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        VBox container =
                new VBox(row);

        container.setPadding(
                new Insets(15)
        );

        container.setStyle(
                "-fx-background-color: #091428;" +
                "-fx-background-radius: 14;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 14;"
        );

        return container;
    }

    // =========================================================
    // SIDEBAR BUTTON
    // =========================================================

    private Button createMenuButton(
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
                "-fx-text-fill: #B8C5D6;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 11 15 11 15;"
        );

        button.setOnMouseEntered(e -> {

            if (!button.getStyle().contains("#1767C9")) {

                button.setStyle(
                        "-fx-background-color: #0E1D33;" +
                        "-fx-background-radius: 10;" +
                        "-fx-text-fill: #4CA8FF;" +
                        "-fx-font-size: 13px;" +
                        "-fx-padding: 11 15 11 15;"
                );
            }
        });

        button.setOnMouseExited(e -> {

            if (!button.getStyle().contains("#1767C9")) {

                button.setStyle(
                        "-fx-background-color: transparent;" +
                        "-fx-text-fill: #B8C5D6;" +
                        "-fx-font-size: 13px;" +
                        "-fx-padding: 11 15 11 15;"
                );
            }
        });

        return button;
    }

    // =========================================================
    // ACTIVE BUTTON
    // =========================================================

    private void setActiveButton(
            Button activeButton) {

        Button[] buttons = {
                dashboardButton,
                uploadButton,
                documentsButton,
                activityButton,
                profileButton
        };

        for (Button button : buttons) {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: #B8C5D6;" +
                    "-fx-font-size: 13px;" +
                    "-fx-padding: 11 15 11 15;"
            );
        }

        activeButton.setStyle(
                "-fx-background-color: #1767C9;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 11 15 11 15;"
        );
    }
}