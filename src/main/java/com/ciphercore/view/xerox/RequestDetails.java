package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class RequestDetails {

    // =========================================================
    // COLORS - PRIVORA PURPLE THEME
    // =========================================================

    private final String BG = "#09080F";
    private final String CARD = "#15131F";
    private final String CARD_INNER = "#19162A";
    private final String BORDER = "#2A2538";

    private final String PURPLE = "#8B5CF6";
    private final String DEEP_PURPLE = "#6D28D9";
    private final String VIOLET = "#A78BFA";

    private final String TEXT = "#F5F3FF";
    private final String SECONDARY = "#9D96B5";


    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public ScrollPane getContent() {

        VBox main = new VBox(28);

        main.setPadding(
                new Insets(35, 40, 50, 40)
        );

        main.setFillWidth(true);

        main.setStyle(
                "-fx-background-color:" + BG + ";"
        );


        // =====================================================
        // HEADER
        // =====================================================

        VBox header = new VBox(6);

        Label title = new Label(
                "Request details"
        );

        title.setStyle(
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-font-size:32px;" +
                "-fx-font-weight:bold;"
        );

        Label subtitle = new Label(
                "Review the document and privacy rules before starting the session."
        );

        subtitle.setStyle(
                "-fx-text-fill:" + SECONDARY + ";" +
                "-fx-font-size:15px;"
        );

        header.getChildren().addAll(
                title,
                subtitle
        );


        // =====================================================
        // DOCUMENT INFORMATION CARD
        // =====================================================

        VBox documentCard = new VBox();

        documentCard.setSpacing(0);

        documentCard.setPadding(
                new Insets(0)
        );

        documentCard.setStyle(
                "-fx-background-color:" + CARD + ";" +
                "-fx-background-radius:22;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:22;"
        );


        // =====================================================
        // CARD TITLE
        // =====================================================

        Label documentTitle = new Label(
                "Document information"
        );

        documentTitle.setStyle(
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-font-size:21px;" +
                "-fx-font-weight:bold;"
        );

        VBox documentHeader = new VBox(
                documentTitle
        );

        documentHeader.setPadding(
                new Insets(28, 32, 24, 32)
        );

        documentHeader.setStyle(
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-width:0 0 1 0;"
        );


        // =====================================================
        // FILE BOX
        // =====================================================

        HBox fileBox = new HBox(18);

        fileBox.setAlignment(
                Pos.CENTER_LEFT
        );

        fileBox.setPadding(
                new Insets(22)
        );

        fileBox.setStyle(
                "-fx-background-color:" + CARD_INNER + ";" +
                "-fx-background-radius:20;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:20;"
        );


        // File icon

        Label fileIcon = new Label(
                "▤"
        );

        fileIcon.setAlignment(
                Pos.CENTER
        );

        fileIcon.setMinSize(
                76,
                76
        );

        fileIcon.setStyle(
                "-fx-background-color:#25164A;" +
                "-fx-background-radius:18;" +
                "-fx-text-fill:" + VIOLET + ";" +
                "-fx-font-size:27px;"
        );


        // File information

        VBox fileInfo = new VBox(5);

        Label fileName = new Label(
                "Aadhaar-Card.pdf"
        );

        fileName.setStyle(
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-font-size:21px;" +
                "-fx-font-weight:bold;"
        );

        Label fileMeta = new Label(
                "1 page · 1.4 MB · Redacted"
        );

        fileMeta.setStyle(
                "-fx-text-fill:" + SECONDARY + ";" +
                "-fx-font-size:14px;"
        );

        fileInfo.getChildren().addAll(
                fileName,
                fileMeta
        );


        // Push waiting badge to right

        Region fileSpacer = new Region();

        HBox.setHgrow(
                fileSpacer,
                Priority.ALWAYS
        );


        // Waiting badge

        Label waiting = new Label(
                "Waiting"
        );

        waiting.setAlignment(
                Pos.CENTER
        );

        waiting.setPadding(
                new Insets(8, 18, 8, 18)
        );

        waiting.setStyle(
                "-fx-background-color:#251F17;" +
                "-fx-border-color:#C88A00;" +
                "-fx-border-radius:20;" +
                "-fx-background-radius:20;" +
                "-fx-text-fill:#F2A900;" +
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;"
        );


        fileBox.getChildren().addAll(
                fileIcon,
                fileInfo,
                fileSpacer,
                waiting
        );


        // =====================================================
        // DOCUMENT DETAILS
        // =====================================================

        HBox detailsRow = new HBox(100);

        detailsRow.setPadding(
                new Insets(32)
        );


        VBox leftDetails = new VBox(28);

        VBox purposeBox = createDetail(
                "PURPOSE",
                "Printing"
        );

        VBox mobileBox = createDetail(
                "MOBILE",
                "+91 98••••4210"
        );

        leftDetails.getChildren().addAll(
                purposeBox,
                mobileBox
        );


        VBox rightDetails = new VBox(28);

        VBox customerBox = createDetail(
                "CUSTOMER",
                "Aditi Sharma"
        );

        VBox uploadedBox = createDetail(
                "UPLOADED",
                "Today, 10:12 AM"
        );

        rightDetails.getChildren().addAll(
                customerBox,
                uploadedBox
        );


        HBox.setHgrow(
                leftDetails,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                rightDetails,
                Priority.ALWAYS
        );

        detailsRow.getChildren().addAll(
                leftDetails,
                rightDetails
        );


        documentCard.getChildren().addAll(
                documentHeader,
                createInnerPadding(fileBox),
                detailsRow
        );


        // =====================================================
        // PRIVACY RULES CARD
        // =====================================================

        VBox privacyCard = new VBox();

        privacyCard.setSpacing(0);

        privacyCard.setStyle(
                "-fx-background-color:" + CARD + ";" +
                "-fx-background-radius:22;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:22;"
        );


        Label privacyTitle = new Label(
                "Privacy rules"
        );

        privacyTitle.setStyle(
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-font-size:21px;" +
                "-fx-font-weight:bold;"
        );

        VBox privacyHeader = new VBox(
                privacyTitle
        );

        privacyHeader.setPadding(
                new Insets(28, 32, 24, 32)
        );

        privacyHeader.setStyle(
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-width:0 0 1 0;"
        );


        VBox rules = new VBox(20);

        rules.setPadding(
                new Insets(28, 32, 28, 32)
        );


        rules.getChildren().addAll(
                createRule(
                        "▣",
                        "Print limit",
                        "3 prints",
                        PURPLE
                ),

                createRule(
                        "◷",
                        "Expiry",
                        "15 min",
                        "#F2A900"
                ),

                createRule(
                        "⇩",
                        "Download",
                        "Disabled",
                        "#FF4D5A"
                ),

                createRule(
                        "⊘",
                        "Copy / Forward",
                        "Disabled",
                        "#FF4D5A"
                ),

                createRule(
                        "♢",
                        "Watermark",
                        "Enabled",
                        "#00D4A8"
                ),

                createRule(
                        "⚠",
                        "Approval",
                        "Required per print",
                        "#F2A900"
                )
        );


        // =====================================================
        // ACTION BUTTONS
        // =====================================================

        HBox actions = new HBox(12);

        actions.setPadding(
                new Insets(0, 32, 30, 32)
        );

        actions.setAlignment(
                Pos.CENTER
        );


        javafx.scene.control.Button startButton =
                new javafx.scene.control.Button(
                        "Start session"
                );

        startButton.setMaxWidth(
                Double.MAX_VALUE
        );

        startButton.setPrefHeight(48);

        startButton.setStyle(
                "-fx-background-color:linear-gradient(to right,"
                        + PURPLE + "," + DEEP_PURPLE + ");" +
                "-fx-background-radius:12;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;" +
                "-fx-cursor:hand;"
        );


        javafx.scene.control.Button rejectButton =
                new javafx.scene.control.Button(
                        "Reject"
                );

        rejectButton.setMaxWidth(
                Double.MAX_VALUE
        );

        rejectButton.setPrefHeight(48);

        rejectButton.setStyle(
                "-fx-background-color:#09080F;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:12;" +
                "-fx-background-radius:12;" +
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;" +
                "-fx-cursor:hand;"
        );


        HBox.setHgrow(
                startButton,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                rejectButton,
                Priority.ALWAYS
        );


        actions.getChildren().addAll(
                startButton,
                rejectButton
        );


        privacyCard.getChildren().addAll(
                privacyHeader,
                rules,
                actions
        );


        // =====================================================
        // ADD ALL
        // =====================================================

        main.getChildren().addAll(
                header,
                documentCard,
                privacyCard
        );


        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane(main);

        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(false);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );

        scrollPane.setPannable(true);

        scrollPane.setStyle(
                "-fx-background-color:" + BG + ";" +
                "-fx-border-color:transparent;"
        );

        return scrollPane;
    }


    // =========================================================
    // DETAIL FIELD
    // =========================================================

    private VBox createDetail(
            String labelText,
            String valueText) {

        VBox box = new VBox(7);

        Label label = new Label(
                labelText
        );

        label.setStyle(
                "-fx-text-fill:" + SECONDARY + ";" +
                "-fx-font-size:12px;" +
                "-fx-font-weight:bold;"
        );

        Label value = new Label(
                valueText
        );

        value.setStyle(
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-font-size:17px;" +
                "-fx-font-weight:bold;"
        );

        box.getChildren().addAll(
                label,
                value
        );

        return box;
    }


    // =========================================================
    // RULE
    // =========================================================

    private HBox createRule(
            String iconText,
            String titleText,
            String valueText,
            String iconColor) {

        HBox row = new HBox(18);

        row.setAlignment(
                Pos.CENTER_LEFT
        );


        Label icon = new Label(
                iconText
        );

        icon.setAlignment(
                Pos.CENTER
        );

        icon.setMinSize(
                54,
                54
        );

        icon.setStyle(
                "-fx-background-color:#19132D;" +
                "-fx-background-radius:15;" +
                "-fx-border-color:" + iconColor + ";" +
                "-fx-border-radius:15;" +
                "-fx-text-fill:" + iconColor + ";" +
                "-fx-font-size:19px;"
        );


        Label title = new Label(
                titleText
        );

        title.setStyle(
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-font-size:16px;" +
                "-fx-font-weight:bold;"
        );


        Region spacer = new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        Label value = new Label(
                valueText
        );

        value.setStyle(
                "-fx-text-fill:" + SECONDARY + ";" +
                "-fx-font-size:15px;"
        );


        row.getChildren().addAll(
                icon,
                title,
                spacer,
                value
        );

        return row;
    }


    // =========================================================
    // INNER PADDING
    // =========================================================

    private VBox createInnerPadding(
            HBox content) {

        VBox box = new VBox(
                content
        );

        box.setPadding(
                new Insets(28, 32, 0, 32)
        );

        return box;
    }
}