import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
public class TestMenu 
{
	public static void main(String[] args) 
	{
		final JFrame f = new JFrame("Test Menu");
		final JTextArea ta = new JTextArea();

		JMenuBar mb = new JMenuBar();

		JMenu file = new JMenu("file");
		JMenu edit = new JMenu("edit");

		JMenuItem mi1 = new JMenuItem("new");
		JMenuItem mi2 = new JMenuItem("open",KeyEvent.VK_O);
		mi2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try
				{
					FileDialog fd = new FileDialog(f,"open",FileDialog.LOAD);
					fd.setVisible(true);
					String filename = fd.getDirectory()+fd.getFile();
					FileInputStream fis = new FileInputStream(filename);
					byte[] content = new byte[1024];
					int count = fis.read(content);
					ta.setText(new String(content,0,count));					
				}
				catch (Exception e1)
				{
					e1.printStackTrace();
				}
			}
		});
		JMenuItem mi3 = new JMenuItem("save");
		JMenuItem mi4 = new JMenuItem("exit");
		mi4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		JMenuItem mi5 = new JMenuItem("cut");
		JMenuItem mi6 = new JMenuItem("copy");
		JMenuItem mi7 = new JMenuItem("paste");

		file.add(mi1);
		file.add(mi2);
		file.add(mi3);
		file.add(mi4);

		edit.add(mi5);
		edit.add(mi6);
		edit.add(mi7);

		mb.add(file);
		mb.add(edit);
		f.add(ta);
		f.setJMenuBar(mb);

		f.setBounds(50,50,500,400);
		f.setVisible(true);
	}
}
