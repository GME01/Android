package com.example.guillaume.tp2_android_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.guillaume.tp2_android_database.Database;

/**
 * Created by Guillaume on 24/11/2017.
 */

public class Connexion extends SQLiteOpenHelper {


    public Connexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Database.CREATE_TABLE_USER);
        db.execSQL(Database.CREATE_TABLE_PET);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE "+Database.TABLE_USER +";");
        //db.execSQL("DROP TABLE "+Database.TABLE_PET+";");
        onCreate(db);
    }
}
