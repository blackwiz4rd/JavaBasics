/**
	getFirst
	getLast
	
	addFirst
	removeFirst
	
	addLast
	removeLast
	
		1st node
			element = null
			next = something
			
		last node
			element = something
			next = null
	*/

public class LinkedList implements Container
{
	public LinkedList()
	{		
		makeEmpty();
	}
	
	public void makeEmpty()
	{
		head = tail = new ListNode();
	}
	
	public boolean isEmpty()
	{
		return head == tail;	
	}
	
	public Object getFirst()
	{
		if(isEmpty())
			throw new EmptyLinkedListException();
		return head.getNext().getElement();
	}
	
	public Object getLast()
	{
		if(isEmpty())
			throw new EmptyLinkedListException();
		return tail.getElement();
	}
	
	public void addFirst(Object element)	//O(1)
	{
		head.setElement(element);
		head = new ListNode(null, head);	
	}
	
	public Object removeFirst()	//O(1)
	{
		Object element = getFirst();
		
		head = head.getNext();
		
		head.setElement(null);
		
		return element;
	}
	
	public void addLast(Object element)
	{
		tail.setNext(new ListNode(element, null));
		
		tail = tail.getNext();
	}
	
	public Object removeLast()
	{
		Object element = tail.getElement();
		
		ListNode temp = head;
		
		while(temp.getNext() != tail)
			temp = temp.getNext();
			
		tail = temp;
		
		tail.setNext(null);
		
		return element;
	}
	
	private ListNode head, tail;
	
	/**
		Node is composed of 
		element
		next
		
		1st node
			element = null
			next = something
			
		last node
			element = something
			next = null
		*/
	private class ListNode
	{
		public ListNode()
		{
			element = next = null;
		}
		
		public ListNode(Object element, ListNode next)
		{
			this.element = element;
			this.next = next;
		}
		
		public Object getElement()
		{
			return element;
		}
		
		public ListNode getNext()
		{
			return next;
		}
		
		public void setNext(ListNode next)
		{
			this.next = next;
		}
		
		public void setElement(Object element)
		{
			this.element = element;
		}
		
		Object element;
		ListNode next;
	}

	public class EmptyLinkedListException extends RuntimeException
	{
		public EmptyLinkedListException()
		{
			System.out.println("EmptyLinkedListException");
		}
	}

}