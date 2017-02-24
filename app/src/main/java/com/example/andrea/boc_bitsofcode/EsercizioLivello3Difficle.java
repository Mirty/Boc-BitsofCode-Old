package com.example.andrea.boc_bitsofcode;

import java.util.Random;

/**
 * Created by andrea on 10/02/17.
 */
public class EsercizioLivello3Difficle {
    Random rand=new Random();

    public String[] tipi=new String[5], nome=new String[5], valore=new String[5];
    public String condizione, then, altrimenti, bottone1, bottone2;
    public int tipo, scelta;

    public void genera(){
        for(int i=0; i<5; i++){
            tipi[i]="";
            nome[i]="";
            valore[i]="";
        }
        scelta=Math.abs(rand.nextInt())%10;

        switch(scelta){
            case 0:
                tipi[0]="int";
                nome[0]="numeroZampe";
                valore[0]="4";
                condizione="(numeroZampe==4){";
                then="parla(\"È un quadrupede\")";
                altrimenti="parla(\"Non è un quadrupede\")";
                bottone1="È un quadrupede";
                bottone2="Non è un quadrupede";
                break;
            case 1:
                tipi[0]="int";
                nome[0]="numeroZampe";
                valore[0]="2";
                condizione="(numeroZampe==4){";
                then="parla(\"È un quadrupede\")";
                altrimenti="parla(\"Non è un quadrupede\")";
                bottone1="È un quadrupede";
                bottone2="Non è un quadrupede";
                break;
            case 2:
                tipi[0]="string";
                nome[0]="nome1";
                valore[0]="\"Andrea\"";
                tipi[1]="string";
                nome[1]="nome2";
                valore[1]="\"Andrea\"";
                condizione="(nome1==nome2){";
                then="parla(\"I nomi sono uguali\")";
                altrimenti="parla(\"I nomi non sono uguali\")";
                bottone1="I nomi sono uguali";
                bottone2="I nomi non sono uguali";
                break;
            case 3:
                tipi[0]="string";
                nome[0]="nome1";
                valore[0]="\"Andrea\"";
                tipi[1]="string";
                nome[1]="nome2";
                valore[1]="\"Michela\"";
                condizione="(nome1==nome2){";
                then="parla(\"I nomi sono uguali\")";
                altrimenti="parla(\"I nomi non sono uguali\")";
                bottone1="I nomi sono uguali";
                bottone2="I nomi non sono uguali";
                break;
            case 4:
                tipi[0]="float";
                nome[0]="portafogli";
                valore[0]="10.00";
                tipi[1]="float";
                nome[1]="prezzoFigurine";
                valore[1]="4.50";
                condizione="(portafogli>prezzoFigurine){";
                then="parla(\"Puoi comprarti le figurine\")";
                altrimenti="parla(\"Non puoi comprarti le figurine\")";
                bottone1="Puoi comprarti le figurine";
                bottone2="Non puoi comprarti le figurine";
                break;
            case 5:
                tipi[0]="float";
                nome[0]="portafogli";
                valore[0]="4.00";
                tipi[1]="float";
                nome[1]="prezzoFigurine";
                valore[1]="4.50";
                condizione="(portafogli>prezzoFigurine){";
                then="parla(\"Puoi comprarti le figurine\")";
                altrimenti="parla(\"Non puoi comprarti le figurine\")";
                bottone1="Puoi comprarti le figurine";
                bottone2="Non puoi comprarti le figurine";
                break;
            case 6:
                tipi[0]="bool";
                nome[0]= "verita";
                valore[0]="true";
                condizione="(verita){";
                then="parla(\"La variabile è vera\")";
                altrimenti="parla(\"La variabile è falsa\")";
                bottone1="La variabile è vera";
                bottone2="La variabile è falsa";
                break;
            case 7:
                tipi[0]="bool";
                nome[0]= "verita";
                valore[0]="false";
                condizione="(verita){";
                then="parla(\"La variabile è vera\")";
                altrimenti="parla(\"La variabile è falsa\")";
                bottone1="La variabile è vera";
                bottone2="La variabile è falsa";
                break;
            case 8:
                tipi[0]="int";
                nome[0]="numero";
                valore[0]="11";
                condizione="(numero>10){";
                then="parla(\"Il numero è maggiore di 10\")";
                altrimenti="parla(\"Il numero è minore di 10\")";
                bottone1="il numero è maggiore di 10";
                bottone2="Il numero è minore di 10";
                break;
            case 9:
                tipi[0]="int";
                nome[0]="numero";
                valore[0]="9";
                condizione="(numero>10){";
                then="parla(\"Il numero è maggiore di 10\")";
                altrimenti="parla(\"Il numero è minore di 10\")";
                bottone1="il numero è maggiore di 10";
                bottone2="Il numero è minore di 10";
                break;
        }
        tipo=scelta%2;
    }

}
