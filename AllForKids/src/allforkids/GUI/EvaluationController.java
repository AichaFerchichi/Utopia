/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Evaluation;
import allforkids.entite.Garderie;
import allforkids.entite.JardinEnfant;
import allforkids.service.EvaluationService;
import allforkids.service.JardinEnfantService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class EvaluationController implements Initializable {
 @FXML
    private TableView<Evaluation> table1;
    @FXML
    private TableColumn<Evaluation, String> matiere;
    @FXML
    private TableColumn<Evaluation, Float> moyenne;
    @FXML
    private TableColumn<Evaluation, String> remarque;
    @FXML
    private Label nomEnfant;
    @FXML
    private Button btretour;
    @FXML
    private AnchorPane AnchorPane1;
    
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficherEvaluation();
    }    
    public void afficherEvaluation()
       {
           
            EvaluationService ips = new EvaluationService();
            table1.setItems(null);
                table1.setItems(ips.getAll());

        matiere.setCellValueFactory(new PropertyValueFactory<>("matiere"));
       
        
        moyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
        remarque.setCellValueFactory(new PropertyValueFactory<>("remarque"));
              

       }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("AccueilParent.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    
}
