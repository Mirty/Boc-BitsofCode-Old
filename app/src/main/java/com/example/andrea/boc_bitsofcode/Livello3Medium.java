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

import java.util.Random;

/**
 * Created by andrea on 09/02/17.
 */
public class Livello3Medium extends AppCompatActivity{
    TextView condizione, ramoThen, graffa, altrimenti, graffa1, ramoElse, graffa2, primagraffa, se;
    Button bottone1, bottone2, avanti, bottone3, bottone4;
    static boolean daActivity=false;
    boolean usatoRamoThen;
    static int punteggio;
    int moltiplicatore, serie=0;
    final int puntiARisposta=50;
    private int giusti = 0, stato=0; //tengo conto di quante risposte sono state indovinate, variabile contatore per la stampa del messaggio di vittoria
    private final int daIndovinare=9; //Rrendo più facile la modifica del codice e lo rendo più leggibile
    Vibrator vi;
    LIvello3NormaleEsercizio esercizio;
    Distrazioni distrazione;
    Typeface custom_font, consegne_font; // per usare il font esterno
    Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livello3medium);

        //inizializzo i vari elementi dell'activity
        se = (TextView) findViewById(R.id.se);
        condizione=(TextView) findViewById(R.id.condizione);
        primagraffa=(TextView) findViewById(R.id.primagraffa);
        ramoThen=(TextView) findViewById(R.id.ramoThen);
        graffa=(TextView) findViewById(R.id.graffa);
        altrimenti=(TextView) findViewById(R.id.altrimenti);
        graffa1=(TextView) findViewById(R.id.graffa1);
        ramoElse=(TextView) findViewById(R.id.ramoElse);
        graffa2=(TextView) findViewById(R.id.graffa2);
        bottone1=(Button) findViewById(R.id.bottone1);
        bottone2=(Button) findViewById(R.id.bottone2);
        avanti=(Button) findViewById(R.id.avanti);
        bottone3=(Button) findViewById(R.id.bottone3);
        bottone4=(Button) findViewById(R.id.bottone4);
        vi=(Vibrator) getSystemService(VIBRATOR_SERVICE); //inizializzo la vibrazione
        esercizio=new LIvello3NormaleEsercizio();
        distrazione= new Distrazioni();
        usatoRamoThen=false;

        help=(Button) findViewById(R.id.helpbutton);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Livello3Medium.this, Tutorial3Medio.class));
            }
        });


        esercizio.genera();

        bottone1.setVisibility(View.VISIBLE);
        bottone2.setVisibility(View.VISIBLE);
        bottone3.setVisibility(View.VISIBLE);
        bottone4.setVisibility(View.VISIBLE);
        avanti.setVisibility(View.INVISIBLE);
        ramoThen.setVisibility(View.INVISIBLE);
        ramoElse.setVisibility(View.INVISIBLE);
        primagraffa.setVisibility(View.INVISIBLE);
        graffa.setVisibility(View.INVISIBLE);
        graffa1.setVisibility(View.INVISIBLE);
        graffa2.setVisibility(View.INVISIBLE);
        altrimenti.setVisibility(View.INVISIBLE);
        condizione.setText("");
        popolaPulsanti();


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
        bottone3.setTypeface(consegne_font);
        bottone4.setTypeface(consegne_font);
        avanti.setTypeface(custom_font);







        bottone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stato==0){ // condizione  inserita
                    if(("("+bottone1.getText().toString()+")").equals(esercizio.condizione)){
                        serie++;
                        bottone3.setVisibility(View.GONE);
                        bottone4.setVisibility(View.GONE);
                        condizione.setText(esercizio.condizione);
                        primagraffa.setVisibility(View.VISIBLE);
                        graffa.setVisibility(View.VISIBLE);
                        bottone1.setText(esercizio.bottone1);
                        bottone2.setText(esercizio.bottone2);
                        stato=1;
                    }
                    else{
                        vi.vibrate(500);
                        serie=0;
                    }
                }
                else if(stato==1){ // else  inserito
                    if(usatoRamoThen && esercizio.tipo==1){
                        serie++;
                        ramoElse.setText("     "+esercizio.bottone1);
                        graffa2.setVisibility(View.VISIBLE);
                        bottone1.setVisibility(View.INVISIBLE);
                        ramoElse.setVisibility(View.VISIBLE);
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
                            else{ // then inserito
                                if((!usatoRamoThen) && esercizio.tipo==0){
                                    serie++;
                                    ramoThen.setText("     "+esercizio.bottone1);
                                    ramoThen.setVisibility(View.VISIBLE);
                                    graffa.setVisibility(View.VISIBLE);
                                    graffa1.setVisibility(View.VISIBLE);
                                    altrimenti.setVisibility(View.VISIBLE);
                                    graffa2.setVisibility(View.VISIBLE);
                                    calcolaPunteggio();
                                    bottone1.setVisibility(View.INVISIBLE);
                                    usatoRamoThen=true;
                                }
                            }
                        }
                    }
                }
            }
        });

        bottone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stato==0){ // condizione inserita
                    if(("("+bottone2.getText().toString()+")").equals(esercizio.condizione)){
                        serie++;
                        bottone3.setVisibility(View.GONE);
                        condizione.setText(esercizio.condizione);
                        primagraffa.setVisibility(View.VISIBLE);
                        graffa.setVisibility(View.VISIBLE);
                        bottone4.setVisibility(View.GONE);
                        bottone1.setText(esercizio.bottone1);
                        bottone2.setText(esercizio.bottone2);
                        stato=1;
                    }
                    else{
                        vi.vibrate(500);
                        serie=0;
                    }
                }
                else if(stato==1){ // else inserito
                    if(usatoRamoThen && esercizio.tipo==0){
                        serie++;
                        ramoElse.setText("     "+esercizio.bottone2);
                        ramoElse.setVisibility(View.VISIBLE);
                        graffa2.setVisibility(View.VISIBLE);
                        bottone2.setVisibility(View.INVISIBLE);
                        giusti++;
                        avanti.setVisibility(View.VISIBLE);
                    }
                    else{
                        if(usatoRamoThen && esercizio.tipo==1){ //Non dovrebbe mai verificarsi
                            serie=0;
                            vi.vibrate(500);
                        }
                        else{ // then inserito
                            if((!usatoRamoThen) && esercizio.tipo==1){
                                serie++;
                                calcolaPunteggio();
                                ramoThen.setText("     "+esercizio.bottone2);
                                ramoThen.setVisibility(View.VISIBLE);
                                graffa.setVisibility(View.VISIBLE);
                                graffa1.setVisibility(View.VISIBLE);
                                bottone2.setVisibility(View.INVISIBLE);
                                altrimenti.setVisibility(View.VISIBLE);
                                graffa2.setVisibility(View.VISIBLE);
                                usatoRamoThen=true;
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
            }
        });

        bottone3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(("("+bottone3.getText().toString()+")").equals(esercizio.condizione)){
                    serie++;
                    bottone3.setVisibility(View.INVISIBLE);
                    condizione.setText(esercizio.condizione);
                    graffa.setVisibility(View.VISIBLE);
                    bottone4.setVisibility(View.INVISIBLE);
                    bottone1.setText(esercizio.bottone1);
                    bottone2.setText(esercizio.bottone2);
                    primagraffa.setVisibility(View.VISIBLE);
                    stato=1;
                }
                else{
                    vi.vibrate(500);
                    serie=0;
                }
            }
        });

        bottone4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(("("+bottone4.getText().toString()+")").equals(esercizio.condizione)){
                    serie++;
                    bottone4.setVisibility(View.INVISIBLE);
                    condizione.setText(esercizio.condizione);
                    bottone3.setVisibility(View.INVISIBLE);
                    bottone1.setText(esercizio.bottone1);
                    bottone2.setText(esercizio.bottone2);
                    primagraffa.setVisibility(View.VISIBLE);
                    graffa.setVisibility(View.VISIBLE);
                    stato=1;
                }
                else{
                    vi.vibrate(500);
                    serie=0;
                }
            }
        });

        avanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcolaPunteggio();
                if(giusti>=daIndovinare){
                    startActivity(new Intent(Livello3Medium.this, Vittoria3Medium.class)); //TODO: crea la classe della vittoria
                }
                else {
                    esercizio.genera();
                    condizione.setText("");
                    ramoThen.setText("");
                    usatoRamoThen = false;
                    primagraffa.setVisibility(View.INVISIBLE);
                    stato=0;
                    graffa.setVisibility(View.INVISIBLE);
                    altrimenti.setVisibility(View.INVISIBLE);
                    graffa1.setVisibility(View.INVISIBLE);
                    ramoElse.setText("");
                    graffa2.setVisibility(View.INVISIBLE);
                    bottone1.setVisibility(View.VISIBLE);
                    bottone1.setText(esercizio.bottone1);
                    bottone2.setVisibility(View.VISIBLE);
                    bottone2.setText(esercizio.bottone2);
                    bottone3.setVisibility(View.VISIBLE);
                    bottone4.setVisibility(View.VISIBLE);
                    avanti.setVisibility(View.INVISIBLE);
                    popolaPulsanti();
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

    private void popolaPulsanti(){
        Random rand=new Random();
        String stringa="";
        for(char c : esercizio.condizione.toCharArray()){
            if(c!='{'&&c!='('&&c!=')'){
                stringa=stringa+c;
            }
        }
        switch (Math.abs(rand.nextInt())%4){
            case 0:
                bottone1.setText(stringa);
                bottone2.setText(distrazione.genera());
                bottone3.setText(distrazione.genera());
                bottone4.setText(distrazione.genera());
                break;
            case 1:
                bottone1.setText(distrazione.genera());
                bottone2.setText(stringa);
                bottone3.setText(distrazione.genera());
                bottone4.setText(distrazione.genera());
                break;
            case 2:
                bottone1.setText(distrazione.genera());
                bottone2.setText(distrazione.genera());
                bottone3.setText(stringa);
                bottone4.setText(distrazione.genera());
                break;
            case 3:
                bottone1.setText(distrazione.genera());
                bottone2.setText(distrazione.genera());
                bottone3.setText(distrazione.genera());
                bottone2.setText(stringa);
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        if(daActivity){
            finish();
        }
    }

}
