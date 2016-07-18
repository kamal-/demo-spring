package com.j.daoImplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.j.beans.LoginBean;
import com.j.common.ConnectionFactory;
import com.j.common.DaoService;
import com.j.dao.LoginDao;

public class LoginDaoImplement extends JdbcDaoSupport implements LoginDao{

	private JdbcTemplate jdbcTemplate=null;
	
	@Autowired
	public LoginDaoImplement(DataSource source)
	{
		 jdbcTemplate = new JdbcTemplate(source);
	}
	@Override
	public boolean isValidUser(LoginBean lbean) {
		
		boolean i=false;
		System.out.println(new String(lbean.getPassword())+"----------------"+lbean.getUsername());
		String query="select * from web_j_db.account where username='"+lbean.getUsername()+"' and password=sha2('"+new String(lbean.getPassword())+"',256)";
		LoginBean returnedUser=(LoginBean)jdbcTemplate.query(query,new ResultSetExtractor<LoginBean>() {
			@Override
	        public LoginBean extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
				LoginBean bean=new LoginBean();
				System.out.println("Calling.....");
				if (rs.next()) {
	            	System.out.println("---------Working------------");
	            	bean.setUsername(rs.getString("username"));
	            	bean.setPassword(rs.getString("password").toCharArray());
	            }
	            return bean;
	            }
		});
		return i;
	}

}

/*public class LoginDaoImplement implements LoginDao{

	private static ConnectionFactory con=ConnectionFactory.getInstance();
	private static Connection connection=con.getConnection();
	

	@Override
	public boolean isValidUser(LoginBean lbean) {
		

		boolean i=false;
		System.out.println(new String(lbean.getPassword())+"----------------"+lbean.getUsername());
		String query="select * from web_j_db.account where username='?' and password=sha2('"+new String(lbean.getPassword())+"',256)";
		PreparedStatement st;
		try {
			st = connection.prepareStatement(query);
			st.setString(0, lbean.getUsername());
			if(st!=null)
				st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return i;
	}

}*/
