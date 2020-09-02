import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TableroJuego extends JPanel implements  KeyListener , ActionListener {

    Baraja baraja;
    Lista barajaDeCartas;
    Lista l1,l2,l3,l4;
    Carta[] cartas;
    int index;
    int lim = 52;

    public TableroJuego()
    {
        setVisible(true);
        setFocusable(true);
        setSize(800,500);
        setLayout(null);
        setBackground(Color.lightGray);

        baraja = new Baraja();
        barajaDeCartas = baraja.barajaCartas;

        l1 = new Lista();
        l2 = new Lista();
        l3 = new Lista();
        l4 = new Lista();

        GenerarCartaAleatoria();
        addKeyListener(this);

        JLabel titulo = new JLabel("Use las teclas para ordenar");
        titulo.setBounds(150,300,250,20);

        JLabel t1 = new JLabel("(1) Corazones");
        t1.setBounds(150,320,100,20); add(t1);

        JLabel t2 = new JLabel("(2) Corazones negros");
        t2.setBounds(150,340,200,20); add(t2);

        JLabel t3 = new JLabel("(3) Diamantes");
        t3.setBounds(150,360,100,20); add(t3);

        JLabel t4 = new JLabel("(4) Treboles");
        t4.setBounds(150,380,100,20); add(t4);

        JLabel tituloCambiar = new JLabel("Cambiar carta");
        tituloCambiar.setBackground(Color.red);
        tituloCambiar.setBounds(150,400,100,20); add(tituloCambiar);

        JLabel direc = new JLabel("Tecla direccion(<-) (->)Tecla direccion");
        direc.setBounds(150,420,250,20); add(direc);

        add(titulo);

        cartas = new Carta[4];
        int con = 100;
        for(int i = 0; i < cartas.length; i++)
        {
            cartas[i] = new Carta("src/Img/cover.png",con,0);
            con += 110;
        }

    }

    public void GenerarCartaAleatoria()
    {
        index = (int)(Math.random() * barajaDeCartas.Length);
        System.out.print("index: "+ index + "\n");
    }

    public void paint(Graphics g)
    {
        super.paint(g);

        for(int i = 0; i < cartas.length; i++)
        {
            cartas[i].Dibujar(g);
        }


        if(!l1.EstaVacio())
        {
            Carta primero = (Carta) l1.primero.Info;
            primero.Dibujar(g);
            int x = primero.x; int y =  primero.y + 160;
            g.drawString("Length: "+l1.Length,x,y);
        }

        if(!l2.EstaVacio())
        {
            Carta primero = (Carta) l2.primero.Info;
            primero.Dibujar(g);
            int x = primero.x; int y =  primero.y + 160;
            g.drawString("Length: "+l2.Length,x,y);
        }

        if(!l3.EstaVacio())
        {
            Carta primero = (Carta) l3.primero.Info;
            primero.Dibujar(g);
            int x = primero.x; int y =  primero.y + 160;
            g.drawString("Length: "+l3.Length,x,y);
        }

        if(!l4.EstaVacio())
        {
            Carta primero = (Carta) l4.primero.Info;
            primero.Dibujar(g);
            int x = primero.x; int y =  primero.y + 160;
            g.drawString("Length: "+l4.Length,x,y);
        }

        try{
            if(barajaDeCartas.EstaVacio())
            {
                JOptionPane.showMessageDialog(null,"You win");
                System.exit(0);
            }

            Carta carta = (Carta) barajaDeCartas.ObtenerNodoPorIndice(index).Info;

            int x = carta.x = 50; int y =  carta.y = 300;
            g.drawString("Tamaño: "+barajaDeCartas.Length,x + 100 ,y + 150);
            carta.Dibujar(g);
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,"Info :  " + e.toString() );
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            GenerarCartaAleatoria();
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            GenerarCartaAleatoria();
        }

        if(e.getKeyCode() == KeyEvent.VK_1)
        {

            Carta carta = (Carta) barajaDeCartas.ObtenerNodoPorIndice(index).Info;
            carta.x = 100; carta.y = 0;
            String tipo = String.valueOf(carta.Tipo);
            int numeroAGuardar = carta.Numero;


            int numeroActualEnLista = 0;
            if(!l1.EstaVacio())
            {
                Carta n = (Carta) l1.primero.Info;
                 numeroActualEnLista = n.Numero + 1;
            }

            if(tipo.equals("C") && numeroAGuardar == 1)
            {
                l1.InsertarInicio(new Nodo(carta));
                barajaDeCartas.EliminarPosicion(index);
                lim--;
                GenerarCartaAleatoria();

            }
            else if(tipo.equals("C") && numeroActualEnLista == numeroAGuardar ){
                l1.InsertarInicio(new Nodo(carta));
                barajaDeCartas.EliminarPosicion(index);
                lim--;
                GenerarCartaAleatoria();

            }


            System.out.print("\nLenth: " + lim + "\n");

        }

        if(e.getKeyCode() == KeyEvent.VK_2)
        {

            int numeroActualEnLista = 0;
            Carta carta = (Carta) barajaDeCartas.ObtenerNodoPorIndice(index).Info;
            carta.x = 210; carta.y = 0;

            String tipo = String.valueOf(carta.Tipo);
            int numeroAGuardar = carta.Numero;


            if(!l2.EstaVacio())
            {
                Carta n = (Carta) l2.primero.Info;
                numeroActualEnLista = n.Numero + 1;

            }

            if(tipo.equals("N") && numeroAGuardar == 1)
            {
                l2.InsertarInicio(new Nodo(carta));
                barajaDeCartas.EliminarPosicion(index);

                lim--;
                GenerarCartaAleatoria();
            }
            else if(tipo.equals("N") && numeroActualEnLista == numeroAGuardar ){
                l2.InsertarInicio(new Nodo(carta));
                barajaDeCartas.EliminarPosicion(index);

                lim--;
                GenerarCartaAleatoria();
            }


            System.out.print("\nLim: " + lim + "\n");

        }

        if(e.getKeyCode() == KeyEvent.VK_3)
        {

            Carta carta = (Carta) barajaDeCartas.ObtenerNodoPorIndice(index).Info;

            carta.x = 320; carta.y = 0;
            String tipo = String.valueOf(carta.Tipo);
            int numeroAGuardar = carta.Numero;


            int numeroActualEnLista = 0;
            if(!l3.EstaVacio())
            {
                Carta n = (Carta) l3.primero.Info;
                numeroActualEnLista = n.Numero + 1;
            }

            if(tipo.equals("D") && numeroAGuardar == 1)
            {
                l3.InsertarInicio(new Nodo(carta));
                barajaDeCartas.EliminarPosicion(index);

                lim--;
                GenerarCartaAleatoria();
            }
            else if(tipo.equals("D") && numeroActualEnLista == numeroAGuardar ){
                l3.InsertarInicio(new Nodo(carta));
               barajaDeCartas.EliminarPosicion(index);

                lim--;
                GenerarCartaAleatoria();
            }


            System.out.print("\nLenth: " + lim + "\n");

        }

        if(e.getKeyCode() == KeyEvent.VK_4)
        {

            Carta carta = (Carta) barajaDeCartas.ObtenerNodoPorIndice(index).Info;

            carta.x = 430; carta.y = 0;
            String tipo = String.valueOf(carta.Tipo);
            int numeroAGuardar = carta.Numero;

            int numeroActualEnLista = 0;
            if(!l4.EstaVacio())
            {
                Carta n = (Carta) l4.primero.Info;
                numeroActualEnLista = n.Numero + 1;
            }

            if(tipo.equals("T") && numeroAGuardar == 1)
            {
                l4.InsertarInicio(new Nodo(carta));
                barajaDeCartas.EliminarPosicion(index);

                lim--;
                GenerarCartaAleatoria();
            }
            else if(tipo.equals("T") && numeroActualEnLista == numeroAGuardar ){
                l4.InsertarInicio(new Nodo(carta));
                barajaDeCartas.EliminarPosicion(index);

                lim--;
                GenerarCartaAleatoria();
            }


            System.out.print("\nLenth: " + lim + "\n");

        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(barajaDeCartas.Length == 0)
        {
            JOptionPane.showMessageDialog(this,"El juego ha terminado");
            System.exit(0);
        }
    }
}
