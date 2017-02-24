package com.example.andrea.boc_bitsofcode;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by federica on 14/02/17.
 */

public class GeneraQ4diff extends ArrayList<Q4Diff> {
    Random r = new Random();

    public GeneraQ4diff(){
        this.add(new Q4Diff("Conta da 1 a 10","conta();", 1, 10, 1));
        this.add(new Q4Diff("Conta da 5 a 10","conta();", 5, 10, 1));
        this.add(new Q4Diff("Scrivi 5 volte 'Ciao' (partendo da 1)","scriviCiao();", 1, 5, 1));
        this.add(new Q4Diff("Fai abbaiare il cane 7 volte (partendo da 3)","abbaia();", 3, 10, 1));
        this.add(new Q4Diff("Visualizza la tabellina del due fino al numero 18","tabellinaDelDue();", 2, 18, 2));
    }

    public Q4Diff generaq4Diff(){
        int index;
        index = r.nextInt()%(this.size()-1);
        if (index < 0)
            index += (this.size()-1);
        return this.get(index);
    }
}
