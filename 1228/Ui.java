import java.awt.*;
public class Ui extends java.applet .Applet{
	public void init(){
		add(new Label("Your name:"));
		add(new TextField(30));
		add(new Label("sex:"));
		CheckboxGroup cbg =new CheckboxGroup();
		add(new Checkbox("Male ",cbg,true));
		add(new Checkbox("Female ",cbg,false));
		add(new Label("What are you like?"));
		add(new Checkbox("ƻ��"));
		add(new Checkbox("����"));
		add(new Checkbox("�㽶"));
		add(new Checkbox("����"));
		add(new Label("��һ�ܳԶ��ٰ���"));
		Choice c = new Choice();
		c.addItem("��һ����");
		c.addItem("һ�ﵽ����");
		c.addItem("��ɢ����");
	add(c);
	add(new Label("����Ϊˮ��ʲô����Ҫ?"));
    add (new TextArea("����Ϊ",3,60));
	add(new Button("ȷ��"));
	add(new Button("���"));
	}
	public  void paint(Graphics g) 
	{
		
	}
}
