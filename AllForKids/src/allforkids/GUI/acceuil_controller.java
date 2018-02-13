/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import javafx.scene.Parent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class acceuil_controller implements Initializable {

    @FXML
    private ToggleButton menu_babysitter;
    @FXML
    private ToggleButton Education;
    @FXML
    private ToggleGroup grupoMenus;
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private AnchorPane AnchorPane2;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
     @FXML
    private void menu_babysitter(ActionEvent event) {
        try {
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("OffreDemande.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

        } catch (IOException ex) {
            Logger.getLogger(acceuil_controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
        @FXML
    private void Education (ActionEvent event) {
        try {
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

        } catch (IOException ex) {
            Logger.getLogger(acceuil_controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
           
    }
    
    

