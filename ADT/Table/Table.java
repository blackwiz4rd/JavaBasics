/**
	Dictionary with int keys
	Can be made with array
	all operations O(1)
	TABLE DIMENSION IS not DYNAMIC
	if you add a key = 100 and have no other data you waste it.
	resize = O(n)
*/

public interface Table extends Container
{
	void insert(int key, Object obj);
	Object remove(int key);
	Object find(int key);
}