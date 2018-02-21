/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Babysitter;
import allforkids.entite.Enseignant;
import allforkids.entite.Evaluation;
import allforkids.entite.Garderie;
import allforkids.entite.Parent;
import allforkids.entite.ProprietaireG;
import allforkids.service.BabysitterService;
import allforkids.service.EnseignantService;
import allforkids.service.EvaluationService;
import allforkids.service.GarderieService;
import allforkids.service.ParentService;
import allforkids.service.ProprietaireGService;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import static javafx.scene.input.KeyCode.T;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class GestionUserController implements Initializable {
@FXML
private RadioButton Renseignant;
@FXML
private RadioButton Rparent;

@FXML
    private AnchorPane AnchorPane1;
 @FXML
    private TableView table;
 @FXML
    private TableColumn Cid_user;
 @FXML
    private TableColumn Ccin;
    @FXML
    private TableColumn Cnom;
    @FXML
    private TableColumn Cprenom;
    @FXML
    private TableColumn Cpseudo;
    @FXML
    private TableColumn Cmdp;
   @FXML
    private TableColumn Cemail;
    @FXML
    private TableColumn Cadresse;
    @FXML
    private TableColumn Cmontant;
    @FXML
    private TableColumn Cnom_club;
    @FXML
    private TableColumn Cnum_tel;
    @FXML
    private TableColumn Ctype;
     @FXML
    private TextField entrer;
    @FXML
    private TextField nom;
    @FXML
    private TextField  cin;
    @FXML
    private TextField  num_tel;
    @FXML
    private TextField  prenom;
    @FXML
    private TextField  nom_club;
    @FXML
    private TextField  adresse;
    @FXML
    private TextField  email;
    @FXML
    private TextField  mdp;
    @FXML
    private TextField  pseudo;
    @FXML
    private TextField  montant;
    @FXML
    private TextField id_user;
     @FXML
    private Button btn1;
    @FXML
    private Label lbTitulo1;
    @FXML
    private ToggleGroup menu;
    @FXML
    private ToggleGroup group;
    @FXML
    private RadioButton Babysitter;
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
    private Button btretour;
    @FXML
    private RadioButton RpropG;
    
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
ToggleGroup group = new ToggleGroup();
         if (group.getSelectedToggle() != null) {

             System.out.println(group.getSelectedToggle().getUserData().toString());
             // Do something here with the userData of newly selected radioButton

         }

     } 
});
    }    
    @FXML
    public void afficher()
    {
    if(Rparent.isSelected())
        
    {  
        cin.setDisable(false);
        adresse.setDisable(false);
       montant.setDisable(false);
       nom_club.setDisable(true);
       num_tel.setDisable(true);
                    Cnom_club.setVisible(false);
              Cnum_tel.setVisible(false);
               Cmontant.setVisible(true);
               Ccin.setVisible(true);
               Cnom.setVisible(true);
          Cprenom.setVisible(true);
          Cadresse.setVisible(true);
        ParentService ps=new ParentService();
    
         table.setItems(null);
                table.setItems(ps.getAll());
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Ccin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          
        Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
              Cadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
              Cmontant.setCellValueFactory(new PropertyValueFactory<>("montant"));
             table.setPrefWidth(689);
              //table.setPrefHeight(552);
//False les champs de saisie
       cin.setVisible(true);
       nom.setVisible(true);
       prenom.setVisible(true);
       pseudo.setVisible(true);
       mdp.setVisible(true);
       email.setVisible(true);
       adresse.setVisible(true);
       montant.setVisible(true);
       nom_club.setVisible(true);
       num_tel.setVisible(true);
       //les labels false
       Lcin.setVisible(true);
       Lnom.setVisible(true);
       Lprenom.setVisible(true);
       Lpseudo.setVisible(true);
       Lmdp.setVisible(true);
       Lemail.setVisible(true);
       Ladresse.setVisible(true);
       Lmontant.setVisible(true);
       Lnom_club.setVisible(true);
       Lnum_tel.setVisible(true);
             
      
                }
    else if(Renseignant.isSelected())
    {
         // table.setPrefWidth(636);
            //  table.setPrefHeight(552);
        EnseignantService ps=new EnseignantService();
        cin.setDisable(false);
    montant.setDisable(false);
    adresse.setDisable(true);
    nom_club.setDisable(false);
    num_tel.setDisable(true);
    nom.setDisable(false);
    prenom.setDisable(false);
         table.setItems(null);
         Cnom_club.setVisible(true);
        Cadresse.setVisible(false);
       Cnum_tel.setVisible(false);
      Cmontant.setVisible(true);
       Ccin.setVisible(true);
       Cnom.setVisible(true);
        Cprenom.setVisible(true);
                table.setItems(ps.getAll());
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Ccin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
             
              Cnom_club.setCellValueFactory(new PropertyValueFactory<>("nom_club"));
              Cnum_tel.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
              table.setPrefWidth(689);
        //False les champs de saisie
       cin.setVisible(true);
       nom.setVisible(true);
       prenom.setVisible(true);
       pseudo.setVisible(true);
       mdp.setVisible(true);
       email.setVisible(true);
       adresse.setVisible(true);
       montant.setVisible(true);
       nom_club.setVisible(true);
       num_tel.setVisible(true);
       //les labels false
       Lcin.setVisible(true);
       Lnom.setVisible(true);
       Lprenom.setVisible(true);
       Lpseudo.setVisible(true);
       Lmdp.setVisible(true);
       Lemail.setVisible(true);
       Ladresse.setVisible(true);
       Lmontant.setVisible(true);
       Lnom_club.setVisible(true);
       Lnum_tel.setVisible(true);
             
      
     }
    else if(RpropG.isSelected())
    {
          table.setPrefWidth(270);
             // table.setPrefHeight(552);
        ProprietaireGService ps=new ProprietaireGService();
    montant.setDisable(true);
    adresse.setDisable(true);
    nom_club.setDisable(true);
    num_tel.setDisable(true);
    nom.setDisable(true);
    prenom.setDisable(true);
     cin.setDisable(true);
         table.setItems(null);
                table.setItems(ps.getAll());
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
             Cmontant.setVisible(false);
              Cnom_club.setVisible(false);
       Ccin.setVisible(false);
        Cnom.setVisible(false);
          Cprenom.setVisible(false);
           
        Cadresse.setVisible(false);
       Cnum_tel.setVisible(false);
       //False les champs de saisie
       cin.setVisible(true);
       nom.setVisible(true);
       prenom.setVisible(true);
       pseudo.setVisible(true);
       mdp.setVisible(true);
       email.setVisible(true);
       adresse.setVisible(true);
       montant.setVisible(true);
       nom_club.setVisible(true);
       num_tel.setVisible(true);
       //les labels false
       Lcin.setVisible(true);
       Lnom.setVisible(true);
       Lprenom.setVisible(true);
       Lpseudo.setVisible(true);
       Lmdp.setVisible(true);
       Lemail.setVisible(true);
       Ladresse.setVisible(true);
       Lmontant.setVisible(true);
       Lnom_club.setVisible(true);
       Lnum_tel.setVisible(true);
             
     

    }
    else if(Babysitter.isSelected())
    {
          table.setPrefWidth(689);
          btn1.setVisible(false);
        BabysitterService ps1=BabysitterService.getInstance();
    adresse.setDisable(false);
    nom_club.setDisable(true);
        montant.setDisable(true);
cin.setDisable(false);
    num_tel.setDisable(false);
     Cnom_club.setVisible(false);
        Cadresse.setVisible(true);
       Cnum_tel.setVisible(true);
       Ccin.setVisible(true);
        Cnom.setVisible(true);
          Cprenom.setVisible(true);
      
         table.setItems(null);
                table.setItems(ps1.getAll());
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Ccin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
                Cadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
Cnum_tel.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
                      Cmontant.setVisible(false);

       
       //False les champs de saisie
       cin.setVisible(false);
       nom.setVisible(false);
       prenom.setVisible(false);
       pseudo.setVisible(false);
       mdp.setVisible(false);
       email.setVisible(false);
       adresse.setVisible(false);
       montant.setVisible(false);
       nom_club.setVisible(false);
       num_tel.setVisible(false);
       //les labels false
       Lcin.setVisible(false);
       Lnom.setVisible(false);
       Lprenom.setVisible(false);
       Lpseudo.setVisible(false);
       Lmdp.setVisible(false);
       Lemail.setVisible(false);
       Ladresse.setVisible(false);
       Lmontant.setVisible(false);
       Lnom_club.setVisible(false);
       Lnum_tel.setVisible(false);
    }
    }
    @FXML
    public void ajouter()
    {if(Rparent.isSelected())
    {
    ParentService ps=new  ParentService();
         Parent p= new  Parent(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),email.getText(),adresse.getText(),Float.parseFloat(montant.getText()));
        ps.insert(p);
        nom.clear();
        cin.clear();
        nom.clear();
        prenom.clear();
        pseudo.clear();
        mdp.clear();
        email.clear();
        adresse.clear();
        montant.clear();
        afficher();}
    else if(Renseignant.isSelected())
    { EnseignantService ps=new  EnseignantService();
         Enseignant p= new  Enseignant(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),email.getText(),Float.parseFloat(montant.getText()),nom_club.getText());
        ps.insert(p);
        nom.clear();
        cin.clear();
        
        prenom.clear();
        pseudo.clear();
        mdp.clear();
        email.clear();
        adresse.clear();
        montant.clear();
        nom_club.clear();
        num_tel.clear();
        afficher();
    
    }
     else if(RpropG.isSelected())
    { ProprietaireGService ps=new  ProprietaireGService();
        ProprietaireG p= new  ProprietaireG(pseudo.getText(),mdp.getText(),email.getText());
        ps.insert(p);
        
        pseudo.clear();
        mdp.clear();
        email.clear();
        
        afficher();
    
    }}
    @FXML
    public void supprimer()
    {
        if(Rparent.isSelected())
    {
   
   TableView<Parent> table1=table;
     int i=table1.getSelectionModel().getSelectedItem().getId_user();
         System.out.println(i);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer ce parent");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     ParentService ps=new ParentService();
        
      ps.delete(i);
      } afficher();}
     
      else if(Renseignant.isSelected())
    {
   
   TableView<Enseignant> table1=table;
     int i=table1.getSelectionModel().getSelectedItem().getId_user();
         System.out.println(i);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer ce parent");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     EnseignantService ps=new EnseignantService();
        
      ps.delete(i);
      } afficher();}
        else if(RpropG.isSelected())
    {
        
   TableView<ProprietaireG> table1=table;
     int i=table1.getSelectionModel().getSelectedItem().getId_user();
         System.out.println(i);
         GarderieService gs=new GarderieService();
   Garderie g=gs.searchGard(i);
        //System.out.println(g);
   gs.delete(g.getId_garderie());
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer ce proprietaire");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     ProprietaireGService ps=new ProprietaireGService();
        
      ps.delete(i);
      } afficher();}
        else if(Babysitter.isSelected())
    {
   
   TableView<Babysitter> table1=table;
     int i=table1.getSelectionModel().getSelectedItem().getId_user();
         System.out.println(i);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer ce babysitter");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
    BabysitterService ps=BabysitterService.getInstance();
    
      ps.delete(i);
      
      } afficher();}
    }
    @FXML
    public void modifier(){
        if(Rparent.isSelected())
    {
    TableView<Parent> table1=table;
     btn1.setDisable(false);
          id_user.setText(Integer.toString(table1.getSelectionModel().getSelectedItem().getId_user()));
          cin.setText(Integer.toString(table1.getSelectionModel().getSelectedItem().getCin()));
     nom.setText(table1.getSelectionModel().getSelectedItem().getNom());
     prenom.setText(table1.getSelectionModel().getSelectedItem().getPrenom());
     pseudo.setText(table1.getSelectionModel().getSelectedItem().getPseudo());
     mdp.setText(table1.getSelectionModel().getSelectedItem().getMdp());
     email.setText(table1.getSelectionModel().getSelectedItem().getEmail());
     montant.setText(Float.toString(table1.getSelectionModel().getSelectedItem().getMontant()));
     adresse.setText(table1.getSelectionModel().getSelectedItem().getAdresse());
    }
        else if(Renseignant.isSelected())
    {
    TableView<Enseignant> table1=table;
     btn1.setDisable(false);
          id_user.setText(Integer.toString(table1.getSelectionModel().getSelectedItem().getId_user()));
          cin.setText(Integer.toString(table1.getSelectionModel().getSelectedItem().getCin()));
     nom.setText(table1.getSelectionModel().getSelectedItem().getNom());
     prenom.setText(table1.getSelectionModel().getSelectedItem().getPrenom());
     pseudo.setText(table1.getSelectionModel().getSelectedItem().getPseudo());
     mdp.setText(table1.getSelectionModel().getSelectedItem().getMdp());
     email.setText(table1.getSelectionModel().getSelectedItem().getEmail());
     montant.setText(Float.toString(table1.getSelectionModel().getSelectedItem().getMontant()));
     nom_club.setText(table1.getSelectionModel().getSelectedItem().getNom_club());
    }else if(RpropG.isSelected())
    {
    TableView<ProprietaireG> table1=table;
     btn1.setDisable(false);
          id_user.setText(Integer.toString(table1.getSelectionModel().getSelectedItem().getId_user()));
         
     pseudo.setText(table1.getSelectionModel().getSelectedItem().getPseudo());
     mdp.setText(table1.getSelectionModel().getSelectedItem().getMdp());
     email.setText(table1.getSelectionModel().getSelectedItem().getEmail());
     
    }
    
    }
    @FXML
     public void mod2()
     {if(Rparent.isSelected())
    {
     ParentService ps=new ParentService();
     Parent e=new Parent(Integer.parseInt(id_user.getText()),Integer.parseInt(cin.getText()),
     nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),email.getText(),adresse.getText(),Float.parseFloat(montant.getText()));
     ps.update(e);
     afficher();
            nom.clear();
        cin.clear();
        nom.clear();
        prenom.clear();
        pseudo.clear();
        mdp.clear();
        email.clear();
        adresse.clear();
        montant.clear(); }
      else if(Renseignant.isSelected()){
      EnseignantService ps=new EnseignantService();
     Enseignant e=new Enseignant(Integer.parseInt(id_user.getText()),Integer.parseInt(cin.getText()),
     nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),email.getText(),Float.parseFloat(montant.getText()),nom_club.getText());
     ps.update(e);
     afficher();
     nom.clear();
        cin.clear();
        nom.clear();
        prenom.clear();
        pseudo.clear();
        mdp.clear();
        email.clear();
        adresse.clear();
        montant.clear();
        nom_club.clear();
        num_tel.clear();
      }
     else if(RpropG.isSelected()){
      ProprietaireGService ps=new ProprietaireGService();
     ProprietaireG e=new ProprietaireG(Integer.parseInt(id_user.getText()),pseudo.getText(),mdp.getText(),email.getText());
     ps.update(e);
     afficher();
     
        pseudo.clear();
        mdp.clear();
        email.clear();
        
      }
     
     
     }
     
    @FXML
    public void rechercher()
{if(Rparent.isSelected())
    {
Parent e=null;
String nom=entrer.getText();
 ParentService ps=new ParentService();


        table.setItems(null);
                table.setItems(ps.getAllByName(nom));
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Ccin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          
        Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
              Cadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
              Cmontant.setCellValueFactory(new PropertyValueFactory<>("montant"));
             Cnom_club.setVisible(false);
              Cnum_tel.setVisible(false);
                Cadresse.setVisible(true);}
if(Renseignant.isSelected())
    {
Enseignant e=null;
String nom=entrer.getText();
 EnseignantService ps=new EnseignantService();


        table.setItems(null);
                table.setItems(ps.getAllByName(nom));
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Ccin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
              Cmontant.setCellValueFactory(new PropertyValueFactory<>("montant"));
              Cnom_club.setCellValueFactory(new PropertyValueFactory<>("nom_club"));
        Cnom_club.setVisible(true);
        Cadresse.setVisible(false);
       Cnum_tel.setVisible(false);}

               if(entrer.getText().isEmpty()){
              afficher();
              }
               if(RpropG.isSelected())
    {
ProprietaireG e=null;
String nom=entrer.getText();
 ProprietaireGService ps=new ProprietaireGService();


        table.setItems(null);
                table.setItems(ps.getAllByName(nom));
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
             Cmontant.setVisible(false);
              Cnom_club.setVisible(false);
       Ccin.setVisible(false);
        Cnom.setVisible(false);
          Cprenom.setVisible(false);
           
        Cadresse.setVisible(false);
       Cnum_tel.setVisible(false);}

               if(entrer.getText().isEmpty()){
              afficher();
              }
if(Babysitter.isSelected())
    {
Babysitter e=null;
String nom=entrer.getText();
 BabysitterService ps2=BabysitterService.getInstance();


        table.setItems(null);
                table.setItems(ps2.getbyPseudo1(nom));
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Ccin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
                Cadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        Cnom_club.setVisible(true);
        Cadresse.setVisible(false);
       Cnum_tel.setVisible(false);}

               if(entrer.getText().isEmpty()){
              afficher();
              }}

   

    @FXML
    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Acceuilkids2.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }

    

              

  
}
