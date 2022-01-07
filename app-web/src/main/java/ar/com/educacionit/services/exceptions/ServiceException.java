package ar.com.educacionit.services.exceptions;

public class ServiceException extends Exception {
											/*GenericException
											  DuplicatedException*/
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	//otro constructor que reciba la GenericException
}
