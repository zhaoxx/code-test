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
		add(new Checkbox("苹果"));
		add(new Checkbox("桔子"));
		add(new Checkbox("香蕉"));
		add(new Checkbox("葡萄"));
		add(new Label("你一周吃多少啊？"));
		Choice c = new Choice();
		c.addItem("比一斤少");
		c.addItem("一斤到三斤");
		c.addItem("比散尽多");
	add(c);
	add(new Label("你认为水果什么最重要?"));
    add (new TextArea("我认为",3,60));
	add(new Button("确定"));
	add(new Button("清空"));
	}
	public  void paint(Graphics g) 
	{
		
	}
}
