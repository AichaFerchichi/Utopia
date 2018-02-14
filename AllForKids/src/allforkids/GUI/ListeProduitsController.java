/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.GUI;
import javafx.scene.image.Image ;
import allforkids.entite.Produit;
import allforkids.service.ProduitService;
//import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Callback;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
//import java.util.logging.Logger ; 
/**
 * FXML Controller class
 *
 * @author Molka
 */

public class ListeProduitsController implements Initializable {

     public static Produit LoggedUser;
     /*@FXML
    private AnchorPane AnchorPane;*/
       @FXML
    private AnchorPane AnchorPane1;
 @FXML
    private TableView<Produit> listeP;
    @FXML
    private TableColumn<Produit, String> Image ;
            //= new TableColumn<Produit, String>("image") ;
    @FXML
    private TableColumn<Produit, Integer> Identifiant;
    @FXML
    private TableColumn<Produit, String> Nom;
    @FXML
    private TableColumn<Produit, String> Cat;
    @FXML
    private TableColumn<Produit, Float> Prix;
    @FXML
    private TableColumn<Produit, String> Description;
     @FXML
     private ComboBox<String> comBox ; 
     @FXML
     private TextField imgPath ; 
     @FXML
     private TextField NomP ; 
     @FXML
     private TextField price ; 
     @FXML
     private TextArea Desc ;
     @FXML
     private ComboBox<Float> comBox2 ; 
     @FXML 
     private ImageView imgV ; 
     @FXML 
     private TextField search ; 
     @FXML 
     private Text textSearch ;
     String id ; 
    // int id_prod ; 
     
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       


//initialisation comBox2
        ObservableList<Float> ol2 = FXCollections.observableArrayList();
        ol2.add((float)10.2) ; 
        ol2.add((float)24.99) ; 
        ol2.add((float)72) ; 
        
        //initialisation ComboBox 
        ObservableList<String> ol = FXCollections.observableArrayList();
        ol.add("jouets") ; 
        ol.add("vêtements") ; 
        ol.add("fournitures") ; 
        
        comBox.setItems(ol);
        comBox2.setItems(ol2);
       
        listeP.getSelectionModel().selectedItemProperty().
                addListener((observable, oldValue, newValue) -> {
                    showDetails(newValue);
                });
        
   //id_prod = listeP.getSelectionModel().getSelectedItem().getId_produit() ; 
       
       // img.textProperty().addListener(listener);
                
