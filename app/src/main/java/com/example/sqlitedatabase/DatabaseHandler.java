package com.example.sqlitedatabase;

/**
 * Created by antoniopedro on 27/04/17.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper{

    private static final int BASEDEDADOS_VERSAO = 2;
    private static final String BASEDEDADOS_NOME = "gestorContactos";
    private static final String TABELA_CONTACTOS = "contactos";
    private static final String CHAVE_ID = "id";
    private static final String CHAVE_NOME = "nome";

    public DatabaseHandler(Context context) {
        super(context, BASEDEDADOS_NOME, null, BASEDEDADOS_VERSAO);
    }

    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABELA_CONTACTOS + "("
                + CHAVE_ID + " INTEGER PRIMARY KEY," + CHAVE_NOME + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_CONTACTOS);

        onCreate(db);
    }

    public void adicionarContacto(Contacto contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(CHAVE_NOME, contact.getNome());
        db.insert(TABELA_CONTACTOS, null, values);
        db.close();
    }

    public List<Contacto> getAllContacts() {

        List<Contacto> contactList = new ArrayList<Contacto>();
        String selectQuery = "SELECT  * FROM " + TABELA_CONTACTOS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Contacto contact = new Contacto();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setNome(cursor.getString(1));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        return contactList;
    }
}
