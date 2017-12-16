package com.example.guillaume.tp2_android_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Guillaume on 24/11/2017.
 */

public class Database {

    private SQLiteDatabase bdd;
    private Connexion myConnexion;
    private static final int VERSION_BDD = 1;
    private static final String NAME_BDD = "tp2App.db";


    public static final String TABLE_USER = "userTable";
    public static final String CHAMP_ID_USER = "user_id";
    public static final int NUM_COL_ID_USER = 0;
    public static final String CHAMP_NAME_USER = "user_name";
    public static final int NUM_COL_NAME_USER = 1;
    public static final String CHAMP_PHONE_USER = "user_phone";
    public static final int NUM_COL_PHONE_USER = 2;


    public static final String TABLE_PET = "petTable";
    public static final String CHAMP_ID_PETS = "pet_id";
    public static final int NUM_COL_ID_PET = 0;
    public static final String CHAMP_NAME_PETS = "pet_name";
    public static final int NUM_COL_NAME_PETS = 1;
    public static final String CHAMP_SPECIES_PETS = "pet_species";
    public static final int NUM_COL_SPECIES_PETS = 2;
    public static final String CHAMP_OWNER_ID= "pet_owner_id";
    public static final int NUM_COL_OWNER_ID = 3;



    public Database(Context context){
        myConnexion = new Connexion(context, NAME_BDD, null, VERSION_BDD);
    }

    public void open(){
        bdd = myConnexion.getWritableDatabase();
    }

    public void close() {
        bdd.close();
    }

    public SQLiteDatabase getDatabase() {
        return bdd;
    }


    //CREATE TABLE USER
    public static final String CREATE_TABLE_USER="CREATE TABLE "+TABLE_USER+" ("+CHAMP_ID_USER+" "+"INTEGER PRIMARY KEY, "
            +CHAMP_NAME_USER+" TEXT, "+CHAMP_PHONE_USER+" TEXT);";

    //CREATE TABLE PET
    public static final String CREATE_TABLE_PET="CREATE TABLE "+TABLE_PET+" ("+CHAMP_ID_PETS+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            CHAMP_NAME_PETS+" TEXT, "+CHAMP_SPECIES_PETS+" TEXT, "+CHAMP_OWNER_ID+" INTEGER);";


    //INSERT USER
    public long insertUser(User user){
        ContentValues values = new ContentValues();
        values.put(CHAMP_ID_USER, user.getId());
        values.put(CHAMP_NAME_USER, user.getName());
        values.put(CHAMP_PHONE_USER, user.getPhone());
        return bdd.insert(TABLE_USER, null, values);
    }

    //UPDATE USER
    public int updateUser(int id,User user){
        ContentValues values = new ContentValues();
        values.put(CHAMP_ID_USER, user.getId());
        values.put(CHAMP_NAME_USER, user.getName());
        values.put(CHAMP_PHONE_USER, user.getPhone());
        return bdd.update(TABLE_USER, values, CHAMP_ID_USER+" = "+id, null);

    }

    //DELETE USER
    public int removeUser(int id){
        return bdd.delete(TABLE_USER, CHAMP_ID_USER+" = "+id, null);
    }

    //GET User in BDD
    public User getUserWithId(int id){
        Cursor c = bdd.query(TABLE_USER, new String[]{CHAMP_ID_USER,CHAMP_NAME_USER,CHAMP_PHONE_USER},
                CHAMP_ID_USER + " LIKE \""+id+"\"",null,null,null,null);
        return cursorToUser(c);
    }

    private User cursorToUser(Cursor c){
        if(c.getCount() == 0){
            return null;
        } else {
            c.moveToFirst();
            User user = new User();
            user.setId(c.getInt(NUM_COL_ID_USER));
            user.setName(c.getString(NUM_COL_NAME_USER));
            user.setPhone(c.getString(NUM_COL_PHONE_USER));
            c.close();
            return user;
        }
    }




    //INSERT PET
    public long insertPet(Pet pet){
        ContentValues values = new ContentValues();
        values.put(CHAMP_NAME_PETS, pet.getName());
        values.put(CHAMP_SPECIES_PETS, pet.getSpecies());
        values.put(CHAMP_OWNER_ID, pet.getOwnerId());
        return bdd.insert(TABLE_PET, null, values);
    }

    //UPDATE PET
    /*public int updatePet(String namePet,Pet pet){
        ContentValues values = new ContentValues();
        values.put(CHAMP_NAME_PETS, pet.getName());
        values.put(CHAMP_SPECIES_PETS, pet.getSpecies());
        values.put(CHAMP_OWNER_ID, pet.getOwnerId());
        return bdd.update(TABLE_PET, values, CHAMP_NAME_PETS+" = "+namePet, null);
    }*/

    //DELETE PET
    /*public int removePet(String namePet){
        return bdd.delete(TABLE_PET, CHAMP_NAME_PETS+" = "+namePet, null);
    }*/

    // GET Pet in BDD
    public Pet getPetWithName(String namePet){
        Cursor cPet = bdd.query(TABLE_PET, new String[]{CHAMP_NAME_PETS,CHAMP_SPECIES_PETS,CHAMP_OWNER_ID},
                CHAMP_NAME_PETS + " LIKE \""+namePet+"\"",null,null,null,null);
        return cursorToPet(cPet);
    }

    private Pet cursorToPet(Cursor cPet){
        if(cPet.getCount() == 0){
            return null;
        } else {
            cPet.moveToFirst();
            Pet pet = new Pet();
            //pet.setId(cPet.getInt(NUM_COL_ID_PET));
            pet.setName(cPet.getString(NUM_COL_NAME_PETS));
            pet.setSpecies(cPet.getString(NUM_COL_SPECIES_PETS));
            pet.setOwnerId(cPet.getInt(NUM_COL_OWNER_ID));
            cPet.close();
            return pet;
        }
    }
}

