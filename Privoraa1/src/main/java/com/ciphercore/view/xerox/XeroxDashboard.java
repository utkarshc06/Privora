package com.ciphercore.view.xerox;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.lang.reflect.Method;

public class XeroxDashboard {

    // =========================================================
    // COLORS
    // =========================================================

    private static final String SIDEBAR_BG = "#121019";
    private static final String MAIN_BG = "#09080F";

    private static final String PURPLE_DARK = "#6D28D9";
    private static final String PURPLE = "#7C3AED";
    private static final String PURPLE_LIGHT = "#8B5CF6";

    private static final String TEXT = "#F5F3FF";
    private static final String MUTED = "#9B93AA";
    private static final String BORDER = "#2A2435";

    // =========================================================
    // FIELDS
    // =========================================================

    private Scene xeroxScene;

    private VBox menuBox;

    private StackPane rightContent;

    private HBox selectedItem;

    private Runnable logoutAction;

    // =========================================================
    // MAIN SCENE
    // =========================================================

    public Scene getXeroxDashboardScene(Runnable rd) {

        this.logoutAction = rd;

        // =====================================================
        // SIDEBAR
        // =====================================================

        VBox sidebar = new VBox();

        sidebar.setPrefWidth(270);
        sidebar.setMinWidth(270);
        sidebar.setMaxWidth(270);

        sidebar.setStyle(
                "-fx-background-color: " + SIDEBAR_BG + ";" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-width: 0 1 0 0;"
        );

        // =====================================================
        // LOGO SECTION
        // =====================================================

        HBox logoSection = new HBox(12);

        logoSection.setAlignment(Pos.CENTER_LEFT);

        logoSection.setPadding(
                new Insets(20, 18, 20, 18)
        );

        // Logo circle

        Circle logoCircle = new Circle(20);

        logoCircle.setFill(
                Color.web(PURPLE)
        );

        // Image

        ImageView shieldView;

        try {

            Image shieldImage =
                    new Image("/assets/images/privimg.jpeg");

            shieldView =
                    new ImageView(shieldImage);

            shieldView.setFitWidth(28);
            shieldView.setFitHeight(28);
            shieldView.setPreserveRatio(true);

        } catch (Exception e) {

            shieldView = new ImageView();

        }

        // Shield box

        StackPane shieldBox =
                new StackPane(shieldView);

        shieldBox.setPrefSize(42, 42);

        shieldBox.setStyle(
                "-fx-background-color: " + PURPLE_DARK + ";" +
                "-fx-background-radius: 50%;" +
                "-fx-effect: dropshadow(" +
                "gaussian, rgba(124,58,237,0.65)," +
                "15, 0.5, 0, 0);"
        );

        // Logo box

        StackPane logoBox =
                new StackPane();

        logoBox.setPrefSize(42, 42);

        logoBox.getChildren().addAll(
                logoCircle,
                shieldBox
        );

        // =====================================================
        // BRAND
        // =====================================================

        VBox titleBox =
                new VBox(2);

        Label appName =
                new Label("PRIVORA");

        appName.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 21px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label("PRIVACY CONTROLLED");

        subtitle.setStyle(
                "-fx-text-fill: #9189A3;" +
                "-fx-font-size: 9px;" +
                "-fx-font-weight: bold;"
        );

        titleBox.getChildren().addAll(
                appName,
                subtitle
        );

        logoSection.getChildren().addAll(
                logoBox,
                titleBox
        );

        // =====================================================
        // PANEL TITLE
        // =====================================================

        Label panelTitle =
                new Label("XEROX CENTRE PANEL");

        panelTitle.setPadding(
                new Insets(15, 20, 10, 20)
        );

        panelTitle.setStyle(
                "-fx-text-fill: #837A96;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        // =====================================================
        // MENU
        // =====================================================

        menuBox =
                new VBox(5);

        menuBox.setPadding(
                new Insets(5, 10, 10, 10)
        );

        String[][] menuItems = {

                {"▦", "Dashboard"},
                {"▤", "Incoming Requests"},
                {"▣", "Request Details"},
                {"◉", "Secure Viewer"},
                {"▣", "Printing"},
                {"▷", "Active Sessions"},
                {"☷", "Completed Jobs"},
                {"◴", "History"},
                {"⚙", "Settings"}

        };

        for (int i = 0;
             i < menuItems.length;
             i++) {

            HBox item =
                    createMenuItem(
                            menuItems[i][0],
                            menuItems[i][1]
                    );

            if (i == 0) {
                setSelected(item);
            }

            menuBox.getChildren().add(item);
        }

        // =====================================================
        // SIDEBAR SCROLL
        // =====================================================

        ScrollPane menuScroll =
                new ScrollPane(menuBox);

        menuScroll.setFitToWidth(true);

        menuScroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        menuScroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        menuScroll.setStyle(
                "-fx-background-color: " + SIDEBAR_BG + ";" +
                "-fx-background: " + SIDEBAR_BG + ";"
        );

        VBox.setVgrow(
                menuScroll,
                Priority.ALWAYS
        );

        // =====================================================
        // LOGOUT
        // =====================================================

        HBox logoutSection =
                new HBox(15);

        logoutSection.setAlignment(
                Pos.CENTER_LEFT
        );

        logoutSection.setPadding(
                new Insets(18, 25, 22, 25)
        );

        logoutSection.setStyle(
                "-fx-border-color: " +
                BORDER +
                " transparent transparent transparent;" +
                "-fx-border-width: 1 0 0 0;" +
                "-fx-cursor: hand;"
        );

        Label logoutIcon =
                new Label("⎋");

        logoutIcon.setStyle(
                "-fx-text-fill: #F87171;" +
                "-fx-font-size: 20px;"
        );

        Label logoutText =
                new Label("Logout");

        logoutText.setStyle(
                "-fx-text-fill: #F87171;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        logoutSection.getChildren().addAll(
                logoutIcon,
                logoutText
        );

        logoutSection.setOnMouseEntered(e -> {

            logoutText.setStyle(
                    "-fx-text-fill: #FB7185;" +
                    "-fx-font-size: 14px;" +
                    "-fx-font-weight: bold;"
            );

        });

        logoutSection.setOnMouseExited(e -> {

            logoutText.setStyle(
                    "-fx-text-fill: #F87171;" +
                    "-fx-font-size: 14px;" +
                    "-fx-font-weight: bold;"
            );

        });

        logoutSection.setOnMouseClicked(e -> {

            if (logoutAction != null) {
                logoutAction.run();
            }

        });

        // =====================================================
        // ADD SIDEBAR COMPONENTS
        // =====================================================

        sidebar.getChildren().addAll(
                logoSection,
                panelTitle,
                menuScroll,
                logoutSection
        );

        // =====================================================
        // RIGHT CONTENT
        // =====================================================

        rightContent =
                new StackPane();

        rightContent.setStyle(
                "-fx-background-color: " + MAIN_BG + ";"
        );

        // =====================================================
        // DEFAULT PAGE
        // =====================================================

        showDashboard();

        // =====================================================
        // ROOT
        // =====================================================

        HBox root =
                new HBox();

        root.setStyle(
                "-fx-background-color: " + MAIN_BG + ";"
        );

        root.getChildren().addAll(
                sidebar,
                rightContent
        );

        HBox.setHgrow(
                rightContent,
                Priority.ALWAYS
        );

        // =====================================================
        // SCENE
        // =====================================================

        xeroxScene =
                new Scene(
                        root,
                        1300,
                        750
                );

        return xeroxScene;
    }

    // =========================================================
    // COMPATIBILITY METHOD
    // =========================================================

    public Scene getScene() {

        if (xeroxScene == null) {

            getXeroxDashboardScene(null);

        }

        return xeroxScene;
    }

    // =========================================================
    // MENU ITEM
    // =========================================================

    private HBox createMenuItem(
            String icon,
            String text) {

        HBox item =
                new HBox(15);

        item.setAlignment(
                Pos.CENTER_LEFT
        );

        item.setPadding(
                new Insets(12, 15, 12, 15)
        );

        item.setMaxWidth(
                Double.MAX_VALUE
        );

        item.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background-radius: 18;" +
                "-fx-cursor: hand;"
        );

        Label iconLabel =
                new Label(icon);

        iconLabel.setPrefWidth(22);

        iconLabel.setStyle(
                "-fx-text-fill: " + MUTED + ";" +
                "-fx-font-size: 17px;"
        );

        Label textLabel =
                new Label(text);

        textLabel.setStyle(
                "-fx-text-fill: #D9D3E3;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        item.getChildren().addAll(
                iconLabel,
                textLabel
        );

        // =====================================================
        // HOVER
        // =====================================================

        ScaleTransition scaleUp =
                new ScaleTransition(
                        Duration.millis(120),
                        item
                );

        scaleUp.setToX(1.02);
        scaleUp.setToY(1.02);

        ScaleTransition scaleDown =
                new ScaleTransition(
                        Duration.millis(120),
                        item
                );

        scaleDown.setToX(1.0);
        scaleDown.setToY(1.0);

        item.setOnMouseEntered(e -> {

            if (item != selectedItem) {

                scaleDown.stop();

                scaleUp.playFromStart();

                item.setStyle(
                        "-fx-background-color: #211A2B;" +
                        "-fx-background-radius: 18;" +
                        "-fx-cursor: hand;" +
                        "-fx-effect: dropshadow(" +
                        "gaussian, rgba(124,58,237,0.20)," +
                        "12, 0.3, 0, 2);"
                );

            }

        });

        item.setOnMouseExited(e -> {

            if (item != selectedItem) {

                scaleUp.stop();

                scaleDown.playFromStart();

                setNormal(item);

            }

        });

        // =====================================================
        // CLICK
        // =====================================================

        item.setOnMouseClicked(e -> {

            if (selectedItem != null) {
                setNormal(selectedItem);
            }

            setSelected(item);

            switch (text) {

                case "Dashboard":
                    showDashboard();
                    break;

                case "Incoming Requests":
                    showIncomingRequests();
                    break;

                case "Request Details":
                    showRequestDetails();
                    break;

                case "Secure Viewer":
                    showSecureViewer();
                    break;

                case "Printing":
                    showPrinting();
                    break;

                case "Active Sessions":
                    showActiveSessions();
                    break;

                case "Completed Jobs":
                    showCompletedJobs();
                    break;

                case "History":
                    showHistory();
                    break;

                case "Settings":
                    showSettings();
                    break;
            }

        });

        return item;
    }

