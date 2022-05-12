package com.example.Hafen_DB.models;

public class Kapitaen {
    
    int id;
    Person person;

    public Kapitaen(int id, Person person){
        setId(id);
        setPerson(person);
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
    public void setPerson(Person person) {
        this.person = person;
    }
    public Person getPerson() {
        return person;
    }

}
