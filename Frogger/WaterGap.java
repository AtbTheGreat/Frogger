import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Point2D.Double;
public class WaterGap
{
  private Rectangle m_bounds;
  private double m_speed, m_delay, distanceMovedX, distanceMovedY, dh, vx, vy;
  private long m_lastTime, elapsedTime;
  private Double m_direction, m_velocity;
  public WaterGap(int x, int y, int width)
  {
    m_bounds=new Rectangle(x, y, width, 20);
    m_direction=new Double(0, 0);
    m_speed=38;
    m_delay=100;
    calculateVelocity();
  }
  public Rectangle getBounds()
  {
    return m_bounds;
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
  public boolean containsFrog(Frog f)
  {
    boolean contained=false;
    Rectangle fBounds=f.getBounds();
    if(m_bounds.width>1)
    {
      if((fBounds.y+fBounds.height)>=m_bounds.y && (fBounds.y+fBounds.height)<=(m_bounds.y+m_bounds.height))
      {
        if((fBounds.x+fBounds.width)>=(m_bounds.x+fBounds.width/2) && (fBounds.x+fBounds.width)<=(m_bounds.x+m_bounds.width-fBounds.width/2))
        {
          f.die(false);
          contained=true;
        }
        else if(fBounds.x<=(m_bounds.x+m_bounds.width-fBounds.width/2) && fBounds.x>=(m_bounds.x+fBounds.width/2))
        {
          f.die(false);
          contained=true;
        }
      }
      else if(fBounds.y<=(m_bounds.y+m_bounds.height) && fBounds.y>=m_bounds.y)
      {
        if((fBounds.x+fBounds.width)>=(m_bounds.x+fBounds.width/2) && (fBounds.x+fBounds.width)<=(m_bounds.x+m_bounds.width-fBounds.width/2))
        {
          f.die(false);
          contained=true;
        }
        else if(fBounds.x<=(m_bounds.x+m_bounds.width-fBounds.width/2) && fBounds.x>=(m_bounds.x+fBounds.width/2))
        {
          f.die(false);
          contained=true;
        }
      }
    }
    else if(m_bounds.width==1)
    {
      if(fBounds.x<=m_bounds.x && (fBounds.x+fBounds.width)>=(m_bounds.x+m_bounds.width))
      {
        if(fBounds.y<=(m_bounds.y+m_bounds.height) && (fBounds.y+fBounds.height)>=(m_bounds.y+m_bounds.height))
        {
          f.die(false);
          contained=true;
        }
        else if(fBounds.y<=m_bounds.y && (fBounds.y+fBounds.height)>=m_bounds.y)
        {
          f.die(false);
          contained=true;
        }
      }
    }
    calculateVelocity();
    return contained;
  }
  public void setDirection(double x, double y)
  {
    m_direction.x=x;
    m_direction.y=y;
  }
  public void setPosition(int x, int y)
  {
    m_bounds.x=x;
    m_bounds.y=y;
  }
}