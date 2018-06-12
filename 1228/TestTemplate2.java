import java.util.*;
public class TestTemplate2 
{
	public static void main(String[] args)
	{
		MyStack<Student> ms=new MyStack<Student>();
		ms.push(new Student(1,"zhangsan"));
		ms.push(new Student(2,"lisi"));
		//ms.push("three");
		
		System.out.println(ms.pop());
		System.out.println(ms.peek());
		System.out.println(ms.pop());
		System.out.println(ms.empty());
	}
}

class MyStack<T>
{
	private LinkedList<T> ll=new LinkedList<T>();
	public void push(T o)
	{
		ll.addFirst(o);
	}
	public T pop()
	{
		return ll.removeFirst();
	}
	public T peek()
	{
		return ll.getFirst();
	}
	public boolean empty()
	{
		return ll.isEmpty();
	}	
}