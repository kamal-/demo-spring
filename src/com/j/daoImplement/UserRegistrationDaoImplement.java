package com.j.daoImplement;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.j.beans.UserRegisterBean;
import com.j.dao.UserRegistrationDao;

@Repository
public class UserRegistrationDaoImplement implements UserRegistrationDao {

	@Override
	public boolean registerUser(UserRegisterBean rbean) {
		
		return false;
	}

	@Override
	public String isMsisdnAvailable(String uname) {
		
		return null;
	}

	

	

}
