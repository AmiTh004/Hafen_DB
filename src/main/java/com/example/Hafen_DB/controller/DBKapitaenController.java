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
    
        String sqlSelectAllKapitaene = "SELECT * FROM `kapitaene` JOIN person ON person.id=kapitaene.person";
    
        try{
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllKapitaene); 
            ResultSet rs = ps.executeQuery();
            // Solange es Datensätze in der von der DB angefragen Ressource gibt, werden diese durchgearbeitet und dann als eine ArrayList zurückgegeben
            while (rs.next()) {
                int id = (int) rs.getLong("id");
                int personid = (int) rs.getLong("person");
                String vorname = rs.getString( "vorname");
                String nachname = rs.getString( "nachname");

                kapitaen.add(new Kapitaen(id, vorname, nachname, personid));
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
                int personid =  (int) rs.getLong("personid");
                kapitaen = new Kapitaen(kapitaenId, vorname, nachname, personid);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }

        return kapitaen;
    }
}