package com.example.databasedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 25/7/2016.
 */
public class PersonDbHelper extends SQLiteOpenHelper {
    public static final int DATEBASE_VERSION = 1;
    public static final  String DATABASE_NAME = "person.db";

    /*
    CREATE TABLE PERSON(
        ID INTEGER PRIMARY KEY,
        NAME TEXT,
        EMAIL TEXT,
        PHONE TEXT);
     */

    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " +
            PersonContact.PersonEntry.TABLE_NAME + "(" +
            PersonContact.PersonEntry._ID + " INTEGER PRIMARY KEY," +
            PersonContact.PersonEntry.COLUMN_NAME_NAME + " TEXT," +
            PersonContact.PersonEntry.COLUMN_NAME_EMAIL + " TEXT," +
            PersonContact.PersonEntry.COLUMN_NAME_PHONE + " TEXT" +
            ")";

    public PersonDbHelper (Context context) {
        super(context, DATABASE_NAME, null, DATEBASE_VERSION);
    }
    public  void  onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){}
}
