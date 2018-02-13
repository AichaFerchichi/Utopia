/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

/**
 *
 * @author MacBook
 */
public class JardinEnfant {
    private int id_jardinEnfant;
    private int id_enfant;
    private String nom;
    private  String adresse;
    private int num_tel;
    private String description;

    public JardinEnfant(int id_jardinEnfant, int id_enfant, String nom, String adresse, int num_tel,String description) {
        this.id_jardinEnfant = id_jardinEnfant;
        this.id_enfant = id_enfant;
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
    }
     public JardinEnfant(int id_enfant,String nom, String adresse, int num_tel) {
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        
    }

    public JardinEnfant( String nom, String adresse, int num_tel,String description) {
        this.id_enfant = id_enfant;
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
    }

    public int getId_jardinEnfant() {
        return id_jardinEnfant;
    }

    public void setId_jardinEnfant(int id_jardinEnfant) {
        this.id_jardinEnfant = id_jardinEnfant;
    }

    public int getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(int id_enfant) {
        this.id_enfant = id_enfant;
    }

    @Override
    public String toString() {
        return "est le nom de l'enfant::JardinEnfant{" + " nom=" + nom + ", adresse=" + adresse + ", num_tel=" + num_tel + ", description=" + description + '}';
    }

   
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

  
}

