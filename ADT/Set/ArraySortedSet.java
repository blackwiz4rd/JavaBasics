public class ArraySortedSet implements SortedSet
{
	private Comparable[] v;
	private int vSize;
	public static int INITSIZE = 1;

	public ArraySortedSet()
	{
		v = new Comparable[INITSIZE];
		makeEmpty();
	}

	//suggested length = vSize * 2
	private Comparable[] resize(int length)
	{
		Comparable[] newv = new Comparable[length];
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
	//O(log(n))
	public void add(Object obj)
	{
		if(contains(obj))
			return;

		if(vSize == v.length)
			v = resize(vSize * 2);

		v[vSize++] = (Comparable)obj;
	}
	
	private Comparable[] insertionSort(Comparable[] v, int vSize)
	{
		return v;
	}
	//O(log(n))
	public void add(Comparable obj)
	{
		if(contains(obj))
			return;

		if(vSize == v.length)
			v = resize(vSize * 2);

		v[vSize++] = (Comparable)obj;
		v = insertionSort(v, vSize);

	}
	//O(log(n)) - binSearch
	public boolean contains(Object obj)
	{
		for(int i = 0; i < vSize; i++)
			if(v[i].equals((Comparable)obj))
				return true;
		return false;
	}
	//O(n)
	public Comparable[] toArray()
	{
		Comparable[] newv = new Comparable[vSize];
		System.arraycopy(v, 0, newv, 0, vSize);		
		return newv;
	}
	//O(nlog(n))
	public static SortedSet union(SortedSet s1, SortedSet s2)
	{
		return null;
	}
	
	//O(nlog(n))
	public static SortedSet insertion(SortedSet s1, SortedSet s2)
	{
		SortedSet x = new ArraySortedSet();
		Object[] v = s1.toArray();

		for(int i = 0; i < v.length; i++)
			if(s2.contains(v[i]))
				x.add(v[i]);
				
		return x;
	}
	//O(nlog(n))
	public static SortedSet substract(SortedSet s1, SortedSet s2)
	{
		SortedSet x = new ArraySortedSet();
		Object[] v = s1.toArray();

		for(int i = 0; i < v.length; i++)
			if(!s2.contains(v[i]))
				x.add(v[i]);
				
		return x;	
	}
	
	public Comparable[] toSortedArray()
	{
		Comparable[] newv = new Comparable[vSize];
		System.arraycopy(v, 0, newv, 0, vSize);		
		return newv;
	}
	
	public static void main(String[] args)
	{
		ArraySortedSet s = new ArraySortedSet();
		s.add((Comparable)4);
		s.add((Comparable)3);		
		s.add((Comparable)2);		
		s.add((Comparable)1);				
		Comparable[] x = s.toSortedArray();
		for(int i = 0; i < x.length; i++)
			System.out.println(x[i]);

		ArraySortedSet ss = new ArraySortedSet();
		
		ss.add((Comparable)6);
		ss.add((Comparable)5);		
		ss.add((Comparable)4);		
		ss.add((Comparable)3);				
		x = ss.toSortedArray();
		for(int i = 0; i < x.length; i++)
			System.out.println(x[i]);

		SortedSet union = union(s, ss);
	
		x = union.toSortedArray();
		for(int i = 0; i < x.length; i++)
			System.out.println(x[i]);
	
	
		SortedSet insertion = insertion(s, ss);
	
		x = insertion.toSortedArray();
		for(int i = 0; i < x.length; i++)
			System.out.println(x[i]);
	
		SortedSet substract = substract(s, ss);
	
		x = substract.toSortedArray();
		for(int i = 0; i < x.length; i++)
			System.out.println(x[i]);
	
	}
}