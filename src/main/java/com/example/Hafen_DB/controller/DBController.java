package com.example.Hafen_DB.controller;

public class DBController {
    
    String connectionUrl;
    String username;
    String passwort;

    public DBController(){
        // ACHTUNG! Hier den Port entsprechend XAMPP austauschen, z.B. jdbc:mysql://localhost:3306/javadb
        // javadb ist der Name der Datenbank, kann auch bei euch anders sein!
        setConnectionUrl("jdbc:mysql://localhost:3306/hafen");
        setPasswort("");
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
