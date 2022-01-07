package ar.com.educacionit.dao.exceptions;

/**
 * una checked exeption
 *
 */
public class DuplicatedException extends Exception {

	public DuplicatedException(String message, Throwable cause) {
		super(message, cause);
	}

}
