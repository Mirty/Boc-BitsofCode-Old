package com.example.andrea.boc_bitsofcode;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by andrea on 13/02/17.
 */
public class MostraPunteggi extends AppCompatActivity{
    TextView[] normale=new TextView[MenuLivelli.nLivelli], medio=new TextView[MenuLivelli.nLivelli], difficile= new TextView[MenuLivelli.nLivelli], impossibile=new TextView[MenuLivelli.nLivelli];
    Button indietro;
    TextView uno,due,tre,quattro, punteggi;
    Typeface consegne_font, custom_font;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punteggi);
        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Acids!.otf");
        indietro = (Button) findViewById(R.id.indietro);
         uno = (TextView) findViewById(R.id.l1);
        due = (TextView) findViewById(R.id.l2);
        tre = (TextView) findViewById(R.id.l3);
        quattro = (TextView) findViewById(R.id.l4);
        punteggi = (TextView) findViewById(R.id.punteggi);

        uno.setTypeface(custom_font);
        due.setTypeface(custom_font);
        tre.setTypeface(custom_font);
        quattro.setTypeface(custom_font);
        punteggi.setTypeface(custom_font);


        for(int i=0; i<MenuLivelli.nLivelli; i++){
            normale[i]=new TextView(this);
            medio[i]= new TextView(this);
            medio[i].setTypeface(consegne_font);
            difficile[i]= new TextView(this);
            difficile[i].setTypeface(consegne_font);
            impossibile[i]= new TextView(this);
            impossibile[i].setTypeface(consegne_font);

        }
        normale[0]=(TextView) findViewById(R.id.normale1);
        normale[0].setTypeface(consegne_font);
        normale[1]=(TextView) findViewById(R.id.normale2);
        normale[1].setTypeface(consegne_font);
        normale[2]=(TextView) findViewById(R.id.normale3);
        normale[2].setTypeface(consegne_font);
        normale[3]=(TextView) findViewById(R.id.normale4);
        normale[3].setTypeface(consegne_font);
        medio[0]=(TextView) findViewById(R.id.medio1);
        medio[0].setTypeface(consegne_font);
        medio[1]=(TextView) findViewById(R.id.medio2);
        medio[1].setTypeface(consegne_font);
        medio[2]=(TextView) findViewById(R.id.medio3);
        medio[2].setTypeface(consegne_font);
        medio[3]=(TextView) findViewById(R.id.medio4);
        medio[3].setTypeface(consegne_font);
        difficile[0]=(TextView) findViewById(R.id.difficile1);
        difficile[0].setTypeface(consegne_font);
        difficile[1]=(TextView) findViewById(R.id.difficile2);
        difficile[1].setTypeface(consegne_font);
        difficile[2]=(TextView) findViewById(R.id.difficile3);
        difficile[2].setTypeface(consegne_font);
        difficile[3]=(TextView) findViewById(R.id.difficile4);
        difficile[3].setTypeface(consegne_font);
        impossibile[0]=(TextView) findViewById(R.id.impossibile1);
        impossibile[0].setTypeface(consegne_font);
        impossibile[1]=(TextView) findViewById(R.id.impossibile2);
        impossibile[1].setTypeface(consegne_font);
        impossibile[2]=(TextView) findViewById(R.id.impossibile3);
        impossibile[2].setTypeface(consegne_font);
        impossibile[3]=(TextView) findViewById(R.id.impossibile4);
        impossibile[3].setTypeface(consegne_font);
        indietro=(Button) findViewById(R.id.indietro);

        for(int i=0; i<MenuLivelli.nLivelli; i++){
            normale[i].setText("Normale: "+MenuLivelli.giocatore.superati[i].normale);
            medio[i].setText("Medio: "+MenuLivelli.giocatore.superati[i].medio);
            difficile[i].setText("Difficile: "+MenuLivelli.giocatore.superati[i].difficile);
            impossibile[i].setText("Impossibile: "+MenuLivelli.giocatore.superati[i].impossibile);
        }
        indietro.setTypeface(consegne_font);
        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
