/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.test;

import allforkids.entite.Commande;
import allforkids.entite.Commentaire;
import allforkids.entite.LigneCommande;
import allforkids.entite.Livraison;
import allforkids.entite.Livreur;
import allforkids.entite.MoyenDetransport;
import allforkids.entite.Note;
import allforkids.entite.Produit;
import allforkids.entite.Promotion;
import allforkids.service.CommandeService;
import allforkids.service.LivraisonService;
import allforkids.service.LivreurService;
import allforkids.service.MoyendeTransportService;
import allforkids.service.NoteService;
import allforkids.service.ProduitService;
import allforkids.service.PromotionService;
import allforkids.technique.util.DataSource;
import java.sql.Date;
import moduleboutique.service.CommentaireService;
import moduleboutique.service.LigneCommandeService;

/**
 *
 * @author MacBook
 */
public class AllForKids {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DataSource ds=DataSource.getInstance();
         System.out.println("DS:"+ds);
       // System.out.println("**************Houaida************");
         //GARDERIE:jawou behy
         /*Garderie G=new Garderie(7,"hoda", "ariana",1234455);
           GarderieService Gservice= GarderieService.getInstance();
           //Gservice.insert(G);
          Gservice.getAllMap().entrySet().stream().forEach(e->System.out.println(e));
           Garderie p4=new Garderie(8,8,"hou","meek",233);
           Gservice.update(p4);
           //System.out.println(p4);
           Garderie p3=Gservice.search(8);
           //System.out.println(p3);*/
         
           //JARDIN D'ENFANT:jawou behy
         /*JardinEnfant J=new JardinEnfant(9,"hoda", "ariana",1234455);
           JardinEnfantService Jservice=JardinEnfantService.getInstance();
           //Jservice.insert(J);
           //Jservice.getAll().forEach(e->System.out.println(e));
           Jservice.getAllMap().entrySet().stream().forEach(e->System.out.println(e));
           JardinEnfant J1=new JardinEnfant(5,8,"houaida","meek",23);
           Jservice.update(J1);
           JardinEnfant J2=Jservice.search(5);
           System.out.println(J2);*/
          
          //ENSEIGNANT:Jawou behy
         
         /*Enseignant E=new Enseignant(123,"houaida", "meknassi","hoda","mdp1","houaida.meknassi@esprit.tn",12,"theatre");
         //  EnseignantService Eservice=new EnseignantService();
           EnseignantService Eservice=EnseignantService.getInstance();
           EnseignantService Es=EnseignantService.getInstance();
            System.out.println("Eservice:"+Eservice);
          System.out.println("Es:"+Es);
           Es.getAll().forEach(e->System.out.println(e));
           //Eservice.insert(E);
           Eservice.getAll().forEach(e->System.out.println(e));
           Enseignant E1=new Enseignant(9,123,"houaida", "meknassi","hoda2","mdp2","houaida.meknassi@esprit.tn",12,"theatre");
           Eservice.update(E1);
           
           Enseignant J2=Eservice.search(9);
           Eservice.delete(12);
           System.out.println(J2);
         */
         //ENFANT:Jawou behy
       /* Enfant EN=new Enfant(4,"hoda", "ariana",12);
           EnfantService ENservice= EnfantService.getInstance();
          // ENservice.insert(EN);
           ENservice.getAll().forEach(e->System.out.println(e));
           Enfant E2=new Enfant(7,4,"houaida","meek",23);
           ENservice.update(E2);
           Enfant E3=ENservice.search(7);
           System.out.println(E3);*/
         
         //ADMIN:Jawou behy
        /*Admin A=new Admin("pseudo1","mdp1","email1");
           AdminService Aservice=AdminService.getInstance();
          //Aservice.insert(A);
           Aservice.getAll().forEach(e->System.out.println(e));
           Admin A2=new Admin(1,"pseudo2","mdp2","email2");
           Aservice.update(A2);
           Admin A3=Aservice.search(4);
           //System.out.println(A3);*/
        
        //PARENT:Jawou behy
    /* Parent P=new Parent(12345678,"houaida", "meknassi","hoda","mdp1","houaida.meknassi@esprit.tn","ariana",100);
           ParentService Pservice=ParentService.getInstance();
           //Pservice.insert(P);
           Pservice.getAll().forEach(e->System.out.println(e));
           Parent P1=new Parent(10,12345777,"houa", "mek","hoda","mdp2","houaida.meknassi@esprit.tn","ariana",999);
           Pservice.update(P1);
           
           Parent P2=Pservice.search(10);
           System.out.println(P2);*/
         /*****************imen*******************/
        /*MoyenDetransport t=new MoyenDetransport("BMW", "181 tu 8982",2);
        MoyenDetransport t2=new MoyenDetransport("Porche", "170 tu 12365",2);
        MoyendeTransportService tService =  MoyendeTransportService.getInstance() ;*/
       // tService.insert(t);  
       // tService.insert(t2);
        //tService.getAll().forEach(e->System.out.println(e));
        
      //  MoyenDetransport t1 =new MoyenDetransport(4,"chouf trahh","179 tu 8982",5);
       // tService.update(t1);
        
      //  MoyenDetransport p3= tService.getMoyenById(1) ; 
        // System.out.println(p3.toString());
        
