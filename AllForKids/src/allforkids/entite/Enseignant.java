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
public class Enseignant extends User{
    
   
    private String nom;
    private String prenom;
    private int cin;
    private String nom_club;
    private int montant;
    static Enseignant instance;
 
 

    public Enseignant( int id_user, int cin,String nom, String prenom, String pseudo, String mdp,String email,int montant, String nom_club) {
        super(id_user, pseudo, mdp, email);
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.nom_club = nom_club;
        this.montant = montant;
    }

    public Enseignant(int cin,String nom, String prenom, String pseudo, String mdp,String email,int montant, String nom_club) {
        super(pseudo, mdp, email);
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.nom_club = nom_club;
        this.montant = montant;
    }

    @Override
    public String toString() {
        //super.toString();
        return "Enseignant{"+"cin= "+ cin + ", nom=" + nom + ", prenom=" + prenom + ", "+ super.toString()+", montant=" + montant +", nom_club=" + nom_club + '}';
    
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

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom_club() {
        return nom_club;
    }

    public void setNom_club(String nom_club) {
        this.nom_club = nom_club;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

   
}

