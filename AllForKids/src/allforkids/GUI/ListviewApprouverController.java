/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;

import allforkids.entite.Babysitter;
import allforkids.entite.Produit;
import allforkids.entite.demandetravail;
import allforkids.service.BabysitterService;
import allforkids.service.ProduitService;
import allforkids.service.demande_travailService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ListviewApprouverController implements Initializable {

    @FXML
    private AnchorPane AnchorPane1;
    @FXML
    private ListView<Babysitter> liste1;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherListeProduits() ;
    }
 
    public void afficherListeProduits() 
       {
         demande_travailService ps1 = new demande_travailService() ;
           BabysitterService ps2 =BabysitterService.getInstance();
          ObservableList<Babysitter> lp = ps2.getAll();
          
          liste1.setCellFactory((ListView<Babysitter> param) -> {
              ListCell<Babysitter> cell = new ListCell<Babysitter>() {
                  @Override
                  protected void updateItem(Babysitter p , boolean bl) {
                      super.updateItem(p, bl);
                      if(p!=null){
                          Image img = new Image(p.getImage(), 300, 300, true, true, true) ;
                          ImageView imgV = new ImageView(img) ;
                          setGraphic(imgV);
                          
                         demandetravail lp=ps1.search(p.getId_user());
  
                          setText("                                Nom : "+p.getNom()+"\n \n                                Prenom : "+p.getPrenom()+"\n \n                                Niveau d'étude : "+lp.getNiveau_etude()+"\n\n                                Poste actuel: "+lp.getPoste_actuel()+"\n \n                                Lanque : "+lp.getLangue());
                      }
                  }
              } ; return cell ;
          });
      liste1.setItems(lp);
           
       
    liste1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


                liste1.setOnMouseClicked(new EventHandler<Event>() {

                    @Override
                    public void handle(Event event) {
                        ObservableList<Babysitter> selectedItems =  liste1.getSelectionModel().getSelectedItems();

                        for(Babysitter s : selectedItems){
                            System.out.println("selected item " + s);
                        }

                    }

                });
    
    
}
}