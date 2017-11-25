public class GrowingArrayStack implements Stack{
	public GrowingArrayStack(){
		v = new Object[INITSIZE];
		makeEmpty();
	}

	/**
		@return returns true if the data structure is empty, false if it's not empty	
	*/
	public boolean isEmpty(){
		return (vSize == 0);
	}
	
	/**
		makes the data structure empty	
	*/
	public void makeEmpty(){
		vSize = 0;
	}

	/**
		Pushes an object to the stack	
	*/
	public void push(Object obj){
		if(vSize == v.length)
			v = resize(2 * vSize);
		v[vSize++] = obj;
	}
	
	public Object[] resize(int newLength){
		if(newLength < v.length)
			throw new IllegalArgumentException();
		Object[] newv = new Object[newLength];
		System.arraycopy(v, 0, newv, 0, v.length);
		return newv;
	}
	/**
		-returns the last object
	*/
	public Object top(){
		if(isEmpty())
			throw new EmptyStackException();
		return v[vSize - 1];
	}
	/**
		Pops out the last Object of the stack	
		-removes the last object from stack
		-returns the last object
	*/
	public Object pop(){
		Object obj = top();
		vSize--;
		return obj;
	}
	
	protected Object v[];
	protected int vSize;
	public static final int INITSIZE = 100;	
}