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
<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("ListeProduits.fxml"));
=======
        Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
>>>>>>> 676447e17ddd27c1d1bf92e9d40259c80ef2c4a8
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
     public static void main(String[] args) {
        launch(args);
        
    }

    
}

