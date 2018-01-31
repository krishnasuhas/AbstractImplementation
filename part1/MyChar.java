import java.io.*;
import java.util.*;

public class MyChar extends Elements
{
	char a;

	public MyChar()
	{
		a='0';
	}
	
	public char Get()
	{
		return a;
	}
	
	public void Set(char b)
	{
		a=b;
	}

	public void print()
	{
		System.out.println("'"+a+"'");
	}
}
