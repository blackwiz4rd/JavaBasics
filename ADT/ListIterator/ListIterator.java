/**
	-next
	-hasNext
	-add
	-remove
	*/

import java.util.NoSuchElementException;

public interface ListIterator
{
	Object next() throws NoSuchElementException;
	
	boolean hasNext();
	
	void add(Object x);
	
	void remove() throws IllegalStateException;
}