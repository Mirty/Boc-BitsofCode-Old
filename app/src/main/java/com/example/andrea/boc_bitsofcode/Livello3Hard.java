package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by andrea on 10/02/17.
 */
public class Livello3Hard extends AppCompatActivity{
    public static boolean daActivity=false;
    TextView[] tipo=new TextView[5], nome=new TextView[5], uguale=new TextView[5], valore=new TextView[5], puntoEVirgola=new TextView[5];
    TextView condizione, ramoThen, graffa, altrimenti, graffa1, ramoElse, graffa2, se;
    Button bottone1, bottone2;
    Vibrator vi;
    EsercizioLivello3Difficle esercizio= new EsercizioLivello3Difficle();
    static int punteggio;
    int moltiplicatore, serie=0;
    final int puntiARisposta=50;
    private int giusti = 0; //tengo conto di quante risposte sono state indovinate, variabile contatore per la stampa del messaggio di vittoria
    private final int daIndovinare=9; //Rrendo più facile la modifica del codice e lo rendo più leggibile
    Typeface custom_font, consegne_font; // per usare il font esterno
    Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livello3hard);

        for(int i=0; i<5; i++){
            tipo[i]=new TextView(this);
            nome[i]=new TextView(this);
            uguale[i]=new TextView(this);
            valore[i]=new TextView(this);
            puntoEVirgola[i]=new TextView(this);
        }
        /**INIZIO INIZIALIZZAZIONE**/
        tipo[0]=(TextView) findViewById(R.id.tipi);
        tipo[1]=(TextView) findViewById(R.id.tipi1);
        /*
        tipo[2]=(TextView) findViewById(R.id.tipi2);
        tipo[3]=(TextView) findViewById(R.id.tipi3);
        tipo[4]=(TextView) findViewById(R.id.tipi4);*/
        nome[0]=(TextView) findViewById(R.id.nome);
        nome[1]=(TextView) findViewById(R.id.nome1);
        /*
        nome[2]=(TextView) findViewById(R.id.nome2);
        nome[3]=(TextView) findViewById(R.id.nome3);
        nome[4]=(TextView) findViewById(R.id.nome4); */
        uguale[0]=(TextView) findViewById(R.id.uguale);
        uguale[1]=(TextView) findViewById(R.id.uguale1);
        /*
        uguale[2]=(TextView) findViewById(R.id.uguale2);
        uguale[3]=(TextView) findViewById(R.id.uguale3);
        uguale[4]=(TextView) findViewById(R.id.uguale4);*/
        valore[0]=(TextView) findViewById(R.id.valore);
        valore[1]=(TextView) findViewById(R.id.valore1);
        /*
        valore[2]=(TextView) findViewById(R.id.valore2);
        valore[3]=(TextView) findViewById(R.id.valore3);
        valore[4]=(TextView) findViewById(R.id.valore4);*/
        puntoEVirgola[0]=(TextView) findViewById(R.id.puntoEVirgola);
        puntoEVirgola[1]=(TextView) findViewById(R.id.puntoEVirgola1);
        /*
        puntoEVirgola[2]=(TextView) findViewById(R.id.puntoEVirgola2);
        puntoEVirgola[3]=(TextView) findViewById(R.id.puntoEVirgola3);
        puntoEVirgola[4]=(TextView) findViewById(R.id.puntoEVirgola4);*/
        se = (TextView) findViewById(R.id.se);
        condizione=(TextView) findViewById(R.id.condizione);
        ramoThen=(TextView) findViewById(R.id.ramoThen);
        graffa=(TextView) findViewById(R.id.graffa);
        altrimenti=(TextView) findViewById(R.id.altrimenti);
        graffa1=(TextView) findViewById(R.id.graffa1);
        ramoElse=(TextView) findViewById(R.id.ramoElse);
        graffa2=(TextView) findViewById(R.id.graffa2);
        bottone1=(Button) findViewById(R.id.bottone1);
        bottone2=(Button) findViewById(R.id.bottone2);
        vi=(Vibrator) getSystemService(VIBRATOR_SERVICE);

        // inizializzo i font
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Acids!.otf");
        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");

        // specifico il font di ogni elemento
        se.setTypeface(custom_font);
        condizione.setTypeface(consegne_font);
        ramoThen.setTypeface(consegne_font);
        altrimenti.setTypeface(custom_font);
        ramoElse.setTypeface(consegne_font);

        bottone1.setTypeface(consegne_font);
        bottone2.setTypeface(consegne_font);


        tipo[0].setTypeface(consegne_font);
        tipo[1].setTypeface(consegne_font);
        /*
        tipo[2].setTypeface(consegne_font);
        tipo[3].setTypeface(consegne_font);
        tipo[4].setTypeface(consegne_font);*/

        nome[0].setTypeface(consegne_font);
        nome[1].setTypeface(consegne_font);
        /*
        nome[2].setTypeface(consegne_font);
        nome[3].setTypeface(consegne_font);
        nome[4].setTypeface(consegne_font);*/

        valore[0].setTypeface(consegne_font);
        valore[1].setTypeface(consegne_font);
        /*
        valore[2].setTypeface(consegne_font);
        valore[3].setTypeface(consegne_font);
        valore[4].setTypeface(consegne_font);*/
        help=(Button) findViewById(R.id.helpbutton);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Livello3Hard.this, Tutorial3Difficile.class));
            }
        });


        /**FINE INIZIALIZZAZIONE**/

        inizializza();

        bottone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(esercizio.tipo==0){
                    if(giusti<daIndovinare){
                        giusti++;
                        serie++;
                        calcolaPunteggio();
                        inizializza();
                    }
                    else{
                        startActivity(new Intent(Livello3Hard.this, Vittoria3Hard.class));
                    }

                }
                else{
                    serie=0;
                    vi.vibrate(500);
                }
            }
        });

        bottone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(esercizio.tipo==1){
                    if(giusti<daIndovinare){
                        giusti++;
                        serie++;
                        calcolaPunteggio();
                        inizializza();
                    }
                    else{
                        startActivity(new Intent(Livello3Hard.this, Vittoria3Hard.class));
                    }

                }
                else{
                    serie=0;
                    vi.vibrate(500);
                }
            }
        });



    }

    private void inizializza(){
        for(int i=0; i<5; i++){
            tipo[i].setVisibility(View.VISIBLE);
            nome[i].setVisibility(View.VISIBLE);
            uguale[i].setVisibility(View.VISIBLE);
            valore[i].setVisibility(View.VISIBLE);
            puntoEVirgola[i].setVisibility(View.VISIBLE);
        }
        esercizio.genera();

        for(int i=0; i<5; i++){
            if(esercizio.tipi[i].equals("")){
                tipo[i].setVisibility(View.GONE);
                nome[i].setVisibility(View.GONE);
                uguale[i].setVisibility(View.GONE);
                valore[i].setVisibility(View.GONE);
                puntoEVirgola[i].setVisibility(View.GONE);
            }
            else{
                tipo[i].setText(esercizio.tipi[i]+" ");
                nome[i].setText(esercizio.nome[i]+" ");
                valore[i].setText(esercizio.valore[i]);
            }
        }
        condizione.setText(esercizio.condizione);
        ramoThen.setText(esercizio.then);
        ramoElse.setText(esercizio.altrimenti);
        bottone1.setText(esercizio.bottone1);
        bottone2.setText(esercizio.bottone2);

    }

    private void calcolaPunteggio(){
        if(serie>=0 && serie <2){
            moltiplicatore=1;
        }
        else{
            if(serie>=2 && serie <5){
                moltiplicatore=2;
            }
            else{
                if(serie>=5 && serie <6){
                    moltiplicatore=3;
                }
                else{
                    moltiplicatore=4;
                }
            }
        }

        punteggio+=puntiARisposta*moltiplicatore;


    }
    @Override
    protected void onResume(){
        super.onResume();

        if(daActivity){//Se ho cambiato activity chiudo il livello3
            finish();
        }

    }

}
