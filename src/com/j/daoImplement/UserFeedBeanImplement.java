package com.j.daoImplement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.j.beans.LoginBean;
import com.j.beans.UserFeedBean;
import com.j.dao.UserFeedDao;

@Repository
public class UserFeedBeanImplement implements UserFeedDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	@Override
	public List<Map<String, Object>> getActiveFeed() {
		Map<Integer,UserFeedBean> returnedUsers=new HashMap<>();
		
		List<Map<String, Object>> m=new ArrayList<>();
		String query="select firstname,age,imgUrl,profileID from web_j_db.activefeed order by id desc limit 20";
		 m=jdbcTemplate.queryForList(query);
		 
		return m;
	}

}
