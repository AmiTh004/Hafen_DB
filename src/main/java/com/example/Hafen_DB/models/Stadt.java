package com.example.Hafen_DB.models;

public class Stadt {
    int id;
    String name;

    public Stadt(int id, String name){
        setId(id);
        setName(name);
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
