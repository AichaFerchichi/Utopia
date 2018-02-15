/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Babysitter;
import allforkids.entite.Enseignant;
import allforkids.entite.Parent;
import allforkids.service.BabysitterService;
import allforkids.service.EnseignantService;
import allforkids.service.ParentService;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class InscriptionUserController implements Initializable {
    private ComboBox comBox;
@FXML
    private TextField nom;
@FXML
    private TextField prenom;
@FXML
    private TextField pseudo;
@FXML
    private TextField mdp;
@FXML
    private TextField mdp2;
@FXML
    private TextField adresse;
@FXML
    private TextField num_tel;
@FXML
    private TextField email;
@FXML
    private TextField club;
@FXML
    private TextField cin;
@FXML
    private TextField montant;
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private Button btretour;
    @FXML
    private RadioButton Renseignant;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton Rparent;
    @FXML
    private RadioButton Rbabysitter;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
        ToggleGroup group = new ToggleGroup();
    RadioButton Renseignant = new RadioButton("select first");
   Renseignant.setToggleGroup(group);
    Renseignant.setSelected(true);
    RadioButton Rparent = new RadioButton("select second");
    Rparent.setToggleGroup(group);
    group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
         @Override
    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

         if (group.getSelectedToggle() != null) {

             System.out.println(group.getSelectedToggle().getUserData().toString());
         /*cin.setDisable(true);
        nom.setDisable(true);
        prenom.setDisable(true);
        pseudo.setDisable(true);
        mdp.setDisable(true);
        mdp2.setDisable(true);
        adresse.setDisable(true);
        email.setDisable(true);
        montant.setDisable(true);
    num_tel.setDisable(true);
      club.setDisable(true);*/
        
      //comBox.getSelectionModel().selectFirst();
         }

     } 
});
    } 
     @FXML
    public void afficher(){
     if(Rparent.isSelected()){
         
    num_tel.setDisable(true);
      club.setDisable(true);
      montant.setDisable(false);}
     
     else if(Renseignant.isSelected())
    {
     num_tel.setDisable(true);
        club.setDisable(false);
        montant.setDisable(false);
    }
      else if(Rbabysitter.isSelected()){
          
        montant.setDisable(true);
     num_tel.setDisable(false);
      club.setDisable(true);
      
      }
    }
    @FXML
    public void inscrire()
    {
        
    if(Rparent.isSelected()){
         
      String m2=mdp2.getText();
      String m=mdp.getText();
      if(m.equals(m2)){
      Parent p=new Parent(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),
      email.getText(),adresse.getText(),Float.parseFloat(montant.getText()));
      ParentService ps= new ParentService();
      ps.insert(p);
      cin.clear();
      nom.clear();
      prenom.clear();
      pseudo.clear();
      mdp.clear();
      mdp2.clear();
      adresse.clear();
      email.clear();
      club.clear();
      num_tel.clear();
      num_tel.setDisable(false);
      club.setDisable(false);
      afficher();
    }
      else {Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Inscription");
            alert.setHeaderText("Vérifiez votre mot de passe");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {}
    mdp.clear();
    mdp2.clear();
    
    }
    
    }
        else if(Renseignant.isSelected()){
        
      String m2=mdp2.getText();
      String m=mdp.getText();
      if(m.equals(m2)){
      Enseignant p=new Enseignant (Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),
      email.getText(),Float.parseFloat(montant.getText()),club.getText());
      EnseignantService ps= new EnseignantService();
      ps.insert(p);
      cin.clear();
      nom.clear();
      prenom.clear();
      pseudo.clear();
      mdp.clear();
      mdp2.clear();
      adresse.clear();
      email.clear();
      club.clear();
      num_tel.clear();
       num_tel.setDisable(false);
       afficher();
    }
      else {Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Inscription");
            alert.setHeaderText("Vérifiez votre mot de passe");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {}
    mdp.clear();
    mdp2.clear();
    
    }
    
    }
     else if(Rbabysitter.isSelected()){
       
      String m2=mdp2.getText();
      String m=mdp.getText();
      if(m.equals(m2)){
      Babysitter p=new Babysitter(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),
      email.getText(),adresse.getText(),Integer.parseInt(num_tel.getText()));
      BabysitterService ps= new BabysitterService();
      ps.insert(p);
      cin.clear();
      nom.clear();
      prenom.clear();
      pseudo.clear();
      mdp.clear();
      mdp2.clear();
      adresse.clear();
      email.clear();
      club.clear();
      num_tel.clear();
      club.setDisable(false);
      afficher();
              
    }
      else {Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Inscription");
            alert.setHeaderText("Vérifiez votre mot de passe");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {}
    mdp.clear();
    mdp2.clear();
    
    }
    
    }
    
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    }
    
    

