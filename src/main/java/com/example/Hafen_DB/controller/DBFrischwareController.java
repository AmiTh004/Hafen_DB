package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.Frischware;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBFrischwareController extends DBController {
    


    public DBFrischwareController() {
        
    }

    public ArrayList<Frischware> getAllFrischware(){

        // Lokale Frischwaren-Arraylist erstellen
        ArrayList<Frischware> frischware = new ArrayList<>();

        // Das ist DB-Query
        String sqlSelectAllFrischware = "SELECT * FROM frischware";

        try{
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllFrischware); 
            ResultSet rs = ps.executeQuery();
            // Solange es Datensätze in der von der DB angefragen Ressource gibt, werden diese durchgearbeitet und dann als eine ArrayList zurückgegeben
            while (rs.next()) {
                int id = (int) rs.getLong("id");
                String frischware_name = rs.getString("frischware_name");
                frischware.add(new Frischware(id, frischware_name));
                System.out.println("Läuft");
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }

        return frischware;
    }

    //Füge neue Frischware hinzu
    public void addNewFrischware(String frischware_name){
        try {
            String sqlSelectAllPersons = "INSERT INTO frischware (frischware_name) VALUES('"+frischware_name+"');";
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

    //Lösche eine Frischware
    public void delFrischware(int id) {
        System.out.println(id);
        try {
            String sqlSelectAllPersons = "DELETE FROM `frischware` WHERE id="+String.valueOf(id);
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

    //Hohle spezifische Frischware
    public Frischware getFrischware(int id) {
        Frischware frischware = null;
        try {
            String sqlSelectFrischware = "SELECT * FROM `frischware` WHERE frischware.id="+String.valueOf(id);
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort());
            PreparedStatement ps = conn.prepareStatement(sqlSelectFrischware);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int frischwareId = (int) rs.getLong("id");
                String frischware_name = rs.getString("frischware_name");
                frischware = new Frischware(frischwareId, frischware_name);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }

        return frischware;
    }

    //Hohle spezifische Frischware und aktualisiere diese
    public Frischware updateFrischware(int id, String frischware_name) {
        Frischware frischware = null;
        try {
            String sqlSelectAllPersons = "UPDATE frischware SET frischware_name='"+frischware_name+"' WHERE id="+String.valueOf(id);
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort());
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
            ps.executeUpdate();
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
        
        return frischware;
    }


    


}
