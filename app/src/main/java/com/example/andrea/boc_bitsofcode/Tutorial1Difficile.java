package com.example.andrea.boc_bitsofcode;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mirty on 24/01/17.
 */

public class Tutorial1Difficile extends AppCompatActivity {

    Typeface custom_font, programming_font, consegne_font;
    TextView descrizione;
    Button avanti, indietro, tipo;
    int pagina; // mi serve per verificare a che punto del tutorial ci si trova
    String descrizioni[];
    Button bottoni[];
    static boolean daActivity=false;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial1facile);

        // inizializzo gli elementi grafici
        descrizione = (TextView) findViewById(R.id.descrizione);
        avanti = (Button) findViewById(R.id.avanti);
        indietro = (Button) findViewById(R.id.indietro);
        tipo = (Button) findViewById(R.id.tipo);
        //  inizializzo i font
        consegne_font = Typeface.createFromAsset(getAssets(),  "fonts/DK The Cats Whiskers.otf");
        programming_font = Typeface.createFromAsset(getAssets(),  "fonts/Courier New.ttf");
        custom_font = Typeface.createFromAsset(getAssets(),  "fonts/Acids!.otf");
        // inizializzo il resto
        pagina = 0;
        descrizioni = new String [8];
        bottoni = new Button[4];

        // personalizzo gli elementi grafici
        descrizione.setTypeface(consegne_font);
        tipo.setTypeface(custom_font);
        tipo.setVisibility(View.GONE);
        indietro.setVisibility(View.GONE);
        for (int i=0; i<4; i++) {
            if (i == 0) bottoni[i] = (Button) findViewById(R.id.intbutton);
            if (i == 1) bottoni[i] = (Button) findViewById(R.id.floatbutton);
            if (i == 2) bottoni[i] = (Button) findViewById(R.id.stringbutton);
            if (i == 3) bottoni[i] = (Button) findViewById(R.id.boolbutton);
            bottoni[i].setTypeface(custom_font);
            bottoni[i].setVisibility(View.GONE);
        }



        descrizioni[0] = "A questo punto sei pronto per imparare a dichiarare le variabili! Ma cosa sono queste variabili? Sono come dei cassettini dentro i quali tu metti qualcosa.\nSupponi di avere un armadio per ogni tipo di dato visto: avrai un armadio per gli int, un armadio per i float, uno per string e un altro ancora per i bool. \nAll'interno di ogni armadio hai tanti cassetti.";
        descrizioni[1] = "Dentro l'armadio int hai tanti cassetti in cui metti solo numeri interi, e ogni cassetto ha un nome. Ad esempio c'è il cassetto anno_di_nascita in cui ci sarà memorizzato il tuo anno di nascita, oppure c'è il cassetto zampe_del_tuo_animale, al cui interno c'è memorizzato il numero di zampe del tuo animale (se ne hai uno), e così via...";
        descrizioni[2] = "Dentro l'armadio float hai tanti cassetti in cui metti solo numeri con il punto, e ogni cassetto ha un nome. Ad esempio ci sarà il cassetto prezzo_del_pane dentro al quale è memorizzato il prezzo del tuo pane preferito!";
        descrizioni[3]="Dentro l'armadio string hai tanti cassetti in cui metti solo stringhe, ovvero qualsiasi cosa che inizia e finisce con le virgolette, e ogni cassetto ha un nome. Ad esempio avrai il cassetto mio_nome, in cui è memorizzato il tuo nome, e così via...";
        descrizioni[4]="Dentro l'armadio bool hai tanti cassetti in cui metti solo valori bool, ovvero qualsiasi cosa che può essere o vera o falsa, e ogni cassetto ha un nome. Ad esempio avrai il cassetto sono_simpatico che sicuramente conterrà il valore true, oppure avrai il cassetto il_sole_splende al cui interno ci sarà true o false a seconda del meteo di oggi.";
        descrizioni[5]="Ma come fai a inserire valori all'interno di questi cassetti?\nPrima di tutto c'è da decidere che tipo di armadio usare (quello degli int, float, string o bool). Poi devi decidere il nome del tuo cassetto (o variabile) ad esempio mio_nome (se devi memorizzare il tuo nome) oppure numero_zampe (se devi memorizzare il numero di zampe di un animale). Ricordati che il nome del cassetto non può contenere spazi, quindi se devi memorizzare il tuo nome potrai chiamare la tua variabile 'mio_nome' oppure 'mionome' ma non potrai chiamarla 'mio nome'! Alla fine potrai inserire il valore da assegnare alla tua variabile (ovvero ciò che vuoi mettere dentro il tuo cassetto) e questo valore potrà essere, a seconda del tipo del dato che hai dichiarato, int float, string o bool. Facciamo degli esempi...";
        descrizioni[6]="Consegna: memorizza in una variabile il numero di persone della tua famiglia. \nPer prima cosa devi scegliere il tipo di dato. Chiediti 'quante persone ci sono nella mia famiglia?'. 2? 3? 4? 5?... Che tipo di dato ti serve per memorizzare questi numeri? Sicuramente un int, quindi cliccherai sul bottone INT. \nPoi dovrai scegliere che nome dare alla tua variabile, è consigliato scegliere un nome significativo, ad esempio 'num_persone'. Ricorda di non usare spazi nel nome della variabile. \nAlla fine devi scegliere il valore da assegnare alla variabile, ad esempio 4 (se in famiglia siete 4). \nFacciamo un altro esempio...";
        descrizioni[7]="Consegna: memorizza in una variabile se il Sole splende. \nPer prima cosa devi scegliere il tipo di dato. Chiediti 'è vero che il Sole splende?'. Vero o falso? Che tipo di dato ti serve per memorizzare vero o falso? Sicuramente un bool, quindi cliccherai sul bottone BOOL. \\nPoi dovrai scegliere che nome dare alla tua variabile, è consigliato scegliere un nome significativo, ad esempio 'il_Sole_splende'. Ricorda di non usare spazi nel nome della variabile. \nAlla fine devi scegliere il valore da assegnare alla variabile, ad esempio true (se il Sole splende). \nOra inizia il livello...";

        descrizione.setText(descrizioni[0]);

        avanti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pagina<7) {
                    if (pagina>0 && pagina <5) bottoni[pagina-1].setVisibility(View.GONE);
                    pagina++;
                    descrizione.setText(descrizioni[pagina]);
                    indietro.setVisibility(View.VISIBLE);
                    if (pagina>0 && pagina <5) bottoni[pagina-1].setVisibility(View.VISIBLE);
                }
                else
                    startActivity(new Intent(Tutorial1Difficile.this, Livello1Hard.class));
            }
        });

        indietro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pagina>0) {
                    if (pagina>0 && pagina <5) bottoni[pagina-1].setVisibility(View.GONE);
                    pagina--;
                    descrizione.setText(descrizioni[pagina]);
                    if (pagina == 0) indietro.setVisibility(View.GONE);
                    if (pagina>0 && pagina <5) bottoni[pagina-1].setVisibility(View.VISIBLE);
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
}
