package  FAQS;

import org.testng.annotations.Test;

public class ABC
{
	private void ABC()
	{
		System.out.println("ABC method");
	}
	public void Hello()
	{
		System.out.println("Hello ABC - I am in Base Class ");
	}
}

class DEF extends ABC
{
	private void DEF()
	{
		System.out.println("DEF Consutructor method");
	}
	public void Hello()
	{
		System.out.println("Hello DEF - I am in Drived class");
	}
	
	@Test
	public static void main() throws Exception 
	{
		ABC  A = new DEF();
		A.Hello();
	}
	
		 
}
	


	
	