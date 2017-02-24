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

public class Tutorial3Difficile extends AppCompatActivity {

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

        descrizioni[0] = "Nelle difficoltà precedenti hai imparato che la condizione dell'if deve essere di tipo booleano.\nAnche i confronti tra valori sono di tipo booleano. Ad esempio, chiedersi 'il mio nome è uguale a Maurizio?', e questo confronto è di tipo booleano perché è una domanda a cui puoi rispondere vero o falso.";
        descrizioni[1]="Adesso possiamo sfruttare le conoscenze sulle variabili per introdurle nell'if. Immagina di voler confrontare il tuo anno di nascita con quello del tuo amico del cuore, e pensa di memorizzare i vostri anni di nascita in due variabili diverse di tipo intero:\nint mio_anno = 2004;\nint suo_anno = 2003;\nadesso vuoi usare l'if per stampare se l'anno di nascita è lo stesso o no. Ti basta fare un confronto tra le due variabili (mio_anno == suo_anno). Questo confronto restituisce un valore booleano e quindi può essere usato come condizione dell'if!";
        descrizioni[2]="In questo livello ti verrà chiesto di controllare la condizione dell'if, la quale si baserà sulle variabili dichiarate all'inizio del codice.\nDovrai cliccare su uno dei due bottoni, su quello corretto (solo uno dei due è corretto!)";
        descrizioni[3]="Avvio del livello 3.difficile";

        descrizione.setText(descrizioni[0]);

        avanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pagina<3) {
                    pagina++;
                    descrizione.setText(descrizioni[pagina]);
                    indietro.setVisibility(View.VISIBLE);
                }
                else
                    startActivity(new Intent(Tutorial3Difficile.this, Livello3Hard.class));
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
