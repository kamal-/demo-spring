package com.j.dao;

import java.util.List;
import java.util.Map;

import com.j.beans.UserFeedBean;

public interface UserFeedDao {

	public List<Map<String, Object>> getActiveFeed();
}
