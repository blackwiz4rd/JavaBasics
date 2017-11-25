/**
	LIFO	
	
*/
public interface Stack extends Container{
	/**
		Pushes an object to the stack	
	*/
	public void push(Object obj);
	/**
		-returns the last object
	*/
	public Object top();
	/**
		Pops out the last Object of the stack	
		-removes the last object from stack
		-returns the last object
	*/
	public Object pop();
	
}

class EmptyStackException extends RuntimeException{	}
class FullStackException extends RuntimeException{	}