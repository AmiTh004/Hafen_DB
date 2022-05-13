package com.example.Hafen_DB.models;

public class Kapitaen {
    
    int id;
    int personid;
    String vorname;
    String nachname;

    public Kapitaen(int id, String vorname, String nachname, int personid){
        setId(id);
        setNachname(nachname);
        setVorname(vorname);
    }

    /**
     * 
     * 
     * SETTER UND GETTER
     */

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
    public String getNachname() {
        return nachname;
    }
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }
    public String getVorname() {
        return vorname;
    }
    public void setPersonid(int personid) {
        this.personid = personid;
    }
    public int getPersonid() {
        return personid;
    }
}
