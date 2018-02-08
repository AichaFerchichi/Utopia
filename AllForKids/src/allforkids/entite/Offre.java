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
public class Offre {
    private int id_offre;
    private int id_babysitter;
    private Date date_publication;
    private String description;

    public Offre(int id_offre, int id_babysitter, Date date_publication, String description) {
        this.id_offre = id_offre;
        this.id_babysitter = id_babysitter;
        this.date_publication = date_publication;
        this.description = description;
    }

    public Offre(int id_babysitter, Date date_publication, String description) {
        this.id_babysitter = id_babysitter;
        this.date_publication = date_publication;
        this.description = description;
    }

    public int getId_offre() {
        return id_offre;
    }

    

    public int getId_babysitter() {
        return id_babysitter;
    }

    public Date getDate_publication() {
        return date_publication;
    }

    public String getDescription() {
        return description;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public void setId_babysitter(int id_babysitter) {
        this.id_babysitter = id_babysitter;
    }

    public void setDate_publication(Date date_publication) {
        this.date_publication = date_publication;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Offre{" + "id_offre=" + id_offre + ", id_babysitter=" + id_babysitter + ", date_publication=" + date_publication + ", description=" + description + '}';
    }

    
    
}
