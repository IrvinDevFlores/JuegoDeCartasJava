import javax.swing.*;
import java.awt.*;

public class ObjetoDibujable extends JPanel
{
    ImageIcon icon;
    Image objectImage;

    final int WIDTH = 100;
    final int HEIGTH = 150;

    public int x;
    public int y;
    public String Ruta = "";

    public ObjetoDibujable(String ruta,int x, int y)
    {
        Ruta = ruta;
        this.x = x;
        this.y = y;
        icon = new ImageIcon(Ruta);
        objectImage = icon.getImage();
    }
    public void DibujarEnPantalla(Graphics g,int x, int y)
    {
        super.paint(g);
        g.drawImage(objectImage, x , y , WIDTH , HEIGTH ,null);
    }
}
