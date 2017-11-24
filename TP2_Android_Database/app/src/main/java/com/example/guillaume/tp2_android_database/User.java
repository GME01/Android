package com.example.guillaume.tp2_android_database;

import java.io.Serializable;

/**
 * Created by Guillaume on 24/11/2017.
 */

public class User implements Serializable {
    //Definiion variables

    private Integer id;
    private String prenom;
    private String telephon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephon() {
        return telephon;
    }

    public void setTelephon(String telephon) {
        this.telephon = telephon;
    }
    // private String nomAnimaux

}
