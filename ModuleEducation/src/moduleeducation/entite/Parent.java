/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduleeducation.entite;

/**
 *
 * @author MacBook
 */
public class Parent extends User{
    
     private int cin;
    private String nom;
    private String prenom;
     private String adresse;
    private int montant;

    public Parent(int id_user,int cin, String nom, String prenom,String pseudo, String mdp,String email,String adresse, int montant) {
        super(id_user, pseudo, mdp, email);
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.montant = montant;
    }

    public Parent(int cin, String nom, String prenom, String pseudo, String mdp, String email, String adresse,int montant) {
        super(pseudo, mdp, email);
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.montant = montant;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Parent{" + "cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", "+ super.toString()+", adresse=" + adresse + ", montant=" + montant + '}';
    }
    

   
}
