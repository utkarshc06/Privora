package com.ciphercore.view.auth;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import com.ciphercore.view.xerox.XeroxDashboard;
import javafx.stage.Stage;

public class LoginPage {

    private Scene loginScene;


    // =========================================================
    // LOGIN SCENE
    // =========================================================

    public Scene getLoginScene(Runnable rhp) {


        // =========================================================
        // MAIN ROOT
        // =========================================================

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #020713, #06152D, #020713);"
        );


        // =========================================================
        // TOP BAR
        // =========================================================

        HBox topBar = new HBox();

        topBar.setPadding(
                new Insets(10, 28, 10, 28)
        );

        topBar.setAlignment(
                Pos.CENTER_LEFT
        );


        // =========================================================
        // LOGO
        // =========================================================

        Circle logoCircle = new Circle(20);

        logoCircle.setFill(
                Color.web("#2196F3")
        );


        Label shield = new Label("♢");

        shield.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );


        StackPane logoBox = new StackPane();

        logoBox.setPrefSize(
                42,
                42
        );


        logoBox.getChildren().addAll(
                logoCircle,
                shield
        );


        // =========================================================
        // BRAND
        // =========================================================

        Label brandName = new Label(
                "PRIVORA"
        );

        brandName.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 19px;" +
                "-fx-font-weight: bold;"
        );


        Label brandTagline = new Label(
                "PRIVACY CONTROLLED"
        );

        brandTagline.setStyle(
                "-fx-text-fill: #7D8BA3;" +
                "-fx-font-size: 9px;" +
                "-fx-letter-spacing: 1px;"
        );


        VBox brandText = new VBox(
                0,
                brandName,
                brandTagline
        );


        HBox brand = new HBox(
                10,
                logoBox,
                brandText
        );

        brand.setAlignment(
                Pos.CENTER_LEFT
        );


        // =========================================================
        // CREATE ACCOUNT
        // =========================================================

        Button createAccount = createSimpleButton(
                "Create account"
        );


        createAccount.setOnAction(e -> {

            System.out.println(
                    "Create account clicked"
            );

            if (rhp != null) {
                rhp.run();
            }

        });


        // =========================================================
        // PUSH CREATE ACCOUNT TO RIGHT
        // =========================================================

        HBox.setHgrow(
                brand,
                javafx.scene.layout.Priority.ALWAYS
        );


        topBar.getChildren().addAll(
                brand,
                createAccount
        );


        // =========================================================
        // LOGIN CARD
        // =========================================================

        VBox loginCard = new VBox();

        loginCard.setPadding(
                new Insets(30)
        );

        loginCard.setSpacing(
                14
        );

        loginCard.setMaxWidth(
                450
        );


        loginCard.setStyle(
                "-fx-background-color: rgba(9,20,40,0.88);" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 22;"
        );


        // =========================================================
        // WELCOME TEXT
        // =========================================================

        Label welcome = new Label(
                "Welcome back"
        );

        welcome.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 23px;" +
                "-fx-font-weight: bold;"
        );


        Label subtitle = new Label(
                "Sign in to continue to PRIVORA"
        );

        subtitle.setStyle(
                "-fx-text-fill: #8C9BB0;" +
                "-fx-font-size: 13px;"
        );


        VBox headingBox = new VBox(
                5,
                welcome,
                subtitle
        );

        headingBox.setAlignment(
                Pos.CENTER
        );


        // =========================================================
        // USER / XEROX / ADMIN
        // =========================================================

        VBox userCard = createRoleCard(
                "♙",
                "User",
                "Upload & share\ndocuments"
        );


        VBox xeroxCard = createRoleCard(
                "▥",
                "Xerox Centre",
                "Handle print requests"
        );


        VBox adminCard = createRoleCard(
                "♢",
                "Admin",
                "Manage the platform"
        );


        HBox roleBox = new HBox(
                10,
                userCard,
                xeroxCard,
                adminCard
        );


        roleBox.setAlignment(
                Pos.CENTER
        );


        // =========================================================
        // DEFAULT ROLE
        // =========================================================

        final String[] selectedRole = {
                "User"
        };


        // =========================================================
        // DEFAULT SELECTED CARD
        // =========================================================

        selectRoleCard(
                userCard,
                xeroxCard,
                adminCard
        );


        // =========================================================
        // SIGN IN BUTTON
        // =========================================================

        Button signInButton = createBlueButton(
                "Sign in as User"
        );


        // =========================================================
        // USER CARD CLICK
        // =========================================================

        userCard.setOnMouseClicked(e -> {

            selectedRole[0] = "User";


            System.out.println(
                    "Selected Role: " +
                    selectedRole[0]
            );


            selectRoleCard(
                    userCard,
                    xeroxCard,
                    adminCard
            );


            signInButton.setText(
                    "Sign in as User"
            );

        });


        // =========================================================
        // XEROX CARD CLICK
        // =========================================================

        xeroxCard.setOnMouseClicked(e -> {

            selectedRole[0] = "Xerox";


            System.out.println(
                    "Selected Role: " +
                    selectedRole[0]
            );


            selectRoleCard(
                    xeroxCard,
                    userCard,
                    adminCard
            );


            signInButton.setText(
                    "Sign in as Xerox"
            );

        });


        // =========================================================
        // ADMIN CARD CLICK
        // =========================================================

        adminCard.setOnMouseClicked(e -> {

            selectedRole[0] = "Admin";


            System.out.println(
                    "Selected Role: " +
                    selectedRole[0]
            );


            selectRoleCard(
                    adminCard,
                    userCard,
                    xeroxCard
            );


            signInButton.setText(
                    "Sign in as Admin"
            );

        });


        // =========================================================
        // EMAIL
        // =========================================================

        Label emailLabel = new Label(
                "Email"
        );

        emailLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );


        TextField emailField = new TextField();

        emailField.setPromptText(
                "demo@privora.app"
        );


        emailField.setStyle(
                "-fx-background-color: #071226;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #24354E;" +
                "-fx-border-radius: 20;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #66758A;" +
                "-fx-padding: 10 15 10 15;"
        );


        // =========================================================
        // PASSWORD
        // =========================================================

        Label passwordLabel = new Label(
                "Password"
        );

        passwordLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );


        PasswordField passwordField =
                new PasswordField();


        passwordField.setPromptText(
                "••••••••"
        );


        passwordField.setStyle(
                "-fx-background-color: #071226;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #24354E;" +
                "-fx-border-radius: 20;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #66758A;" +
                "-fx-padding: 10 15 10 15;"
        );


        // =========================================================
        // SIGN IN BUTTON ACTION
        // =========================================================
