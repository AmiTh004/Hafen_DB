package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.Kapitaen;
import java.util.ArrayList;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
    
public class KapitaenController {
        
    DBController dbc;
    PersonController pc;
    
    public ArrayList<Kapitaen> getAllKapitaene(){
    
        // Lokale Normalwaren-Arraylist erstellen
        ArrayList<Kapitaen> kapitaen = new ArrayList<>();
    
        // Das ist DB-Query
        String sqlSelectAllKapitaene = "SELECT * FROM `kapitaene` JOIN person ON person.id=kapitaene.person";
    
        try{
            Connection conn = DriverManager.getConnection(dbc.getConnectionUrl(), dbc.getUsername(), dbc.getPasswort()); 
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
}
