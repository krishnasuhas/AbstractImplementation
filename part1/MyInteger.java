import java.io.*;
import java.util.*;

public class MyInteger extends Elements
{
	int a;

	public MyInteger()
	{
		a=0;
	}
	
	public int Get()
	{
		return a;
	}
	
	public void Set(int b)
	{
		a=b;
	}

	public void print()
	{
		System.out.println(" "+a+"");
	}
}
