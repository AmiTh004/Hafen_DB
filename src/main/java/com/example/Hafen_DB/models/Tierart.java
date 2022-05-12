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
    public void setTierartenname(String tierart_name) {
        this.tierart_name = tierart_name;
    }
}
