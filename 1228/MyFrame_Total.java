import java.awt.*;
import java.awt.event.*;
public class MyFrame_Total extends Frame
{
	private Panel borderPanel;
	private Panel flowPanel;
	private Panel gridPanel;
	private Panel cardPanel;

	public MyFrame_Total(String title)
	{
		super(title);
		setLayout(new GridLayout(2,2));
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		setBounds(50,50,500,400);
		setBorderPanel();
		setFlowPanel();
		setGridPanel();
		setCardPanel();
		add(borderPanel);
		add(flowPanel);
		add(gridPanel);
		add(cardPanel);
	}

	public void setBorderPanel()
	{
		borderPanel = new Panel();
		borderPanel.setLayout(new BorderLayout());
		Button b1 = new Button("NORTH");
		Button b2 = new Button("SOUTH");
		Button b3 = new Button("WEST");
		Button b4 = new Button("EAST");
		Button b5 = new Button("CENTER");
		borderPanel.add(b1,"North");
		borderPanel.add(b2,"South");
		borderPanel.add(b3,"West");
		borderPanel.add(b4,"East");
		borderPanel.add(b5,"Center");
	}
	public void setFlowPanel()
	{
		flowPanel = new Panel();
		flowPanel.setLayout(new FlowLayout());
		Button b1 = new Button("play");
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				Button b = (Button)e.getSource();
				if(b.getLabel().equals("play"))
					b.setLabel("pause");
				else
					b.setLabel("play");
			}
		});
		Button b2 = new Button("stop");
		flowPanel.add(b1);
		flowPanel.add(b2);
	}
	public void setGridPanel()
	{
		gridPanel = new Panel();
		gridPanel.setLayout(new GridLayout(3,2));
		Button b1 = new Button("aaa");
		Button b2 = new Button("bbb");
		Button b3 = new Button("ccc");
		Button b4 = new Button("ddd");
		Button b5 = new Button("eee");
		Button b6 = new Button("fff");
		gridPanel.add(b1);
		gridPanel.add(b2);
		gridPanel.add(b3);
		gridPanel.add(b4);
		gridPanel.add(b5);
		gridPanel.add(b6);
	}
	public void setCardPanel()
	{
		cardPanel = new Panel();
		final CardLayout cl = new CardLayout();
		cardPanel.setLayout(cl);
		ActionListener al = new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				cl.next(cardPanel);
			}
		};
		Button b1 = new Button("∫ÏÃ“K");
		Button b2 = new Button("∫⁄Ã“K");
		b1.addActionListener(al);
		b2.addActionListener(al);
		cardPanel.add(b1,"1");
		cardPanel.add(b2,"2");
	}
	

	public static void main(String[] args) 
	{
		MyFrame_Total mt = new MyFrame_Total("Test Total Layout");
		mt.setVisible(true);
	}
}
