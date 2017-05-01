package com.example.sqlitedatabase;

/**
 * Created by antoniopedro on 27/04/17.
 */

public class Contacto {

    int id;
    String nome;

    public Contacto(){

    }

    public Contacto(String nome){
        this.nome = nome;
    }

    public int getID(){
        return this.id;
    }

    public void setID(int id){
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
