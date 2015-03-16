import javax.swing.JFrame;
import java.awt.Container; 
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Application extends JFrame
{
  private AppPanel m_mainPanel; 
  public static void main(String[] args)
  {
    Application app=new Application();        
    app.setBounds(0, 0, 347, 207); 
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    app.setVisible(true);   
  }
  public Application()
  {
    super("It's not easy being green");
    m_mainPanel=new AppPanel();
    Container c=getContentPane();
    c.add(m_mainPanel);
    addWindowListener(new WindowAdapter()
                        {
      public void windowClosing(WindowEvent e)
      {
        m_mainPanel.quitGameLoop();
        dispose();
        System.exit(0);
      }
    });
  }
}
