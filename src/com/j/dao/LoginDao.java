package com.j.dao;

import com.j.beans.LoginBean;

public interface LoginDao {

	public boolean isValidUser(LoginBean lbean);
}
