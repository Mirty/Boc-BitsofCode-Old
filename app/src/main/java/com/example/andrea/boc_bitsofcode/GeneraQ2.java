package com.example.andrea.boc_bitsofcode;


import java.util.ArrayList;
import java.util.Random;
/**
 * Created by federica on 17/01/17.
 */

public class GeneraQ2 extends ArrayList<Quesiti2>{

    Random r = new Random();

    public GeneraQ2(){
        this.add(new Quesiti2("età","int", "Calcolo_età","int", "Dichiara la variabile 'anni' e assegnale la differenza tra l'anno attuale e l'anno passato come parametro", "int anni = 2017 - parametro;", "anni"));
        this.add(new Quesiti2("colore del sole","string", "colore", "string", "Dichiara la variabile colore e assegnale il valore della variabile passata come parametro", "string colore = parametro;", "colore"));
        this.add(new Quesiti2("Il cielo è verde","boolean", "Cielo_verde","boolean","Dichiara una variabile cielo e assegnale il valore false.", "boolean cielo = false;", "cielo"));
        this.add(new Quesiti2("gradi centigradi","float", "Quanti_Gradi?", "float", "Dichiara una variabile gradi e assegnale la differenza tra 20 e la variabile passata come parametro.", "float gradi = 20 - parametro;", "gradi"));
        this.add(new Quesiti2("antenne lumaca","int", "n_antenne","int", "Dichiara una variabile numero e sottrai alla variabile passata come parametro il valore 2.", "int numero = parametro - 2;", "numero"));
        this.add(new Quesiti2("temperatura corporea","float", "calcola_gradi","float", "Dichiara una variabile temperatura e somma il valore della variabile passata come parametro e 10.", "int temperatura = parametro + 10;", "temperatura"));
        /*this.add(new Quesiti2("distanza","float", "calcola distanza","float", ""));
        this.add(new Quesiti2("Pianeti sistema solare","int", "n° pianeti","int", ""));
        this.add(new Quesiti2("dita delle mani","int", "n° dita mani","int", ""));
        this.add(new Quesiti2("zampe di un cane","int","n° zampe","int", ""));
        this.add(new Quesiti2("orecchie di un gatto","int","n° orecchie","int", ""));
        this.add(new Quesiti2("La mela è blu","boolean","Mela Blu?","boolean", ""));
        this.add(new Quesiti2("Il sole è giallo","boolean","Sole Giallo?","boolean", ""));
        this.add(new Quesiti2("Nome del mio cane","string","Nome cane","string", ""));
        this.add(new Quesiti2("4 diviso 3","float","calcolo risultato","float", ""));
        this.add(new Quesiti2("Altezza","float","calcolo altezza","float", ""));*/

    }

    public Quesiti2 generaq2(){
        int indice;
        indice = r.nextInt()%(this.size()-1);
        if (indice < 0)
            indice += (this.size()-1);
        return this.get(indice);
    }

}