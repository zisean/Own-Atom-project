package com.example.databasedemo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class AddPersionActivity extends AppCompatActivity {

    private static PersonDbHelper mDbHelper;

    private static EditText editTextName;
    private static EditText editTextEmail;
    private static EditText editTextPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_persion);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDbHelper = new PersonDbHelper(getApplicationContext());
                SQLiteDatabase db = mDbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(PersonContact.PersonEntry.COLUMN_NAME_NAME, editTextName.getText().toString());
                values.put(PersonContact.PersonEntry.COLUMN_NAME_EMAIL, editTextEmail.getText().toString());
                values.put(PersonContact.PersonEntry.COLUMN_NAME_PHONE, editTextPhone.getText().toString());

                long id = db.insert(PersonContact.PersonEntry.TABLE_NAME, null, values);

                Log.d("New Row ID", Long.toString(id));

                finish();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextName =(EditText) findViewById(R.id.name);
        editTextEmail=(EditText) findViewById(R.id.email);
        editTextPhone = (EditText) findViewById(R.id.email);
    }

}
