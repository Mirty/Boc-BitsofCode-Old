package com.example.andrea.boc_bitsofcode;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Vittoria2media extends AppCompatActivity{

    TextView text;
    Button avanti;
    Vibrator vi; //un dildo
    Typeface font;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vittoria);

        vi=(Vibrator) getSystemService(VIBRATOR_SERVICE); //inizializzo la vibrazione

        vi.vibrate(new long[]{0, 500, 110, 500, 110, 450, 110, 200, 110, 170, 40, 450, 110, 200, 110, 170, 40, 500}, -1); //TA TA TA TATATA TATATAAAA

        text= (TextView) findViewById(R.id.text); //Inizializzo la textbox di vittoria (da sistemare in front end)
        avanti=(Button) findViewById(R.id.avanti);
        font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");
        text.setTypeface(font);
        avanti.setTypeface(font);

        text.setText("Il tuo punteggio è: "+Livello2medio.punteggio); //Stampo il messaggio di vittoria TODO: frontend è roba vostra <3
        Livello2medio.daActivity=true;

        if(MenuLivelli.giocatore.superati[1].medio<Livello2medio.punteggio){
            MenuLivelli.giocatore.superati[1].medio=Livello2medio.punteggio;
        }

        avanti.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finish(); //chiudo quest' activity ormai inutile
            }
        });

    }
}