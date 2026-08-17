package com.ciphercore.view.auth;

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

public class RegisterPage {

    private Scene registerScene;

    public Scene getRegisterScene(Runnable backToLogin) {

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #020713, #06152D, #020713);"
        );

        // TOP BAR
        HBox topBar = new HBox();
        topBar.setPadding(new Insets(12, 28, 12, 28));
        topBar.setAlignment(Pos.CENTER_LEFT);

        Circle logoCircle = new Circle(20);
        logoCircle.setFill(Color.web("#2196F3"));

        Label shield = new Label("♢");
        shield.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );

        StackPane logoBox = new StackPane(
                logoCircle,
                shield
        );

        logoBox.setPrefSize(42, 42);

        Label brandName = new Label("PRIVORA");
        brandName.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 19px;" +
                "-fx-font-weight: bold;"
        );

        Label tagline = new Label("PRIVACY CONTROLLED");
        tagline.setStyle(
                "-fx-text-fill: #7D8BA3;" +
                "-fx-font-size: 9px;" +
                "-fx-letter-spacing: 1px;"
        );

        VBox brandText = new VBox(
                0,
                brandName,
                tagline
        );

        HBox brand = new HBox(
                10,
                logoBox,
                brandText
        );

        brand.setAlignment(Pos.CENTER_LEFT);

        HBox.setHgrow(
                brand,
                javafx.scene.layout.Priority.ALWAYS
        );

        Button loginButton = createSimpleButton("Back to login");

        loginButton.setOnAction(e -> {
            if (backToLogin != null) {
                backToLogin.run();
            }
        });

        topBar.getChildren().addAll(
                brand,
                loginButton
        );

        // REGISTER CARD
        VBox registerCard = new VBox();

        registerCard.setPadding(new Insets(30));
        registerCard.setSpacing(14);
        registerCard.setMaxWidth(470);

        registerCard.setStyle(
                "-fx-background-color: rgba(9,20,40,0.88);" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 22;"
        );

        // HEADING
        Label heading = new Label("Create your account");

        heading.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Join PRIVORA and keep your documents under control"
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

        // NAME
        Label nameLabel = createLabel("Full Name");

        TextField nameField = new TextField();
        nameField.setPromptText("Enter your full name");
        styleField(nameField);

        // EMAIL
        Label emailLabel = createLabel("Email");

        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        styleField(emailField);

        // PASSWORD
        Label passwordLabel = createLabel("Password");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Create a password");
        styleField(passwordField);

        // CONFIRM PASSWORD
        Label confirmLabel = createLabel("Confirm Password");

        PasswordField confirmPasswordField = new PasswordField();
        confirmPasswordField.setPromptText("Re-enter your password");
        styleField(confirmPasswordField);

        // ROLE
        Label roleLabel = createLabel("Account Type");

        VBox userCard = createRoleCard(
                "♙",
                "User",
                "Send documents"
        );

        VBox xeroxCard = createRoleCard(
                "▥",
                "Xerox Centre",
                "Print documents"
        );

        VBox adminCard = createRoleCard(
                "♢",
                "Admin",
                "Manage platform"
        );

        HBox roleBox = new HBox(
                10,
                userCard,
                xeroxCard,
                adminCard
        );

        roleBox.setAlignment(Pos.CENTER);

        final String[] selectedRole = {"User"};

        selectRoleCard(
                userCard,
                xeroxCard,
                adminCard
        );

        userCard.setOnMouseClicked(e -> {

            selectedRole[0] = "User";

            selectRoleCard(
                    userCard,
                    xeroxCard,
                    adminCard
            );
        });

        xeroxCard.setOnMouseClicked(e -> {

            selectedRole[0] = "Xerox";

            selectRoleCard(
                    xeroxCard,
                    userCard,
                    adminCard
            );
        });

        adminCard.setOnMouseClicked(e -> {

            selectedRole[0] = "Admin";

            selectRoleCard(
                    adminCard,
                    userCard,
                    xeroxCard
            );
        });

        // CREATE ACCOUNT
        Button createAccount = createBlueButton(
                "Create Account"
        );

        createAccount.setOnAction(e -> {

            System.out.println("Create Account clicked");

            System.out.println(
                    "Name: " + nameField.getText()
            );

            System.out.println(
                    "Email: " + emailField.getText()
            );

            System.out.println(
                    "Role: " + selectedRole[0]
            );

        });

        Label existingAccount = new Label(
                "Already have an account? Back to login"
        );

        existingAccount.setStyle(
                "-fx-text-fill: #8C9BB0;" +
                "-fx-font-size: 12px;"
        );

        registerCard.getChildren().addAll(
                headingBox,

                nameLabel,
                nameField,

                emailLabel,
                emailField,

                passwordLabel,
                passwordField,

                confirmLabel,
                confirmPasswordField,

                roleLabel,
                roleBox,

                createAccount,

                existingAccount
        );

        // CENTER
        StackPane centerBox = new StackPane(
                registerCard
        );

        centerBox.setPadding(
                new Insets(30)
        );

        ScrollPane scrollPane = new ScrollPane(
                centerBox
        );

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

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

        root.setTop(topBar);
        root.setCenter(scrollPane);

        registerScene = new Scene(
                root,
                1300,
                750
        );

        return registerScene;
    }

    private Label createLabel(String text) {

        Label label = new Label(text);

        label.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        return label;
    }

    private void styleField(TextField field) {

        field.setStyle(
                "-fx-background-color: #071226;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #24354E;" +
                "-fx-border-radius: 20;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #66758A;" +
                "-fx-padding: 10 15 10 15;"
        );

        field.setMaxWidth(
                Double.MAX_VALUE
        );
    }

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
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        Label descriptionLabel = new Label(
                description
        );

        descriptionLabel.setStyle(
                "-fx-text-fill: #7E8DA3;" +
                "-fx-font-size: 9px;"
        );

        VBox card = new VBox(
                7,
                iconLabel,
                titleLabel,
                descriptionLabel
        );

        card.setPadding(new Insets(11));
        card.setPrefWidth(125);
        card.setPrefHeight(95);

        card.setAlignment(Pos.CENTER);

        card.setStyle(
                "-fx-background-color: #0B162A;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #22334C;" +
                "-fx-border-radius: 18;"
        );

        return card;
    }

    private void selectRoleCard(
            VBox selected,
            VBox other1,
            VBox other2) {

        selected.setStyle(
                "-fx-background-color: #0E1D33;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #2196F3;" +
                "-fx-border-radius: 18;" +
                "-fx-effect: dropshadow(gaussian, rgba(33,150,243,0.8), 25, 0.6, 0, 5);"
        );

        other1.setStyle(
                "-fx-background-color: #0B162A;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #22334C;" +
                "-fx-border-radius: 18;"
        );

        other2.setStyle(
                "-fx-background-color: #0B162A;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #22334C;" +
                "-fx-border-radius: 18;"
        );
    }

    private Button createBlueButton(String text) {

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
                "-fx-padding: 11 20 11 20;"
        );

        return button;
    }

    private Button createSimpleButton(String text) {

        Button button = new Button(text);

        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-padding: 8 15 8 15;"
        );

        return button;
    }
}