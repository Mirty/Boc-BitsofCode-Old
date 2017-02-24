package com.example.andrea.boc_bitsofcode;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by andrea on 18/02/17.
 */
public class Esercizio3Impossibile {
    public String quesito, tipo1, tipo2, nome1, nome2, valore1, valore2, ramoThen, ramoElse;
    public ArrayList<String> condizioniPositive, condizioniNegative;
    Random rand= new Random();

    public void genera(){
        condizioniPositive=new ArrayList<String>();
        condizioniNegative=new ArrayList<String>();
        switch(Math.abs(rand.nextInt())%5){
            case 0:
                quesito="Un animale ha 4 zampe.\nFai controllare a Bender se è un quadrupede e se si, fagli dire (usando la funzione parla):\n\"L'animale è un quadrupede\"\n oppure:\n \"L'animale non è un quadrupede\"";
                tipo1="int";
                tipo2="";
                nome1="numeroZampe";
                nome2="";
                valore1="4";
                valore2="";
                condizioniPositive.add("numeroZampe==4");
                condizioniPositive.add("4==numeroZampe");
                condizioniNegative.add("4!=numeroZampe");
                condizioniNegative.add("numeroZampe!=4");
                ramoThen="parla(\"L'animale è un quadrupede\")";
                ramoElse="parla(\"L'animale non è un quadrupede\")";
                break;
            case 1:
                quesito="Due persone si chiamano Andrea.\nFai dire a Bender se queste due persone hanno lo stesso nome. Se è vero, (usando la funzione parla), fagli dire:\n\"Hanno lo stesso nome\", altrimenti fagli dire:\n\"Non hanno lo stesso nome\"";
                tipo1="string";
                tipo2="string";
                nome1="persona1";
                nome2="persona2";
                valore1="Andrea";
                valore2="Andrea";
                condizioniPositive.add("persona1==persona2");
                condizioniPositive.add("persona2==persona1");
                condizioniNegative.add("persona1!=persona2");
                condizioniNegative.add("persona2!=persona1");
                ramoThen="parla(\"Hanno lo stesso nome\")";
                ramoElse="parla(\"Non hanno lo stesso nome\")";
                break;
            case 2:
                quesito="Hai 3.50€ nel portafogli, e vuoi comprarti un gelato che costa 2.00€.\nFai dire a Bender se puoi comprarti il gelato.\nSe puoi, usando la funzione parla, fagli dire:\n\"Puoi comprarti il gelato\"\naltrimenti fagli dire:\n\"Non puoi comprarti il gelato\"";
                tipo1="float";
                tipo2="float";
                nome1="portafogli";
                nome2="prezzoGelato";
                valore1="3.50";
                valore2="2.00";
                condizioniPositive.add("portafogli>=prezzoGelato");
                condizioniPositive.add("prezzoGelato<=portafogli");
                condizioniPositive.add("portafogli>prezzoGelato");
                condizioniPositive.add("prezzoGelato<portafogli");
                condizioniNegative.add("portafogli<prezzoGelato");
                condizioniNegative.add("prezzoGelato>portafogli");
                ramoThen="parla(\"Puoi comprarti il gelato\")";
                ramoElse="parla(\"Non puoi comprarti il gelato\")";
                break;
            case 3:
                quesito="Leggi che su Marte esiste un monte alto circa 22000 m.\n Sapendo che il monte più alto della Terra è alto 8848 m, fai dire a Bender, usando la funzione parla \"Terra\" se è più alto il monte terrestre, o \"Marte\" se è più alto il monte marziano";
                tipo1="int";
                tipo2="int";
                nome1="monteDellaTerra";
                nome2="monteDiMarte";
                valore1="8848";
                valore2="22000";
                condizioniPositive.add("monteDiMarte>monteDellaTerra");
                condizioniPositive.add("monteDellaTerra<monteDiMarte");
                condizioniNegative.add("monteDiMarte<monteDellaTerra");
                condizioniNegative.add("monteDellaTerra>monteDiMarte");
                ramoThen="parla(\"Marte\")";
                ramoElse="parla(\"Terra\")";
                break;
            case 4:
                quesito="In geografia, un rilievo viene considerato montagna ogni volta che esso supera i 600m.\nIl Monte Bianco è alto 4809 m.\nUsando la funzione parla, fai dire a Bender se esso è un \"Monte\" o una \"Collina\"";
                tipo1="int";
                tipo2="";
                nome1="altezzaMonteBianco";
                nome2="";
                valore1="4809";
                valore2="";
                condizioniPositive.add("altezzaMonteBianco>=600");
                condizioniPositive.add("600<=altezzaMonteBianco");
                condizioniPositive.add("altezzaMonteBianco>600");
                condizioniPositive.add("600<altezzaMonteBianco");
                condizioniPositive.add("altezzaMonteBianco>599");
                condizioniPositive.add("599<altezzaMonteBianco");
                condizioniNegative.add("600>=altezzaMonteBianco");
                condizioniNegative.add("altezzaMonteBianco<=600");
                condizioniNegative.add("600>altezzaMonteBianco");
                condizioniNegative.add("altezzaMonteBianco<600");
                condizioniNegative.add("601>altezzaMonteBianco");
                condizioniNegative.add("altezzaMonteBianco<601");
                ramoThen="parla(\"Monte\")";
                ramoElse="parla(\"Collina\")";

        }
    }


}
