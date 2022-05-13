package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.Route;
import java.util.ArrayList;
    
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class RouteController {
        
    DBController dbc;
    PersonController pc;
    
    public ArrayList<Route> getAllRouten(){
    
        // Lokale Normalwaren-Arraylist erstellen
        ArrayList<Route> route = new ArrayList<>();
    
        String sqlSelectAllRoute = "SELECT * FROM `route` JOIN staedte s1 ON s1.id = route.start JOIN staedte s2 ON s2.id = route.ziel";
    
        try{
            Connection conn = DriverManager.getConnection(dbc.getConnectionUrl(), dbc.getUsername(), dbc.getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllRoute); 
            ResultSet rs = ps.executeQuery();
            // Solange es Datensätze in der von der DB angefragen Ressource gibt, werden diese durchgearbeitet und dann als eine ArrayList zurückgegeben
            while (rs.next()) {
                //TEST
                System.out.println(rs);
                int id = (int) rs.getLong("id");
                int stadtid = (int) rs.getLong("stadtid");
                //TODO STRING WIRD WAHRSCHEINLICH PROBLEME MACHEN, CAUSE MAN SOLL DAS JA EIGENTLICH AUSWÄHLEN
                String start = rs.getString("start");
                String ziel = rs.getString("ziel");
                int entfernung = (int) rs.getLong("entfernung");
                int fahrtdauer = (int) rs.getLong("fahrtdauer");

                route.add(new Route(id, ziel, start, entfernung, fahrtdauer, stadtid));
            }
        }

        catch(SQLException e){
            System.out.println(e);
        }
    
        return route;
    }
}
