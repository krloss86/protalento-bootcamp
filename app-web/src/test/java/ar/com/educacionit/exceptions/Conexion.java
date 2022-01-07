package ar.com.educacionit.exceptions;

public class Conexion {

	private boolean open;
	private boolean err;
	
	public void open() throws ConnectionIsAlreadyOpenException {
		if(open) {
			throw new ConnectionIsAlreadyOpenException();
		}else {
			open = true;
		}
	}
	
	public void close() throws ConnectionIsNotOpenException {
		if(!open) {
			throw new ConnectionIsNotOpenException();
		}else {
			open = false;
		}
	}
	
	public void commit() {
		
		if(!open) {
			throw new CommitException("Error: connection close");
		}
		
		if(err) {
			throw new CommitException("Error:");
		}
		
		System.out.println("Commiting changes");
	}
	
	public void rollback() {
		
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isErrr() {
		return err;
	}

	public void setErrr(boolean errro) {
		this.err = errro;
	}
	
}
