package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.UserEntity;
import com.svse.util.DBConnection;

public class UserDAO
{

	private DBConnection db;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;

	public UserDAO()
	{
		db = new DBConnection();
	}

	// ²éÑ¯Ò»¸ö
	public UserEntity getOne(int uid)
	{
		UserEntity user = new UserEntity();
		try
		{
			conn = db.getConnection();
			String sql = "select * from userinfo where uid=?";
			pre=conn.prepareStatement(sql);
			pre.setInt(1, uid);
			rs=pre.executeQuery();
			while(rs.next())
			{
				 
				  String uname=rs.getString("uname");
				  String upsw=rs.getString("upsw");
				  user.setUid(uid);
				  user.setUname(uname);
				  user.setUpsw(upsw);
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			db.closeAll(rs, pre, conn);
		}
		return user;
	}
}
