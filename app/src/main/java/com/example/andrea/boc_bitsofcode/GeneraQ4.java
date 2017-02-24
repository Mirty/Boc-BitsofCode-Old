package com.example.andrea.boc_bitsofcode;


import java.util.ArrayList;
import java.util.Random;
/**
 * Created by federica on 17/01/17.
 */

public class GeneraQ4 extends ArrayList<Quesito4>{

    Random r = new Random();

    public GeneraQ4(){
        this.add(new Quesito4("Fino a che numero vuoi che il robottino conti?", "contaAvoceAlta()", "number", 1, ""));
        this.add(new Quesito4("Quante volte vuoi che appaia la scritta 'CIAO'", "scriviCiao()", "text", 0, "CIAO"));
        this.add(new Quesito4("Quante volte vuoi che l'uccellino faccia Cip Cip?", "cipCip()", "text", 0, "Cip Cip"));
        this.add(new Quesito4("Indica fino a che numero vuoi moltiplicare il numero 2", "tabellinaDelDue", "number",2,""));
        this.add(new Quesito4("Indica fino a che numero vuoi moltiplicare il numero 3", "tabellinaDel3()", "number", 3, ""));
        this.add(new Quesito4("Indica fino a che numero vuoi moltiplicare il numero 4","tabellinaDelQuattro()", "number", 4, ""));
        this.add(new Quesito4("Indica fino a che numero vuoi moltiplicare il numero 5","tabellinaDelCinque()" ,"number", 5, ""));
        this.add(new Quesito4("Indica fino a che numero vuoi moltiplicare il numero 6", "tabellinaDelSei()", "number",6, ""));
        this.add(new Quesito4("Quante volte vuoi far abbaiare il cane?", "bauBau()", "text", 0, "BauBau"));
        this.add(new Quesito4("Quante volte vuoi far miagolare il gatto?", "miao()", "text", 0, "miao"));
        this.add(new Quesito4("Quante stelline vuoi visualizzare?", "cieloStellato()", "text", 0, "*"));
        this.add(new Quesito4("Quanti cuoricini vuoi visualizzare?", "cuori()", "text", 0, "♥"));
        this.add(new Quesito4("Quanti cerchi vuoi visualizzare?", "cerchi()", "text", 0, "°"));
    }

    public Quesito4 generaq4(){
        int index;
        index = r.nextInt()%(this.size()-1);
        if (index < 0)
            index += (this.size()-1);
        return this.get(index);
    }

}