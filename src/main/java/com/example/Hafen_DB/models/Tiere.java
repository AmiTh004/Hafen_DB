package com.example.Hafen_DB.models;

public class Tiere {
    
    int id;
    Tierart tierart;
    String tier_name;

    public Tiere(int id, Tierart tierart, String tier_name){
        setId(id);
        setTierart(tierart);
        setTier_name(tier_name);
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
    public void setTierart(Tierart tierart) {
        this.tierart = tierart;
    }
    public Tierart getTierart() {
        return tierart;
    }
    public void setTier_name(String tier_name) {
        this.tier_name = tier_name;
    }
    public String getTier_name() {
        return tier_name;
    }
}
