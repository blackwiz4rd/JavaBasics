public class QueueByLinkedList implements Queue
{
	public void makeEmpty()
	{
		list.makeEmpty();
	}
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	public void enqueue(Object obj)
	{
		list.addLast(obj);
	}
	public Object dequeue()
	{
		return list.removeLast();
	}
	public Object getFront()
	{
		return list.getFirst();
	}
	LinkedList list;
}