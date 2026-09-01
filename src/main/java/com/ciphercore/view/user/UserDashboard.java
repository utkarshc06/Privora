package com.ciphercore.view.user;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

public class UserDashboard {

    private Scene userScene;

    private VBox menuBox;

    private StackPane rightContent;

    private HBox selectedItem;


    // =========================================================
    // MAIN USER SCENE
    // =========================================================

    public Scene getUserDashboardScene(Runnable rd) {

        // =====================================================
        // SIDEBAR
        // =====================================================

        VBox sidebar = new VBox();

        sidebar.setPrefWidth(270);
        sidebar.setMinWidth(270);

        sidebar.setStyle("""
                -fx-background-color: #121016;
                -fx-border-color: #2B2338;
                -fx-border-width: 0 1 0 0;
                """);


        // =====================================================
        // LOGO
        // =====================================================

        HBox logoSection = new HBox(12);

        logoSection.setAlignment(Pos.CENTER_LEFT);

        logoSection.setPadding(
                new Insets(20, 18, 20, 18)
        );


        Circle logoCircle = new Circle(20);

        logoCircle.setFill(
                Color.web("#6D28D9")
        );


        Image shieldImage = new Image(
                "/assets/images/privimg.jpeg"
        );


        ImageView shieldView = new ImageView(shieldImage);

        shieldView.setFitWidth(28);
        shieldView.setFitHeight(28);
        shieldView.setPreserveRatio(true);


        StackPane shieldBox = new StackPane(shieldView);

        shieldBox.setPrefSize(42, 42);

        shieldBox.setStyle("""
                -fx-background-color: #6D28D9;
                -fx-background-radius: 50%;
                -fx-effect: dropshadow(
                    gaussian,
                    rgba(139,92,246,0.65),
                    15,
                    0.5,
                    0,
                    0
                );
                """);


        StackPane logoBox = new StackPane();

        logoBox.setPrefSize(42, 42);

        logoBox.getChildren().addAll(
                logoCircle,
                shieldBox
        );


        // =====================================================
        // TITLE
        // =====================================================

        VBox titleBox = new VBox(2);


        Label appName = new Label("PRIVORA");

        appName.setStyle("""
                -fx-text-fill: #F5F3FF;
                -fx-font-size: 20px;
                -fx-font-weight: bold;
                """);


        Label subtitle = new Label(
                "PRIVACY CONTROLLED"
        );

        subtitle.setStyle("""
                -fx-text-fill: #A8A0B8;
                -fx-font-size: 9px;
                -fx-font-weight: bold;
                """);


        titleBox.getChildren().addAll(
                appName,
                subtitle
        );


        logoSection.getChildren().addAll(
                logoBox,
                titleBox
        );


        // =====================================================
        // USER PANEL TITLE
        // =====================================================

        Label panelTitle = new Label("USER PANEL");

        panelTitle.setPadding(
                new Insets(15, 20, 10, 20)
        );

        panelTitle.setStyle("""
                -fx-text-fill: #756A86;
                -fx-font-size: 10px;
                -fx-font-weight: bold;
                """);


        // =====================================================
        // MENU
        // =====================================================

        menuBox = new VBox(5);

        menuBox.setPadding(
                new Insets(5, 10, 10, 10)
        );


       String[][] menuItems = {

        {"▦", "Dashboard"},
        {"⇧", "Upload Document"},
        {"▣", "Purpose"},
        {"♢", "Permissions"},
        {"♜", "Select Centre"},
        {"◴", "Request Status"},
        {"▤", "My Documents"},
        {"〽", "Activity"},
        {"▣", "Privacy Receipt"},
        {"♧", "Notifications"},
        {"⚙", "Profile"}

};


        for (int i = 0; i < menuItems.length; i++) {

            HBox item = createMenuItem(
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

        ScrollPane menuScroll = new ScrollPane(menuBox);

        menuScroll.setFitToWidth(true);

        menuScroll.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        menuScroll.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        menuScroll.setStyle("""
                -fx-background-color: #121016;
                -fx-background: #121016;
                """);


        VBox.setVgrow(
                menuScroll,
                Priority.ALWAYS
        );


        // =====================================================
        // LOGOUT
        // =====================================================

        HBox logoutSection = new HBox(15);

        logoutSection.setAlignment(
                Pos.CENTER_LEFT
        );

        logoutSection.setPadding(
                new Insets(18, 25, 22, 25)
        );

        logoutSection.setStyle("""
                -fx-border-color:
                    #2B2338
                    transparent
                    transparent
                    transparent;

                -fx-border-width: 1 0 0 0;

                -fx-cursor: hand;
                """);


        Label logoutIcon = new Label("⎋");

        logoutIcon.setStyle("""
                -fx-text-fill: #FF6B6B;
                -fx-font-size: 19px;
                """);


        Label logoutText = new Label("Logout");

        logoutText.setStyle("""
                -fx-text-fill: #FF6B6B;
                -fx-font-size: 14px;
                -fx-font-weight: bold;
                """);


        logoutSection.getChildren().addAll(
                logoutIcon,
                logoutText
        );


        // =====================================================
        // LOGOUT ACTION
        // =====================================================

        logoutSection.setOnMouseClicked(e -> {

            if (rd != null) {

                rd.run();

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
        // RIGHT SIDE CONTENT
        // =====================================================

        rightContent = new StackPane();

        rightContent.setStyle(
                "-fx-background-color: #0B0A0F;"
        );


        // =====================================================
        // SHOW DASHBOARD FIRST
        // =====================================================

        showDashboard();


        // =====================================================
        // ROOT
        // =====================================================

        HBox root = new HBox();

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

        userScene = new Scene(
                root,
                1300,
                750
        );

        return userScene;
    }


    // =========================================================
    // CREATE MENU ITEM
    // =========================================================

    private HBox createMenuItem(
            String icon,
            String text) {

        HBox item = new HBox(15);

        item.setAlignment(
                Pos.CENTER_LEFT
        );

        item.setPadding(
                new Insets(11, 15, 11, 15)
        );

        item.setMaxWidth(
                Double.MAX_VALUE
        );

        item.setStyle("""
                -fx-background-color: transparent;
                -fx-background-radius: 18;
                -fx-cursor: hand;
                """);


        Label iconLabel = new Label(icon);

        iconLabel.setPrefWidth(20);

        iconLabel.setStyle("""
                -fx-text-fill: #9E94AD;
                -fx-font-size: 16px;
                """);


        Label textLabel = new Label(text);

        textLabel.setStyle("""
                -fx-text-fill: #D8D2E2;
                -fx-font-size: 14px;
                -fx-font-weight: bold;
                """);


        item.getChildren().addAll(
                iconLabel,
                textLabel
        );


        // =====================================================
        // CLICK
        // =====================================================

        item.setOnMouseClicked(e -> {

            selectMenuItem(item);

        });


        // =====================================================
        // HOVER ANIMATION
        // =====================================================

        ScaleTransition scaleUp =
                new ScaleTransition(
                        Duration.millis(120),
                        item
                );

        scaleUp.setToX(1.03);
        scaleUp.setToY(1.03);


        ScaleTransition scaleDown =
                new ScaleTransition(
                        Duration.millis(120),
                        item
                );

        scaleDown.setToX(1);
        scaleDown.setToY(1);


        item.setOnMouseEntered(e -> {

            if (item != selectedItem) {

                scaleDown.stop();

                scaleUp.playFromStart();

                item.setStyle("""
                        -fx-background-color: #211A2E;
                        -fx-background-radius: 18;
                        -fx-cursor: hand;
                        -fx-effect: dropshadow(
                            gaussian,
                            rgba(139,92,246,0.25),
                            12,
                            0.3,
                            0,
                            2
                        );
                        """);
            }

        });


        item.setOnMouseExited(e -> {

            if (item != selectedItem) {

                scaleUp.stop();

                scaleDown.playFromStart();

                setNormal(item);

            }

        });


        return item;
    }


    // =========================================================
    // MENU ITEM CLICK HANDLER
    // =========================================================

    private void selectMenuItem(HBox item) {

        for (javafx.scene.Node node :
                menuBox.getChildren()) {

            if (node instanceof HBox) {

                setNormal((HBox) node);

            }

        }


        setSelected(item);


        Label textLabel =
                (Label) item.getChildren().get(1);


        String text =
                textLabel.getText();


        switch (text) {

            case "Dashboard":
                showDashboard();
                break;

            case "Upload Document":
                showUploadDocument();
                break;

            case "Purpose":
                showPurpose();
                break;

            case "Permissions":
                showPermissions();
                break;

            case "Select Centre":
                showSelectCentre();
                break;

            case "Request Status":
                showRequestStatus();
                break;

            case "My Documents":
                showMyDocuments();
                break;

            case "Activity":
                showActivity();
                break;

            case "Privacy Receipt":
                showPrivacyReceipt();
                break;

            case "Notifications":
                showNotifications();
                break;

            case "Profile":
                showProfile();
                break;
        }
    }


    // =========================================================
    // SELECT UPLOAD DOCUMENT MENU
    // =========================================================

    private void selectUploadDocumentMenu() {

        for (javafx.scene.Node node :
                menuBox.getChildren()) {

            if (node instanceof HBox item) {

                Label textLabel =
                        (Label) item.getChildren().get(1);


                if (textLabel.getText()
                        .equals("Upload Document")) {

                    for (javafx.scene.Node other :
                            menuBox.getChildren()) {

                        if (other instanceof HBox otherItem) {

                            setNormal(otherItem);

                        }

                    }


                    setSelected(item);

                    break;
                }
            }
        }
    }


    // =========================================================
    // OPEN PURPOSE PAGE
    // =========================================================

    public void openPurposePage() {

        for (javafx.scene.Node node :
                menuBox.getChildren()) {

            if (node instanceof HBox item) {

                Label textLabel =
                        (Label) item.getChildren().get(1);


                if (textLabel.getText()
                        .equals("Purpose")) {

                    for (javafx.scene.Node other :
                            menuBox.getChildren()) {

                        if (other instanceof HBox otherItem) {

                            setNormal(otherItem);

                        }

                    }


                    setSelected(item);

                    break;
                }
            }
        }


        showPurpose();
    }


    // =========================================================
    // SELECTED MENU
    // =========================================================

    private void setSelected(HBox item) {

        selectedItem = item;

        item.setScaleX(1);
        item.setScaleY(1);

        item.setStyle("""
                -fx-background-color:
                    linear-gradient(
                        to right,
                        #6D28D9,
                        #8B5CF6
                    );

                -fx-background-radius: 18;

                -fx-cursor: hand;

                -fx-effect: dropshadow(
                    gaussian,
                    rgba(139,92,246,0.45),
                    18,
                    0.4,
                    0,
                    3
                );
                """);


        Label icon =
                (Label) item.getChildren().get(0);

        Label text =
                (Label) item.getChildren().get(1);


        icon.setStyle("""
                -fx-text-fill: white;
                -fx-font-size: 16px;
                """);


        text.setStyle("""
                -fx-text-fill: white;
                -fx-font-size: 14px;
                -fx-font-weight: bold;
                """);
    }


    // =========================================================
    // NORMAL MENU
    // =========================================================

    private void setNormal(HBox item) {

        item.setStyle("""
                -fx-background-color: transparent;
                -fx-background-radius: 18;
                -fx-cursor: hand;
                """);


        Label icon =
                (Label) item.getChildren().get(0);

        Label text =
                (Label) item.getChildren().get(1);


        icon.setStyle("""
                -fx-text-fill: #9E94AD;
                -fx-font-size: 16px;
                """);


        text.setStyle("""
                -fx-text-fill: #D8D2E2;
                -fx-font-size: 14px;
                -fx-font-weight: bold;
                """);
    }


    // =========================================================
    // DASHBOARD
    // =========================================================

    private void showDashboard() {

        UDashboard dashboard =
                new UDashboard();


        rightContent.getChildren().setAll(
                dashboard.getContent()
        );


        dashboard.getNewUploadButton()
                .setOnAction(e -> {

                    selectUploadDocumentMenu();

                    showUploadDocument();

                });


        dashboard.getUploadDocumentAction()
                .setOnMouseClicked(e -> {

                    selectUploadDocumentMenu();

                    showUploadDocument();

                });
    }


    // =========================================================
    // UPLOAD DOCUMENT
    // =========================================================

    private void showUploadDocument() {

        rightContent.getChildren().setAll(
                new UploadDocument(this).getContent()
        );
    }


    // =========================================================
    // PURPOSE
    // =========================================================

   private void showPurpose() {

    rightContent.getChildren().setAll(

            new Purpose(() -> {

                // Purpose → Next → Permissions
                showPermissions();

            }).getContent()

    );
}

// =========================================================
// SELECT PERMISSIONS MENU
// =========================================================

private void selectPermissionsMenu() {

    for (javafx.scene.Node node :
            menuBox.getChildren()) {

        if (node instanceof HBox item) {

            Label textLabel =
                    (Label) item.getChildren().get(1);

            if (textLabel.getText()
                    .equals("Permissions")) {

                // Remove previous selection

                for (javafx.scene.Node other :
                        menuBox.getChildren()) {

                    if (other instanceof HBox otherItem) {

                        setNormal(otherItem);

                    }
                }

                // Select Permissions

                setSelected(item);

                break;
            }
        }
    }
}

    // =========================================================
    // PERMISSIONS
    // =========================================================

   private void showPermissions() {

    // Change left sidebar selection
    selectPermissionsMenu();

    // Change right side content
    rightContent.getChildren().setAll(
            new Permissions().getContent()
    );
}


    // =========================================================
    // SELECT CENTRE
    // =========================================================

    private void showSelectCentre() {

        rightContent.getChildren().setAll(
                new SelectCentre().getContent()
        );
    }

    // =========================================================
    // REQUEST STATUS
    // =========================================================

    private void showRequestStatus() {

        rightContent.getChildren().setAll(
                new RequestStatus().getContent()
        );
    }


    // =========================================================
    // MY DOCUMENTS
    // =========================================================

    private void showMyDocuments() {

        rightContent.getChildren().setAll(
                new MyDocuments().getContent()
        );
    }


    // =========================================================
    // ACTIVITY
    // =========================================================

    private void showActivity() {

        rightContent.getChildren().setAll(
                new Activity().getContent()
        );
    }


    // =========================================================
    // PRIVACY RECEIPT
    // =========================================================

    private void showPrivacyReceipt() {

        rightContent.getChildren().setAll(
                new PrivacyReceipt().getContent()
        );
    }


    // =========================================================
    // NOTIFICATIONS
    // =========================================================

    private void showNotifications() {

        rightContent.getChildren().setAll(
                new Notifications().getContent()
        );
    }


    // =========================================================
    // PROFILE
    // =========================================================

    private void showProfile() {

        rightContent.getChildren().setAll(
                new Profile().getContent()
        );
    }
}