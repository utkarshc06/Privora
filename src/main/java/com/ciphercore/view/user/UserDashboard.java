package com.ciphercore.view.user;

import com.ciphercore.view.landing.HomePage;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class UserDashboard {

    private Scene xeroxdashboardScene;

    public Scene getXeroxDashboardScene(Runnable rd){

         Label l = new Label("XEROX DASHBOARD");
        l.setStyle("-fx-fill:black; -fx-font-weight:bold; -fx-font-size:60px;");

        Button bk = new Button("BACK TO LOGIN ");
        bk.setStyle("-fx-background-color:BLACK; -fx-fill:white; -fx-font-weight:bold; -fx-font-size:20px;");

        bk.setOnAction(e->{
            rd.run();              // home chya runnable ch rhp ne home chi run -> backtohome
        });

        VBox vb = new VBox(30,l,bk);
        vb.setAlignment(Pos.CENTER);

        Scene sc = new Scene(vb,1300,750);
        xeroxdashboardScene = sc;

        HomePage.homeStage.setScene(xeroxdashboardScene);


        
        return xeroxdashboardScene;


    }
    
}