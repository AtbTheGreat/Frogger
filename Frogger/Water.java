import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color; 
public class Water extends GameField
{
  private Color blue;
  public Water(int x, int y, int width, int height)
  {
    bounds=new Rectangle(x, y, width, height);
    blue=new Color(0, 204, 204);
  }
  public void draw(Graphics g)
  {
    g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
    g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
  }
  public Color getColor()
  {
    return blue;
  }
  public boolean containsFrog(Frog f)
  {
    boolean contained=false;
    Rectangle fBounds=f.getBounds();
    if(fBounds.x>=bounds.x && (fBounds.x+fBounds.width)<=(bounds.x+bounds.width) && fBounds.y>=bounds.y && (fBounds.y)<=(bounds.y+bounds.height))
    {
      contained=true;
    }
    return contained;
  }
  public boolean containsPartialFrog(Frog f)
  {
    boolean contained=false;
    Rectangle fBounds=f.getBounds();
    if(fBounds.y>=bounds.y && (fBounds.y+fBounds.height)<=(bounds.y+bounds.height) && (fBounds.x<bounds.x || (fBounds.x+fBounds.width)>(bounds.x+bounds.width)))
    {
      f.die(false);
      contained=true;
    }
    return contained;
  }
}