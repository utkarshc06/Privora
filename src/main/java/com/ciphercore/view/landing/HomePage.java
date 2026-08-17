package com.ciphercore.view.landing;


import com.ciphercore.view.auth.LoginPage;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class HomePage extends Application {

        public static Stage homeStage;
        public static Scene homeScene;


        @Override
        public void start(Stage stage) throws Exception {

                homeStage = stage;

                // MAIN ROOT

                BorderPane root = new BorderPane();
                root.setStyle("-fx-background-color: linear-gradient(to bottom right, #020713, #06152D, #020713);");

                // TOP NAVIGATION BAR

                HBox navigationBar = new HBox();
                navigationBar.setPadding(new Insets(12, 28, 12, 28));
                navigationBar.setAlignment(Pos.CENTER_LEFT);
                navigationBar.setSpacing(15);

                // PRIVORA LOGO

                Circle logoCircle = new Circle(20);
                logoCircle.setFill(Color.web("#2196F3"));

                // Shield Image

                Image shieldImage = new Image(
                getClass().getResource("/assets/images/jslogo.jpeg").toExternalForm()
                );

                ImageView shieldView = new ImageView(shieldImage);
                shieldView.setFitWidth(28);
                shieldView.setFitHeight(28);
                shieldView.setPreserveRatio(true);

                // Shield container

                StackPane shieldBox = new StackPane(shieldView);
                shieldBox.setPrefSize(42, 42);
                shieldBox.setStyle("-fx-background-color: #1597F5;-fx-background-radius: 50%;-fx-effect: dropshadow(gaussian, rgba(21,151,245,0.7), 15, 0.5, 0, 0);");

                // Logo container

                StackPane logoBox = new StackPane();
                logoBox.getChildren().addAll(logoCircle, shieldBox);

                // PRIVORA TEXT

                Label brandName = new Label("PRIVORA");
                brandName.setStyle("-fx-text-fill: white;-fx-font-size: 20px;-fx-font-weight: bold;");

                Label brandTagline = new Label("PRIVACY CONTROLLED");
                brandTagline.setStyle("-fx-text-fill: #7D8BA3;-fx-font-size: 9px;-fx-letter-spacing: 1px;");


                VBox brandText = new VBox(0, brandName, brandTagline);
                HBox brand = new HBox(10, logoBox, brandText);
                brand.setAlignment(Pos.CENTER_LEFT);

                // RIGHT SIDE NAVIGATION

                Button signInTop = createNavButton("Sign in");
                Button getStartedTop = createBlueButton("Get started");

                signInTop.setOnAction(e -> {

                         System.out.println("Sign in clicked");
                       
                         Runnable rhp = new Runnable() {
                
                public void run(){
                    backtohome();
                };
            };
                LoginPage obj1 = new LoginPage();
            homeStage.setScene(obj1.getLoginScene(rhp));

                });

                HBox rightNavigation = new HBox(15, signInTop, getStartedTop);
                rightNavigation.setAlignment(Pos.CENTER_RIGHT);

                // Push right navigation to the right

                HBox.setHgrow(rightNavigation, Priority.ALWAYS);
                navigationBar.getChildren().addAll(brand, rightNavigation);

                // MAIN CONTENT

                VBox content = new VBox();
                content.setPadding(new Insets(35, 28, 80, 28));
                content.setSpacing(30);

                // SMALL BADGE

                Label badge = new Label("◈  Zero-trust document sharing");
                badge.setStyle("-fx-background-color: rgba(20,80,150,0.25);-fx-border-color: #24588F;-fx-border-radius: 20;-fx-background-radius: 20;-fx-text-fill: #C9D9EE;-fx-padding: 8 14 8 14;-fx-font-size: 12px;");

                // MAIN HEADING

                Label heading1 = new Label("Share sensitive docs.");
                heading1.setStyle("-fx-text-fill: #F2F6FC;-fx-font-size: 48px;-fx-font-weight: bold;");

                Label heading2 = new Label("Set the rules.");
                heading2.setStyle("-fx-text-fill: #2196F3;-fx-font-size: 48px;-fx-font-weight: bold;");

                Label heading3 = new Label("Stay in control.");
                heading3.setStyle("-fx-text-fill: #F2F6FC;-fx-font-size: 48px;-fx-font-weight: bold;");

                HBox heading = new HBox(12, heading1, heading2, heading3);
                heading.setAlignment(Pos.CENTER_LEFT);

                // DESCRIPTION

                Label description = new Label(
                                "PRIVORA scans, redacts and locks your documents with time\n" +
                                "limits, print caps and watermarks — so print shops see exactly\n" +
                                "what you allow, and nothing more."
                );

                description.setStyle("-fx-text-fill: #9AA9BE;-fx-font-size: 17px;-fx-line-spacing: 6px;");

                // MAIN BUTTONS

                Button loginButton = createBlueButton("Login  →");
                loginButton.setOnAction(e -> {

                        System.out.println("Login clicked");

                        Runnable rhp = new Runnable() {
                
                        public void run(){
                                 backtohome();
                };
            };
                
            LoginPage obj1 = new LoginPage();
            homeStage.setScene(obj1.getLoginScene(rhp));

                       
                });

                Button registerButton = createDarkButton("Register");
                Button aboutButton = createNavButton("About project");

                HBox actionButtons = new HBox(12, loginButton, registerButton, aboutButton);
                actionButtons.setAlignment(Pos.CENTER_LEFT);

                // STATISTICS CARDS

                VBox documentsCard = createStatCard(
                                "10k+",
                                "Documents\nsecured"
                );

                VBox centresCard = createStatCard(
                                "500+",
                                "Xerox centres"
                );

                VBox privacyCard = createStatCard(
                                "99.9%",
                                "Privacy score"
                );

                HBox statistics = new HBox(
                                15,
                                documentsCard,
                                centresCard,
                                privacyCard
                );

                statistics.setAlignment(Pos.CENTER_LEFT);

                // SECURE SESSION MAIN CARD

                VBox secureSession = new VBox();
                secureSession.setPadding(new Insets(28));
                secureSession.setSpacing(18);
                secureSession.setStyle("-fx-background-color: rgba(7,18,38,0.85);-fx-border-color: #1C2B45;-fx-border-radius: 20;-fx-background-radius: 20;");

                // SESSION GRADIENT CARD

                VBox sessionBox = new VBox();
                sessionBox.setPadding(new Insets(22));
                sessionBox.setSpacing(15);
                sessionBox.setStyle("-fx-background-color: linear-gradient(to right, #1767C9, #087A9B, #07875E);-fx-background-radius: 18;");

                // Session top row

                HBox sessionTop = new HBox();
                sessionTop.setAlignment(Pos.CENTER_LEFT);

                Label documentIcon = new Label("▣");
                documentIcon.setStyle("-fx-background-color: rgba(255,255,255,0.20);-fx-background-radius: 12;-fx-text-fill: white;-fx-font-size: 24px;-fx-padding: 8px 12px;");

                VBox sessionText = new VBox(2);

                Label secureText = new Label("Secure Session");
                secureText.setStyle("-fx-text-fill: #CDE4F5;-fx-font-size: 13px;");

                Label fileName = new Label("Aadhaar-Card.pdf");
                fileName.setStyle("-fx-text-fill: white;-fx-font-size: 16px;-fx-font-weight: bold;");

                sessionText.getChildren().addAll(secureText, fileName);

                HBox.setHgrow(sessionText, Priority.ALWAYS);

                Label liveLabel = new Label("Live");
                liveLabel.setStyle("-fx-background-color: rgba(255,255,255,0.25);-fx-background-radius: 15;-fx-text-fill: white;-fx-padding: 6 12 6 12;-fx-font-size: 12px;");

                sessionTop.getChildren().addAll(documentIcon, sessionText, liveLabel);

                // SESSION INFORMATION

                Label printLabel = new Label("Print 2/3");
                printLabel.setStyle("-fx-background-color: rgba(255,255,255,0.20);-fx-background-radius: 20;-fx-text-fill: white;-fx-padding: 10 18 10 18;-fx-font-size: 12px;");

                Label timeLabel = new Label("12:44 left");
                timeLabel.setStyle("-fx-background-color: rgba(255,255,255,0.20);-fx-background-radius: 20;-fx-text-fill: white;-fx-padding: 10 18 10 18;-fx-font-size: 12px;");

                Label watermarkLabel = new Label("Watermarked");
                watermarkLabel.setStyle("-fx-background-color: rgba(255,255,255,0.20);-fx-background-radius: 20;-fx-text-fill: white;-fx-padding: 10 18 10 18;-fx-font-size: 12px;");

                HBox sessionInfo = new HBox(
                                12,
                                printLabel,
                                timeLabel,
                                watermarkLabel
                );

                HBox.setHgrow(printLabel, Priority.ALWAYS);
                HBox.setHgrow(timeLabel, Priority.ALWAYS);
                HBox.setHgrow(watermarkLabel, Priority.ALWAYS);

                sessionBox.getChildren().addAll(
                                sessionTop,
                                sessionInfo
                );
                
                // LOWER FEATURE CARDS

                VBox aiCard = createFeatureCard(
                                "◉",
                                "AI Privacy Scan",
                                "Auto-detects Aadhaar, PAN, phone, email."
                );

                VBox ruleCard = createFeatureCard(
                                "♢",
                                "Rule-based Access",
                                "Print caps, expiry timers, watermarks."
                );

                HBox featureCards = new HBox(
                                15,
                                aiCard,
                                ruleCard
                );

                HBox.setHgrow(aiCard, Priority.ALWAYS);
                HBox.setHgrow(ruleCard, Priority.ALWAYS);

                secureSession.getChildren().addAll(
                                sessionBox,
                                featureCards
                );

                // PRIVACY SCORE

                Label privacyScore = new Label("Privacy score · 94/100");
                privacyScore.setStyle("-fx-background-color: #13D6A0;-fx-background-radius: 20;-fx-text-fill: white;-fx-padding: 10 16 10 16;-fx-font-size: 13px;-fx-effect: dropshadow(gaussian, rgba(19,214,160,0.5), 15, 0.4, 0, 0);");

                // SCORE CONTAINER

                StackPane scoreContainer = new StackPane();
                scoreContainer.setAlignment(Pos.CENTER_LEFT);
                scoreContainer.getChildren().add(privacyScore);

                // ADD EVERYTHING TO CONTENT

                content.getChildren().addAll(
                                badge,
                                heading,
                                description,
                                actionButtons,
                                statistics,
                                secureSession,
                                scoreContainer
                );

                // SCROLL PANE

                ScrollPane scrollPane = new ScrollPane();
                scrollPane.setContent(content);
                scrollPane.setFitToWidth(true);
                scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
                scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
                scrollPane.setStyle("-fx-background-color: transparent;-fx-background: transparent;");

                // ROOT

                root.setTop(navigationBar);
                root.setCenter(scrollPane);

                // SCENE

                homeScene = new Scene(root, 1300, 750);
                stage.setTitle("PRIVORA");
                stage.setScene(homeScene);
                stage.show();

                // PAGE ENTRANCE ANIMATION

                FadeTransition fade = new FadeTransition(
                                Duration.millis(900),
                                content
                );

                fade.setFromValue(0);
                fade.setToValue(1);
                fade.play();

                TranslateTransition slide = new TranslateTransition(
                                Duration.millis(800),
                                content
                );

                slide.setFromY(30);
                slide.setToY(0);
                slide.play();

        }

        // BLUE BUTTON

        private Button createBlueButton(String text) {

                Button button = new Button(text);
                button.setStyle("-fx-background-color: linear-gradient(to right, #2488F5, #12B5F4);-fx-background-radius: 20;-fx-text-fill: #06152D;-fx-font-size: 13px;-fx-font-weight: bold;-fx-padding: 10 20 10 20;-fx-effect: dropshadow(gaussian, rgba(18,181,244,0.45), 15, 0.4, 0, 5);");

                button.setOnMouseEntered(e -> {

                        button.setStyle("-fx-background-color: linear-gradient(to right, #36A0FF, #20C8FF);-fx-background-radius: 20;-fx-text-fill: white;-fx-font-size: 13px;-fx-font-weight: bold;-fx-padding: 10 20 10 20;-fx-effect: dropshadow(gaussian, rgba(18,181,244,0.9), 25, 0.6, 0, 5);");

                        ScaleTransition scale = new ScaleTransition(
                                        Duration.millis(120),
                                        button
                        );

                        scale.setToX(1.06);
                        scale.setToY(1.06);
                        scale.play();

                });

                button.setOnMouseExited(e -> {

                        button.setStyle("-fx-background-color: linear-gradient(to right, #2488F5, #12B5F4);-fx-background-radius: 20;-fx-text-fill: #06152D;-fx-font-size: 13px;-fx-font-weight: bold;-fx-padding: 10 20 10 20;-fx-effect: dropshadow(gaussian, rgba(18,181,244,0.45), 15, 0.4, 0, 5);");

                        ScaleTransition scale = new ScaleTransition(
                                        Duration.millis(120),
                                        button
                        );

                        scale.setToX(1);
                        scale.setToY(1);
                        scale.play();

                });

                return button;
        }

        // DARK BUTTON

        private Button createDarkButton(String text) {

                Button button = new Button(text);
                button.setStyle("-fx-background-color: rgba(2,7,19,0.9);-fx-border-color: #263653;-fx-border-radius: 20;-fx-background-radius: 20;-fx-text-fill: #DCE6F5;-fx-font-size: 13px;-fx-font-weight: bold;-fx-padding: 10 22 10 22;");

                button.setOnMouseEntered(e -> {

                        button.setStyle("-fx-background-color: rgba(20,80,150,0.35);-fx-border-color: #2196F3;-fx-border-radius: 20;-fx-background-radius: 20;-fx-text-fill: white;-fx-font-size: 13px;-fx-font-weight: bold;-fx-padding: 10 22 10 22;-fx-effect: dropshadow(gaussian, rgba(33,150,243,0.7), 20, 0.5, 0, 3);");

                        ScaleTransition scale = new ScaleTransition(
                                        Duration.millis(120),
                                        button
                        );

                        scale.setToX(1.06);
                        scale.setToY(1.06);
                        scale.play();

                });


                button.setOnMouseExited(e -> {

                        button.setStyle("-fx-background-color: rgba(2,7,19,0.9);-fx-border-color: #263653;-fx-border-radius: 20;-fx-background-radius: 20;-fx-text-fill: #DCE6F5;-fx-font-size: 13px;-fx-font-weight: bold;-fx-padding: 10 22 10 22;");

                        ScaleTransition scale = new ScaleTransition(
                                        Duration.millis(120),
                                        button
                        );

                        scale.setToX(1);
                        scale.setToY(1);
                        scale.play();

                });

                return button;
        }

        // NAVIGATION BUTTON

        private Button createNavButton(String text) {

                Button button = new Button(text);
                button.setStyle("-fx-background-color: transparent;-fx-text-fill: #D8E1EE;-fx-font-size: 13px;-fx-font-weight: bold;-fx-padding: 10 15 10 15;");

                button.setOnMouseEntered(e -> {

                        button.setStyle("-fx-background-color: rgba(33,150,243,0.15);-fx-background-radius: 15;-fx-text-fill: #4CB5FF;-fx-font-size: 13px;-fx-font-weight: bold;-fx-padding: 10 15 10 15;-fx-effect: dropshadow(gaussian, rgba(33,150,243,0.5), 15, 0.4, 0, 0);");

                });


                button.setOnMouseExited(e -> {

                        button.setStyle("-fx-background-color: transparent;-fx-text-fill: #D8E1EE;-fx-font-size: 13px;-fx-font-weight: bold;-fx-padding: 10 15 10 15;");

                });

                return button;
        }

        // STATISTICS CARD

        private VBox createStatCard(String number, String text) {

                Label numberLabel = new Label(number);
                numberLabel.setStyle("-fx-text-fill: #299BFF;-fx-font-size: 22px;-fx-font-weight: bold;");

                Label textLabel = new Label(text);
                textLabel.setStyle("-fx-text-fill: #9AA9BE;-fx-font-size: 12px;");

                VBox card = new VBox(
                                5,
                                numberLabel,
                                textLabel
                );

                card.setPadding(new Insets(16));
                card.setPrefWidth(125);
                card.setPrefHeight(88);
                card.setStyle("-fx-background-color: rgba(7,18,38,0.85);-fx-border-color: #1C2B45;-fx-border-radius: 15;-fx-background-radius: 15;");

                card.setOnMouseEntered(e -> {

                        card.setStyle("-fx-background-color: rgba(15,45,80,0.95);-fx-border-color: #2196F3;-fx-border-radius: 15;-fx-background-radius: 15;-fx-effect: dropshadow(gaussian, rgba(33,150,243,0.5), 20, 0.4, 0, 0);");

                        ScaleTransition scale = new ScaleTransition(
                                        Duration.millis(150),
                                        card
                        );

                        scale.setToX(1.05);
                        scale.setToY(1.05);
                        scale.play();

                });

                card.setOnMouseExited(e -> {

                        card.setStyle("-fx-background-color: rgba(7,18,38,0.85);-fx-border-color: #1C2B45;-fx-border-radius: 15;-fx-background-radius: 15;");

                        ScaleTransition scale = new ScaleTransition(
                                        Duration.millis(150),
                                        card
                        );

                        scale.setToX(1);
                        scale.setToY(1);
                        scale.play();

                });

                return card;
        }

        // FEATURE CARD

        private VBox createFeatureCard(
                        String icon,
                        String title,
                        String description) {

                Label iconLabel = new Label(icon);
                iconLabel.setStyle("-fx-background-color: #0BD3A2;-fx-background-radius: 12;-fx-text-fill: white;-fx-font-size: 18px;-fx-padding: 7px 10px 7px 10px;");

                Label titleLabel = new Label(title);
                titleLabel.setStyle("-fx-text-fill: #E9F0F8;-fx-font-size: 14px;-fx-font-weight: bold;");

                Label descriptionLabel = new Label(description);
                descriptionLabel.setStyle("-fx-text-fill: #8191A8;-fx-font-size: 11px;");

                VBox card = new VBox(
                                8,
                                iconLabel,
                                titleLabel,
                                descriptionLabel
                );

                card.setPadding(new Insets(16));
                card.setMinHeight(105);
                card.setStyle("-fx-background-color: rgba(4,14,31,0.85);-fx-border-color: #1C2B45;-fx-border-radius: 15;-fx-background-radius: 15;");

                card.setOnMouseEntered(e -> {

                        card.setStyle("-fx-background-color: rgba(10,35,60,0.95);-fx-border-color: #0BD3A2;-fx-border-radius: 15;-fx-background-radius: 15;-fx-effect: dropshadow(gaussian, rgba(11,211,162,0.4), 20, 0.4, 0, 0);");

                        ScaleTransition scale = new ScaleTransition(
                                        Duration.millis(150),
                                        card
                        );

                        scale.setToX(1.03);
                        scale.setToY(1.03);
                        scale.play();

                });

                card.setOnMouseExited(e -> {

                        card.setStyle("-fx-background-color: rgba(4,14,31,0.85);-fx-border-color: #1C2B45;-fx-border-radius: 15;-fx-background-radius: 15;");

                        ScaleTransition scale = new ScaleTransition(
                                        Duration.millis(150),
                                        card
                        );

                        scale.setToX(1);
                        scale.setToY(1);
                        scale.play();

                });

                return card;
        }

        public static void backtohome() {

                if (homeStage != null && homeScene != null) {

                        homeStage.setScene(homeScene);

                        System.out.println(
                                "RETURNED TO HOME PAGE"
                        );

                } else {

                        System.out.println(
                                "ERROR: HOME PAGE SCENE NOT AVAILABLE"
                        );
                }
        }

        public Scene getScene() {
            return homeScene;
        }

}