import java.io.*;
import java.util.*;

public class Sequence extends Elements
{
	
	public Element e;
	public Sequence next;
	public Sequence first=this;
	int size;

	public Sequence()
	{
		next=null;
		size=0;
	}
	
	public Sequence(Element e)
	{
		this.e=e;
		next=null;
		size=0;
	}

	public Element first()
	{
		return this.e;
	}
	
	public Sequence rest()
	{
		return next;
	}

	public int length()
	{
		return size;
	}

	public void add(Element b,int pos)
	{
		Sequence newele=new Sequence(b);
		Sequence ptr1=start;
		Sequence ptr2=start;
		pos=pos-1;
		if(pos>size)
		{
			System.out.println("error out of range");
			exit(1);
		}
		else if(pos==0)
		{
			newele.next=start;
			start=newele;
		}
		else if(pos<size)
		{
			for(int i=1;i<size;i++)
			{
				if(i<pos)
				{
					ptr1=ptr1.next;
				}
				if(i<=pos)
				{
					ptr2=ptr2.next;
				}
			}
			newele.next=ptr2;
			ptr1.next=newele;		
		}
		else 
		{
			for(int i=1;i<=size;i++)
			{
				if(i<pos)
				{
					ptr1=ptr1.next;
				}
			}
			ptr1.next=newele;
		}
	}
	public void delete(int pos)	
	{
		Sequence ptr1=start;
		Sequence ptr2=start;
		pos=pos-1;
		if(pos==0)
		{
			start=start.next;
		}
		else if(pos<size-1)
		{
			for(int i=1;i<size;i++)
			{
				if(i<pos)
				{
					ptr1=ptr1.next;
				}
				if(i<=pos)
				{
					ptr2=ptr2.next;
				}
			}
			ptr2.next=ptr2;
			ptr1.next=ptr2;	
		}
		else if(pos==size-1)
		{
			for(int i=1;i<=size-2;i++)
			{
				ptr1=ptr1.next;
			}
			ptr1.next=null;	
		}
	}
	public void print()
	{
		System.out.println(" ["+e+"] ")
	}

	public Element index(int pos)
	{
		if(pos>size)
		{
			System.out.println("error out of range");
			exit(1);
		}
		pos=pos-1;
		Sequence ptr1=start;
		for(i=0;i<pos;i++)
		{
			ptr1=ptr1.next;
		}
		return ptr1.e;			
	}
}
