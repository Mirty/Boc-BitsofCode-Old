package com.example.andrea.boc_bitsofcode;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by federica on 17/01/17.
 */

public class Quesito {

    public String quesito,tipo;

    public Quesito (String quesito, String tipo){
        this.quesito = quesito;
        this.tipo = tipo;
    }

    String getQuesito(){
        return quesito;
    }

    String getTipo(){
        return tipo;
    }
}