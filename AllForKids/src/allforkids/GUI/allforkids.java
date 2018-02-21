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
    //Parent root = FXMLLoader.load(getClass().getResource("ListViewTest.fxml")); 

            Parent root = FXMLLoader.load(getClass().getResource("CommandeLivraison.fxml")); 
            
  //  Parent root = FXMLLoader.load(getClass().getResource("ListeProduits.fxml"));
=======

//Parent root = FXMLLoader.load(getClass().getResource("ListviewApprouver.fxml"));
       // Parent root = FXMLLoader.load(getClass().getResource("AccueilKids.fxml"));
>>>>>>> 2da60c06d91094d6f3f019a43b9afca654d1b80a


       //Parent root = FXMLLoader.load(getClass().getResource("GestionUser.fxml"));

       //Parent root = FXMLLoader.load(getClass().getResource("MoyenTransport.fxml"));

//                Parent root = FXMLLoader.load(getClass().getResource("acceuil.fxml"));


    //   Parent root = FXMLLoader.load(getClass().getResource("AccueilGeneral.fxml"));

//Parent root = FXMLLoader.load(getClass().getResource("demandeTravail.fxml"));

//Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
//Parent root = FXMLLoader.load(getClass().getResource("acceuilkids2.fxml"));


Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
//Parent root = FXMLLoader.load(getClass().getResource("acceuilkids2.fxml"));
//Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));

//Parent root = FXMLLoader.load(getClass().getResource("acceuilkids2.fxml"));

<<<<<<< HEAD
=======
      



>>>>>>> 2da60c06d91094d6f3f019a43b9afca654d1b80a
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
     public static void main(String[] args) {
        launch(args);
        
    }

    
}
