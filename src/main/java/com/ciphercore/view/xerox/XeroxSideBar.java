package com.ciphercore.view.xerox;

import com.ciphercore.view.landing.HomePage;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class XeroxSideBar {

    private final String activePage;

    public XeroxSideBar(String activePage) {
        this.activePage = activePage;
    }

    public VBox getSideBar() {

        VBox sidebar = new VBox();

        sidebar.setPrefWidth(250);
        sidebar.setMinWidth(250);
        sidebar.setMaxWidth(250);

        sidebar.setPadding(
                new Insets(28, 18, 20, 18)
        );

        sidebar.setStyle(
                "-fx-background-color:#09172B;" +
                "-fx-border-color:#1C304A;"
        );

        // =====================================================
        // LOGO
        // =====================================================

        Label logo = new Label("PRIVORA");

        logo.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:25px;" +
                "-fx-font-weight:bold;"
        );

        Label centre =
                new Label("XEROX CENTRE");

        centre.setStyle(
                "-fx-text-fill:#8C9BB0;" +
                "-fx-font-size:13px;"
        );

        VBox.setMargin(
                centre,
                new Insets(5, 0, 30, 0)
        );

        // =====================================================
        // BUTTONS
        // =====================================================

        Button dashboard =
                createButton("Dashboard", "Dashboard");

        Button requests =
                createButton(
                        "Incoming Requests",
                        "IncomingRequests"
                );

        Button details =
                createButton(
                        "Request Details",
                        "RequestDetails"
                );

        Button viewer =
                createButton(
                        "Secure Viewer",
                        "SecureViewer"
                );

        Button printing =
                createButton(
                        "Printing",
                        "Printing"
                );

        Button sessions =
                createButton(
                        "Active Sessions",
                        "ActiveSession"
                );

        Button completed =
                createButton(
                        "Completed Jobs",
                        "CompletedJobs"
                );

        Button history =
                createButton(
                        "History",
                        "History"
                );

        Button settings =
                createButton(
                        "Settings",
                        "Settings"
                );

        // =====================================================
        // DASHBOARD
        // =====================================================

        dashboard.setOnAction(e -> {

            System.out.println("DASHBOARD CLICKED");

            XeroxDashboard page =
                    new XeroxDashboard();

            replacePage(
                    dashboard,
                    page.getScene()
            );
        });

        // =====================================================
        // INCOMING REQUESTS
        // =====================================================

        requests.setOnAction(e -> {

            System.out.println(
                    "INCOMING REQUESTS CLICKED"
            );

            IncomingRequests page =
                    new IncomingRequests();

            replacePage(
                    requests,
                    page.getScene()
            );
        });

        // =====================================================
        // REQUEST DETAILS
        // =====================================================

        details.setOnAction(e -> {

            System.out.println(
                    "REQUEST DETAILS CLICKED"
            );

            RequestDetails page =
                    new RequestDetails();

            replacePage(
                    details,
                    page.getScene()
            );
        });

        // =====================================================
        // SECURE VIEWER
        // =====================================================

        viewer.setOnAction(e -> {

            System.out.println(
                    "SECURE VIEWER CLICKED"
            );

            SecureViewer page =
                    new SecureViewer();

            replacePage(
                    viewer,
                    page.getScene()
            );
        });

        // =====================================================
        // PRINTING
        // =====================================================

        printing.setOnAction(e -> {

            System.out.println(
                    "PRINTING CLICKED"
            );

            Printing page =
                    new Printing();

            replacePage(
                    printing,
                    page.getScene()
            );
        });

        // =====================================================
        // ACTIVE SESSIONS
        // =====================================================

        sessions.setOnAction(e -> {

            System.out.println(
                    "ACTIVE SESSIONS CLICKED"
            );

            ActiveSession page =
                    new ActiveSession();

            replacePage(
                    sessions,
                    page.getScene()
            );
        });

        // =====================================================
        // COMPLETED JOBS
        // =====================================================

        completed.setOnAction(e -> {

            System.out.println(
                    "COMPLETED JOBS CLICKED"
            );

            CompletedJobs page =
                    new CompletedJobs();

            replacePage(
                    completed,
                    page.getScene()
            );
        });

        // =====================================================
        // HISTORY
        // =====================================================

        history.setOnAction(e -> {

            System.out.println(
                    "HISTORY CLICKED"
            );

            History page =
                    new History();

            replacePage(
                    history,
                    page.getScene()
            );
        });

        // =====================================================
        // SETTINGS
        // =====================================================

        settings.setOnAction(e -> {

            System.out.println(
                    "SETTINGS CLICKED"
            );

            Settings page =
                    new Settings();

            replacePage(
                    settings,
                    page.getScene()
            );
        });

        // =====================================================
        // NAVIGATION
        // =====================================================

        VBox navigation =
                new VBox(8);

        navigation.getChildren().addAll(
                dashboard,
                requests,
                details,
                viewer,
                printing,
                sessions,
                completed,
                history,
                settings
        );

        // =====================================================
        // SPACER
        // =====================================================

        Region spacer =
                new Region();

        VBox.setVgrow(
                spacer,
                Priority.ALWAYS
        );

        // =====================================================
        // LOGOUT
        // =====================================================

        Button logout =
                new Button("Logout");

        logout.setMaxWidth(
                Double.MAX_VALUE
        );

        logout.setPrefHeight(45);

        logout.setAlignment(
                Pos.CENTER_LEFT
        );

        logout.setPadding(
                new Insets(0, 15, 0, 15)
        );

        logout.setFocusTraversable(false);

        logout.setStyle(
                "-fx-background-color:transparent;" +
                "-fx-text-fill:#FF5555;" +
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;" +
                "-fx-background-radius:10;"
        );

        logout.setOnAction(e -> {

            System.out.println(
                    "LOGOUT CLICKED"
            );
            HomePage.backtohome();

            Scene currentScene =
                    logout.getScene();

            if (currentScene == null) {

                System.out.println(
                        "ERROR: LOGOUT HAS NO SCENE"
                );

                return;
            }

            HomePage homePage =
                    new HomePage();

            Scene homeScene =
                    homePage.getScene();

            currentScene.setRoot(
                    homeScene.getRoot()
            );

            System.out.println(
                    "RETURNED TO HOME PAGE"
            );
        });

        // =====================================================
        // ADD SIDEBAR
        // =====================================================

        sidebar.getChildren().addAll(
                logo,
                centre,
                navigation,
                spacer,
                logout
        );

        return sidebar;
    }

    // =========================================================
    // CREATE BUTTON
    // =========================================================

    private Button createButton(
            String text,
            String pageName) {

        Button button =
                new Button(text);

        button.setMaxWidth(
                Double.MAX_VALUE
        );

        button.setPrefHeight(43);

        button.setAlignment(
                Pos.CENTER_LEFT
        );

        button.setPadding(
                new Insets(0, 15, 0, 15)
        );

        button.setFocusTraversable(false);

        if (activePage.equals(pageName)) {

            button.setStyle(
                    "-fx-background-color:#2196F3;" +
                    "-fx-text-fill:white;" +
                    "-fx-font-size:14px;" +
                    "-fx-font-weight:bold;" +
                    "-fx-background-radius:10;"
            );

        } else {

            button.setStyle(
                    "-fx-background-color:transparent;" +
                    "-fx-text-fill:#D8E2F0;" +
                    "-fx-font-size:14px;" +
                    "-fx-background-radius:10;"
            );
        }

        return button;
    }

    // =========================================================
    // CHANGE PAGE
    // =========================================================

    private void replacePage(
            Button button,
            Scene newScene) {

        Scene currentScene =
                button.getScene();

        if (currentScene == null) {

            System.out.println(
                    "ERROR: BUTTON HAS NO SCENE"
            );

            return;
        }

        /*
         * Important:
         * Remove the root from the temporary Scene first.
         * This prevents Scene/root attachment problems.
         */

        javafx.scene.Parent newRoot =
                newScene.getRoot();

        newScene.setRoot(
                new VBox()
        );

        currentScene.setRoot(
                newRoot
        );

        System.out.println(
                "PAGE CHANGED SUCCESSFULLY"
        );
    }
}