package com.j.daoImplement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;


import com.j.beans.UserDetailBean;
import com.j.dao.UserDetailDao;

@Repository
public class UserDetailDaoImplement implements UserDetailDao {

	@Autowired
private JdbcTemplate jdbcTemplate;
	
	@Override
	public Map<String, Object> getUserDetail(final String profileID) {

		String query="select imgUrl,firstname,lastname,age,lvisitdate,state,city,zip,lastname,age,"
				+ "lvisitdate,state,city,zip,town,country,countrycode,"
				+ "nextvisitdate,msisdn,status from web_j_db.userprofile where profileid=?";
		Map<String,Object> l=new HashMap<>();
		UserDetailBean returnedUser=(UserDetailBean)jdbcTemplate.execute(query,new PreparedStatementCallback<UserDetailBean>(){  
		    @Override  
		    public UserDetailBean doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException { 
						ps.setString(1, profileID);
					ResultSet r=	ps.executeQuery();
					final Map<String, String> usermap=new HashMap<String, String>();
					UserDetailBean ubean=new UserDetailBean();
					if(r.next())
					{
						ubean.setAge(r.getInt("age"));
						ubean.setImgUrl(r.getString("imgUrl"));
						ubean.setName(r.getString("firstname"));
						ubean.setSurName(r.getString("lastname"));
						ubean.setProfileID(profileID);
						ubean.setLastVisit(r.getDate("lvisitdate"));
						ubean.setAddress(r.getString("town")+","+r.getString("state")+","+r.getString("country")+","+r.getInt("countrycode"));
						ubean.setMonumber(r.getLong("msisdn"));
						ubean.setNextvisitDate(r.getDate("nextvisitdate"));
						ubean.setStatus(r.getString("status"));

					}
					return ubean;
			}
			});
		l.put("user", returnedUser);
		return l;
	}

}
