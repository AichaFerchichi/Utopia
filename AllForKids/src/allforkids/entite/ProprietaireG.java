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
public class ProprietaireG extends User{
    public ProprietaireG(int id_user, String pseudo, String mdp, String email) {
        super(id_user, pseudo, mdp, email);
    }
   
    public ProprietaireG(int id_user, String pseudo, String mdp, String email,String type) {
        super(id_user, pseudo, mdp, email,type);
    }
   
public ProprietaireG( String pseudo, String mdp, String email,String type) {
        super( pseudo, mdp, email,type);
    }
public ProprietaireG( String pseudo, String mdp, String email) {
        super( pseudo, mdp, email);
    }

    public ProprietaireG() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
       return "ProprietaireG{" + super.toString()+ '}';
        }
    
}
