public interface Dictionary
{
	void insert(Comparable key, Object obj);
	Object remove(Comparable key);
	Object find(Comparable key);
}