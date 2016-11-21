package com.j.daoImplement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.j.beans.UserDetailBean;
import com.j.beans.VisitRecordsBean;
import com.j.dao.VisitRecordsDao;

@Repository
public class VisitRecordsDaoImplement implements VisitRecordsDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	
	@Override
	public List<Map<String, Object>> getRecords(final String profileID) {
		String query="select appdate,attachement,notes from web_j_db.userappointdetail where profileid=?";
		Map<String,Object> l=new HashMap<>();
		List<Map<String,Object>> returnedUser=jdbcTemplate.queryForList(query,new Object[]{profileID});
//		l.put("user", returnedUser);
		return returnedUser;
	}

}
