package ar.com.educacionit.services.impl;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.impl.SocioDaoImpl;
import ar.com.educacionit.dao.impl.UserDaoImpl;
import ar.com.educacionit.domain.Users;
import ar.com.educacionit.services.LoginService;
import ar.com.educacionit.services.exceptions.ServiceException;

public class LoginServiceImpl implements LoginService {

	private UserDao userDao;
	private SociosDao socioDao;
	
	public LoginServiceImpl() {
		this.userDao = new UserDaoImpl();
		this.socioDao = new SocioDaoImpl();
	}
	
	@Override
	public Users getUserByUserName(String username) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
