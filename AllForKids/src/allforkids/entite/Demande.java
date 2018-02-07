/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

import java.sql.Date;

/**
 *
 * @author user
 */
public class Demande {
  private int id_demande; 
  private int id_parent;
  private Date date_publication;
  private String description;

    public Demande(int id_demande, int id_parent, Date date_publication, String description) {
        this.id_demande = id_demande;
        this.id_parent = id_parent;
        this.date_publication = date_publication;
        this.description = description;
    }

    public Demande(int id_parent, Date date_publication, String description) {
       
        this.id_parent = id_parent;
        this.date_publication = date_publication;
        this.description = description;
    }

    public int getId_demande() {
        return id_demande;
    }


    public int getId_parent() {
        return id_parent;
    }

    public Date getDate_publication() {
        return date_publication;
    }

    public String getDescription() {
        return description;
    }

    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
    }

    
    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public void setDate_publication(Date date_publication) {
        this.date_publication = date_publication;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Demande{" + "id_demande=" + id_demande + ", id_parent=" + id_parent + ", date_publication=" + date_publication + ", description=" + description + '}';
    }

    
    
  
  }
