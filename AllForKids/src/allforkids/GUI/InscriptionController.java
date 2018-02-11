/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Enfant;
import allforkids.service.EnfantService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author MacBook
 */
public class InscriptionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField tfId;
@FXML
    private TextField tfNom;
@FXML
    private TextField tfPrenom;
@FXML
    private TextField tfAge;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void inscrire(){
    EnfantService ps=new EnfantService();
        Enfant p= new Enfant(Integer.parseInt(tfId.getText()),tfNom.getText(),tfPrenom.getText(),Integer.parseInt(tfAge.getText()));
        ps.insert(p);
        tfNom.clear();
        tfPrenom.clear();
    }
    
}
