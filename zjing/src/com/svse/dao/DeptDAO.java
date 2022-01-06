package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.*;
import com.svse.util.DBConnection;

public class DeptDAO
{

	private DBConnection db;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;

	public DeptDAO()
	{
		db = new DBConnection();
	}

	// 全查询
	public List<DeptEntity> getAll()
	{
		List<DeptEntity> ar = new ArrayList<DeptEntity>();
		try
		{
			conn = db.getConnection();
			// pid eid pname ename 
			String sql = "select a.pid,a.eid,a.pname,b.ename from deptinfo a,collegeinfo b where a.eid=b.eid";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{
//				private int eid;
//				private String ename;
//				private int pid;
//				private String pname;
				int pid = rs.getInt("pid");
				int eid = rs.getInt("eid");
				String pname = rs.getString("pname");
				String ename = rs.getString("ename");
				DeptEntity dept = new DeptEntity();
				dept.setPid(pid);
				dept.setEid(eid);
				dept.setEname(ename);
				dept.setPname(pname);
				ar.add(dept);
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
		public void addDept(DeptEntity dept)
		{
			try
			{
				conn = db.getConnection();
				String sql = "insert into deptinfo values(null,?,?)";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, dept.getEid());
				pre.setString(2, dept.getPname());
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
		// 删除
		public void delDept(int pid)
		{
			try
			{
				conn = db.getConnection();
				String sql = "delete from deptinfo where pid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, pid);
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
		public DeptEntity getOne(int pid)
		{
			DeptEntity dept = new DeptEntity();
			try

			{
				conn = db.getConnection();
				String sql = "select * from deptinfo where pid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, pid);
				rs = pre.executeQuery();
				while (rs.next())
				{

					int eid = rs.getInt("eid");
					String pname = rs.getString("pname");

					dept.setPid(pid);
					dept.setEid(eid);
					dept.setPname(pname);
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
			return dept;
		}

		// 修改
		public void updateDept(DeptEntity dept)
		{
			try
			{
				conn = db.getConnection();
				String sql = "update deptinfo set eid=?,pname=? where pid=?";
				pre = conn.prepareStatement(sql);
				pre.setInt(1, dept.getEid());
				pre.setString(2, dept.getPname());
				pre.setInt(3, dept.getPid());
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