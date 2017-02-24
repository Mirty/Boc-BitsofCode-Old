package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by andrea on 18/01/17.
 */
public class Livello1HardIII extends AppCompatActivity {

    TextView domanda, consegna, hint;
    EditText valoreVariabile;
    Button conferma;
    static boolean daActivity = false;
    Vibrator vi;
    Typeface custom_font; // per usare il font esterno
    Typeface programming_font, consegne_font;
    Button help;

    @Override
    protected void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);
        setContentView(R.layout.livello1hardsceglinomevariabile);

        domanda = (TextView) findViewById(R.id.domanda);
        valoreVariabile = (EditText) findViewById(R.id.nome);
        conferma = (Button) findViewById(R.id.conferma);
        consegna = (TextView) findViewById(R.id.consegna);
        hint = (TextView) findViewById(R.id.hint) ;
        vi=(Vibrator) getSystemService(VIBRATOR_SERVICE);

        consegna.setText("Assegna il valore alla tua variabile");
        domanda.setText("" + Livello1Hard.polloFritto.domanda);
        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");
        programming_font = Typeface.createFromAsset(getAssets(),  "fonts/Courier New.ttf");
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Acids!.otf");
        domanda.setTypeface(consegne_font);
        consegna.setTypeface(consegne_font);
        conferma.setTypeface(custom_font);
        valoreVariabile.setTypeface(programming_font);
        hint.setVisibility(View.INVISIBLE);

        help=(Button) findViewById(R.id.helpbutton);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Livello1HardIII.this, Tutorial1Difficile.class));
            }
        });

        valoreVariabile.setText("");

        if (Livello1Hard.polloFritto.tipo == 0 || Livello1Hard.polloFritto.tipo == 1) {
            valoreVariabile.setRawInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        }
        Livello1HardII.daActivity=true;

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (valoreVariabile.getText().toString().equals("")) {
                    Toast.makeText(Livello1HardIII.this, "Assegna un valore alla tua variabile", Toast.LENGTH_LONG);
                    vi.vibrate(250);
                } else {
                    if (Livello1Hard.polloFritto.risposta == null || Livello1Hard.polloFritto.risposta.equals(valoreVariabile.getText().toString())) {
                        Livello1Hard.rispostaData = valoreVariabile.getText().toString();
                        Livello1Hard.serie++;
                        Livello1Hard.calcolaPunteggio();
                        Livello1Hard.calcolaPunteggio();
                        startActivity(new Intent(Livello1HardIII.this, Livello1HardRiepilogo.class));
                    } else {
                        Livello1Hard.serie = 0;
                        vi.vibrate(500);
                    }
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (daActivity) {//Se ho cambiato activity chiudo il livello1
            finish();
        }


    }
}