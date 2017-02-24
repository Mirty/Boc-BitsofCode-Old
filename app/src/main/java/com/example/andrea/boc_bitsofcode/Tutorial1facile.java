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

public class Tutorial1facile extends AppCompatActivity {

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

        descrizioni[0] = "In informatica, per rappresentare i valori si usano dei tipi. Immagina di vedere un numero e pensare: \"ehi, quello è un numero!\". Oppure immagina di vedere un nome e pensare: \"ma quello è un nome!\" Per ogni dato esiste quello che si chiama il suo \"tipo di dato\". In questo gioco comprariranno 4 tipi di dato semplice, e sono semplicissimi da ricordare!";
        descrizioni[1] = "Quando tu vedi un numero, questo può essere di tipo int o di tipo float. In generale i numeri sono int, ma se hanno il punto sono float. Quindi se tu dovessi vedere il numero 8 dovresti cliccare sul bottone : ";
        descrizioni[2] = "Quando tu vedi un numero, questo può essere di tipo int o di tipo float. In generale i numeri sono int, ma se hanno il punto sono float. Quindi se tu vedessi il numero 8.0 dovresti cliccare sul bottone : ";
        descrizioni[3]="Come è possibile rappresentare il tipo del tuo nome? Il tuo nome non è un numero, bensì è un insieme di lettere. Per rappresentare una sequenza di lettere si usa il tipo string. Quindi se tu dovessi vedere \"Djanni\" dovresti cliccare sul bottone STRING. Riconosci i dati di tipo string perché iniziano e finiscono sempre con le virgolette. Dentro le virgolette può starci qualsiasi cosa, ad esempio anche dei numeri. Ricordati che se ci sono le virgolette allora è un dato di tipo string. Se infattitu dovessi trovare \"123\" allora capiresti che è un dato di tipo string perché inizia e finisce con le virgolette. ";
        descrizioni[4]="L'ultimo tipo di dato è il tipo bool, che può rappresentare solo 2 valori diversi: true e false. True in inglese significa vero, mentre false significa falso. Se tu dovessi dire di che tipo è il valore true, cliccheresti sul bottone BOOL. Capirai che true non è una stringa perché non è racchiusa da virgolette. Se invece trovassi \"true\" allora capiresti che è una stringa perché il dato comincia e finisce con le virgolette. \n";
        descrizioni[5]="Quindi ricordati che esistono 4 tipi di dato differenti, ovvero:\nint per i numeri senza il punto,\nfloat per i numeri che hanno il punto\nstring per tutto ciò che inizia e finisce con le virgolette (\"\")\nbool per i due valori true e false";
        descrizioni[6]="Avvio del livello 1.facile";

        descrizione.setText(descrizioni[0]);

        avanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pagina<6) {
                    if (pagina>0 && pagina <5) bottoni[pagina-1].setVisibility(View.GONE);
                    pagina++;
                    descrizione.setText(descrizioni[pagina]);
                    indietro.setVisibility(View.VISIBLE);
                    if (pagina>0 && pagina <5) bottoni[pagina-1].setVisibility(View.VISIBLE);
                }
                else
                    startActivity(new Intent(Tutorial1facile.this, Livello1.class));
            }
        });

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pagina>0) {
                    if (pagina>0 && pagina <5) bottoni[pagina-1].setVisibility(View.GONE);
                    pagina--;
                    descrizione.setText(descrizioni[pagina]);
                    if (pagina == 0) indietro.setVisibility(View.GONE);
                    if (pagina>0 && pagina <5) bottoni[pagina-1].setVisibility(View.VISIBLE);
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
