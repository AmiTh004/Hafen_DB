package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.Kapitaen;
import java.util.ArrayList;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
    
public class DBKapitaenController extends DBController{
        
    
    public ArrayList<Kapitaen> getAllKapitaene(){
    
        ArrayList<Kapitaen> kapitaen = new ArrayList<>();
    
        String sqlSelectAllKapitaene = "SELECT * FROM `kapitaene`";
    
        try{
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllKapitaene); 
            ResultSet rs = ps.executeQuery();
            // Solange es Datensätze in der von der DB angefragen Ressource gibt, werden diese durchgearbeitet und dann als eine ArrayList zurückgegeben
            while (rs.next()) {
                int id = (int) rs.getLong("id");
                String vorname = rs.getString( "vorname");
                String nachname = rs.getString( "nachname");

                kapitaen.add(new Kapitaen(id, vorname, nachname));
            }
        }

        catch(SQLException e){
            System.out.println(e);
        }
    
        return kapitaen;
    }

    public Kapitaen getKapitaen(int id){
        Kapitaen kapitaen = null;
        try{
            String sqlSelectAllKapitaen = "SELECT * FROM `kapitaen` WHERE kapitaen.id="+String.valueOf(id);
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllKapitaen); 
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int kapitaenId = (int) rs.getLong("kapitaenId");
                String vorname = rs.getString("vorname");
                String nachname = rs.getString("nachname");
                kapitaen = new Kapitaen(kapitaenId, vorname, nachname);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }

        return kapitaen;
    }

    public void addNewKapitaen(String vorname, String nachname){
        try {
            String sqlSelectAllPersons = "INSERT INTO kapitaen (vorname, nachname) VALUES('"+vorname+"', '"+nachname+"');";
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort());
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
            //als Return von executeUpdate kommt 0 (fail) oder 1 (ok) zurück
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delKapitaen(int id) {
        try {
            String sqlSelectAllPersons = "DELETE FROM `kapitaen` WHERE id="+String.valueOf(id);
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort());
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
            //als Return von executeUpdate kommt 0 (fail) oder 1 (ok) zurück
            int rs = ps.executeUpdate();
            System.out.println(rs);
            
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Kapitaen updateKapitaen(int id, String vorname, String nachname) {
        Kapitaen kapitaen = null;
        try {
            String sqlSelectAllPersons = "UPDATE `kapitaen` SET vorname='"+vorname+"', nachname='"+nachname+"' WHERE id="+String.valueOf(id);
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort());
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
            //ps.executeUpdate();
            //als Return von executeUpdate kommt 0 (fail) oder 1 (ok) zurück
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
        
        return kapitaen;
    }
    
}