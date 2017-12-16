package com.example.guillaume.tp2_android_database;

import java.io.Serializable;

/**
 * Created by Guillaume on 15/12/2017.
 */

public class Pet implements Serializable {

    private int id;
    private String name;
    private String species;
    private int ownerId;

    public  Pet(){}

    public Pet(String name, String species, int ownerId){
        this.name = name;
        this.species = species;
        this.ownerId = ownerId;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public Integer getOwnerId(){return ownerId;}
    public void setOwnerId(Integer ownerId){this.ownerId = ownerId;}
    public String toString(){
        return "Name : "+name+"\nSpecies :"+species+"\nOwnerId :"+ownerId;
    }
}
