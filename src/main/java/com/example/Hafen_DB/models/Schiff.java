package com.example.Hafen_DB.models;

public class Schiff {
    
    int id;
    String schiff_name;
    String kapitaen;

    public Schiff(int id, String schiff_name, String kapitaen){
        setId(id);
        setSchiff_name(schiff_name);
        setKapitaen(kapitaen);
    }
    
    /**
     * 
     *
     *  SETTER UND GETTER
     */

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setSchiff_name(String schiff_name) {
        this.schiff_name = schiff_name;
    }
    public String getSchiff_name() {
        return schiff_name;
    }
    public void setKapitaen(String kapitaen) {
        this.kapitaen = kapitaen;
    }
    public String getKapitaen() {
        return kapitaen;
    }
}
