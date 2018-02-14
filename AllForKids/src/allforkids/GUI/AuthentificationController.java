/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Parent;
import allforkids.entite.User;
import allforkids.service.ParentService;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class AuthentificationController implements Initializable {

@FXML
    private AnchorPane AnchorPane1;
@FXML
    public TextField tfId;
@FXML
    private TextField tfMdp;

public static User LoggedUser;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void Education(){
       int a = Integer.parseInt(tfId.getText());
        ParentService ips = new ParentService();
       // System.out.println(ips.search(a));
       LoggedUser = new User();
        LoggedUser.setId_user(a);
        
   if( (ips.search(a).getId_user()==a)&&(ips.search(a).getMdp().equals(tfMdp.getText())))
    {//System.out.println(ips.search(a).getType());
       
        if(ips.search(a).getType().equals("parent")){
           
    try {
        System.out.println(tfId.getText());
       
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
            

        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
        else if(ips.search(a).getType().equals("enseignant")){
           
    try {
        System.out.println(tfId.getText());
       
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionEvaluation.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
         

        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
         else if(ips.search(a).getType().equals("admin")){
           
    try {
        System.out.println(tfId.getText());
       
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionUser.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
         

        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    
    }
    }
    else
   {Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Authentification ");
            alert.setHeaderText("vérifiez vos parametres");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                 tfId.clear();
        tfMdp.clear();
       
    }
   if (result.get() == ButtonType.CANCEL) {
       try {
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("accueil.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
   }
   }}

    
}
