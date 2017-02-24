package com.example.andrea.boc_bitsofcode;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.punteggi);

        for(int i=0; i<MenuLivelli.nLivelli; i++){
            normale[i]=new TextView(this);
            medio[i]= new TextView(this);
            difficile[i]= new TextView(this);
            impossibile[i]= new TextView(this);
        }
        normale[0]=(TextView) findViewById(R.id.normale1);
        normale[1]=(TextView) findViewById(R.id.normale2);
        normale[2]=(TextView) findViewById(R.id.normale3);
        normale[3]=(TextView) findViewById(R.id.normale4);
        medio[0]=(TextView) findViewById(R.id.medio1);
        medio[1]=(TextView) findViewById(R.id.medio2);
        medio[2]=(TextView) findViewById(R.id.medio3);
        medio[3]=(TextView) findViewById(R.id.medio4);
        difficile[0]=(TextView) findViewById(R.id.difficile1);
        difficile[1]=(TextView) findViewById(R.id.difficile2);
        difficile[2]=(TextView) findViewById(R.id.difficile3);
        difficile[3]=(TextView) findViewById(R.id.difficile4);
        impossibile[0]=(TextView) findViewById(R.id.impossibile1);
        impossibile[1]=(TextView) findViewById(R.id.impossibile2);
        impossibile[2]=(TextView) findViewById(R.id.impossibile3);
        impossibile[3]=(TextView) findViewById(R.id.impossibile4);
        indietro=(Button) findViewById(R.id.indietro);

        for(int i=0; i<MenuLivelli.nLivelli; i++){
            normale[i].setText("Normale: "+MenuLivelli.giocatore.superati[i].normale);
            medio[i].setText("Medio: "+MenuLivelli.giocatore.superati[i].medio);
            difficile[i].setText("Difficile: "+MenuLivelli.giocatore.superati[i].difficile);
            impossibile[i].setText("Impossibile: "+MenuLivelli.giocatore.superati[i].impossibile);
        }

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}
