/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.entite;

/**
 *
 * @author user
 */
public class Babysitter extends User{
  
    private int cin;
    private String nom;
    private String prenom;
    private String adresse;
    private int num_tel;

    public Babysitter(int id_user,int cin, String nom, String prenom, String adresse,  String pseudo, String mdp, String Email,int num_tel,String type ) {
        super(id_user, pseudo, mdp, Email,type);

        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num_tel = num_tel;
    }
public Babysitter(int id_user,int cin, String nom, String prenom, String adresse,  String pseudo, String mdp, String Email,int num_tel ) {
        super(id_user, pseudo, mdp, Email);

        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num_tel = num_tel;
    }
    public Babysitter(int cin, String nom, String prenom, String pseudo,String mdp,String Email,String adresse, int num_tel,String type) {
        super(pseudo, mdp, Email,type);
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num_tel = num_tel;
    }

    public Babysitter(int cin, String nom, String prenom, String pseudo,String mdp,String Email,String adresse, int num_tel) {
        super(pseudo, mdp, Email);
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.num_tel = num_tel;
    }


    public int getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    @Override
    public String toString() {
        return "Babysitter{" + "cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + super.toString()+", adresse=" + adresse + ", num_tel=" + num_tel + '}';
    }

    
    
 

}