/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;
import javafx.scene.paint.Color;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Acceuilkids2Controller implements Initializable {

    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Label lb3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void afficher1() throws IOException{
        
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("GestionUser.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

         
    }
    @FXML
    public void afficher2() throws IOException{
        
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("Evaluation.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

         
    }
    @FXML
    public void afficher3() throws IOException{
        
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("OffreDemande.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

         
    }
    @FXML
    public void changerColor()
     {
    lb1.setTextFill(Color.RED);
        lb2.setTextFill(Color.RED);
    lb3.setTextFill(Color.RED);

     }
    @FXML
      public void changerColor2()
     {
    lb1.setTextFill(Color.BLACK);
    lb2.setTextFill(Color.BLACK);
    lb3.setTextFill(Color.BLACK);
     }
    
}
