package com.example.Hafen_DB.controller;

import com.example.Hafen_DB.models.Wertgegenstand;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBWertgegenstandController extends DBController{
    
    
    public ArrayList<Wertgegenstand> getAllWertgegenstaende(){
    
        ArrayList<Wertgegenstand> wertgegenstand = new ArrayList<>();
        // Das ist DB-Query
        String sqlSelectAllWertgegenstaende = "SELECT * FROM `wertgegenstaende`";
    
        try{
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllWertgegenstaende); 
            ResultSet rs = ps.executeQuery();
            //Solange es Datensätze in der von der DB angefragen Ressource gibt, werden diese durchgearbeitet und dann als eine ArrayList zurückgegeben
            while (rs.next()) {
                int id = (int) rs.getLong("id");
                String wertgegenstaende_name = rs.getString("wertgegenstaende_nameeeeee");
                wertgegenstand.add(new Wertgegenstand(id, wertgegenstaende_name));
                }
            }
            catch(SQLException e){
                System.out.println(e);
            }
        return wertgegenstand;
    }



    // Füge neuen Wetgegenstand hinzu
    public void addNeWertgegenstand(String wertgegenstaende_name) {
        try{
            String sqlSelectAllWertgegenstaende = "INSERT INTO wertgegenstaende(wertgegenstaende_name) VALUES('"+wertgegenstaende_name+"');";
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort());
            //Rückfrage!
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllWertgegenstaende); 
            // als Return von executeUpdate kommt 0 (FAIL) oder 1 (OK!) zurück
            int rs = ps.executeUpdate();
            System.out.println(rs);
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    // Lösche einen Wertgegenstand
    public void delWertgegenstand(int id){
        try{

            String sqlSelectAllWertgegenstaende = "DELETE FROM wertgegenstaende WHERE id="+String.valueOf(id);
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort());
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllWertgegenstaende); 
            // als Return von executeUpdate kommt 0 (FAIL) oder 1 (OK!) zurück
            int rs = ps.executeUpdate();
            System.out.println(rs);
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }


    // Hole spezifischen Wertgegenstand
    public Wertgegenstand getWertgegenstand(int id){
        Wertgegenstand wertgegenstand = null;
        try{
            String sqlSelectAllWertgegenstaende = "SELECT * FROM `wertgegenstaende` WHERE wertgegenstaende.id="+String.valueOf(id);
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllWertgegenstaende); 
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int wertgegenstaendeID = (int) rs.getLong("id");
                String wertgegenstaende_name = rs.getString("wertgegenstaende_name");
                wertgegenstand = new Wertgegenstand(wertgegenstaendeID, wertgegenstaende_name);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }

        return wertgegenstand;
    }

    // Hole spezifischen Bahnhof und aktualisiere diese ab
    public Wertgegenstand updateWertgegenstand(int id, String wertgegenstaende_name){
        Wertgegenstand wertgegenstand = null;
        try{
            String sqlSelectAllWertgegenstaende = "UPDATE wertgegenstaende SET wertgegenstaende_name='"+wertgegenstaende_name+"' WHERE id="+String.valueOf(id);
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllWertgegenstaende); 
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }

        return wertgegenstand;
    }
}