/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Babysitter;
import allforkids.entite.demandetravail;
import allforkids.service.BabysitterService;
import allforkids.service.demande_travailService;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class demandeTravailController implements Initializable {

    @FXML
    private TextField tnom1;
    @FXML
    private TextField id_user;
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private TextField tadresse;
    @FXML
    private TextField tprenom;
    @FXML
    private TextField tnum_tel;
    @FXML
    private TextField tmail;
    @FXML
    private DatePicker tdate_naissance;
    private ComboBox<String> langue;
    @FXML
    private Button postuler;
    @FXML
    private ComboBox<String> tlangue;
    @FXML
    private TextField tetude;
    @FXML
    private TextField tposte;

 
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        try {     
        ObservableList<String> ol = FXCollections.observableArrayList();
        ol.add("Francais") ; 
        ol.add("Anglais") ; 
        ol.add("Espagnol") ;
        ol.add("Allemand") ;
        ol.add("Turc") ;
        ol.add("Japonais") ;
        ol.add("Italien") ;

        tlangue.setItems(ol);
            affichage();
            // T
            
            //   
        } catch (ParseException ex) {
            Logger.getLogger(demandeTravailController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    private void affichage() throws ParseException {
      
        BabysitterService as=BabysitterService.getInstance();
        Babysitter b=  as.search(AuthentificationController.LoggedBabysitter.getId_user());
        tnom1.setDisable(true);
        tadresse.setDisable(true);
        tdate_naissance.setDisable(true);
        tmail.setDisable(true);
        tnum_tel.setDisable(true);
        tprenom.setDisable(true);
     tnom1.setText(b.getNom());
    tadresse.setText(b.getAdresse());
  tmail.setText(b.getEmail());
   tnum_tel.setText(Integer.toString(b.getNum_tel()));
       tprenom.setText(b.getPrenom());
       tdate_naissance.getEditor().setText(b.getDate_naissance());
       
      

              
        
        
    

    

    
    }
    @FXML

    private void ajouter(ActionEvent event) throws ParseException{
           demande_travailService Gd=new demande_travailService();
        demandetravail demande=new demandetravail(tetude.getText(),tposte.getText(),tlangue.getValue());
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setHeaderText("produit ajouté, merci.");
       Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
     Gd.insert1(demande,AuthentificationController.LoggedBabysitter.getId_user());
        
    tetude.clear();
    tposte.clear();
    tlangue.setValue(null);
    
     
    }}
}

    

   

    
