/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.JardinEnfant;
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
public class JardinEnfantService implements IService<JardinEnfant>{
     Connection connexion;
Statement st;
ResultSet result;
static JardinEnfantService instance;
 public static JardinEnfantService getInstance()
    {
    if(instance==null)
    
    instance = new JardinEnfantService();
    return instance;
    
    }
public JardinEnfantService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void insert(JardinEnfant t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   String req="insert into JardinEnfants(id_enfant,nom,adresse,num_tel)values('"+t.getId_enfant()+"','"+t.getNom()+"','"+t.getAdresse()+"','"+t.getNum_tel()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public  List<JardinEnfant> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     List<JardinEnfant> JardinEnfants=new ArrayList<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from JardinEnfants");
    } catch (SQLException ex) {
        Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            JardinEnfant p=new JardinEnfant(result.getInt(2),result.getString(3),result.getString(4),result.getInt(5));
            JardinEnfants.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  JardinEnfants;
    }

    @Override
    public JardinEnfant search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    JardinEnfant p=null;
        try {
       
        result=st.executeQuery("select * from JardinEnfants where id_jardinEnfant="+id);
          if(result.next())
         p = new JardinEnfant(result.getInt(2),result.getString(3),result.getString(4),result.getInt(5));
    } catch (SQLException ex) {
        Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    JardinEnfant p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from JardinEnfants where id_jardinEnfant="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(JardinEnfant t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    JardinEnfant p1=search(t.getId_jardinEnfant());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update JardinEnfants set id_enfant='"+t.getId_enfant()+"',nom='"+t.getNom()+"', adresse='"+t.getAdresse()+"', num_tel='"+t.getNum_tel()+"' where id_jardinEnfant="+t.getId_jardinEnfant());
        } catch (SQLException ex) {
            Logger.getLogger(JardinEnfantService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

   @Override
    public  Map<String,JardinEnfant> getAllMap() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Map<String,JardinEnfant> JardinEnfants=new HashMap<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select nom_enfant,nom,adresse,num_tel from JardinEnfants g join enfants e on g.id_enfant=e.id_enfant");
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            JardinEnfant p=new JardinEnfant(result.getString(2),result.getString(3),result.getInt(4));
            JardinEnfants.put(result.getString(1),p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(GarderieService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  JardinEnfants;
    }
    
    
}
