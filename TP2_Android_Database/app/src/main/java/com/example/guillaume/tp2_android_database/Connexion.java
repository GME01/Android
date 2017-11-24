package com.example.guillaume.tp2_android_database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.guillaume.tp2_android_database.Database;
import java.sql.DatabaseMetaData;

/**
 * Created by Guillaume on 24/11/2017.
 */

public class Connexion extends SQLiteOpenHelper {


    public Connexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Database.TABLE_USER);
        // TP 2.2
        //db.execSQL(DatabaseMetaData.CREATE_TALBE_ANIMAUX);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Database.TABLE_USER);
        //db.execSQL("DROP TABLE IF EXISTS " + DatabaseMetaData.TABLE_ANIMAUX);
        onCreate(db);
    }
}
