package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class XeroxDashboard {

    public Scene getScene() {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:#061126;"
        );

        // =====================================================
        // SIDEBAR
        // =====================================================

        XeroxSideBar sideBar =
                new XeroxSideBar("Dashboard");

        root.setLeft(
                sideBar.getSideBar()
        );

        // =====================================================
        // TOP BAR
        // =====================================================

        HBox topBar =
                new HBox();

        topBar.setPadding(
                new Insets(18, 28, 18, 28)
        );

        topBar.setAlignment(
                Pos.CENTER_LEFT
        );

        topBar.setStyle(
                "-fx-background-color:#09172B;" +
                "-fx-border-color:#1C304A;"
        );

        Label title =
                new Label(
                        "Xerox Centre Dashboard"
                );

        title.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:15px;" +
                "-fx-font-weight:bold;"
        );

        Region spacer =
                new Region();

        HBox.setHgrow(
                spacer,
                Priority.ALWAYS
        );

        Label online =
                new Label(
                        "●  Centre Online"
                );

        online.setStyle(
                "-fx-text-fill:#20D6A1;" +
                "-fx-font-weight:bold;"
        );

        topBar.getChildren().addAll(
                title,
                spacer,
                online
        );

        // =====================================================
        // MAIN
        // =====================================================

        VBox main =
                new VBox(22);

        main.setPadding(
                new Insets(32)
        );

        Label heading =
                new Label(
                        "Centre Dashboard"
                );

        heading.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:32px;" +
                "-fx-font-weight:bold;"
        );

        Label subtitle =
                new Label(
                        "Manage your document printing requests."
                );

        subtitle.setStyle(
                "-fx-text-fill:#8C9BB0;" +
                "-fx-font-size:15px;"
        );

        // =====================================================
        // STAT CARDS
        // =====================================================

        GridPane cards =
                new GridPane();

        cards.setHgap(16);

        cards.add(
                createCard(
                        "TODAY'S REQUESTS",
                        "0",
                        "Incoming requests"
                ),
                0,
                0
        );

        cards.add(
                createCard(
                        "ACTIVE PRINTS",
                        "0",
                        "Currently printing"
                ),
                1,
                0
        );

        cards.add(
                createCard(
                        "COMPLETED JOBS",
                        "0",
                        "Successfully completed"
                ),
                2,
                0
        );

        cards.add(
                createCard(
                        "PENDING APPROVAL",
                        "0",
                        "Waiting for action"
                ),
                3,
                0
        );

        // =====================================================
        // RECENT REQUESTS
        // =====================================================

        VBox recent =
                new VBox(15);

        recent.setPadding(
                new Insets(22)
        );

        recent.setPrefHeight(270);

        recent.setStyle(
                "-fx-background-color:#0B192D;" +
                "-fx-background-radius:18;" +
                "-fx-border-color:#22354F;" +
                "-fx-border-radius:18;"
        );

        Label recentTitle =
                new Label(
                        "Recent Requests"
                );

        recentTitle.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:19px;" +
                "-fx-font-weight:bold;"
        );

        Label recentInfo =
                new Label(
                        "No requests available"
                );

        recentInfo.setStyle(
                "-fx-text-fill:#8C9BB0;" +
                "-fx-font-size:14px;"
        );

        VBox.setVgrow(
                recentInfo,
                Priority.ALWAYS
        );

        recent.setAlignment(
                Pos.TOP_LEFT
        );

        recent.getChildren().addAll(
                recentTitle,
                recentInfo
        );

        // =====================================================
        // MAIN ADD
        // =====================================================

        main.getChildren().addAll(
                heading,
                subtitle,
                cards,
                recent
        );

        root.setTop(topBar);
        root.setCenter(main);

        return new Scene(
                root,
                1300,
                750
        );
    }

    private VBox createCard(
            String title,
            String value,
            String description) {

        VBox card =
                new VBox(8);

        card.setPrefWidth(235);
        card.setPrefHeight(135);

        card.setPadding(
                new Insets(20)
        );

        card.setStyle(
                "-fx-background-color:#0B192D;" +
                "-fx-background-radius:18;" +
                "-fx-border-color:#22354F;" +
                "-fx-border-radius:18;"
        );

        Label heading =
                new Label(title);

        heading.setStyle(
                "-fx-text-fill:#8C9BB0;" +
                "-fx-font-size:12px;" +
                "-fx-font-weight:bold;"
        );

        Label number =
                new Label(value);

        number.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:30px;" +
                "-fx-font-weight:bold;"
        );

        Label info =
                new Label(description);

        info.setStyle(
                "-fx-text-fill:#20D6A1;" +
                "-fx-font-size:12px;"
        );

        card.getChildren().addAll(
                heading,
                number,
                info
        );

        return card;
    }

    public Scene getXeroxDashboardScene(Runnable rd) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getXeroxDashboardScene'");
    }
}