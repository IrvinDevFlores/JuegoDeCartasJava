import javax.swing.*;
import java.awt.*;

public class ImagenDibujable
{
    ImageIcon icon;
    Image image;

    int x;
    int y;

    public ImagenDibujable(String ruta, int x, int y)
    {
        icon = new ImageIcon(ruta);
        image = icon.getImage();
        this.x = x;
        this.y = y;
    }

    public void Dibujar(Graphics g)
    {
        g.drawImage(image,x,y,100,150,null);
    }
}
