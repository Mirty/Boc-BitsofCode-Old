package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by andrea on 21/01/17.
 */
public class Livello1Impossible extends AppCompatActivity{

    Button conferma;
    TextView domanda, last, consegna;
    EditText risposta;
    Esercizio polloFritto=new Esercizio();
    Vibrator vi;
    static boolean daActivity=false;
    int giusti=0, serie=0, moltiplicatore;
    final int puntiARisposta=50, daIndovinare=10;
    static int punteggio=0;
    Typeface buttons_font, consegne_font, programming_font;
    Button help;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.livello1impossible);

        conferma=(Button) findViewById(R.id.conferma);
        domanda=(TextView) findViewById(R.id.domanda);
        consegna=(TextView) findViewById(R.id.textView2);
        risposta=(EditText) findViewById(R.id.risposta);
        last=(TextView) findViewById(R.id.last);
        vi=(Vibrator) getSystemService(VIBRATOR_SERVICE);

        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");
        buttons_font = Typeface.createFromAsset(getAssets(),  "fonts/Acids!.otf");
        programming_font = Typeface.createFromAsset(getAssets(),  "fonts/Courier New.ttf");
        domanda.setTypeface(consegne_font);
        risposta.setTypeface(programming_font);
        conferma.setTypeface(buttons_font);
        consegna.setTypeface(consegne_font);

        help=(Button) findViewById(R.id.helpbutton);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Livello1Impossible.this, Tutorial1Impossibile.class));
            }
        });

        polloFritto.genera();
        domanda.setText(""+polloFritto.domanda);
        last.setVisibility(View.GONE);

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(controlla()){
                    serie++;
                    giusti++;
                    calcolaPunteggio();
                    last.setText(risposta.getText().toString());
                    last.setTextColor(Color.GREEN);
                    polloFritto.genera();
                    domanda.setText(polloFritto.domanda);
                    risposta.setText("");
                    if(giusti>daIndovinare){
                        startActivity(new Intent(Livello1Impossible.this, Vittoria1Impossible.class));
                    }
                }
                else{
                    serie=0;
                    last.setText(risposta.getText().toString());
                    last.setTextColor(Color.RED);
                    vi.vibrate(500);
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


    private void calcolaPunteggio(){
        if(serie>=0 && serie <5){
            moltiplicatore=1;
        }
        else{
            if(serie>=5 && serie <10){
                moltiplicatore=2;
            }
            else{
                if(serie>=10 && serie <15){
                    moltiplicatore=3;
                }
                else{
                    moltiplicatore=4;
                }
            }
        }

        punteggio+=puntiARisposta*moltiplicatore;
    }

    boolean controlla() {
        String tipoDato = "", nomeDato = "", valoreDato = "";
        boolean uguale = false, spazio = false;

        if (!(risposta.getText().toString().contains(";") && risposta.getText().toString().contains("="))) { //controllo se sono presenti almeno un = e un ;
            return false;
        }

        for (int i = 0; i < risposta.getText().toString().length(); i++) {
            if ((!spazio) && (!uguale)) {
                if (risposta.getText().toString().charAt(i) != ' ') {
                    tipoDato = tipoDato + risposta.getText().toString().charAt(i);
                } else {
                    spazio = true;
                }
            } else {
                if ((!uguale) && spazio) {
                    if (risposta.getText().toString().charAt(i) == ' ') {
                        if (risposta.getText().toString().charAt(i + 1) != '=') {
                            return false;
                        }
                    } else {
                        if (risposta.getText().toString().charAt(i) == '=') {
                            uguale = true;
                            if (risposta.getText().toString().charAt(i + 1) == ' ') {
                                i++;
                            }
                        } else {
                            nomeDato = nomeDato + risposta.getText().toString().charAt(i);
                        }
                    }
                } else {
                    if (uguale && spazio) {
                        if(risposta.getText().toString().charAt(i)!=';') {
                            valoreDato = valoreDato + risposta.getText().toString().charAt(i);
                        }
                    }
                }
            }
        }


        switch (polloFritto.tipo) { //controllo se la prima parola corrisponde al tipo di dato esatto
            case 0:
                if (!(tipoDato.equals("int"))) {
                    return false;
                }
                break;
            case 1:
                if (!(tipoDato.equals("float"))) {
                    return false;
                }
                break;
            case 2:
                if (!(tipoDato.equals("string"))) {
                    return false;
                }
                break;
            case 3:
                if (!(tipoDato.equals("bool"))) {
                    return false;
                }
                break;
        }

        if(nomeDato.contains("\"")||nomeDato.contains("'")||Character.isDigit(nomeDato.charAt(0))||nomeDato.matches("[0-9]+")){
            return false;
        }

        if(polloFritto.tipo==0&&!(valoreDato.matches("[0-9]+"))){
            return false;
        }

        if (polloFritto.risposta == null) {
            return true;
        } else {
            if(polloFritto.risposta.toLowerCase().equals(valoreDato.toLowerCase())){
                return true;
            }
            else{
                return false;
            }
        }

    }
}

