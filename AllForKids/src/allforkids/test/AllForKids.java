/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.test;

import allforkids.entite.MoyenDetransport;
import allforkids.service.MoyendeTransportService;
import allforkids.technique.util.DataSource;

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
        MoyenDetransport t=new MoyenDetransport("BMW", "181 tu 8982",2);
        MoyenDetransport t2=new MoyenDetransport("Porche", "170 tu 12365",2);
        MoyendeTransportService tService =  MoyendeTransportService.getInstance() ;
       // tService.insert(t);  
       // tService.insert(t2);
        tService.getAll().forEach(e->System.out.println(e));
        
      //  MoyenDetransport t1 =new MoyenDetransport(4,"chouf trahh","179 tu 8982",5);
       // tService.update(t1);
        
      //  MoyenDetransport p3= tService.getMoyenById(1) ; 
        // System.out.println(p3.toString());
        
       /*   tService.delete(p3); 
           MoyenDetransport p3= tService.search(1) ; 
        System.out.println(p3.toString());*/
        
    
    }
    
}
