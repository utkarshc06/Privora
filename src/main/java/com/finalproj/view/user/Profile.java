package com.finalproj.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Profile {

    private Scene profileScene;

    // =========================================================
    // PROFILE SCENE
    // =========================================================

    public Scene getProfileScene(Runnable backToDashboard) {

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #020713, #06152D, #020713);"
        );

        // =====================================================
        // TOP SECTION
        // =====================================================

        VBox topSection = new VBox(5);

        topSection.setPadding(
                new Insets(30, 35, 10, 35)
        );

        Label heading =
                new Label("Profile");

        heading.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );

        Label description =
                new Label(
                        "Manage your PRIVORA account information."
                );

        description.setStyle(
                "-fx-text-fill: #8291A7;" +
                "-fx-font-size: 13px;"
        );

        topSection.getChildren().addAll(
                heading,
                description
        );

        // =====================================================
        // PROFILE CARD
        // =====================================================

        VBox profileCard =
                new VBox(20);

        profileCard.setPadding(
                new Insets(30)
        );

        profileCard.setMaxWidth(700);

        profileCard.setStyle(
                "-fx-background-color: #091428;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: #1C304A;" +
                "-fx-border-radius: 18;"
        );

        // =====================================================
        // PROFILE HEADER
        // =====================================================

        Label profileIcon =
                new Label("U");

        profileIcon.setAlignment(
                Pos.CENTER
        );

        profileIcon.setStyle(
                "-fx-background-color: #1767C9;" +
                "-fx-background-radius: 50%;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-min-width: 65px;" +
                "-fx-min-height: 65px;"
        );

        VBox profileName =
                new VBox(4);

        Label name =
                new Label("User");

        name.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );

        Label role =
                new Label("Document Owner");

        role.setStyle(
                "-fx-text-fill: #71829A;" +
                "-fx-font-size: 12px;"
        );

        profileName.getChildren().addAll(
                name,
                role
        );

        HBox profileHeader =
                new HBox(
                        18,
                        profileIcon,
                        profileName
                );

        profileHeader.setAlignment(
                Pos.CENTER_LEFT
        );

        // =====================================================
        // SEPARATOR
        // =====================================================

        Separator separator =
                new Separator();

        separator.setStyle(
                "-fx-background-color: #1C304A;"
        );

        // =====================================================
        // ACCOUNT INFORMATION
        // =====================================================

        Label accountTitle =
                new Label("Account Information");

        accountTitle.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );

        // NAME

        Label nameTitle =
                new Label("Full Name");

        nameTitle.setStyle(
                "-fx-text-fill: #71829A;" +
                "-fx-font-size: 11px;"
        );

        Label nameValue =
                new Label("User");

        nameValue.setStyle(
                "-fx-text-fill: #D9E2EF;" +
                "-fx-font-size: 13px;"
        );

        VBox nameBox =
                new VBox(
                        5,
                        nameTitle,
                        nameValue
                );

        // EMAIL

        Label emailTitle =
                new Label("Email Address");

        emailTitle.setStyle(
                "-fx-text-fill: #71829A;" +
                "-fx-font-size: 11px;"
        );

        Label emailValue =
                new Label("user@privora.app");

        emailValue.setStyle(
                "-fx-text-fill: #D9E2EF;" +
                "-fx-font-size: 13px;"
        );

        VBox emailBox =
                new VBox(
                        5,
                        emailTitle,
                        emailValue
                );

        // ROLE

        Label roleTitle =
                new Label("Account Role");

        roleTitle.setStyle(
                "-fx-text-fill: #71829A;" +
                "-fx-font-size: 11px;"
        );

        Label roleValue =
                new Label("Document Owner");

        roleValue.setStyle(
                "-fx-text-fill: #D9E2EF;" +
                "-fx-font-size: 13px;"
        );

        VBox roleBox =
                new VBox(
                        5,
                        roleTitle,
                        roleValue
                );

        // STATUS

        Label statusTitle =
                new Label("Account Status");

        statusTitle.setStyle(
                "-fx-text-fill: #71829A;" +
                "-fx-font-size: 11px;"
        );

        Label statusValue =
                new Label("● Active");

        statusValue.setStyle(
                "-fx-text-fill: #19D6A3;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        VBox statusBox =
                new VBox(
                        5,
                        statusTitle,
                        statusValue
                );

        // =====================================================
        // INFORMATION CONTAINER
        // =====================================================

        VBox information =
                new VBox(
                        18,
                        nameBox,
                        emailBox,
                        roleBox,
                        statusBox
                );

        // =====================================================
        // BACK BUTTON
        // =====================================================

        Button backButton =
                new Button("←  Back to Dashboard");

        backButton.setStyle(
                "-fx-background-color: #1767C9;" +
                "-fx-background-radius: 10;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 18 10 18;"
        );

        backButton.setOnMouseEntered(e -> {

            backButton.setStyle(
                    "-fx-background-color: #2186F3;" +
                    "-fx-background-radius: 10;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 13px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 10 18 10 18;"
            );
        });

        backButton.setOnMouseExited(e -> {

            backButton.setStyle(
                    "-fx-background-color: #1767C9;" +
                    "-fx-background-radius: 10;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 13px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 10 18 10 18;"
            );
        });

        backButton.setOnAction(e -> {

            System.out.println(
                    "Back to Dashboard clicked"
            );

            backToDashboard.run();
        });

        // =====================================================
        // ADD EVERYTHING TO PROFILE CARD
        // =====================================================

        profileCard.getChildren().addAll(
                profileHeader,
                separator,
                accountTitle,
                information,
                backButton
        );

        // =====================================================
        // CENTER AREA
        // =====================================================

        VBox centerContent =
                new VBox(
                        20,
                        profileCard
                );

        centerContent.setPadding(
                new Insets(15, 35, 35, 35)
        );

        centerContent.setAlignment(
                Pos.TOP_LEFT
        );

        // =====================================================
        // ROOT
        // =====================================================

        root.setTop(topSection);
        root.setCenter(centerContent);

        // =====================================================
        // SCENE
        // =====================================================

        profileScene =
                new Scene(
                        root,
                        1100,
                        600
                );

        return profileScene;
    }
}