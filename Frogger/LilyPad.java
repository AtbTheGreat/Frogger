import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Image;
import javax.swing.ImageIcon;
public class LilyPad
{
  private Rectangle m_bounds;
  private Image image;
  public LilyPad(Rectangle waterBounds, int x)
  {
    image=new ImageIcon("lilyPad.png").getImage();
    m_bounds=new Rectangle(x, waterBounds.y, 35, 20);
  }
  public void draw(Graphics g)
  {
    g.drawImage(image, m_bounds.x, m_bounds.y, m_bounds.width, m_bounds.height, null);
  }
  public boolean boardFrog(Frog f)
  {
    boolean boarded=false;
    Rectangle fBounds=f.getBounds();
    if(fBounds.x>=m_bounds.x && (fBounds.x+fBounds.width)<=(m_bounds.x+m_bounds.width) && fBounds.y<(m_bounds.y+m_bounds.height) && fBounds.y>m_bounds.y)
    {
      boarded=true;
      f.setPosition(fBounds.x, m_bounds.y);
    }
    return boarded;
  }
  public Rectangle getBounds()
  {
    return m_bounds;
  }
}