package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by andrea on 07/02/17.
 */
public class Livello3Normale extends AppCompatActivity{
    TextView condizione, ramoThen, graffa, altrimenti, graffa1, ramoElse, graffa2, se, graffaopen2;
    Button bottone1, bottone2, avanti;
    static boolean daActivity=false;
    static int punteggio;
    int moltiplicatore, serie=0;
    final int puntiARisposta=50;
    private int giusti = 0; //tengo conto di quante risposte sono state indovinate, variabile contatore per la stampa del messaggio di vittoria
    private final int daIndovinare=9; //Rrendo più facile la modifica del codice e lo rendo più leggibile
    boolean usatoRamoThen;
    Vibrator vi;
    LIvello3NormaleEsercizio esercizio;
    Typeface custom_font, consegne_font; // per usare il font esterno
    Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livello3);

        //inizializzo i vari elementi dell'activity
        se = (TextView) findViewById(R.id.se);
        condizione=(TextView) findViewById(R.id.condizione);
        ramoThen=(TextView) findViewById(R.id.ramoThen);
        graffa=(TextView) findViewById(R.id.graffa);
        altrimenti=(TextView) findViewById(R.id.altrimenti);
        graffa1=(TextView) findViewById(R.id.graffa1);
        ramoElse=(TextView) findViewById(R.id.ramoElse);
        graffa2=(TextView) findViewById(R.id.graffa2);
        graffaopen2=(TextView) findViewById(R.id.graffaopen2);
        bottone1=(Button) findViewById(R.id.bottone1);
        bottone2=(Button) findViewById(R.id.bottone2);
        avanti=(Button) findViewById(R.id.avanti);
        vi=(Vibrator) getSystemService(VIBRATOR_SERVICE); //inizializzo la vibrazione
        esercizio=new LIvello3NormaleEsercizio();


        help=(Button) findViewById(R.id.helpbutton);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Livello3Normale.this, Tutorial3Facile.class));
            }
        });


        // inizializzo i font
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Acids!.otf");
        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");


        // specifico il font di ogni elemento
        se.setTypeface(custom_font);
        altrimenti.setTypeface(custom_font);

        condizione.setTypeface(consegne_font);
        ramoThen.setTypeface(consegne_font);
        ramoElse.setTypeface(consegne_font);

        bottone1.setTypeface(consegne_font);
        bottone2.setTypeface(consegne_font);
        avanti.setTypeface(custom_font);



        usatoRamoThen=false;
        avanti.setVisibility(View.GONE);
        esercizio.genera();
        ramoThen.setText("");
        condizione.setText(""+esercizio.condizione);
        bottone1.setVisibility(View.VISIBLE);
        bottone2.setVisibility(View.VISIBLE);
        bottone1.setText(esercizio.bottone1);
        bottone2.setText(esercizio.bottone2);
        // all'inizio non faccio visualizzare nulla del ramo else
        altrimenti.setVisibility(View.GONE);
        graffa.setVisibility(View.GONE);
        graffaopen2.setVisibility(View.GONE);
        ramoElse.setVisibility(View.GONE);


        bottone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usatoRamoThen && esercizio.tipo==1){
                    serie++;
                    calcolaPunteggio();
                    ramoElse.setText("     "+esercizio.bottone1);
                    bottone1.setVisibility(View.GONE);
                    giusti++;
                    avanti.setVisibility(View.VISIBLE);
                }
                else{
                    if((!usatoRamoThen) && esercizio.tipo==1){
                        serie=0;
                        vi.vibrate(500);
                    }
                    else{
                        if(usatoRamoThen && esercizio.tipo==0){ //Lo gestisco ma non dovrebbe mai verificarsi
                            serie=0;
                            vi.vibrate(500);
                        }
                        else{
                            if((!usatoRamoThen) && esercizio.tipo==0){
                                serie++;
                                ramoThen.setText("     "+esercizio.bottone1);
                                calcolaPunteggio();
                                bottone1.setVisibility(View.GONE);
                                usatoRamoThen=true;

                                altrimenti.setVisibility(View.VISIBLE);
                                graffa.setVisibility(View.VISIBLE);
                                graffaopen2.setVisibility(View.VISIBLE);
                                ramoElse.setText("");
                                ramoElse.setVisibility(View.VISIBLE);
                            }
                        }
                    }
                }
            }
        });

        bottone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usatoRamoThen && esercizio.tipo==0){
                    serie++;
                    calcolaPunteggio();
                    ramoElse.setText("     "+esercizio.bottone2);
                    bottone2.setVisibility(View.GONE);
                    giusti++;
                    avanti.setVisibility(View.VISIBLE);
                }
                else{
                    if(usatoRamoThen && esercizio.tipo==1){ //Non dovrebbe mai verificarsi
                        serie=0;
                        vi.vibrate(500);
                    }
                    else{
                        if((!usatoRamoThen) && esercizio.tipo==1){
                            serie++;
                            calcolaPunteggio();
                            ramoThen.setText("     "+esercizio.bottone2);
                            bottone2.setVisibility(View.GONE);
                            usatoRamoThen=true;

                            altrimenti.setVisibility(View.VISIBLE);
                            graffa.setVisibility(View.VISIBLE);
                            graffaopen2.setVisibility(View.VISIBLE);
                            ramoElse.setText("");
                            ramoElse.setVisibility(View.VISIBLE);

                        }
                        else{
                            if((!usatoRamoThen) && esercizio.tipo==0){
                                serie=0;
                                vi.vibrate(500);
                            }
                        }
                    }
                }
            }
        });

        avanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(giusti>=daIndovinare){
                    startActivity(new Intent(Livello3Normale.this, Vittoria3Normale.class));
                }
                else {
                    esercizio.genera();
                    condizione.setText(esercizio.condizione);
                    ramoThen.setText("");
                    usatoRamoThen = false;
                    ramoElse.setText("");
                    bottone1.setVisibility(View.VISIBLE);
                    bottone1.setText(esercizio.bottone1);
                    bottone2.setVisibility(View.VISIBLE);
                    bottone2.setText(esercizio.bottone2);
                    avanti.setVisibility(View.GONE);

                    // dell'else non mostro nulla
                    altrimenti.setVisibility(View.GONE);
                    graffa.setVisibility(View.GONE);
                    graffaopen2.setVisibility(View.GONE);
                    ramoElse.setText("");
                    ramoElse.setVisibility(View.GONE);
                }
            }
        });





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

        if(daActivity){//Se ho cambiato activity chiudo il livello1
            finish();
        }

    }

}
