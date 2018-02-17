/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Offre;
import allforkids.entite.demandetravail;
import static allforkids.service.OffreService.instance;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class demande_travailService implements IAllForKids<demandetravail>{
Connection cnx;
Statement st;
ResultSet rs;
static demande_travailService instance;
public demande_travailService(){
 cnx=DataSource.getInstance().getConnexion();
    try {
        st=cnx.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(demande_travailService.class.getName()).log(Level.SEVERE, null, ex);
    } 
}
public static demande_travailService getInstance()
    {
        if(instance==null)
        { instance = new demande_travailService();}
        return instance;
    }

   
    public void insert1(demandetravail p,int v) {
String req;
req = "insert into demande_travail(id_babysitter,niveau_etude,poste_actuel,langue)values('"+v+"','"+p.getNiveau_etude()+"','"+p.getPoste_actuel()+"','"+p.getLangue()+"')";

    try {
        st.executeUpdate(req);
    } catch (SQLException ex) {
        Logger.getLogger(demande_travailService.class.getName()).log(Level.SEVERE, null, ex);
    }
     
    }

    @Override
    public List<demandetravail> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, demandetravail> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public demandetravail search(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(demandetravail t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public demandetravail getbyPseudo(String pseudo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(demandetravail t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
