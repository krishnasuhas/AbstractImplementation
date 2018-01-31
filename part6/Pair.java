import java.io.*;

public class Pair
{
	MyChar k;
	Element v;

	public Pair()
	{
		k=new MyChar();
		v=new MyInteger();
	}

	public Pair(MyChar a,Element b)
	{
		k=a;
		v=b;
	}
	
	public void Print()
	{
		System.out.print("(");
		k.Print();
		v.Print();
		System.out.print(")");
	}
}
