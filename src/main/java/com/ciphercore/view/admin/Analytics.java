package com.ciphercore.view.admin;

import javafx.geometry.Insets;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Analytics {

    // =========================================================
    // MAIN CONTENT
    // =========================================================

    public ScrollPane getContent() {

        // =====================================================
        // MAIN PAGE
        // =====================================================

        VBox root = new VBox(20);

        root.setPadding(
                new Insets(25, 38, 40, 38)
        );

        root.setStyle(
                "-fx-background-color: #080E18;"
        );


        // =====================================================
        // HEADING
        // =====================================================

        Label title = new Label(
                "Analytics"
        );

        title.setStyle(
                "-fx-text-fill: #F8FAFC;" +
                "-fx-font-size: 32px;" +
                "-fx-font-weight: bold;"
        );


        Label subtitle = new Label(
                "Deep insights across privacy, uploads, sessions and users."
        );

        subtitle.setStyle(
                "-fx-text-fill: #94A3B8;" +
                "-fx-font-size: 14px;"
        );


        VBox heading = new VBox(
                4,
                title,
                subtitle
        );


        // =====================================================
        // STAT CARDS
        // =====================================================

        GridPane stats = new GridPane();

        stats.setHgap(15);

        stats.setVgap(15);


        VBox privacyScore = createStatCard(
                "AVG PRIVACY SCORE",
                "88.4",
                "+2.1 vs last month"
        );


        VBox uploads = createStatCard(
                "UPLOADS / DAY",
                "312",
                "+18%"
        );


        VBox sessions = createStatCard(
                "SESSIONS / DAY",
                "264",
                "+11%"
        );


        VBox users = createStatCard(
                "ACTIVE USERS",
                "984",
                "+7%"
        );


        stats.add(
                privacyScore,
                0,
                0
        );


        stats.add(
                uploads,
                1,
                0
        );


        stats.add(
                sessions,
                0,
                1
        );


        stats.add(
                users,
                1,
                1
        );


        GridPane.setHgrow(
                privacyScore,
                Priority.ALWAYS
        );

        GridPane.setHgrow(
                uploads,
                Priority.ALWAYS
        );

        GridPane.setHgrow(
                sessions,
                Priority.ALWAYS
        );

        GridPane.setHgrow(
                users,
                Priority.ALWAYS
        );


        // =====================================================
        // SESSIONS TREND
        // =====================================================

        VBox sessionsChartCard =
                createChartCard(
                        "Sessions trend"
                );


        CategoryAxis xAxis =
                new CategoryAxis();


        NumberAxis yAxis =
                new NumberAxis();


        xAxis.setLabel("");

        yAxis.setLabel("");


        xAxis.setTickLabelFill(
                Color.web("#718096")
        );


        yAxis.setTickLabelFill(
                Color.web("#718096")
        );


        LineChart<String, Number> lineChart =
                new LineChart<>(
                        xAxis,
                        yAxis
                );


        lineChart.setLegendVisible(
                false
        );


        lineChart.setAnimated(
                false
        );


        lineChart.setCreateSymbols(
                true
        );


        lineChart.setPrefHeight(
                300
        );


        lineChart.setStyle(
                "-fx-background-color: transparent;"
        );


        XYChart.Series<String, Number> sessionSeries =
                new XYChart.Series<>();


        sessionSeries.getData().add(
                new XYChart.Data<>(
                        "Feb",
                        180
                )
        );


        sessionSeries.getData().add(
                new XYChart.Data<>(
                        "Mar",
                        260
                )
        );


        sessionSeries.getData().add(
                new XYChart.Data<>(
                        "Apr",
                        220
                )
        );


        sessionSeries.getData().add(
                new XYChart.Data<>(
                        "May",
                        360
                )
        );


        sessionSeries.getData().add(
                new XYChart.Data<>(
                        "Jun",
                        440
                )
        );


        sessionSeries.getData().add(
                new XYChart.Data<>(
                        "Jul",
                        540
                )
        );


        lineChart.getData().add(
                sessionSeries
        );


        sessionsChartCard.getChildren().add(
                lineChart
        );


        // =====================================================
        // UPLOADS BY PURPOSE
        // =====================================================

        VBox purposeCard =
                createChartCard(
                        "Uploads by purpose"
                );


        CategoryAxis purposeX =
                new CategoryAxis();


        NumberAxis purposeY =
                new NumberAxis();


        purposeX.setTickLabelFill(
                Color.web("#718096")
        );


        purposeY.setTickLabelFill(
                Color.web("#718096")
        );


        BarChart<String, Number> purposeChart =
                new BarChart<>(
                        purposeX,
                        purposeY
                );


        purposeChart.setLegendVisible(
                false
        );


        purposeChart.setAnimated(
                false
        );


        purposeChart.setPrefHeight(
                300
        );


        XYChart.Series<String, Number> purposeSeries =
                new XYChart.Series<>();


        purposeSeries.getData().add(
                new XYChart.Data<>(
                        "Printing",
                        420
                )
        );


        purposeSeries.getData().add(
                new XYChart.Data<>(
                        "Scanning",
                        600
                )
        );


        purposeSeries.getData().add(
                new XYChart.Data<>(
                        "Form",
                        180
                )
        );


        purposeSeries.getData().add(
                new XYChart.Data<>(
                        "Verify",
                        130
                )
        );


        purposeSeries.getData().add(
                new XYChart.Data<>(
                        "Submit",
                        90
                )
        );


        purposeSeries.getData().add(
                new XYChart.Data<>(
                        "Other",
                        45
                )
        );


        purposeChart.getData().add(
                purposeSeries
        );


        purposeCard.getChildren().add(
                purposeChart
        );


        // =====================================================
        // PRIVACY DISTRIBUTION
        // =====================================================

        VBox privacyCard =
                createChartCard(
                        "Privacy score distribution"
                );


        PieChart pieChart =
                new PieChart();


        pieChart.setLegendVisible(
                false
        );


        pieChart.setLabelsVisible(
                true
        );


        pieChart.setPrefHeight(
                320
        );


        pieChart.getData().addAll(

                new PieChart.Data(
                        "Excellent 62",
                        62
                ),

                new PieChart.Data(
                        "Good 24",
                        24
                ),

                new PieChart.Data(
                        "Average 10",
                        10
                ),

                new PieChart.Data(
                        "Low 4",
                        4
                )
        );


        privacyCard.getChildren().add(
                pieChart
        );


        // =====================================================
        // USER GROWTH
        // =====================================================

        VBox growthCard =
                createChartCard(
                        "User growth"
                );


        CategoryAxis growthX =
                new CategoryAxis();


        NumberAxis growthY =
                new NumberAxis();


        growthX.setTickLabelFill(
                Color.web("#718096")
        );


        growthY.setTickLabelFill(
                Color.web("#718096")
        );


        BarChart<String, Number> growthChart =
                new BarChart<>(
                        growthX,
                        growthY
                );


        growthChart.setLegendVisible(
                false
        );


        growthChart.setAnimated(
                false
        );


        growthChart.setPrefHeight(
                320
        );


        XYChart.Series<String, Number> growthSeries =
                new XYChart.Series<>();


        growthSeries.getData().add(
                new XYChart.Data<>(
                        "Feb",
                        220
                )
        );


        growthSeries.getData().add(
                new XYChart.Data<>(
                        "Mar",
                        310
                )
        );


        growthSeries.getData().add(
                new XYChart.Data<>(
                        "Apr",
                        280
                )
        );


        growthSeries.getData().add(
                new XYChart.Data<>(
                        "May",
                        420
                )
        );


        growthSeries.getData().add(
                new XYChart.Data<>(
                        "Jun",
                        510
                )
        );


        growthSeries.getData().add(
                new XYChart.Data<>(
                        "Jul",
                        620
                )
        );


        growthChart.getData().add(
                growthSeries
        );


        growthCard.getChildren().add(
                growthChart
        );


        // =====================================================
        // ADD EVERYTHING TO ROOT
        // =====================================================

        root.getChildren().addAll(

                heading,

                stats,

                sessionsChartCard,

                purposeCard,

                privacyCard,

                growthCard
        );


        // =====================================================
        // SCROLL PANE
        // =====================================================

        ScrollPane scrollPane =
                new ScrollPane();


        scrollPane.setContent(
                root
        );


        // =====================================================
        // SCROLL SETTINGS
        // =====================================================

        scrollPane.setFitToWidth(
                true
        );


        scrollPane.setHbarPolicy(
                ScrollPane.ScrollBarPolicy.NEVER
        );


        scrollPane.setVbarPolicy(
                ScrollPane.ScrollBarPolicy.AS_NEEDED
        );


        // =====================================================
        // SCROLL PANE STYLE
        // =====================================================

        scrollPane.setStyle(
                "-fx-background-color: #080E18;" +
                "-fx-border-color: transparent;"
        );


        return scrollPane;
    }


    // =========================================================
    // STAT CARD
    // =========================================================

    private VBox createStatCard(
            String title,
            String value,
            String change
    ) {

        VBox card = new VBox(7);


        card.setPadding(
                new Insets(20)
        );


        card.setPrefHeight(
                115
        );


        card.setStyle(
                "-fx-background-color: #111927;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #202B3C;" +
                "-fx-border-radius: 20;"
        );


        Label titleLabel =
                new Label(title);


        titleLabel.setStyle(
                "-fx-text-fill: #718096;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );


        Label valueLabel =
                new Label(value);


        valueLabel.setStyle(
                "-fx-text-fill: #F8FAFC;" +
                "-fx-font-size: 27px;" +
                "-fx-font-weight: bold;"
        );


        Label changeLabel =
                new Label(change);


        changeLabel.setStyle(
                "-fx-text-fill: #06C993;" +
                "-fx-font-size: 10px;" +
                "-fx-font-weight: bold;"
        );


        HBox.setHgrow(
                card,
                Priority.ALWAYS
        );


        card.getChildren().addAll(
                titleLabel,
                valueLabel,
                changeLabel
        );


        return card;
    }


    // =========================================================
    // CHART CARD
    // =========================================================

    private VBox createChartCard(
            String title
    ) {

        VBox card = new VBox();


        card.setStyle(
                "-fx-background-color: #111927;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #202B3C;" +
                "-fx-border-radius: 20;"
        );


        Label titleLabel =
                new Label(title);


        titleLabel.setStyle(
                "-fx-text-fill: #E2E8F0;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;"
        );


        HBox header =
                new HBox(
                        titleLabel
                );


        header.setPadding(
                new Insets(18, 20, 16, 20)
        );


        header.setStyle(
                "-fx-border-color: #202B3C;" +
                "-fx-border-width: 0 0 1 0;"
        );


        card.getChildren().add(
                header
        );


        return card;
    }
}