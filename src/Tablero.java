import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tablero extends JFrame
{
    CanvasTablero canvasTablero;
    public Tablero()
    {

        super("Tablero de juego");
        canvasTablero = new CanvasTablero();
        int Width = canvasTablero.width;
        int Height = canvasTablero.height;

        setResizable(false);
        setLayout(null);

        getContentPane().add(canvasTablero);
        setSize(Width, Height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}