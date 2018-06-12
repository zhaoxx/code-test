import java.util.*;
class TestTemplate 
{
	public static void main(String[] args) 
	{
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student(1,"zhangsan"));
		students.add(new Student(2,"lisi"));
		students.add(new Student(1,"wangwu"));
		
		/*Student s = students.get(0);
		System.out.println(s.sname);*/
		for(Student s:students)
		{
			System.out.println(s.sname);
		}
	}
}
