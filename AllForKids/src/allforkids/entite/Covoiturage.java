/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

/**
 *
 * @author imen
 */
public class Covoiturage {
    
   private int id;
   private int id_user;
   private String depart;
   private String destination;
   private int nbre_place_dispo; 

    public Covoiturage(int id_user, String depart, String destination, int nbre_place_dispo) {
        this.id_user = id_user;
        this.depart = depart;
        this.destination = destination;
        this.nbre_place_dispo = nbre_place_dispo;
    }

    public Covoiturage(int id, int id_user, String depart, String destination, int nbre_place_dispo) {
        this.id = id;
        this.id_user = id_user;
        this.depart = depart;
        this.destination = destination;
        this.nbre_place_dispo = nbre_place_dispo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getNbre_place_dispo() {
        return nbre_place_dispo;
    }

    public void setNbre_place_dispo(int nbre_place_dispo) {
        this.nbre_place_dispo = nbre_place_dispo;
    }

    @Override
    public String toString() {
        return "Covoiturage{" + "id=" + id + ", id_user=" + id_user + ", depart=" + depart + ", destination=" + destination + ", nbre_place_dispo=" + nbre_place_dispo + '}';
    }
   
}
