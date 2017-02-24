package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Start extends AppCompatActivity {

    private ImageView immagine;
    TextView text;
    Typeface consegne_font;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        consegne_font= Typeface.createFromAsset(getAssets(), "fonts/DK The Cats Whiskers.otf");
        immagine = (ImageView) findViewById(R.id.immagine);
        text=(TextView) findViewById(R.id.loading);
        text.setTypeface(consegne_font);
        MyTimer mytimer = new MyTimer(5000,1000);
        immagine.setImageResource(R.mipmap.logo3);
        mytimer.start();


    }

    public class MyTimer extends CountDownTimer {

        public MyTimer(long startTime, long interval) {

            super(startTime, interval);
        }

        public void onFinish() {
            startActivity(new Intent(Start.this, NewContinue.class));
            finish();
        }


        @Override

        public void onTick(long millisUntilFinished) {
            text.setText(text.getText().toString() +".");
            if(millisUntilFinished/1000 == 4){
                immagine.setImageResource(R.mipmap.logo3);
            }else{
                if(millisUntilFinished/1000 == 3){
                    immagine.setImageResource(R.mipmap.logo2);
                }else{
                    if(millisUntilFinished/1000 < 3)
                        immagine.setImageResource(R.mipmap.logo);
                }
            }
        }

    }
}

