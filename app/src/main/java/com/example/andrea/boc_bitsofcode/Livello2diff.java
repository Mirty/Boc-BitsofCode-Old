package com.example.andrea.boc_bitsofcode;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by federica on 18/01/17.
 */

public class Livello2diff extends AppCompatActivity {

    Button interi, decimali, stringhe, booleani;
    TextView quesito;
    String testoIn;
    public static boolean daActivity = false;
    private GeneraQ2 gq = new GeneraQ2();
    private Quesiti2 q = new Quesiti2("", "", "", "", "", "", "");
    private Vibrator v;
    private static int step = 0;
    private int i, index, giusti = 0, daIndovinare = 5;
    static int punteggio = 500;
    String nomeFun;
    Random r = new Random();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livello2diff);

        v=(Vibrator) getSystemService(VIBRATOR_SERVICE);
        interi = (Button) findViewById(R.id.interi);
        decimali = (Button) findViewById(R.id.decimali);
        booleani = (Button) findViewById(R.id.booleani);
        stringhe = (Button) findViewById(R.id.stringhe);
        quesito = (TextView) findViewById(R.id.quesito);

        q = gq.generaq2();
        nomeFun = q.getNome();
        quesito.setText("Scrivi una funzione che indichi: " + q.getQuesito() + "\n scegli il tipo di dato.");




        interi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                    switch (step) {
                        case 0:
                            if (q.getTipo().equals("int")) {
                                stringhe.setText("STRING");
                                punteggio +=50;
                                step1();
                            } else {
                                punteggio -= 5;
                                v.vibrate(500);
                            }
                            break;
                        case 1:
                            if (interi.getText().equals(nomeFun)) {
                                punteggio +=50;
                                step2();

                            } else {
                                punteggio -=5;
                                v.vibrate(500);
                            }
                            break;

                        case 2:
                            if (q.getParametro().equals("int")) {
                                punteggio +=50;
                                step3();

                            } else {
                                punteggio -=50;
                                v.vibrate(500);
                            }
                            break;
                    }
            }
    });

    stringhe.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                switch (step) {
                    case 0:
                        if (q.getTipo().equals("string")) {
                            stringhe.setText("STRING");
                            punteggio +=50;
                            step1();

                        } else {
                            punteggio -=5;
                            v.vibrate(500);
                        }
                        break;
                    case 1:
                        if (stringhe.getText().equals(nomeFun)) {
                            punteggio +=50;
                            step2();

                        } else {
                            punteggio -=5;
                            v.vibrate(500);
                        }
                        break;
                    case 2:
                        if (q.getParametro().equals("string")) {
                            punteggio +=50;
                            step3();

                        } else {
                            punteggio -=5;
                            v.vibrate(500);
                        }
                        break;
                    case 3:
                        step5();
                        break;
                }
        }
    });

    booleani.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                switch (step) {
                    case 0:
                        if (q.getTipo().equals("boolean")) {
                            stringhe.setText("STRING");
                            punteggio +=50;
                            step1();

                        } else {
                            punteggio -=5;
                            v.vibrate(500);
                        }
                        break;
                    case 1:
                        if (booleani.getText().equals(nomeFun)) {
                            punteggio +=50;
                            step2();

                        } else {
                            punteggio -=5;
                            v.vibrate(500);
                        }
                        break;

                    case 2:
                        if (q.getParametro().equals("boolean")) {
                            punteggio +=50;
                            step3();

                        } else {
                            punteggio -=5;
                            v.vibrate(500);
                        }
                        break;
                }
        }
    });

    decimali.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                switch (step) {
                    case 0:
                        if (q.getTipo().equals("float")) {
                            stringhe.setText("STRING");
                            punteggio +=50;
                            step1();

                        } else {
                            punteggio -=5;
                            v.vibrate(500);
                        }
                        break;
                    case 1:
                        if (decimali.getText().equals(nomeFun)) {
                            punteggio +=50;
                            step2();

                        } else {
                            punteggio -=5;
                            v.vibrate(500);
                        }
                        break;
                    case 2:
                        if (q.getParametro().equals("float")) {
                            punteggio +=50;
                            step3();
                        } else {
                            punteggio -=5;
                            v.vibrate(500);
                        }
                        break;
                }

        }
    });
    }

    public void step1(){
        interi.setVisibility(View.GONE);
        booleani.setVisibility(View.GONE);
        decimali.setVisibility(View.GONE);
        stringhe.setVisibility(View.GONE);

        quesito.setText("Scegli il nome della funzione: ");

        interi.setVisibility(View.VISIBLE);
        booleani.setVisibility(View.VISIBLE);
        decimali.setVisibility(View.VISIBLE);
        stringhe.setVisibility(View.VISIBLE);


        ArrayList<String> s = new ArrayList();

        ArrayList<Integer> in = new ArrayList();

        for(i=0;i<4;i++) {
            in.add(i);
            if (i==0) {
                s.add(nomeFun);
            }else{
                index = (r.nextInt() % (gq.size()-1));
                if(index < 0)
                    index += (gq.size()-1);
                s.add(gq.get(index).getNome());
            }
        }

        Collections.shuffle(in);
        interi.setText(s.get(in.get(0)));
        booleani.setText(s.get(in.get(1)));
        stringhe.setText(s.get(in.get(2)));
        decimali.setText(s.get(in.get(3)));
        step++;

    }

    public void step2(){
        interi.setVisibility(View.GONE);
        booleani.setVisibility(View.GONE);
        decimali.setVisibility(View.GONE);
        stringhe.setVisibility(View.GONE);


        quesito.setText("Scegli il tipo del parametro da assegnare: ");

        interi.setVisibility(View.VISIBLE);
        booleani.setVisibility(View.VISIBLE);
        decimali.setVisibility(View.VISIBLE);
        stringhe.setVisibility(View.VISIBLE);


        interi.setText("INT");
        decimali.setText("FLOAT");
        booleani.setText("BOOLEAN");
        stringhe.setText("STRING");
        step++;
    }

    public void step3(){
        TextView testo;
        final EditText testoParla2;
        Button conferma2;
        final Dialog dialog = new Dialog(Livello2diff.this);
        //final Dialog dialog2 = new Dialog(Livello2diff.this);
        // Carico il layout della dialog al suo intenro

        dialog.setContentView(R.layout.dialog2);
        interi.setVisibility(View.GONE);
        booleani.setVisibility(View.GONE);
        decimali.setVisibility(View.GONE);
        stringhe.setVisibility(View.GONE);
        quesito.setVisibility(View.GONE);

        conferma2 = (Button) dialog.findViewById(R.id.conferma2);
        testoParla2 = (EditText) dialog.findViewById(R.id.testoParla2);
        testo = (TextView) dialog.findViewById(R.id.inserisci2);
        testo.setText(q.getCreavar());

        conferma2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                testoIn = testoParla2.getText().toString();
                if(testoIn.equals(q.getVariabile())) {
                    quesito.setVisibility(View.VISIBLE);
                    quesito.setText(q.getTipo() + " " + q.getNome() + " (" + q.getParametro() + " parametro "+" ) {\n\n" + testoIn + "\n\n");
                    dialog.dismiss();
                }else{
                    v.vibrate(500);

                }
            }
        });
        step4();
        dialog.show();


    }

    public void step4(){
        TextView testo;
        final EditText testoParla3;
        Button conferma3;

        final Dialog dialog3 = new Dialog(Livello2diff.this);

        dialog3.setContentView(R.layout.dialog3);
        conferma3 = (Button) dialog3.findViewById(R.id.conferma3);
        testoParla3 = (EditText) dialog3.findViewById(R.id.testoParla3);
        testo = (TextView) dialog3.findViewById(R.id.inserisci3);

        testo.setText("Adesso restituisci il valore della variabile: " + q.getNomeVar());

        conferma3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                testoIn = testoParla3.getText().toString();
                if (testoIn.equals("restituisci " + q.getNomeVar() + ";")) {
                    quesito.setVisibility(View.VISIBLE);
                    quesito.append(testoIn + "\n\n }");
                    step++;
                    stringhe.setVisibility(View.VISIBLE);
                    stringhe.setText("AVANTI");
                    dialog3.dismiss();
                } else {
                    v.vibrate(500);
                }

            }
        });
        giusti++;
        dialog3.show();
    }


    public void step5(){
    if (giusti < daIndovinare) {
        quesito.setText("");
        interi.setVisibility(View.VISIBLE);
        booleani.setVisibility(View.VISIBLE);
        decimali.setVisibility(View.VISIBLE);
        quesito.setVisibility(View.VISIBLE);
        step = 0;
        q = gq.generaq2();
        nomeFun = q.getNome();

        quesito.setText("Scrivi una funzione che indichi: " + q.getQuesito() + "\n scegli il tipo di dato.");
    }else{
        finish();
        startActivity(new Intent(Livello2diff.this, Vittoria2diff.class));
    }
    }

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }*/

}
