package com.j.dao;

import com.j.beans.UserDetailBean;
import com.j.beans.UserRegisterBean;

public interface UserRegistrationDao {

	public boolean registerUser(UserRegisterBean rbean);
	public String isMsisdnAvailable(String uname);

}
