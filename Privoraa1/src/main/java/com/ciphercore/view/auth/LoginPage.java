package com.ciphercore.view.auth;

import com.ciphercore.controller.LoginController;
import com.ciphercore.view.admin.AdminDashboard;
import com.ciphercore.view.landing.HomePage;
import com.ciphercore.view.user.UserDashboard;
import com.ciphercore.view.xerox.XeroxDashboard;

import javafx.animation.ScaleTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class LoginPage {

    private Scene loginScene;

    private VBox selectedCard;

    // =========================================================
    // LOGIN SCENE
    // =========================================================

    public Scene getLoginScene(Runnable rhp) {

        LoginController loginController =
                new LoginController();

        // =====================================================
        // ROOT
        // =====================================================

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #0B0A10, #171225, #0B0A10);"
        );

        // =====================================================
        // TOP BAR
        // =====================================================

        HBox topBar =
                new HBox();

        topBar.setPadding(
                new Insets(10, 28, 10, 28)
        );

        topBar.setAlignment(
                Pos.CENTER_LEFT
        );

        // =====================================================
        // LOGO
        // =====================================================

        Circle logoCircle =
                new Circle(20);

        logoCircle.setFill(
                Color.web("#8B5CF6")
        );

        Image shieldImage =
                new Image(
                        "/assets/images/Cipherlogo.png"
                );

        ImageView shieldView =
                new ImageView(
                        shieldImage
                );

        shieldView.setFitWidth(28);
        shieldView.setFitHeight(28);
        shieldView.setPreserveRatio(true);

        StackPane shieldBox =
                new StackPane(
                        shieldView
                );

        shieldBox.setPrefSize(
                42,
                42
        );

        shieldBox.setStyle(
                "-fx-background-color: #7C3AED;" +
                "-fx-background-radius: 50%;" +
                "-fx-effect: dropshadow(gaussian, rgba(124,58,237,0.7), 15, 0.5, 0, 0);"
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
        // BRAND
        // =====================================================

        Label brandName =
                new Label("PRIVORA");

        brandName.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 19px;" +
                "-fx-font-weight: bold;"
        );

        Label brandTagline =
                new Label(
                        "PRIVACY CONTROLLED"
                );

        brandTagline.setStyle(
                "-fx-text-fill: #9B91B5;" +
                "-fx-font-size: 9px;" +
                "-fx-letter-spacing: 1px;"
        );

        VBox brandText =
                new VBox(
                        0,
                        brandName,
                        brandTagline
                );

        HBox brand =
                new HBox(
                        10,
                        logoBox,
                        brandText
                );

        brand.setAlignment(
                Pos.CENTER_LEFT
        );

        // =====================================================
        // CREATE ACCOUNT BUTTON
        // =====================================================

        Button createAccount =
                createSimpleButton(
                        "Create account"
                );

        createAccount.setOnAction(e -> {

            Runnable rlp =
                    new Runnable() {

                        @Override
                        public void run() {
                            backtologin();
                        }
                    };

            RegisterPage registerPage =
                    new RegisterPage();

            HomePage.homeStage.setScene(
                    registerPage.getRegisterScene(
                            rlp
                    )
            );
        });

        HBox.setHgrow(
                brand,
                javafx.scene.layout.Priority.ALWAYS
        );

        topBar.getChildren().addAll(
                brand,
                createAccount
        );

        // =====================================================
        // LOGIN CARD
        // =====================================================

        VBox loginCard =
                new VBox();

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
                "-fx-background-color: rgba(22,17,34,0.94);" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #33254D;" +
                "-fx-border-radius: 22;" +
                "-fx-effect: dropshadow(gaussian, rgba(124,58,237,0.15), 30, 0.3, 0, 8);"
        );

        // =====================================================
        // HEADING
        // =====================================================

        Label welcome =
                new Label(
                        "Welcome back"
                );

        welcome.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 23px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle =
                new Label(
                        "Sign in to continue to PRIVORA"
                );

        subtitle.setStyle(
                "-fx-text-fill: #A49AB8;" +
                "-fx-font-size: 13px;"
        );

        VBox headingBox =
                new VBox(
                        5,
                        welcome,
                        subtitle
                );

        headingBox.setAlignment(
                Pos.CENTER
        );

        // =====================================================
        // ROLE CARDS
        // =====================================================

        VBox userCard =
                createRoleCard(
                        "♙",
                        "User",
                        "Upload & share\ndocuments"
                );

        VBox xeroxCard =
                createRoleCard(
                        "▥",
                        "Xerox Centre",
                        "Handle print requests"
                );

        VBox adminCard =
                createRoleCard(
                        "♢",
                        "Admin",
                        "Manage the platform"
                );

        HBox roleBox =
                new HBox(
                        10,
                        userCard,
                        xeroxCard,
                        adminCard
                );

        roleBox.setAlignment(
                Pos.CENTER
        );

        // =====================================================
        // SELECTED ROLE
        // =====================================================

        final String[] selectedRole = {
                "User"
        };

        selectRoleCard(
                userCard,
                xeroxCard,
                adminCard
        );

        // =====================================================
        // SIGN IN BUTTON
        // =====================================================

        Button signInButton =
                createBlueButton(
                        "Sign in as User"
                );

        // =====================================================
        // USER ROLE
        // =====================================================

        userCard.setOnMouseClicked(e -> {

            selectedRole[0] =
                    "User";

            selectRoleCard(
                    userCard,
                    xeroxCard,
                    adminCard
            );

            signInButton.setText(
                    "Sign in as User"
            );
        });

        // =====================================================
        // XEROX ROLE
        // =====================================================

        xeroxCard.setOnMouseClicked(e -> {

            selectedRole[0] =
                    "Xerox";

            selectRoleCard(
                    xeroxCard,
                    userCard,
                    adminCard
            );

            signInButton.setText(
                    "Sign in as Xerox"
            );
        });

        // =====================================================
        // ADMIN ROLE
        // =====================================================

        adminCard.setOnMouseClicked(e -> {

            selectedRole[0] =
                    "Admin";

            selectRoleCard(
                    adminCard,
                    userCard,
                    xeroxCard
            );

            signInButton.setText(
                    "Sign in as Admin"
            );
        });

        // =====================================================
        // EMAIL
        // =====================================================

        Label emailLabel =
                new Label("Email");

        emailLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        TextField emailField =
                new TextField();

        emailField.setPromptText(
                "superx@privora.app"
        );

        emailField.setStyle(
                "-fx-background-color: #15111F;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #3A2C50;" +
                "-fx-border-radius: 20;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #746A85;" +
                "-fx-padding: 10 15 10 15;"
        );

        // =====================================================
        // PASSWORD
        // =====================================================

        Label passwordLabel =
                new Label("Password");

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
                "-fx-background-color: #15111F;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #3A2C50;" +
                "-fx-border-radius: 20;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #746A85;" +
                "-fx-padding: 10 15 10 15;"
        );

        // =====================================================
        // LOGIN MESSAGE
        // =====================================================

        Label loginMessage =
                new Label();

        loginMessage.setStyle(
                "-fx-text-fill: #FF6B6B;" +
                "-fx-font-size: 12px;"
        );

        // =====================================================
        // SIGN IN ACTION
        // =====================================================

        signInButton.setOnAction(e -> {

            String email =
                    emailField.getText().trim();

            String password =
                    passwordField.getText();

            String role =
                    selectedRole[0];

            // =============================================
            // VALIDATE EMAIL
            // =============================================

            if (email.isEmpty()) {

                loginMessage.setStyle(
                        "-fx-text-fill: #FF6B6B;" +
                        "-fx-font-size: 12px;"
                );

                loginMessage.setText(
                        "Please enter your email."
                );

                return;
            }

            // =============================================
            // VALIDATE PASSWORD
            // =============================================

            if (password.isEmpty()) {

                loginMessage.setStyle(
                        "-fx-text-fill: #FF6B6B;" +
                        "-fx-font-size: 12px;"
                );

                loginMessage.setText(
                        "Please enter your password."
                );

                return;
            }

            // =============================================
            // FIREBASE LOGIN
            // =============================================

            boolean loginSuccess =
                    loginController.login(
                            email,
                            password,
                            role
                    );

            // =============================================
            // LOGIN SUCCESS
            // =============================================

            if (loginSuccess) {

                // =========================================
                // LOGOUT ACTION
                // =========================================

                Runnable logoutAction =
                        new Runnable() {

                            @Override
                            public void run() {
                                backtologin();
                            }
                        };

                // =========================================
                // USER DASHBOARD
                // =========================================

                if (role.equals("User")) {

                    UserDashboard userDashboard =
                            new UserDashboard();

                    HomePage.homeStage.setScene(
                            userDashboard.getUserDashboardScene(
                                    logoutAction
                            )
                    );

                    return;
                }

                // =========================================
                // XEROX DASHBOARD
                // =========================================

                if (role.equals("Xerox")) {

                    XeroxDashboard xeroxDashboard =
                            new XeroxDashboard();

                    HomePage.homeStage.setScene(
                            xeroxDashboard.getXeroxDashboardScene(
                                    logoutAction
                            )
                    );

                    return;
                }

                // =========================================
                // ADMIN DASHBOARD
                // =========================================

                if (role.equals("Admin")) {

                    AdminDashboard adminDashboard =
                            new AdminDashboard();

                    HomePage.homeStage.setScene(
                            adminDashboard.getAdminDashboardScene(
                                    logoutAction
                            )
                    );

                    return;
                }
            }

            // =============================================
            // LOGIN FAILED
            // =============================================

            else {

                loginMessage.setStyle(
                        "-fx-text-fill: #FF6B6B;" +
                        "-fx-font-size: 12px;"
                );

                loginMessage.setText(
                        "Invalid email or password."
                );
            }
        });

        // =====================================================
        // CREATE ACCOUNT LINK
        // =====================================================

        Button createLinkButton =
                createLinkButton(
                        "New here? Create an account"
                );

        createLinkButton.setOnAction(e -> {

            Runnable rlp =
                    new Runnable() {

                        @Override
                        public void run() {
                            backtologin();
                        }
                    };

            RegisterPage registerPage =
                    new RegisterPage();

            HomePage.homeStage.setScene(
                    registerPage.getRegisterScene(
                            rlp
                    )
            );
        });

        // =====================================================
        // ADD CONTENT TO LOGIN CARD
        // =====================================================

        loginCard.getChildren().addAll(
                headingBox,
                roleBox,
                emailLabel,
                emailField,
                passwordLabel,
                passwordField,
                loginMessage,
                signInButton,
                createLinkButton
        );

        // =====================================================
        // CENTER BOX
        // =====================================================

        StackPane centerBox =
                new StackPane(
                        loginCard
                );

        centerBox.setPadding(
                new Insets(40)
        );

        // =====================================================
        // SCROLL PANE
        // =====================================================

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

        // =====================================================
        // ROOT
        // =====================================================

        root.setTop(
                topBar
        );

        root.setCenter(
                scrollPane
        );

        // =====================================================
        // SCENE
        // =====================================================

        loginScene =
                new Scene(
                        root,
                        1300,
                        700
                );

        return loginScene;
    }

    // =========================================================
    // CREATE ROLE CARD
    // =========================================================

    private VBox createRoleCard(
            String icon,
            String title,
            String description) {

        Label iconLabel =
                new Label(icon);

        iconLabel.setStyle(
                "-fx-background-color: #251A38;" +
                "-fx-background-radius: 50%;" +
                "-fx-text-fill: #B99AEF;" +
                "-fx-padding: 8;"
        );

        Label titleLabel =
                new Label(title);

        titleLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        Label descriptionLabel =
                new Label(description);

        descriptionLabel.setStyle(
                "-fx-text-fill: #91869F;" +
                "-fx-font-size: 10px;"
        );

        VBox card =
                new VBox(
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
                "-fx-background-color: #17131F;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #352846;" +
                "-fx-border-radius: 18;" +
                "-fx-cursor: hand;"
        );

        ScaleTransition scaleUp =
                new ScaleTransition(
                        Duration.millis(120),
                        card
                );

        scaleUp.setToX(1.04);
        scaleUp.setToY(1.04);

        ScaleTransition scaleDown =
                new ScaleTransition(
                        Duration.millis(120),
                        card
                );

        scaleDown.setToX(1.0);
        scaleDown.setToY(1.0);

        card.setOnMouseEntered(e -> {

            if (card == selectedCard) {
                return;
            }

            scaleDown.stop();

            scaleUp.playFromStart();

            card.setStyle(
                    "-fx-background-color: #241A32;" +
                    "-fx-background-radius: 18;" +
                    "-fx-border-color: #8B5CF6;" +
                    "-fx-border-radius: 18;" +
                    "-fx-effect: dropshadow(gaussian, rgba(139,92,246,0.7), 20, 0.5, 0, 5);" +
                    "-fx-cursor: hand;"
            );
        });

        card.setOnMouseExited(e -> {

            if (card == selectedCard) {
                return;
            }

            scaleUp.stop();

            scaleDown.playFromStart();

            card.setStyle(
                    "-fx-background-color: #17131F;" +
                    "-fx-background-radius: 18;" +
                    "-fx-border-color: #352846;" +
                    "-fx-border-radius: 18;" +
                    "-fx-cursor: hand;"
            );
        });

        return card;
    }

    // =========================================================
    // SELECT ROLE CARD
    // =========================================================

    private void selectRoleCard(
            VBox selected,
            VBox other1,
            VBox other2) {

        selectedCard =
                selected;

        selected.setScaleX(1.0);
        selected.setScaleY(1.0);

        other1.setScaleX(1.0);
        other1.setScaleY(1.0);

        other2.setScaleX(1.0);
        other2.setScaleY(1.0);

        selected.setStyle(
                "-fx-background-color: #241A32;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #8B5CF6;" +
                "-fx-border-radius: 18;" +
                "-fx-effect: dropshadow(gaussian, rgba(139,92,246,0.8), 25, 0.6, 0, 5);" +
                "-fx-cursor: hand;"
        );

        other1.setStyle(
                "-fx-background-color: #17131F;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #352846;" +
                "-fx-border-radius: 18;" +
                "-fx-cursor: hand;"
        );

        other2.setStyle(
                "-fx-background-color: #17131F;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #352846;" +
                "-fx-border-radius: 18;" +
                "-fx-cursor: hand;"
        );
    }

    // =========================================================
    // PURPLE BUTTON
    // =========================================================

    private Button createBlueButton(
            String text) {

        Button button =
                new Button(text);

        button.setMaxWidth(
                Double.MAX_VALUE
        );

        button.setStyle(
                "-fx-background-color: linear-gradient(to right, #7C3AED, #A855F7);" +
                "-fx-background-radius: 20;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 11 20 11 20;" +
                "-fx-effect: dropshadow(gaussian, rgba(139,92,246,0.5), 20, 0.5, 0, 4);" +
                "-fx-cursor: hand;"
        );

        ScaleTransition scaleUp =
                new ScaleTransition(
                        Duration.millis(120),
                        button
                );

        scaleUp.setToX(1.04);
        scaleUp.setToY(1.04);

        ScaleTransition scaleDown =
                new ScaleTransition(
                        Duration.millis(120),
                        button
                );

        scaleDown.setToX(1.0);
        scaleDown.setToY(1.0);

        button.setOnMouseEntered(e -> {

            scaleDown.stop();

            scaleUp.playFromStart();
        });

        button.setOnMouseExited(e -> {

            scaleUp.stop();

            scaleDown.playFromStart();
        });

        return button;
    }

    // =========================================================
    // SIMPLE BUTTON
    // =========================================================

    private Button createSimpleButton(
            String text) {

        Button button =
                new Button(text);

        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: #F1ECF8;" +
                "-fx-font-size: 12px;" +
                "-fx-padding: 8 15 8 15;" +
                "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e -> {

            button.setStyle(
                    "-fx-background-color: rgba(139,92,246,0.18);" +
                    "-fx-background-radius: 15;" +
                    "-fx-text-fill: #B78CFF;" +
                    "-fx-font-size: 12px;" +
                    "-fx-padding: 8 15 8 15;" +
                    "-fx-cursor: hand;"
            );
        });

        button.setOnMouseExited(e -> {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: #F1ECF8;" +
                    "-fx-font-size: 12px;" +
                    "-fx-padding: 8 15 8 15;" +
                    "-fx-cursor: hand;"
            );
        });

        return button;
    }

    // =========================================================
    // CREATE LINK BUTTON
    // =========================================================

    private Button createLinkButton(
            String text) {

        Button button =
                new Button(text);

        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: #9D91AD;" +
                "-fx-font-size: 12px;" +
                "-fx-padding: 5 10 5 10;" +
                "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e -> {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: #B78CFF;" +
                    "-fx-font-size: 12px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 5 10 5 10;" +
                    "-fx-cursor: hand;"
            );
        });

        button.setOnMouseExited(e -> {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: #9D91AD;" +
                    "-fx-font-size: 12px;" +
                    "-fx-padding: 5 10 5 10;" +
                    "-fx-cursor: hand;"
            );
        });

        return button;
    }

    // =========================================================
    // BACK TO LOGIN
    // =========================================================

    public void backtologin() {

        HomePage.homeStage.setScene(
                loginScene
        );
    }
}