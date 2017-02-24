package com.example.andrea.boc_bitsofcode;

import java.util.Random;
/**
 * Created by andrea on 07/02/17.
 */
public class LIvello3NormaleEsercizio {
    public String condizione="(il gatto fa le fusa){", bottone1="accarezza();", bottone2="scappa();";
    public int tipo=0, scelta;
    private Random rand;

    public LIvello3NormaleEsercizio(){
        rand= new Random();
    }

    public void genera(){
        scelta=abs(rand.nextInt())%10;

        switch(scelta){
            case 0:
                condizione="(il cane ringhia)";
                bottone1="scappa();";
                bottone2="accarezza();";
                break;
            case 1:
                condizione="(il semaforo è rosso)";
                bottone1="attraversa();";
                bottone2="fermati();";
                break;
            case 2:
                condizione="(il cane scodinzola)";
                bottone1="accarezza();";
                bottone2="scappa();";
                break;
            case 3:
                condizione="(il gatto fa le fusa)";
                bottone1="scappa();";
                bottone2="accarezza();";
                break;
            case 4:
                condizione="(il semaforo è verde)";
                bottone1="attraversa();";
                bottone2="fermati();";
                break;
            case 5:
                condizione="(il gatto soffia)";
                bottone1="accarezza();";
                bottone2="scappa();";
                break;
            case 6:
                condizione="(fuori piove)";
                bottone1="prendiOmbrello();";
                bottone2="lasciaOmbrello();";
                break;
            case 7:
                condizione="(non hai fretta)";
                bottone1="corri();";
                bottone2="cammina();";
                break;
            case 8:
                condizione="(hai fretta)";
                bottone1="corri();";
                bottone2="cammina();";
                break;
            case 9:
                condizione="(fuori c'è il sole)";
                bottone1="prendiOmbrello();";
                bottone2="lasciaOmbrello();";
                break;
        }

        tipo=scelta%2;


    }

    private int abs(int x){
        if(x<0){
            return (-x);
        }
        return x;
    }
}
