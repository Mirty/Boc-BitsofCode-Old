package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by federica on 14/02/17.
 */

public class Livello4medio extends AppCompatActivity {
    private Button uno, due, tre, quattro;
    private TextView quesito;
    public static boolean an = false;
    private int index, numq = 0, i;
    public static boolean daActivity = false;
    private int moltiplicatore = 5, puntiARisposta=50;
    private int daIndovinare = 10, serie=0;
    static int punteggio, giusti = 0;
    Q4medio q = new Q4medio("", "", 0,0,0,0);
    GeneraQ4Med gen = new GeneraQ4Med();
    private Vibrator v;

    Random r = new Random();
    String s;
    private Integer num = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livello4medio);
        uno = (Button) findViewById(R.id.button1);
        due = (Button) findViewById(R.id.button2);
        tre = (Button) findViewById(R.id.button3);
        quattro = (Button) findViewById(R.id.button4);
        quesito = (TextView) findViewById(R.id.quesito);
        v =(Vibrator) getSystemService(VIBRATOR_SERVICE);

        q = gen.generaq4Med();

        quesito.setText(q.getQuesito());
        quesito.append( "\nfor ( i = " + q.getFcond() + "; i < " + q.getscond() + "; i = i + " + q.getthcond());
        quesito.append ("{\n " + q. getFun() + " \n}");

        setButton();



            uno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try{
                        s = uno.getText().toString();
                        num  = Integer.parseInt(s);
                        if(num == q.getres()){
                            giusti++;
                            numq++;
                            serie++;
                            calcolaPunteggio();
                            genera();
                        }else{
                            v.vibrate(500);
                        }
                    }catch(NumberFormatException e){
                        //non gestita
                    }

                }
            });

            due.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try{
                        s = due.getText().toString();
                        num  = Integer.parseInt(s);
                        if(num == q.getres()){
                            giusti++;
                            numq++;
                            serie++;
                            calcolaPunteggio();
                            genera();

                        }else{
                            v.vibrate(500);
                        }
                    }catch(NumberFormatException e){
                        //non gestita
                    }

                }
            });

            tre.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try{
                        s = tre.getText().toString();
                        num  = Integer.parseInt(s);
                        if(num == q.getres()){
                            giusti++;
                            numq++;
                            serie++;
                            calcolaPunteggio();
                            genera();
                        }else{
                            v.vibrate(500);
                        }
                    }catch(NumberFormatException e){
                        //non gestita
                    }

                }
            });

            quattro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try{
                        s = quattro.getText().toString();
                        num  = Integer.parseInt(s);
                        if(num == q.getres()){
                            giusti++;
                            numq++;
                            serie++;
                            calcolaPunteggio();
                            genera();
                        }else{
                            v.vibrate(500);
                        }
                    }catch(NumberFormatException e){
                        //non gestita
                    }

                }
            });




    }

    public void setButton(){
        ArrayList<Integer> in = new ArrayList();
        in.add(q.getres());

        for(i=0; i<3;i++){
            index = r.nextInt() % 20;
            if(index < 0){
                index +=20;
            }
            in.add(index);
        }

        Collections.shuffle(in);
        uno.setText("" + in.get(0));
        due.setText("" + in.get(1));
        tre.setText("" + in.get(2));
        quattro.setText("" + in.get(3));
    }

    protected void onResume(){
        super.onResume();
        if(daActivity){
            an = true;
            finish();
        }

    }

    private void calcolaPunteggio() {
        if (serie >= 0 && serie < 5) {
            moltiplicatore = 1;
        } else {
            if (serie >= 5 && serie < 10) {
                moltiplicatore = 2;
            } else {
                if (serie >= 10 && serie < 15) {
                    moltiplicatore = 3;
                } else {
                    moltiplicatore = 4;
                }
            }
        }

        punteggio += puntiARisposta * moltiplicatore;

    }

    private void genera(){
        if(numq <= daIndovinare){
            q = gen.generaq4Med();

            quesito.setText(q.getQuesito());
            quesito.append( "\nfor (i = " + q.getFcond() + "; i < " + q.getscond() + "; i = i + " + q.getthcond());
            quesito.append (") {\n " + q. getFun() + " \n}");
            setButton();
        }else{
            daActivity = true;
            startActivity(new Intent(Livello4medio.this, Vittoria4medium.class));
        }
    }


}
