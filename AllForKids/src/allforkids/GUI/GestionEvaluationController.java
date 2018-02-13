/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Evaluation;

import allforkids.service.EvaluationService;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class GestionEvaluationController implements Initializable {
     @FXML
    private Button btn1;
     @FXML
    private TextField idEva;
     @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
     @FXML
    private TextField matiere;
    @FXML
    private TextField moyenne;
     @FXML
    private TextArea remarque;
    
 @FXML
    private AnchorPane AnchorPane1;
 @FXML
    private TableView<Evaluation> table;
 @FXML
    private TableColumn<Evaluation, Integer> Cid;
    @FXML
    private TableColumn<Evaluation, String> Cnom;
    @FXML
    private TableColumn<Evaluation, String> Cprenom;
    @FXML
    private TableColumn<Evaluation, String> Cmatiere;
    @FXML
    private TableColumn<Evaluation, Float> Cmoyenne;
    @FXML
    private TableColumn<Evaluation, String> Cremarque;
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
           
            EvaluationService ips = new EvaluationService();
            table.setItems(null);
                table.setItems(ips.getAll());
 Cid.setCellValueFactory(new PropertyValueFactory<>("id_evaluation"));
        Cnom.setCellValueFactory(new PropertyValueFactory<>("nom_enfant"));
       
        
        Cprenom.setCellValueFactory(new PropertyValueFactory<>("prenom_enfant"));
        Cmatiere.setCellValueFactory(new PropertyValueFactory<>("matiere"));
              Cmoyenne.setCellValueFactory(new PropertyValueFactory<>("moyenne"));
              Cremarque.setCellValueFactory(new PropertyValueFactory<>("remarque"));

       }
     public void ajouter()
     {
     EvaluationService ps=new EvaluationService();
        Evaluation p= new Evaluation(matiere.getText(),Float.parseFloat(moyenne.getText()),remarque.getText(),nom.getText(),prenom.getText());
        ps.insert(p);
        nom.clear();
        prenom.clear();
        matiere.clear();
        moyenne.clear();
        remarque.clear();
        afficherEva();
        
     }
     public void supprimer()
     {
         int i=table.getSelectionModel().getSelectedItem().getId_evaluation();
         System.out.println(i);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Suppression");
            alert.setHeaderText("voulez-vous vraiment effacer cette évaluation");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
     EvaluationService ps=new EvaluationService();
        
      ps.delete(i);
      afficherEva();}
        
     }
     public void modifier()
     {
          btn1.setDisable(false);
          idEva.setText(Integer.toString(table.getSelectionModel().getSelectedItem().getId_evaluation()));
     nom.setText(table.getSelectionModel().getSelectedItem().getNom_enfant());
     prenom.setText(table.getSelectionModel().getSelectedItem().getPrenom_enfant());
     matiere.setText(table.getSelectionModel().getSelectedItem().getMatiere());
     moyenne.setText(Float.toString(table.getSelectionModel().getSelectedItem().getMoyenne()));
     remarque.setText(table.getSelectionModel().getSelectedItem().getRemarque());
    
     }
     public void mod2()
     {
     EvaluationService ps=new EvaluationService();
     Evaluation e=new Evaluation(Integer.parseInt(idEva.getText()),
     matiere.getText(),Float.parseFloat(moyenne.getText()),remarque.getText(),nom.getText(),
    prenom.getText());
     ps.update(e);
     afficherEva();
     }

}
