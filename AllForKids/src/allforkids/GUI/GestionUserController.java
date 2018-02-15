/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Babysitter;
import allforkids.entite.Enseignant;
import allforkids.entite.Evaluation;
import allforkids.entite.Parent;
import allforkids.service.BabysitterService;
import allforkids.service.EnseignantService;
import allforkids.service.EvaluationService;
import allforkids.service.ParentService;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import javafx.scene.layout.AnchorPane;

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
             // Do something here with the userData of newly selected radioButton

         }

     } 
});
    }    
    @FXML
    public void afficher()
    {
    if(Rparent.isSelected())
        
    {  adresse.setDisable(false);
       montant.setDisable(false);
       nom_club.setDisable(true);
       num_tel.setDisable(true);
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
             Cnom_club.setVisible(false);
              Cnum_tel.setVisible(true);
               Cmontant.setVisible(false);
                
        
       
    }
    else if(Renseignant.isSelected())
    {
         
        EnseignantService ps=new EnseignantService();
    montant.setDisable(false);
    adresse.setDisable(true);
    nom_club.setDisable(false);
    num_tel.setDisable(true);
         table.setItems(null);
                table.setItems(ps.getAll());
 Cid_user.setCellValueFactory(new PropertyValueFactory<>("id_user"));
 Ccin.setCellValueFactory(new PropertyValueFactory<>("cin"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Cpseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
              Cmdp.setCellValueFactory(new PropertyValueFactory<>("mdp"));
              Cemail.setCellValueFactory(new PropertyValueFactory<>("email"));
              Cmontant.setCellValueFactory(new PropertyValueFactory<>("montant"));
              Cnom_club.setCellValueFactory(new PropertyValueFactory<>("nom_club"));
        Cnom_club.setVisible(false);
        Cadresse.setVisible(false);
       Cnum_tel.setVisible(true);
      Cmontant.setVisible(false);

    }
    else if(Babysitter.isSelected())
    {
         
        BabysitterService ps1=BabysitterService.getInstance();
    adresse.setDisable(false);
    nom_club.setDisable(true);
        montant.setDisable(true);

    num_tel.setDisable(false);
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

                      Cmontant.setVisible(false);

        Cnom_club.setVisible(false);
        Cadresse.setVisible(true);
       Cnum_tel.setVisible(true);
       
       
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
        nom.clear();
        prenom.clear();
        pseudo.clear();
        mdp.clear();
        email.clear();
        adresse.clear();
        montant.clear();
        nom_club.clear();
        num_tel.clear();
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

              

  
}
