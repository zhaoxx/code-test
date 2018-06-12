package testgui;

import java.awt.*;
import java.awt.event.*;

public class MyFrame_Total1 extends Frame
{
  private Panel borderPanel;
  private Panel flowPanel;
  private Panel gridPanel;
  private Panel cardPanel;
  public MyFrame_Total1(String title)
  {
    super(title);
    setSize(600,400);
    setLocation(100,100);
    setBorderLayoutPanel();
    setFlowLayoutPanel();
    setGridLayoutPanel();
    setCardLayoutPanel();
    setLayout(new GridLayout(2,2));
    add(borderPanel);
    add(flowPanel);
    add(gridPanel);
    add(cardPanel);    
  }

  public void setBorderLayoutPanel()
  {
    borderPanel=new Panel();
    borderPanel.setLayout(new BorderLayout());
    Button btn1=new Button("North");
    Button btn2=new Button("South");
    Button btn3=new Button("West");
    Button btn4=new Button("East");
    Button btn5=new Button("Center");
    borderPanel.add(btn1,BorderLayout.NORTH);
    borderPanel.add(btn2,BorderLayout.SOUTH);
    borderPanel.add(btn3,BorderLayout.WEST);
    borderPanel.add(btn4,BorderLayout.EAST);
    borderPanel.add(btn5,BorderLayout.CENTER);
  }
  public void setFlowLayoutPanel()
  {
    flowPanel=new Panel();
    Button btn1=new Button("mybole");
    Button btn2=new Button("winsun");
    flowPanel.add(btn1);
    flowPanel.add(btn2);
  }
  public void setGridLayoutPanel()
  {
    gridPanel=new Panel();
    gridPanel.setLayout(new GridLayout(2,2));
    Button btn1=new Button("Button1");
    Button btn2=new Button("Button2");
    Button btn3=new Button("Button3");
    Button btn4=new Button("Button4");
    gridPanel.add(btn1);
    gridPanel.add(btn2);
    gridPanel.add(btn3);
    gridPanel.add(btn4);
  }
  public void setCardLayoutPanel()
  {
    CardLayout cl=new CardLayout();
    cardPanel=new Panel();
    cardPanel.setLayout(cl);
    Button btn1=new Button("∫⁄Ã“A");
    Button btn2=new Button("∫ÏÃ“K");
    cardPanel.add(btn1,"1");
    cardPanel.add(btn2,"2");
  }
  public static void main(String[] args) throws HeadlessException
  {
    MyFrame_Total1 mf = new MyFrame_Total1("http://www.mybole.com.cn");
    mf.setVisible(true);
  }

}


















