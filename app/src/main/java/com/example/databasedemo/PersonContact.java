package com.example.databasedemo;

        import android.provider.BaseColumns;

/**
 * Created by Administrator on 25/7/2016.
 */
public class PersonContact {

    public PersonContact(){

    }

    public static abstract class PersonEntry implements BaseColumns{
        public static final String TABLE_NAME = "person";
        public static final String COLUMN_NAME_NAME = "name";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_PHONE = "phone";
    }
}
