package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by andrea on 20/02/17.
 */
public class Livello4Impossible extends AppCompatActivity{
    TextView consegna, risultato, azione;
    EditText[] input= new EditText[3];
    Button avanti;
    static int punteggio;
    int moltiplicatore, serie=0;
    final int puntiARisposta=50;
    private int giusti = 0, stato=0; //tengo conto di quante risposte sono state indovinate, variabile contatore per la stampa del messaggio di vittoria
    private final int daIndovinare=5; //Rrendo più facile la modifica del codice e lo rendo più leggibile
    Vibrator vi;
    boolean giusto=true;
    static boolean daActivity=false;
    Esercizio4Impossibile esercizio;

    @Override
    public void onCreate(Bundle savedIstance){
        super.onCreate(savedIstance);
        setContentView(R.layout.livello4impossibile);

        for(int i=0; i<3; i++){
            input[i]=new EditText(this);
        }
        consegna=(TextView) findViewById(R.id.consegna);
        input[0]=(EditText) findViewById(R.id.inizializzazione);
        input[1]=(EditText) findViewById(R.id.condizione);
        input[2]=(EditText) findViewById(R.id.incremento);
        azione=(TextView) findViewById(R.id.azione);
        risultato=(TextView) findViewById(R.id.risultato);
        avanti=(Button) findViewById(R.id.avanti);
        vi=(Vibrator) getSystemService(VIBRATOR_SERVICE);
        esercizio= new Esercizio4Impossibile();

        inizializzaDomanda();

        input[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input[0].setTextColor(Color.parseColor("#000000"));
            }
        });
        input[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input[1].setTextColor(Color.parseColor("#000000"));
            }
        });
        input[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input[2].setTextColor(Color.parseColor("#000000"));
            }
        });

        avanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(stato==0){
                    if(esercizio.inizializzazione.contains(input[0].getText().toString())){
                        serie++;
                    }
                    else{
                        serie=0;
                        vi.vibrate(500);
                        input[0].setTextColor(Color.RED);
                        giusto=false;
                    }

                    if(esercizio.condizione.contains(input[1].getText().toString())){
                        serie++;
                    }
                    else{
                        serie=0;
                        vi.vibrate(500);
                        input[0].setTextColor(Color.RED);
                        giusto=false;
                    }

                    if(esercizio.incremento.contains(input[2].getText().toString())){
                        serie++;
                    }
                    else{
                        serie=0;
                        vi.vibrate(500);
                        input[0].setTextColor(Color.RED);
                        giusto=false;
                    }
                    if(giusto){
                        giusti++;
                        calcolaPunteggio();
                        stato=1;
                        avanti.setText("Avanti");
                    }
                    else{
                        giusto=true;
                    }

                }
                else{
                    if(giusti<daIndovinare){
                        inizializzaDomanda();
                    }
                    else{
                        startActivity(new Intent(Livello4Impossible.this, Vittoria4Impossible.class));
                    }
                }
            }
        });






    }

    private void inizializzaDomanda(){
        esercizio.genera();
        avanti.setText("Via");
        consegna.setText(esercizio.consegna);
        for(int i=0; i<3;i++){
            input[i].setText("");
        }
        azione.setText(esercizio.azione);
        risultato.setText("");
        stato=0;
        giusto=true;
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
        if(daActivity){
            finish();
        }
    }
}
