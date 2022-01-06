package com.svse.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection
{
//	private String driver = "com.mysql.jdbc.Driver";
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/blog?useSSL=false&autoReconnect=true&serverTimezone=GMT";
	private String user = "root";
	private String password = "root";

	private Connection conn = null;

	// Á¬½Ó
	public Connection getConnection()
	{
		try
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}

	// ¹Ø±Õ
	public void closeAll(ResultSet rs, PreparedStatement pre, Connection conn)
	{
		try
		{
			if (rs != null)
			{
				rs.close();
			}
			if (pre != null)
			{
				pre.close();
			}
			if (conn != null)
			{
				conn.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
