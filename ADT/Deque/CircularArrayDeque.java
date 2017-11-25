public class CircularArrayDeque implements Deque
{
	private Object[] v;
	private int back;
	private int front;

	public static int INITSIZE = 1;

	public CircularArrayDeque()
	{
		v = new Object[INITSIZE];
		makeEmpty();
	}

	private int increment(int index)
	{
		return (index + 1) % v.length;
	}
	
	private int decrement(int index)
	{
		return (index - 1) % v.length;
	}

	public void makeEmpty()
	{
		for(int i = 0; i < v.length; i++)
			v[i] = null;

		back = front = 0;
	}
	
	public boolean isEmpty()
	{
		return increment(front) == back;		
	}

	public void addFirst(Object obj)
	{

	}
	
	//enqueue
	public void addLast(Object obj)
	{	
		if(increment(back) == front)
		{
			v = resize();
			if(back < front)
			{
				System.arraycopy(v, 0, v, v.length / 2, back);
				back += v.length / 2;
			}
		}

		v[back] = obj;
		back = increment(back);
	}
	
	private Object[] resize()
	{
		Object[] newv = new Object[v.length * 2];
		System.arraycopy(v, 0, newv, 0, v.length);
		return newv;
	}
	
	public Object removeFirst()
	{
		
		return null;		
	}
	
	public Object removeLast()
	{
		
		Object obj = v[back];
		
		v[back] = null;
		
		return obj;
	}
	
	public Object getFirst()
	{
		return v[front];
	}
	
	public Object getLast()
	{
		return v[back];
	}
	
	public int size()
	{
		if(back < front)
			return v.length - front + back;
		else
			return back - front;
	}
	
	public void printArray()
	{
		for(int i = 0; i < v.length; i++)
			System.out.println(v[i]);
	}
	
	public static void main(String[] args)
	{
		CircularArrayDeque c = new CircularArrayDeque();
		c.addLast(4);
		c.addLast(5);
		c.addLast(6);
		c.addLast(7);
		c.removeFirst();
		c.removeFirst();

		System.out.println("size: " + c.size());
		c.printArray();
	}
}