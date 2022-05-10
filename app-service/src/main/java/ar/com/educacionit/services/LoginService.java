package ar.com.educacionit.services;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.exceptions.ServiceException;

public interface LoginService {

	Users getUserByUserNameAndPassword(String username,String password) throws ServiceException;
}
