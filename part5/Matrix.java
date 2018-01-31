import java.io.*;

public class Matrix extends Sequence
{
	int rowsize,colsize;
	Sequence ptr;
	public Matrix(int a,int b)
	{
		rowsize=a;
		colsize=b;
		ptr=new Sequence();
		for(int i=0;i<rowsize;i++)
		{
			for(int j=0;j<colsize;j++)
			{
				ptr.add(new MyInteger());
			}
		}
	}
	
	public void Set(int a,int b,int value)
	{
		Sequence temp=ptr.head;
		int count=0;
		while(count<(a*colsize+b))
		{	
			count++;
			temp=temp.next;
		}
		Element m=new MyInteger(value);
		temp.e=m;
	}
	
	public int Get(int a,int b)
	{
		Sequence temp=ptr.head;
		int count=0;
		while(count<(a*colsize+b))
		{
			count++;
			temp=temp.next;
		}
		return ((MyInteger)temp.e).a;
	}

	public Matrix Sum(Matrix matb)
	{
		Matrix sum=new Matrix(rowsize,colsize);
		Sequence temp1=this.ptr.head;
		Sequence temp2=matb.ptr.head;
		Sequence temp3=sum.ptr.head;
		int count=0;
		while(count<(rowsize*colsize))
		{
			count++;
			((MyInteger)temp3.e).a=((MyInteger)temp1.e).a+((MyInteger)temp2.e).a;
			temp1=temp1.next;
			temp2=temp2.next;
			temp3=temp3.next;
		}
		return sum;
	}

	public Matrix Product(Matrix matb)
	{
		Matrix pro=new Matrix(0,0);
		if(this.colsize!=matb.rowsize)
		{
			System.out.println("Matrix dimensions incompatible for Product");
		}
		else
		{
			pro=new Matrix(rowsize,matb.colsize);
			Sequence temp1=this.ptr.head;
			Sequence temp2=matb.ptr.head;
			Sequence temp3=pro.ptr.head;
			Sequence temp11=temp1;
			Sequence temp22=temp2;

			int samp=0;
			
			for(int count0=0;count0<rowsize;count0++)
			{
				for(int count1=0;count1<matb.colsize;count1++)
				{
					for(int i=0;i<colsize;i++)
					{
						samp+=((MyInteger)temp11.e).a*((MyInteger)temp22.e).a;
						temp11=temp11.next;
						for(int j=0;j<matb.colsize;j++)
						{
							if(temp22!=null)
							temp22=temp22.next;
						}
					}
					((MyInteger)temp3.e).a=samp;
					samp=0;
					temp3=temp3.next;
					temp22=temp2;
					for(int n=0;n<count1+1;n++)
					temp22=temp22.next;
					temp11=temp1;
					for(int k=0;k<count0*colsize;k++)
					{
						if(temp11!=null)
						temp11=temp11.next;
					}
				}
				temp11=temp1;
				for(int k=0;k<(count0+1)*colsize;k++)
				{
					if(temp11!=null)
					temp11=temp11.next;
				}
				temp22=temp2;
			}
		}
		return pro;
	}

	public void Print()
	{
		Sequence temp1=this.ptr.head;
		int count=0;
		while(count<(rowsize*colsize))
		{
			if(count%colsize==0)
			System.out.print("[ ");
			System.out.print(((MyInteger)temp1.e).a+" ");
			count++;
			if(count%colsize==0)
			System.out.print("]\n");
			temp1=temp1.next;
			
		}
	}
}
