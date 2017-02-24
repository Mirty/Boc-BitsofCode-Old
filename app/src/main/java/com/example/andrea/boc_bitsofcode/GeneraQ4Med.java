package com.example.andrea.boc_bitsofcode;


import java.util.ArrayList;
import java.util.Random;
/**
 * Created by federica on 17/01/17.
 */

public class GeneraQ4Med extends ArrayList<Q4medio>{

    Random r = new Random();

    public GeneraQ4Med(){
        this.add(new Q4medio("Fino a che numero conterà il robottino?","conta();", 0, 5, 1 , 5));
        this.add(new Q4medio("Quante volte apparirà la scritta Ciao?","scriviCiao();", 0, 5, 1 , 5));
        this.add(new Q4medio("Quante volte apparirà la scritta CipCip?","scriviCipCip();", 0, 5, 1 , 5));
        /*this.add(new Quesito4("Quante volte vuoi che il robottino conti?", "contaAvoceAlta"));
        this.add(new Quesito4("Quante volte vuoi che il robottino conti?", "contaAvoceAlta"));
        this.add(new Quesito4("Quante volte vuoi che il robottino conti?", "contaAvoceAlta"));
        this.add(new Quesito4("Quante volte vuoi che il robottino conti?", "contaAvoceAlta"));
        this.add(new Quesito4("Quante volte vuoi che il robottino conti?", "contaAvoceAlta"));
        this.add(new Quesito4("Quante volte vuoi che il robottino conti?", "contaAvoceAlta"));
        this.add(new Quesito4("Quante volte vuoi che il robottino conti?", "contaAvoceAlta"));
        this.add(new Quesito4("Quante volte vuoi che il robottino conti?", "contaAvoceAlta"));
        this.add(new Quesito4("Quante volte vuoi che il robottino conti?", "contaAvoceAlta"));
        this.add(new Quesito4("Quante volte vuoi che il robottino conti?", "contaAvoceAlta"));
        this.add(new Quesito4("Quante volte vuoi che il robottino conti?", "contaAvoceAlta"));
    */

    }

    public Q4medio generaq4Med(){
        int index;
        index = r.nextInt()%(this.size()-1);
        if (index < 0)
            index += (this.size()-1);
        return this.get(index);
    }

}