package com.ciphercore.view.admin;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Centres {

    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public VBox getContent() {

        VBox root = new VBox(
                22
        );

        root.setPadding(
                new Insets(30, 38, 40, 38)
        );

        root.setStyle(
                "-fx-background-color: #080E18;"
        );

        // =====================================================
        // HEADING
        // =====================================================

        Label title = new Label(
                "Centre management"
        );

        title.setStyle(
                "-fx-text-fill: #F8FAFC;" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;"
        );

        Label subtitle = new Label(
                "Approve, reject or block registered print centres."
        );

        subtitle.setStyle(
                "-fx-text-fill: #94A3B8;" +
                "-fx-font-size: 15px;"
        );

        VBox heading = new VBox(
                5,
                title,
                subtitle
        );

        // =====================================================
        // MAIN CARD
        // =====================================================

        VBox card = new VBox();

        card.setStyle(
                "-fx-background-color: #111927;" +
                "-fx-background-radius: 22;" +
                "-fx-border-color: #202B3C;" +
                "-fx-border-radius: 22;"
        );

        // =====================================================
        // TOOLBAR
        // =====================================================

        HBox toolbar = new HBox(
                10
        );

        toolbar.setPadding(
                new Insets(25, 28, 20, 28)
        );

        // Search

        TextField searchField = new TextField();

        searchField.setPromptText(
                "⌕  Search centres by name or city..."
        );

        searchField.setPrefHeight(
                48
        );

        searchField.setStyle(
                "-fx-background-color: #172235;" +
                "-fx-background-radius: 18;" +
                "-fx-border-color: transparent;" +
                "-fx-text-fill: #E2E8F0;" +
                "-fx-prompt-text-fill: #64748B;" +
                "-fx-font-size: 14px;" +
                "-fx-padding: 0 18;"
        );

        HBox.setHgrow(
                searchField,
                Priority.ALWAYS
        );

        // Filter

        Button filterButton = new Button(
                "▽  Filter"
        );

        filterButton.setPrefHeight(
                48
        );

        filterButton.setPrefWidth(
                120
        );

        filterButton.setStyle(
                "-fx-background-color: #080E18;" +
                "-fx-border-color: #273448;" +
                "-fx-border-radius: 18;" +
                "-fx-background-radius: 18;" +
                "-fx-text-fill: #E2E8F0;" +
                "-fx-font-size: 13px;" +
                "-fx-font-weight: bold;"
        );

        // Add

        Button addButton = new Button(
                "+  Add"
        );

        addButton.setPrefHeight(
                48
        );

        addButton.setPrefWidth(
                110
        );

        addButton.setStyle(
                "-fx-background-color: linear-gradient(to right, #168DF5, #22A7FF);" +
                "-fx-background-radius: 18;" +
                "-fx-text-fill: #06111F;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        toolbar.getChildren().addAll(
                searchField,
                filterButton,
                addButton
        );

        // =====================================================
        // TABLE HEADER
        // =====================================================

        HBox tableHeader = createTableHeader();

        // =====================================================
        // CENTRE ROWS
        // =====================================================

        VBox rows = new VBox();

        VBox row1 = createCentreRow(
                "S",
                "Sharma Xerox\nPoint",
                "Sector 12,\nNoida",
                "Verified",
                "Active"
        );

        VBox row2 = createCentreRow(
                "Q",
                "QuickPrint\nHub",
                "Connaught\nPlace, Delhi",
                "Verified",
                "Active"
        );

        VBox row3 = createCentreRow(
                "P",
                "PrintZone\nExpress",
                "Sec 21,\nFaridabad",
                "Pending",
                "Pending"
        );

        VBox row4 = createCentreRow(
                "M",
                "Metro Copy\nCorner",
                "MG Road,\nGurgaon",
                "Pending",
                "Rejected"
        );

        rows.getChildren().addAll(
                row1,
                row2,
                row3,
                row4
        );

        card.getChildren().addAll(
                toolbar,
                tableHeader,
                rows
        );

        // =====================================================
        // ROOT
        // =====================================================

        root.getChildren().addAll(
                heading,
                card
        );

        return root;
    }

    // =========================================================
    // TABLE HEADER
    // =========================================================

    private HBox createTableHeader() {

        HBox header = new HBox();

        header.setPadding(
                new Insets(0, 28, 14, 28)
        );

        Label centre = createHeaderLabel(
                "CENTRE"
        );

        Label address = createHeaderLabel(
                "ADDRESS"
        );

        Label verification = createHeaderLabel(
                "VERIFICATION"
        );

        Label status = createHeaderLabel(
                "STATUS"
        );

        Label actions = createHeaderLabel(
                "ACTIONS"
        );

        centre.setPrefWidth(195);
        address.setPrefWidth(145);
        verification.setPrefWidth(145);
        status.setPrefWidth(150);

        HBox.setHgrow(
                actions,
                Priority.ALWAYS
        );

        header.getChildren().addAll(
                centre,
                address,
                verification,
                status,
                actions
        );

        return header;
    }

    // =========================================================
    // CENTRE ROW
    // =========================================================

    private VBox createCentreRow(
            String icon,
            String centreName,
            String addressText,
            String verificationText,
            String statusText
    ) {

        VBox container = new VBox();

        container.setPadding(
                new Insets(15, 28, 15, 28)
        );

        // -----------------------------------------------------
        // MAIN ROW
        // -----------------------------------------------------

        HBox row = new HBox();

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        // Centre

        Label iconLabel = new Label(
                icon
        );

        iconLabel.setAlignment(
                Pos.CENTER
        );

        iconLabel.setPrefSize(
                40,
                40
        );

        iconLabel.setStyle(
                "-fx-background-color: linear-gradient(to bottom right, #168DF5, #22A7FF);" +
                "-fx-background-radius: 14;" +
                "-fx-text-fill: white;" +
                "-fx-font-size: 15px;" +
                "-fx-font-weight: bold;"
        );

        Label centreLabel = new Label(
                centreName
        );

        centreLabel.setStyle(
                "-fx-text-fill: #E2E8F0;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );

        HBox centreBox = new HBox(
                12,
                iconLabel,
                centreLabel
        );

        centreBox.setAlignment(
                Pos.CENTER_LEFT
        );

        centreBox.setPrefWidth(
                195
        );

        // Address

        Label addressLabel = new Label(
                addressText
        );

        addressLabel.setStyle(
                "-fx-text-fill: #94A3B8;" +
                "-fx-font-size: 13px;"
        );

        addressLabel.setPrefWidth(
                145
        );

        // Verification

        Label verificationLabel = createStatus(
                verificationText
        );

        verificationLabel.setPrefWidth(
                145
        );

        // Status

        Label statusLabel = createStatus(
                statusText
        );

        statusLabel.setPrefWidth(
                150
        );

        // Actions

        VBox actions = new VBox(
                5
        );

        actions.setAlignment(
                Pos.CENTER_LEFT
        );

        Button approve = new Button(
                "Approve"
        );

        approve.setPrefWidth(
                90
        );

        approve.setPrefHeight(
                35
        );

        approve.setStyle(
                "-fx-background-color: #06C993;" +
                "-fx-background-radius: 12;" +
                "-fx-text-fill: #031B14;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        Button reject = new Button(
                "Reject"
        );

        reject.setPrefWidth(
                90
        );

        reject.setPrefHeight(
                35
        );

        reject.setStyle(
                "-fx-background-color: #080E18;" +
                "-fx-border-color: #263449;" +
                "-fx-border-radius: 12;" +
                "-fx-background-radius: 12;" +
                "-fx-text-fill: #E2E8F0;" +
                "-fx-font-size: 12px;" +
                "-fx-font-weight: bold;"
        );

        Label block = new Label(
                "⊘"
        );

        block.setStyle(
                "-fx-text-fill: #F87171;" +
                "-fx-font-size: 20px;"
        );

        actions.getChildren().addAll(
                approve,
                reject,
                block
        );

        HBox.setHgrow(
                actions,
                Priority.ALWAYS
        );

        row.getChildren().addAll(
                centreBox,
                addressLabel,
                verificationLabel,
                statusLabel,
                actions
        );

        container.getChildren().add(
                row
        );

        container.setStyle(
                "-fx-border-color: #202B3C;" +
                "-fx-border-width: 0 0 1 0;"
        );

        return container;
    }

    // =========================================================
    // HEADER LABEL
    // =========================================================

    private Label createHeaderLabel(
            String text
    ) {

        Label label = new Label(
                text
        );

        label.setStyle(
                "-fx-text-fill: #8B98AA;" +
                "-fx-font-size: 11px;" +
                "-fx-font-weight: bold;"
        );

        return label;
    }

    // =========================================================
    // STATUS
    // =========================================================

    private Label createStatus(
            String text
    ) {

        Label label = new Label(
                text
        );

        if (text.equalsIgnoreCase("Verified")
                || text.equalsIgnoreCase("Active")) {

            label.setStyle(
                    "-fx-background-color: rgba(6,201,147,0.14);" +
                    "-fx-background-radius: 12;" +
                    "-fx-text-fill: #06D9A0;" +
                    "-fx-font-size: 11px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 7 12;"
            );

        } else if (
                text.equalsIgnoreCase("Pending")
        ) {

            label.setStyle(
                    "-fx-background-color: rgba(245,158,11,0.15);" +
                    "-fx-background-radius: 12;" +
                    "-fx-text-fill: #F5B942;" +
                    "-fx-font-size: 11px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 7 12;"
            );

        } else {

            label.setStyle(
                    "-fx-background-color: rgba(239,68,68,0.15);" +
                    "-fx-background-radius: 12;" +
                    "-fx-text-fill: #F87171;" +
                    "-fx-font-size: 11px;" +
                    "-fx-font-weight: bold;" +
                    "-fx-padding: 7 12;"
            );
        }

        return label;
    }
}