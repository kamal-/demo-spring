package com.j.daoImplement;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.j.beans.UserRegisterBean;
import com.j.dao.UserRegistrationDao;

public class UserRegistrationDaoImplement extends JdbcDaoSupport implements UserRegistrationDao {

	@Override
	public boolean registerUser(UserRegisterBean rbean) {
		
		return false;
	}

	@Override
	public String isMsisdnAvailable(String uname) {
		
		return null;
	}

	

	

}
