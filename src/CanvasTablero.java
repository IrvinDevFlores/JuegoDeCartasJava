import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.Timer.*;

public class CanvasTablero extends JPanel implements ActionListener, KeyListener {

    public int width = 900;
    public int height = 600;
    Carta[] tableroDeCartas;

    Lista barajaDeCartas;
    CambiadorDeCartas cambiadorDeCartas;

    public CanvasTablero()
    {

        setVisible(true);
        setSize(width,height);
        setBackground(Color.ORANGE);
        setLayout(null);
        setFocusable(true);


        l1 = new Lista();
        l2 = new Lista();
        l3 = new Lista();
        l4 = new Lista();
        barajaDeCartas = new Lista();
        String ruta = "";

        for(int i  = 0; i < 52; i++)
        {
            if(i >= 0 && i < 13)
            {
                    String carpetas = "src/Img/";
                    int number = i + 1;
                    String word = number+"cor."+"png";

                    ruta = carpetas + word;
                    Carta carta = new Carta(ruta,50,0);
                    carta.Numero = number;
                    carta.Tipo = 'C';
                    barajaDeCartas.InsertarFinal(new Nodo(carta));

            }

            if(i >= 13 && i < 26)
            {
                    String carpetas = "src/Img/";
                    int number = i + 1-(13);
                    String word = number+"corN."+"png";

                    ruta = carpetas + word;
                    Carta carta = new Carta(ruta,170,0);
                    carta.Numero = number;
                    carta.Tipo = 'N';
                    barajaDeCartas.InsertarFinal(new Nodo(carta));
            }

            if(i >= 26 && i < 39)
            {

                    String carpetas = "src/Img/";
                    int number = i + 1 -(26);
                    String word = number+"dia."+"png";

                    ruta = carpetas + word;
                    Carta carta = new Carta(ruta,50,0);
                    carta.Numero = number;
                    carta.Tipo = 'D';
                    barajaDeCartas.InsertarFinal(new Nodo(carta));

            }

            if(i >= 39 && i < 52)
            {
                    String carpetas = "src/Img/";
                    int number = i + 1 - ( 39);
                    String word = number+"tre."+"png";

                    ruta = carpetas + word;
                    Carta carta = new Carta(ruta,50,0);
                    carta.Numero = number;
                    carta.Tipo = 'T';
                    barajaDeCartas.InsertarFinal(new Nodo(carta));
            }

        }

        cambiadorDeCartas = new CambiadorDeCartas(barajaDeCartas);

        indexActual = GenerarAleatorio(barajaDeCartas.Length );

        JPanel directionButtons = new JPanel();
        back = new JButton("<-");
        back.addActionListener(event ->{
            GenerarCartaAleatorio();
        });

        directionButtons.add(back);
        next = new JButton("->");
        next.addActionListener(event ->{
            GenerarCartaAleatorio();
        });
        directionButtons.add(next);


        JPanel numberButtons = new JPanel(new GridLayout(3,0));
        JLabel one = new JLabel("Tecla 1");
        numberButtons.add(one);
        JButton two = new JButton("2");
        numberButtons.add(two);
        JButton thre = new JButton("3");
        numberButtons.add(thre);
        JButton four = new JButton("4");
        numberButtons.add(four);



        directionButtons.setBackground(Color.ORANGE);
        directionButtons.setBounds(50,500,100,50);

        numberButtons.setBackground(Color.ORANGE);
        numberButtons.setBounds(150,350,100,200);

        add(directionButtons);
        add(numberButtons);
        tx = new Timer(120,this);
        tx.addActionListener(this);
        tx.start();
        addKeyListener(this);

    }

    public int GenerarAleatorio(int hasta)
    {
        return (int)(Math.random()*hasta);
    }

    int indexActual = 0;
    public void GenerarCartaAleatorio()
    {
         index = GenerarAleatorio(barajaDeCartas.Length );
         indexActual = index;

    }


    Timer tx;
    JButton back, next;

    Lista l1, l2, l3, l4;

    Carta ultimoDato;
    int index ;

    public void paint(Graphics g)
    {
        super.paint(g);
        Carta corazones = null;
        if(l1.ultimo != null)
        {
            corazones = ultimoDato;
            corazones.DibujarEnPantalla(g,0,0);
        }



        Carta carta = (Carta) barajaDeCartas
                .ObtenerNodoPorIndice(indexActual).Info;
        carta.DibujarEnPantalla(g,50,350);



        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {


        int key = e.getKeyChar();


        if(key ==  49)//49-50-51-52
        {
            Carta carta = (Carta) barajaDeCartas
                    .ObtenerNodoPorIndice(indexActual).Info;

            l1.InsertarNodoAsc(new Nodo(carta));

        }

        if(key ==  KeyEvent.VK_2)//49-50-51-52
        {
            Carta carta = (Carta) barajaDeCartas.ObtenerNodoPorIndice(index).Info;
            String c = String.valueOf(carta.Tipo);
            if(carta.Numero <= 13)
            {
                l2.InsertarNodoAsc(new Nodo(carta));
            }
        }


        if(key ==  KeyEvent.VK_3)//49-50-51-52
        {
            Carta carta = (Carta) barajaDeCartas.ObtenerNodoPorIndice(index).Info;
            String c = String.valueOf(carta.Tipo);
            if(carta.Numero <= 13)
            {
                l3.InsertarNodoAsc(new Nodo(carta));
            }
        }

        if(key ==  KeyEvent.VK_4)//49-50-51-52
        {
            Carta carta = (Carta) barajaDeCartas.ObtenerNodoPorIndice(index).Info;
            String c = String.valueOf(carta.Tipo);
            if(carta.Numero < 13)
            {
                l4.InsertarNodoAsc(new Nodo(carta));
            }
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
