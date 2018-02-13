/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Garderie;
import allforkids.entite.JardinEnfant;
import allforkids.service.GarderieService;
import allforkids.service.IAllForKids;
import allforkids.service.JardinEnfantService;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class ListeGardJardController implements Initializable {
    @FXML
    private AnchorPane AnchorPane1;
 @FXML
    private TableView<Garderie> table;
    @FXML
    private TableColumn<Garderie, String> garderie;
    @FXML
    private TableColumn<Garderie, String> info;
    @FXML
    private TableColumn<Garderie, String> adresse;
    @FXML
    private TableColumn<Garderie, Integer> num_tel;
    @FXML
    private TableView<JardinEnfant> table1;
    @FXML
    private TableColumn<JardinEnfant, String> jardin;
    @FXML
    private TableColumn<JardinEnfant, String> info1;
    @FXML
    private TableColumn<JardinEnfant, String> adresseJ;
    @FXML
    private TableColumn<JardinEnfant, Integer> num_telJ;
    @FXML
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherGarderie();
        afficherJardin();
        
    }    
     public void afficherGarderie()
       {
           
            GarderieService ips = new GarderieService();
            table.setItems(null);
                table.setItems(ips.getAll());

        garderie.setCellValueFactory(new PropertyValueFactory<>("nom"));
       
        
        adresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        num_tel.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
              info.setCellValueFactory(new PropertyValueFactory<>("description"));

       }
     public void afficherJardin()
       {
           
            JardinEnfantService ips = new JardinEnfantService();
            table1.setItems(null);
                table1.setItems(ips.getAll());

        jardin.setCellValueFactory(new PropertyValueFactory<>("nom"));
       
        
        adresseJ.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        num_telJ.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
              info1.setCellValueFactory(new PropertyValueFactory<>("description"));

       }
      @FXML
    public void inscrire(ActionEvent event) {
        if (!table.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Inscription à une garderie");
            alert.setHeaderText("etes-vous sur que vous voulez s'inscrire à :  "
                    + table.getSelectionModel().getSelectedItem().getNom());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                try {
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Inscription.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

        } catch (IOException ex) {
            Logger.getLogger(acceuil_controller.class.getName()).log(Level.SEVERE, null, ex);
        } 
            }

        }
    
    }
}

