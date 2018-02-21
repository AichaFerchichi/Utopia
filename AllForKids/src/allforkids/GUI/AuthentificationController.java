/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import static allforkids.GUI.AuthentificationController.LoggedUser;
import allforkids.entite.Babysitter;
import allforkids.entite.Parent;
import allforkids.entite.ProprietaireG;
import allforkids.entite.User;
import allforkids.service.AdminService;
import static allforkids.service.AdminService.LoggedUser;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
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
    public TextField tfPseudo;
@FXML
    private PasswordField tfMdp;


public static Parent LoggedParent;
public static ProprietaireG LoggedProprietaireG;
public static Babysitter LoggedBabysitter;
public static User LoggedUser;
    @FXML
    private Button btn;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    
    @FXML
    public void Education() throws SQLException, IOException{
      
       AdminService ips = new AdminService();
       // System.out.println(ips.search(a));
       
       // System.out.println(tfPseudo.getText()+tfMdp.getText());
       String pseudo=tfPseudo.getText();
     String mdp=tfMdp.getText();
     User u=ips.Login(pseudo);
     
                  
   if (u.getMdp().equals(mdp)){
            System.out.println(pseudo);
                
             String type=  u.getType();
      System.out.println(type);
          if(type.equals("parent")){
              
                LoggedParent = new Parent();
                LoggedParent.setId_user(u.getId_user());
       System.out.println(u);
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
            

        

              }
          else if(type.equals("enseignant")){
           
    
        System.out.println(tfPseudo.getText());
       
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionEvaluation.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
         

    }
        
          else if(type.equals("admin")){
        System.out.println(tfPseudo.getText());
             
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilAdmin.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
         

       
    
    }
                    else if(type.equals("babysitter")){
                        LoggedBabysitter = new Babysitter();
                LoggedBabysitter.setId_user(u.getId_user());
       //System.out.println(u.getId_user());
       // System.out.println(tfPseudo.getText());
             
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilGeneral.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
         

       
    
    }
          
                    else if(type.equals("proprietaireg")){
                        LoggedProprietaireG = new ProprietaireG();
               LoggedProprietaireG.setId_user(u.getId_user());
       //System.out.println(u.getId_user());
       // System.out.println(tfPseudo.getText());
             
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionGarderie.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
       
    
    }
    }
   
    if (!u.getMdp().equals(mdp))
    {
    
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Authentification ");
            alert.setHeaderText("vérifiez vos parametres");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                 tfPseudo.clear();
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

    @FXML
    private void inscrire(ActionEvent event) throws IOException {
         AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("InscriptionUser.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

   
    
}
