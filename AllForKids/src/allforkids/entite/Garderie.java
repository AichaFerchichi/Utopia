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
public class Garderie {
    private int id_garderie;
    private int id_enfant;
private String description;
   
    private String nom;
    private  String adresse;
    private int num_tel;

    public Garderie(int id_garderie,int id_enfant,String nom, String adresse, int num_tel,String description) {
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.id_garderie=id_garderie;
        this.id_enfant=id_enfant;
        this.description=description;
    }
     public Garderie(String nom, String adresse, int num_tel) {
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.id_garderie=id_garderie;
        this.id_enfant=id_enfant;
        
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
     public Garderie(String nom, String adresse, int num_tel,String description) {
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.description=description;
        
    }
    public Garderie(int id_enfant,String nom, String adresse, int num_tel,String description) {
        this.nom = nom;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.id_enfant=id_enfant;
        this.description=description;
    }
 public int getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(int id_enfant) {
        this.id_enfant = id_enfant;
    }
    public int getId_garderie() {
        return id_garderie;
    }

    public void setId_garderie(int id_garderie) {
        this.id_garderie = id_garderie;
    }
    public Garderie(){
    
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

    @Override
    public String toString() {
        return "est le nom de l'enfant::Garderie{" + " nom=" + nom + ", adresse=" + adresse + ", num_tel=" + num_tel +", descritpion=" + description + '}';
    }
    
    
    
    
}

