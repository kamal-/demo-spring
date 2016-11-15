package com.j.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.j.dao.UserFeedDao;


@Service
public class UserFeedBeanService {

	@Autowired
	private UserFeedDao userFeedBeanDaoImplement;
	public UserFeedBeanService() {
		// TODO Auto-generated constructor stub
	}
	public List<Map<String, Object>> getActiveFeed() {
		return userFeedBeanDaoImplement.getActiveFeed();
	}
}
