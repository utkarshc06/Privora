package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class History {

    private BorderPane root;

    // Purple theme
    private final String BG = "#0B0714";
    private final String CARD = "#151022";
    private final String BORDER = "#2A2140";
    private final String TEXT = "#F5F3FF";
    private final String MUTED = "#A9A0C2";
    private final String PURPLE = "#8B5CF6";

    public History() {
        createUI();
    }

    private void createUI() {

        root = new BorderPane();
        root.setStyle("-fx-background-color: " + BG + ";");

        VBox content = new VBox(22);
        content.setPadding(new Insets(35));
        content.setAlignment(Pos.TOP_LEFT);

        // =========================
        // HEADER
        // =========================

        Label title = new Label("History");
        title.setStyle(
                "-fx-font-size: 34px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: " + TEXT + ";"
        );

        Label subtitle = new Label(
                "Every finished job with a full audit trail."
        );

        subtitle.setStyle(
                "-fx-font-size: 16px;" +
                "-fx-text-fill: " + MUTED + ";"
        );

        VBox header = new VBox(5);
        header.getChildren().addAll(title, subtitle);

        // =========================
        // TABLE
        // =========================

        VBox table = new VBox();

        table.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-radius: 20;"
        );

        // Header row
        HBox headerRow = createRow(
                "CUSTOMER",
                "PURPOSE",
                "DATE",
                "PRINTS",
                "STATUS"
        );

        headerRow.setStyle(
                "-fx-border-color: transparent transparent " +
                BORDER + " transparent;" +
                "-fx-border-width: 0 0 1 0;"
        );

        table.getChildren().add(headerRow);

        // Empty structure rows
        for (int i = 0; i < 5; i++) {
            HBox row = createEmptyRow();

            if (i < 4) {
                row.setStyle(
                        "-fx-border-color: transparent transparent " +
                        BORDER + " transparent;" +
                        "-fx-border-width: 0 0 1 0;"
                );
            }

            table.getChildren().add(row);
        }

        content.getChildren().addAll(header, table);

        root.setCenter(content);
    }

    // =========================================================
    // TABLE HEADER
    // =========================================================

    private HBox createRow(
            String customer,
            String purpose,
            String date,
            String prints,
            String status
    ) {

        HBox row = new HBox();

        row.setPadding(new Insets(18, 20, 18, 20));
        row.setSpacing(20);

        Label c1 = createLabel(customer, 1);
        Label c2 = createLabel(purpose, 1);
        Label c3 = createLabel(date, 1);
        Label c4 = createLabel(prints, 1);
        Label c5 = createLabel(status, 1);

        row.getChildren().addAll(c1, c2, c3, c4, c5);

        return row;
    }

    // =========================================================
    // EMPTY DATA ROW
    // =========================================================

    private HBox createEmptyRow() {

        HBox row = new HBox();

        row.setPadding(new Insets(18, 20, 18, 20));
        row.setSpacing(20);
        row.setMinHeight(58);

        Label customer = createLabel("", 1);
        Label purpose = createLabel("", 1);
        Label date = createLabel("", 1);
        Label prints = createLabel("", 1);
        Label status = createLabel("", 1);

        row.getChildren().addAll(
                customer,
                purpose,
                date,
                prints,
                status
        );

        return row;
    }

    // =========================================================
    // LABEL
    // =========================================================

    private Label createLabel(String text, int grow) {

        Label label = new Label(text);

        label.setMaxWidth(Double.MAX_VALUE);

        label.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-text-fill: " + MUTED + ";"
        );

        HBox.setHgrow(label, javafx.scene.layout.Priority.ALWAYS);

        return label;
    }

    // =========================================================
    // GET CONTENT
    // =========================================================

    public BorderPane getContent() {
        return root;
    }
}