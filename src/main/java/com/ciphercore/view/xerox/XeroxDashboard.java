package com.ciphercore.view.xerox;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class XeroxDashboard {

    private Scene xeroxScene;

    private VBox menuBox;

    private StackPane rightContent;

    private HBox selectedItem;


    // =========================================================
    // MAIN XEROX SCENE
    // =========================================================

    public Scene getXeroxDashboardScene(Runnable rd) {

        // =====================================================
        // SIDEBAR
        // =====================================================

        VBox sidebar = new VBox();

        sidebar.setPrefWidth(270);
        sidebar.setMinWidth(270);

        sidebar.setStyle(
                "-fx-background-color: #121019;" +
                "-fx-border-color: #2A2435;" +
                "-fx-border-width: 0 1 0 0;"
        );


        // =====================================================
        // LOGO
        // =====================================================

        HBox logoSection = new HBox(12);

        logoSection.setAlignment(
                Pos.CENTER_LEFT
        );

        logoSection.setPadding(
                new Insets(20, 18, 20, 18)
        );


        // =====================================================
        // PRIVORA LOGO
        // =====================================================

        Circle logoCircle = new Circle(20);

        logoCircle.setFill(
                Color.web("#7C3AED")
        );


        Image shieldImage =
                new Image("/assets/images/privimg.jpeg");


        ImageView shieldView =
                new ImageView(shieldImage);

        shieldView.setFitWidth(28);
        shieldView.setFitHeight(28);
        shieldView.setPreserveRatio(true);


        // Shield container

        StackPane shieldBox =
                new StackPane(shieldView);

        shieldBox.setPrefSize(
                42,
                42
        );

        shieldBox.setStyle(
                "-fx-background-color: #6D28D9;" +
                "-fx-background-radius: 50%;" +
                "-fx-effect: dropshadow(" +
                "gaussian, rgba(124,58,237,0.65)," +
                "15, 0.5, 0, 0);"
        );


        StackPane logoBox =
                new StackPane();

        logoBox.setPrefSize(
                42,
                42
        );

        logoBox.getChildren().addAll(
                logoCircle,
                shieldBox
        );


        // =====================================================
        // TITLE
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
                new Label(
                        "PRIVACY CONTROLLED"
                );

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
                new Label(
                        "XEROX CENTRE PANEL"
                );

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
        // MENU SCROLL
        // =====================================================

        ScrollPane menuScroll =
                new ScrollPane(menuBox);

        menuScroll.setFitToWidth(
                true
        );

        menuScroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        menuScroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        menuScroll.setStyle(
                "-fx-background-color: #121019;" +
                "-fx-background: #121019;"
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
                "-fx-border-color: #2A2435 transparent transparent transparent;" +
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


        // =====================================================
        // LOGOUT HOVER
        // =====================================================

        logoutSection.setOnMouseEntered(e -> {

            logoutText.setStyle(
                    "-fx-text-fill: #FB7185;" +
                    "-fx-font-size: 14px;" +
                    "-fx-font-weight: bold;"
            );


            ScaleTransition scale =
                    new ScaleTransition(
                            Duration.millis(120),
                            logoutSection
                    );

            scale.setToX(1.03);
            scale.setToY(1.03);

            scale.play();

        });


        logoutSection.setOnMouseExited(e -> {

            logoutText.setStyle(
                    "-fx-text-fill: #F87171;" +
                    "-fx-font-size: 14px;" +
                    "-fx-font-weight: bold;"
            );


            ScaleTransition scale =
                    new ScaleTransition(
                            Duration.millis(120),
                            logoutSection
                    );

            scale.setToX(1);
            scale.setToY(1);

            scale.play();

        });


        logoutSection.setOnMouseClicked(e -> {

            if (rd != null) {

                rd.run();

            }

        });


        // =====================================================
        // ADD SIDEBAR
        // =====================================================

        sidebar.getChildren().addAll(
                logoSection,
                panelTitle,
                menuScroll,
                logoutSection
        );


        // =====================================================
        // RIGHT SIDE
        // =====================================================

        rightContent =
                new StackPane();

        rightContent.setStyle(
                "-fx-background-color: #0B0910;"
        );


        // Default page

        showDashboard();


        // =====================================================
        // ROOT
        // =====================================================

        HBox root =
                new HBox();

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
                "-fx-text-fill: #9B93AA;" +
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


        // =====================================================
        // EXIT
        // =====================================================

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

                setNormal(
                        selectedItem
                );

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
    // SELECTED
    // =========================================================

    private void setSelected(
            HBox item) {


        selectedItem = item;


        item.setScaleX(1);

        item.setScaleY(1);


        item.setStyle(
                "-fx-background-color: linear-gradient(" +
                "to right, #6D28D9, #8B5CF6);" +
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
    // NORMAL
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
                "-fx-text-fill: #9B93AA;" +
                "-fx-font-size: 17px;"
        );


        text.setStyle(
                "-fx-text-fill: #D9D3E3;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );
    }


    // =========================================================
    // RIGHT SIDE PAGE METHODS
    // =========================================================

    private void showDashboard() {

        rightContent.getChildren().setAll(
                new XDashboard().getContent()
        );

    }


    private void showIncomingRequests() {

        rightContent.getChildren().setAll(
                new IncomingRequests().getContent()
        );

    }


    private void showRequestDetails() {

        rightContent.getChildren().setAll(
                new RequestDetails().getContent()
        );

    }


    private void showSecureViewer() {

        rightContent.getChildren().setAll(
                new SecureViewer().getContent()
        );

    }


    private void showPrinting() {

        rightContent.getChildren().setAll(
                new Printing().getContent()
        );

    }


    private void showActiveSessions() {

        rightContent.getChildren().setAll(
                new ActiveSessions().getContent()
        );

    }


    private void showCompletedJobs() {

        rightContent.getChildren().setAll(
                new CompletedJobs().getContent()
        );

    }


    private void showHistory() {

        rightContent.getChildren().setAll(
                new History().getContent()
        );

    }


    private void showSettings() {

        rightContent.getChildren().setAll(
                new Settings().getContent()
        );

    }
}