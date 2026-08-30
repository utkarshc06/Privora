package com.ciphercore.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Permissions {

    // =========================================================
    // COLORS - PRIVORA PURPLE / VIOLET THEME
    // =========================================================

    private final String BACKGROUND = "#0B0A0F";
    private final String CARD = "#15131F";
    private final String BORDER = "#29243A";

    private final String PURPLE = "#8B5CF6";
    private final String DEEP_PURPLE = "#6D28D9";
    private final String LIGHT_PURPLE = "#A78BFA";

    private final String TEXT = "#F5F3FF";
    private final String SECONDARY = "#9D96B5";


    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public VBox getContent() {

        VBox main = new VBox(25);

        main.setPadding(
                new Insets(30, 35, 40, 35)
        );

        main.setStyle(
                "-fx-background-color: " + BACKGROUND + ";"
        );


        // =====================================================
        // HEADER
        // =====================================================

        VBox header = new VBox(5);

        Label title = new Label(
                "Permission settings"
        );

        title.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 30px;" +
                "-fx-font-weight: bold;"
        );


        Label subtitle = new Label(
                "Fine-tune what the print centre can and can't do."
        );

        subtitle.setStyle(
                "-fx-text-fill: " + SECONDARY + ";" +
                "-fx-font-size: 15px;"
        );


        header.getChildren().addAll(
                title,
                subtitle
        );


        // =====================================================
        // PERMISSION GRID
        // =====================================================

        GridPane grid = new GridPane();

        grid.setHgap(20);
        grid.setVgap(20);


        // =====================================================
        // PRINT LIMIT
        // =====================================================

        VBox printLimit =
                createPrintLimitCard();


        // =====================================================
        // EXPIRY TIME
        // =====================================================

        VBox expiryTime =
                createExpiryCard();


        // =====================================================
        // DOWNLOAD
        // =====================================================

        VBox download =
                createToggleCard(
                        "⇩",
                        "Download Allowed",
                        "Allow file download",
                        false
                );


        // =====================================================
        // FORWARD
        // =====================================================

        VBox forward =
                createToggleCard(
                        "➜",
                        "Forward Allowed",
                        "Share with another centre",
                        false
                );


        // =====================================================
        // SCREENSHOT
        // =====================================================

        VBox screenshot =
                createToggleCard(
                        "▣",
                        "Screenshot Allowed",
                        "Block screen capture",
                        false
                );


        // =====================================================
        // APPROVAL
        // =====================================================

        VBox approval =
                createToggleCard(
                        "✓",
                        "Approval Required",
                        "Require centre approval",
                        true
                );


        // =====================================================
        // ADD TO GRID
        // =====================================================

        grid.add(
                printLimit,
                0,
                0
        );

        grid.add(
                expiryTime,
                1,
                0
        );

        grid.add(
                download,
                0,
                1
        );

        grid.add(
                forward,
                1,
                1
        );

        grid.add(
                screenshot,
                0,
                2
        );

        grid.add(
                approval,
                1,
                2
        );


        // =====================================================
        // COLUMN WIDTH
        // =====================================================

        javafx.scene.layout.ColumnConstraints column1 =
                new javafx.scene.layout.ColumnConstraints();

        column1.setPercentWidth(50);

        column1.setHgrow(
                Priority.ALWAYS
        );


        javafx.scene.layout.ColumnConstraints column2 =
                new javafx.scene.layout.ColumnConstraints();

        column2.setPercentWidth(50);

        column2.setHgrow(
                Priority.ALWAYS
        );


        grid.getColumnConstraints().addAll(
                column1,
                column2
        );


        // =====================================================
        // SAVE BUTTON
        // =====================================================

        HBox buttonBox =
                new HBox();

        buttonBox.setAlignment(
                Pos.CENTER_RIGHT
        );


        Button saveButton =
                new Button("▣   Save");


        saveButton.setPrefWidth(135);
        saveButton.setPrefHeight(48);


        saveButton.setStyle(
                "-fx-background-color: linear-gradient(to right, "
                        + "#16131F, #201B2C);" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 15;" +
                "-fx-background-radius: 15;" +
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );


        // =====================================================
        // SAVE BUTTON HOVER
        // =====================================================

        saveButton.setOnMouseEntered(e -> {

            saveButton.setStyle(
                    "-fx-background-color: #211A2E;" +
                    "-fx-border-color: " + PURPLE + ";" +
                    "-fx-border-radius: 15;" +
                    "-fx-background-radius: 15;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 14px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-cursor: hand;" +
                    "-fx-effect: dropshadow(" +
                    "gaussian, rgba(139,92,246,0.35), " +
                    "15, 0.4, 0, 3);"
            );

            saveButton.setScaleX(1.03);
            saveButton.setScaleY(1.03);

        });


        saveButton.setOnMouseExited(e -> {

            saveButton.setStyle(
                    "-fx-background-color: linear-gradient(to right, "
                            + "#16131F, #201B2C);" +
                    "-fx-border-color: " + BORDER + ";" +
                    "-fx-border-radius: 15;" +
                    "-fx-background-radius: 15;" +
                    "-fx-text-fill: " + TEXT + ";" +
                    "-fx-font-size: 14px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-cursor: hand;"
            );

            saveButton.setScaleX(1);
            saveButton.setScaleY(1);

        });


        saveButton.setOnAction(e -> {

            System.out.println(
                    "Permission settings saved."
            );

        });


        buttonBox.getChildren().add(
                saveButton
        );


        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        main.getChildren().addAll(
                header,
                grid,
                buttonBox
        );


        return main;
    }


    // =========================================================
    // PRINT LIMIT CARD
    // =========================================================

    private VBox createPrintLimitCard() {

        VBox card =
                createCard();


        HBox row =
                new HBox(18);

        row.setAlignment(
                Pos.CENTER_LEFT
        );


        StackPane icon =
                createIcon("▣");


        VBox textBox =
                new VBox(4);


        Label title =
                new Label(
                        "Print Limit"
                );

        title.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );


        Label description =
                new Label(
                        "Cap total prints"
                );

        description.setStyle(
                "-fx-text-fill: " + SECONDARY + ";" +
                "-fx-font-size: 13px;"
        );


        textBox.getChildren().addAll(
                title,
                description
        );


        HBox.setHgrow(
                textBox,
                Priority.ALWAYS
        );


        // =====================================================
        // COUNTER
        // =====================================================

        HBox counter =
                new HBox();

        counter.setAlignment(
                Pos.CENTER
        );

        counter.setPrefHeight(52);

        counter.setStyle(
                "-fx-background-color: #1B1926;" +
                "-fx-border-color: #302A40;" +
                "-fx-border-radius: 25;" +
                "-fx-background-radius: 25;"
        );


        Button minus =
                new Button("−");

        Button plus =
                new Button("+");


        Label number =
                new Label("3");


        number.setMinWidth(45);

        number.setAlignment(
                Pos.CENTER
        );

        number.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;"
        );


        styleCounterButton(minus);

        styleCounterButton(plus);


        minus.setOnAction(e -> {

            int value =
                    Integer.parseInt(
                            number.getText()
                    );

            if (value > 1) {

                number.setText(
                        String.valueOf(value - 1)
                );

            }

        });


        plus.setOnAction(e -> {

            int value =
                    Integer.parseInt(
                            number.getText()
                    );

            if (value < 99) {

                number.setText(
                        String.valueOf(value + 1)
                );

            }

        });


        counter.getChildren().addAll(
                minus,
                number,
                plus
        );


        row.getChildren().addAll(
                icon,
                textBox,
                counter
        );


        card.getChildren().add(
                row
        );


        return card;
    }


    // =========================================================
    // EXPIRY CARD
    // =========================================================

    private VBox createExpiryCard() {

        VBox card =
                createCard();


        HBox row =
                new HBox(18);

        row.setAlignment(
                Pos.CENTER_LEFT
        );


        StackPane icon =
                createIcon("◷");


        VBox textBox =
                new VBox(4);


        Label title =
                new Label(
                        "Expiry Time"
                );

        title.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );


        Label description =
                new Label(
                        "Auto-close session"
                );

        description.setStyle(
                "-fx-text-fill: " + SECONDARY + ";" +
                "-fx-font-size: 13px;"
        );


        textBox.getChildren().addAll(
                title,
                description
        );


        HBox.setHgrow(
                textBox,
                Priority.ALWAYS
        );


        ComboBox<String> expiry =
                new ComboBox<>();


        expiry.getItems().addAll(
                "5 min",
                "10 min",
                "15 min",
                "30 min"
        );


        expiry.setValue(
                "15 min"
        );


        expiry.setPrefWidth(125);

        expiry.setPrefHeight(42);


        expiry.setStyle(
                "-fx-background-color: #1B1926;" +
                "-fx-border-color: #302A40;" +
                "-fx-border-radius: 22;" +
                "-fx-background-radius: 22;" +
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 14px;" +
                "-fx-cursor: hand;"
        );


        row.getChildren().addAll(
                icon,
                textBox,
                expiry
        );


        card.getChildren().add(
                row
        );


        return card;
    }


    // =========================================================
    // TOGGLE CARD
    // =========================================================

    private VBox createToggleCard(
            String iconText,
            String titleText,
            String descriptionText,
            boolean defaultValue) {


        VBox card =
                createCard();


        HBox row =
                new HBox(18);

        row.setAlignment(
                Pos.CENTER_LEFT
        );


        StackPane icon =
                createIcon(iconText);


        VBox textBox =
                new VBox(4);


        Label title =
                new Label(
                        titleText
                );

        title.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;"
        );


        Label description =
                new Label(
                        descriptionText
                );

        description.setStyle(
                "-fx-text-fill: " + SECONDARY + ";" +
                "-fx-font-size: 13px;"
        );


        textBox.getChildren().addAll(
                title,
                description
        );


        HBox.setHgrow(
                textBox,
                Priority.ALWAYS
        );


        ToggleButton toggle =
                new ToggleButton();


        toggle.setSelected(
                defaultValue
        );


        toggle.setPrefWidth(55);

        toggle.setPrefHeight(30);


        updateToggleStyle(toggle);


        toggle.setOnAction(e -> {

            updateToggleStyle(toggle);

        });


        row.getChildren().addAll(
                icon,
                textBox,
                toggle
        );


        card.getChildren().add(
                row
        );


        return card;
    }


    // =========================================================
    // CARD
    // =========================================================

    private VBox createCard() {

        VBox card =
                new VBox();


        card.setPrefHeight(125);

        card.setMinHeight(115);


        card.setPadding(
                new Insets(20, 25, 20, 25)
        );


        card.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 22;" +
                "-fx-background-radius: 22;"
        );


        // =====================================================
        // CARD HOVER
        // =====================================================

        card.setOnMouseEntered(e -> {

            card.setStyle(
                    "-fx-background-color: #1B1828;" +
                    "-fx-border-color: #4C3575;" +
                    "-fx-border-radius: 22;" +
                    "-fx-background-radius: 22;"
            );

        });


        card.setOnMouseExited(e -> {

            card.setStyle(
                    "-fx-background-color: " + CARD + ";" +
                    "-fx-border-color: " + BORDER + ";" +
                    "-fx-border-radius: 22;" +
                    "-fx-background-radius: 22;"
            );

        });


        return card;
    }


    // =========================================================
    // ICON
    // =========================================================

    private StackPane createIcon(
            String iconText) {


        Circle circle =
                new Circle(25);


        circle.setFill(
                Color.web(PURPLE)
        );


        Label iconLabel =
                new Label(iconText);


        iconLabel.setStyle(
                "-fx-text-fill: white;" +
                "-fx-font-size: 19px;" +
                "-fx-font-weight: bold;"
        );


        StackPane box =
                new StackPane();


        box.setPrefSize(
                50,
                50
        );


        box.getChildren().addAll(
                circle,
                iconLabel
        );


        return box;
    }


    // =========================================================
    // COUNTER BUTTON STYLE
    // =========================================================

    private void styleCounterButton(
            Button button) {


        button.setPrefWidth(42);

        button.setPrefHeight(42);


        button.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 18px;" +
                "-fx-font-weight: bold;" +
                "-fx-cursor: hand;"
        );


        button.setOnMouseEntered(e -> {

            button.setStyle(
                    "-fx-background-color: #29213D;" +
                    "-fx-text-fill: " + LIGHT_PURPLE + ";" +
                    "-fx-font-size: 18px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-cursor: hand;"
            );

        });


        button.setOnMouseExited(e -> {

            button.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-text-fill: " + TEXT + ";" +
                    "-fx-font-size: 18px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-cursor: hand;"
            );

        });

    }


    // =========================================================
    // TOGGLE STYLE
    // =========================================================

    private void updateToggleStyle(
            ToggleButton toggle) {


        if (toggle.isSelected()) {

            toggle.setText("●");


            toggle.setStyle(
                    "-fx-background-color: " + PURPLE + ";" +
                    "-fx-background-radius: 20;" +
                    "-fx-text-fill: white;" +
                    "-fx-font-size: 13px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-cursor: hand;" +
                    "-fx-effect: dropshadow(" +
                    "gaussian, rgba(139,92,246,0.35), " +
                    "10, 0.3, 0, 2);"
            );


        } else {

            toggle.setText("");


            toggle.setStyle(
                    "-fx-background-color: #303747;" +
                    "-fx-background-radius: 20;" +
                    "-fx-border-color: #3B4354;" +
                    "-fx-border-radius: 20;" +
                    "-fx-cursor: hand;"
            );

        }

    }
}