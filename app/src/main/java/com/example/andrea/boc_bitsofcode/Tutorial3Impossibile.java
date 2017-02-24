package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mirty on 24/01/17.
 */

public class Tutorial3Impossibile extends AppCompatActivity {

    Typeface custom_font, programming_font, consegne_font;
    TextView descrizione;
    Button avanti, indietro, tipo;
    int pagina; // mi serve per verificare a che punto del tutorial ci si trova
    String descrizioni[];
    Button bottoni[];
    static boolean daActivity=false;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial1facile);

        // inizializzo gli elementi grafici
        descrizione = (TextView) findViewById(R.id.descrizione);
        avanti = (Button) findViewById(R.id.avanti);
        indietro = (Button) findViewById(R.id.indietro);
        tipo = (Button) findViewById(R.id.tipo);
        //  inizializzo i font
        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");
        programming_font = Typeface.createFromAsset(getAssets(),  "fonts/Courier New.ttf");
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Acids!.otf");
        // inizializzo il resto
        pagina = 0;
        descrizioni = new String [7];
        bottoni = new Button[4];

        // personalizzo gli elementi grafici
        descrizione.setTypeface(consegne_font);
        tipo.setTypeface(custom_font);
        tipo.setVisibility(View.GONE);
        indietro.setVisibility(View.GONE);
        for (int i=0; i<4; i++) {
            if (i == 0) bottoni[i] = (Button) findViewById(R.id.intbutton);
            if (i == 1) bottoni[i] = (Button) findViewById(R.id.floatbutton);
            if (i == 2) bottoni[i] = (Button) findViewById(R.id.stringbutton);
            if (i == 3) bottoni[i] = (Button) findViewById(R.id.boolbutton);
            bottoni[i].setTypeface(custom_font);
            bottoni[i].setVisibility(View.GONE);
        }

        descrizioni[0] = "Fantastico! Ora sei un pro nell'uso del costrutto if! A questo punto puoi sfruttare tutte le tue conoscenze sulle variabili, sulle funzioni e sull'if per scrivere le tue prime righe di codice, sempre in maniera guidata!\nLeggi la consegna, assegna un valore alle variabili, scrivi la condizione dell'if e le istruzioni che verranno eseguite se la condizione è vera o falsa.";
         descrizioni[1]="Avvio del livello 3.impossibile";

        descrizione.setText(descrizioni[0]);

        avanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pagina<1) {
                    pagina++;
                    descrizione.setText(descrizioni[pagina]);
                    indietro.setVisibility(View.VISIBLE);
                }
                else
                    startActivity(new Intent(Tutorial3Impossibile.this, Livello3Impossible.class));
            }
        });

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pagina>0) {
                    pagina--;
                    descrizione.setText(descrizioni[pagina]);
                    if (pagina == 0) indietro.setVisibility(View.GONE);
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

    }
}
