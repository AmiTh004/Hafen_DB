package com.example.Hafen_DB.controller;

import com.example.Hafen_DB.models.Wertgegenstand;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class WertgegenstandController {
    
    public class TierartController {
    
        DBController dbc;
    
        public ArrayList<Wertgegenstand> getAllWertgegenstand(){
    
            ArrayList<Wertgegenstand> wertgegenstand = new ArrayList<>();
            // Das ist DB-Query
            String sqlSelectAllWertgegenstaende = "SELECT * FROM `wertgegenstaende`";
    
            try{
                Connection conn = DriverManager.getConnection(dbc.getConnectionUrl(), dbc.getUsername(), dbc.getPasswort()); 
                PreparedStatement ps = conn.prepareStatement(sqlSelectAllWertgegenstaende ); 
                ResultSet rs = ps.executeQuery();
                //Solange es Datensätze in der von der DB angefragen Ressource gibt, werden diese durchgearbeitet und dann als eine ArrayList zurückgegeben
                while (rs.next()) {
                    int id = (int) rs.getLong("id");
                    String wertgegenstaende_name = rs.getString("wertgegenstaende_name");
                    wertgegenstand.add(new Wertgegenstand(id, wertgegenstaende_name));
                    }
                }
                catch(SQLException e){
                    System.out.println(e);
                }
    
            return wertgegenstand;
        }
    }
}