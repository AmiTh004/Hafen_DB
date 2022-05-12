package com.example.Hafen_DB.models;

public class Stadt {
    int id;
    String stadt_name;

    public Stadt(int id, String stadt_name){
        setId(id);
        setStadt_name(stadt_name);
    }

    /**
     * 
     *
     *  SETTER UND GETTER
     */

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getStadt_name() {
        return stadt_name;
    }
    public void setStadt_name(String stadt_name) {
        this.stadt_name = stadt_name;
    }
}
