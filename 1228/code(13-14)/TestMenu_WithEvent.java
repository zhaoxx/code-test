package testgui;

import java.awt.*;
import java.awt.event.*;
public class TestMenu_WithEvent
{
  public static void main(String[] args)
  {
  	final Frame f=new Frame("http://www.mybole.com.cn");
    f.setSize(600,400);
    f.setLocation(100,100);
    f.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          System.exit(0);
        }
      });
	MenuBar mb=new MenuBar();
    Menu m1=new Menu("File");
    Menu m2=new Menu("Edit");
    MenuItem mi1=new MenuItem("New");
    MenuItem mi2=new MenuItem("Open");
    mi2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            FileDialog fd=new FileDialog(f,"Weixin Open File Dialog",
                                         FileDialog.LOAD);
            fd.setVisible();
          }
        });
    MenuItem mi3=new MenuItem("Save");
    MenuItem mi4=new MenuItem("Exit");
    mi4.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            System.exit(0);
          }
        });
    MenuItem mi5=new MenuItem("Copy");
    MenuItem mi6=new MenuItem("Paste");
    m1.add(mi1);
    m1.add(mi2);
    m1.add(mi3);
    m1.add(mi4);
    m2.add(mi5);
    m2.add(mi6);
    mb.add(m1);
    mb.add(m2);

    f.setMenuBar(mb);
    f.setVisible(true);
	}
}
