/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Produit;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Molka
 */
public class ProduitDetailsController implements Initializable {

    @FXML 
    private ImageView image ; 
    @FXML 
    private Text nom ; 
    @FXML 
    private Text categorie ; 
    @FXML 
    private Text prix ; 
    @FXML 
    private Text desc ; 
    
    @FXML
    private AnchorPane AnchorPane1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        afficher(ListViewTestController.LoggedUser) ; 
        // TODO
    }    
    
    
   public void afficher(Produit u)
       {
         
            nom.setText("Nom : "+u.getNom());
            categorie.setText("Catégorie : "+u.getCatégorie());
            prix.setText("Prix : "+u.getPrix_produit()+" DT");
            desc.setText("Description : "+u.getDescription());
            String imageFile = u.getImage() ; 
            Image image1 = new Image(imageFile);
            image.setImage(image1);
       } 
   
    @FXML
    private void retour(ActionEvent event) throws IOException {
        AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListViewTest.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);
    }
    
}
