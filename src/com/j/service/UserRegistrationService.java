package com.j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j.beans.UserRegisterBean;
import com.j.dao.UserRegistrationDao;

@Service
public class UserRegistrationService {

	@Autowired
	private UserRegistrationDao userRegistrationDaoImpement;
	public UserRegistrationService() {
		// TODO Auto-generated constructor stub
	}
	public boolean registerUser(UserRegisterBean rbean) {
		return userRegistrationDaoImpement.registerUser(rbean);
	}
	public String isMsisdnAvailable(String uname) {
		return userRegistrationDaoImpement.isMsisdnAvailable(uname);
	}
}
