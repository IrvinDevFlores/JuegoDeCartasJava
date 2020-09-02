import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class CambiadorDeCartas
{
    Lista barajaDeCartas;
    public Carta carta;

    public int IndiceBaraja;
    public int IndiceCarta;


    public CambiadorDeCartas(Lista barajaDeCartas)
    {
        this.barajaDeCartas = barajaDeCartas;
        IndiceBaraja = 0;
        IndiceCarta = 0;
        GenerarCartaAleatorio();


    }

    public void Dibujar(Graphics g)
    {
        this.carta.DibujarEnPantalla(g,50,350 );
    }


    public void GenerarCartaAleatorio()
    {



    }

    public int GenerarAleatorio( int hasta)
    {
        return (int)(Math.floor(Math.random()*hasta));

    }

    public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() ==  KeyEvent.VK_1)
        {
            for(int i = 0; i < barajaDeCartas.Length; i++)
            {
                Carta carta = (Carta) barajaDeCartas.ObtenerNodoPorIndice(i).Info;

                if(carta.Numero == 1)
                {

                }
            }
        }
    }
}
