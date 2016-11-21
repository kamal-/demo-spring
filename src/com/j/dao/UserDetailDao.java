package com.j.dao;


import java.util.Map;

import com.j.beans.UserDetailBean;

public interface UserDetailDao {

	public Map<String, Object> getUserDetail(String profileID);
	public boolean updateUserDetails(UserDetailBean userDetailBean);
	
}
