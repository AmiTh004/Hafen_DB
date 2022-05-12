package com.example.Hafen_DB.models;

public class Route {
    
    int id;
    Staedte ziel;
    Staedte start;
    int entfernung;
    int fahrtdauer;

    public Route(int id, Staedte ziel, Staedte start, int entfernung, int fahrtdauer){
        setId(id);
        setZiel(ziel);
        setStart(start);
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
    public void setZiel(Staedte ziel) {
        this.ziel = ziel;
    }
    public Staedte getZiel() {
        return ziel;
    }
    public void setStart(Staedte start) {
        this.start = start;
    }
    public Staedte getStart() {
        return start;
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
