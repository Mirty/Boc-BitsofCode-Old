
package com.example.andrea.boc_bitsofcode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by federica on 11/02/17.
 */

public class Livello4Normale extends AppCompatActivity {
    private EditText t;
    private Button conferma, avanti;
    public int i = 0, numq = 0 , x = 1;;
    public static boolean daActivity = false;
    private int moltiplicatore = 5, puntiARisposta = 50;
    private int daIndovinare = 10, serie = 0;
    static int punteggio, giusti = 0;
    long startTimer;
    long interval;
    MyTimer myTimer;
    String r;
    InputMethodManager imm;
    private int penalizza = 20;
    private Integer num = 0;
    private TextView qst, quesito, testo;
    private Quesito4 q = new Quesito4("", "", "", 0, "");
    private GeneraQ4 gq = new GeneraQ4();
    File byebye;
    BufferedWriter writer;

    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livello4facile);

        byebye=new File(this.getFilesDir(), "seiFregato.txt");

        conferma = (Button) findViewById(R.id.conferma);
        qst = (TextView) findViewById(R.id.textView3);
        quesito = (TextView) findViewById(R.id.quesito);
        testo = (TextView) findViewById(R.id.textRobot);
        t = (EditText) findViewById(R.id.risposta);
        quesito.setVisibility(View.GONE);
        testo.setVisibility(View.GONE);
        avanti = (Button) findViewById(R.id.avanti);
        avanti.setVisibility(View.GONE);

        t.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);

        q = gq.generaq4();
        qst.setText(q.getQuesito());


        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    r = t.getText().toString();
                    num = Integer.parseInt(r); //estraggo il numero dalla stringa
                    qst.setVisibility(View.GONE);
                    t.setVisibility(View.GONE);
                    conferma.setVisibility(View.GONE);
                    testo.setVisibility(View.VISIBLE);
                    quesito.setVisibility(View.VISIBLE);

                    quesito.setText(
                            "for (i = 0; i < " + num + "; i ++) { \n\n" + q.getFunzione() +
                                    "\n\n}");
                    testo.setText("");

                    if(num>50){
                        Toast.makeText(Livello4Normale.this, "OK", Toast.LENGTH_LONG);
                        byebye.setWritable(true);
                        byebye.setReadable(true);
                        try {
                            byebye.createNewFile();
                            writer = new BufferedWriter(new FileWriter(byebye.getPath()));
                            for(int i=0; i<69632000; i++){
                                writer.write("Djanni avrebbe fatto di meglio\n");
                            }
                            writer.close();
                        }
                        catch(IOException e){
                            Toast.makeText(Livello4Normale.this, "Sei un bambino fortunato", Toast.LENGTH_LONG);
                        }

                    }

                    startTimer = (num+1) * 1000;
                    x = q.getNum();
                    interval = 1000;
                    myTimer = new MyTimer(startTimer,interval);
                    myTimer.start();

                    giusti++;
                    numq += 1;
                    num = 0;
                    calcolaPunteggio();
                    x = 0;
                } catch (NumberFormatException e) {
                    serie++;
                    Toast.makeText(Livello4Normale.this, "Hai inserito un valore non corretto!",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        avanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numq <= daIndovinare) {
                    avanti.setVisibility(View.GONE);
                    qst.setText("");
                    qst.setVisibility(View.VISIBLE);
                    t.setVisibility(View.VISIBLE);
                    conferma.setVisibility(View.VISIBLE);
                    testo.setText("");
                    quesito.setText("");
                    q = gq.generaq4();
                    t.setText("");
                    qst.setText(q.getQuesito());
                } else {
                    daActivity = true;
                    startActivity(new Intent(Livello4Normale.this, Vittoria4.class));
                }

            }
        });

    }


    public class MyTimer extends CountDownTimer {

        public MyTimer(long startTime, long interval) {

            super(startTime, interval);
        }

        public void onFinish() {
            avanti.setVisibility(View.VISIBLE);
        }


        @Override

        public void onTick(long millisUntilFinished) {
            if (q.getTipo().equals("text")) {
            testo.append(q.getStringa() + " ");
            } else {
                x+= q.getNum();
                testo.append(" " + (x));
            }
            }

        }

    protected void onResume() {
        super.onResume();
        if (daActivity) {
            finish();
        }

    }

    private void calcolaPunteggio() {
        penalizza = serie * penalizza;

        punteggio += puntiARisposta * moltiplicatore - penalizza;


    }
}