       /*   tService.delete(p3); 
           MoyenDetransport p3= tService.search(1) ; 
        System.out.println(p3.toString());*/
       
       System.out.println("++++++++++++++++++++++++++////MODULE BOUTIQUE////+++++++++++++++++++++++++++++");
       /*System.out.println("*****************GESTION DES PRODUITS******************");
        Produit p1=new Produit("poupée Vaiana", "jouets", (float)26.99, "Embarquez pour des aventures extraordinaires avec la belle Vaiana ! ") ; 
        Produit p2=new Produit("Trottinette", "jouets", (float)72.00, "Déplacez-vous avec style aux commandes de cette trottinette solide, évolutive et ultra-confortable !"); 
        ProduitService gestionP =  ProduitService.getInstance();
        System.out.println("<<<<< Insertion et affichage >>>>>");
        gestionP.insert(p1);
        gestionP.insert(p2) ;
        gestionP.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Produit p3=gestionP.search(1) ; 
        System.out.println(p3);*/
       
        
        
        System.out.println("*****************GESTION DES PROMOTIONS******************");
        /*Promotion pr1 = new Promotion( 1,50, new Date(0) ,new Date(0) );
        Promotion pr2 = new Promotion( 1,50, new Date(0) ,new Date(0) );
        PromotionService gestionPr = PromotionService.getInstance() ; 
        System.out.println("<<<<< Insertion et affichage >>>>>");
        gestionPr.insert(pr1);
        gestionPr.insert(pr2);
        gestionPr.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Promotion pr3=gestionPr.search(7) ; 
        System.out.println(pr3);*/
       
        
                
        
        System.out.println("*****************GESTION DES COMMENTAIRES******************");
        /*Commentaire c1 = new Commentaire(3, 1, "agréable produit, trés bonne qualité.. Merci") ; 
        Commentaire c2 = new Commentaire(3, 1, "inutile!") ; 
        CommentaireService gestionC = CommentaireService.getInstance() ; 
        System.out.println("<<<<< Insertion et affichage >>>>>");
        gestionC.insert(c1);
        gestionC.insert(c2);
        gestionC.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Commentaire c3=gestionC.search(3) ; 
        System.out.println(c3);*/
        
        System.out.println("*****************GESTION DES NOTES******************");
        /*Note n1 = new Note(3, 1, 2) ; 
        Note n2 = new Note(3, 2, 4) ;  
        NoteService gestionN = NoteService.getInstance() ; 
        System.out.println("<<<<< Insertion et affichage >>>>>");
        gestionN.insert(n1);
        gestionN.insert(n2);
        gestionN.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Note n3=gestionN.search(1) ; 
        System.out.println(n3);*/
        
        System.out.println("*****************GESTION DES LIVREURS******************");
        /*Livreur l1 = new Livreur("toto", "toto", "toto@esprit.tn", 1) ; 
        Livreur l2 = new Livreur("toto2", "toto2", "toto2@esprit.tn", 0) ; 
        LivreurService gestionL = LivreurService.getInstance() ;
        System.out.println("<<<<< Insertion et affichage >>>>>");
        gestionL.insert(l1);
        gestionL.insert(l2);
        gestionL.getAll().forEach(e->System.out.println(e));
        System.out.println("<<<<< Recherche >>>>>");
        Livreur l3 = gestionL.search(1) ; 
        System.out.println(l3);*/
        
        System.out.println("*****************GESTION DES LIVRAISONS******************");
        /*Livraison lv1 = new Livraison(1, 3, 2, 520, "nasr2") ; 
        LivraisonService gestionLv = LivraisonService.getInstance() ;
        System.out.println("<<<<< Insertion et affichage >>>>>");
        gestionLv.insert(lv1);
        gestionLv.getAll().forEach(e->System.out.println(e)) ; 
        System.out.println("<<<<< Recherche >>>>>");
        Livraison lv3 = gestionLv.search(15) ; 
        System.out.println(lv3);*/
        
        
        System.out.println("*****************GESTION DES LIGNE COMMANDES******************");
        /*LigneCommande lc1 = new LigneCommande(5, 4) ;  
        LigneCommande lc2 = new LigneCommande(3, 1) ; 
        LigneCommande lc3 = new LigneCommande(2, 5) ; 
        Produit prod3 = new Produit(2,72) ; 
        LigneCommandeService gestionLc = LigneCommandeService.getInstance() ;
        ProduitService gestionP =  ProduitService.getInstance();
        //gestionLc.insert(lc1);
        //gestionLc.insert(lc2);
        //gestionLc.insert(lc3);
        gestionLc.insertPrix(gestionP.search(5));
        gestionLc.insertPrix(gestionP.search(3));
        gestionLc.getAll().forEach(e->System.out.println(e)) ;*/
        
        System.out.println("*****************GESTION DES COMMANDES******************");
        /*Commande cm1 = new Commande(6, 1, 0) ; 
        CommandeService gestionCm = CommandeService.getInstance() ;
        gestionCm.insert(cm1);
        gestionCm.insertTotal(cm1);
        gestionCm.getAll().forEach(e->System.out.println(e));*/
        
    
    }
    
}
