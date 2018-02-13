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
public class Evaluation {
    private int id_evaluation;
    private String matiere;
    private float moyenne;
    private String remarque;
    private String nom_enfant;

  private String prenom_enfant;
    public Evaluation(int id_evaluation, String matiere, float moyenne, String remarque,String nom_enfant,String prenom_enfant) {
        this.id_evaluation = id_evaluation;
        this.matiere = matiere;
        this.moyenne = moyenne;
        this.remarque = remarque;
         this.nom_enfant=nom_enfant;
        this.prenom_enfant=prenom_enfant;
    }

    public Evaluation(String matiere, float moyenne, String remarque,String nom_enfant,String prenom_enfant) {
        this.matiere = matiere;
        this.moyenne = moyenne;
        this.remarque = remarque;
        this.nom_enfant=nom_enfant;
        this.prenom_enfant=prenom_enfant;
    }

    public int getId_evaluation() {
        return id_evaluation;
    }

    public void setId_evaluation(int id_evaluation) {
        this.id_evaluation = id_evaluation;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public String getNom_enfant() {
        return nom_enfant;
    }

    public void setNom_enfant(String nom_enfant) {
        this.nom_enfant = nom_enfant;
    }

    public String getPrenom_enfant() {
        return prenom_enfant;
    }

    public void setPrenom_enfant(String prenom_enfant) {
        this.prenom_enfant = prenom_enfant;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "id_evaluation=" + id_evaluation + ", matiere=" + matiere + ", moyenne=" + moyenne + ", remarque=" + remarque + ", nom_enfant=" + nom_enfant + ", prenom_enfant=" + prenom_enfant + '}';
    }

    
    
}
