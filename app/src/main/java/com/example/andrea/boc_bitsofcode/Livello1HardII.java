package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
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
 * Created by andrea on 18/01/17.
 */
public class Livello1HardII extends AppCompatActivity {
    TextView domanda, consegna, hint;
    EditText nomeVariabile;
    Button conferma;
    static boolean daActivity = false;
    Typeface custom_font, programming_font, consegne_font;
    Vibrator vi;
    Button help;

    @Override
    protected void onCreate(Bundle savedinstanceState) {
        super.onCreate(savedinstanceState);
        setContentView(R.layout.livello1hardsceglinomevariabile);

        domanda = (TextView) findViewById(R.id.domanda);
        nomeVariabile = (EditText) findViewById(R.id.nome);
        conferma = (Button) findViewById(R.id.conferma);
        consegna = (TextView) findViewById(R.id.consegna);
        hint = (TextView) findViewById(R.id.hint) ;
        vi=(Vibrator) getSystemService(VIBRATOR_SERVICE);

        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");
        programming_font = Typeface.createFromAsset(getAssets(),  "fonts/Courier New.ttf");
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Acids!.otf");
        domanda.setTypeface(consegne_font);
        consegna.setTypeface(consegne_font);
        hint.setTypeface(consegne_font);
        conferma.setTypeface(custom_font);
        nomeVariabile.setTypeface(programming_font);

        consegna.setText("Scegli il NOME \ndella variabile");
        domanda.setText("" + Livello1Hard.polloFritto.domanda);
        hint.setText("Consiglio: usa un nome significativo");
        nomeVariabile.setText("");

        help=(Button) findViewById(R.id.helpbutton);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Livello1HardII.this, Tutorial1Difficile.class));
            }
        });

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nomeVariabile.getText().toString().equals("")) { //Per Marta: devi sostituire da qui
                    vi.vibrate(250);
                    Toast.makeText(Livello1HardII.this, "Dai un nome alla tua variabile. consiglio: usa dei nomi significativi per le tue variabili", Toast.LENGTH_LONG).show();
                } else {

                    if(nomeVariabile.getText().toString().contains(" ")){
                        Toast.makeText(Livello1HardII.this, "I nomi delle variabili non possono contenere spazi, puoi sostituirlo con il carattere \"_\"", Toast.LENGTH_LONG).show();
                        Livello1Hard.serie=0;
                        vi.vibrate(500);
                    }
                    else{
                        if(nomeVariabile.getText().toString().contains("\"")){
                            Toast.makeText(Livello1HardII.this, "I nomi delle variabili non possono contenere \"", Toast.LENGTH_LONG).show();
                            Livello1Hard.serie=0;
                            vi.vibrate(500);
                        }
                        else{
                            if(nomeVariabile.getText().toString().contains("'")){
                                Toast.makeText(Livello1HardII.this, "I nomi delle variabili non possono contenere '", Toast.LENGTH_LONG).show();
                                Livello1Hard.serie=0;
                                vi.vibrate(500);
                            }
                            else{
                                if(Character.isDigit(nomeVariabile.getText().charAt(0))){
                                    Toast.makeText(Livello1HardII.this, "I nomi delle variabili non possono iniziare con un numero", Toast.LENGTH_LONG).show();
                                    Livello1Hard.serie=0;
                                    vi.vibrate(500);
                                }
                                else{
                                    if (nomeVariabile.getText().toString().matches("[0-9]+")) {
                                        Toast.makeText(Livello1HardII.this, "I nomi delle variabili non possono essere solo numeri", Toast.LENGTH_LONG).show();
                                        Livello1Hard.serie=0;
                                        vi.vibrate(500);
                                    }
                                    else{
                                        if (containsOtherChar(nomeVariabile.getText().toString())) {
                                            Toast.makeText(Livello1HardII.this, "I nomi delle variabili possono contenere solo lettere, numeri e underscore", Toast.LENGTH_LONG).show();
                                            Livello1Hard.serie=0;
                                            vi.vibrate(500);
                                        }
                                        else {
                                            Livello1Hard.nomeVariabile = nomeVariabile.getText().toString();
                                            Livello1HardIII.daActivity=false;
                                            startActivity(new Intent(Livello1HardII.this, Livello1HardIII.class));
                                            finish();
                                        }

                                    }
                                }
                            }
                        }
                    }
                }//fino a qui
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
    
    public boolean containsOtherChar (String string) {
        for (char c: string.toCharArray()) {
            if ((int) c < 48 || ((int) c > 57 && (int) c < 65) || ((int) c > 90 && (int) c < 95) || (int) c > 122 || ((int) c > 95 && (int) c < 97))  {
                return true;
            }
        }
        return false;
    }
}