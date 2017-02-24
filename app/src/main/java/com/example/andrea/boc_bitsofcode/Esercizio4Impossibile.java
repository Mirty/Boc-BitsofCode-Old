package com.example.andrea.boc_bitsofcode;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by andrea on 20/02/17.
 */
public class Esercizio4Impossibile {
    String consegna, azione, risultato;
    ArrayList<String> incremento, inizializzazione, condizione;
    Random rand;

    public Esercizio4Impossibile(){
        inizializzazione=new ArrayList<String>();
        condizione=new ArrayList<String>();
        incremento=new ArrayList<String>();
        incremento.add("contatore++");
        incremento.add("contatore+1");
        incremento.add("contatore+ 1");
        incremento.add("contatore +1");
        incremento.add("contatore + 1");
        rand= new Random();
    }

    public void genera(){
        switch (Math.abs(rand.nextInt())%5){
            case 0:
                consegna="Fai contare Bender da 1 a 10, usando la funzione conta(int) che prende un intero come parametro.\nConsiglio:\nPuoi usare contatore come parametro.\nConsiglio:\nInizia a contare da 1";
                inizializzazione.add("contatore=1");
                inizializzazione.add("contatore= 1");
                inizializzazione.add("contatore =1");
                inizializzazione.add("contatore = 1");
                condizione.add("contatore<11");
                condizione.add("contatore< 11");
                condizione.add("contatore <11");
                condizione.add("contatore < 11");
                condizione.add("contatore<=10");
                condizione.add("contatore<= 10");
                condizione.add("contatore <=10");
                condizione.add("contatore <= 10");
                condizione.add("11>contatore");
                condizione.add("11> contatore");
                condizione.add("11 >contatore");
                condizione.add("11 > contatore");
                condizione.add("10>=contatore");
                condizione.add("10>= contatore");
                condizione.add("10 >=contatore");
                condizione.add("10 >= contatore");
                azione="conta(contatore)";
                risultato="1  2  3  4  5  6  7  8  9  10";
                break;
            case 1:
                consegna="Fai fare a Bender 10 passi a destra usando la funzione cammina(string) usando come parametro la stringa \"destra\"\nConsiglio:\nInizia a contare da 0";
                inizializzazione.add("contatore=0");
                inizializzazione.add("contatore= 0");
                inizializzazione.add("contatore =0");
                inizializzazione.add("contatore = 0");
                condizione.add("contatore<10");
                condizione.add("contatore< 10");
                condizione.add("contatore <10");
                condizione.add("contatore < 10");
                condizione.add("contatore<=9");
                condizione.add("contatore<= 9");
                condizione.add("contatore <=9");
                condizione.add("contatore <= 9");
                condizione.add("10>contatore");
                condizione.add("10> contatore");
                condizione.add("10 >contatore");
                condizione.add("10 > contatore");
                condizione.add("9>=contatore");
                condizione.add("9>= contatore");
                condizione.add("9 >=contatore");
                condizione.add("9 >= contatore");
                azione="cammina(\"destra\")";
                risultato="->  ->  ->  ->  ->  ->  ->  ->  ->  ->";
                break;
            case 2:
                consegna="Fai dire a Bender la parola \"casa\" per 10 volte usando la funzione parla(string).\nConsiglio:\ninizia a contare da 0";
                inizializzazione.add("contatore=0");
                inizializzazione.add("contatore= 0");
                inizializzazione.add("contatore =0");
                inizializzazione.add("contatore = 0");
                condizione.add("contatore<10");
                condizione.add("contatore< 10");
                condizione.add("contatore <10");
                condizione.add("contatore < 10");
                condizione.add("contatore<=9");
                condizione.add("contatore<= 9");
                condizione.add("contatore <=9");
                condizione.add("contatore <= 9");
                condizione.add("10>contatore");
                condizione.add("10> contatore");
                condizione.add("10 >contatore");
                condizione.add("10 > contatore");
                condizione.add("9>=contatore");
                condizione.add("9>= contatore");
                condizione.add("9 >=contatore");
                condizione.add("9 >= contatore");
                azione="cammina(\"destra\")";
                risultato="casa  casa  casa  casa  casa  casa  casa  casa  casa  casa";
                break;
            case 3:
                consegna="Fai fare a Bender 10 passi a sinistra usando la funzione cammina(string) usando come parametro la stringa \"sinistra\"\nConsiglio:\nInizia a contare da 0";
                inizializzazione.add("contatore=0");
                inizializzazione.add("contatore= 0");
                inizializzazione.add("contatore =0");
                inizializzazione.add("contatore = 0");
                condizione.add("contatore<10");
                condizione.add("contatore< 10");
                condizione.add("contatore <10");
                condizione.add("contatore < 10");
                condizione.add("contatore<=9");
                condizione.add("contatore<= 9");
                condizione.add("contatore <=9");
                condizione.add("contatore <= 9");
                condizione.add("10>contatore");
                condizione.add("10> contatore");
                condizione.add("10 >contatore");
                condizione.add("10 > contatore");
                condizione.add("9>=contatore");
                condizione.add("9>= contatore");
                condizione.add("9 >=contatore");
                condizione.add("9 >= contatore");
                azione="cammina(\"sinistra\")";
                risultato="<-  <-  <-  <-  <-  <-  <-  <-  <-  <-";
                break;
            case 4:
                consegna="Fai contare Bender da 1 a 20, usando la funzione conta(int) che prende un intero come parametro.\nConsiglio:\nPuoi usare contatore come parametro.\nConsiglio:\nInizia a contare da 1";
                inizializzazione.add("contatore=1");
                inizializzazione.add("contatore= 1");
                inizializzazione.add("contatore =1");
                inizializzazione.add("contatore = 1");
                condizione.add("contatore<21");
                condizione.add("contatore< 21");
                condizione.add("contatore <21");
                condizione.add("contatore < 21");
                condizione.add("contatore<=20");
                condizione.add("contatore<= 20");
                condizione.add("contatore <=20");
                condizione.add("contatore <= 20");
                condizione.add("21>contatore");
                condizione.add("21> contatore");
                condizione.add("21 >contatore");
                condizione.add("21 > contatore");
                condizione.add("20>=contatore");
                condizione.add("20>= contatore");
                condizione.add("20 >=contatore");
                condizione.add("20 >= contatore");
                azione="conta(contatore)";
                risultato="1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20";
                break;

        }
    }
}
