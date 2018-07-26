package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Linkedlist {

	public static void main(String[] args) 
	{
		LinkedList<String> list=new LinkedList<String>();
		list.add("naanvi");
		list.add("hanu");
		list.add("jaya");
		
		 
		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			
		}
		
				
			    System.out.println(list); 
		 list.contains(list.lastIndexOf(2));
		 list.add("loki");
		 list.add(2,"jaasri");
		 System.out.println(list);

		

	}

}
