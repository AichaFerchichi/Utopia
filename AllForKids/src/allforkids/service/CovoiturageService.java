/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;


import allforkids.entite.Covoiturage;
import allforkids.technique.util.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

/**
 *
 * @author imen
 */
public class CovoiturageService implements IAllForKids<Covoiturage>{
     Connection connexion;
    Statement st;
    ResultSet result;
   static CovoiturageService instance;
 public static CovoiturageService getInstance()
    {
    if(instance==null)
    
    instance = new CovoiturageService();
    return instance;
    
    }

    private CovoiturageService() {
        try {
            DataSource ds = DataSource.getInstance();
            connexion= ds.getConnexion();
            System.out.println("Connection: "+ds.getConnexion());
            System.out.println(connexion);
            st = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public Covoiturage getMoyenById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Covoiturage t= null ; 
    String req = "select * from  covoiturages where id="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
         t = new Covoiturage(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getInt("nbre_place_dispo")) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return t ; 
    }

    @Override
    public void insert(Covoiturage p) {
           String req = "insert into covoiturages (id_user,depart,destination,nbre_place_dispo) values ('" + p.getId_user()+"','" +p.getDepart()+"','" + p.getDestination()+"','" + p.getNbre_place_dispo()+  "')";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    }

    @Override
    public List<Covoiturage> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      List<Covoiturage> list = new ArrayList<>();
        try {
            result = st.executeQuery("select * from covoiturages join users on users.id_user=covoiturages.id_user where users.type='parent'");
         
            while (result.next()) {
               Covoiturage t = new Covoiturage(result.getInt(1),result.getInt(2), result.getString("depart"), result.getString("destination"),result.getInt("nbre_place_dispo"));
                list.add(t);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    @Override
    public Covoiturage search(int id){
             Covoiturage p = null ; 
    String req = "select * from covoiturages where id="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new Covoiturage(result.getInt(1),result.getInt(2), result.getString(3), result.getString(4),result.getInt(5)) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
    }

  
    public boolean delete(Covoiturage p) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String req = "delete from covoiturages where id="+p.getId(); 
    if(p!=null){
        try{
            st.executeUpdate(req) ;
            return true ; 
        } catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return false ; 
    }

    @Override
    public boolean update(Covoiturage t) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Covoiturage t1 = getMoyenById(t.getId()) ; 
    if(t1!=null){
        try{
//           "update personne set nom='"+p.getNom()+"', prenom='"+p.getPrenom()+"'where id="+p.getId())
            st.executeUpdate("update covoiturages set id='" + t.getId()+"', id_user='"+ t.getId_user()+"', depart='"+ t.getDepart()+"', destination='"+ t.getDestination()+"', nbre_place_dispo='" + t.getNbre_place_dispo()+"'where id="+t.getId()) ; 
        } catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true ; 
    }
    return false ;
    }

    @Override
    public Map<String, Covoiturage> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
