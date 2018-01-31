import java.io.*;

public class Map 
{
	Pair p;
	Map next;
	int size;

	public Map()
	{
		size=0;
		p=new Pair();
		next=null;
	}

	public Map(Pair b)
	{
		size=0;
		p=b;
		next=null;
	}
	public void add(Pair b,int pos)
	{
		Map newpair=new Map(b);
		Map ptr=this;
		Pair temp;
		if(pos==0)
		{
			newpair.next=ptr.next;
			ptr.next=newpair;
			temp=newpair.p;
			newpair.p=ptr.p;
			ptr.p=temp;		
		}
		else if(pos<=size)
		{
			for(int i=0;i<pos-1;i++)
			{
				ptr=ptr.next;
				
			}
			newpair.next=ptr.next;
			ptr.next=newpair;		
		}
		else if(pos>size)
		{
			System.out.println("in Map error out of range");
			System.exit(0);
		}
		size++;
	}

	public void add(Pair b)
	{
		if(size==0)
		{
			this.p=b;		
		}
		else
		{
			Map ptr=this;
			int pos=0;
			while(ptr!=null&&(int)ptr.p.k.a<=(int)b.k.a)
			{
				pos++;
				ptr=ptr.next;
			}
			/*if(ptr==null)
			add(b,pos-1);
			else*/
			add(b,pos);
		}
		size++;
	}

	public void Print()
	{
		Map ptr=this;
		System.out.print("[ ");
		while(ptr!=null)
		{
			ptr.p.Print();
			System.out.print(" ");
			ptr=ptr.next;
		}
		System.out.print("]");
	}

	public MapIterator begin()
	{
		return (new MapIterator(this));
	}

	public MapIterator end()
	{
		Map ptr=this;
		while(ptr!=null)ptr=ptr.next;

		return (new MapIterator(ptr));
	}

	public MapIterator find(MyChar key)
	{
		Map ptr=this;
		while(ptr!=null&&((MyChar)ptr.p.k).a!=key.a)
		{
			ptr=ptr.next;
		}
		MapIterator mi=new MapIterator(ptr);
		return mi;
	}
		
}
