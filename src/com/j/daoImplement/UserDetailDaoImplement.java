package com.j.daoImplement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.j.beans.LoginBean;
import com.j.beans.UserDetailBean;
import com.j.dao.UserDetailDao;

public class UserDetailDaoImplement extends JdbcDaoSupport implements UserDetailDao {

private JdbcTemplate jdbcTemplate=null;
	
	@Autowired
	public UserDetailDaoImplement(DataSource source)
	{
		 jdbcTemplate = new JdbcTemplate(source);
	}
	@Override
	public List<Map<String, String>> getUserDetail(final String profileID) {

		String query="select * from web_j_db.userprofile where profileid='?'";
		UserDetailBean returnedUser=(UserDetailBean)jdbcTemplate.execute(query,new PreparedStatementCallback<UserDetailBean>(){  
		    @Override  
		    public UserDetailBean doInPreparedStatement(PreparedStatement ps)  
		            throws SQLException, DataAccessException { 
						ps.setString(0, profileID);
					ResultSet r=	ps.executeQuery();
					UserDetailBean ubean=new UserDetailBean();ubean=null;
					if(r.next())
					{
						ubean.setAddress(r.getString("address"));
						ubean.setAge(r.getInt("age"));
						ubean.setImgUrl(r.getString("imgUrl"));
						ubean.setName(r.getString("firstname"));
						ubean.setSurName(r.getString("lastname"));
						ubean.setProfileID(profileID);
						ubean.setLastVisit(r.getDate("lvisitdate"));
						ubean.setAddress(r.getString("town")+","+r.getString("state")+","+r.getString("country"));
						ubean.setMonumber(r.getInt("msisdn"));
						//ubean.setDuration(r.getInt(""));
					}
					return ubean;
			}
			});
		return null;
	}

}
