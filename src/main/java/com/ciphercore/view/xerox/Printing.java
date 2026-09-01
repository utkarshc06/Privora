package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class Printing {

    // =========================
    // PURPLE THEME
    // =========================
    private static final String BG = "#090713";
    private static final String CARD = "#121020";
    private static final String CARD2 = "#171329";
    private static final String BORDER = "#292044";
    private static final String PURPLE = "#8B3DFF";
    private static final String PURPLE_LIGHT = "#A970FF";
    private static final String TEXT = "#FFFFFF";
    private static final String MUTED = "#AAA2C5";
    private static final String GREEN = "#00D9A5";

    // Dynamic values
    private int allowedPrints = 0;
    private int currentPrints = 0;
    private int remainingPrints = 0;

    private Label allowedValue;
    private Label currentValue;
    private Label remainingValue;
    private Label progressNumber;
    private Label progressText;

    private VBox rootContent;

    public Printing() {
    }

    // =========================================================
    // GET CONTENT
    // =========================================================
    public VBox getContent() {

        rootContent = new VBox();
        rootContent.setSpacing(24);
        rootContent.setPadding(new Insets(30, 34, 40, 34));
        rootContent.setFillWidth(true);

        rootContent.setStyle(
                "-fx-background-color: " + BG + ";"
        );

        // =========================
        // PAGE TITLE
        // =========================
        Label title = new Label("Printing");
        title.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 36px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Live print progress. Locks automatically at the print limit."
        );

        subtitle.setStyle(
                "-fx-text-fill: " + MUTED + ";" +
                "-fx-font-size: 16px;"
        );

        VBox heading = new VBox(5, title, subtitle);

        // =========================
        // PROGRESS CARD
        // =========================
        VBox progressCard = createProgressCard();

        // =========================
        // PRINT CONTROLS
        // =========================
        VBox controlsCard = createControlsCard();

        rootContent.getChildren().addAll(
                heading,
                progressCard,
                controlsCard
        );

        return rootContent;
    }

    // =========================================================
    // PROGRESS CARD
    // =========================================================
    private VBox createProgressCard() {

        VBox card = new VBox(30);
        card.setAlignment(Pos.CENTER);
        card.setPadding(new Insets(35));

        card.setMaxWidth(Double.MAX_VALUE);

        card.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 22px;" +
                "-fx-background-radius: 22px;" +
                "-fx-border-width: 1px;"
        );

        // =========================
        // CIRCLE
        // =========================

        StackPane progressPane = new StackPane();

        Circle backgroundCircle = new Circle(110);
        backgroundCircle.setFill(Color.TRANSPARENT);
        backgroundCircle.setStroke(Color.web("#20233A"));
        backgroundCircle.setStrokeWidth(18);

        Arc progressArc = new Arc(
                0,
                0,
                110,
                110,
                0,
                0
        );

        progressArc.setFill(Color.TRANSPARENT);
        progressArc.setStroke(Color.web(PURPLE));
        progressArc.setStrokeWidth(18);
        progressArc.setStrokeLineCap(
                javafx.scene.shape.StrokeLineCap.ROUND
        );

        progressNumber = new Label("0");

        progressNumber.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 52px;" +
                "-fx-font-weight: bold;"
        );

        progressText = new Label("OF 0 PRINTS");

        progressText.setStyle(
                "-fx-text-fill: " + MUTED + ";" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        VBox circleText = new VBox(
                3,
                progressNumber,
                progressText
        );

        circleText.setAlignment(Pos.CENTER);

        progressPane.getChildren().addAll(
                backgroundCircle,
                progressArc,
                circleText
        );

        // =========================
        // STAT CARDS
        // =========================

        allowedValue = createValueLabel("0");
        currentValue = createValueLabel("0");
        remainingValue = createValueLabel("0");

        VBox allowedCard = createStatCard(
                allowedValue,
                "ALLOWED"
        );

        VBox currentCard = createStatCard(
                currentValue,
                "CURRENT"
        );

        VBox remainingCard = createStatCard(
                remainingValue,
                "REMAINING"
        );

        HBox stats = new HBox(
                18,
                allowedCard,
                currentCard,
                remainingCard
        );

        stats.setAlignment(Pos.CENTER);

        stats.setMaxWidth(650);

        card.getChildren().addAll(
                progressPane,
                stats
        );

        return card;
    }

    // =========================================================
    // STAT CARD
    // =========================================================
    private VBox createStatCard(
            Label value,
            String text
    ) {

        Label label = new Label(text);

        label.setStyle(
                "-fx-text-fill: " + MUTED + ";" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        VBox box = new VBox(
                5,
                value,
                label
        );

        box.setAlignment(Pos.CENTER);

        box.setPrefWidth(180);
        box.setPrefHeight(90);

        box.setStyle(
                "-fx-background-color: " + CARD2 + ";" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 18px;" +
                "-fx-background-radius: 18px;" +
                "-fx-border-width: 1px;"
        );

        return box;
    }

    // =========================================================
    // CONTROLS CARD
    // =========================================================
    private VBox createControlsCard() {

        VBox card = new VBox(20);

        card.setPadding(new Insets(26));

        card.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 22px;" +
                "-fx-background-radius: 22px;"
        );

        Label heading = new Label("Print controls");

        heading.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 20px;" +
                "-fx-font-weight: bold;"
        );

        Label info = new Label(
                "Print controls will become available when a session is active."
        );

        info.setStyle(
                "-fx-text-fill: " + MUTED + ";" +
                "-fx-font-size: 15px;"
        );

        Button printButton = new Button("Print");

        printButton.setMaxWidth(Double.MAX_VALUE);
        printButton.setPrefHeight(48);

        printButton.setStyle(
                "-fx-background-color: " + PURPLE + ";" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-background-radius: 12px;"
        );

        printButton.setDisable(true);

        card.getChildren().addAll(
                heading,
                info,
                printButton
        );

        return card;
    }

    // =========================================================
    // VALUE LABEL
    // =========================================================
    private Label createValueLabel(String value) {

        Label label = new Label(value);

        label.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 28px;" +
                "-fx-font-weight: bold;"
        );

        return label;
    }

    // =========================================================
    // UPDATE PRINT DATA
    // Firebase / Database se data aane par ye method call karna
    // =========================================================
    public void setPrintData(
            int allowed,
            int current
    ) {

        this.allowedPrints = allowed;
        this.currentPrints = current;

        this.remainingPrints =
                Math.max(allowed - current, 0);

        updateUI();
    }

    // =========================================================
    // UPDATE UI
    // =========================================================
    private void updateUI() {

        if (allowedValue == null) {
            return;
        }

        allowedValue.setText(
                String.valueOf(allowedPrints)
        );

        currentValue.setText(
                String.valueOf(currentPrints)
        );

        remainingValue.setText(
                String.valueOf(remainingPrints)
        );

        progressNumber.setText(
                String.valueOf(currentPrints)
        );

        progressText.setText(
                "OF " + allowedPrints + " PRINTS"
        );
    }

    // =========================================================
    // SCENE
    // =========================================================
    public Scene getScene() {

        BorderPane root = new BorderPane();

        root.setStyle(
                "-fx-background-color: " + BG + ";"
        );

        root.setCenter(getContent());

        return new Scene(root, 1200, 800);
    }
}