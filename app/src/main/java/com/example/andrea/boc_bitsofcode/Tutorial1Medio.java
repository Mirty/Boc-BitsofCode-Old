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

public class Tutorial1Medio extends AppCompatActivity {

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



        descrizioni[0] = "Hai imparato ad assegnare un tipo di dato a interi, float, string e bool. Ora sei pronto per applicare queste conoscenze al mondo reale!";
        descrizioni[1] = "Se ti chiedessi 'in che anno sei nato?' tu mi risponderesti con un numero, un numero intero. Quindi se tu dovessi decidere che tipo di dato usare per rappresentare il tuo anno di nascita, tu cliccheresti sul bottone: ";
        descrizioni[2] = "Se invece ti chiedessi   'Quanto costa una penna in cartoleria?' allora tu mi risponderesti (probabilmente) con un numero con il punto, ad esempio 0.99. \n0.99 abbiamo visto che è un dato di tipo float.";
        descrizioni[3]="Se ti chiedessi 'come ti chiami?', tu mi diresti il tuo nome, ma il tuo nome altro non è che un dato di tipo string! Quindi cliccheresti sul bottone:";
        descrizioni[4]="Se poi ti chiedessi 'Puoi vedere cosa c'è davanti a te?' tu mi risponderesti si o no, quindi o true (si, perché true significa vero) o false (no, perché false significa falso).";
        descrizioni[5]="Quindi tu puoi rappresentare qualsiasi cosa della vita reale usando i 4 tipi di dato int, float, string e bool! ";
        descrizioni[6]="Avvio del livello 1.medio";

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
                    startActivity(new Intent(Tutorial1Medio.this, Livello1Medium.class));
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
