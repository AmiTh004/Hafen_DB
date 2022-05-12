package com.example.Hafen_DB.models;

public class Tierart {
    int id;
    String tierart_name;

    public Tierart(int id, String tierart_name){
        setId(id);
        setTierartenname(tierart_name);
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
    public String getTierartenname() {
        return tierart_name;
    }
    public void setTierartenname(String tierartenname) {
        this.tierart_name = tierartenname;
    }
}
