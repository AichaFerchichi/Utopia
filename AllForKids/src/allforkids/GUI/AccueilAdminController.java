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
import javafx.scene.image.Image;
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
    @FXML
    private ToggleButton utilisateur;
    @FXML
    private ImageView retire;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/enfant.jpg"));
         imgView1.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/garderie.jpg"));
         imgView2.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/children-4.jpg"));
    bt1.setDisable(true);
     bt.setDisable(false);
    }
    @FXML
    private void retirer(ActionEvent event) {
        AnchorPane2.setVisible(false);
        retire.setVisible(false);
    }
    
    @FXML
    private void changer2(ActionEvent event) {
       
        imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/enfant.jpg"));
         imgView1.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/garderie.jpg"));
         imgView2.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/children-4.jpg"));
     bt1.setDisable(true);
     bt.setDisable(false);
    }
    @FXML
    private void changer1(ActionEvent event) {
       
          imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/1.jpg"));
         imgView1.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/2.jpg"));
   imgView2.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/3.jpg"));
    bt1.setDisable(false);
     bt.setDisable(true);
    }
      
    @FXML
    private void afficher(ActionEvent event) {
       AnchorPane2.setVisible(true);
       retire.setVisible(true);
    }

    @FXML
    private void afficher1(ActionEvent event)throws IOException{
        
            bt2.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ApprouverDemande.fxml"));
           bt2.getChildren().add(newLoadedPane);

        
    }

    @FXML
    private void afficher2(ActionEvent event) throws IOException {
         bt2.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionUser.fxml"));
           bt2.getChildren().add(newLoadedPane);
        
    }

    @FXML
    private void changer2(MouseEvent event) {
    }

    
}
