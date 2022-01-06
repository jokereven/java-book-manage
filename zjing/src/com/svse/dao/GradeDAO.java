package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.*;
import com.svse.util.DBConnection;

public class GradeDAO {
	
	private DBConnection db;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;

	public GradeDAO()
	{
		db = new DBConnection();
	}
	
	// 全查询
	public List<GradeEntity> getAll()
	{
		List<GradeEntity> ar = new ArrayList<GradeEntity>();
		try
		{
			conn = db.getConnection();
			String sql = "select * from gradeinfo";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{
				int gid = rs.getInt("gid");
				String mname = rs.getString("mname");
				String mremark = rs.getString("mremark");
				GradeEntity grade = new GradeEntity();
				grade.setGid(gid);
				grade.setMname(mname);
				grade.setMremark(mremark);
				ar.add(grade);
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
		return ar;
	}
	
	// 增加
	public void addGrade(GradeEntity grade)
	{
		try
		{
			conn = db.getConnection();
			String sql="insert into gradeinfo values(null,?,?)";
			pre=conn.prepareStatement(sql);
			pre.setString(1, grade.getMname());
			pre.setString(2, grade.getMremark());
			pre.executeUpdate();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			db.closeAll(rs, pre, conn);
		}
	}
	
	// 查询一个
	public GradeEntity getOne(int gid)
	{
		GradeEntity coll = new GradeEntity();
		try
		{
			conn = db.getConnection();
			String sql = "select * from gradeinfo where gid=?";
			pre=conn.prepareStatement(sql);
			pre.setInt(1, gid);
			rs=pre.executeQuery();
			while(rs.next())
			{
				 
				  String mname=rs.getString("mname");
				  String mremark=rs.getString("mremark");
				  
				  coll.setGid(gid);;
				  coll.setMname(mname);
				  coll.setMremark(mremark);
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
		return coll;
	}
	
	// 修改
	public void updateGrade(GradeEntity grade)
	{
		try
		{
			conn = db.getConnection();
			String sql="update gradeinfo set mname=?,mremark=? where gid=?";
			pre=conn.prepareStatement(sql);
			pre.setString(1, grade.getMname());
			pre.setString(2, grade.getMremark());
			pre.setInt(3,grade.getGid());
			pre.executeUpdate();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			db.closeAll(rs, pre, conn);
		}
	}
	

}
