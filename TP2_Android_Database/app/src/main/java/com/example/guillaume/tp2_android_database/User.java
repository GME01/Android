package com.example.guillaume.tp2_android_database;

import java.io.Serializable;

/**
 * Created by Guillaume on 24/11/2017.
 */

public class User implements Serializable {

    private int id;
    private String name;
    private String phone;

    public User(){}

    public User(int id, String name, String phone){
        this.id = id;
        this.name = name;
        this.phone = phone;
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
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String toString(){
        return "ID : "+id+"\nName : "+name+"\nPhone :"+phone;
    }

}
