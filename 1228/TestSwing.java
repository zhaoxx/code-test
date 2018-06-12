import javax.swing.*;
class TestSwing 
{
	public static void main(String[] args) 
	{
		JFrame jf = new JFrame("test Swing Frame");
		jf.setBounds(50,50,300,200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		JButton jb = new JButton("click me!");
		jf.getContentPane().add(jb);
		jf.setVisible(true);
	}
}
