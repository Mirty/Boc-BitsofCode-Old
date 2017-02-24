package com.example.andrea.boc_bitsofcode;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

/**
 * Created by andrea on 15/01/17.
 */
public class CreaProfilo extends AppCompatActivity {

    EditText testo;
    Button pulsante;
    Utente giocatore;
    File salvataggio;
    TextView crea;
    Typeface custom_font, consegne_font; // per usare il font esterno

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crea_profilo);

        crea = (TextView)  findViewById(R.id.crea);
        testo= (EditText) findViewById(R.id.testo);
        pulsante= (Button) findViewById(R.id.pulsante);
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Acids!.otf");
        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");

        pulsante.setTypeface(custom_font);
        crea.setTypeface(consegne_font);
        testo.setTypeface(consegne_font);


        salvataggio=(File) getIntent().getSerializableExtra("salvataggio");


        pulsante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(testo.getText().toString().equals("")){
                    Toast.makeText(CreaProfilo.this, "Inserisci il tuo nome", Toast.LENGTH_LONG).show();
                }
                else{
                   giocatore=new Utente(testo.getText().toString());
                    giocatore.salva(salvataggio);
                    startActivity(new Intent(CreaProfilo.this, MenuLivelli.class).putExtra("salvataggio", salvataggio));
                    finish();
                }
            }
        });





    }
}
