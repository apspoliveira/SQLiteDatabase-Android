package com.example.sqlitedatabase;

/**
 * Created by antoniopedro on 27/04/17.
 */

public class Contacto {

    int id;
    String nome;

    // Empty constructor
    public Contacto(){

    }

    // constructor
    public Contacto(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    // constructor
    public Contacto(String nome){
        this.nome = nome;
    }

    // getting name
    public int getID(){
        return this.id;
    }

    // getting name
    public void setID(int id){
        this.id = id;
    }

    // getting name
    public String getNome(){
        return this.nome;
    }

    // getting name
    public void setNome(String nome){
        this.nome = nome;
    }
}
