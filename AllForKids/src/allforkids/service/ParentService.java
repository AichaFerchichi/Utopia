/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Parent;
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
public class ParentService implements IAllForKids<Parent> {
     Connection connexion;
Statement st;
ResultSet result;
static ParentService instance;
 public static ParentService getInstance()
    {
    if(instance==null)
    {
    instance = new ParentService();}
    return instance;
    
    }
public ParentService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public void insert(Parent t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String req="insert into users(cin,nom,prenom,pseudo,mdp,email,adresse,montant,nom_club,num_tel,type)values('"+t.getCin()+"','"+t.getNom()+"',"
            + "'"+t.getPrenom()+"','"+t.getPseudo()+"','"+t.getMdp()+"','"+t.getEmail()+"','"+t.getAdresse()+"','"+t.getMontant()+"','','0','parent')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Parent> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     List<Parent> Parents=new ArrayList<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from users");
    } catch (SQLException ex) {
        Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Parent p=new Parent(result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getInt(9));
            Parents.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Parents;
    }

    @Override
    public Parent search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Parent p=null;
        try {
       
        result=st.executeQuery("select * from users where id_user="+id);
          if(result.next())
         p = new Parent(result.getInt(1),result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getString(8),result.getInt(9));
    } catch (SQLException ex) {
        Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Parent p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from users where id_user="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Parent t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  Parent p1=search(t.getId_user());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update users set cin='"+t.getCin()+"',nom='"+t.getNom()+"', prenom='"
                    +t.getPrenom()+"', pseudo='"+t.getPseudo()+"', mdp='"+t.getMdp()+"', email='"+t.getEmail()+"', adresse='"+t.getAdresse()+"', montant='"+t.getMontant()+"' where id_user="+t.getId_user());
        } catch (SQLException ex) {
            Logger.getLogger(ParentService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    @Override
    public Map<String, Parent> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

