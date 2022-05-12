package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.Tierart;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class TierartController {

    DBController dbc;

    public ArrayList<Tierart> getAllTierart(){

    // Lokale Personen-Arraylist erstellen
    ArrayList<Tierart> tierart = new ArrayList<>();

    // Das ist DB-Query
    String sqlSelectAllTierart = "SELECT * FROM `tierliste`";

    try{
        Connection conn = DriverManager.getConnection(dbc.getConnectionUrl(), dbc.getUsername(), dbc.getPasswort()); 
        PreparedStatement ps = conn.prepareStatement(sqlSelectAllTierart); 
        ResultSet rs = ps.executeQuery();
        // Solange es Datensätze in der von der DB angefragen Ressource gibt, werden diese durchgearbeitet und dann als eine ArrayList zurückgegeben
        while (rs.next()) {
            int id = (int) rs.getLong("id");
            String tierart_name = rs.getString("tierart_name");
            tierart.add(new Tierart(id, tierart_name));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }

        return tierart;
    }
}