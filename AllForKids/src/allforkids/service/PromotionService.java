/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;


import allforkids.entite.Promotion;
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
 * @author Molka
 */
public class PromotionService implements IAllForKids<Promotion>{
    
    Connection connexion;
    Statement st;
    ResultSet result;
    static PromotionService instance;
    
 public static PromotionService getInstance()
    {
    if(instance==null)
    {
    instance = new PromotionService();}
    return instance;
    
    }
 
private PromotionService() 
{
    connexion=DataSource.getInstance().getConnexion();
    try {
        st=connexion.createStatement();
    } catch (SQLException ex) {
        Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @Override
    public void insert(Promotion p) {
         String req = "insert into promotions(id_produit,pourcentage,date_debut,date_fin) values ('" + p.getId_produit()+ "','" + p.getPourcentage()+ "','" + p.getDate_debut()+ "','" + p.getDate_fin()+ "')";
        //System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Promotion> getAll() {
        List<Promotion> list = new ArrayList<>();
        try {
            result = st.executeQuery("select * from promotions");
           /* ResultSetMetaData resultMeta = result.getMetaData() ; 
            System.out.println("**********");
            for(int i = 1 ; i<= resultMeta.getColumnCount() ; i++){
                System.out.println(resultMeta.getColumnName(i).toUpperCase());
            }
            System.out.println("***********"); */
            while (result.next()) {
                Promotion p = new Promotion(result.getInt("id_promo"),result.getInt("id_produit"), result.getInt("pourcentage"), result.getDate("date_debut"),result.getDate("date_fin"));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;    }

    @Override
    public Promotion search(int id) {
        Promotion p = null ; 
    String req = "select * from promotions where id_promo="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new Promotion(result.getInt("id_promo"),result.getInt("id_produit"), result.getInt("pourcentage"), result.getDate("date_debut"),result.getDate("date_fin")) ; 
    }   catch (SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
    }

    @Override
    public boolean delete(int id) {
        Promotion p=search(id);
   if(p!=null)
   {
       try {
           st.executeUpdate("delete from promotions where id_promo="+id);
            return true;
       } catch (SQLException ex) {
           Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
       }
  
   }return false;
    }

    @Override
    public boolean update(Promotion p) {
        Promotion p1 = search(p.getId_promotion()) ; 
    if(p1!=null){
        try{
            st.executeUpdate("update promotions set id_produit='"+p.getId_produit()+"', pourcentage='"+p.getPourcentage()+"', date_debut='"+p.getDate_debut()+"', date_fin='"+p.getDate_fin()+"' where id_promo="+p.getId_promotion()) ; 
        } catch (SQLException ex) {
            Logger.getLogger(PromotionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true ; 
    }
    return false ; 
    }

    @Override
    public Map<String, Promotion> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
    

