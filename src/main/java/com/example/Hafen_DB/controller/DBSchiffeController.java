package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.Schiff;
import java.util.ArrayList;
        
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class DBSchiffeController extends DBController{

        
    public ArrayList<Schiff> getAllSchiffe(){
        
        ArrayList<Schiff> schiff = new ArrayList<>();
        
        String sqlSelectAllSchiffe = "SELECT * FROM `schiffe` JOIN kapitaene k1 ON k1.id = schiffe.kapitaen";
        
        try{
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort()); 
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
    public void addNewSchiff(String schiff_name, String kapitaen) {
        try{
            String sqlSelectAllSchiff = "INSERT INTO schiff(schiff_name, kapitaen) VALUES('"+schiff_name+"', '"+kapitaen+"');";
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort());
            //Rückfrage!
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllSchiff); 
            // als Return von executeUpdate kommt 0 (FAIL) oder 1 (OK!) zurück
            int rs = ps.executeUpdate();
            System.out.println(rs);
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }

    public void delSchiff(int id){
        try{

            String sqlSelectAllSchiff = "DELETE FROM `schiff` WHERE id="+String.valueOf(id);
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort());
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllSchiff); 
            // als Return von executeUpdate kommt 0 (FAIL) oder 1 (OK!) zurück
            int rs = ps.executeUpdate();
            System.out.println(rs);
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }


    public Schiff getSchiff(int id){
        Schiff schiff = null;
        try{
            String sqlSelectAllSchiff = "SELECT * FROM `schiff` WHERE schiff.id="+String.valueOf(id);
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllSchiff); 
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int schiffId = (int) rs.getLong("id");
                String schiff_name = rs.getString("schiff_name");
                String kapitaen = rs.getString("kapitaen");
                schiff = new Schiff(schiffId, schiff_name, kapitaen);
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }

        return schiff;
    }

    // Hole spezifischen Bahnhof und aktualisiere diese ab
    public Schiff updateSchiff(int id, String schiff_name, String kapitaen){
        Schiff schiff = null;
        try{
            String sqlSelectAllSchiff = "UPDATE schiff SET schiff_name='"+schiff_name+"', kapitaen='"+kapitaen+"' WHERE id="+String.valueOf(id);
            Connection conn = DriverManager.getConnection(getConnectionUrl(), getUsername(), getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllSchiff); 
            ps.executeUpdate();
        }
        catch(SQLException e){
            System.out.println(e);
        }

        return schiff;
    }
}