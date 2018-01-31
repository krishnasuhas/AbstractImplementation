public class SequenceIterator
{
	Sequence ptr;
	public SequenceIterator(Sequence b)
	{
		ptr=b;
	}
		
	public SequenceIterator advance()
	{
		ptr=ptr.next;
		return (new SequenceIterator(ptr));
	}

	public Element get()
	{
		return ptr.e;
	}
	
	public boolean equal(SequenceIterator b)
	{
		return(ptr==b.ptr);
	}

}
