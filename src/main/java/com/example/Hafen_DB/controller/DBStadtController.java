package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.Stadt;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBStadtController {
    
    DBController dbc;

    public ArrayList<Stadt> getAllStadt(){

        // Lokale Städte-Arraylist erstellen
        ArrayList<Stadt> stadt = new ArrayList<>();

        // Das ist DB-Query
        String sqlSelectAllStaedte = "SELECT * FROM `staedte`";

        try{
            Connection conn = DriverManager.getConnection(dbc.getConnectionUrl(), dbc.getUsername(), dbc.getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllStaedte); 
            ResultSet rs = ps.executeQuery();
            // Solange es Datensätze in der von der DB angefragen Ressource gibt, werden diese durchgearbeitet und dann als eine ArrayList zurückgegeben
            while (rs.next()) {
                int id = (int) rs.getLong("id");
                String name = rs.getString("name");
                stadt.add(new Stadt(id, name));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }

       return stadt;
    }
}
