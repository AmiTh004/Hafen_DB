package com.example.Hafen_DB.models;

public class Tierarten {
    int id;
    String tierartenname;

    public Tierarten(int id, String tierartenname){
        setId(id);
        setTierartenname(tierartenname);
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
        return tierartenname;
    }
    public void setTierartenname(String tierartenname) {
        this.tierartenname = tierartenname;
    }
}
