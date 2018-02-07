/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Produit;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Molka
 */
public class ProduitService implements IAllForKids<Produit> {

    Connection connexion;
    Statement st;
    ResultSet result;
    static ProduitService instance;
    
 public static ProduitService getInstance()
    {
    if(instance==null)
    
    instance = new ProduitService();
    return instance;
    
    }
 
private ProduitService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    @Override
    public void insert(Produit p) {
         String req = "insert into produits(nom,categorie,prix_produit,description) values ('" + p.getNom() + "','" + p.getCatégorie()+ "','" + p.getPrix_produit()+ "','" + p.getDescription()+ "')";
        //System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Produit> getAll() {
         List<Produit> list = new ArrayList<>();
        try {
            result = st.executeQuery("select * from produits");
           /* ResultSetMetaData resultMeta = result.getMetaData() ; 
            System.out.println("**********");
            for(int i = 1 ; i<= resultMeta.getColumnCount() ; i++){
                System.out.println(resultMeta.getColumnName(i).toUpperCase());
            }
            System.out.println("***********"); */
            while (result.next()) {
                Produit p = new Produit(result.getInt("id_produit"),result.getString("nom"), result.getString("categorie"), result.getFloat("prix_produit"),result.getString("description"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    @Override
    public Produit search(int id) {
        Produit p = null ; 
    String req = "select * from produits where id_produit="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new Produit(result.getInt("id_produit"),result.getString("nom"), result.getString("categorie"), result.getFloat("prix_produit"),result.getString("description")) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
    }

    @Override
    public boolean delete(int id) {
        Produit p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from produits where id_produit="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Produit p) {
        Produit p1 = search(p.getId_produit()) ; 
    if(p1!=null){
        try{
            st.executeUpdate("update produits set nom='"+p.getNom()+"', categorie='"+p.getCatégorie()+"', prix_produit='"+p.getPrix_produit()+"', description='"+p.getDescription()+"' where id_produit="+p.getId_produit()) ; 
        } catch (SQLException ex) {
            Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true ; 
    }
    return false ; 
    }

    @Override
    public Map<String, Produit> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
