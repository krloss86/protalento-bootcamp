package ar.com.educacionit.collections.list;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapEntryMain {

	public static void main(String[] args) {

		Map<Integer, String> dias = new HashMap<>();

		dias.put(1, "Lunes");
		dias.put(2, "Martes");

		dias.keySet();//las claves
		dias.values();//values
		Set<Entry<Integer,String>> entries = dias.entrySet();
		
		Iterator<Entry<Integer,String>> itEntries = entries.iterator();
		Entry<Integer,String> entry = null;
		while(itEntries.hasNext()) {
			entry = itEntries.next();
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		System.out.println(entry);
		System.out.println(itEntries.hasNext());
		itEntries = entries.iterator();
		System.out.println(itEntries.hasNext());
	}

}
