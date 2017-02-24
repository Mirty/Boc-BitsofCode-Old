package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by federica on 17/01/17.
 */

public class Livello2medio extends AppCompatActivity {
    Button interi, decimali, stringhe, booleani;
    TextView quesito, consegna;
    public static boolean daActivity = false;
    private GeneraQuesiti gq = new GeneraQuesiti();
    private Quesito q = new Quesito("", "");
    private int moltiplicatore, puntiARisposta=50;
    private int daIndovinare = 10, serie=0;
    static int punteggio, giusti = 0;
    private Vibrator v;
    CountDownTimer timer;
    Random r = new Random();
    Typeface button_font, consegne_font;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.livello2medio);
        v=(Vibrator) getSystemService(VIBRATOR_SERVICE);
        interi = (Button) findViewById(R.id.interi);
        decimali = (Button) findViewById(R.id.decimali);
        booleani = (Button) findViewById(R.id.booleani);
        stringhe = (Button) findViewById(R.id.stringhe);
        consegna = (TextView) findViewById(R.id.consegnaliv2medio);

        quesito = (TextView) findViewById(R.id.quesito);

        button_font = Typeface.createFromAsset(getAssets(),  "fonts/Acids!.otf");
        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");
        interi.setTypeface(button_font);
        decimali.setTypeface(button_font);
        booleani.setTypeface(button_font);
        stringhe.setTypeface(button_font);
        quesito.setTypeface(consegne_font);
        consegna.setTypeface(consegne_font);

        timer = new CountDownTimer(500, 100) { //Inizializzo il timer per la gestione del cambiamento di colore
            @Override
            public void onTick(long millisUntilFinished) {
                quesito.setTextColor(Color.RED);
            }

            @Override
            public void onFinish() {
                quesito.setTextColor(Color.parseColor("#00838F"));
            }
        };


        q = gq.genera();
        quesito.setText(q.getQuesito());

        interi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (q.getTipo().equals("int")) {
                    if (giusti < daIndovinare) {
                        q =gq.genera();
                        quesito.setText(q.getQuesito());
                        giusti++;
                        serie++;
                        calcolaPunteggio();
                    } else {
                        startActivity(new Intent(Livello2medio.this, Vittoria2media.class));
                    }
                } else {
                    timer.start();
                    v.vibrate(500);
                    serie=0;
                }
            }
        });

        stringhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (q.getTipo().equals("string")) {
                    if (giusti < daIndovinare) {
                        q =gq.genera();
                        quesito.setText(q.getQuesito());
                        giusti++;
                        calcolaPunteggio();
                    } else {
                        startActivity(new Intent(Livello2medio.this, Vittoria2media.class));
                    }
                } else {
                    timer.start();
                    v.vibrate(500);
                    serie=0;
                }
            }
        });

        booleani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (q.getTipo().equals("boolean")) {
                    if (giusti < daIndovinare) {
                        q =gq.genera();
                        quesito.setText(q.getQuesito());
                        giusti++;
                        calcolaPunteggio();
                    } else {
                        startActivity(new Intent(Livello2medio.this, Vittoria2media.class));
                    }
                } else {
                    timer.start();
                    v.vibrate(500);
                    serie=0;
                }
            }
        });

        decimali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (q.getTipo().equals("float")) {
                    if (giusti < daIndovinare) {
                        q =gq.genera();
                        quesito.setText(q.getQuesito());
                        giusti++;
                        calcolaPunteggio();
                    } else {
                        startActivity(new Intent(Livello2medio.this, Vittoria2media.class));
                    }
                } else {
                    timer.start();
                    v.vibrate(500);
                    serie=0;
                }
            }
        });
    }

    protected void onResume(){
        super.onResume();
        if(daActivity){
            finish();
        }

    }

    private void calcolaPunteggio(){
        if(serie>=0 && serie <5){
            moltiplicatore=1;
        }
        else{
            if(serie>=5 && serie <10){
                moltiplicatore=2;
            }
            else{
                if(serie>=10 && serie <15){
                    moltiplicatore=3;
                }
                else{
                    moltiplicatore=4;
                }
            }
        }

        punteggio+=puntiARisposta*moltiplicatore;


    }
}