    // =========================================================
    // SELECTED MENU
    // =========================================================

    private void setSelected(
            HBox item) {

        selectedItem = item;

        item.setScaleX(1);
        item.setScaleY(1);

        item.setStyle(
                "-fx-background-color: linear-gradient(" +
                "to right, " +
                PURPLE_DARK +
                ", " +
                PURPLE_LIGHT +
                ");" +
                "-fx-background-radius: 18;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(" +
                "gaussian, rgba(124,58,237,0.50)," +
                "18, 0.45, 0, 3);"
        );

        Label icon =
                (Label) item.getChildren().get(0);

        Label text =
                (Label) item.getChildren().get(1);

        icon.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 17px;"
        );

        text.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );
    }

    // =========================================================
    // NORMAL MENU
    // =========================================================

    private void setNormal(
            HBox item) {

        item.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background-radius: 18;" +
                "-fx-cursor: hand;"
        );

        Label icon =
                (Label) item.getChildren().get(0);

        Label text =
                (Label) item.getChildren().get(1);

        icon.setStyle(
                "-fx-text-fill: " + MUTED + ";" +
                "-fx-font-size: 17px;"
        );

        text.setStyle(
                "-fx-text-fill: #D9D3E3;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );
    }

    // =========================================================
    // PAGE LOADER
    // =========================================================

    private void showPage(
            Object page) {

        try {

            /*
             * First try getContent()
             */

            Method contentMethod =
                    page.getClass()
                            .getMethod("getContent");

            Object result =
                    contentMethod.invoke(page);

            if (result instanceof Node node) {

                setRightContent(node);

                return;
            }

        } catch (Exception ignored) {

        }

        try {

            /*
             * If getContent() doesn't exist,
             * try getScene()
             */

            Method sceneMethod =
                    page.getClass()
                            .getMethod("getScene");

            Object result =
                    sceneMethod.invoke(page);

            if (result instanceof Scene scene) {

                setRightContent(
                        scene.getRoot()
                );

                return;
            }

        } catch (Exception ignored) {

        }

        /*
         * If neither method exists
         */

        Label error =
                new Label(
                        "Unable to load this page."
                );

        error.setStyle(
                "-fx-text-fill: #F87171;" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );

        rightContent.getChildren().setAll(
                error
        );
    }

    // =========================================================
    // RIGHT CONTENT + SCROLL
    // =========================================================

    private void setRightContent(
            Node node) {

        ScrollPane scrollPane =
                new ScrollPane(node);

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle(
                "-fx-background-color: " + MAIN_BG + ";" +
                "-fx-background: " + MAIN_BG + ";"
        );

        rightContent.getChildren().setAll(
                scrollPane
        );
    }

    // =========================================================
    // DASHBOARD
    // =========================================================

    private void showDashboard() {

        showPage(
                new XDashboard()
        );
    }

    // =========================================================
    // INCOMING REQUESTS
    // =========================================================

    private void showIncomingRequests() {

        showPage(
                new IncomingRequests()
        );
    }

    // =========================================================
    // REQUEST DETAILS
    // =========================================================

    private void showRequestDetails() {

        showPage(
                new RequestDetails()
        );
    }

    // =========================================================
    // SECURE VIEWER
    // =========================================================

    private void showSecureViewer() {

        showPage(
                new SecureViewer()
        );
    }

    // =========================================================
    // PRINTING
    // =========================================================

    private void showPrinting() {

        showPage(
                new Printing()
        );
    }

    // =========================================================
    // ACTIVE SESSIONS
    // =========================================================

    private void showActiveSessions() {

        showPage(
                new ActiveSessions()
        );
    }

    // =========================================================
    // COMPLETED JOBS
    // =========================================================

    private void showCompletedJobs() {

        showPage(
                new CompletedJobs()
        );
    }

    // =========================================================
    // HISTORY
    // =========================================================

    private void showHistory() {

        showPage(
                new History()
        );
    }

    // =========================================================
    // SETTINGS
    // =========================================================

    private void showSettings() {

        showPage(
                new Settings()
        );
    }
}