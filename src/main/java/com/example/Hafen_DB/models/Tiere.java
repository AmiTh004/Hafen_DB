package com.example.Hafen_DB.models;

public class Tiere {
    
    int id;
    Tierarten tierart;
    String tier_name;

    public Tiere(int id, Tierarten tierart, String tier_name){
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
    public void setTierart(Tierarten tierart) {
        this.tierart = tierart;
    }
    public Tierarten getTierart() {
        return tierart;
    }
    public void setTier_name(String tier_name) {
        this.tier_name = tier_name;
    }
    public String getTier_name() {
        return tier_name;
    }
}
