package com.example.andrea.boc_bitsofcode;


import java.util.ArrayList;
import java.util.Random;
/**
 * Created by federica on 17/01/17.
 */

public class GeneraQuesiti extends ArrayList<Quesito>{

    Random r = new Random();

    public GeneraQuesiti(){
        this.add(new Quesito("eta","int"));
        this.add(new Quesito("colore del sole","string"));
        this.add(new Quesito("Il cielo è verde","boolean"));
        this.add(new Quesito("gradi centigradi","float"));
        this.add(new Quesito("zampe di un cane","int"));
        this.add(new Quesito("orecchie di un gatto","int"));
        this.add(new Quesito("La mela è blu","boolean"));
        this.add(new Quesito("Il sole è giallo","boolean"));
        this.add(new Quesito("Nome del mio cane","string"));
        this.add(new Quesito("4 diviso 3","float"));
        this.add(new Quesito("Altezza","float"));

    }

    public Quesito genera(){
        int indice;
        indice = r.nextInt()%9;
        if (indice < 0)
            indice += 9;
        return this.get(indice);
    }

}