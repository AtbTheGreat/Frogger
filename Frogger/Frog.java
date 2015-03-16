import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.geom.Point2D.Double;
import java.awt.event.*;
public class Frog
{
  private Image image;
  private Rectangle m_bounds;
  private double m_speed, m_delay, distanceMovedX, distanceMovedY, dh, vx, vy;
  private long m_lastTime, elapsedTime;
  private Double m_direction, aquaticDirection, m_velocity;
  private int width, height;
  private boolean alive, boarded;
  public Frog(Rectangle bounds)
  {
    width=19;
    height=20;
    alive=true;
    boarded=false;
    image=new ImageIcon("frog.png").getImage();
    m_bounds=new Rectangle(bounds.x+(bounds.width-width)/2, bounds.y+bounds.height-height, width, height);
    m_speed=100;
    m_delay=100;
    m_direction=new Double(0, 0);
    calculateVelocity();
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
  public void die(boolean street)
  {
    if(street==true)
    {
      image=new ImageIcon("blood.png").getImage();
    }
    else if(street==false)
    {
      image=new ImageIcon("water.png").getImage();
    }
    boarded=false;
    setDirection(0, 0);
    alive=false;
  }
  public boolean isAlive()
  {
    return alive;
  }
  public void setDirection(double x, double y)
  {
    m_direction.x=x;
    m_direction.y=y;
    calculateVelocity();
  }
  public void navigate(int e)
  {
    if(e==KeyEvent.VK_LEFT)
    {
      setDirection(-1, 0);
      if(boarded==true && aquaticDirection.x==-1)
      {
        m_speed=100;
      }
    }
    else if(e==KeyEvent.VK_RIGHT)
    {
      setDirection(1, 0);
      if(boarded==true && aquaticDirection.x==1)
      {
        m_speed=100;
      }
    }
    else if(e==KeyEvent.VK_UP)
    {
      setDirection(0, -1);
    }
    else if(e==KeyEvent.VK_DOWN)
    {
      setDirection(0, 1);
    }
  }
  public void align(double x, double y, double s)
  {
    setDirection(x, y);
    m_speed=s;
    calculateVelocity();
  }
  public Rectangle getBounds()
  {
    return m_bounds;
  }
  public void collideX(int x)
  {
    setPosition(x, m_bounds.y);
    setDirection(0, 0);
  }
  public void collideY(int y)
  {
    setPosition(m_bounds.x, y);
    setDirection(0, 0);
  }
  public void setPosition(int x, int y)
  {
    m_bounds.x=x;
    m_bounds.y=y;
    calculateVelocity();
  }
  public void halt()
  {
    setDirection(0, 0);
  }
  public void board(Aquatic a, Rectangle streetBounds)
  {
    Rectangle aBounds=a.getBounds();
    if(m_bounds.x>(aBounds.x-m_bounds.width/2) && (m_bounds.x+m_bounds.width)<(aBounds.x+aBounds.width+m_bounds.width/2))
    {
      if(m_bounds.y<(aBounds.y+aBounds.height) && m_bounds.y>aBounds.y && m_direction.x==0 && m_direction.y==-1)
      {
        setPosition(m_bounds.x, aBounds.y);
        aquaticDirection=a.getDirection();
        alignDirection();
        calculateVelocity();
        boarded=true;
      }
      else if(m_direction.x==0 && m_direction.y==1)
      {
        if((m_bounds.y+m_bounds.height)<(aBounds.y+aBounds.height) && (m_bounds.y+m_bounds.height)>aBounds.y)
        {
          setPosition(m_bounds.x, aBounds.y);
          aquaticDirection=a.getDirection();
          m_speed=a.getSpeed();
          alignDirection();
          calculateVelocity();
          boarded=true;
        }
        else if(m_bounds.y+m_bounds.height>=streetBounds.y)
        {
          setPosition(m_bounds.x, streetBounds.y);
          calculateVelocity();
          boarded=false;
        }
      }
      calculateVelocity();
    }
  }
  public boolean getBoarded()
  {
    return boarded;
  }
  public void alignDirection()
  {
    m_direction.x=aquaticDirection.x;
    m_direction.y=aquaticDirection.y;
    m_speed=38;
    calculateVelocity();
  }
  public void unboard()
  {
    boarded=false;
    m_speed=100;
  }
}