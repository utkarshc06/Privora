package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Settings {

    private BorderPane root;

    // ==============================
    // PURPLE THEME
    // ==============================

    private static final String BG = "#0B0714";
    private static final String CARD = "#151022";
    private static final String BORDER = "#2A2140";
    private static final String TEXT = "#F5F3FF";
    private static final String MUTED = "#A9A0C2";
    private static final String PURPLE = "#8B5CF6";

    public Settings() {
        createUI();
    }

    // ==============================
    // MAIN UI
    // ==============================

    private void createUI() {

        root = new BorderPane();

        root.setStyle(
                "-fx-background-color: " + BG + ";"
        );

        VBox main = new VBox(22);

        main.setPadding(
                new Insets(35)
        );

        // ==============================
        // HEADER
        // ==============================

        Label title = new Label("Settings");

        title.setStyle(
                "-fx-font-size: 34px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: " + TEXT + ";"
        );

        Label subtitle = new Label(
                "Manage your centre's profile and preferences."
        );

        subtitle.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-text-fill: " + MUTED + ";"
        );

        VBox header = new VBox(5);

        header.getChildren().addAll(
                title,
                subtitle
        );

        // ==============================
        // TWO COLUMN LAYOUT
        // ==============================

        HBox columns = new HBox(28);

        VBox profileCard = createProfileCard();
        VBox preferenceCard = createPreferenceCard();

        HBox.setHgrow(
                profileCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                preferenceCard,
                Priority.ALWAYS
        );

        columns.getChildren().addAll(
                profileCard,
                preferenceCard
        );

        // ==============================
        // ADD TO MAIN
        // ==============================

        main.getChildren().addAll(
                header,
                columns
        );

        root.setCenter(main);
    }

    // =========================================================
    // LEFT COLUMN - CENTRE PROFILE
    // =========================================================

    private VBox createProfileCard() {

        VBox card = createCard();

        Label heading = new Label(
                "Centre profile"
        );

        heading.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: " + TEXT + ";"
        );

        VBox headingBox = new VBox(
                heading
        );

        headingBox.setPadding(
                new Insets(22, 28, 22, 28)
        );

        VBox fields = new VBox(18);

        fields.setPadding(
                new Insets(25, 28, 28, 28)
        );

        // ------------------------------
        // Centre name
        // ------------------------------

        VBox centreName =
                createTextField(
                        "Centre name"
                );

        // ------------------------------
        // Address
        // ------------------------------

        VBox address =
                createTextField(
                        "Address"
                );

        // ------------------------------
        // Phone + Email
        // ------------------------------

        HBox contactRow =
                new HBox(18);

        VBox phone =
                createTextField(
                        "Phone"
                );

        VBox email =
                createTextField(
                        "Email"
                );

        HBox.setHgrow(
                phone,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                email,
                Priority.ALWAYS
        );

        contactRow.getChildren().addAll(
                phone,
                email
        );

        // ------------------------------
        // Fields
        // ------------------------------

        fields.getChildren().addAll(
                centreName,
                address,
                contactRow
        );

        card.getChildren().addAll(
                headingBox,
                createDivider(),
                fields
        );

        return card;
    }

    // =========================================================
    // RIGHT COLUMN - OPERATIONAL
    // =========================================================

    private VBox createPreferenceCard() {

        VBox card = createCard();

        Label heading = new Label(
                "Operational preferences"
        );

        heading.setStyle(
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: " + TEXT + ";"
        );

        VBox headingBox = new VBox(
                heading
        );

        headingBox.setPadding(
                new Insets(22, 28, 22, 28)
        );

        VBox preferences =
                new VBox();

        preferences.setPadding(
                new Insets(25, 28, 25, 28)
        );

        // ------------------------------
        // Preference 1
        // ------------------------------

        HBox preference1 =
                createPreference(
                        "Auto-accept low-risk jobs",
                        "Skip manual accept for eligible jobs"
                );

        // ------------------------------
        // Preference 2
        // ------------------------------

        HBox preference2 =
                createPreference(
                        "Require staff PIN before print",
                        "Extra verification before printing"
                );

        // ------------------------------
        // Preference 3
        // ------------------------------

        HBox preference3 =
                createPreference(
                        "Send notification on completion",
                        "Notify when the job is completed"
                );

        preferences.getChildren().addAll(
                preference1,
                createDivider(),
                preference2,
                createDivider(),
                preference3
        );

        card.getChildren().addAll(
                headingBox,
                createDivider(),
                preferences
        );

        return card;
    }

    // =========================================================
    // TEXT FIELD
    // =========================================================

    private VBox createTextField(
            String fieldName
    ) {

        VBox box = new VBox(7);

        Label label =
                new Label(fieldName);

        label.setStyle(
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: " + TEXT + ";"
        );

        TextField field =
                new TextField();

        field.setPromptText(
                fieldName
        );

        field.setPrefHeight(52);

        field.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-width: 1px;" +
                "-fx-border-radius: 25px;" +
                "-fx-background-radius: 25px;" +
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-prompt-text-fill: " + MUTED + ";" +
                "-fx-padding: 0 16px;"
        );

        box.getChildren().addAll(
                label,
                field
        );

        VBox.setVgrow(
                field,
                Priority.NEVER
        );

        return box;
    }

    // =========================================================
    // PREFERENCE ROW
    // =========================================================

    private HBox createPreference(
            String titleText,
            String descriptionText
    ) {

        HBox row = new HBox();

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(14, 0, 14, 0)
        );

        VBox textBox =
                new VBox(5);

        Label title =
                new Label(titleText);

        title.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: " + TEXT + ";"
        );

        Label description =
                new Label(descriptionText);

        description.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-text-fill: " + MUTED + ";"
        );

        textBox.getChildren().addAll(
                title,
                description
        );

        HBox.setHgrow(
                textBox,
                Priority.ALWAYS
        );

        // Toggle only for UI structure.
        // Actual value can later come from Firebase.

        ToggleButton toggle =
                new ToggleButton();

        toggle.setPrefSize(
                48,
                26
        );

        toggle.setStyle(
                "-fx-background-color: " + BORDER + ";" +
                "-fx-background-radius: 20px;" +
                "-fx-border-color: transparent;"
        );

        row.getChildren().addAll(
                textBox,
                toggle
        );

        return row;
    }

    // =========================================================
    // CARD
    // =========================================================

    private VBox createCard() {

        VBox card = new VBox();

        card.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-background-radius: 20px;" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 20px;"
        );

        return card;
    }

    // =========================================================
    // DIVIDER
    // =========================================================

    private HBox createDivider() {

        HBox divider = new HBox();

        divider.setPrefHeight(1);

        divider.setStyle(
                "-fx-background-color: " + BORDER + ";"
        );

        return divider;
    }

    // =========================================================
    // GET CONTENT
    // =========================================================

    public BorderPane getContent() {
        return root;
    }
}