package com.ciphercore.view.admin;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Users {

    // =========================================================
    // COLORS - SAME PRIVORA USER THEME
    // =========================================================

    private final String BACKGROUND = "#0B0A0F";
    private final String CARD = "#111722";
    private final String CARD_HOVER = "#171426";
    private final String BORDER = "#262137";

    private final String PURPLE = "#8B5CF6";
    private final String DEEP_PURPLE = "#6D28D9";
    private final String LIGHT_PURPLE = "#A78BFA";

    private final String TEXT = "#F5F3FF";
    private final String SECONDARY = "#9E94AD";

    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public ScrollPane getContent() {

        VBox main = new VBox(24);

        main.setPadding(
                new Insets(35, 40, 40, 40)
        );

        main.setStyle(
                "-fx-background-color: " + BACKGROUND + ";"
        );

        // =====================================================
        // HEADER
        // =====================================================

        Label title = new Label(
                "User management"
        );

        title.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Add, edit or suspend accounts across all roles."
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
        // MAIN CARD
        // =====================================================

        VBox userCard = new VBox(18);

        userCard.setPadding(
                new Insets(25, 25, 20, 25)
        );

        userCard.setMaxWidth(
                Double.MAX_VALUE
        );

        userCard.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-width: 1;" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;"
        );

        // =====================================================
        // SEARCH BAR
        // =====================================================

        HBox searchRow = new HBox(12);

        searchRow.setAlignment(
                Pos.CENTER_LEFT
        );

        TextField searchField = new TextField();

        searchField.setPromptText(
                "Search users by name or email..."
        );

        searchField.setStyle(
                "-fx-background-color: #171D2B;" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #302A43;" +
                "-fx-border-radius: 22;" +
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-prompt-text-fill: #777084;" +
                "-fx-font-size: 13px;" +
                "-fx-padding: 11 18 11 18;"
        );

        HBox.setHgrow(
                searchField,
                Priority.ALWAYS
        );

        // =====================================================
        // FILTER BUTTON
        // =====================================================

        Button filterButton = new Button(
                "☰   Filter"
        );

        filterButton.setStyle(
                "-fx-background-color: #17131F;" +
                "-fx-border-color: #39304D;" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;" +
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 12px;" +
                "-fx-padding: 10 18 10 18;" +
                "-fx-cursor: hand;"
        );

        filterButton.setOnMouseEntered(e -> {

            filterButton.setStyle(
                    "-fx-background-color: #241A32;" +
                    "-fx-border-color: " + PURPLE + ";" +
                    "-fx-border-radius: 20;" +
                    "-fx-background-radius: 20;" +
                    "-fx-text-fill: " + LIGHT_PURPLE + ";" +
                    "-fx-font-size: 12px;" +
                    "-fx-padding: 10 18 10 18;" +
                    "-fx-cursor: hand;"
            );
        });

        filterButton.setOnMouseExited(e -> {

            filterButton.setStyle(
                    "-fx-background-color: #17131F;" +
                    "-fx-border-color: #39304D;" +
                    "-fx-border-radius: 20;" +
                    "-fx-background-radius: 20;" +
                    "-fx-text-fill: " + TEXT + ";" +
                    "-fx-font-size: 12px;" +
                    "-fx-padding: 10 18 10 18;" +
                    "-fx-cursor: hand;"
            );
        });

        // =====================================================
        // ADD BUTTON
        // =====================================================

        Button addButton = new Button(
                "+   Add"
        );

        addButton.setStyle(
                "-fx-background-color: linear-gradient(to right, "
                        + PURPLE + ", " + DEEP_PURPLE + ");" +
                "-fx-background-radius: 22;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 10 20 10 20;" +
                "-fx-cursor: hand;"
        );

        addButton.setOnAction(e -> showMessage(
                "Add User",
                "User creation will be connected to Firebase later."
        ));

        searchRow.getChildren().addAll(
                searchField,
                filterButton,
                addButton
        );

        // =====================================================
        // COLUMN HEADERS
        // =====================================================

        HBox headerRow = new HBox();

        headerRow.setPadding(
                new Insets(8, 15, 8, 15)
        );

        Label nameHeader = createHeader(
                "NAME"
        );

        Label emailHeader = createHeader(
                "EMAIL"
        );

        Label roleHeader = createHeader(
                "ROLE"
        );

        Label statusHeader = createHeader(
                "STATUS"
        );

        Label actionsHeader = createHeader(
                "ACTIONS"
        );

        nameHeader.setPrefWidth(190);
        emailHeader.setPrefWidth(220);
        roleHeader.setPrefWidth(110);
        statusHeader.setPrefWidth(130);
        actionsHeader.setPrefWidth(180);

        headerRow.getChildren().addAll(
                nameHeader,
                emailHeader,
                roleHeader,
                statusHeader,
                actionsHeader
        );

        // =====================================================
        // SEPARATOR
        // =====================================================

        HBox separator = new HBox();

        separator.setPrefHeight(1);

        separator.setStyle(
                "-fx-background-color: " + BORDER + ";"
        );

        // =====================================================
        // USERS
        // =====================================================

        VBox usersList = new VBox();

        usersList.setSpacing(0);

        usersList.getChildren().addAll(

                createUserRow(
                        "AS",
                        "Aditi Sharma",
                        "aditi@privora.app",
                        "User",
                        "Active"
                ),

                createUserRow(
                        "RV",
                        "Rahul Verma",
                        "rahul@privora.app",
                        "User",
                        "Active"
                ),

                createUserRow(
                        "SX",
                        "Sharma Xerox",
                        "hello@sharmaxerox.in",
                        "Centre",
                        "Active"
                ),

                createUserRow(
                        "Q",
                        "QuickPrint",
                        "ops@quickprint.in",
                        "Centre",
                        "Pending"
                ),

                createUserRow(
                        "AK",
                        "Admin Kapoor",
                        "kapoor@privora.app",
                        "Admin",
                        "Active"
                ),

                createUserRow(
                        "PN",
                        "Priya Nair",
                        "priya@privora.app",
                        "User",
                        "Expired"
                )
        );

        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        userCard.getChildren().addAll(
                searchRow,
                headerRow,
                separator,
                usersList
        );

        // =====================================================
        // SCROLL
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane(main);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-background: transparent;" +
                "-fx-border-color: transparent;"
        );

        main.getChildren().addAll(
                heading,
                userCard
        );

        return scrollPane;
    }

    // =========================================================
    // USER ROW
    // =========================================================

    private HBox createUserRow(
            String initials,
            String name,
            String email,
            String role,
            String status) {

        HBox row = new HBox();

        row.setMinHeight(80);

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(10, 15, 10, 15)
        );

        row.setStyle(
                "-fx-background-color: transparent;"
        );

        // =====================================================
        // AVATAR
        // =====================================================

        Label avatar = new Label(
                initials
        );

        avatar.setAlignment(
                Pos.CENTER
        );

        avatar.setMinSize(
                42,
                42
        );

        avatar.setMaxSize(
                42,
                42
        );

        avatar.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, "
                        + PURPLE + ", #3B82F6);" +
                "-fx-background-radius: 50%;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        // =====================================================
        // NAME
        // =====================================================

        Label nameLabel = new Label(
                name
        );

        nameLabel.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        VBox nameBox = new VBox(
                nameLabel
        );

        HBox nameContainer = new HBox(
                12,
                avatar,
                nameBox
        );

        nameContainer.setAlignment(
                Pos.CENTER_LEFT
        );

        nameContainer.setPrefWidth(
                190
        );

        // =====================================================
        // EMAIL
        // =====================================================

        Label emailLabel = new Label(
                email
        );

        emailLabel.setStyle(
                "-fx-text-fill: " + SECONDARY + ";" +
                "-fx-font-size: 12px;"
        );

        emailLabel.setPrefWidth(
                220
        );

        // =====================================================
        // ROLE
        // =====================================================

        Label roleLabel = new Label(
                role
        );

        roleLabel.setAlignment(
                Pos.CENTER
        );

        roleLabel.setStyle(
                "-fx-background-color: #211A30;" +
                "-fx-background-radius: 14;" +
                "-fx-text-fill: #C9B9E8;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 6 12;"
        );

        HBox roleBox = new HBox(
                roleLabel
        );

        roleBox.setPrefWidth(
                110
        );

        roleBox.setAlignment(
                Pos.CENTER_LEFT
        );

        // =====================================================
        // STATUS
        // =====================================================

        Label statusLabel = new Label(
                status
        );

        if (status.equals("Active")) {

            statusLabel.setStyle(
                    "-fx-background-color: #17352F;" +
                    "-fx-background-radius: 14;" +
                    "-fx-text-fill: #4ADE80;" +
                    "-fx-font-size: 10px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 6 12;"
            );

        } else if (status.equals("Pending")) {

            statusLabel.setStyle(
                    "-fx-background-color: #3A3020;" +
                    "-fx-background-radius: 14;" +
                    "-fx-text-fill: #FBBF24;" +
                    "-fx-font-size: 10px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 6 12;"
            );

        } else {

            statusLabel.setStyle(
                    "-fx-background-color: #282735;" +
                    "-fx-background-radius: 14;" +
                    "-fx-text-fill: #9CA3AF;" +
                    "-fx-font-size: 10px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 6 12;"
            );
        }

        HBox statusBox = new HBox(
                statusLabel
        );

        statusBox.setPrefWidth(
                130
        );

        statusBox.setAlignment(
                Pos.CENTER_LEFT
        );

        // =====================================================
        // ACTIONS
        // =====================================================

        Button editButton = new Button(
                "✎"
        );

        Button suspendButton = new Button(
                "⊘"
        );

        Button deleteButton = new Button(
                "⌫"
        );

        styleActionButton(
                editButton,
                LIGHT_PURPLE
        );

        styleActionButton(
                suspendButton,
                "#C5B8D5"
        );

        styleActionButton(
                deleteButton,
                "#EF6B73"
        );

        editButton.setOnAction(e ->
                showMessage(
                        "Edit User",
                        "Editing: " + name
                )
        );

        suspendButton.setOnAction(e ->
                showMessage(
                        "Suspend User",
                        "Suspend action for: " + name
                )
        );

        deleteButton.setOnAction(e ->
                showMessage(
                        "Delete User",
                        "Delete action for: " + name
                )
        );

        HBox actions = new HBox(
                8,
                editButton,
                suspendButton,
                deleteButton
        );

        actions.setAlignment(
                Pos.CENTER_LEFT
        );

        actions.setPrefWidth(
                180
        );

        // =====================================================
        // ADD ROW
        // =====================================================

        row.getChildren().addAll(
                nameContainer,
                emailLabel,
                roleBox,
                statusBox,
                actions
        );

        // =====================================================
        // HOVER
        // =====================================================

        row.setOnMouseEntered(e -> {

            row.setStyle(
                    "-fx-background-color: " + CARD_HOVER + ";" +
                    "-fx-background-radius: 12;"
            );
        });

        row.setOnMouseExited(e -> {

            row.setStyle(
                    "-fx-background-color: transparent;"
            );
        });

        return row;
    }

    // =========================================================
    // HEADER LABEL
    // =========================================================

    private Label createHeader(
            String text) {

        Label label = new Label(
                text
        );

        label.setStyle(
                "-fx-text-fill: #81758F;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );

        return label;
    }

    // =========================================================
    // ACTION BUTTON
    // =========================================================

    private void styleActionButton(
            Button button,
            String textColor) {

        button.setMinSize(
                32,
                32
        );

        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + textColor + ";" +
                "-fx-font-size: 17px;" +
                "-fx-padding: 4;" +
                "-fx-cursor: hand;"
        );

        button.setOnMouseEntered(e -> {

            button.setStyle(
                    "-fx-background-color: #241A32;" +
                    "-fx-background-radius: 10;" +
                    "-fx-text-fill: " + textColor + ";" +
                    "-fx-font-size: 17px;" +
                    "-fx-padding: 4;" +
                    "-fx-cursor: hand;"
            );
        });

        button.setOnMouseExited(e -> {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: " + textColor + ";" +
                    "-fx-font-size: 17px;" +
                    "-fx-padding: 4;" +
                    "-fx-cursor: hand;"
            );
        });
    }

    // =========================================================
    // MESSAGE
    // =========================================================

    private void showMessage(
            String title,
            String message) {

        Alert alert = new Alert(
                Alert.AlertType.INFORMATION
        );

        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.showAndWait();
    }
}