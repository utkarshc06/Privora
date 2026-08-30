package com.ciphercore.view.auth;

import com.ciphercore.controller.RegisterController;

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
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class RegisterPage {

    private Scene registerScene;

    // Selected role
    private String selectedRole = "USER";

    // Selected role card
    private VBox selectedRoleCardReference;

    // =============================================================
    // REGISTER SCENE
    // =============================================================

    public Scene getRegisterScene(Runnable rlp) {

        RegisterController registerController =
                new RegisterController();

        // =========================================================
        // MAIN ROOT
        // =========================================================

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #0B0A10, #171225, #0B0A10);"
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

        // =========================================================
        // BRAND
        // =========================================================

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

        // =========================================================
        // SIGN IN BUTTON
        // =========================================================

        Button signInTop =
                createSimpleButton(
                        "Sign in"
                );

        signInTop.setOnAction(e -> {

            rlp.run();

        });

        HBox.setHgrow(
                brand,
                Priority.ALWAYS
        );

        topBar.getChildren().addAll(
                brand,
                signInTop
        );

        // =========================================================
        // MAIN CONTENT
        // =========================================================

        VBox content =
                new VBox();

        content.setSpacing(
                20
        );

        content.setPadding(
                new Insets(35, 40, 40, 40)
        );

        content.setMaxWidth(
                900
        );

        // =========================================================
        // JOIN PRIVORA CARD
        // =========================================================

        VBox infoCard =
                new VBox();

        infoCard.setSpacing(
                12
        );

        infoCard.setPadding(
                new Insets(28)
        );

        infoCard.setStyle(
                "-fx-background-color: linear-gradient(to right, #24143D, #2B1748, #211333);" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #4A3268;" +
                "-fx-border-radius: 22;" +
                "-fx-effect: dropshadow(gaussian, rgba(124,58,237,0.20), 25, 0.4, 0, 5);"
        );

        Label joinTitle =
                new Label(
                        "Join PRIVORA"
                );

        joinTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 25px;" +
                "-fx-font-weight: bold;"
        );

        Label joinDescription =
                new Label(
                        "A privacy-first way to share sensitive documents with print shops and services you trust."
                );

        joinDescription.setWrapText(
                true
        );

        joinDescription.setStyle(
                "-fx-text-fill: #C4B8D6;" +
                "-fx-font-size: 13px;"
        );

        Label feature1 =
                createFeature(
                        "End-to-end privacy scoring"
                );

        Label feature2 =
                createFeature(
                        "Auto redaction of PII"
                );

        Label feature3 =
                createFeature(
                        "Rule-based session expiry"
                );

        Label feature4 =
                createFeature(
                        "Signed privacy receipts"
                );

        VBox features =
                new VBox(
                        8,
                        feature1,
                        feature2,
                        feature3,
                        feature4
                );

        infoCard.getChildren().addAll(
                joinTitle,
                joinDescription,
                features
        );

        // =========================================================
        // REGISTER CARD
        // =========================================================

        VBox registerCard =
                new VBox();

        registerCard.setSpacing(
                14
        );

        registerCard.setPadding(
                new Insets(28)
        );

        registerCard.setStyle(
                "-fx-background-color: rgba(22,17,34,0.94);" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #33254D;" +
                "-fx-border-radius: 22;" +
                "-fx-effect: dropshadow(gaussian, rgba(124,58,237,0.15), 30, 0.3, 0, 8);"
        );

        // =========================================================
        // CREATE ACCOUNT TITLE
        // =========================================================

        Label createTitle =
                new Label(
                        "Create your account"
                );

        createTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;"
        );

        Label createSubtitle =
                new Label(
                        "It takes less than a minute."
                );

        createSubtitle.setStyle(
                "-fx-text-fill: #A49AB8;" +
                "-fx-font-size: 12px;"
        );

        VBox heading =
                new VBox(
                        4,
                        createTitle,
                        createSubtitle
                );

        // =========================================================
        // THREE ROLE CARDS
        // =========================================================

        VBox userCard =
                createRoleCard(
                        "♙",
                        "User",
                        "Share documents securely"
                );

        VBox xeroxCard =
                createRoleCard(
                        "▥",
                        "Xerox Centre",
                        "Handle print jobs"
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

        HBox.setHgrow(
                userCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                xeroxCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                adminCard,
                Priority.ALWAYS
        );

        // =========================================================
        // DEFAULT USER
        // =========================================================

        selectedRole =
                "USER";

        selectRoleCard(
                userCard,
                xeroxCard,
                adminCard
        );

        // =========================================================
        // USER CARD CLICK
        // =========================================================

        userCard.setOnMouseClicked(e -> {

            selectedRole =
                    "USER";

            System.out.println(
                    "Selected Role: USER"
            );

            selectRoleCard(
                    userCard,
                    xeroxCard,
                    adminCard
            );
        });

        // =========================================================
        // XEROX CARD CLICK
        // =========================================================

        xeroxCard.setOnMouseClicked(e -> {

            selectedRole =
                    "XEROX";

            System.out.println(
                    "Selected Role: XEROX"
            );

            selectRoleCard(
                    xeroxCard,
                    userCard,
                    adminCard
            );
        });

        // =========================================================
        // ADMIN CARD CLICK
        // =========================================================

        adminCard.setOnMouseClicked(e -> {

            selectedRole =
                    "ADMIN";

            System.out.println(
                    "Selected Role: ADMIN"
            );

            selectRoleCard(
                    adminCard,
                    userCard,
                    xeroxCard
            );
        });

        // =========================================================
        // FULL NAME
        // =========================================================

        Label fullNameLabel =
                createInputLabel(
                        "Full name"
                );

        TextField fullNameField =
                createTextField(
                        "SUJAY MASHALKAR"
                );

        // =========================================================
        // EMAIL + MOBILE
        // =========================================================

        Label emailLabel =
                createInputLabel(
                        "Email"
                );

        TextField emailField =
                createTextField(
                        "you@example.com"
                );

        Label mobileLabel =
                createInputLabel(
                        "Mobile"
                );

        TextField mobileField =
                createTextField(
                        "+91 98765 43210"
                );

        VBox emailBox =
                new VBox(
                        7,
                        emailLabel,
                        emailField
                );

        VBox mobileBox =
                new VBox(
                        7,
                        mobileLabel,
                        mobileField
                );

        HBox emailMobileBox =
                new HBox(
                        12,
                        emailBox,
                        mobileBox
                );

        HBox.setHgrow(
                emailBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                mobileBox,
                Priority.ALWAYS
        );

        // =========================================================
        // PASSWORD + CONFIRM
        // =========================================================

        Label passwordLabel =
                createInputLabel(
                        "Password"
                );

        PasswordField passwordField =
                createPasswordField(
                        "••••••••"
                );

        Label confirmLabel =
                createInputLabel(
                        "Confirm"
                );

        PasswordField confirmField =
                createPasswordField(
                        "••••••••"
                );

        VBox passwordBox =
                new VBox(
                        7,
                        passwordLabel,
                        passwordField
                );

        VBox confirmBox =
                new VBox(
                        7,
                        confirmLabel,
                        confirmField
                );

        HBox passwordRow =
                new HBox(
                        12,
                        passwordBox,
                        confirmBox
                );

        HBox.setHgrow(
                passwordBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                confirmBox,
                Priority.ALWAYS
        );

        // =========================================================
        // REGISTER MESSAGE
        // =========================================================

        Label registerMessage =
                new Label();

        registerMessage.setStyle(
                "-fx-text-fill: #FF6B6B;" +
                "-fx-font-size: 12px;"
        );

        // =========================================================
        // CREATE ACCOUNT BUTTON
        // =========================================================

        Button createAccountButton =
                createBlueButton(
                        "Create account"
                );

        createAccountButton.setOnAction(e -> {

            String name =
                    fullNameField
                            .getText()
                            .trim();

            String email =
                    emailField
                            .getText()
                            .trim();

            String mobile =
                    mobileField
                            .getText()
                            .trim();

            String password =
                    passwordField
                            .getText();

            String confirmPassword =
                    confirmField
                            .getText();

            String role =
                    selectedRole;

            // =====================================================
            // VALIDATE EMPTY FIELDS
            // =====================================================

            if (name.isEmpty()
                    || email.isEmpty()
                    || mobile.isEmpty()
                    || password.isEmpty()
                    || confirmPassword.isEmpty()) {

                registerMessage.setText(
                        "Please fill all fields."
                );

                return;
            }

            // =====================================================
            // PASSWORD CHECK
            // =====================================================

            if (!password.equals(confirmPassword)) {

                registerMessage.setText(
                        "Passwords do not match."
                );

                return;
            }

            // =====================================================
            // REGISTER USER
            // =====================================================

            RegisterController controller =
                    new RegisterController();

            boolean flag =
                    controller.signUp(
                            name,
                            email,
                            mobile,
                            password,
                            role
                    );

            // =====================================================
            // SUCCESS
            // =====================================================

            if (flag) {

                System.out.println(
                        "Account created successfully"
                );

                System.out.println(
                        "Registered role: "
                                + role
                );

                registerMessage.setStyle(
                        "-fx-text-fill: #4ADE80;" +
                        "-fx-font-size: 12px;"
                );

                registerMessage.setText(
                        "Account created successfully."
                );

                rlp.run();

            } else {

                registerMessage.setStyle(
                        "-fx-text-fill: #FF6B6B;" +
                        "-fx-font-size: 12px;"
                );

                registerMessage.setText(
                        "Account creation failed."
                );
            }
        });

        // =========================================================
        // BOTTOM SIGN IN
        // =========================================================

        Label alreadyAccount =
                new Label(
                        "Already have an account?"
                );

        alreadyAccount.setStyle(
                "-fx-text-fill: #8F849F;" +
                "-fx-font-size: 12px;"
        );

        Button bottomSignIn =
                createLinkButton(
                        "Sign in"
                );

        bottomSignIn.setOnAction(e -> {

            rlp.run();

        });

        HBox bottomLogin =
                new HBox(
                        4,
                        alreadyAccount,
                        bottomSignIn
                );

        bottomLogin.setAlignment(
                Pos.CENTER
        );

        // =========================================================
        // ADD REGISTER CONTENT
        // =========================================================

        registerCard.getChildren().addAll(
                heading,
                roleBox,
                fullNameLabel,
                fullNameField,
                emailMobileBox,
                passwordRow,
                registerMessage,
                createAccountButton,
                bottomLogin
        );

        // =========================================================
        // ADD CARDS TO CONTENT
        // =========================================================

        content.getChildren().addAll(
                infoCard,
                registerCard
        );

        // =========================================================
        // CENTER CONTENT
        // =========================================================

        StackPane centerBox =
                new StackPane(
                        content
                );

        centerBox.setAlignment(
                Pos.TOP_CENTER
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

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setPannable(
                true
        );

        scrollPane.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;" +
                "-fx-border-color: transparent;"
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

        registerScene =
                new Scene(
                        root,
                        1300,
                        700
                );

        return registerScene;
    }

    // =============================================================
    // FEATURE LABEL
    // =============================================================

    private Label createFeature(
            String text) {

        Label label =
                new Label(
                        "⊙  " + text
                );

        label.setStyle(
                "-fx-text-fill: #D8CDED;" +
                "-fx-font-size: 12px;"
        );

        return label;
    }

    // =============================================================
    // ROLE CARD
    // =============================================================

    private VBox createRoleCard(
            String icon,
            String title,
            String description) {

        Label iconLabel =
                new Label(
                        icon
                );

        iconLabel.setStyle(
                "-fx-background-color: #251A38;" +
                "-fx-background-radius: 50%;" +
                "-fx-text-fill: #B99AEF;" +
                "-fx-padding: 8;"
        );

        Label titleLabel =
                new Label(
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

        descriptionLabel.setWrapText(
                true
        );

        descriptionLabel.setStyle(
                "-fx-text-fill: #91869F;" +
                "-fx-font-size: 10px;"
        );

        VBox card =
                new VBox(
                        7,
                        iconLabel,
                        titleLabel,
                        descriptionLabel
                );

        card.setPadding(
                new Insets(12)
        );

        card.setPrefHeight(
                100
        );

        card.setPrefWidth(
                240
        );

        card.setMaxWidth(
                Double.MAX_VALUE
        );

        // =========================================================
        // DEFAULT STYLE
        // =========================================================

        card.setStyle(
                "-fx-background-color: #17131F;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #352846;" +
                "-fx-border-radius: 18;" +
                "-fx-cursor: hand;"
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
                1.03
        );

        scaleUp.setToY(
                1.03
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
        // MOUSE ENTER
        // =========================================================

        card.setOnMouseEntered(e -> {

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

        // =========================================================
        // MOUSE EXIT
        // =========================================================

        card.setOnMouseExited(e -> {

            scaleUp.stop();

            scaleDown.playFromStart();

            if (card == getSelectedCard()) {

                card.setStyle(
                        "-fx-background-color: #241A32;" +
                        "-fx-background-radius: 18;" +
                        "-fx-border-color: #8B5CF6;" +
                        "-fx-border-radius: 18;" +
                        "-fx-effect: dropshadow(gaussian, rgba(139,92,246,0.8), 25, 0.6, 0, 5);" +
                        "-fx-cursor: hand;"
                );

            } else {

                card.setStyle(
                        "-fx-background-color: #17131F;" +
                        "-fx-background-radius: 18;" +
                        "-fx-border-color: #352846;" +
                        "-fx-border-radius: 18;" +
                        "-fx-cursor: hand;"
                );
            }
        });

        return card;
    }

    // =============================================================
    // SELECT ROLE CARD - NOW SUPPORTS 3 CARDS
    // =============================================================

    private void selectRoleCard(
            VBox selected,
            VBox other1,
            VBox other2) {

        selectedRoleCardReference =
                selected;

        // =========================================================
        // SELECTED
        // =========================================================

        selected.setStyle(
                "-fx-background-color: #241A32;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #8B5CF6;" +
                "-fx-border-radius: 18;" +
                "-fx-effect: dropshadow(gaussian, rgba(139,92,246,0.8), 25, 0.6, 0, 5);" +
                "-fx-cursor: hand;"
        );

        // =========================================================
        // OTHER 1
        // =========================================================

        other1.setStyle(
                "-fx-background-color: #17131F;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #352846;" +
                "-fx-border-radius: 18;" +
                "-fx-cursor: hand;"
        );

        // =========================================================
        // OTHER 2
        // =========================================================

        other2.setStyle(
                "-fx-background-color: #17131F;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #352846;" +
                "-fx-border-radius: 18;" +
                "-fx-cursor: hand;"
        );
    }

    // =============================================================
    // GET SELECTED CARD
    // =============================================================

    private VBox getSelectedCard() {

        return selectedRoleCardReference;
    }

    // =============================================================
    // INPUT LABEL
    // =============================================================

    private Label createInputLabel(
            String text) {

        Label label =
                new Label(
                        text
                );

        label.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        return label;
    }

    // =============================================================
    // TEXT FIELD
    // =============================================================

    private TextField createTextField(
            String prompt) {

        TextField field =
                new TextField();

        field.setPromptText(
                prompt
        );

        field.setStyle(
                "-fx-background-color: #15111F;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #3A2C50;" +
                "-fx-border-radius: 20;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #746A85;" +
                "-fx-padding: 10 15 10 15;"
        );

        return field;
    }

    // =============================================================
    // PASSWORD FIELD
    // =============================================================

    private PasswordField createPasswordField(
            String prompt) {

        PasswordField field =
                new PasswordField();

        field.setPromptText(
                prompt
        );

        field.setStyle(
                "-fx-background-color: #15111F;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #3A2C50;" +
                "-fx-border-radius: 20;" +
                "-fx-text-fill: white;" +
                "-fx-prompt-text-fill: #746A85;" +
                "-fx-padding: 10 15 10 15;"
        );

        return field;
    }

    // =============================================================
    // PURPLE BUTTON
    // =============================================================

    private Button createBlueButton(
            String text) {

        Button button =
                new Button(
                        text
                );

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

        scaleUp.setToX(
                1.03
        );

        scaleUp.setToY(
                1.03
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

    // =============================================================
    // SIMPLE BUTTON
    // =============================================================

    private Button createSimpleButton(
            String text) {

        Button button =
                new Button(
                        text
                );

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

    // =============================================================
    // LINK BUTTON
    // =============================================================

    private Button createLinkButton(
            String text) {

        Button button =
                new Button(
                        text
                );

        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: #9D91AD;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 0;" +
                "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e -> {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: #B78CFF;" +
                    "-fx-font-size: 12px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 0;" +
                    "-fx-cursor: hand;"
            );
        });

        button.setOnMouseExited(e -> {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: #9D91AD;" +
                    "-fx-font-size: 12px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 0;" +
                    "-fx-cursor: hand;"
            );
        });

        return button;
    }
}

