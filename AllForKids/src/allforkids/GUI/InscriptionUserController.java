/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import static allforkids.GUI.AuthentificationController.LoggedParent;
import allforkids.entite.Babysitter;
import allforkids.entite.Enfant;
import allforkids.entite.Enseignant;
import allforkids.entite.Garderie;
import allforkids.entite.Parent;
import allforkids.service.BabysitterService;
import allforkids.service.EnfantService;
import allforkids.service.EnseignantService;
import allforkids.service.GarderieService;
import allforkids.service.ParentService;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class InscriptionUserController implements Initializable {
     @FXML
private AnchorPane AnchorPane1;
    @FXML
    private RadioButton Renseignant;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton Rparent;
    @FXML
    private RadioButton Rbabysitter;
    @FXML
    private Label Lcin;
    @FXML
    private Label Lnom;
    @FXML
    private Label Lprenom;
    @FXML
    private Label Lpseudo;
    @FXML
    private Label Lmdp;
    @FXML
    private Label Lemail;
    @FXML
    private Label Ladresse;
    @FXML
    private Label Lmontant;
    @FXML
    private Label Lnom_club;
    @FXML
    private Label Lnum_tel;
    @FXML
    private TextField club;
    @FXML
    private TextField cin;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField pseudo;
    @FXML
    private TextField mdp;
    @FXML
    private TextField email;
    @FXML
    private TextField adresse;
    @FXML
    private TextField montant;
    @FXML
    private TextField num_tel;
    
  
    @FXML
    private TextField prenom_enfant;
    @FXML
    private TextField age;
    @FXML
    private TextField nom_enfant;
   
    @FXML
    private Label Lnum_tel1;
    @FXML
    private Label Lnum_tel2;
    @FXML
    private Label Lnum_tel3;
    @FXML
    private Label Lnum_tel4;
    @FXML
    private Label Lnum_tel11;
    @FXML
    private Label Lnum_tel12;
    @FXML
    private RadioButton Rgarderie;
    @FXML
    private ToggleGroup etude;
    @FXML
    private RadioButton Rjardin;
     public static Enfant LoggedEnfant;
      public static Parent LoggedParent;
    @FXML
    private AnchorPane an2;
    @FXML
    private AnchorPane an3;
    @FXML
    private Button btV;
    @FXML
    private Button btP;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            // TODO
            afficher();
        } catch (IOException ex) {
            Logger.getLogger(InscriptionUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ToggleGroup group = new ToggleGroup();
    RadioButton Renseignant = new RadioButton("select first");
   Renseignant.setToggleGroup(group);
    Renseignant.setSelected(true);
    RadioButton Rparent = new RadioButton("select second");
    Rparent.setToggleGroup(group);
    group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
         @Override
    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
ToggleGroup group = new ToggleGroup();
         if (group.getSelectedToggle() != null) {

             System.out.println(group.getSelectedToggle().getUserData().toString());
             // Do something here with the userData of newly selected radioButton

         }

     } 
});
    ToggleGroup etude = new ToggleGroup();
    RadioButton Rgarderie = new RadioButton("select first");
   Rgarderie.setToggleGroup(etude);
   Rgarderie.setSelected(true);
    RadioButton Rjardin = new RadioButton("select second");
    Rjardin.setToggleGroup(etude);
    etude.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
         @Override
    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {
ToggleGroup etude = new ToggleGroup();
         if (etude.getSelectedToggle() != null) {

             System.out.println(etude.getSelectedToggle().getUserData().toString());
             // Do something here with the userData of newly selected radioButton

         }

     } 
});
    }    
     @FXML
    public void afficher() throws IOException{
     if(Rparent.isSelected()){
         
    num_tel.setDisable(true);
      club.setDisable(true);
      montant.setDisable(false);
     age.setDisable(false);
     prenom_enfant.setDisable(false);
     nom_enfant.setDisable(false);
    an2.setVisible(true);
    an3.setVisible(true);
     btV.setVisible(false);
      btP.setVisible(true);
       cin.clear();
      nom.clear();
      prenom.clear();
      pseudo.clear();
      mdp.clear();
      adresse.clear();
      email.clear();
      montant.clear();
      
     
     }
     
     if(Renseignant.isSelected())
    {
     num_tel.setDisable(true);
        club.setDisable(false);
        montant.setDisable(false);
        age.setDisable(true);
     prenom_enfant.setDisable(true);
     nom_enfant.setDisable(true);
         an2.setVisible(false);
    an3.setVisible(false);
    btV.setVisible(true);
     btP.setVisible(false);
    }
      if(Rbabysitter.isSelected()){
          
        montant.setDisable(true);
     num_tel.setDisable(false);
      club.setDisable(true);
      age.setDisable(true);
     prenom_enfant.setDisable(true);
     nom_enfant.setDisable(true);
      an2.setVisible(false);
    an3.setVisible(false);
     btV.setVisible(true);
      btP.setVisible(false);
      }
      
    }
    @FXML
    public void inscrire() throws IOException
    {
        
     if(Renseignant.isSelected()){
        
    Enseignant p=new Enseignant (Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),
      email.getText(),Float.parseFloat(montant.getText()),club.getText());
      EnseignantService ps= new EnseignantService();
      ps.insert(p);
      cin.clear();
      nom.clear();
      prenom.clear();
      pseudo.clear();
      mdp.clear();
     adresse.clear();
      email.clear();
      club.clear();
      num_tel.clear();
       num_tel.setDisable(false);
       afficher();
    
      
    
    }
     else if(Rbabysitter.isSelected()){
       
      
      Babysitter p=new Babysitter(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),
      email.getText(),adresse.getText(),Integer.parseInt(num_tel.getText()));
      BabysitterService ps= new BabysitterService();
      ps.insert(p);
      cin.clear();
      nom.clear();
      prenom.clear();
      pseudo.clear();
      mdp.clear();
     adresse.clear();
      email.clear();
      club.clear();
      num_tel.clear();
      club.setDisable(false);
      afficher();
              
    
      
    
    }
    
    }

    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    @FXML
    private void listegarderie(ActionEvent event) throws IOException {
        
        LoggedEnfant = new Enfant();
       
        LoggedEnfant.setNom(nom_enfant.getText());
        LoggedEnfant.setPrenom(prenom_enfant.getText());
        LoggedEnfant.setAge(Integer.parseInt(age.getText())); 
        System.out.println(LoggedEnfant.getNom());
      
         
      LoggedParent = new Parent();
        LoggedParent.setCin(Integer.parseInt(cin.getText()));
        LoggedParent.setNom(nom.getText());
        LoggedParent.setPrenom(prenom.getText());
         LoggedParent.setPseudo(pseudo.getText());
          LoggedParent.setMdp(mdp.getText());
           LoggedParent.setEmail(email.getText());
        LoggedParent.setMontant(Float.parseFloat(age.getText())); 
         LoggedParent.setAdresse(adresse.getText());
        System.out.println(LoggedParent.getNom());
        
        Parent p=new Parent(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),
      email.getText(),adresse.getText(),Float.parseFloat(montant.getText()));
      ParentService ps= new ParentService();
      ps.insert(p);
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListeGardJard.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
        
    }

}
    
    

