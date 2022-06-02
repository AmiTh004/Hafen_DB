package com.example.Hafen_DB.models;

public class Wertgegenstand {
    
    int id;
    String wertgegenstaende_name;

    public Wertgegenstand(int id, String wertgegenstaende_name){
        setId(id);
        setWertgegenstaende_name(wertgegenstaende_name);
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
    public String getWertgegenstaende_name() {
        return wertgegenstaende_name;
    }
    public void setWertgegenstaende_name(String wertgegenstaende_name) {
        this.wertgegenstaende_name = wertgegenstaende_name;
    }
}
