package com.example.Hafen_DB.models;

public class Route {
    
    int id;
    String ziel;
    String start;
    int stadtid;

    int entfernung;
    int fahrtdauer;

    public Route(int id, String ziel, String start, int entfernung, int fahrtdauer, int stadtid){
        setId(id);
        setStadtid(stadtid);
        setStart(start);
        setZiel(ziel);
        setEntfernung(entfernung);
        setFahrtdauer(fahrtdauer);
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
    public void setStadtid(int stadtid) {
        this.stadtid = stadtid;
    }
    public int getStadtid() {
        return stadtid;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getStart() {
        return start;
    }
    public void setZiel(String ziel) {
        this.ziel = ziel;
    }
    public String getZiel() {
        return ziel;
    }
    public void setEntfernung(int entfernung) {
        this.entfernung = entfernung;
    }
    public int getEntfernung() {
        return entfernung;
    }
    public void setFahrtdauer(int fahrtdauer) {
        this.fahrtdauer = fahrtdauer;
    }
    public int getFahrtdauer() {
        return fahrtdauer;
    }
}
