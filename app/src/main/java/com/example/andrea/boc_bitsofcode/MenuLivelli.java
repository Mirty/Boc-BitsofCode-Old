package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class MenuLivelli extends AppCompatActivity{

    Button uno, due, tre, quattro ,punteggi; //i tre (per ora) bottoni e quello che mostrerà i punteggi
    TextView text;
    public static int nLivelli=4; //DA MODIFICARE OGNI VOLTA CHE SI AGGIUNGE O RIMUOVE UN LIVELLO, SERVE PER IL SALVATAGGIO
    public static Utente giocatore;
    File salvataggio;
    Typeface consegne_font;
    public static boolean ninne;


    public static int entra = 0; //ANTIBUG: di default entro al livello 1 (sempre meglio che far piantare l' applicazione)

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulivelli);
        consegne_font = Typeface.createFromAsset(getAssets(), "fonts/DK The Cats Whiskers.otf");

        uno=(Button) findViewById(R.id.uno);
        due=(Button) findViewById(R.id.due);
        tre=(Button) findViewById(R.id.tre);
        text = (TextView) findViewById(R.id.menu);
        quattro = (Button) findViewById(R.id.quattro);
        punteggi=(Button) findViewById(R.id.punteggi);
        salvataggio=(File)getIntent().getSerializableExtra("salvataggio");

        uno.setTypeface(consegne_font);
        due.setTypeface(consegne_font);
        tre.setTypeface(consegne_font);
        text.setTypeface(consegne_font);
        quattro.setTypeface(consegne_font);
        punteggi.setTypeface(consegne_font);


        try{
            giocatore=new Utente(new BufferedReader(new FileReader(salvataggio.getPath())));
        }
        catch(FileNotFoundException e){
            Toast.makeText(MenuLivelli.this, "Impossibile caricare il profilo, il file risulta assente", Toast.LENGTH_LONG).show();
        }

        giocatore.salva(salvataggio);
        ninne=giocatore.nome.equals("ninne");

        if(giocatore.superati[0].impossibile==0&&(!ninne)){
            due.setEnabled(false);
        }
        if(giocatore.superati[1].impossibile==0&&(!ninne)){
            tre.setEnabled(false);
        }

        if(giocatore.superati[2].impossibile==0&&(!ninne)){
            quattro.setEnabled(false);
        }


        uno.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                entra = 0;
                startActivity(new Intent(MenuLivelli.this, Livello1diff.class)); //Faccio scegliere la difficoltà del primo livello
            }
        });


        due.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                entra = 1;
                startActivity(new Intent(MenuLivelli.this,Livello1diff.class));
            }
        });

        tre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entra=2;
                startActivity(new Intent(MenuLivelli.this, Livello1diff.class));
            }
        });
        quattro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entra = 3;
                startActivity(new Intent(MenuLivelli.this, Livello1diff.class));
            }
        });

        punteggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuLivelli.this, MostraPunteggi.class));
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();

        giocatore.salva(salvataggio);

    }

}
