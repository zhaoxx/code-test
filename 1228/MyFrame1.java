import java.awt.*;
import java.awt.event.*;
public class MyFrame1 
{
	public static void main(String[] args) 
	{
		Frame f = new Frame("my first frame");
		f.setBounds(50,50,500,400);
		f.setBackground(Color.red);
		f.setLayout(new GridLayout(2,3));
		f.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		f.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)  
			{
				System.exit(0);
			}
		});
		Button b1 = new Button("NORTH");
		Button b2 = new Button("SOUTH");
		Button b3 = new Button("WEST");
		Button b4 = new Button("EAST");
		Button b5 = new Button("CENTER");
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);

		f.setVisible(true);
	}
}