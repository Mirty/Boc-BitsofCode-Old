package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by andrea on 18/01/17.
 */
public class Livello1HardRiepilogo extends AppCompatActivity{

    TextView riepilogo;
    Button avanti;
    String tipo;
    Typeface custom_font, consegne_font;

    @Override
    protected void onCreate(Bundle savedinstanceState){
        super.onCreate(savedinstanceState);
        setContentView(R.layout.livello1hardriepilogo);

        riepilogo=(TextView)findViewById(R.id.spiegazione);
        avanti=(Button)findViewById(R.id.avanti);
        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Acids!.otf");

        riepilogo.setTypeface(consegne_font);
        avanti.setTypeface(custom_font);

        switch(Livello1Hard.polloFritto.tipo){
            case 0:
                tipo="int ";
                break;
            case 1:
                tipo="float ";
                break;
            case 2:
                tipo="string ";
                break;
            case 3:
                tipo="bool ";
                break;
        }

        riepilogo.setText(tipo+Livello1Hard.nomeVariabile+"= "+Livello1Hard.rispostaData+";\n\n"+tipo +" indica al computer che tipo di dato vuoi memorizzare \n"+Livello1Hard.nomeVariabile+" è il nome che hai dato alla tua variabile\n"+Livello1Hard.rispostaData+" è il valore che hai dato alla tua variabile\n il ; alla fine indica che il comando è finito, e non va mai dimenticato");

        Livello1Hard.giusti++;

        if(Livello1Hard.giusti<(Livello1Hard.daIndovinare-1)){
            avanti.setText("avanti");
        }
        else{
            avanti.setText("fine");
        }

        avanti.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(Livello1Hard.giusti>=Livello1Hard.daIndovinare){
                    startActivity(new Intent(Livello1HardRiepilogo.this,Vittoria1Hard.class));
                }
                Livello1HardIII.daActivity=true;
                finish();
            }
        });

    }


}
