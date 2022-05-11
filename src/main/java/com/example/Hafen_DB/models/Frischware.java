package com.example.Hafen_DB.models;

public class Frischware {
 
    int id;
    String frischware_name;

    public Frischware(int id, String frischware_name){
        setId(id);
        setFrischware_name(frischware_name);
    }

    
    /**
     * 
     * 
     * SETTER UND GETTER
     */
    
    public String getFrischware_name() {
        return frischware_name;
    }
    public void setFrischware_name(String frischware_name) {
        this.frischware_name = frischware_name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}