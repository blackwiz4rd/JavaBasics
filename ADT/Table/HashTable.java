/**
	HASH TABLE

	Dictionary with int keys
	Can be made with array
	all operations O(1)
	TABLE DIMENSION IS not DYNAMIC
	
	HASH FUNCTION
		translates an Object (eg. String) to an int
		Object key -> int key
		
		1)Object has a hashCode method that returns an int based on the memory index

		2)compression map:hasCode should return an int between the interval of existence of the array
		
	array of buckets (secchi)
	each index can have multiple elements of dictionary

	HASH BUCKET TABLE
*/

public interface Table extends Container
{
	void insert(int key, Object obj);
	Object remove(int key);
	Object find(int key);
}