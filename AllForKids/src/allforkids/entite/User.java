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
public class User {
    private int id_user;
   
    private String pseudo;
    private String mdp;
   
    private String email;

    public User() {
    }
   
    

    public User(int id_user, String pseudo, String mdp, String email) {
        this.id_user = id_user;
       
        this.pseudo = pseudo;
        this.mdp = mdp;
        
        this.email = email;
       
       
    }

    public User(String pseudo, String mdp, String email) {
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
        
    }

    @Override
    public String toString() {
        return  " pseudo=" + pseudo + ", mdp=" +mdp + ", email=" + email ;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

  

   
}

