package com.j.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j.beans.LoginBean;
import com.j.dao.LoginDao;

@Service
public class LoginService {
	
	@Autowired
	private LoginDao loginDaoImplement2;
	

	public LoginService() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginBean isValidUser(LoginBean _login){
		
		return loginDaoImplement2.isValidUser(_login);
	}

}
