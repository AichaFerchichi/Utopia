/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Garderie;
import allforkids.service.GarderieService;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class GestionGarderieController implements Initializable {
@FXML
    private Button btn1;
   @FXML
    private Button btliste;
      @FXML
    private TextField entrer;
     @FXML
    private TextField id_garderie;
     @FXML
    private TextField nom;
    @FXML
    private TextField adresse;
     @FXML
    private TextField num_tel;
    @FXML
    private TextArea description;
     
    public static Garderie LoggedUser;
 @FXML
    private AnchorPane AnchorPane1;
 @FXML
    private TableView<Garderie> table;
 @FXML
    private TableColumn<Garderie, Integer> Cid;
    @FXML
    private TableColumn<Garderie, String> Cnom;
    @FXML
    private TableColumn<Garderie, String> Cadresse;
    @FXML
    private TableColumn<Garderie, Integer> Cnum_tel;
    @FXML
    private TableColumn<Garderie, String> Cdescription;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherEva();
    }    
     public void afficherEva()
       {
           
            GarderieService ips = new GarderieService();
            table.setItems(null);
                table.setItems(ips.getAll());
 Cid.setCellValueFactory(new PropertyValueFactory<>("id_garderie"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          
        Cadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        Cnum_tel.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
              Cdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
             

       }
     public void ajouter()
     {
     GarderieService ps=new GarderieService();
        Garderie p= new Garderie(nom.getText(),adresse.getText(),Integer.parseInt(num_tel.getText()),description.getText());
        ps.insert(p);
        nom.clear();
        adresse.clear();
        num_tel.clear();
      
       description.clear();
        afficherEva();
        
     }
     public void supprimer()
     {
         int i=table.getSelectionModel().getSelectedItem().getId_garderie();
         System.out.println(i);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer cette garderie");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     GarderieService ps=new GarderieService();
        
      ps.delete(i);
      afficherEva();}
        
     }
     public void modifier()
     {
          btn1.setDisable(false);
          id_garderie.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getId_garderie()));
     nom.setText(table.getSelectionModel().getSelectedItem().getNom());
     adresse.setText(table.getSelectionModel().getSelectedItem().getAdresse());
     num_tel.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getNum_tel()));
     description.setText(table.getSelectionModel().getSelectedItem().getDescription());
     
    
     }
     public void mod2()
     {
     GarderieService ps=new GarderieService();
     Garderie e=new Garderie(Integer.parseInt(id_garderie.getText()),
     nom.getText(),adresse.getText(),Integer.parseInt(num_tel.getText()),description.getText());
     ps.update(e);
     afficherEva();
     }
public void rechercher()
{
Garderie e=null;
String nom=entrer.getText();
 GarderieService ps=new GarderieService();


        table.setItems(null);
                table.setItems(ps.getAllByName(nom));
 Cid.setCellValueFactory(new PropertyValueFactory<>("id_garderie"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
          
        Cadresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        Cnum_tel.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
              Cdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
              
              if(entrer.getText().isEmpty()){
              afficherEva();
              }}
              public void chargerListe()
              {
              LoggedUser = new Garderie();
        LoggedUser.setNom(table.getSelectionModel().getSelectedItem().getNom());
        LoggedUser.setId_garderie(table.getSelectionModel().getSelectedItem().getId_garderie());
                  System.out.println(LoggedUser.getNom());
                  System.out.println(LoggedUser.getId_garderie());
         try {
        
       
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionEnfant.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
            

        } catch (IOException ex) {
            Logger.getLogger(GestionGarderieController.class.getName()).log(Level.SEVERE, null, ex);
        } 
              }


    
}
