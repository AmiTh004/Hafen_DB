package com.example.Hafen_DB.models;

public class Verschiffung {
    
    int id;
    Schiff schiff;
    Route route;

    public Verschiffung(int id, Schiff schiff, Route route){
        setId(id);
        setSchiff(schiff);
        setRoute(route);
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
    public void setSchiff(Schiff schiff) {
        this.schiff = schiff;
    }
    public Schiff getSchiff() {
        return schiff;
    }
    public void setRoute(Route route) {
        this.route = route;
    }
    public Route getRoute() {
        return route;
    }
}
