import java.io.*;
import java.util.*;

public class Sequence extends Element
{
	int size;
	Element e;
	Sequence next=null;

	public Sequence()
	{
		e=new MyInteger();
		//size=0;
	}
	
	public Sequence(Element e)
	{
		this.e=e;
		//size=0;
	}

	public Element first()
	{
		return e;
	}
	
	public Sequence rest()
	{
		return this.next;
	}

	public int length()
	{
		int count=1;
		Sequence ptr=this;
		while(ptr!=null)
		{
			count++;
			ptr=ptr.next;
		}
		return count-2;
	}

	public void add(Element b,int pos)
	{
		Sequence newele=new Sequence(b);
		Sequence ptr=this;
		Element temp;
		if(pos==0)
		{
			newele.next=ptr.next;
			ptr.next=newele;
			temp=newele.e;
			newele.e=ptr.e;
			ptr.e=temp;		
		}
		if(pos<=size&&pos>0)
		{
			for(int i=0;i<pos-1;i++)
			{
				ptr=ptr.next;
				
			}
			newele.next=ptr.next;
			ptr.next=newele;		
		}
		else if(pos>size)
		{
			System.out.println("in sequence error out of range");
			System.exit(0);
		}
		size++;
	}
	public void delete(int pos)	
	{
		Sequence ptr=this;
		Sequence nxt=this.next;
		if(pos==0)
		{	
			{
				while(nxt.next!=null)
				{
					ptr.e=nxt.e;
					ptr=ptr.next;
					nxt=nxt.next;
				}
				pos=0;
			}
		}
		if (pos<size)
		{
			for(int i=0;i<pos-1;i++)
			{
				ptr=ptr.next;
			}
			ptr.next=ptr.next.next;
		}
		size--;
	}
	public void Print()
	{
		Sequence ptr=this;
		System.out.print("[ ");
		while(ptr.next!=null)
		{
			ptr.e.Print();
			System.out.print(" ");
			ptr=ptr.next;
		}
		System.out.print("]");
	}

	public Element index(int pos)
	{
		if(pos>size)
		{
			System.out.println("error out of range");
			System.exit(0);
		}
		Sequence ptr=this;
		for(int i=0;i<pos;i++)
		{
			ptr=ptr.next;
		}
		return ptr.e;			
	}

	/*public Sequence flatten()
	{
		Sequence newseq;
		Sequence temp;
		Sequence ptr=this;
		for(int i=0;i<size;i++)
		{
			if(ptr.e instanceof Sequence)
			{
				temp=ptr.e;
				for(int j=0;j<temp.size-1;j++)
				{
					newseq.add(temp.first);
					temp.delete(0);
				}
				newseq.add(temp.first);
			}
			else
			{
				newseq.add(ptr.e);
			}
		}
	}*/
	
}
