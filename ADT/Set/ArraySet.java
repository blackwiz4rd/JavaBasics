public class ArraySet implements Set
{
	private Object[] v;
	private int vSize;
	public static int INITSIZE = 1;

	public ArraySet()
	{
		v = new Object[INITSIZE];
		makeEmpty();
	}

	//suggested length = vSize * 2
	private Object[] resize(int length)
	{
		Object[] newv = new Object[length];
		System.arraycopy(v, 0, newv, 0, vSize);
		return newv;
	}

	public boolean isEmpty()
	{
		return vSize == 0;
	}
	public void makeEmpty()
	{
		for(int i = 0; i < v.length; i++)
			v[i] = null;
		vSize = 0;
	}
	//O(n)
	public void add(Object obj)
	{
		if(contains(obj))
			return;

		if(vSize == v.length)
			v = resize(vSize * 2);

		v[vSize++] = obj;
	}
	//O(n)
	public boolean contains(Object obj)
	{
		for(int i = 0; i < vSize; i++)
			if(v[i].equals(obj))
				return true;
		return false;
	}
	//O(n)
	public Object[] toArray()
	{
		Object[] newv = new Object[vSize];
		System.arraycopy(v, 0, newv, 0, vSize);		
		return newv;
	}
	//O(n^2)
	public static Set union(Set s1, Set s2)
	{
		Set x = new ArraySet();
		Object[] v = s1.toArray();
		
		for(int i = 0; i < v.length; i++)
			x.add(v[i]);
			
		v = s2.toArray();
		
		for(int i = 0; i < v.length; i++)
			x.add(v[i]);
			
		return x;
	}
	
	//O(n^2)
	public static Set insertion(Set s1, Set s2)
	{
		Set x = new ArraySet();
		Object[] v = s1.toArray();

		for(int i = 0; i < v.length; i++)
			if(s2.contains(v[i]))
				x.add(v[i]);
				
		return x;
	}
	//O(n^2)
	public static Set substract(Set s1, Set s2)
	{
		Set x = new ArraySet();
		Object[] v = s1.toArray();

		for(int i = 0; i < v.length; i++)
			if(!s2.contains(v[i]))
				x.add(v[i]);
				
		return x;	
	}
}