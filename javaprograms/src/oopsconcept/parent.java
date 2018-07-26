package oopsconcept;

public class parent
{
	int workhard()
	{
		System.out.println("wake up early go to college");
		return 10;
	}
	float care()
	{
		System.out.println("utmost care");
		return 10.5f;
	}


	public static void main(String[] args)
	{
		parent p=new parent();
		p.workhard();
		
		Child c=new Child();
		c.workhard();
				
	}

}
