package com.example.Hafen_DB.models;

public class Route {
    
    int id;
    String ziel;
    int zielId;
    String start;
    int startId;
    int entfernung;
    int fahrtdauer;

    public Route(int id, String ziel, String start, int entfernung, int fahrtdauer, int startId, int zielId){
        setId(id);
        setStartId(startId);
        setStart(start);
        setZiel(ziel);
        setEntfernung(entfernung);
        setFahrtdauer(fahrtdauer);
        setZielId(zielId);
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
    public void setStartId(int startId) {
        this.startId = startId;
    }
    public int getStartId() {
        return startId;
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
    public void setZielId(int zielId) {
        this.zielId = zielId;
    }
    public int getZielId() {
        return zielId;
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
