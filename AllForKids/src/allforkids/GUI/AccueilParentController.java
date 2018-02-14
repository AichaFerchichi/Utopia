/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Parent;
import allforkids.entite.User;
import allforkids.service.AdminService;
import allforkids.service.ParentService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MacBook
 */

public class AccueilParentController implements Initializable {
@FXML
    private TextField id_user;
@FXML
    private AnchorPane AnchorPane1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher(AuthentificationController.LoggedParent);
    }    
    public void GarJard()
    {
     try {
        
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeGardJard.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void Evaluation()
    {
     try {
        
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Evaluation.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public void afficher(Parent u)
    {
        ParentService ius = new ParentService();
        System.out.println(u);
        id_user.setText(Integer.toString(u.getId_user()));
        System.out.println(id_user.getText());
        
    
    }

    
}
