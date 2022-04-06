package ar.com.educacionit.generic;

import javax.servlet.http.Part;

public abstract class BaseFile {

	protected String filePath;//alt+shit+r
	protected Part filePart;

	public BaseFile(String path) {
		if(path == null) {
			throw new IllegalArgumentException("Debe indicar un path de archivo");
		}
		this.filePath = path;
	}
	
	public BaseFile(Part filePart) {
		if(filePart == null) {
			throw new IllegalArgumentException("Debe ingresar un Part valido");
		}
		this.filePart = filePart;
	}

	public String getFilePath() {
		
		//hay lógica
		if(filePath == null) {
			//uso path por defecto...
		}
		
		return filePath;
	}

}
