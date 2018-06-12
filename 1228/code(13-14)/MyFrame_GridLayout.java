package testgui;
import java.awt.*;
public class MyFrame_GridLayout
{
  public static void main(String[] args)
  {
    Frame f=new Frame("mybole");
    f.setSize(600,400);
    f.setLocation(50,50);
    f.setBackground(Color.green);
    f.setLayout(new GridLayout(3,2));
		//f.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		//f.setLayout(new GridLayout(3,2,10,10));
    Button b1 = new Button("north");
    Button b2 = new Button("sourth");
    Button b3 = new Button("west");
    Button b4 = new Button("east");
    Button b5 = new Button("center");
    f.add(b1);
    f.add(b2);
    f.add(b3);
    f.add(b4);
    f.add(b5);
    f.setVisible(true);
    
  }
}