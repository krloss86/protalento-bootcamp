package clase4;

public class CicloWhile {

	public static void main(String[] args) {
		
		short[] edades = new short[] {10,5,25}; // length = 3, pos: 0,1,2 
				
		// 0,1,2 en total 3 pisos
		
		int i = 0;
		
		// 0 < 3
		// 1 < 3
		// 2 < 3
		// 3 < 3 ? NO 
		while(i < edades.length) {
			System.out.println("pos"+ i + ", val:" + edades[i]);			
			i++;
		}
		
		System.out.println("--------------");
		
		i = edades.length - 1;
		
		while( i >= 0 ) {
			System.out.println("pos"+ i + ", val:" + edades[i]);			
			i--;
		}
		
		System.out.println("FIN");
	}

}
