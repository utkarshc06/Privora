package com.ciphercore.view.user;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class Activity {

    // =========================================================
    // COLORS
    // =========================================================

    private final String BACKGROUND = "#0B0A0F";
    private final String CARD = "#111722";
    private final String CARD_HOVER = "#171426";
    private final String BORDER = "#262137";

    private final String PURPLE = "#8B5CF6";
    private final String PURPLE_DARK = "#6D28D9";

    private final String TEXT = "#F5F3FF";
    private final String SECONDARY = "#9E94AD";


    // =========================================================
    // CONTENT
    // =========================================================

    public VBox getContent() {

        VBox main = new VBox(25);

        main.setPadding(
                new Insets(35, 40, 40, 40)
        );

        main.setStyle(
                "-fx-background-color: " + BACKGROUND + ";"
        );


        // =====================================================
        // HEADING
        // =====================================================

        Label title = new Label(
                "Activity timeline"
        );

        title.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;"
        );


        Label subtitle = new Label(
                "A full audit trail of everything you've done."
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
        // TIMELINE CARD
        // =====================================================

        VBox timelineCard = new VBox();

        timelineCard.setPadding(
                new Insets(25, 30, 25, 30)
        );

        timelineCard.setMaxWidth(
                Double.MAX_VALUE
        );

        timelineCard.setStyle(
                "-fx-background-color: " + CARD + ";" +
                "-fx-border-color: " + BORDER + ";" +
                "-fx-border-width: 1;" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;"
        );


        // =====================================================
        // TIMELINE
        // =====================================================

        VBox timeline = new VBox();


        // =====================================================
        // ACTIVITY 1 - UPLOADED
        // =====================================================

        HBox uploaded = createTimelineItem(
                "⇧",
                "Uploaded",
                "Aadhaar-Card.pdf",
                "10:12 AM",
                PURPLE
        );


        // =====================================================
        // ACTIVITY 2 - VIEWED
        // =====================================================

        HBox viewed = createTimelineItem(
                "◉",
                "Viewed",
                "By Sharma Xerox Point",
                "10:14 AM",
                "#22C55E"
        );


        // =====================================================
        // ACTIVITY 3 - QR GENERATED
        // =====================================================

        HBox qrGenerated = createTimelineItem(
                "⌗",
                "QR Generated",
                "Session VF-8823-KL",
                "10:16 AM",
                PURPLE
        );


        // =====================================================
        // ACTIVITY 4 - PRINTED
        // =====================================================

        HBox printed = createTimelineItem(
                "▣",
                "Printed",
                "Copy 1 of 3",
                "10:22 AM",
                "#22C55E"
        );


        // =====================================================
        // ACTIVITY 5 - EXPIRED
        // =====================================================

        HBox expired = createTimelineItem(
                "×",
                "Expired",
                "PAN-Form.pdf session",
                "Yesterday",
                "#EF4444"
        );


        timeline.getChildren().addAll(
                uploaded,
                viewed,
                qrGenerated,
                printed,
                expired
        );


        timelineCard.getChildren().add(
                timeline
        );


        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane(timelineCard);

        scrollPane.setFitToWidth(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setStyle("""
                -fx-background-color: transparent;
                -fx-background: transparent;
                -fx-border-color: transparent;
                """);

        VBox.setVgrow(
                scrollPane,
                Priority.ALWAYS
        );


        // =====================================================
        // ADD EVERYTHING
        // =====================================================

        main.getChildren().addAll(
                heading,
                scrollPane
        );


        return main;
    }


    // =========================================================
    // CREATE TIMELINE ITEM
    // =========================================================

    private HBox createTimelineItem(
            String icon,
            String title,
            String description,
            String time,
            String iconColor) {


        HBox item = new HBox(18);

        item.setAlignment(
                Pos.CENTER_LEFT
        );

        item.setMinHeight(75);

        item.setMaxWidth(
                Double.MAX_VALUE
        );


        // =====================================================
        // TIMELINE LEFT SIDE
        // =====================================================

        VBox timelineIconBox = new VBox();

        timelineIconBox.setAlignment(
                Pos.TOP_CENTER
        );

        timelineIconBox.setPrefWidth(
                32
        );

        timelineIconBox.setMinWidth(
                32
        );


        // =====================================================
        // ICON CIRCLE
        // =====================================================

        Label iconLabel = new Label(
                icon
        );

        iconLabel.setAlignment(
                Pos.CENTER
        );

        iconLabel.setPrefSize(
                32,
                32
        );

        iconLabel.setMinSize(
                32,
                32
        );

        iconLabel.setStyle(
                "-fx-background-color: " + iconColor + ";" +
                "-fx-background-radius: 50%;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;"
        );


        timelineIconBox.getChildren().add(
                iconLabel
        );


        // =====================================================
        // CENTER INFORMATION
        // =====================================================

        VBox information = new VBox(3);

        HBox.setHgrow(
                information,
                Priority.ALWAYS
        );


        Label titleLabel = new Label(
                title
        );

        titleLabel.setStyle(
                "-fx-text-fill: " + TEXT + ";" +
                "-fx-font-size: 17px;" +
                "-fx-font-weight: bold;"
        );


        Label descriptionLabel = new Label(
                description
        );

        descriptionLabel.setStyle(
                "-fx-text-fill: " + SECONDARY + ";" +
                "-fx-font-size: 14px;"
        );


        information.getChildren().addAll(
                titleLabel,
                descriptionLabel
        );


        // =====================================================
        // TIME
        // =====================================================

        Label timeLabel = new Label(
                time
        );

        timeLabel.setMinWidth(
                85
        );

        timeLabel.setAlignment(
                Pos.CENTER_RIGHT
        );

        timeLabel.setStyle(
                "-fx-text-fill: #A8A0B8;" +
                "-fx-font-size: 13px;"
        );


        // =====================================================
        // ADD CONTENT
        // =====================================================

        item.getChildren().addAll(
                timelineIconBox,
                information,
                timeLabel
        );


        // =====================================================
        // HOVER
        // =====================================================

        item.setOnMouseEntered(e -> {

            item.setStyle(
                    "-fx-background-color: " + CARD_HOVER + ";" +
                    "-fx-background-radius: 12;" +
                    "-fx-cursor: hand;"
            );

            item.setPadding(
                    new Insets(8, 10, 8, 10)
            );

        });


        // =====================================================
        // MOUSE EXIT
        // =====================================================

        item.setOnMouseExited(e -> {

            item.setStyle(
                    "-fx-background-color: transparent;" +
                    "-fx-background-radius: 12;"
            );

            item.setPadding(
                    new Insets(8, 0, 8, 0)
            );

        });


        return item;
    }
}