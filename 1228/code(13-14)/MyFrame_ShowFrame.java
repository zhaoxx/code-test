package testgui;
import java.awt.*;
public class MyFrame_ShowFrame
{
  public static void main(String[] args)
  {
    Frame f=new Frame("myframe");
    //f.show(); ¹ýÊ±
    //f.setSize(600,400);
    //f.setLocation(50,50);
    f.setVisible(true);
    
  }
}