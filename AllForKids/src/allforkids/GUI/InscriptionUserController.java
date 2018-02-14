/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Parent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    }    
    public void inscrire()
    {
    if(comBox.getValue().equals("parent")){
        num_tel.setDisable(true);
      club.setDisable(true);
      String m2=mdp2.getText();
      String m=mdp.getText();
      if(m.equals(m2)){
      Parent p=new Parent(Integer.parseInt(cin.getText()),nom.getText(),prenom.getText(),pseudo.getText(),mdp.getText(),
      email.getText(),adresse.getText(),Float.parseFloat(montant.getText()));
    }}
    
    }
}
