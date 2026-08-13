package com.finalproj.view.auth;

import com.finalproj.view.landing.Homepage;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class RegisterPage {

    private Scene registerScene;

    // =========================================================
    // REGISTER SCENE
    // =========================================================

    public Scene getRegisterScene(Runnable backToLogin) {

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
        logoCircle.setFill(Color.web("#2196F3"));

        Label shield = new Label("♢");

        shield.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );

        StackPane logoBox = new StackPane();

        logoBox.setPrefSize(42, 42);

        logoBox.getChildren().addAll(
                logoCircle,
                shield
        );

        // =========================================================
        // BRAND
        // =========================================================

        Label brandName = new Label("PRIVORA");

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

        brand.setAlignment(Pos.CENTER_LEFT);

        // =========================================================
        // BACK TO LOGIN
        // =========================================================

        Button backButton = createSimpleButton(
                "← Back to login"
        );

        backButton.setOnAction(e -> {

            System.out.println(
                    "Back to Login clicked"
            );

            backToLogin.run();
        });

        HBox.setHgrow(
                brand,
                Priority.ALWAYS
        );

        topBar.getChildren().addAll(
                brand,
                backButton
        );

        // =========================================================
        // REGISTER CARD
        // =========================================================

        VBox registerCard = new VBox();

        registerCard.setPadding(
                new Insets(30)
        );

        registerCard.setSpacing(13);

        registerCard.setMaxWidth(480);

        registerCard.setStyle(
                "-fx-background-color: rgba(9,20,40,0.90);" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 22;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.35), 25, 0.4, 0, 8);"
        );

        // =========================================================
        // HEADING
        // =========================================================

        Label heading = new Label(
                "Create your account"
        );

        heading.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Join PRIVORA and take control of your documents"
        );

        subtitle.setStyle(
                "-fx-text-fill: #8C9BB0;" +
                "-fx-font-size: 12px;"
        );

        VBox headingBox = new VBox(
                5,
                heading,
                subtitle
        );

        headingBox.setAlignment(Pos.CENTER);

        // =========================================================
        // ROLE SELECTION
        // =========================================================

        Label roleLabel = new Label(
                "Account type"
        );

        roleLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        VBox userCard = createRoleCard(
                "♙",
                "User",
                "Share documents"
        );

        VBox xeroxCard = createRoleCard(
                "▥",
                "Xerox Centre",
                "Print documents"
        );

        HBox roleBox = new HBox(
                12,
                userCard,
                xeroxCard
        );

        roleBox.setAlignment(Pos.CENTER);

        HBox.setHgrow(
                userCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                xeroxCard,
                Priority.ALWAYS
        );

        final String[] selectedRole = {
                "User"
        };

        selectRoleCard(
                userCard,
                xeroxCard
        );

        // =========================================================
        // USER ROLE CLICK
        // =========================================================

        userCard.setOnMouseClicked(e -> {

            selectedRole[0] = "User";

            System.out.println(
                    "Selected Role: User"
            );

            selectRoleCard(
                    userCard,
                    xeroxCard
            );
        });

        // =========================================================
        // XEROX ROLE CLICK
        // =========================================================

        xeroxCard.setOnMouseClicked(e -> {

            selectedRole[0] = "Xerox";

            System.out.println(
                    "Selected Role: Xerox"
            );

            selectRoleCard(
                    xeroxCard,
                    userCard
            );
        });

        // =========================================================
        // FULL NAME
        // =========================================================

        Label nameLabel = createFieldLabel(
                "Full name"
        );

        TextField nameField = new TextField();

        nameField.setPromptText(
                "Enter your full name"
        );

        styleTextField(nameField);

        // =========================================================
        // EMAIL
        // =========================================================

        Label emailLabel = createFieldLabel(
                "Email"
        );

        TextField emailField = new TextField();

        emailField.setPromptText(
                "you@example.com"
        );

        styleTextField(emailField);

        // =========================================================
        // PASSWORD
        // =========================================================

        Label passwordLabel = createFieldLabel(
                "Password"
        );

        PasswordField passwordField =
                new PasswordField();

        passwordField.setPromptText(
                "Create a password"
        );

        styleTextField(passwordField);

        // =========================================================
        // CONFIRM PASSWORD
        // =========================================================

        Label confirmLabel = createFieldLabel(
                "Confirm password"
        );

        PasswordField confirmField =
                new PasswordField();

        confirmField.setPromptText(
                "Confirm your password"
        );

        styleTextField(confirmField);

        // =========================================================
        // TERMS CHECKBOX
        // =========================================================

        CheckBox terms = new CheckBox(
                "I agree to the PRIVORA terms and privacy policy"
        );

        terms.setStyle(
                "-fx-text-fill: #8C9BB0;" +
                "-fx-font-size: 11px;"
        );

        // =========================================================
        // MESSAGE LABEL
        // =========================================================

        Label messageLabel = new Label();

        messageLabel.setStyle(
                "-fx-text-fill: #FF6B6B;" +
                "-fx-font-size: 11px;"
        );

        // =========================================================
        // CREATE ACCOUNT BUTTON
        // =========================================================

        Button createAccount = createBlueButton(
                "Create account"
        );

        createAccount.setOnAction(e -> {

            System.out.println(
                    "Create account clicked"
            );

            System.out.println(
                    "Name: " +
                    nameField.getText()
            );

            System.out.println(
                    "Email: " +
                    emailField.getText()
            );

            System.out.println(
                    "Role: " +
                    selectedRole[0]
            );

            // ---------------------------------------------
            // BASIC VALIDATION
            // ---------------------------------------------

            if (nameField.getText().isEmpty()) {

                messageLabel.setText(
                        "Please enter your name."
                );

                return;
            }

            if (emailField.getText().isEmpty()) {

                messageLabel.setText(
                        "Please enter your email."
                );

                return;
            }

            if (passwordField.getText().isEmpty()) {

                messageLabel.setText(
                        "Please enter a password."
                );

                return;
            }

            if (!passwordField.getText().equals(
                    confirmField.getText())) {

                messageLabel.setText(
                        "Passwords do not match."
                );

                return;
            }

            if (!terms.isSelected()) {

                messageLabel.setText(
                        "Please accept the terms."
                );

                return;
            }

            // ---------------------------------------------
            // TEMPORARY SUCCESS
            // ---------------------------------------------

            messageLabel.setStyle(
                    "-fx-text-fill: #19D6A3;" +
                    "-fx-font-size: 11px;"
            );

            messageLabel.setText(
                    "Account details are valid!"
            );

            System.out.println(
                    "Registration successful"
            );

            /*
             * Firebase registration will be added here later.
             */
        });

        // =========================================================
        // LOGIN TEXT
        // =========================================================

        Label alreadyAccount = new Label(
                "Already have an account? Sign in"
        );

        alreadyAccount.setStyle(
                "-fx-text-fill: #8C9BB0;" +
                "-fx-font-size: 12px;"
        );

        alreadyAccount.setOnMouseClicked(e -> {

            System.out.println(
                    "Sign in text clicked"
            );

            backToLogin.run();
        });

        alreadyAccount.setOnMouseEntered(e -> {

            alreadyAccount.setStyle(
                    "-fx-text-fill: #4CA8FF;" +
                    "-fx-font-size: 12px;" +
                    "-fx-cursor: hand;"
            );

        });

        // =========================================================
        // ADD EVERYTHING TO CARD
        // =========================================================

        registerCard.getChildren().addAll(

                headingBox,

                roleLabel,
                roleBox,

                nameLabel,
                nameField,

                emailLabel,
                emailField,

                passwordLabel,
                passwordField,

                confirmLabel,
                confirmField,

                terms,

                messageLabel,

                createAccount,

                alreadyAccount
        );

        // =========================================================
        // CENTER
        // =========================================================

        StackPane centerBox = new StackPane(
                registerCard
        );

        centerBox.setPadding(
                new Insets(30)
        );

        // =========================================================
        // SCROLL
        // =========================================================

        ScrollPane scrollPane =
                new ScrollPane(centerBox);

        scrollPane.setFitToWidth(true);

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

        root.setTop(topBar);

        root.setCenter(scrollPane);

        // =========================================================
        // SCENE
        // =========================================================

        registerScene = new Scene(
                root,
                1300,
                700
        );

        return registerScene;
    }

    // =============================================================
    // ROLE CARD
    // =============================================================

    private VBox createRoleCard(
            String icon,
            String title,
            String description) {

        Label iconLabel = new Label(icon);

        iconLabel.setStyle(
                "-fx-background-color: #14243D;" +
                "-fx-background-radius: 50%;" +
                "-fx-text-fill: #A8B8CC;" +
                "-fx-padding: 8;"
        );

        Label titleLabel = new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        Label descriptionLabel =
                new Label(description);

        descriptionLabel.setStyle(
                "-fx-text-fill: #7E8DA3;" +
                "-fx-font-size: 10px;"
        );

        VBox card = new VBox(
                7,
                iconLabel,
                titleLabel,
                descriptionLabel
        );

        card.setPadding(
                new Insets(12)
        );

        card.setPrefHeight(95);

        card.setAlignment(
                Pos.CENTER_LEFT
        );

        card.setStyle(
                "-fx-background-color: #0B162A;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #22334C;" +
                "-fx-border-radius: 18;"
        );

        // Hover

        card.setOnMouseEntered(e -> {

            card.setStyle(
                    "-fx-background-color: #0E1D33;" +
                    "-fx-background-radius: 18;" +
                    "-fx-border-color: #2196F3;" +
                    "-fx-border-radius: 18;" +
                    "-fx-effect: dropshadow(gaussian, rgba(33,150,243,0.7), 20, 0.5, 0, 5);"
            );

            ScaleTransition scale =
                    new ScaleTransition(
                            Duration.millis(120),
                            card
                    );

            scale.setToX(1.03);
            scale.setToY(1.03);

            scale.play();
        });

        card.setOnMouseExited(e -> {

            ScaleTransition scale =
                    new ScaleTransition(
                            Duration.millis(120),
                            card
                    );

            scale.setToX(1);
            scale.setToY(1);

            scale.play();
        });

        return card;
    }

    // =============================================================
    // SELECT ROLE
    // =============================================================

    private void selectRoleCard(
            VBox selected,
            VBox other) {

        selected.setStyle(
                "-fx-background-color: #0E1D33;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #2196F3;" +
                "-fx-border-radius: 18;" +
                "-fx-effect: dropshadow(gaussian, rgba(33,150,243,0.8), 25, 0.6, 0, 5);"
        );

        other.setStyle(
                "-fx-background-color: #0B162A;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #22334C;" +
                "-fx-border-radius: 18;"
        );
    }

    // =============================================================
    // FIELD LABEL
    // =============================================================

    private Label createFieldLabel(
            String text) {

        Label label = new Label(text);

        label.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        return label;
    }

    // =============================================================
    // TEXT FIELD STYLE
    // =============================================================

    private void styleTextField(
            TextField field) {

        field.setStyle(
                "-fx-background-color: #071226;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #24354E;" +
                "-fx-border-radius: 20;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #66758A;" +
                "-fx-padding: 10 15 10 15;"
        );
    }

    // =============================================================
    // BLUE BUTTON
    // =============================================================

    private Button createBlueButton(
            String text) {

        Button button = new Button(text);

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

        button.setOnMouseEntered(e -> {

            ScaleTransition scale =
                    new ScaleTransition(
                            Duration.millis(120),
                            button
                    );

            scale.setToX(1.04);
            scale.setToY(1.04);

            scale.play();
        });

        button.setOnMouseExited(e -> {

            ScaleTransition scale =
                    new ScaleTransition(
                            Duration.millis(120),
                            button
                    );

            scale.setToX(1);
            scale.setToY(1);

            scale.play();
        });

        return button;
    }

    // =============================================================
    // SIMPLE BUTTON
    // =============================================================

    private Button createSimpleButton(
            String text) {

        Button button = new Button(text);

        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-padding: 8 15 8 15;"
        );

        button.setOnMouseEntered(e -> {

            button.setStyle(
                    "-fx-background-color: rgba(33,136,255,0.18);" +
                    "-fx-background-radius: 15;" +
                    "-fx-text-fill: #4CA8FF;" +
                    "-fx-font-size: 12px;" +
                    "-fx-padding: 8 15 8 15;"
            );
        });

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