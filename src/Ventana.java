
import javax.swing.*;

public class Ventana extends JFrame {


    public Ventana()
    {
        super("Tablero de juego");
        setSize(700,500);
        add(new TableroJuego());
        setResizable(false);
        setVisible(true);
    }

    public static void main(String args[])
    {
        new Ventana();
    }
}
