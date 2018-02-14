/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Evaluation;
import allforkids.entite.Parent;
import allforkids.service.EnseignantService;
import allforkids.service.ParentService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void afficher()
    {
    if(Rparent.isSelected())
    {
        
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
              Cnum_tel.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
                Cadresse.setVisible(true);
        Cnom_club.setVisible(false);
       
    }
    else if(Renseignant.isSelected())
    {
        
        EnseignantService ps=new EnseignantService();
    
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
        Cnom_club.setVisible(true);
        Cadresse.setVisible(false);
       
    }
    }
    
}
