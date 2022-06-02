package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.Frischware;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class FrischwareController extends DBController{
    
    DBController dbc;

    public ArrayList<Frischware> getAllFrischware(){

        // Lokale Frischwaren-Arraylist erstellen
        ArrayList<Frischware> frischware = new ArrayList<>();

        // Das ist DB-Query
        String sqlSelectAllFrischware = "SELECT * FROM `frischware`";

        try{
            Connection conn = DriverManager.getConnection(dbc.getConnectionUrl(), dbc.getUsername(), dbc.getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllFrischware); 
            ResultSet rs = ps.executeQuery();
            // Solange es Datensätze in der von der DB angefragen Ressource gibt, werden diese durchgearbeitet und dann als eine ArrayList zurückgegeben
            while (rs.next()) {
                int id = (int) rs.getLong("id");
                String frischware_name = rs.getString("frischware_name");
                frischware.add(new Frischware(id, frischware_name));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }

        return frischware;
    }


}
