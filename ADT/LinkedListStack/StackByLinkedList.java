public class StackByLinkedList implements Stack
{
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	public void makeEmpty()
	{
		list.makeEmpty();
	}

	public void push(Object obj)
	{
		list.addFirst(obj);		
	}
	public Object top()
	{
		return list.removeFirst();
	}
	public Object pop()
	{
		return list.getFirst();
	}
	
	private LinkedList list;
}