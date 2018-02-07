/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

import java.sql.Date;

/**
 *
 * @author Molka
 */
public class Promotion {
    private int id_promotion ; 
    private int id_produit ; 
    private int pourcentage ; 
    private Date date_debut ; 
    private Date date_fin ; 

    public Promotion(int id_promotion, int id_produit, int pourcentage, Date date_debut, Date date_fin) {
        this.id_promotion = id_promotion;
        this.id_produit = id_produit;
        this.pourcentage = pourcentage;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public Promotion(int id_produit, int pourcentage, Date date_debut, Date date_fin) {
        this.id_produit = id_produit;
        this.pourcentage = pourcentage;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    public int getId_promotion() {
        return id_promotion;
    }

    public int getId_produit() {
        return id_produit;
    }

    public int getPourcentage() {
        return pourcentage;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "Promotion{" + "id_promotion=" + id_promotion + ", id_produit=" + id_produit + ", pourcentage=" + pourcentage + ", date_debut=" + date_debut + ", date_fin=" + date_fin + '}';
    }
    
    
    
    
    
}
