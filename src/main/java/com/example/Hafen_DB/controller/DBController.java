package com.example.Hafen_DB.controller;
import com.example.Hafen_DB.models.*;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class DBController {
    
    String connectionUrl;
    String username;
    String passwort;

    public DBController(){
        // ACHTUNG! Hier den Port entsprechend XAMPP austauschen, z.B. jdbc:mysql://localhost:3306/javadb
        // javadb ist der Name der Datenbank, kann auch bei euch anders sein!
        setConnectionUrl("jdbc:mysql://localhost:3306/javadb");
        setPasswort("root");
        setUsername("root");
    }




    
    /**
     * 
     * 
     * SETTER UND GETTER
     */

    
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public String getUsername() {
        return username;
    }

    public void setConnectionUrl(String connectionUrl) {
        this.connectionUrl = connectionUrl;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }
}
