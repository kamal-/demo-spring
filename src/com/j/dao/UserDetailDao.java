package com.j.dao;

import java.util.List;
import java.util.Map;

public interface UserDetailDao {

	public List<Map<String,String>> getUserDetail(String profileID);
}
