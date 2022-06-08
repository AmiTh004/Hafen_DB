package com.example.Hafen_DB.models;

public class Route {
    
    int id;
    String ziel;
    int id_zielStadt;
    String start;
    int id_startStadt;

    int entfernung;
    int fahrtdauer;

    public Route(int id, String ziel, String start, int entfernung, int fahrtdauer, int id_startStadt, int id_zielStadt){
        setId(id);
        setId_startStadt(id_startStadt);
        setStart(start);
        setZiel(ziel);
        setEntfernung(entfernung);
        setFahrtdauer(fahrtdauer);
        setId_zielStadt(id_zielStadt);
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
    public void setId_startStadt(int id_startStadt) {
        this.id_startStadt = id_startStadt;
    }
    public int getId_startStadt() {
        return id_startStadt;
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
    public void setId_zielStadt(int id_zielStadt) {
        this.id_zielStadt = id_zielStadt;
    }
    public int getId_zielStadt() {
        return id_zielStadt;
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
