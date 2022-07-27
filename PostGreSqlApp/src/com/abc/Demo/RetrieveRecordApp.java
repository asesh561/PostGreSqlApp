package com.abc.Demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.abc.utility.JdbcUtil;

public class RetrieveRecordApp 
{
	private static final String SQL_SELECT_QUERY = "SELECT pid,pname,price,qty FROM PRODUCT";

	public static void main(String[] args)
	{
		//jdbc resources
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet resultSet=null;
		
		try
		{
			connection=JdbcUtil.getDBConnection();
			if(connection!=null)
			{
				pstmt=connection.prepareStatement(SQL_SELECT_QUERY);
				if(pstmt!=null)
				{
					resultSet=pstmt.executeQuery();
					if(resultSet!=null)
					{
						System.out.println("PID PNAME PCOST Quantity");
						while(resultSet.next())
						{
							System.out.println(resultSet.getInt(1)+" "
						+resultSet.getString(2)+" "+ resultSet.getFloat(3)+
						" "+resultSet.getFloat(4));
						}
					}
				}
			}
		}
		catch (SQLException e) {
		e.printStackTrace();	
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			JdbcUtil.close(resultSet, pstmt, connection);
		}
		
	}

}
