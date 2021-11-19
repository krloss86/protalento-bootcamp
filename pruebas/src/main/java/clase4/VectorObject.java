package clase4;

public class VectorObject {

	public static void main(String[] args) {
		
		//la base de todos lo tipos de datos en java
		Object edad = 10;
		Object nombres = "carlos";
		Object flag = true;
		Object letra = 'a';
		
		Object[] datos = new Object[] {edad,nombres,flag,letra};
		
		//determinar que datos son de tipo Boolean ???
		for( Object dato : datos ) {
			if(dato instanceof Boolean) {				
				//casteo
				Boolean aux = (Boolean)dato;
				
				//api reflection
				System.out.println("Encontre:" + aux);
			}
		}
	}

}
