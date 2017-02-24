package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by andrea on 18/02/17.
 */
public class Livello3Impossible extends AppCompatActivity{
    TextView consegna,se,altrimenti;
    TextView[] tipi=new TextView[2], nome= new TextView[2], uguale= new TextView[2], puntoEVirgola= new TextView[2];
    EditText[] input= new EditText[5];
    Button avanti;
    Esercizio3Impossibile esercizio= new Esercizio3Impossibile();
    Vibrator vi;
    static int punteggio = 0;
    int moltiplicatore, serie=0;
    final int puntiARisposta=50;
    private int giusti = 0; //tengo conto di quante risposte sono state indovinate, variabile contatore per la stampa del messaggio di vittoria
    private final int daIndovinare=5; //Rrendo più facile la modifica del codice e lo rendo più leggibile
    static boolean daActivity=false;
    boolean giusto, condizione;
    Typeface custom_font, consegne_font; // per usare il font esterno
    Button help;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.livello3impossibile);
        for(int i=0; i<5; i++){
            if(i<2){
                tipi[i]= new TextView(this);
                nome[i]= new TextView(this);
                uguale[i]= new TextView(this);
                puntoEVirgola[i]= new TextView(this);
            }
            input[i]= new EditText(this);
        }
        consegna=(TextView) findViewById(R.id.consegna);
        tipi[0]=(TextView) findViewById(R.id.tipo1);
        nome[0]=(TextView) findViewById(R.id.nome1);
        uguale[0]=(TextView) findViewById(R.id.uguale1);
        input[0]=(EditText) findViewById(R.id.valore1);
        puntoEVirgola[0]=(TextView) findViewById(R.id.puntoEVirgola1);
        tipi[1]=(TextView) findViewById(R.id.tipo2);
        nome[1]=(TextView) findViewById(R.id.nome2);
        uguale[1]=(TextView) findViewById(R.id.uguale2);
        input[1]=(EditText) findViewById(R.id.valore2);
        puntoEVirgola[1]=(TextView) findViewById(R.id.puntoEVirgola2);
        input[2]=(EditText) findViewById(R.id.condizione); // CONDIZIONE
        input[3]=(EditText) findViewById(R.id.then); // RAMO THEN
        input[4]=(EditText) findViewById(R.id.ramoElse); // RAMO ELSE
        avanti=(Button) findViewById(R.id.avanti);
        vi=(Vibrator) getSystemService(VIBRATOR_SERVICE);
        giusto=false;
        se = (TextView) findViewById(R.id.se);
        altrimenti = (TextView) findViewById(R.id.altrimenti);
        help=(Button) findViewById(R.id.helpbutton);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Livello3Impossible.this, Tutorial3Impossibile.class));
            }
        });


        // inizializzo i font
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Acids!.otf");
        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");


        // specifico il font di ogni elemento
        se.setTypeface(custom_font);
        input[2].setTypeface(consegne_font);
        input[3].setTypeface(consegne_font);
        altrimenti.setTypeface(custom_font);
        input[4].setTypeface(consegne_font);
        consegna.setTypeface(consegne_font);

        tipi[0].setTypeface(consegne_font);
        nome[0].setTypeface(consegne_font);
        input[0].setTypeface(consegne_font);
        tipi[1].setTypeface(consegne_font);
        nome[1].setTypeface(consegne_font);
        input[1].setTypeface(consegne_font);
        avanti.setTypeface(custom_font);


        esercizio.genera();
        inizializzaDomanda();

        avanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(esercizio.tipo2.equals("")&&!(input[0].getText().toString().equals(esercizio.valore1))){
                    vi.vibrate(500);
                    input[0].setTextColor(Color.RED);
                    serie=0;
                    giusto=false;
                }
                else{
                    if((input[0].getText().toString().equals(esercizio.valore1)||input[0].getText().toString().equals(esercizio.valore2))&&!(input[0].getText().equals(input[1].getText()))){
                        serie++;
                    }
                    else{
                        if((input[0].getText().toString().equals(esercizio.valore1))){
                            serie++;
                        }
                        else{
                            vi.vibrate(500);
                            input[0].setTextColor(Color.RED);
                            serie=0;
                            giusto=false;
                        }

                    }
                }
                if(input[1].getVisibility()==View.VISIBLE){
                    if((input[1].getText().toString().equals(esercizio.valore1)||input[1].getText().toString().equals(esercizio.valore2))&&!(input[0].getText().equals(input[1].getText()))){
                        serie++;
                    }
                    else{
                        if(input[1].getText().toString().equals(esercizio.valore2)){
                            serie++;
                        }
                        else{
                            vi.vibrate(500);
                            input[1].setTextColor(Color.RED);
                            serie=0;
                            giusto=false;
                        }
                    }
                }
                if(esercizio.condizioniPositive.contains(input[2].getText().toString())){
                    condizione=true;
                }
                else{
                    if(esercizio.condizioniNegative.contains(input[2].getText().toString())){
                        condizione=false;
                    }
                    else{
                        vi.vibrate(500);
                        input[2].setTextColor(Color.RED);
                        serie=0;
                        giusto=false;
                    }
                }

                if(input[3].getText().toString().equals(esercizio.ramoThen)&&condizione){
                    serie++;
                }
                else{
                    if(input[3].getText().toString().equals(esercizio.ramoElse)&&(!condizione)){
                        serie++;
                    }
                    else{
                        vi.vibrate(500);
                        input[3].setTextColor(Color.RED);
                        serie=0;
                        giusto=false;
                    }
                }
                if(input[4].getText().toString().equals(esercizio.ramoThen)&&(!condizione)){
                    serie++;
                }
                else{
                    if(input[4].getText().toString().equals(esercizio.ramoElse)&&condizione){
                        serie++;
                    }
                    else{
                        vi.vibrate(500);
                        input[3].setTextColor(Color.RED);
                        serie=0;
                        giusto=false;
                    }
                }

                if(giusto){
                    calcolaPunteggio();
                    giusti++;
                    if(giusti<daIndovinare){
                        esercizio.genera();
                        inizializzaDomanda();
                    }
                    else{
                        startActivity(new Intent(Livello3Impossible.this, Vittoria3Impossible.class));
                    }
                }
                giusto=true;


            }
        });

    }

    private void inizializzaDomanda(){
        for(int i=0; i<2; i++){
            tipi[i].setVisibility(View.VISIBLE);
            nome[i].setVisibility(View.VISIBLE);
            uguale[i].setVisibility(View.VISIBLE);
            input[i].setVisibility(View.VISIBLE);
            puntoEVirgola[i].setVisibility(View.VISIBLE);

        }
        for(int i=0; i<5; i++){
            input[i].setText("");
        }
        consegna.setText(esercizio.quesito);
        tipi[0].setText(esercizio.tipo1);
        nome[0].setText(esercizio.nome1);
        tipi[1].setText(esercizio.tipo2);
        nome[1].setText(esercizio.nome2);

        for(int i=0; i<2; i++){
            if(tipi[i].getText().toString().equals("")){
                tipi[i].setVisibility(View.GONE);
                nome[i].setVisibility(View.GONE);
                uguale[i].setVisibility(View.GONE);
                input[i].setVisibility(View.GONE);
                puntoEVirgola[i].setVisibility(View.GONE);
            }
        }
        giusto=true;
    }

    @Override
    protected void onResume(){
        super.onResume();

        if(daActivity){//Se ho cambiato activity chiudo il livello1
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
