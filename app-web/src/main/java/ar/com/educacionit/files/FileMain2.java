package ar.com.educacionit.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileMain2 {

	public static void main(String[] args) throws IOException {
		
		File aFile = new File("c:/carpeta/binario.docx");//puntero

		if(aFile.exists()) {
			
			InputStream is = new FileInputStream(aFile);
			OutputStream os = new FileOutputStream("c:/carpeta/binarioCopia.docx");
			
			int length;
			byte[] buffer = new byte[1024];
			
			while((length = is.read(buffer)) > 0) {
				os.write(buffer,0,length);
			}
			
			is.close();
			os.close();
		}
	}

}
