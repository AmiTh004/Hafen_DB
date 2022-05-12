package com.example.Hafen_DB.models;

public class Person {
    int id;
    String vorname;
    String nachname;

    public Person(int id, String vorname, String nachname){
        setId(id);
        setVorname(vorname);
        setNachname(nachname);
    }
    /**
     * 
     * 
     * SETTER UND GETTER
     */
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNachname() {
        return nachname;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    public String getVorname() {
        return vorname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
}
