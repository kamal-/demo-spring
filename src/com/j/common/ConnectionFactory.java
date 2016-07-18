package com.j.common;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory implements DaoService {

	private static javax.naming.Context ctx;
	private static DataSource ds;
	private static Connection connection;
	private static ConnectionFactory connFactory;
	
	public ConnectionFactory(){
		
	}
	public Connection getConnection() {
		Properties props = new Properties();
		props.setProperty(Context.INITIAL_CONTEXT_FACTORY,
				"com.mysql.jdbc.Driver");
		props.setProperty(Context.PROVIDER_URL, "jdbc:mysql://localhost:3306");
		try {
			ctx = new InitialContext(props);
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/");
			connection = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}



	@Override
	public Exception clone() {
		return new Exception();
	}

	public static ConnectionFactory getInstance() {
		synchronized (ConnectionFactory.class) {
			if (connFactory == null)
				// connFactory=(ConnectionFactory)ctx.lookup("connectionFactory");
				connFactory = new ConnectionFactory();
		}
		return connFactory;
	}
}
