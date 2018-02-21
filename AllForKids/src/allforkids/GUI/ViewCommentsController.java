/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Commentaire;
import allforkids.entite.Parent;
import allforkids.entite.Produit;
import allforkids.service.CommentaireService;
import allforkids.service.ParentService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Molka
 */
public class ViewCommentsController implements Initializable {
    
    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private Text nom ; 
    @FXML
    private Text categorie ; 
    @FXML
    private Text prix ; 
    @FXML
    private Text description ; 
    @FXML 
    private ImageView image ; 
    @FXML
    private ListView<Commentaire> listeC ;
    @FXML
    private Text count ; 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher(ListeProduitsController.LoggedUser) ; 
        afficherCommment(); 
    }    
    
     public void afficher(Produit u)
       {
         
            nom.setText("Nom : "+u.getNom());
            categorie.setText("Catégorie : "+u.getCatégorie());
            prix.setText("Prix : "+u.getPrix_produit()+" DT");
            description.setText("Description : "+u.getDescription());
            String imageFile = u.getImage() ; 
            Image image1 = new Image(imageFile);
            image.setImage(image1);
       } 
    
    @FXML
    public void afficherCommment(){
        CommentaireService cs = new CommentaireService() ; 
        ObservableList<Commentaire>  lc = cs.getAllById(ListeProduitsController.LoggedUser.getId_produit()) ; 
        System.out.println("**********id prod :"+ListeProduitsController.LoggedUser.getId_produit());
        count.setText("Nombre de commentaires total : "+lc.size()+" commentaires");
          listeC.setCellFactory((ListView<Commentaire> param) -> {
              ListCell<Commentaire> cell = new ListCell<Commentaire>() {
                  @Override
                  protected void updateItem(Commentaire p , boolean bl) {
                      super.updateItem(p, bl);
                      if(p!=null){

                          
                          ParentService ps = new ParentService() ; 
                          Parent pr = ps.search(p.getId_parent()) ; 
                          System.out.println("***********************");
                          System.out.println("parents : "+pr);
                          System.out.println("***********************"); 
                          Image img = new Image(pr.getImage(), 80, 80, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
final Circle clip = new Circle(30,40,25);
imgV.setClip(clip);
        
        
                          setGraphic(imgV);
                          setText(pr.getNom()+" a commenté :"+"\n"+p.getContenu()+"\n");
                          
                      }
                  }
              } ; return cell ;
          });
      listeC.setItems(lc);
    }
    
        @FXML 
    public void OnZoomIn2(MouseEvent event){
        
            double w =image.getFitWidth() ;
            double h = image.getFitHeight() ; 
            image.setFitHeight(h+25);
            image.setFitWidth(w+25);
        
    }
    
     @FXML 
    public void OnZoomOut2(MouseEvent event){
        
            double w =image.getFitWidth() ;
            double h = image.getFitHeight() ; 
            image.setFitHeight(h-25);
            image.setFitWidth(w-25);
        
    }
    
}
