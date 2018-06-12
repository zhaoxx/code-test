package testgui;
import java.awt.*;
public class MyFrame_BorderLayout
{
  public static void main(String[] args)
  {
    Frame f=new Frame("mybole");
    f.setSize(600,400);
    f.setLocation(50,50);
    f.setBackground(Color.green);    
    //f.setLayout(new BorderLayout(10,10));
    Button b1 = new Button("north");
    Button b2 = new Button("sourth");
    Button b3 = new Button("west");
    Button b4 = new Button("east");
    Button b5 = new Button("center");
    f.add(b1,"North");
    f.add(b2,"South");
    f.add(b3,"West");
    f.add(b4,"East");
    f.add(b5,"Center");
    f.setVisible(true);
    
  }
}