package com.abc.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil
{
	
	public static Connection getDBConnection() throws  SQLException,IOException
	{
		String path="E:\\Advanced Java\\PostGreSqlApp\\src\\com\\abc\\resources\\ConnectionData.properties";
		FileInputStream fis = new FileInputStream(path);
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("jdbc.url");
		String username = p.getProperty("jdbc.username");
		String pwd = p.getProperty("jdbc.password");
		Connection connection= DriverManager.getConnection(url, username, pwd);
		return connection;
	}
	public static void close(ResultSet resultset,Statement statement,Connection connection)
	{
		try
		{
			if(resultset!=null)
			{
				resultset.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		try
		{
			if(statement!=null)
			{
				statement.close();
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		try
		{
			if(connection!=null)
			{
				connection.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	

}
