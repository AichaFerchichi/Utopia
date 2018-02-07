/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package allforkids.service;

import allforkids.entite.Reservation;
import allforkids.technique.util.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author imen
 */
public class ReservationService implements IAllForKids<Reservation>{
     Connection connexion;
    Statement st;
    ResultSet result;
    static ReservationService instance;
 public static ReservationService getInstance()
    {
    if(instance==null)
    
    instance = new ReservationService();
    return instance;
    
    }
 

    private ReservationService() {
        try {
            DataSource ds = DataSource.getInstance();
            connexion= ds.getConnexion();
            System.out.println("Connection: "+ds.getConnexion());
            System.out.println(connexion);
            st = connexion.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public Reservation getReservationbyId(int id) {
     Reservation p = null ; 
    String req = "select * from reservations where id_reservation="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
        p = new Reservation(result.getInt(1),result.getInt(2),result.getInt(3) ); 
    }   catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ; 
     }

    @Override
    public void insert(Reservation p) {
        String req = "insert into reservations (id_user,nbre_place) values ('" + p.getId_user()+ "','" + p.getNbre_place()+ "')";
        System.out.println(req);
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Reservation> getAll() {
        List<Reservation> list = new ArrayList<>();
        try {
            result = st.executeQuery("select * from reservations join users on users.id_user=reservations.id_user where users.type='parent'");
         
            while (result.next()) {
                Reservation p = new Reservation(result.getInt(1), result.getInt(2), result.getInt(3));
                list.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return list;
    }

    @Override
    public Reservation search(int id) {
                  Reservation p = null ; 
    String req = "select * from reservations where id_Reservation="+id ; 
    try{
        result = st.executeQuery(req) ; 
        result.next() ; 
       p = new Reservation(result.getInt(1), result.getInt(2), result.getInt(3));
        }   catch (SQLException ex) {
            Logger.getLogger(CovoiturageService.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p ;
    }

    
    public boolean delete(Reservation p) {
         String req = "delete from reservations where id_reservation="+p.getId()  ; 
    if(p!=null){
        try{
            st.executeUpdate(req) ;
            return true ; 
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return false ; 
    }

    @Override
    public boolean update(Reservation p) {
         Reservation p1 = getReservationbyId(p.getId()) ; 
    if(p1!=null){
        try{
            st.executeUpdate("update reservations set id_user='"+p.getId_user()+"', nbre_place='"+p.getNbre_place()+"'where id_reservation="+p.getId()) ; 
        } catch (SQLException ex) {
            Logger.getLogger(ReservationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true ; 
    }
    return false ; 
    }

    @Override
    public Map<String, Reservation> getAllMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    
    

