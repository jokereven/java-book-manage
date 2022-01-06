package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.*;
import com.svse.util.DBConnection;

public class MyclassDAO {
	

	private DBConnection db;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;

	public MyclassDAO()
	{
		db = new DBConnection();
	}

	
	// 全查询
	public List<MyclassEntity> getAll()
	{
		List<MyclassEntity> ar = new ArrayList<MyclassEntity>();
//		List<MojarEntity> mojarar = new ArrayList<MojarEntity>();
//		List<GradeEntity> gradear = new ArrayList<GradeEntity>();
		try
		{
			conn = db.getConnection();
			// pid eid pname ename 
			// a mojarinfo b gradeinfo c myclassinfo
//			String sql = "select * from myclassinfo";
			String sql = "select c.cid,c.mid,c.gid,c.mname,c.mremark,b.mname,a.mname from mojarinfo a, gradeinfo b ,myclassinfo c where a.mid=c.mid and b.gid = c.gid";
			pre = conn.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next())
			{
//				private int cid;
//				private int mid;
//				private String mname;
//				private int gid;
//				private String mremark;
				int cid = rs.getInt("cid");
				int mid = rs.getInt("mid");
				String mname = rs.getString("mname");
				String mremark = rs.getString("mremark");
				String mojarmname = rs.getString("a.mname");
				String grademname = rs.getString("b.mname");
				MyclassEntity myclass = new  MyclassEntity();
				myclass.setCid(cid);
				myclass.setGid(mid);
				myclass.setMid(mid);
				myclass.setMname(mname);
				myclass.setMremark(mremark);
				myclass.setMojarmname(mojarmname);
				myclass.setGrademname(grademname);
				ar.add(myclass);
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
			public void addMyclass(MyclassEntity myclass)
			{
				try
				{
					conn = db.getConnection();
					String sql = "insert into myclassinfo values(null,?,?,?,?)";
					pre = conn.prepareStatement(sql);
					pre.setInt(1, myclass.getMid());
					pre.setInt(2, myclass.getGid());
					pre.setString(3, myclass.getMname());
					pre.setString(4, myclass.getMremark());
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
			public void delMyclass(int cid)
			{
				try
				{
					conn = db.getConnection();
					String sql = "delete from myclassinfo where cid=?";
					pre = conn.prepareStatement(sql);
					pre.setInt(1, cid);
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
			public MyclassEntity getOne(int cid)
			{
				MyclassEntity myclass = new MyclassEntity();
				try

				{
					conn = db.getConnection();
					String sql = "select * from myclassinfo where cid=?";
					pre = conn.prepareStatement(sql);
					pre.setInt(1, cid);
					rs = pre.executeQuery();
					while (rs.next())
					{
						int mid = rs.getInt("mid");
						int gid = rs.getInt("gid");
						String mname = rs.getString("mname");
						String mremark = rs.getString("mremark");
						myclass.setCid(cid);
						myclass.setMid(mid);
						myclass.setGid(gid);
						myclass.setMname(mname);
						myclass.setMremark(mremark);
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
				return myclass;
			}
			
			
			// 修改
			public void updateMyclass(MyclassEntity myclass)
			{
				try
				{
					conn = db.getConnection();
					String sql = "update myclassinfo set mid=?,gid=?,mname=?,mremark=? where cid=?";
					pre = conn.prepareStatement(sql);
					pre.setInt(1, myclass.getMid());
					pre.setInt(2, myclass.getGid());
					pre.setString(3, myclass.getMname());
					pre.setString(4, myclass.getMremark());
					pre.setInt(5,myclass.getCid());
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
