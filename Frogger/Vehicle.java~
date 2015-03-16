import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.geom.Point2D.Double;
public class Vehicle
{
  protected Image image;
  protected Rectangle m_bounds;
  protected double m_speed, m_delay, distanceMovedX, distanceMovedY, dh, vx, vy;
  protected long m_lastTime, elapsedTime;
  protected Double m_direction, m_velocity;
  public Vehicle()
  {
  }
  public Vehicle(int x, int y)
  {
  }
  public boolean killFrog(Frog f)
  {
    boolean contained=false;
    Rectangle fBounds=f.getBounds();
    if((fBounds.y+fBounds.height)>m_bounds.y && (fBounds.y+fBounds.height)<(m_bounds.y+m_bounds.height))
    {
      if((fBounds.x+fBounds.width)>m_bounds.x && (fBounds.x+fBounds.width)<(m_bounds.x+m_bounds.width))
      {
        f.die(true);
        contained=true;
      }
      else if(fBounds.x<(m_bounds.x+m_bounds.width) && fBounds.x>m_bounds.x)
      {
        f.die(true);
        contained=true;
      }
    }
    else if(fBounds.y<(m_bounds.y+m_bounds.height) && fBounds.y>m_bounds.y)
    {
      if((fBounds.x+fBounds.width)>m_bounds.x && (fBounds.x+fBounds.width)<(m_bounds.x+m_bounds.width))
      {
        f.die(true);
        contained=true;
      }
      else if(fBounds.x<(m_bounds.x+m_bounds.width) && fBounds.x>m_bounds.x)
      {
        f.die(true);
        contained=true;
      }
    }
    calculateVelocity();
    return contained;
  }
  public void draw(Graphics g)
  {
    g.drawImage(image, m_bounds.x, m_bounds.y, m_bounds.width, m_bounds.height, null);
    calculateVelocity();
  }
  public void animate(long currentTime)
  {
    if(m_lastTime==0)
    {
      m_lastTime=currentTime;
    }
    elapsedTime=(currentTime-m_lastTime);
    if(elapsedTime>m_delay)
    {
      int distanceMovedX=(int)(m_velocity.x*(double)(elapsedTime)/1000);
      int distanceMovedY=(int)(m_velocity.y*(double)(elapsedTime)/1000);
      m_bounds.y+=distanceMovedY;
      m_bounds.x+=distanceMovedX;
      m_lastTime=currentTime;
    }
    calculateVelocity();
  }
  public void calculateVelocity()
  {
    dh=Math.pow((Math.pow(m_direction.x, 2)+Math.pow(m_direction.y, 2)), .5);
    vx=m_speed*(double)m_direction.x/dh;
    vy=m_speed*(double)m_direction.y/dh;
    
    m_velocity = new Double(vx, vy);
  }
  public Rectangle getBounds()
  {
    return m_bounds;
  }
  public void setPosition(int x, int y)
  {
    m_bounds.x=x;
    m_bounds.y=y;
  }
}