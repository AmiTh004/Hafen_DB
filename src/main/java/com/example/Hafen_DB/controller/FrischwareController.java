package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.Frischware;
import com.example.Hafen_DB.controller.FrischwareController;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class FrischwareController {
    
    DBController dbc;

    public ArrayList<Frischware> getAllFrischwaren(){

        // Lokale Frischwaren-Arraylist erstellen
        ArrayList<Frischware> frischwaren = new ArrayList<>();

        // Das ist DB-Query
        String sqlSelectAllFrischwaren = "SELECT * FROM `frischware`";

        // Verbindung aufbauen mit USERNAME root und PASSWORT root
        try{
            Connection conn = DriverManager.getConnection(dbc.getConnectionUrl(), dbc.getUsername(), dbc.getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllFrischwaren); 
            ResultSet rs = ps.executeQuery();
            // Solange es Datensätze in der von der DB angefragen Ressource gibt, werden diese durchgearbeitet und dann als eine ArrayList zurückgegeben
            while (rs.next()) {
                int id = (int) rs.getLong("id");
                String frischware_name = rs.getString("frischware_name");
                frischwaren.add(new Frischware(id, frischware_name));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }

        return frischwaren;
    }


}
