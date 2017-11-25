public class FixedCircularArrayQueue implements Queue
{
	private Object v[];
	//indexes
	private int front;
	private int back;

	private final static int INITSIZE = 1;
	
	public FixedCircularArrayQueue()
	{
		v = new Object[INITSIZE];
		makeEmpty();
	}
	
	//index = index + 1 if index is not at array end
	//index = 0 if index is at array end
	private int increment(int index)
	{
		return (index + 1) % v.length;
	}
	
	public void makeEmpty()
	{
		for(int i = 0; i < v.length; i++)
			v[i] = null;
		front = back = 0;
	}
	
	public boolean isEmpty()
	{
		return increment(front) == back;
	}
	//enqueue in the end
	
	private Object[] resize()
	{
		Object[] newv = new Object[v.length * 2];
		System.arraycopy(v, 0, newv, 0, v.length);
		return newv;
	}
	
	public void enqueue(Object obj)
	{
		//otherwise resize and back before front
		if(increment(back) == front)
		{
			v = resize();
		
			if(back < front)
			{
				System.arraycopy(v, 0, v, v.length / 2, back);
				for(int i = 0; i < back; i++)
					v[i] = null;
				back += v.length / 2;
			}
		}
		v[back] = obj;
		back = increment(back);
	}

	public Object dequeue()
	{
		Object obj = getFront();
		
		v[front] = null;
			
		front = increment(front);
		return obj;
	}

	public Object getFront()
	{
		return v[front];
	}
	
	public void printArray()
	{
		for(int i = 0; i < v.length; i++)
			System.out.println(v[i]);
	}
		
	public static void main(String[] args)
	{
		FixedCircularArrayQueue c = new FixedCircularArrayQueue();
		c.enqueue(1);
		c.enqueue(2);
		c.enqueue(3);
		c.dequeue();
		c.enqueue(4);
		c.enqueue(5);
		c.dequeue();
		c.enqueue(4);
		c.enqueue(5);
		c.enqueue(4);
		c.enqueue(5);
		c.enqueue(6);
		c.printArray();				
	}
}