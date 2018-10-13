import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class CircleIcon implements Icon{
    private Color color;
    private int size;

    public CircleIcon(int aSize){
         size = aSize;
         color = Color.RED;
    }

    public int getIconWidth() {
        return size;
    }

    public int getIconHeight() {
        return size;
    }

    public void setColor(Color color) {
        this.color=color;
    }

     public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double planet = new Ellipse2D.Double(x, y,
                size, size);
        g2.setColor(color);
        g2.fill(planet);
     }

}
