package com.example.sqlitedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.adicionarContacto(new Contacto("Pedro"));
        db.adicionarContacto(new Contacto("João"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contacto> contacts = db.getAllContacts();

        for (Contacto cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Name: " + cn.getNome();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
}
