package ar.com.educacionit.collections.list;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapStringMain {

	public static void main(String[] args) {

		//Collection<Integer> edades = new ArrayList<>(); 
		
		Map<Integer, String> dias = new HashMap<>();
		
		//agregar elementos put(integer,string)
		dias.put(1, "Lunes");
		dias.put(2, "Martes");
		dias.put(3, "Miercoles");
		dias.put(4, "Jueves");
		dias.put(5, "Viernes");
		dias.put(6, "Sabado");
		dias.put(7, "Domingo");
		//dias.put(7, "Osvaldo");
//		dias.put(1321321,"asdkañs{ldkañlsdkñlaskd");
		
		//obtengo un elemento del mapa
		String diaStr = dias.get(7);
		
		//System.out.println(dias);
		
		//obtener todas las claves de un mapa
		
		//keyset del mapa
		Set<Integer> keySet = dias.keySet();
		
		for(Integer key : keySet) {
			//ahora puedo tomar del mapa
			String value = dias.get(key);
			System.out.println(key + "-"+value);
		}
		
		//recorrer solo los valores
		Collection<String> values = dias.values();
		for(String value : values) {
			System.out.println(value + "-" + dias.containsValue(value) );
		}
		
		System.err.println("-----------------");
		//EntrySet
		Set<Map.Entry<Integer, String>> entrySet =  dias.entrySet();
		for(Map.Entry<Integer, String> entry : entrySet) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
			//System.out.println(entry);
		}
	}

}
