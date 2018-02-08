/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Garderie;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MacBook
 */
public class GarderieService implements IAllForKids<Garderie> {

    Connection connexion;
Statement st;
ResultSet result;
static GarderieService instance;
 public static GarderieService getInstance()
    {
    if(instance==null)
    {
    instance = new GarderieService();}
    return instance;
    
    }
public GarderieService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void insert(Garderie t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   String req="insert into garderies(id_enfant,nom,adresse,num_tel)values('"+t.getId_enfant()+"','"+t.getNom()+"','"+t.getAdresse()+"','"+t.getNum_tel()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public  List<Garderie> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     List<Garderie> garderies=new ArrayList<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from garderies");
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Garderie p=new Garderie(result.getInt(2),result.getString(3),result.getString(4),result.getInt(5));
            garderies.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  garderies;
    }
@Override
    public  Map<String,Garderie> getAllMap() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Map<String,Garderie> garderies=new HashMap<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select nom_enfant,nom,adresse,num_tel from garderies g join enfants e on g.id_enfant=e.id_enfant");
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Garderie p=new Garderie(result.getString(2),result.getString(3),result.getInt(4));
            garderies.put(result.getString(1),p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  garderies;
    }

    @Override
    public Garderie search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Garderie p=null;
        try {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        
        result=st.executeQuery("select * from garderies where id_garderie="+id);
          if(result.next())
         p = new Garderie(result.getInt(2),result.getString(3),result.getString(4),result.getInt(5));
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Garderie p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from garderies where id_garderie="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }
   return false;
    }

    @Override
    public boolean update(Garderie t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Garderie p1=search(t.getId_enfant());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update garderies set id_enfant='"+t.getId_enfant()+"',nom='"+t.getNom()+"', adresse='"+t.getAdresse()+"', num_tel='"+t.getNum_tel()+"' where id_garderie="+t.getId_garderie());
        } catch (SQLException ex) {
            Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    
    
}

