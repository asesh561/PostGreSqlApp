package com.abc.Demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.abc.utility.JdbcUtil;

public class InsertRecordApp 
{
	
	private static final String SQL_INSERT_QUERY = "INSERT INTO PRODUCT(PID,PNAME,PRICE,QTY)VALUES(?,?,?,?)";

	public static void main(String[] args) 
	{
		//jdbc resources used
		Connection connection=null;
		PreparedStatement pstmt=null;
		Scanner scanner=null;
		String pid=null,pname=null,price=null,qty=null;
		try
		{
			connection=JdbcUtil.getDBConnection();
			if(connection!=null)
			{
				pstmt=connection.prepareStatement(SQL_INSERT_QUERY);
				scanner=new Scanner(System.in);
				if(scanner!=null)
				{
					System.out.println("Enter the PID ");
					pid=scanner.next();
					System.out.println("Enter the name of the product");
					pname=scanner.next();
					System.out.println("Enter the Price");
					price=scanner.next();
					System.out.println("Enter the Quantity");
					qty=scanner.next();
				}
				if(pstmt!=null)
				{
					pstmt.setInt(1, Integer.parseInt(pid));
					pstmt.setString(2, pname);
					pstmt.setFloat(3, Float.parseFloat(price));
					pstmt.setFloat(4, Float.parseFloat(qty));
					int rowCount = pstmt.executeUpdate();
					System.out.println("No of records inserted is ::"+rowCount);
				}

			}
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(scanner!=null)
			{
				scanner.close();
			}
			JdbcUtil.close(null, pstmt, connection);
		}

	}

}
