package com.example.andrea.boc_bitsofcode;

import java.util.Random;

/**
 * Created by andrea on 09/02/17.
 */
public class Distrazioni {
    Random rand= new Random();

    public String genera(){
        switch(Math.abs(rand.nextInt())%15){
            case 0:
                return "123";
            case 1:
                return "\"ciao\"";
            case 2:
                return "\"Djanni\"";
            case 3:
                return "1.25";
            case 4:
                return "587";
            case 5:
                return "\"gatto\"";
            case 6:
                return "654.24";
            case 7:
                return "\"pioggia\"";
            case 8:
                return "354";
            case 9:
                return "46.58";
            case 10:
                return "\"tesoro\"";
            case 11:
                return "687";
            case 12:
                return "65.32";
            case 13:
                return "\"mollusco\"";
            case 14:
                return "35641";
            default:
                return "\"KAKAROOOTH\"";
        }
    }


}
