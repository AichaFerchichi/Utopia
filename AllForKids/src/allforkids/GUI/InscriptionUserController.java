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
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class InscriptionUserController implements Initializable {
@FXML
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> ol = FXCollections.observableArrayList();
        ol.add("parent") ; 
        ol.add("enseignant") ; 
        ol.add("babysitter") ; 
        ol.add("Livreur") ; 
       comBox.setItems(ol);
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
         cin.setDisable(false);
        nom.setDisable(false);
        prenom.setDisable(false);
        pseudo.setDisable(false);
        mdp.setDisable(false);
        mdp2.setDisable(false);
        adresse.setDisable(false);
        email.setDisable(false);
        montant.setDisable(false);
    num_tel.setDisable(true);
      club.setDisable(true);
      comBox.getSelectionModel().selectFirst();
        
    }    
    
    public void inscrire()
    {
        String i=comBox.getValue().toString();
        System.out.println(i);
    if(comBox.getValue().toString().equals("parent")){
        
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
     if(comBox.getValue().toString().equals("enseignant")){
        num_tel.setDisable(true);
        club.setDisable(false);
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
     if(comBox.getValue().toString().equals("babysitter")){
        club.setDisable(true);
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
    
    
}
