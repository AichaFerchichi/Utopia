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
import javafx.scene.shape.Circle;

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
    private ToggleButton retire;
    @FXML
    private ImageView retire1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/enfant.jpg"));
        /*final Circle clip = new Circle(100, 50, 50);
        imgView.setClip(clip); */
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
    private void afficherApprouver(MouseEvent event)throws IOException{
        
            bt2.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListviewApprouver.fxml"));
           bt2.getChildren().add(newLoadedPane);
  
    }
     
    private void changer2(ActionEvent event) {
       
        imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/enfant.jpg"));
         imgView1.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/garderie.jpg"));
         imgView2.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/children-4.jpg"));
     bt1.setDisable(true);
     bt.setDisable(false);
    }
    private void changer1(ActionEvent event) {
       
          imgView.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/1.jpg"));
         imgView1.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/2.jpg"));
   imgView2.setImage(new Image("file:/Users/MacBook/Desktop/3A5/PIDEV/AllForKids/Utopia/AllForKids/src/allforkids/GUI/img/3.jpg"));
    bt1.setDisable(false);
     bt.setDisable(true);
    }

    @FXML
    private void retire(ActionEvent event) {
    }

    @FXML
    private void changer2(MouseEvent event) {
    }
    

    @FXML
    private void afficher2(ActionEvent event) throws IOException {
         bt2.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionUser.fxml"));
           bt2.getChildren().add(newLoadedPane);
    }

<<<<<<< HEAD
    @FXML
    private void changer2(MouseEvent event) {
        
    }
=======
>>>>>>> 170a8157c3eb983af7d0d03f65717ff4b9959425

    
}
