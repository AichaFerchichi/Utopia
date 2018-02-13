/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Enfant;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MacBook
 */
public class EnfantService implements IAllForKids<Enfant> {
    Connection connexion;
Statement st;
ResultSet result;
static EnfantService instance;
 public static EnfantService getInstance()
    {
    if(instance==null)
    {instance = new EnfantService();}
    return instance;
    
    }
public EnfantService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void insert(Enfant t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   String req="insert into enfants(id_parent,nom_enfant,prenom,age)values('"+t.getId_parent()+"','"+t.getNom()+"','"+t.getPrenom()+"','"+t.getAge()+"')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public  List<Enfant> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     List<Enfant> Enfants=new ArrayList<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from enfants e join users u on e.id_parent= u.id_user where type='parent'");
    } catch (SQLException ex) {
        Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Enfant p=new Enfant(result.getInt(2),result.getString(3),result.getString(4),result.getInt(5));
            Enfants.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Enfants;
    }

    @Override
    public Enfant search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Enfant p=null;
        try {
       
        result=st.executeQuery("select * from enfants where id_enfant="+id);
          if(result.next())
         p = new Enfant(result.getInt(2),result.getString(3),result.getString(4),result.getInt(5));
    } catch (SQLException ex) {
        Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Enfant p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from enfants where id_enfant="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Enfant t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Enfant p1=search(t.getId_enfant());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update enfants set id_parent='"+t.getId_parent()+"',nom='"+t.getNom()+"', prenom='"+t.getPrenom()+"', age='"+t.getAge()+"' where id_enfant="+t.getId_enfant());
        } catch (SQLException ex) {
            Logger.getLogger(EnfantService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    @Override
    public Map<String, Enfant> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
