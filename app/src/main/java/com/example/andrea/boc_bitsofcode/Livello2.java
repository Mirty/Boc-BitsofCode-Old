package com.example.andrea.boc_bitsofcode;

//TODO: NON È UN VERO E PROPRIO LIVELLO, È PIÙ UN TUTORIAL. PUÒ ESSERE UN EXTRA (PER ESEMPIO PARLA COL ROBOT)
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Dialog;
import android.text.Editable;
import android.widget.ImageView;
import android.widget.TextView;

public class Livello2 extends AppCompatActivity {

    Button parla, conferma;
    EditText testoParla;
    TextView testofun;
    String testoIn;
    ImageView parlarobot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livello2);

        parla = (Button) findViewById(R.id.parla);
        String testoOut;


        parla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(Livello2.this);

                // Carico il layout della dialog al suo intenro
                dialog.setContentView(R.layout.dialog);

                conferma = (Button) dialog.findViewById(R.id.conferma);
                testoParla = (EditText) dialog.findViewById(R.id.testoParla);
                parlarobot = (ImageView) dialog.findViewById(R.id.parlarobot);

                conferma.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        testoIn = testoParla.getText().toString();
                        dialog.dismiss();
                        testofun = (TextView) findViewById(R.id.testoFun);
                        testofun.setMovementMethod(new ScrollingMovementMethod()); //permette di scrollare il testo
                        testofun.setText("void" + " parla \n(String discorso) {\n\n" +
                                "Stampa(\"" + testoIn + "\"); \n\n }");
                        parla.setVisibility(View.GONE); //fa scomparire il bottone dopo averlo premuto
                    }
                });
                dialog.show();


            }
        });
    }
}
