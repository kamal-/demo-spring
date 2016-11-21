package com.j.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j.beans.UserDetailBean;
import com.j.dao.UserDetailDao;

@Service
public class UserDetailService {

	@Autowired
	private UserDetailDao userDetailDaoImplement;
	public UserDetailService() {
		// TODO Auto-generated constructor stub
	}

	public Map<String, Object> getUserDetail(final String profileID) {
		return userDetailDaoImplement.getUserDetail(profileID);
	}
	public boolean updateUserDetails(UserDetailBean userDetailBean){
		return true;
	}
}
