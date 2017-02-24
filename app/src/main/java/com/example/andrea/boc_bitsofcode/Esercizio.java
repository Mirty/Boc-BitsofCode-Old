package com.example.andrea.boc_bitsofcode;

import java.util.Random;

/**
 * Created by andrea on 18/01/17.
 */
public class Esercizio {

    String domanda="Memorizza in una variabile il numero di zampe di un cane", risposta="4";
    int tipo=0, scelta;
    Random rand= new Random();

    public void genera(){
        scelta=rand.nextInt()%10;
        if(scelta<0){
            scelta=-scelta;
        }

        switch(scelta){
            case 0:
                domanda="Memorizza in una variabile il numero di code di un cane";
                tipo=0;
                risposta="1";
                break;
            case 1:
                domanda="Memorizza in una variabile il tuo nome";
                tipo=2;
                risposta="\""+MenuLivelli.giocatore.nome+"\"";
                break;
            case 2:
                domanda="Memorizza in una variabile il tuo anno di nascita";
                tipo=0;
                risposta=null;
                break;
            case 3:
                domanda="Memorizza in una variabile se \"Il mare è giallo\" è vera o no";
                tipo=3;
                risposta="false";
                break;
            case 4:
                domanda="Il gelataio ti ha dato 3.50€ di resto; memorizzalo in una varabile";
                tipo=1;
                risposta="3.50";
                break;
            case 5:
                domanda="Memorizza in una variabile il numero di persone nella tua famiglia";
                tipo=0;
                risposta=null;
                break;
            case 6:
                domanda="Un pacchetto di figurine costa 4.50€, memorizzalo in una variabile";
                tipo=1;
                risposta="4.50";
                break;
            case 7:
                domanda="Memorizza in una variabile la parola \"casa\"";
                tipo=2;
                risposta="\"casa\"";
                break;
            case 8:
                domanda="Memorizza in una variabile se \"Il cielo è blu\" è vera o no";
                tipo=3;
               risposta="true";
                break;
            case 9:
                domanda="Memorizza in una variabile se \"il cane miagola\" è vera o no";
                tipo=3;
                risposta="false";
                break;
            default:
                domanda="Memorizza in una variabile il numero di zampe di un cane";
                tipo=0;
                risposta="4";
                break;
        }


    }

}
