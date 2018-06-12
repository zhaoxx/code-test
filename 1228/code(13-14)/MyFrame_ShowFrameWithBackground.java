package testgui;
import java.awt.*;
public class MyFrame_ShowFrameWithBackground
{
  public static void main(String[] args)
  {
    Frame f=new Frame("mybole");
    f.setSize(600,400);
    f.setLocation(50,50);
    f.setBackground(Color.green);
    f.setVisible(true);
    
  }
}