        afficherListeProduits() ;
        //onSelect();
        
    }  
    
    public void showDetails(Produit e){
        //int id = e.getId_produit() ; 
        id = Integer.toString(e.getId_produit());
        NomP.setText(e.getNom());
        comBox.setValue(e.getCatégorie());
        comBox2.setValue(e.getPrix_produit());
        Desc.setText(e.getDescription());
        imgPath.setText(e.getImage());
        
        
    }
    public void afficherListeProduits()
       {
           
            ProduitService ps = new ProduitService();
            listeP.setItems(null);
            listeP.setItems(ps.getAll());

        
        Identifiant.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
       // idProd.cellFactoryProperty();
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
       // nom.cellFactoryProperty();
        Cat.setCellValueFactory(new PropertyValueFactory<>("catégorie"));
           // Cat.cellFactoryProperty();
        Prix.setCellValueFactory(new PropertyValueFactory<>("prix_produit"));
       // prix.cellFactoryProperty();
        Description.setCellValueFactory(new PropertyValueFactory<>("description"));
       // description.cellFactoryProperty();
       /*String imageFile = imgPath.getText() ;
       System.out.println(imageFile);
       ImageView image1 = new ImageView(imageFile);*/
      
      // Image.setCellValueFactory(new PropertyValueFactory<>("image"));
       //imgV.setImage(image1);
      
       }
     
    public void actionBrowser()throws MalformedURLException {
        
        String imageFile;
        /*JFileChooser chooser = new JFileChooser() ; 
        chooser.showOpenDialog(null) ; 
        File f = chooser.getSelectedFile() ; 
        String filename = f.getAbsolutePath() ; 
        imgPath.setText(filename);
        Image image = new Image(filename) ; 
        imgV.setImage(image);*/
        FileChooser fc = new FileChooser();
        File selectedFile = fc.showOpenDialog(null);
        if (selectedFile != null) {
            imageFile = selectedFile.toURI().toURL().toString();
            System.out.println(imageFile);
            Image image1 = new Image(imageFile);
            imgV.setImage(image1);
            imgPath.setText(imageFile);
        } else {
            System.out.println("file doesn't exist");
        }
     }
    
    
     @FXML
    public void ajouterProduit(ActionEvent event)throws IOException, InterruptedException{
        ProduitService ps = new ProduitService(); 
        Produit p = new Produit(NomP.getText() ,comBox.getValue(),comBox2.getValue(),Desc.getText(),imgPath.getText()); 
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
       alert.setHeaderText("produit ajouté, merci.");
       Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
        ps.insert(p);
         afficherListeProduits() ;
         NomP.clear() ; 
         comBox.setValue("Veuillez choirsir une catégorie");
         comBox2.setValue(null); 
         Desc.clear();
         imgPath.clear(); 
        }
    }
    
    /*@FXML 
    public void onSelect (){
           if (!listeP.getSelectionModel().isEmpty()){
           NomP.setText(listeP.getSelectionModel().getSelectedItem().getNom());
           comBox.setValue(listeP.getSelectionModel().getSelectedItem().getCatégorie()) ; 
           comBox2.setValue(listeP.getSelectionModel().getSelectedItem().getPrix_produit());
           Desc.setText(listeP.getSelectionModel().getSelectedItem().getDescription());
            //imgPath.setText(listeP.getSelectionModel().getSelectedItem().getImage().toString());
           }
    }*/
    
    @FXML
    public void supprimerProduit(ActionEvent event)throws IOException, InterruptedException{
        if (!listeP.getSelectionModel().isEmpty()) {
         
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("suppression d'un produit");
            alert.setHeaderText("etes-vous sur que vous voulez supprimer le produit: "
                    + listeP.getSelectionModel().getSelectedItem().getNom());
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                ProduitService ps = new ProduitService();
                ps.delete(listeP.getSelectionModel().getSelectedItem().getId_produit());
                afficherListeProduits() ;
                NomP.clear() ; 
         comBox.setValue("Veuillez choirsir une catégorie");
         comBox2.setValue(null); 
         Desc.clear();
         
            }
        } 
        
    }
    
     @FXML
    public void modifierProduit(ActionEvent event)throws IOException, InterruptedException{
     if (!listeP.getSelectionModel().isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
     alert.setTitle("modification d'un produit");
            alert.setHeaderText("etes-vous sur que vous voulez modifier le produit: "
                    + listeP.getSelectionModel().getSelectedItem().getNom());
     Optional<ButtonType> result = alert.showAndWait();
     if (result.get() == ButtonType.OK) {
            Produit n = new Produit(NomP.getText(), comBox.getValue(),comBox2.getValue(),Desc.getText(),imgPath.getText());
            n.setId_produit(Integer.parseInt(id));
            ProduitService ps = new ProduitService();
            ps.update(n);
            afficherListeProduits(); } 
       
    }
    }
    
    @FXML
    private void rechercherProduit(ActionEvent event)throws IOException, InterruptedException {
          ProduitService ps = new ProduitService();
                String a =(search.getText()) ;

        listeP.setItems(ps.SearchCatégorie(a));
        textSearch.setText("Résultat de votre recherche : "+ps.SearchCatégorie(a).size()+" produits");
      
        Identifiant.setCellValueFactory(new PropertyValueFactory<>("id_produit"));
        Nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Cat.setCellValueFactory(new PropertyValueFactory<>("catégorie"));
        Prix.setCellValueFactory(new PropertyValueFactory<>("prix_produit"));
        Description.setCellValueFactory(new PropertyValueFactory<>("description"));
        
    }
    
    @FXML
    private void afficherimage(MouseEvent event){
        if (event.getClickCount() == 1) //Checking double click
       {
            imgV.setImage(null);
            //int S = listeP.getSelectionModel().getSelectedItem().getId_produit();
            //Produit p = new Produit() ; 
            /*ProduitService ps = new ProduitService();
            Produit p = ps.search(S) ; */
            String imageFile = imgPath.getText() ; 
            //String imageFile = p.getImage() ; 
            //String imageFile = (ps.search(listeP.getSelectionModel().getSelectedItem().getId_produit()).getImage());
            System.out.println(imageFile);
            Image image1 = new Image(imageFile);
            imgV.setImage(image1);
      }
    }
    
    
    @FXML 
    public void onclickPromotion(ActionEvent event)throws IOException, InterruptedException{
     if(!listeP.getSelectionModel().isEmpty()){
         /* Produit p = new Produit(NomP.getText(), comBox.getValue(),comBox2.getValue(),Desc.getText(),imgPath.getText()) ; 
       int id = Integer.parseInt(Identifiant.getText()) ; */
         LoggedUser = new Produit();
       
        LoggedUser.setId_produit(listeP.getSelectionModel().getSelectedItem().getId_produit());
        LoggedUser.setImage(listeP.getSelectionModel().getSelectedItem().getImage());
                  System.out.println(LoggedUser.getImage());
                  System.out.println(LoggedUser.getId_produit());
        try {
       
            AnchorPane1.getChildren().clear();
            Pane newLoadedPane = FXMLLoader.load(getClass().getResource("ListePromotions.fxml"));
            AnchorPane1.getChildren().add(newLoadedPane);

        } catch (IOException ex) {
            Logger.getLogger(AuthentificationController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    } 
    }
           
    /*public int returnId(){
        if(!listeP.getSelectionModel().isEmpty()){
       Produit p = new Produit(NomP.getText(), comBox.getValue(),comBox2.getValue(),Desc.getText(),imgPath.getText()) ; 
       return p.getId_produit() ; 
        }return -1 ; 
    }*/
    
   /*@FXML 
    public void onkeytype(KeyEvent event)throws IOException, InterruptedException{
        char c = event.getKeyChar() ; 
        if(!(Character.isDigit(c)||c==KeyEvent.VK_BACK_SPACE||c==KeyEvent.VK_DELETE)){
            event.consume();
        }
    }*/
    
    
}
