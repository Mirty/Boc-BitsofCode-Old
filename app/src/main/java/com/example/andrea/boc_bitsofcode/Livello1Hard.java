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


/**
 * Created by andrea on 18/01/17.
 */
public class Livello1Hard extends AppCompatActivity{

    TextView domanda, consegna;
    static Esercizio polloFritto=new Esercizio();
    Button interi, reali, stringhe, booleani;
    Vibrator vi;
    static String nomeVariabile, rispostaData;
    static int punteggio = 0, serie=0, moltiplicatore;
    final static int puntiARisposta=50;
    static int giusti = 0; //tengo conto di quante risposte sono state indovinate, variabile contatore per la stampa del messaggio di vittoria
    static final int daIndovinare=5; //Rrendo più facile la modifica del codice e lo rendo più leggibile
    static boolean daActivity=false;
    CountDownTimer timer;
    Typeface buttons_font, consegne_font;
    Button help;



    @Override
    protected void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.livello1difficile);

        consegna = (TextView) findViewById(R.id.consegna);
        domanda=(TextView)findViewById(R.id.testo);
        interi=(Button)findViewById(R.id.interi);
        reali=(Button)findViewById(R.id.reali);
        stringhe=(Button)findViewById(R.id.stringa);
        booleani=(Button)findViewById(R.id.booleani);
        vi=(Vibrator) getSystemService(VIBRATOR_SERVICE); //inizializzo la vibrazione

        polloFritto.genera();
        consegna.setText(""+polloFritto.domanda);
        domanda.setText("Scegli il TIPO della variabile");

        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");
        buttons_font = Typeface.createFromAsset(getAssets(),  "fonts/Acids!.otf");
        domanda.setTypeface(consegne_font);
        consegna.setTypeface(consegne_font);
        interi.setTypeface(buttons_font);
        reali.setTypeface(buttons_font);
        stringhe.setTypeface(buttons_font);
        booleani.setTypeface(buttons_font);

        help=(Button) findViewById(R.id.helpbutton);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Livello1Hard.this, Tutorial1Difficile.class));
            }
        });

        timer = new CountDownTimer(500, 100) { //Inizializzo il timer per la gestione del cambiamento di colore
            @Override
            public void onTick(long millisUntilFinished) {
                domanda.setTextColor(Color.RED);
            }

            @Override
            public void onFinish() {
                domanda.setTextColor(Color.parseColor("#3F51B5"));
            }
        };

        interi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(polloFritto.tipo==0){
                    serie++;
                    calcolaPunteggio();
                    startActivity(new Intent(Livello1Hard.this, Livello1HardII.class));
                }
                else{
                    timer.start(); //cambio il colore del font per 1/2 secondo
                    vi.vibrate(500);
                    serie=0;
                }

            }
        });

        reali.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(polloFritto.tipo==1){
                    serie++;
                    calcolaPunteggio();
                    startActivity(new Intent(Livello1Hard.this, Livello1HardII.class));
                }
                else{
                    timer.start(); //cambio il colore del font per 1/2 secondo
                    vi.vibrate(500);
                    serie=0;
                }

            }
        });

        stringhe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(polloFritto.tipo==2){
                    serie++;
                    calcolaPunteggio();
                    startActivity(new Intent(Livello1Hard.this, Livello1HardII.class));
                }
                else{
                    timer.start(); //cambio il colore del font per 1/2 secondo
                    vi.vibrate(500);
                    serie=0;
                }

            }
        });

        booleani.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(polloFritto.tipo==3){
                    serie++;
                    calcolaPunteggio();
                    startActivity(new Intent(Livello1Hard.this, Livello1HardII.class));
                }
                else{
                    timer.start(); //cambio il colore del font per 1/2 secondo
                    vi.vibrate(500);
                    serie=0;
                }

            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();

        if(daActivity){//Se ho cambiato activity chiudo il livello1
            finish();
        }
        polloFritto.genera();
        consegna.setText(""+polloFritto.domanda);
        Livello1HardII.daActivity=false;


    }

    public static void calcolaPunteggio(){
        switch(serie){
            case 0:
                moltiplicatore=1;
                break;
            case 1:
                moltiplicatore=2;
                break;
            case 2:
                moltiplicatore=3;
                break;
            case 3:
                moltiplicatore=4;
                break;
            default:
                moltiplicatore=5;

        }

        punteggio+=puntiARisposta*moltiplicatore;


    }

}
