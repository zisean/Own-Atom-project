package com.example.databasedemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static PersonDbHelper mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),AddPersionActivity.class);
                    startActivity(intent);

            }
        });
        ArrayList<Long> ids = new ArrayList<Long>();
        ArrayList names = new ArrayList();

        mDbHelper = new PersonDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                PersonContact.PersonEntry._ID,
                PersonContact.PersonEntry.COLUMN_NAME_NAME
        };

        String sortOrder = PersonContact.PersonEntry.COLUMN_NAME_NAME + " ASC";

        Cursor c = db.query(
                PersonContact.PersonEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        if (c.moveToFirst()){
            do {
                long id = c.getLong(c.getColumnIndexOrThrow(PersonContact.PersonEntry._ID));
                String name = c.getString(c.getColumnIndexOrThrow(PersonContact.PersonEntry.COLUMN_NAME_NAME));

                ids.add(new Long(id));
                names.add(name);

            }while (c.moveToNext());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);

        ListView personList = (ListView) findViewById(R.id.person_list);
        personList.setAdapter(adapter);

        personList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public  void  onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Intent intent = new Intent(getApplicationContext(),ViewPersonActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public void onResume(){
        super.onResume();
        ArrayList<Long> ids = new ArrayList<Long>();
        ArrayList names = new ArrayList();

        mDbHelper = new PersonDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                PersonContact.PersonEntry._ID,
                PersonContact.PersonEntry.COLUMN_NAME_NAME
        };

        String sortOrder = PersonContact.PersonEntry.COLUMN_NAME_NAME + " ASC";

        Cursor c = db.query(
                PersonContact.PersonEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                sortOrder
        );

        if (c.moveToFirst()){
            do {
                long id = c.getLong(c.getColumnIndexOrThrow(PersonContact.PersonEntry._ID));
                String name = c.getString(c.getColumnIndexOrThrow(PersonContact.PersonEntry.COLUMN_NAME_NAME));

                ids.add(new Long(id));
                names.add(name);

            }while (c.moveToNext());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, names);

        ListView personList = (ListView) findViewById(R.id.person_list);
        personList.setAdapter(adapter);


    }
}
