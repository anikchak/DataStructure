package practice.javaconcepts;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class JavaConcepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		B b = new B();
		A aVar = new B();
		aVar.i = 10;
		//aVar.j =10 - this member will not be visible as the reference variable is of superclass
		aVar.aMethod();
		// aVar.bMethod(); - this method will not be visible as the reference variable is of superclass
		//b.aMethod();
		//Method Overriding example -  for method overriding OBJECT is considered. For other purposes, reference variables is considered
		A obj;
		obj = a;
		a.show();
		
		obj = b;
		b.show();
		
		/*
		 * Hashtable interation
		 */
		Hashtable<Integer,Integer> ht = new Hashtable<Integer, Integer>();
		ht.put(1,2);
		ht.put(3,4);
		ht.put(5,6);
		System.out.println("Hashtable iteration using set");
		Set<Integer> s = ht.keySet();
		Iterator<Integer> itr = s.iterator();
		while(itr.hasNext()){
			Integer key = itr.next();
			Integer val = ht.get(key);
			System.out.println(key+"->"+val);
		}
		
		System.out.println("Hashtable iteration using Enumerations");
		Enumeration<Integer> e = ht.keys();
		while(e.hasMoreElements()){
			Integer key = e.nextElement();
			int val = ht.get(key);
			System.out.println(key+"=>"+val);
		}
		
	}

}
