package com.ciphercore.view.xerox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Printing {

    public Scene getScene() {

        BorderPane root =
                new BorderPane();

        root.setStyle(
                "-fx-background-color:#061126;"
        );

        XeroxSideBar sideBar =
                new XeroxSideBar(
                        "Printing"
                );

        root.setLeft(
                sideBar.getSideBar()
        );

        VBox main =
                new VBox(22);

        main.setPadding(
                new Insets(32)
        );

        Label heading =
                new Label("Printing");

        heading.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:32px;" +
                "-fx-font-weight:bold;"
        );

        Label subtitle =
                new Label(
                        "Live print progress. Locks automatically at the print limit."
                );

        subtitle.setStyle(
                "-fx-text-fill:#8C9BB0;"
        );

        // =====================================================
        // PROGRESS
        // =====================================================

        VBox progress =
                new VBox(20);

        progress.setAlignment(
                Pos.CENTER
        );

        progress.setPrefHeight(350);

        progress.setStyle(
                "-fx-background-color:#0B192D;" +
                "-fx-background-radius:18;" +
                "-fx-border-color:#22354F;" +
                "-fx-border-radius:18;"
        );

        Label count =
                new Label("0");

        count.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:65px;" +
                "-fx-font-weight:bold;"
        );

        Label of =
                new Label("OF 0 PRINTS");

        of.setStyle(
                "-fx-text-fill:#8C9BB0;" +
                "-fx-font-size:14px;"
        );

        HBox stats =
                new HBox(15);

        stats.setAlignment(
                Pos.CENTER
        );

        stats.getChildren().addAll(
                createStat("ALLOWED", "0"),
                createStat("CURRENT", "0"),
                createStat("REMAINING", "0")
        );

        progress.getChildren().addAll(
                count,
                of,
                stats
        );

        // =====================================================
        // PRINT CONTROLS
        // =====================================================

        VBox controls =
                new VBox(15);

        controls.setPadding(
                new Insets(22)
        );

        controls.setStyle(
                "-fx-background-color:#0B192D;" +
                "-fx-background-radius:18;" +
                "-fx-border-color:#22354F;" +
                "-fx-border-radius:18;"
        );

        Label controlTitle =
                new Label(
                        "Print Controls"
                );

        controlTitle.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:19px;" +
                "-fx-font-weight:bold;"
        );

        Label info =
                new Label(
                        "Print controls will become available when a request is active."
                );

        info.setStyle(
                "-fx-text-fill:#8C9BB0;"
        );

        Button print =
                new Button("Print Next Copy");

        print.setMaxWidth(
                Double.MAX_VALUE
        );

        print.setPrefHeight(48);

        print.setStyle(
                "-fx-background-color:#2196F3;" +
                "-fx-text-fill:white;" +
                "-fx-font-size:14px;"
        );

        controls.getChildren().addAll(
                controlTitle,
                info,
                print
        );

        main.getChildren().addAll(
                heading,
                subtitle,
                progress,
                controls
        );

        root.setCenter(main);

        return new Scene(
                root,
                1300,
                750
        );
    }

    private VBox createStat(
            String title,
            String value) {

        VBox box =
                new VBox(5);

        box.setAlignment(
                Pos.CENTER
        );

        box.setPrefWidth(140);

        box.setPadding(
                new Insets(15)
        );

        box.setStyle(
                "-fx-background-color:#101E32;" +
                "-fx-background-radius:12;" +
                "-fx-border-color:#22354F;" +
                "-fx-border-radius:12;"
        );

        Label number =
                new Label(value);

        number.setStyle(
                "-fx-text-fill:white;" +
                "-fx-font-size:24px;" +
                "-fx-font-weight:bold;"
        );

        Label label =
                new Label(title);

        label.setStyle(
                "-fx-text-fill:#8C9BB0;" +
                "-fx-font-size:11px;"
        );

        box.getChildren().addAll(
                number,
                label
        );

        return box;
    }
}