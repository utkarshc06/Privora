package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class XDashboard {

    // =========================================================
    // VIOLET THEME
    // =========================================================

    private final String BG = "#090714";
    private final String CARD = "#151027";
    private final String CARD2 = "#1B1533";
    private final String BORDER = "#302451";
    private final String VIOLET = "#8B5CF6";
    private final String VIOLET_LIGHT = "#A78BFA";
    private final String TEXT = "#FFFFFF";
    private final String MUTED = "#A9A0C2";


    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public VBox getContent() {

        VBox main = new VBox();

        main.setFillWidth(true);

        main.setStyle(
                "-fx-background-color:" + BG + ";"
        );


        // =====================================================
        // SCROLL CONTENT
        // =====================================================

        VBox content = new VBox(22);

        content.setPadding(
                new Insets(35)
        );

        content.setFillWidth(true);

        content.setStyle(
                "-fx-background-color:" + BG + ";"
        );


        // =====================================================
        // HEADER
        // =====================================================

        Label title =
                new Label("Centre dashboard");

        title.setStyle(
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-font-size:32px;" +
                "-fx-font-weight:bold;"
        );


        Label subtitle =
                new Label(
                        "A quick view of today's print activity."
                );

        subtitle.setStyle(
                "-fx-text-fill:" + MUTED + ";" +
                "-fx-font-size:15px;"
        );


        VBox header =
                new VBox(
                        6,
                        title,
                        subtitle
                );


        // =====================================================
        // STAT CARDS
        // =====================================================

        HBox cards =
                new HBox(18);

        cards.setFillHeight(true);


        VBox requestsCard =
                createStatCard(
                        "TODAY'S REQUESTS",
                        "28",
                        "+6 vs yesterday"
                );


        VBox activeCard =
                createStatCard(
                        "ACTIVE PRINTS",
                        "3",
                        "1 needs approval"
                );


        VBox completedCard =
                createStatCard(
                        "COMPLETED JOBS",
                        "124",
                        "This week"
                );


        VBox pendingCard =
                createStatCard(
                        "PENDING APPROVAL",
                        "2",
                        "Waiting on user"
                );


        HBox.setHgrow(
                requestsCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                activeCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                completedCard,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                pendingCard,
                Priority.ALWAYS
        );


        cards.getChildren().addAll(
                requestsCard,
                activeCard,
                completedCard,
                pendingCard
        );


        // =====================================================
        // LOWER SECTION
        // =====================================================

        HBox bottom =
                new HBox(25);

        bottom.setFillHeight(true);


        VBox incomingRequests =
                createIncomingRequests();


        VBox rightSide =
                createRightSide();


        HBox.setHgrow(
                incomingRequests,
                Priority.ALWAYS
        );


        bottom.getChildren().addAll(
                incomingRequests,
                rightSide
        );


        // =====================================================
        // ADD TO SCROLL CONTENT
        // =====================================================

        content.getChildren().addAll(
                header,
                cards,
                bottom
        );


        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane(content);

        scrollPane.setFitToWidth(true);

        scrollPane.setFitToHeight(false);

        scrollPane.setPannable(true);

        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );

        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );


        scrollPane.setStyle(
                "-fx-background:" + BG + ";" +
                "-fx-background-color:" + BG + ";" +
                "-fx-border-color:transparent;"
        );


        // =====================================================
        // SCROLL BAR STYLE
        // =====================================================

        scrollPane.lookupAll(".scroll-bar").forEach(node -> {

            node.setStyle(
                    "-fx-background-color:" + BG + ";"
            );
        });


        VBox.setVgrow(
                scrollPane,
                Priority.ALWAYS
        );


        main.getChildren().add(
                scrollPane
        );


        return main;
    }


    // =========================================================
    // STAT CARD
    // =========================================================

    private VBox createStatCard(
            String heading,
            String number,
            String description
    ) {

        VBox card =
                new VBox(7);

        card.setPadding(
                new Insets(22)
        );

        card.setMinHeight(140);

        card.setMaxWidth(
                Double.MAX_VALUE
        );

        card.setStyle(
                "-fx-background-color:" + CARD + ";" +
                "-fx-background-radius:18;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:18;"
        );


        Label headingLabel =
                new Label(heading);

        headingLabel.setStyle(
                "-fx-text-fill:#9188AA;" +
                "-fx-font-size:12px;" +
                "-fx-font-weight:bold;"
        );


        Label numberLabel =
                new Label(number);

        numberLabel.setStyle(
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-font-size:34px;" +
                "-fx-font-weight:bold;"
        );


        Label descriptionLabel =
                new Label(description);

        descriptionLabel.setStyle(
                "-fx-text-fill:" + VIOLET_LIGHT + ";" +
                "-fx-font-size:13px;"
        );


        card.getChildren().addAll(
                headingLabel,
                numberLabel,
                descriptionLabel
        );


        return card;
    }


    // =========================================================
    // INCOMING REQUESTS
    // =========================================================

    private VBox createIncomingRequests() {

        VBox box =
                new VBox();

        box.setPadding(
                new Insets(22)
        );

        box.setMinWidth(600);

        box.setStyle(
                "-fx-background-color:" + CARD + ";" +
                "-fx-background-radius:18;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:18;"
        );


        Label title =
                new Label(
                        "Latest incoming requests"
                );

        title.setStyle(
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;"
        );


        Label viewAll =
                new Label(
                        "View all  ›"
                );

        viewAll.setStyle(
                "-fx-text-fill:" + VIOLET_LIGHT + ";" +
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;"
        );


        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );


        HBox top =
                new HBox(
                        title,
                        spacer,
                        viewAll
                );

        top.setAlignment(
                Pos.CENTER_LEFT
        );


        // =====================================================
        // TABLE HEADERS
        // =====================================================

        HBox headings =
                new HBox();

        headings.setPadding(
                new Insets(
                        25,
                        5,
                        12,
                        5
                )
        );


        Label customer =
                createColumn("CUSTOMER");

        Label purpose =
                createColumn("PURPOSE");

        Label time =
                createColumn("TIME");

        Label status =
                createColumn("STATUS");

        Label actions =
                createColumn("ACTIONS");


        HBox.setHgrow(
                customer,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                purpose,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                time,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                status,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                actions,
                Priority.ALWAYS
        );


        headings.getChildren().addAll(
                customer,
                purpose,
                time,
                status,
                actions
        );


        // =====================================================
        // REQUEST ROWS
        // =====================================================

        VBox rows =
                new VBox();


        rows.getChildren().addAll(

                createRequestRow(
                        "Printing",
                        "10:12 AM",
                        "Pending"
                ),

                createRequestRow(
                        "Scanning",
                        "10:08 AM",
                        "Pending"
                ),

                createRequestRow(
                        "Form Filling",
                        "09:55 AM",
                        "Active"
                ),

                createRequestRow(
                        "Verification",
                        "09:41 AM",
                        "Completed"
                ),

                createRequestRow(
                        "Document Print",
                        "09:32 AM",
                        "Completed"
                )
        );


        box.getChildren().addAll(
                top,
                headings,
                rows
        );


        return box;
    }


    // =========================================================
    // REQUEST ROW
    // =========================================================

    private HBox createRequestRow(
            String purposeText,
            String timeText,
            String statusText
    ) {

        HBox row =
                new HBox();

        row.setAlignment(
                Pos.CENTER_LEFT
        );

        row.setPadding(
                new Insets(
                        14,
                        5,
                        14,
                        5
                )
        );

        row.setStyle(
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-width:0 0 1 0;"
        );


        // Customer

        HBox customerBox =
                new HBox(10);

        customerBox.setAlignment(
                Pos.CENTER_LEFT
        );


        Circle avatar =
                new Circle(
                        19,
                        Color.web(VIOLET)
                );


        Label customerName =
                new Label("Customer");

        customerName.setStyle(
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-font-size:14px;" +
                "-fx-font-weight:bold;"
        );


        customerBox.getChildren().addAll(
                avatar,
                customerName
        );


        // Purpose

        Label purpose =
                new Label(
                        purposeText
                );

        purpose.setStyle(
                "-fx-text-fill:" + MUTED + ";" +
                "-fx-font-size:14px;"
        );


        // Time

        Label time =
                new Label(
                        timeText
                );

        time.setStyle(
                "-fx-text-fill:" + MUTED + ";" +
                "-fx-font-size:14px;"
        );


        // Status

        Label status =
                new Label(
                        statusText
                );

        status.setStyle(
                getStatusStyle(statusText)
        );


        // Action

        Label action =
                new Label(
                        statusText.equals("Pending")
                                ? "Accept    Reject"
                                : "Open"
                );

        action.setStyle(
                "-fx-text-fill:" + VIOLET_LIGHT + ";" +
                "-fx-font-size:13px;" +
                "-fx-font-weight:bold;"
        );


        HBox.setHgrow(
                customerBox,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                purpose,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                time,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                status,
                Priority.ALWAYS
        );

        HBox.setHgrow(
                action,
                Priority.ALWAYS
        );


        row.getChildren().addAll(
                customerBox,
                purpose,
                time,
                status,
                action
        );


        return row;
    }


    // =========================================================
    // STATUS STYLE
    // =========================================================

    private String getStatusStyle(
            String status
    ) {

        if (status.equals("Pending")) {

            return """
                    -fx-text-fill:#C4A7FF;
                    -fx-background-color:#302050;
                    -fx-background-radius:20;
                    -fx-padding:5 12;
                    -fx-font-size:12px;
                    """;
        }


        if (status.equals("Active")) {

            return """
                    -fx-text-fill:#BBA2FF;
                    -fx-background-color:#292044;
                    -fx-background-radius:20;
                    -fx-padding:5 12;
                    -fx-font-size:12px;
                    """;
        }


        return """
                -fx-text-fill:#9D7CFF;
                -fx-background-color:#241A3E;
                -fx-background-radius:20;
                -fx-padding:5 12;
                -fx-font-size:12px;
                """;
    }


    // =========================================================
    // RIGHT SIDE
    // =========================================================

    private VBox createRightSide() {

        VBox right =
                new VBox(25);

        right.setPrefWidth(350);


        // =====================================================
        // VERIFIED CENTRE
        // =====================================================

        VBox verified =
                new VBox(8);

        verified.setPadding(
                new Insets(25)
        );

        verified.setStyle(
                "-fx-background-color:" + VIOLET + ";" +
                "-fx-background-radius:18;"
        );


        Label icon =
                new Label("✦");

        icon.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:24px;"
        );


        Label verifiedTitle =
                new Label(
                        "Verified Centre"
                );

        verifiedTitle.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:20px;" +
                "-fx-font-weight:bold;"
        );


        Label verifiedText =
                new Label(
                        "Your centre has a 98% approval rate. Keep it up!"
                );

        verifiedText.setWrapText(true);

        verifiedText.setStyle(
                "-fx-text-fill:#E9E0FF;" +
                "-fx-font-size:13px;"
        );


        verified.getChildren().addAll(
                icon,
                verifiedTitle,
                verifiedText
        );


        // =====================================================
        // PRINTER STATUS
        // =====================================================

        VBox printerStatus =
                new VBox(15);

        printerStatus.setPadding(
                new Insets(22)
        );

        printerStatus.setStyle(
                "-fx-background-color:" + CARD + ";" +
                "-fx-background-radius:18;" +
                "-fx-border-color:" + BORDER + ";" +
                "-fx-border-radius:18;"
        );


        Label printerTitle =
                new Label(
                        "Printer status"
                );

        printerTitle.setStyle(
                "-fx-text-fill:" + TEXT + ";" +
                "-fx-font-size:18px;" +
                "-fx-font-weight:bold;"
        );


        VBox printerA =
                createPrinter(
                        VIOLET_LIGHT,
                        "Printer A",
                        "Idle · Tray full"
                );


        VBox printerB =
                createPrinter(
                        "#A78BFA",
                        "Printer B",
                        "Job in progress"
                );


        VBox printerC =
                createPrinter(
                        "#FF6B81",
                        "Printer C",
                        "Offline"
                );


        printerStatus.getChildren().addAll(
                printerTitle,
                printerA,
                printerB,
                printerC
        );


        right.getChildren().addAll(
                verified,
                printerStatus
        );


        return right;
    }


    // =========================================================
    // PRINTER
    // =========================================================

    private VBox createPrinter(
            String dotColor,
            String printerName,
            String printerStatus
    ) {

        VBox box =
                new VBox(3);

        box.setPadding(
                new Insets(15)
        );

        box.setStyle(
                "-fx-background-color:" + CARD2 + ";" +
                "-fx-background-radius:15;"
        );


        HBox line =
                new HBox(10);

        line.setAlignment(
                Pos.CENTER_LEFT
        );


        Circle dot =
                new Circle(
                        5,
                        Color.web(dotColor)
                );


        Label name =
                new Label(
                        printerName
                );

        name.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;"
        );


        line.getChildren().addAll(
                dot,
                name
        );


        Label status =
                new Label(
                        printerStatus
                );

        status.setPadding(
                new Insets(
                        0,
                        0,
                        0,
                        15
                )
        );

        status.setStyle(
                "-fx-text-fill:" + MUTED + ";" +
                "-fx-font-size:12px;"
        );


        box.getChildren().addAll(
                line,
                status
        );


        return box;
    }


    // =========================================================
    // COLUMN
    // =========================================================

    private Label createColumn(
            String text
    ) {

        Label label =
                new Label(text);

        label.setStyle(
                "-fx-text-fill:#81769E;" +
                "-fx-font-size:11px;" +
                "-fx-font-weight:bold;"
        );

        return label;
    }
}