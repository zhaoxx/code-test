import java.util.*;
class  TestHashMap
{
	public static void printElements(Collection c)
	{
		Enumeration e = Collections.enumeration(c);
		while(e.hasMoreElements())
		{
			System.out.println(e.nextElement());
		}
	}
	public static void main(String[] args) 
	{
		HashMap hm = new HashMap();
		hm.put("one",new Student(1,"zhangsan"));
		hm.put("two",new Student(2,"lisi"));
		hm.put("three",new Student(3,"wangwu"));

		//System.out.println(hm.get("one"));
		/*Set keys = hm.keySet();
		printElements(keys);*/

		/*Collection values = hm.values();
		printElements(values);*/

		Set entrys = hm.entrySet();
		//printElements(entrys);
		Iterator it = entrys.iterator();
		while(it.hasNext())
		{
			Map.Entry me = (Map.Entry)it.next();
			System.out.println(me.getKey());
			System.out.println(me.getValue());
		}

	}
}

class Student
{
	int sno;
	String sname;
	public Student(int _sno,String _sname)
	{
		sno = _sno;
		sname = _sname;
	}
	public String toString()
	{
		return "sno="+sno+"\tsname="+sname;
	}
}
