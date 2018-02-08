/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import allforkids.entite.Forum;
import allforkids.entite.Offre;
import allforkids.technique.util.DataSource;

/**
 *
 * @author user
 */
public class OffreService implements IAllForKids<Offre>{
Connection cnx;
Statement st;
ResultSet rs;
static OffreService instance;
private OffreService(){
 cnx=DataSource.getInstance().getConnexion();
    try {
        st=cnx.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    } 
}
public static OffreService getInstance()
    {
        if(instance==null)
            instance = new OffreService();
        return instance;
    }

    @Override
    public void insert(Offre p) {
        		
String req="insert into offres_babysitter(id_babysitter,date_publication,description)values('"+p.getId_babysitter()+"','"+p.getDate_publication()+"','"+p.getDescription()+"')";
     try {
            st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    } 
    }

    @Override
    public List<Offre> getAll() {
    List<Offre> Offres=new ArrayList<>();
        
    try {
        rs=st.executeQuery("SELECT * FROM `offres_babysitter` d join users u on d.id_babysitter=u.id_user where type='babysitter'");
    } catch (SQLException ex) { 
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    }
  
      
    try {
        while(rs.next()){
           Offre p;
        
            p = new Offre(rs.getInt("id_babysitter"),rs.getDate("date_publication"),rs.getString("Description"));
            Offres.add(p);
        }
    } catch (SQLException ex) { 
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return Offres;
    }

    @Override
    public Offre search(int n) {
Offre p=null;
        try {
       
        rs=st.executeQuery("select * from offres_babysitter where id_offre="+n);
          if(rs.next())
   p = new Offre(rs.getInt("id_babysitter"),rs.getDate("date_publication"),rs.getString("Description"));

    } catch (SQLException ex) { 
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
        return p; 
    }

    @Override
    public boolean delete(int id) {
     Offre p1=search(id);
        // System.out.println(p1);
         
   if(p1!=null)
   {
       try {
           st.executeUpdate("delete from offres_babysitter where id_offre="+id);
            return true;
       } catch (SQLException ex) {      
             Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
         }      
  
   }return false;
    }

    @Override
    public boolean update(Offre p) {
Offre p1=search(p.getId_offre());
   if(p1!=null)
   {
        try {
            		

            st.executeUpdate("Update offres_babysitter set id_babysitter='"+p.getId_babysitter()+"',date_publication='"+p.getDate_publication()+"',description='"+p.getDescription()+"'where id_offre="+p.getId_offre());
       	

        } catch (SQLException ex) { 
        Logger.getLogger(OffreService.class.getName()).log(Level.SEVERE, null, ex);
    }
       return true ;
   }
   return false;
    }  

    @Override
    public Map<String, Offre> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

 

   
