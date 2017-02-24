package com.example.andrea.boc_bitsofcode;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by federica on 17/01/17.
 */

public class Quesito4{

    public String quesito,funzione, tipo, stringa ;
    public int num;
    public Quesito4 (String quesito, String funzione, String tipo, int num, String stringa){
        this.tipo = tipo;
        this.num = num;
        this.stringa= stringa;
        this.quesito = quesito;
        this.funzione = funzione;
    }

    String getQuesito(){
        return quesito;
    }

    String getTipo(){ return tipo;}

    String getStringa() {return stringa;}

    int getNum(){ return num;}

    String getFunzione(){
        return funzione;
    }
}