signInButton.setOnAction(e -> {

    System.out.println("SIGN IN BUTTON CLICKED");

    System.out.println(
            "Selected Role: " + selectedRole[0]
    );

    if (selectedRole[0].equals("Xerox")) {

        System.out.println(
                "Opening Xerox Dashboard..."
        );

        XeroxDashboard dashboard =
                new XeroxDashboard();

        Stage stage =
                (Stage) signInButton
                        .getScene()
                        .getWindow();

        stage.setScene(
                dashboard.getScene()
        );

        stage.show();

    } else if (selectedRole[0].equals("User")) {

        System.out.println(
                "User login selected"
        );

    } else if (selectedRole[0].equals("Admin")) {

        System.out.println(
                "Admin login selected"
        );
    }
});


// sing in action

   signInButton.setOnAction(e -> {

    System.out.println("SIGN IN BUTTON CLICKED");

    System.out.println(
            "Selected Role: " + selectedRole[0]
    );

    if (selectedRole[0].equals("Xerox")) {

        System.out.println(
                "Opening Xerox Dashboard..."
        );

        XeroxDashboard dashboard =
                new XeroxDashboard();

        Stage stage =
                (Stage) signInButton
                        .getScene()
                        .getWindow();

        stage.setScene(
                dashboard.getScene()
        );

        stage.show();

    } else if (selectedRole[0].equals("User")) {

        System.out.println(
                "User login selected"
        );

    } else if (selectedRole[0].equals("Admin")) {

        System.out.println(
                "Admin login selected"
        );
    }
});


        // =========================================================
        // CREATE ACCOUNT TEXT
        // =========================================================

        Label newHere = new Label(
                "New here? Create an account"
        );


        newHere.setStyle(
                "-fx-text-fill: #8C9BB0;" +
                "-fx-font-size: 12px;"
        );


        // =========================================================
        // ADD EVERYTHING TO LOGIN CARD
        // =========================================================

        loginCard.getChildren().addAll(
                headingBox,
                roleBox,
                emailLabel,
                emailField,
                passwordLabel,
                passwordField,
                signInButton,
                newHere
        );


        // =========================================================
        // CENTER LOGIN CARD
        // =========================================================

        StackPane centerBox = new StackPane(
                loginCard
        );


        centerBox.setPadding(
                new Insets(40)
        );


        // =========================================================
        // SCROLL PANE
        // =========================================================

        ScrollPane scrollPane =
                new ScrollPane(
                        centerBox
                );


        scrollPane.setFitToWidth(
                true
        );


        scrollPane.setFitToHeight(
                true
        );


        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );


        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );


        scrollPane.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;"
        );


        // =========================================================
        // ROOT
        // =========================================================

        root.setTop(
                topBar
        );


        root.setCenter(
                scrollPane
        );


        // =========================================================
        // SCENE
        // =========================================================

        loginScene = new Scene(
                root,
                1300,
                700
        );


        return loginScene;
    }


    // =============================================================
    // ROLE CARD
    // =============================================================

    private VBox createRoleCard(
            String icon,
            String title,
            String description) {


        Label iconLabel = new Label(
                icon
        );


        iconLabel.setStyle(
                "-fx-background-color: #14243D;" +
                "-fx-background-radius: 50%;" +
                "-fx-text-fill: #A8B8CC;" +
                "-fx-padding: 8;"
        );


        Label titleLabel = new Label(
                title
        );


        titleLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );


        Label descriptionLabel =
                new Label(
                        description
                );


        descriptionLabel.setStyle(
                "-fx-text-fill: #7E8DA3;" +
                "-fx-font-size: 10px;"
        );


        VBox card = new VBox(
                8,
                iconLabel,
                titleLabel,
                descriptionLabel
        );


        card.setPadding(
                new Insets(12)
        );


        card.setPrefWidth(
                125
        );


        card.setPrefHeight(
                105
        );


        // =========================================================
        // DEFAULT STYLE
        // =========================================================

        card.setStyle(
                "-fx-background-color: #0B162A;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #22334C;" +
                "-fx-border-radius: 18;"
        );


        // =========================================================
        // HOVER ANIMATION
        // =========================================================

        ScaleTransition scaleUp =
                new ScaleTransition(
                        Duration.millis(120),
                        card
                );


        scaleUp.setToX(
                1.04
        );


        scaleUp.setToY(
                1.04
        );


        ScaleTransition scaleDown =
                new ScaleTransition(
                        Duration.millis(120),
                        card
                );


        scaleDown.setToX(
                1.0
        );


        scaleDown.setToY(
                1.0
        );


        // =========================================================
        // CURSOR ENTER
        // =========================================================

        card.setOnMouseEntered(e -> {

            scaleDown.stop();

            scaleUp.playFromStart();


            card.setStyle(
                    "-fx-background-color: #0E1D33;" +
                    "-fx-background-radius: 18;" +
                    "-fx-border-color: #2196F3;" +
                    "-fx-border-radius: 18;" +
                    "-fx-effect: dropshadow(gaussian, rgba(33,150,243,0.7), 20, 0.5, 0, 5);"
            );

        });


        // =========================================================
        // CURSOR EXIT
        // =========================================================

        card.setOnMouseExited(e -> {

            scaleUp.stop();

            scaleDown.playFromStart();


            card.setStyle(
                    "-fx-background-color: #0B162A;" +
                    "-fx-background-radius: 18;" +
                    "-fx-border-color: #22334C;" +
                    "-fx-border-radius: 18;"
            );

        });


        return card;
    }


    // =============================================================
    // SELECT ROLE CARD
    // =============================================================

    private void selectRoleCard(
            VBox selected,
            VBox other1,
            VBox other2) {


        // =========================================================
        // SELECTED CARD
        // =========================================================

        selected.setStyle(
                "-fx-background-color: #0E1D33;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #2196F3;" +
                "-fx-border-radius: 18;" +
                "-fx-effect: dropshadow(gaussian, rgba(33,150,243,0.8), 25, 0.6, 0, 5);"
        );


        // =========================================================
        // OTHER CARD 1
        // =========================================================

        other1.setStyle(
                "-fx-background-color: #0B162A;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #22334C;" +
                "-fx-border-radius: 18;"
        );


        // =========================================================
        // OTHER CARD 2
        // =========================================================

        other2.setStyle(
                "-fx-background-color: #0B162A;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #22334C;" +
                "-fx-border-radius: 18;"
        );

    }


    // =============================================================
    // BLUE BUTTON
    // =============================================================

    private Button createBlueButton(
            String text) {


        Button button = new Button(
                text
        );


        button.setMaxWidth(
                Double.MAX_VALUE
        );


        button.setStyle(
                "-fx-background-color: linear-gradient(to right, #2188FF, #19B5F1);" +
                "-fx-background-radius: 20;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 11 20 11 20;" +
                "-fx-effect: dropshadow(gaussian, rgba(33,136,255,0.5), 20, 0.5, 0, 4);"
        );


        // =========================================================
        // BUTTON HOVER ANIMATION
        // =========================================================

        ScaleTransition scaleUp =
                new ScaleTransition(
                        Duration.millis(120),
                        button
                );


        scaleUp.setToX(
                1.04
        );


        scaleUp.setToY(
                1.04
        );


        ScaleTransition scaleDown =
                new ScaleTransition(
                        Duration.millis(120),
                        button
                );


        scaleDown.setToX(
                1.0
        );


        scaleDown.setToY(
                1.0
        );


        // =========================================================
        // MOUSE ENTER
        // =========================================================

        button.setOnMouseEntered(e -> {

            scaleDown.stop();

            scaleUp.playFromStart();

        });


        // =========================================================
        // MOUSE EXIT
        // =========================================================

        button.setOnMouseExited(e -> {

            scaleUp.stop();

            scaleDown.playFromStart();

        });


        return button;
    }


    // =============================================================
    // SIMPLE BUTTON
    // =============================================================

    private Button createSimpleButton(
            String text) {


        Button button = new Button(
                text
        );


        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-padding: 8 15 8 15;"
        );


        // =========================================================
        // MOUSE ENTER
        // =========================================================

        button.setOnMouseEntered(e -> {

            button.setStyle(
                    "-fx-background-color: rgba(33,136,255,0.18);" +
                    "-fx-background-radius: 15;" +
                    "-fx-text-fill: #4CA8FF;" +
                    "-fx-font-size: 12px;" +
                    "-fx-padding: 8 15 8 15;" +
                    "-fx-effect: dropshadow(gaussian, rgba(33,136,255,0.5), 15, 0.4, 0, 0);"
            );

        });


        // =========================================================
        // MOUSE EXIT
        // =========================================================

        button.setOnMouseExited(e -> {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 12px;" +
                    "-fx-padding: 8 15 8 15;"
            );

        });


        return button;
    }

}