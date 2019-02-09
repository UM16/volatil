package mx.tecvalles.memorama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class tablero extends AppCompatActivity {

    /*private ImageButton carta1;
    private ImageButton carta2;
    private ImageButton carta3;
    private ImageButton carta4;
    private ImageButton carta5;
    private ImageButton carta6;
    private ImageButton carta7;
    private ImageButton carta8;
    private ImageButton carta9;
    private ImageButton carta10;
    private ImageButton carta11;
    private ImageButton carta12;*/
    private ImageButton cartas[] = new ImageButton[12];
    private memorama juego = new memorama();
    private int[] cartasAbiertas = new int[2];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);

        cartas[0] = (ImageButton) findViewById(R.id.carta1);
        cartas[1] = (ImageButton) findViewById(R.id.carta2);
        cartas[2] = (ImageButton) findViewById(R.id.carta3);
        cartas[3] = (ImageButton) findViewById(R.id.carta4);
        cartas[4] = (ImageButton) findViewById(R.id.carta5);
        cartas[5] = (ImageButton) findViewById(R.id.carta6);
        cartas[6] = (ImageButton) findViewById(R.id.carta7);
        cartas[7] = (ImageButton) findViewById(R.id.carta8);
        cartas[8] = (ImageButton) findViewById(R.id.carta9);
        cartas[9] = (ImageButton) findViewById(R.id.carta10);
        cartas[10] = (ImageButton) findViewById(R.id.carta11);
        cartas[11] = (ImageButton) findViewById(R.id.carta12);

        for (int i = 0; i < 12; i++) {

            cartas[i].setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    onClickCartas(arg0.getId());
                }
            });

        }

        juego.barajear();
    }

    private void onClickCartas(int carta) {
        String recurso = "";
        int resID;
        int cartaValor = 0;

        switch (carta) {
            case R.id.carta1:
                cartaValor = 1;
                break;
            case R.id.carta2:
                cartaValor = 2;
                break;
            case R.id.carta3:
                cartaValor = 3;
                break;
            case R.id.carta4:
                cartaValor = 4;
                break;
            case R.id.carta5:
                cartaValor = 5;
                break;
            case R.id.carta6:
                cartaValor = 6;
                break;
            case R.id.carta7:
                cartaValor = 7;
                break;
            case R.id.carta8:
                cartaValor = 8;
                break;
            case R.id.carta9:
                cartaValor = 9;
                break;
            case R.id.carta10:
                cartaValor = 10;
                break;
            case R.id.carta11:
                cartaValor = 11;
                break;
            case R.id.carta12:
                cartaValor = 12;

        }

        switch (juego.pedirCarta(cartaValor)) {
            case 1: case 7:
                recurso = "catarina";
                break;
            case 2: case 8:
                recurso = "arbol";
                break;
            case 3: case 9:
                recurso = "calavera";
                break;
            case 4: case 10:
                recurso = "colibri";
                break;
            case 5: case 11:
                recurso = "corona";
                break;
            case 6: case 12:
                recurso = "perro";
                break;

        }

        resID = getResources().getIdentifier(recurso, "drawable", getPackageName());
        cartas[cartaValor - 1].getAdjustViewBounds();
        cartas[cartaValor - 1].setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        cartas[cartaValor - 1].setImageResource(resID);


        if (juego.getMovimientos() == 2 && !juego.esPar()) {

            // Falta un delay para que consuma tiempo antes de voltear las dos cartas

            cartasAbiertas = juego.getCartasAbiertas();
            cartas[cartasAbiertas[0]].setImageResource(R.drawable.ic_fondo_carta);
            cartas[cartasAbiertas[1]].setImageResource(R.drawable.ic_fondo_carta);


        } else if (juego.esFIN()) {


            Toast toast1 = Toast.makeText(getApplicationContext(), "Lo lograste!!!", Toast.LENGTH_SHORT);

            toast1.show();

        }

    }


}
