import java.awt.*;
class TestFlowLayout 
{
	public static void main(String[] args) 
	{
		Frame f = new Frame("Test Flow Layout");
		f.setBounds(50,50,500,400);
		f.setBackground(Color.blue);
		f.setLayout(new FlowLayout(FlowLayout.RIGHT));
		f.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		Button b1 = new Button("aaa");
		Button b2 = new Button("bbb");
		Button b3 = new Button("ccc");

		f.add(b1);
		f.add(b2);
		f.add(b3);

		f.setVisible(true);
	}
}
