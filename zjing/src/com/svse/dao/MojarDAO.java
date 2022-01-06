package com.svse.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.svse.entity.*;
import com.svse.util.DBConnection;

public class MojarDAO {
	
	private DBConnection db;
	private PreparedStatement pre = null;
	private ResultSet rs = null;
	private Connection conn = null;

	public MojarDAO()
	{
		db = new DBConnection();
	}
	
	// 全查询
		public List<MojarEntity> getAll()
		{
			List<MojarEntity> ar = new ArrayList<MojarEntity>();
			try
			{
				conn = db.getConnection();
				// mid pid mname mremark
				String sql = "select a.mid,a.pid,a.mname,a.mremark,b.pname from mojarinfo a,deptinfo b where a.pid=b.pid";
				pre = conn.prepareStatement(sql);
				rs = pre.executeQuery();
				while (rs.next())
				{
//					private int mid;
//					private int pid;
//					private String mname;
//					private String mremark;
//					private String pname;
					int mid = rs.getInt("mid");
					int pid = rs.getInt("pid");
					String mname = rs.getString("mname");
					String mremark = rs.getString("mremark");
					String pname = rs.getString("pname");
					MojarEntity mojar = new MojarEntity();
					mojar.setMid(mid);
					mojar.setPid(pid);
					mojar.setMname(mname);
					mojar.setMremark(mremark);;
					mojar.setPname(pname);
					ar.add(mojar);
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
				public void addMojar(MojarEntity mojar)
				{
					try
					{
						conn = db.getConnection();
						String sql = "insert into mojarinfo values(null,?,?,?)";
						pre = conn.prepareStatement(sql);
						pre.setInt(1, mojar.getPid());
						pre.setString(2, mojar.getMname());
						pre.setString(3, mojar.getMremark());
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
				public void delMojar(int mid)
				{
					try
					{
						conn = db.getConnection();
						String sql = "delete from mojarinfo where mid=?";
						pre = conn.prepareStatement(sql);
						pre.setInt(1, mid);
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
				public MojarEntity getOne(int mid)
				{
					MojarEntity mojar = new MojarEntity();
					try

					{
						conn = db.getConnection();
						String sql = "select * from mojarinfo where mid=?";
						pre = conn.prepareStatement(sql);
						pre.setInt(1, mid);
						rs = pre.executeQuery();
						while (rs.next())
						{

							int pid = rs.getInt("pid");
							String mname = rs.getString("mname");
							String mremark = rs.getString("mremark");
						
							mojar.setMid(mid);
							mojar.setPid(pid);
							mojar.setMname(mname);
							mojar.setMremark(mremark);
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
					return mojar;
				}
				
				
				// 修改
				public void updateMojar(MojarEntity mojar)
				{
					try
					{
						conn = db.getConnection();
						String sql = "update mojarinfo set pid=?,mname=?,mremark=? where mid=?";
						pre = conn.prepareStatement(sql);
						pre.setInt(1,mojar.getPid());
						pre.setString(2,mojar.getMname());
						pre.setString(3, mojar.getMremark());
						pre.setInt(4, mojar.getMid());
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
