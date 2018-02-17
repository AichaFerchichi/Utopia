package allforkids.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class AccueilAdminController implements Initializable{

    @FXML
    private AnchorPane bt2;
    @FXML
    private ImageView imgView;
    @FXML
    private AnchorPane AnchorPane2;
    @FXML
    private ToggleButton demandes;
    @FXML
    private ToggleButton bt;
    @FXML
    private ToggleButton bt1;
    @FXML
    private ImageView imgView1;
    @FXML
    private ImageView imgView2;
    @FXML
    private TextField id_user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
    /*@FXML
    public void changerColor()
     {
    lb1.setTextFill(Color.RED);
        lb2.setTextFill(Color.RED);
    lb3.setTextFill(Color.RED);

     }
    @FXML
      public void changerColor2()
     {
    lb1.setTextFill(Color.BLACK);
    lb2.setTextFill(Color.BLACK);
    lb3.setTextFill(Color.BLACK);
     }
    */

    @FXML
    private void afficher1(ActionEvent event)throws IOException{
        
            bt2.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ApprouverDemande.fxml"));
           bt2.getChildren().add(newLoadedPane);

        
    }

}
