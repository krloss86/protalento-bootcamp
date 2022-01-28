package ar.com.educacionit.files;

import java.io.File;

public class FileMain {

	public static void main(String[] args) {
		
		File aFile = new File("c:/carpeta");//puntero

		boolean exists = aFile.exists();
		
		System.out.println(exists);
		
		System.out.println(aFile.isDirectory());		
		
		//INVESTIGAR ALGORITMO RECURSIVO PARA MOSTRAR LOS ARCHIVOS DE LAS CARPETAS
		// TIENA CASO BASE
		System.out.println(aFile.isFile());
	}
	
	public File recorrer(File f) {
		
		if(!f.isDirectory()) {//SI NO ES UN DIRECTORIO
			System.out.println(f.getName());
		}
		//....
		
		return f;
	}

}
