import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color; 
public class GameField
{
  protected Rectangle bounds;
  private Color black;
  public GameField()
  {
  }
  public GameField(int x, int y, int width, int height)
  {
    bounds=new Rectangle(x, y, width, height);
    black=new Color(0, 0, 0);
  }
  public void draw(Graphics g)
  {
    g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
  }
  public Rectangle getBounds()
  {
    return bounds;
  }
  public Color getColor()
  {
    return black;
  }
  public boolean containsFrog(Frog f)
  {
    boolean contained=false;
    Rectangle fBounds=f.getBounds();
    if(fBounds.x>=bounds.x && (fBounds.x+fBounds.width)<=(bounds.x+bounds.width) && fBounds.y>=bounds.y && (fBounds.y+fBounds.height)<=(bounds.y+bounds.height))
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
      contained=true;
    }
    return contained;
  }
}