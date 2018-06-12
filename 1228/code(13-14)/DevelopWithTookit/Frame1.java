import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;

public class Frame1 extends JFrame
{
  JPanel contentPane;
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu jMenuFile = new JMenu();
  JMenuItem jMenuFileExit = new JMenuItem();
  JMenu jMenuHelp = new JMenu();
  JMenuItem jMenuHelpAbout = new JMenuItem();
  JToolBar jToolBar = new JToolBar();
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  ImageIcon image1;
  ImageIcon image2;
  ImageIcon image3;
  JLabel statusBar = new JLabel();
  JButton jButton4 = new JButton();
  XYLayout xYLayout1 = new XYLayout();
  JTextArea jTextArea1 = new JTextArea();
  JMenu jMenu1 = new JMenu();
  JMenuItem jMenuItem1 = new JMenuItem();
  JMenuItem jMenuItem2 = new JMenuItem();
  JPopupMenu jPopupMenu1 = new JPopupMenu();
  JMenuItem jMenuItem3 = new JMenuItem();
  JMenuItem jMenuItem4 = new JMenuItem();

  //Construct the frame
  public Frame1()
  {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try
    {
      jbInit();
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
  }
  //Component initialization
  private void jbInit() throws Exception
  {
    image1 = new ImageIcon(Frame1.class.getResource("openFile.png"));
    image2 = new ImageIcon(Frame1.class.getResource("closeFile.png"));
    image3 = new ImageIcon(Frame1.class.getResource("help.png"));
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(xYLayout1);
    this.setSize(new Dimension(400, 300));
    this.setTitle("http://www.mybole.com.cn");
    statusBar.setText(" ");
    jMenuFile.setText("File");
    jMenuFileExit.setText("Exit");
    jMenuFileExit.addActionListener(new Frame1_jMenuFileExit_ActionAdapter(this));
    jMenuHelp.setText("Help");
    jMenuHelpAbout.setText("About");
    jMenuHelpAbout.addActionListener(new Frame1_jMenuHelpAbout_ActionAdapter(this));
    jButton1.setIcon(image1);
    jButton1.setToolTipText("Open File");
    jButton2.setIcon(image2);
    jButton2.setToolTipText("Close File");
    jButton3.setIcon(image3);
    jButton3.setToolTipText("Help");
    jButton4.setText("winsun");
    jTextArea1.setText("");
    jMenu1.setText("Edit");
    jMenuItem1.setText("Copy");
    jMenuItem2.setText("Paste");
    jMenuItem3.setText("Show");
    jMenuItem3.addActionListener(new Frame1_jMenuItem3_actionAdapter(this));
    jMenuItem4.setText("Hide");
    contentPane.addMouseListener(new Frame1_contentPane_mouseAdapter(this));
    jToolBar.add(jButton1);
    jToolBar.add(jButton2);
    jToolBar.add(jButton3);
    jMenuFile.add(jMenuFileExit);
    jMenuHelp.add(jMenuHelpAbout);
    jMenuBar1.add(jMenuFile);
    jMenuBar1.add(jMenu1);
    jMenuBar1.add(jMenuHelp);
    this.setJMenuBar(jMenuBar1);
    contentPane.add(jToolBar,  new XYConstraints(0, 0, 400, -1));
    contentPane.add(statusBar,  new XYConstraints(0, 284, 400, -1));
    contentPane.add(jButton4,          new XYConstraints(54, 57, 83, 62));
    contentPane.add(jTextArea1,    new XYConstraints(188, 41, 136, 136));
    jMenu1.add(jMenuItem1);
    jMenu1.add(jMenuItem2);
    jPopupMenu1.add(jMenuItem3);
    jPopupMenu1.add(jMenuItem4);
  }
  //File | Exit action performed
  public void jMenuFileExit_actionPerformed(ActionEvent e)
  {
    System.exit(0);
  }
  //Help | About action performed
  public void jMenuHelpAbout_actionPerformed(ActionEvent e)
  {
    Frame1_AboutBox dlg = new Frame1_AboutBox(this);
    Dimension dlgSize = dlg.getPreferredSize();
    Dimension frmSize = getSize();
    Point loc = getLocation();
    dlg.setLocation((frmSize.width - dlgSize.width) / 2 + loc.x, (frmSize.height - dlgSize.height) / 2 + loc.y);
    dlg.setModal(true);
    dlg.pack();
    dlg.show();
  }
  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e)
  {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING)
    {
      jMenuFileExit_actionPerformed(null);
    }
  }

  void contentPane_mouseReleased(MouseEvent e)
  {
    if(e.isPopupTrigger())
    {
      jPopupMenu1.show(e.getComponent(),e.getX(),e.getY());
    }
  }

  void jMenuItem3_actionPerformed(ActionEvent e)
  {
    JOptionPane.showMessageDialog(null,"Show");
  }
}

class Frame1_jMenuFileExit_ActionAdapter implements ActionListener
{
  Frame1 adaptee;

  Frame1_jMenuFileExit_ActionAdapter(Frame1 adaptee)
  {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e)
  {
    adaptee.jMenuFileExit_actionPerformed(e);
  }
}

class Frame1_jMenuHelpAbout_ActionAdapter implements ActionListener
{
  Frame1 adaptee;

  Frame1_jMenuHelpAbout_ActionAdapter(Frame1 adaptee)
  {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e)
  {
    adaptee.jMenuHelpAbout_actionPerformed(e);
  }
}

class Frame1_contentPane_mouseAdapter extends java.awt.event.MouseAdapter
{
  Frame1 adaptee;

  Frame1_contentPane_mouseAdapter(Frame1 adaptee)
  {
    this.adaptee = adaptee;
  }
  public void mouseReleased(MouseEvent e)
  {
    adaptee.contentPane_mouseReleased(e);
  }
}

class Frame1_jMenuItem3_actionAdapter implements java.awt.event.ActionListener
{
  Frame1 adaptee;

  Frame1_jMenuItem3_actionAdapter(Frame1 adaptee)
  {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e)
  {
    adaptee.jMenuItem3_actionPerformed(e);
  }
}