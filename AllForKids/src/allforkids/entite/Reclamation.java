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
public class Reclamation {
    private int id_reclamation;
    private int id_parent;
    private int id_babysitter;
    private String description;
    private Date date_envoi;

    public Reclamation(int id_reclamation, int id_parent, int id_babysitter, String description, Date date_envoi) {
        this.id_reclamation = id_reclamation;
        this.id_parent = id_parent;
        this.id_babysitter = id_babysitter;
        this.description = description;
        this.date_envoi = date_envoi;
    }

    public Reclamation(int id_parent, int id_babysitter, String description, Date date_envoi) {
        this.id_parent = id_parent;
        this.id_babysitter = id_babysitter;
        this.description = description;
        this.date_envoi = date_envoi;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

  

    public int getId_parent() {
        return id_parent;
    }

    public int getId_babysitter() {
        return id_babysitter;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate_envoi() {
        return date_envoi;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
    }

    public void setId_babysitter(int id_babysitter) {
        this.id_babysitter = id_babysitter;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate_envoi(Date date_envoi) {
        this.date_envoi = date_envoi;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation + ", id_parent=" + id_parent + ", id_babysitter=" + id_babysitter + ", description=" + description + ", date_envoi=" + date_envoi + '}';
    }

    

}
