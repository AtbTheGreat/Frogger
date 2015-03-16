import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.geom.Point2D.Double;
public class Car extends Vehicle
{
  public Car(int x, int y)
  {
    image=new ImageIcon("car.png").getImage();
    m_bounds=new Rectangle(x, y, 41, 20);
    m_speed=38;
    m_delay=100;
    m_direction=new Double(-1, 0);
    calculateVelocity();
  }
}