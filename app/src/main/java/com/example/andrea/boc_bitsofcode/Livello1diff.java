package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Livello1diff extends AppCompatActivity{

    Button facile, medio, difficile, impossibile;
    Typeface consegne_font;
    TextView textV2;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livello1diff);
        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");
        textV2 = (TextView) findViewById(R.id.textV2);
        facile=(Button) findViewById(R.id.normal);
        medio=(Button) findViewById(R.id.medium);
        difficile=(Button) findViewById(R.id.hard);
        textV2 = (TextView) findViewById(R.id.textV2);
        impossibile=(Button) findViewById(R.id.impossible);
        facile.setTypeface(consegne_font);
        medio.setTypeface(consegne_font);
        textV2.setTypeface(consegne_font);
        difficile.setTypeface(consegne_font);
        impossibile.setTypeface(consegne_font);



        facile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                switch(MenuLivelli.entra){
                    case 0:
                        Livello1.daActivity=false;//rendo avviabile il livello uno difficoltà normale
                        Livello1.punteggio=0;//mi assicuro che il conteggio del punteggio parta effettivamente da 0
                        startActivity(new Intent(Livello1diff.this, Tutorial1facile.class));
                        break;
                    case 1:
                        startActivity(new Intent(Livello1diff.this, Livello2.class));
                        break;
                    case 2:
                        Livello3Normale.daActivity=false;
                        Livello3Normale.punteggio=0;
                        startActivity(new Intent(Livello1diff.this, Tutorial3Facile.class));
                        break;
                    case 3:
                        startActivity(new Intent(Livello1diff.this, Livello4Normale.class));
                        break;
                }

                finish(); //chiudo quest' activity ormai inutile
            }

        });

        medio.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                switch(MenuLivelli.entra){
                    case 0:
                        Livello1Medium.daActivity=false;
                        Livello1Medium.punteggio=0;
                        startActivity(new Intent(Livello1diff.this, Tutorial1Medio.class));
                        break;
                    case 1:
                        Livello2medio.daActivity=false;
                        Livello2medio.punteggio=0;
                        startActivity(new Intent(Livello1diff.this, Livello2medio.class));
                        break;
                    case 2:
                        Livello3Medium.daActivity=false;
                        Livello3Medium.punteggio=0;
                        startActivity(new Intent(Livello1diff.this, Tutorial3Medio.class));
                        break;
                    case 3:
                        startActivity(new Intent(Livello1diff.this, Livello4medio.class));
                        break;
                }

                finish();

            }
        });

        difficile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                switch(MenuLivelli.entra){
                    case 0:
                        Livello1Hard.daActivity=false;
                        Livello1Hard.punteggio=0;
                        Livello1Hard.serie=0;
                        Livello1Hard.giusti=0;
                        Livello1HardII.daActivity=false;
                        Livello1HardIII.daActivity=false;
                        startActivity(new Intent(Livello1diff.this, Tutorial1Difficile.class));
                        break;
                    case 1:
                        Livello2diff.daActivity=false;
                        startActivity(new Intent(Livello1diff.this, Livello2diff.class));
                        break;
                    case 2:
                        Livello3Hard.daActivity=false;
                        startActivity(new Intent(Livello1diff.this, Tutorial3Difficile.class));
                        break;
                    case 3:
                        startActivity(new Intent(Livello1diff.this, Livello4Diff.class));
                        break;
                }

                finish();
            }
        });

        impossibile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (MenuLivelli.entra){
                    case 0:
                        Livello1Impossible.daActivity=false;
                        Livello1Impossible.punteggio=0;
                        startActivity(new Intent(Livello1diff.this, Tutorial1Impossibile.class));
                        break;
                    case 1:
                        //TODO: Fede livello 2 impossibile qui
                        break;
                    case 2:
                        Livello3Impossible.daActivity=false;
                        startActivity(new Intent(Livello1diff.this, Tutorial3Impossibile.class));
                        break;
                    case 3:
                        Livello4Impossible.daActivity=false;
                        startActivity(new Intent(Livello1diff.this, Livello4Impossible.class));
                        break;
                }

                finish();
            }
        });


    }

}
