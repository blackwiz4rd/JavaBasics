/**
	Every abstract data type (ADT) has to extend this interface
	ADT is an interface
*/
public interface Container{
	/**
		@return returns true if the data structure is empty, false if it's not empty	
	*/
	public boolean isEmpty();
	
	/**
		makes the data structure empty	
	*/
	public void makeEmpty();
}