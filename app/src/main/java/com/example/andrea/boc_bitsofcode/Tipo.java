package com.example.andrea.boc_bitsofcode;

import java.util.Random;

public class Tipo {

    String valore="''battello''"; //ANTIBUG: ogni oggetto di tipo Tipo è inizializzato ai valori "Doraemon" e string per non generare in nessun caso oggetti nulli
    String tipo="string";
    private Random random= new Random();
    private Integer buffInt;
    private Float buffFloat;

    public Tipo(String tipo){
        this.tipo = tipo;

        if (tipo.equals("int")){ //creo i dati di tipo int
            buffInt = abs(random.nextInt())%1000;
            valore= buffInt.toString();
        }

        if(tipo.equals("float")) { // creo i dati di tipo float/double TO DO: troppi decimali, trova il modo di sistemarli
            buffFloat=(float)(abs(random.nextInt())%100000)/100;
            valore= buffFloat.toString();
        }

        if(tipo.equals("string")){ //creo i dati di tipo stringa
            switch (Math.abs(random.nextInt())%51){
                case 0:
                    valore="''ciao''";
                    break;
                case 1:
                    valore= "''a''";
                    break;
                case 2:
                    valore= "''crescere''";
                    break;
                case 3:
                    valore= "''scaffale''";
                    break;
                case 4:
                    valore="''b''";
                    break;
                case 5:
                    valore= "''casa''";
                    break;
                case 6:
                    valore= "''fabbrica''";
                    break;
                case 7:
                    valore= "''manuale''";
                    break;
                case 8:
                    valore= "''c''";
                    break;
                case 9:
                    valore= "''Djanni''";
                    break;
                case 10:
                    valore="''acclamare''";
                    break;
                case 11:
                    valore="''assimilare''";
                    break;
                case 12:
                    valore="''maschera''";
                    break;
                case 13:
                    valore="''incidere''";
                    break;
                case 14:
                    valore="''giudice''";
                    break;
                case 15:
                    valore="''fornaio''";
                    break;
                case 16:
                    valore="''euforia''";
                    break;
                case 17:
                    valore="''epiteto''";
                    break;
                case 18:
                    valore="''difesa''";
                    break;
                case 19:
                    valore="''delega''";
                    break;
                case 20:
                    valore="''corvo''";
                    break;
                case 21:
                    valore="''convesso''";
                    break;
                case 22:
                    valore="''copiare''";
                    break;
                case 23:
                    valore="''degrado''";
                    break;
                case 24:
                    valore="''kerosene''";
                    break;
                case 25:
                    valore="''censura''";
                    break;
                case 26:
                    valore="''cellulare''";
                    break;
                case 27:
                    valore="''canestro''";
                    break;
                case 28:
                    valore="''brusio''";
                    break;
                case 29:
                    valore="''barriera''";
                    break;
                case 30:
                    valore="''avventura''";
                    break;
                case 31:
                    valore="''accademia''";
                    break;
                case 32:
                    valore="''acciuga''";
                    break;
                case 33:
                    valore="''cometa''";
                    break;
                case 34:
                    valore="''contributo''";
                    break;
                case 35:
                    valore="''delirio''";
                    break;
                case 36:
                    valore="''rotto''";
                    break;
                case 37:
                    valore="''effetto''";
                    break;
                case 38:
                    valore="''onda''";
                    break;
                case 39:
                    valore="''energetica''";
                    break;
                case 40:
                    valore="''aiuole''";
                    break;
                case 41:
                    valore="''fermata''";
                    break;
                case 42:
                    valore="''frase''";
                    break;
                case 43:
                    valore="''giglio''";
                    break;
                case 44:
                    valore="''ibrido''";
                    break;
                case 45:
                    valore="''incantesimo''";
                    break;
                case 46:
                    valore="''inventiva''";
                    break;
                case 47:
                    valore="''litro''";
                    break;
                case 48:
                    valore="''lucchetto''";
                    break;
                case 49:
                    valore="''molla''";
                    break;
                case 50:
                    valore="''oblò''";
                    break;
            }
        }

        if(tipo.equals("booleani")){ //creo i dati booleani
            if(random.nextBoolean()){
                valore="true";
            }
            else{
                valore="false";
            }
        }

    }

    public String getValore(){
        return valore;
    }

    public String getTipo(){
        return tipo;
    }

    private int abs (int x){
        if(x<0){
            return -x;
        }
        return x;
    }
}



