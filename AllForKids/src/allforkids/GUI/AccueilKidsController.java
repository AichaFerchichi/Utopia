/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class AccueilKidsController implements Initializable {
@FXML 
private AnchorPane AnchorPane1;
@FXML 
private Label lb1;
@FXML 
private Label lb2;
@FXML 
private Label lb3;
@FXML 
private Label lb4;
@FXML 
private Label lb5;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        // TODO 
      
    }
     public void changercolor2()
    {
   
    lb2.setTextFill(Color.BLACK);
    }
     public void changercolor3()
    {
   
    lb2.setTextFill(Color.RED);
    }
   
    public void changercolor()
    {
    lb1.setTextFill(Color.RED);
   
    
    }
    public void changercolor4()
    {
    lb1.setTextFill(Color.BLACK);
   
    
    }
    
    public void afficher() throws IOException
    { 
    AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeGardJard.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    public void afficher2() throws IOException
    {  
    AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeGardJard.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    public void afficher3() throws IOException
    {  
    AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeGardJard.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    public void afficher4() throws IOException
    {  
    AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeGardJard.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    public void afficher5() throws IOException
    { 
    AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeGardJard.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
}
