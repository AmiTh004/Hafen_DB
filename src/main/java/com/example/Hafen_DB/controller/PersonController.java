package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.Person;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PersonController {
    
    DBController dbc;

    public ArrayList<Person> getAllPerson(){

        // Lokale Personen-Arraylist erstellen
        ArrayList<Person> person = new ArrayList<>();

        // Das ist DB-Query
        String sqlSelectAllPerson = "SELECT * FROM `personen`";

        try{
            Connection conn = DriverManager.getConnection(dbc.getConnectionUrl(), dbc.getUsername(), dbc.getPasswort()); 
            PreparedStatement ps = conn.prepareStatement(sqlSelectAllPerson); 
            ResultSet rs = ps.executeQuery();
            // Solange es Datensätze in der von der DB angefragen Ressource gibt, werden diese durchgearbeitet und dann als eine ArrayList zurückgegeben
            while (rs.next()) {
                int id = (int) rs.getLong("id");
                String vorname = rs.getString("vorname");
                String nachname = rs.getString("nachname");
                person.add(new Person(id, vorname, nachname));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }

       return person;
    }
}