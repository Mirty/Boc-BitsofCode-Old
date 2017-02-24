package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by federica on 14/02/17.
 */

public class Livello4Diff extends AppCompatActivity {
    Button b1,b2,b3,b4;
    TextView q1;
    Random r = new Random();
    public static boolean an = false;
    private int step = 1;
    private int index,i;
    public static boolean daActivity = false;
    private int moltiplicatore = 5, puntiARisposta=50;
    private int daIndovinare = 5, serie=0;
    static int punteggio, giusti;
    private Vibrator v;
    Q4Diff q = new Q4Diff("","",0,0,0);
    GeneraQ4diff gq = new GeneraQ4diff();
    Integer num;
    String s;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livello4diff);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        v =(Vibrator) getSystemService(VIBRATOR_SERVICE);
        q1 = (TextView) findViewById(R.id.q1);

        step1();
        setButton();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    s = b1.getText().toString();
                    num = Integer.parseInt(s);
                    controllo(num);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    s = b2.getText().toString();
                    num = Integer.parseInt(s);
                    controllo(num);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    s = b3.getText().toString();
                    num = Integer.parseInt(s);
                    controllo(num);
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(b4.getText().equals("Continua")){
                    b1.setVisibility(View.VISIBLE);
                    b2.setVisibility(View.VISIBLE);
                    b3.setVisibility(View.VISIBLE);
                    step1();
                    setButton();
                }else{
                    s = b4.getText().toString();
                    num = Integer.parseInt(s);
                    controllo(num);
                }
            }
        });

    }

    private void step1(){
        q = gq.generaq4Diff();
        q1.setText(q.getQuesito());
        q1.append("Scegli la prima condizione: " + "\n for ( i =   ; i <   ; i = i +  ) { \n " + q.getFun() + "\n }");
        step = 1;
    }

    public void setButton(){
        ArrayList<Integer> in = new ArrayList();
        switch (step){
            case 1:
                in.add(q.getFcond());
                break;
            case 2:
                in.add(q.getScond());
                break;
            case 3:
                in.add(q.getThcond());
                break;
        }

        for(i=0;i< 3; i++){
            index = r.nextInt() % 20;
            if(index < 0){
                index += 20;
            }
            in.add(index);
        }


        Collections.shuffle(in);
        b1.setText("" + in.get(0));
        b2.setText("" + in.get(1));
        b3.setText("" + in.get(2));
        b4.setText("" + in.get(3));
    }

    private void controllo(Integer num){
        switch(step){
            case 1:
                if(num == q.getFcond()){
                    step++;
                    setButton();
                    q1.setText(q.getQuesito());
                    q1.append("\nScegli la seconda condizione: \n" +
                            "\n for ( i = " + q.fcond + " ; i <   ; i = i +  ) { \n " + q.getFun() + "\n }");
                }else{
                    v.vibrate(500);
                }
                break;
            case 2:
                if(num == q.getScond()){
                    step++;
                    setButton();
                    q1.setText(q.getQuesito());
                    q1.append("\nScegli la seconda condizione: \n" +
                            "\n for ( i = " + q.fcond + " ; i < " +  q.getScond() + "; i = i +  ) { \n " + q.getFun() + "\n }");
                }else{
                    v.vibrate(500);
                }
                break;
            case 3:
                if(num == q.getThcond()){
                    q1.setText(q.getQuesito());
                    q1.append("\n for ( i = " + q.fcond + " ; i < " +
                            q.getScond() + "; i = i + " + q.getThcond() + " ) { \n " + q.getFun() + "\n }");

                    giusti++;
                    calcolaPunteggio();

                    if(giusti <= daIndovinare){
                        b1.setVisibility(View.GONE);
                        b2.setVisibility(View.GONE);
                        b3.setVisibility(View.GONE);
                        b4.setText("Continua");
                    }else{
                        daActivity = true;
                        startActivity(new Intent(Livello4Diff.this, Vittoria4Hard.class));
                    }

                }else{
                    v.vibrate(500);
                }
                break;

        }

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


}
