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
        String sqlSelectAllRoute = "SELECT * FROM `route` JOIN `staedte` s1 ON s1.id = route.start JOIN `staedte` s2 ON s2.id = route.ziel ";
    
        try{
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllRoute); 
            ResultSet rs = ps.executeQuery();
            // Solange es Datensätze in der von der DB angefragen Ressource gibt, werden diese durchgearbeitet und dann als eine ArrayList zurückgegeben
            while (rs.next()) {
                //TEST
                //WICHTIG: java startId= html start, java start = html name
                System.out.println(rs);
                int id = (int) rs.getLong("id");
                int startId = (int) rs.getLong("start");
                //Weil ColumnLabel "name" doppelt ist, über den Index, erste Spalte index=1
                String start = rs.getString(7);
                int zielId = (int) rs.getLong("ziel");
                String ziel = rs.getString(9);
                int entfernung = (int) rs.getLong("entfernung");
                int fahrtdauer = (int) rs.getLong("fahrtdauer");

                //route.add(new Route(id, ziel, start, entfernung, fahrtdauer, stadtid));
                Route r1 = new Route(id, ziel, start, entfernung, fahrtdauer, startId, zielId);
                System.out.println("Route wird ausgegeben");
                System.out.println(r1);
                route.add(r1);
            }
        }

        catch(SQLException e){
            System.out.println(e);
        }
    
        return route;
    }

    //Füge eine neue Route hinzu
    public void addNewRoute(int zielId, int startId, int entfernung, int fahrtdauer){
        try {
            String sqlSelectAllPersons = "INSERT INTO route (ziel, start, entfernung, fahrtdauer) VALUES('"+zielId+"','"+startId+"', '"+entfernung+"','"+fahrtdauer+"');";
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort());
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
            //als Return von executeUpdate kommt 0 (fail) oder 1 (ok) zurück
            int rs = ps.executeUpdate();
            System.out.println(rs);
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Lösche eine Route
    public void delRoute(int id) {
        try {
            String sqlSelectAllPersons = "DELETE FROM route WHERE id="+String.valueOf(id);
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort());
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
            //als Return von executeUpdate kommt 0 (fail) oder 1 (ok) zurück
            int rs = ps.executeUpdate();
            System.out.println(rs);
            
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
    }

    //Hohle spezifische Route
    public Route getRoute(int id) {
        Route route = null;
        try {
            String sqlSelectToDo = "SELECT * FROM `route` JOIN `staedte` s1 ON s1.id = route.start JOIN `staedte` s2 ON s2.id = route.ziel WHERE todos.id="+String.valueOf(id);
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort());
            PreparedStatement ps = conn.prepareStatement(sqlSelectToDo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int routeId = (int) rs.getLong("id");
                int zielId = (int) rs.getLong("ziel");
                String ziel = rs.getString(9);
                int startId = (int) rs.getLong("start");
                String start = rs.getString(7);
                int entfernung = (int) rs.getLong("entfernung");
                int fahrtdauer = (int) rs.getLong("fahrtdauer");
                route = new Route(routeId, ziel, start, entfernung, fahrtdauer, startId, zielId);
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }

        return route;
    }

    //Hohle spezifische Route und aktualisiere diese
    public Route updateRoute(int id, int entfernung, int fahrtdauer, int startId, int zielId) {
        Route route = null;
        try {
            String sqlSelectAllPersons = "UPDATE route SET ziel='"+zielId+"', start='"+startId+"', entfernung='"+entfernung+"', fahrtdauer='"+fahrtdauer+"' WHERE id="+String.valueOf(id);
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort());
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
            ps.executeUpdate();
        } 
        catch (SQLException e) {
            System.out.println(e);
        }
        
        return route;
    }

    
}
