package com.finalproj.view.auth;

import com.finalproj.view.landing.Homepage;
import com.finalproj.view.user.UserDashboard;

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
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class LoginPage {

    private Scene loginScene;

    // =========================================================
    // LOGIN SCENE
    // =========================================================

    public Scene getLoginScene(Runnable rhp) {

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

        brand.setAlignment(
                Pos.CENTER_LEFT
        );

        // =========================================================
        // CREATE ACCOUNT BUTTON
        // =========================================================

        Button createAccount = createSimpleButton(
                "Create account"
        );

        createAccount.setOnAction(e -> {

            System.out.println(
                    "Create account clicked"
            );

            RegisterPage registerPage =
                    new RegisterPage();

            Runnable backToLogin = () -> {

                System.out.println(
                        "Back to Login clicked"
                );

                LoginPage loginPage =
                        new LoginPage();

                Homepage.homeStage.setScene(
                        loginPage.getLoginScene(rhp)
                );
            };

            Homepage.homeStage.setScene(
                    registerPage.getRegisterScene(
                            backToLogin
                    )
            );
        });

        HBox.setHgrow(
                brand,
                Priority.ALWAYS
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
                "-fx-border-radius: 22;" +
                "-fx-effect: dropshadow(gaussian, rgba(0,0,0,0.35), 25, 0.4, 0, 8);"
        );

        // =========================================================
        // HEADING
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
        // ROLE CARDS
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

        final String[] selectedRole = {
                "User"
        };

        selectRoleCard(
                userCard,
                xeroxCard,
                adminCard
        );

        // =========================================================
        // SIGN IN BUTTON (declare early so role handlers can access)
        // =========================================================

        Button signInButton = createBlueButton(
                "Sign in as User"
        );

        // =========================================================
        // USER ROLE
        // =========================================================

        userCard.setOnMouseClicked(e -> {

            selectedRole[0] = "User";

            System.out.println(
                    "Selected Role: User"
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
        // XEROX ROLE
        // =========================================================

        xeroxCard.setOnMouseClicked(e -> {

            selectedRole[0] = "Xerox";

            System.out.println(
                    "Selected Role: Xerox"
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
        // ADMIN ROLE
        // =========================================================

        adminCard.setOnMouseClicked(e -> {

            selectedRole[0] = "Admin";

            System.out.println(
                    "Selected Role: Admin"
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

        styleTextField(
                emailField
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

        styleTextField(
                passwordField
        );

        // (Sign in button already declared above)

        // =========================================================
        // SIGN IN ACTION
        // =========================================================

        signInButton.setOnAction(e -> {

            System.out.println(
                    "Sign in clicked"
            );

            System.out.println(
                    "Role: " +
                    selectedRole[0]
            );

            System.out.println(
                    "Email: " +
                    emailField.getText()
            );

            // =====================================================
            // USER DASHBOARD NAVIGATION
            // =====================================================

            if (selectedRole[0].equals("User")) {

                System.out.println(
                        "Opening User Dashboard..."
                );

                UserDashboard userDashboard =
                        new UserDashboard();

                Runnable logout = () -> {

                    System.out.println(
                            "Logout clicked"
                    );

                    Homepage.homeStage.setScene(
                            getLoginScene(rhp)
                    );
                };

                Homepage.homeStage.setScene(
                        userDashboard.getDashboardScene(
                                logout
                        )
                );
            }

            // =====================================================
            // XEROX
            // =====================================================

            else if (selectedRole[0].equals("Xerox")) {

                System.out.println(
                        "Xerox Dashboard coming soon..."
                );
            }

            // =====================================================
            // ADMIN
            // =====================================================

            else if (selectedRole[0].equals("Admin")) {

                System.out.println(
                        "Admin Dashboard coming soon..."
                );
            }
        });

        // =========================================================
        // BOTTOM TEXT
        // =========================================================

        Label newHere = new Label(
                "New here? Create an account"
        );

        newHere.setStyle(
                "-fx-text-fill: #8C9BB0;" +
                "-fx-font-size: 12px;"
        );

        // =========================================================
        // ADD TO CARD
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
        // CENTER
        // =========================================================

        StackPane centerBox =
                new StackPane(
                        loginCard
                );

        centerBox.setPadding(
                new Insets(40)
        );

        // =========================================================
        // SCROLL
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

        card.setStyle(
                "-fx-background-color: #0B162A;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #22334C;" +
                "-fx-border-radius: 18;"
        );

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

            scale.setToX(1.04);
            scale.setToY(1.04);

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

        Button button =
                new Button(text);

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

        Button button =
                new Button(text);

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