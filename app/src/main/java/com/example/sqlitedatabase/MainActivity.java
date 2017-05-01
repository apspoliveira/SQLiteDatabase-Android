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

        //db.onCreate(db.getWritableDatabase());
        db.onUpgrade(db.getWritableDatabase(),1,2);

        Log.d("Inserir: ", "A inserir contactos...");
        db.adicionarContacto(new Contacto("João"));
        db.adicionarContacto(new Contacto("Rodrigo"));
        db.adicionarContacto(new Contacto("Francisco"));
        db.adicionarContacto(new Contacto("Martim"));
        db.adicionarContacto(new Contacto("Santiago"));

        Log.d("Ler: ", "Ler todos os contactos...");
        List<Contacto> contacts = db.getAllContacts();

        for (Contacto cn : contacts) {
            String log = "Id: "+cn.getID()+" ,Nome: " + cn.getNome();
        
            Log.d("Nome: ", log);
        }
    }
}
