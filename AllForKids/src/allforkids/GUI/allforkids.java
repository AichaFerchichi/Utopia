/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author user
 */
public class allforkids extends Application{

@Override
    public void start(Stage stage) throws IOException {

   //     Parent root = FXMLLoader.load(getClass().getResource("ListeProduits.fxml"));

        //Parent root = FXMLLoader.load(getClass().getResource("AccueilKids.fxml"));

       Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));

//                Parent root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));
<<<<<<< HEAD
//Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
//Parent root = FXMLLoader.load(getClass().getResource("acceuilkids2.fxml"));
=======

//Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));

//Parent root = FXMLLoader.load(getClass().getResource("acceuilkids2.fxml"));

>>>>>>> 1bff410f93deb3069391b461572bc42a8240582b


        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
     public static void main(String[] args) {
        launch(args);
        
    }

    
}

