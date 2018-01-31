public class MapIterator
{
	Map ptr;
	public MapIterator(Map b)
	{
		ptr=b;
	}
		
	public MapIterator advance()
	{
		ptr=ptr.next;
		return (new MapIterator(ptr));
	}

	public Pair get()
	{
		return ptr.p;
	}
	
	public boolean equal(MapIterator b)
	{
		return(ptr==b.ptr);
	}

}
