import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.geom.Point2D.Double;
public class Turtle extends Aquatic
{
  public Turtle(int x, int y)
  {
    image=new ImageIcon("turtle.png").getImage();
    m_bounds=new Rectangle(x, y, 34, 20);
    m_speed=38;
    m_delay=100;
    m_direction=new Double(-1, 0);
    calculateVelocity();
  }
}