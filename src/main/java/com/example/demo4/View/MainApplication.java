package com.example.demo4.View;


import com.example.demo4.Controller.Login;
import com.example.demo4.Controller.Products;
import com.example.demo4.Models.data.DBConnection;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    Stage window;
    Scene scene1, scene2, scene3, scene4;
    @Override
    public void start(Stage primaryStage) {
        DBConnection db = new DBConnection();
        Products pro  = new Products();
        //Scene1
        Label labelStart =new Label("Welcome to DENDEN pharmacy");
        Button btnStart = new Button("Let's start");
        VBox layout1 = new VBox();
        layout1.setAlignment(Pos.BASELINE_CENTER);
        btnStart.setOnAction(actionEvent -> {
            window.setScene(scene2);
        });
        layout1.getChildren().addAll(labelStart,btnStart);
        layout1.setSpacing(10);
        scene1 = new Scene(layout1, 300, 300);
        Login lg = new Login();
        window = primaryStage;
        VBox vBox = new VBox();
        scene3 = new Scene(vBox);
        VBox vboxProducts = new VBox();
        pro.getProductsforCustomers(db,vboxProducts);
        scene4 = new Scene(vboxProducts);
        VBox loginPage = lg.login(window,scene1,scene3,db,scene4);
        pro.getProductsDisplay(db,vBox,window,scene1, scene3);
        scene2 = new Scene(loginPage);
        window.setScene(scene3);
        window.show();
    }
}
