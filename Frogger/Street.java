import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color; 
public class Street extends GameField
{
  private Color gray;
  public Street(int x, int y, int width, int height)
  {
    bounds=new Rectangle(x, y, width, height);
    gray=new Color(128, 128, 128);
  }
  public void draw(Graphics g)
  {
    g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
    g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
  }
  public Color getColor()
  {
    return gray;
  }
  public boolean containsFrog(Frog f)
  {
    boolean contained=false;
    Rectangle fBounds=f.getBounds();
    if(fBounds.x>=bounds.x && (fBounds.x+fBounds.width)<=(bounds.x+bounds.width) && fBounds.y>=bounds.y && (fBounds.y+fBounds.height)<=(bounds.y+bounds.height))
    {
      contained=true;
      f.unboard();
    }
    return contained;
  }
  public boolean containsPartialFrog(Frog f)
  {
    boolean contained=false;
    Rectangle fBounds=f.getBounds();
    if(fBounds.y>=bounds.y && (fBounds.y+fBounds.height)<=(bounds.y+bounds.height) && (fBounds.x<bounds.x || (fBounds.x+fBounds.width)>(bounds.x+bounds.width)))
    {
      f.die(true);
      contained=true;
    }
    return contained;
  }
}