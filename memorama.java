
package mx.tecvalles.memorama;
import java.util.Random;
/**
 * Created by USER on 17/03/2018.
 */

class memorama {


    private int[ ] mazo = new int[12];
    private int[ ] mazoBarajeado = new int[12];
    private int  paresEncontrados;
    private int paresTotales = 6;
    private int [] cartaAbiertas = new int[2];
    private int [] tablero = new int[2];
    private int NoMovimeintos=0;
    private Random r = new Random();
    private static final int MAXCARTAS = 12;

    public void barajear() {


        int i = 0, j = 0, k = 0;
        for ( i = 1; i <= 12; i++) {
            mazo[i-1] = i;
        }
        //while ((mazo[i++] = i) < MAXCARTAS);
        i = MAXCARTAS - 1;
        while (i >= 0) {
            j = r.nextInt(i + 1);
            k = mazo[i];
            mazo[i] = mazo[j];
            mazo[j] = k;
            mazoBarajeado[i] = mazo[i--];

        }
    }

    public int pedirCarta(int carta)
    {

        if(NoMovimeintos > 0 ) {
            cartaAbiertas[1] = mazoBarajeado[carta - 1];
            tablero[1] = carta - 1;
        }
        else {
            cartaAbiertas[0] = mazoBarajeado[carta - 1];
            tablero[0] = carta - 1;
        }

        NoMovimeintos++;

        return mazoBarajeado[carta-1];


    }

    public boolean esPar()
    {
        int cartaUp1 = cartaAbiertas[0];
        int cartaUp2 = cartaAbiertas[1];

        if(NoMovimeintos>1) {
            NoMovimeintos = 0;
            if (cartaUp1 > 6) cartaUp1-=6;
            if (cartaUp2 > 6) cartaUp2-=6;

            if (cartaUp1 == cartaUp2)
            {
                cartaAbiertas[0]=0;
                cartaAbiertas[1]=0;
                tablero[0]=0;
                tablero[1]=0;
                paresEncontrados++;
                return true;

            }

        }

        return false;
    }

    public int getMovimientos()
    {
        return NoMovimeintos;


    }

    public int[] getCartasAbiertas(){

        return tablero;
    }


    public boolean esFIN(){

        if (paresEncontrados == paresTotales)
        {
            return true;
        }
        else
        {
            return false;
        }


    }




}
