package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.Schiff;

import java.util.ArrayList;
        
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class SchiffeController {

    DBController dbc;
    KapitaenController kc;
        
    public ArrayList<Schiff> getAllSchiffe(){
        
        ArrayList<Schiff> schiff = new ArrayList<>();
        
        String sqlSelectAllSchiffe = "SELECT * FROM `schiffe` JOIN kapitaene k1 ON k1.id = schiffe.kapitaen";
        
        try{
            Connection conn = DriverManager.getConnection(dbc.getConnectionUrl(), dbc.getUsername(), dbc.getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllSchiffe); 
            ResultSet rs = ps.executeQuery();
            // Solange es Datensätze in der von der DB angefragen Ressource gibt, werden diese durchgearbeitet und dann als eine ArrayList zurückgegeben
            while (rs.next()) {
                //TEST
                System.out.println(rs);
                int id = (int) rs.getLong("id");
                String schiff_name = rs.getString("schiff_name");
                String kapitaen = rs.getString("kapitaen");
    
                schiff.add(new Schiff(id, schiff_name, kapitaen));
            }
        }
    
        catch(SQLException e){
            System.out.println(e);
        }
        
        return schiff;
    }
}