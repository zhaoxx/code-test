import java.awt.*;
class MenuTest 
{
	public static void main(String[] args) 
	{
		Frame f1 = new Frame("Test Menu");
		f1.setBounds(50,50,500,400)
		
		MenuBar mb = new MenuBar();

		Menu file = new Menu("file");
		Menu edit = new Menu("edit");

		MenuItem mi1 = new MenuItem("new");
		MenuItem mi2 = new MenuItem("open");
		MenuItem mi3 = new MenuItem("save");
		MenuItem mi4 = new MenuItem("exit");

		MenuItem mi5 = new MenuItem("cut");
		MenuItem mi6 = new MenuItem("copy");
		MenuItem mi7 = new MenuItem("paste");
		
		file.add(mi1);
		file.add(mi2);
		file.add(mi3);
		file.add(mi4);

		edit.add(mi5);
		edit.add(mi6);
		edit.add(mi7);

		mb.add(file);
		mb.add(edit);

		f1.setMenubar(mb);

		f1.setVisible(true);
	}
}
