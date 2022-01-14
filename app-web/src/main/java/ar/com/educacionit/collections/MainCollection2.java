package ar.com.educacionit.collections;

import java.util.LinkedList;
import java.util.ListIterator;

public class MainCollection2 {

	public static void main(String[] args) {
		
		//creo
		LinkedList<String> nombres = new LinkedList<>();  
		//agregar
		nombres.add(new String("edwin"));
		nombres.add(new String("camilo"));
		nombres.add(new String("juan"));
		/*for() {
			
		}*/
		
		//iterator
		
		//ListIterator
		
		ListIterator<String> li = nombres.listIterator();
		
		while(li.hasNext()) {
			String current = li.next();
			System.out.println(current);
		}
		
		while(li.hasPrevious()) {
			String current = li.previous();
			System.out.println(current);
		}
	}
}
