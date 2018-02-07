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
public class Enfant {
    private int id_enfant;
    private int id_parent;
    private String nom;
    private String prenom;
    private int age;

    public Enfant( int id_parent, String nom, String prenom, int age) {
        //this.id_enfant = id_enfant;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.id_parent=id_parent;
    }
    public Enfant(  String nom, String prenom) {
        //this.id_enfant = id_enfant;
        this.nom = nom;
        this.prenom = prenom;
        
    }

    public Enfant(int id_enfant, int id_parent, String nom, String prenom, int age) {
        this.id_enfant = id_enfant;
        this.id_parent = id_parent;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

  

    @Override
    public String toString() {
        return "Enfant{"+"id_parent="+id_parent+ " nom=" + nom + ", prenom=" + prenom + ", age=" + age + '}';
    }

    public int getId_enfant() {
        return id_enfant;
    }

    public void setId_enfant(int id_enfant) {
        this.id_enfant = id_enfant;
    }

    public int getId_parent() {
        return id_parent;
    }

    public void setId_parent(int id_parent) {
        this.id_parent = id_parent;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
