package com.example.andrea.boc_bitsofcode;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by federica on 17/01/17.
 */

public class Quesiti2{

    public String quesito,tipo, nome, parametro, variabile, creavar, nomeVar;

    public Quesiti2 (String quesito, String tipo, String nome, String parametro, String creavar, String variabile, String nomeVar){
        this.nome = nome;
        this.variabile = variabile;
        this.parametro = parametro;
        this.quesito = quesito;
        this.tipo = tipo;
        this.nomeVar = nomeVar;
        this.creavar = creavar;
    }

    String getQuesito(){
        return quesito;
    }

    String getTipo(){
        return tipo;
    }

    String getNome(){return nome;}

    String getParametro(){ return parametro;}

    String getVariabile(){return variabile;}

    String getCreavar(){return creavar;}

    String getNomeVar(){return nomeVar;}
}