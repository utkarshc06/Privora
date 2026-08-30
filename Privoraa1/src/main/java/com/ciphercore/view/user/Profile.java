package com.ciphercore.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Profile {

    // =========================================================
    // COLORS
    // =========================================================

    private final String BACKGROUND = "#0B0A0F";
    private final String CARD = "#111722";
    private final String BORDER = "#252B3A";

    private final String PURPLE = "#6D28D9";
    private final String PURPLE_LIGHT = "#8B5CF6";

    private final String TEXT = "#F5F3FF";
    private final String SECONDARY = "#A8A0B8";

    private final String INPUT = "#101620";


    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public VBox getContent() {

        // =====================================================
        // MAIN CONTAINER
        // =====================================================

        VBox content = new VBox(25);

        content.setPadding(
                new Insets(35, 40, 50, 40)
        );

        content.setStyle(
                "-fx-background-color: " + BACKGROUND + ";"
        );


        // =====================================================
        // PAGE TITLE
        // =====================================================

        Label title = new Label(
                "My profile"
        );

        title.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;"
        );


        Label subtitle = new Label(
                "Manage your personal information and security."
        );

        subtitle.setStyle(
                "-fx-text-fill: " + SECONDARY + ";" +
                "-fx-font-size: 16px;"
        );


        VBox heading = new VBox(5);

        heading.getChildren().addAll(
                title,
                subtitle
        );


        // =====================================================
        // PROFILE CARD
        // =====================================================

        VBox profileCard = createProfileCard();


        // =====================================================
        // PERSONAL INFORMATION
        // =====================================================

        VBox personalCard = createPersonalInformation();


        // =====================================================
        // SECURITY
        // =====================================================

        VBox securityCard = createSecurityCard();


        // =====================================================
        // ADD ALL
        // =====================================================

        content.getChildren().addAll(
                heading,
                profileCard,
                personalCard,
                securityCard
        );


        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane = new ScrollPane();

        scrollPane.setContent(content);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle("""
                -fx-background-color: #0B0A0F;
                -fx-background: #0B0A0F;
                -fx-border-color: transparent;
                """);


        // =====================================================
        // REMOVE DEFAULT SCROLLPANE PADDING
        // =====================================================

        BorderPane root = new BorderPane();

        root.setCenter(scrollPane);

        root.setStyle(
                "-fx-background-color: " + BACKGROUND + ";"
        );


        // =====================================================
        // RETURN CONTENT
        // =====================================================

        VBox finalContent = new VBox();

        finalContent.getChildren().add(root);

        VBox.setVgrow(
                root,
                javafx.scene.layout.Priority.ALWAYS
        );


        return finalContent;
    }


    // =========================================================
    // PROFILE CARD
    // =========================================================

    private VBox createProfileCard() {

        VBox card = new VBox(15);

        card.setPadding(
                new Insets(28)
        );

        card.setAlignment(
                Pos.CENTER
        );

        card.setStyle("""
                -fx-background-color: #111722;
                -fx-border-color: #252B3A;
                -fx-border-width: 1;
                -fx-border-radius: 22;
                -fx-background-radius: 22;
                """);


        // =====================================================
        // PROFILE CIRCLE
        // =====================================================

        Circle profileCircle = new Circle(58);

        profileCircle.setFill(
                Color.web("#6D28D9")
        );


        Label initials = new Label(
                "AS"
        );

        initials.setStyle("""
                -fx-text-fill: white;
                -fx-font-size: 30px;
                -fx-font-weight: bold;
                """);


        StackPane avatar = new StackPane();

        avatar.setPrefSize(
                116,
                116
        );

        avatar.getChildren().addAll(
                profileCircle,
                initials
        );


        // =====================================================
        // NAME
        // =====================================================

        Label name = new Label(
                "Aditi Sharma"
        );

        name.setStyle("""
                -fx-text-fill: #F5F3FF;
                -fx-font-size: 22px;
                -fx-font-weight: bold;
                """);


        // =====================================================
        // EMAIL
        // =====================================================

        Label email = new Label(
                "aditi@privora.app"
        );

        email.setStyle("""
                -fx-text-fill: #8E98A8;
                -fx-font-size: 14px;
                """);


        // =====================================================
        // STATUS
        // =====================================================

        Label status = new Label(
                "●  Active"
        );

        status.setStyle("""
                -fx-background-color: rgba(16,185,129,0.18);
                -fx-background-radius: 15;
                -fx-text-fill: #34D399;
                -fx-font-size: 13px;
                -fx-font-weight: bold;
                -fx-padding: 6 13 6 13;
                """);


        // =====================================================
        // CHANGE PICTURE BUTTON
        // =====================================================

        Button changePicture = new Button(
                "Change picture"
        );

        changePicture.setMaxWidth(
                Double.MAX_VALUE
        );

        changePicture.setPrefHeight(38);

        changePicture.setStyle("""
                -fx-background-color: #080B12;
                -fx-border-color: #252B3A;
                -fx-border-width: 1;
                -fx-border-radius: 12;
                -fx-background-radius: 12;
                -fx-text-fill: #D8D2E2;
                -fx-font-size: 14px;
                -fx-font-weight: bold;
                -fx-cursor: hand;
                """);


        changePicture.setOnMouseEntered(e -> {

            changePicture.setStyle("""
                    -fx-background-color: #211A2E;
                    -fx-border-color: #6D28D9;
                    -fx-border-width: 1;
                    -fx-border-radius: 12;
                    -fx-background-radius: 12;
                    -fx-text-fill: white;
                    -fx-font-size: 14px;
                    -fx-font-weight: bold;
                    -fx-cursor: hand;
                    """);

        });


        changePicture.setOnMouseExited(e -> {

            changePicture.setStyle("""
                    -fx-background-color: #080B12;
                    -fx-border-color: #252B3A;
                    -fx-border-width: 1;
                    -fx-border-radius: 12;
                    -fx-background-radius: 12;
                    -fx-text-fill: #D8D2E2;
                    -fx-font-size: 14px;
                    -fx-font-weight: bold;
                    -fx-cursor: hand;
                    """);

        });


        // =====================================================
        // ADD PROFILE COMPONENTS
        // =====================================================

        card.getChildren().addAll(
                avatar,
                name,
                email,
                status,
                changePicture
        );


        return card;
    }


    // =========================================================
    // PERSONAL INFORMATION
    // =========================================================

    private VBox createPersonalInformation() {

        VBox card = createCard();


        // =====================================================
        // TITLE
        // =====================================================

        Label title = new Label(
                "Personal information"
        );

        title.setStyle("""
                -fx-text-fill: #F5F3FF;
                -fx-font-size: 19px;
                -fx-font-weight: bold;
                """);


        // =====================================================
        // GRID
        // =====================================================

        GridPane grid = new GridPane();

        grid.setHgap(20);
        grid.setVgap(10);


        // =====================================================
        // NAME
        // =====================================================

        Label nameLabel = createFieldLabel(
                "Full name"
        );

        TextField nameField = createTextField(
                "Aditi Sharma"
        );


        // =====================================================
        // EMAIL
        // =====================================================

        Label emailLabel = createFieldLabel(
                "Email"
        );

        TextField emailField = createTextField(
                "aditi@privora.app"
        );


        // =====================================================
        // MOBILE
        // =====================================================

        Label mobileLabel = createFieldLabel(
                "Mobile"
        );

        TextField mobileField = createTextField(
                "+91 98765 43210"
        );


        // =====================================================
        // CITY
        // =====================================================

        Label cityLabel = createFieldLabel(
                "City"
        );

        TextField cityField = createTextField(
                "Pune"
        );


        // =====================================================
        // COLUMN 1
        // =====================================================

        VBox nameBox = new VBox(7);

        nameBox.getChildren().addAll(
                nameLabel,
                nameField
        );


        VBox mobileBox = new VBox(7);

        mobileBox.getChildren().addAll(
                mobileLabel,
                mobileField
        );


        // =====================================================
        // COLUMN 2
        // =====================================================

        VBox emailBox = new VBox(7);

        emailBox.getChildren().addAll(
                emailLabel,
                emailField
        );


        VBox cityBox = new VBox(7);

        cityBox.getChildren().addAll(
                cityLabel,
                cityField
        );


        grid.add(
                nameBox,
                0,
                0
        );

        grid.add(
                emailBox,
                1,
                0
        );

        grid.add(
                mobileBox,
                0,
                1
        );

        grid.add(
                cityBox,
                1,
                1
        );


        // =====================================================
        // UPDATE BUTTON
        // =====================================================

        Button updateButton = createPurpleButton(
                "Update profile"
        );


        updateButton.setOnAction(e -> {

            System.out.println(
                    "Profile updated"
            );

        });


        // =====================================================
        // ADD
        // =====================================================

        card.getChildren().addAll(
                title,
                grid,
                updateButton
        );


        return card;
    }


    // =========================================================
    // SECURITY
    // =========================================================

    private VBox createSecurityCard() {

        VBox card = createCard();


        // =====================================================
        // TITLE
        // =====================================================

        Label title = new Label(
                "Security"
        );

        title.setStyle("""
                -fx-text-fill: #F5F3FF;
                -fx-font-size: 19px;
                -fx-font-weight: bold;
                """);


        // =====================================================
        // CURRENT PASSWORD
        // =====================================================

        Label currentLabel = createFieldLabel(
                "Current password"
        );

        PasswordField currentPassword =
                createPasswordField();

        currentPassword.setText(
                "password"
        );


        // =====================================================
        // NEW PASSWORD
        // =====================================================

        Label newLabel = createFieldLabel(
                "New password"
        );

        PasswordField newPassword =
                createPasswordField();


        // =====================================================
        // CONFIRM PASSWORD
        // =====================================================

        Label confirmLabel = createFieldLabel(
                "Confirm new password"
        );

        PasswordField confirmPassword =
                createPasswordField();


        // =====================================================
        // CURRENT PASSWORD BOX
        // =====================================================

        VBox currentBox = new VBox(7);

        currentBox.getChildren().addAll(
                currentLabel,
                currentPassword
        );


        // =====================================================
        // NEW PASSWORD BOX
        // =====================================================

        VBox newBox = new VBox(7);

        newBox.getChildren().addAll(
                newLabel,
                newPassword
        );


        // =====================================================
        // CONFIRM PASSWORD BOX
        // =====================================================

        VBox confirmBox = new VBox(7);

        confirmBox.getChildren().addAll(
                confirmLabel,
                confirmPassword
        );


        // =====================================================
        // PASSWORD GRID
        // =====================================================

        GridPane passwordGrid =
                new GridPane();

        passwordGrid.setHgap(20);
        passwordGrid.setVgap(20);


        passwordGrid.add(
                currentBox,
                0,
                0,
                2,
                1
        );

        passwordGrid.add(
                newBox,
                0,
                1
        );

        passwordGrid.add(
                confirmBox,
                1,
                1
        );


        // =====================================================
        // CHANGE PASSWORD BUTTON
        // =====================================================

        Button changePassword =
                new Button(
                        "Change password"
                );

        changePassword.setPrefHeight(42);

        changePassword.setStyle("""
                -fx-background-color: #080B12;
                -fx-border-color: #252B3A;
                -fx-border-width: 1;
                -fx-border-radius: 12;
                -fx-background-radius: 12;
                -fx-text-fill: #F5F3FF;
                -fx-font-size: 14px;
                -fx-font-weight: bold;
                -fx-cursor: hand;
                """);


        changePassword.setOnMouseEntered(e -> {

            changePassword.setStyle("""
                    -fx-background-color: #211A2E;
                    -fx-border-color: #6D28D9;
                    -fx-border-width: 1;
                    -fx-border-radius: 12;
                    -fx-background-radius: 12;
                    -fx-text-fill: white;
                    -fx-font-size: 14px;
                    -fx-font-weight: bold;
                    -fx-cursor: hand;
                    """);

        });


        changePassword.setOnMouseExited(e -> {

            changePassword.setStyle("""
                    -fx-background-color: #080B12;
                    -fx-border-color: #252B3A;
                    -fx-border-width: 1;
                    -fx-border-radius: 12;
                    -fx-background-radius: 12;
                    -fx-text-fill: #F5F3FF;
                    -fx-font-size: 14px;
                    -fx-font-weight: bold;
                    -fx-cursor: hand;
                    """);

        });


        changePassword.setOnAction(e -> {

            if (!newPassword.getText().equals(
                    confirmPassword.getText()
            )) {

                System.out.println(
                        "Passwords do not match"
                );

                return;
            }


            System.out.println(
                    "Password changed"
            );

        });


        // =====================================================
        // ADD
        // =====================================================

        card.getChildren().addAll(
                title,
                passwordGrid,
                changePassword
        );


        return card;
    }


    // =========================================================
    // CREATE CARD
    // =========================================================

    private VBox createCard() {

        VBox card = new VBox(20);

        card.setPadding(
                new Insets(25, 28, 28, 28)
        );

        card.setStyle("""
                -fx-background-color: #111722;
                -fx-border-color: #252B3A;
                -fx-border-width: 1;
                -fx-border-radius: 22;
                -fx-background-radius: 22;
                """);

        return card;
    }


    // =========================================================
    // FIELD LABEL
    // =========================================================

    private Label createFieldLabel(
            String text) {

        Label label = new Label(
                text
        );

        label.setStyle("""
                -fx-text-fill: #D8D2E2;
                -fx-font-size: 14px;
                -fx-font-weight: bold;
                """);

        return label;
    }


    // =========================================================
    // TEXT FIELD
    // =========================================================

    private TextField createTextField(
            String value) {

        TextField field =
                new TextField(value);

        field.setPrefHeight(48);

        field.setStyle("""
                -fx-background-color: #101620;
                -fx-border-color: #252B3A;
                -fx-border-width: 1;
                -fx-border-radius: 14;
                -fx-background-radius: 14;
                -fx-text-fill: #F5F3FF;
                -fx-font-size: 14px;
                -fx-padding: 0 15 0 15;
                """);


        field.setOnMouseEntered(e -> {

            field.setStyle("""
                    -fx-background-color: #101620;
                    -fx-border-color: #6D28D9;
                    -fx-border-width: 1;
                    -fx-border-radius: 14;
                    -fx-background-radius: 14;
                    -fx-text-fill: #F5F3FF;
                    -fx-font-size: 14px;
                    -fx-padding: 0 15 0 15;
                    """);

        });


        field.setOnMouseExited(e -> {

            if (!field.isFocused()) {

                field.setStyle("""
                        -fx-background-color: #101620;
                        -fx-border-color: #252B3A;
                        -fx-border-width: 1;
                        -fx-border-radius: 14;
                        -fx-background-radius: 14;
                        -fx-text-fill: #F5F3FF;
                        -fx-font-size: 14px;
                        -fx-padding: 0 15 0 15;
                        """);
            }

        });


        field.focusedProperty().addListener(
                (obs, oldValue, newValue) -> {

                    if (newValue) {

                        field.setStyle("""
                                -fx-background-color: #101620;
                                -fx-border-color: #8B5CF6;
                                -fx-border-width: 2;
                                -fx-border-radius: 14;
                                -fx-background-radius: 14;
                                -fx-text-fill: #F5F3FF;
                                -fx-font-size: 14px;
                                -fx-padding: 0 15 0 15;
                                """);

                    } else {

                        field.setStyle("""
                                -fx-background-color: #101620;
                                -fx-border-color: #252B3A;
                                -fx-border-width: 1;
                                -fx-border-radius: 14;
                                -fx-background-radius: 14;
                                -fx-text-fill: #F5F3FF;
                                -fx-font-size: 14px;
                                -fx-padding: 0 15 0 15;
                                """);
                    }

                }
        );


        return field;
    }


    // =========================================================
    // PASSWORD FIELD
    // =========================================================

    private PasswordField createPasswordField() {

        PasswordField field =
                new PasswordField();

        field.setPrefHeight(48);

        field.setStyle("""
                -fx-background-color: #101620;
                -fx-border-color: #252B3A;
                -fx-border-width: 1;
                -fx-border-radius: 14;
                -fx-background-radius: 14;
                -fx-text-fill: #F5F3FF;
                -fx-font-size: 14px;
                -fx-padding: 0 15 0 15;
                """);


        field.focusedProperty().addListener(
                (obs, oldValue, newValue) -> {

                    if (newValue) {

                        field.setStyle("""
                                -fx-background-color: #101620;
                                -fx-border-color: #8B5CF6;
                                -fx-border-width: 2;
                                -fx-border-radius: 14;
                                -fx-background-radius: 14;
                                -fx-text-fill: #F5F3FF;
                                -fx-font-size: 14px;
                                -fx-padding: 0 15 0 15;
                                """);

                    } else {

                        field.setStyle("""
                                -fx-background-color: #101620;
                                -fx-border-color: #252B3A;
                                -fx-border-width: 1;
                                -fx-border-radius: 14;
                                -fx-background-radius: 14;
                                -fx-text-fill: #F5F3FF;
                                -fx-font-size: 14px;
                                -fx-padding: 0 15 0 15;
                                """);
                    }

                }
        );


        return field;
    }


    // =========================================================
    // PURPLE BUTTON
    // =========================================================

    private Button createPurpleButton(
            String text) {

        Button button = new Button(
                text
        );

        button.setPrefHeight(45);
        button.setPrefWidth(145);

        button.setStyle("""
                -fx-background-color:
                    linear-gradient(
                        to right,
                        #6D28D9,
                        #8B5CF6
                    );
                -fx-background-radius: 13;
                -fx-text-fill: white;
                -fx-font-size: 14px;
                -fx-font-weight: bold;
                -fx-cursor: hand;
                """);


        button.setOnMouseEntered(e -> {

            button.setStyle("""
                    -fx-background-color:
                        linear-gradient(
                            to right,
                            #7C3AED,
                            #A78BFA
                        );
                    -fx-background-radius: 13;
                    -fx-text-fill: white;
                    -fx-font-size: 14px;
                    -fx-font-weight: bold;
                    -fx-cursor: hand;
                    -fx-effect: dropshadow(
                        gaussian,
                        rgba(139,92,246,0.45),
                        18,
                        0.4,
                        0,
                        4
                    );
                    """);

            button.setScaleX(1.03);
            button.setScaleY(1.03);

        });


        button.setOnMouseExited(e -> {

            button.setStyle("""
                    -fx-background-color:
                        linear-gradient(
                            to right,
                            #6D28D9,
                            #8B5CF6
                        );
                    -fx-background-radius: 13;
                    -fx-text-fill: white;
                    -fx-font-size: 14px;
                    -fx-font-weight: bold;
                    -fx-cursor: hand;
                    """);

            button.setScaleX(1);
            button.setScaleY(1);

        });


        return button;
    }
}