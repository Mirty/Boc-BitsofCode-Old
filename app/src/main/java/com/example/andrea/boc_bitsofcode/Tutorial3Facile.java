package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by mirty on 24/01/17.
 */

public class Tutorial3Facile extends AppCompatActivity {

    Typeface custom_font, programming_font, consegne_font;
    TextView descrizione;
    LinearLayout esempioIf;
    Button avanti, indietro;
    int pagina; // mi serve per verificare a che punto del tutorial ci si trova
    String descrizioni[];
    static boolean daActivity=false;
    TextView condizione, ramoThen, altrimenti, ramoElse, se;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial3facile);

        // inizializzo gli elementi grafici
        descrizione = (TextView) findViewById(R.id.descrizione);
        avanti = (Button) findViewById(R.id.avanti);
        indietro = (Button) findViewById(R.id.indietro);
        esempioIf = (LinearLayout) findViewById(R.id.ifexample);
        //  inizializzo i font
        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");
        programming_font = Typeface.createFromAsset(getAssets(),  "fonts/Courier New.ttf");
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Acids!.otf");
        // inizializzo il resto
        pagina = 0;
        descrizioni = new String [7];
        se = (TextView) findViewById(R.id.se);
        condizione=(TextView) findViewById(R.id.condizione);
        ramoThen=(TextView) findViewById(R.id.then);
        altrimenti=(TextView) findViewById(R.id.altrimenti);
        ramoElse=(TextView) findViewById(R.id.ramoElse);

        // personalizzo gli elementi grafici
        descrizione.setTypeface(consegne_font);
        se.setTypeface(custom_font);
        condizione.setTypeface(consegne_font);
        ramoThen.setTypeface(consegne_font);
        altrimenti.setTypeface(custom_font);
        ramoElse.setTypeface(consegne_font);
        indietro.setVisibility(View.GONE);

        descrizioni[0] = "Ora che hai imparato a usare le fuzioni, possiamo usarle per applicarle a dei problemi di decisione.\nImmagina di avere una funzione gioca e una funzione fai_i_compiti e di voler scrivere un programma in cui se hai finito i compiti allora giochi, altrimenti fai i compiti.\nQuesto è certamente possibile utilizzando il costrutto che si chiama if. ";
        descrizioni[1] = "If in inglese vuol dire se. L'if si usa, quindi, per decidere cosa fare nel caso in cui una condizione sia vera o falsa (true o false).\nLa condizione dell'if deve essere quindi di tipo bool.\nSe la condizione dell'if è vera si esegue l'istruzione dentro le prime parentesi {} altrimenti, se la condizione dell'if è falsa, si esegue l'istruzione dentro le seconde {}.\nFacciamo un esempio!";
        descrizioni[2] = "";
        descrizioni[3] = "Avvio del livello 3.facile";

        descrizione.setText(descrizioni[0]);
        esempioIf.setVisibility(View.GONE);

        avanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pagina<3) {
                    pagina++;
                    descrizione.setText(descrizioni[pagina]);
                    if (pagina==2)
                        esempioIf.setVisibility(View.VISIBLE);
                    else
                        esempioIf.setVisibility(View.GONE);
                    indietro.setVisibility(View.VISIBLE);
                }
                else
                    startActivity(new Intent(Tutorial3Facile.this, Livello3Normale.class));
            }
        });

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pagina>0) {
                    pagina--;
                    descrizione.setText(descrizioni[pagina]);
                    if (pagina == 0) indietro.setVisibility(View.GONE);
                    if (pagina==2)
                        esempioIf.setVisibility(View.VISIBLE);
                    else
                        esempioIf.setVisibility(View.GONE);
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
