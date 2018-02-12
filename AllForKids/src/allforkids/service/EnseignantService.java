/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Enseignant;
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
public class EnseignantService implements IAllForKids<Enseignant>{
     Connection connexion;
Statement st;
ResultSet result;
static EnseignantService instance;
 public static EnseignantService getInstance()
    {
    if(instance==null)
    
    {instance = new EnseignantService();}
    return instance;
    
    }
 
private EnseignantService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public void insert(Enseignant t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    String req="insert into users(cin,nom,prenom,pseudo,mdp,email,adresse,montant,nom_club,num_tel,type)values('"+t.getCin()+"','"+t.getNom()+"',"
            + "'"+t.getPrenom()+"','"+t.getPseudo()+"','"+t.getMdp()+"','"+t.getEmail()+"','','"+t.getMontant()+"','"+t.getNom_club()+"','0','enseignant')";
    System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Enseignant> getAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     List<Enseignant> Enseignants=new ArrayList<>();
        
    try {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        result=st.executeQuery("select * from users");
    } catch (SQLException ex) {
        Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
        System.out.println("");
    try {
        while(result.next()){
            Enseignant p=new Enseignant(result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getInt(9),result.getString(10));
            Enseignants.add(p);
        }
    } catch (SQLException ex) {
        Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
    }
    return  Enseignants;
    }

    @Override
    public Enseignant search(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Enseignant p=null;
        try {
       
        result=st.executeQuery("select * from users where id_user="+id);
          if(result.next())
         p = new Enseignant(result.getInt(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7),result.getInt(9),result.getString(10));
    } catch (SQLException ex) {
        Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
    }
        
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Enseignant p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from users where id_user="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Enseignant t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  Enseignant p1=search(t.getId_user());
   if(p1!=null)
   {
        try {
            st.executeUpdate("Update users set  cin='"+t.getCin()+"',nom='"+t.getNom()+"', prenom='"
                    +t.getPrenom()+"', pseudo='"+t.getPseudo()+"', mdp='"+t.getMdp()+"', email='"+t.getEmail()+"', montant='"+t.getMontant()+"', nom_club='"+t.getNom_club()+"' where id_user="+t.getId_user());
        } catch (SQLException ex) {
            Logger.getLogger(EnseignantService.class.getName()).log(Level.SEVERE, null, ex);
        }
       return true ;
   }
   return false;
    }

    @Override
    public Map<String, Enseignant> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    
