package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.svse.entity.CollegeEntity;
import com.svse.util.DBConnection;

public class CollegeDAO {
	
	private DBConnection db;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;

	public CollegeDAO()
	{
		db = new DBConnection();
	}
	
	// 增加
	public void addColl(CollegeEntity college)
	{
		try
		{
			conn = db.getConnection();
			String sql="insert into collegeinfo values(null,?,?)";
			pre=conn.prepareStatement(sql);
			pre.setString(1, college.getEname());
			pre.setString(2, college.getEremark());
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

	// 全查询
	public List<CollegeEntity> getAll()
	{
		List<CollegeEntity> ar = new ArrayList<CollegeEntity>();
		try
		{
			conn = db.getConnection();
			String sql = "select * from collegeinfo";
			pre=conn.prepareStatement(sql);
			rs=pre.executeQuery();
			while(rs.next())
			{
				  int eid=rs.getInt("eid");
				  String ename=rs.getString("ename");
				  String eremark=rs.getString("eremark");
				  
				  
				  CollegeEntity coll=new CollegeEntity();
				  coll.setEid(eid);
				  coll.setEname(ename);
				  coll.setEremark(eremark);
				  
				  ar.add(coll);
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

	// 修改
		public void updateColl(CollegeEntity coll)
		{
			try
			{
				conn = db.getConnection();
				String sql="update collegeinfo set ename=?,eremark=? where eid=?";
				pre=conn.prepareStatement(sql);
				pre.setString(1, coll.getEname());
				pre.setString(2, coll.getEremark());
				pre.setInt(3,coll.getEid());
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
		public CollegeEntity getOne(int eid)
		{
			CollegeEntity coll = new CollegeEntity();
			try
			{
				conn = db.getConnection();
				String sql = "select * from collegeinfo where eid=?";
				pre=conn.prepareStatement(sql);
				pre.setInt(1, eid);
				rs=pre.executeQuery();
				while(rs.next())
				{
					 
					  String ename=rs.getString("ename");
					  String eremark=rs.getString("eremark");
					  
					  coll.setEid(eid);;
					  coll.setEname(ename);
					  coll.setEremark(eremark);
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
	
}
