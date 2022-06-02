package com.example.Hafen_DB.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.Hafen_DB.models.Route;

public class DBRoutenController extends DBController {
    
    public ArrayList<Route> getAllRouten(){
    
        // Lokale Normalwaren-Arraylist erstellen
        ArrayList<Route> route = new ArrayList<>();
    
        /*
        SELECT liegt schon im Wort
        FROM liegt schon im Wort
        route ist die Tabelle, aus der ausgewählt wird
        JOIN für einen Foreign Key
        staedte ist die Tabelle, aus der der Key kommt
        s1 ist eine Instanziierung zum Zwischenspeichern (wegen mehrerer Keys)
        ON liegt schon im Wort
        s1.id ist die Spalte, die gewählt werden soll
        = route.start ist die Spalte in der Tabelle, die mit s1.id gleichgesetzt wird. 
        danach geht es mit JOIN wieder weiter für den zweiten Key und so geht es dann weiter, wobei die Variablennamen natürlich abweichen müssen
        */
        String sqlSelectAllRoute = "SELECT * FROM `route` JOIN staedte s1 ON s1.id = route.start JOIN staedte s2 ON s2.id = route.ziel";
    
        try{
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllRoute); 
            ResultSet rs = ps.executeQuery();
            // Solange es Datensätze in der von der DB angefragen Ressource gibt, werden diese durchgearbeitet und dann als eine ArrayList zurückgegeben
            while (rs.next()) {
                //TEST
                System.out.println(rs);
                int id = (int) rs.getLong("id");
                int stadtid = (int) rs.getLong("stadtid");
                String start = rs.getString("start");
                String ziel = rs.getString("ziel");
                int entfernung = (int) rs.getLong("entfernung");
                int fahrtdauer = (int) rs.getLong("fahrtdauer");

                //route.add(new Route(id, ziel, start, entfernung, fahrtdauer, stadtid));
                Route r1 = new Route(id, ziel, start, entfernung, fahrtdauer, stadtid);
                System.out.println(r1);
            }
        }

        catch(SQLException e){
            System.out.println(e);
        }
    
        return route;
    }
}
