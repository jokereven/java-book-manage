package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.*;
import com.svse.entity.*;

/**
 * Servlet implementation class EmpServlet
 */
@WebServlet("/DeptServlet")
public class DeptServlet extends HttpServlet
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");

		DeptDAO deptdao = new DeptDAO();
		CollegeDAO colldao = new CollegeDAO();
//		System.out.println(action); all

		if (action.equals("all"))
		{
			List<DeptEntity> ar = deptdao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("dept/all.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("allp"))
		{
			// 全查询部门----下拉框的内容
			List<CollegeEntity> ar = colldao.getAll();
			request.setAttribute("myallp", ar);
			request.getRequestDispatcher("dept/add.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("add"))
		{
			// get 学院名 系别名
			int eid = Integer.parseInt(request.getParameter("eid"));
//			String ename = new String(request.getParameter("ename").getBytes("ISO8859_1"), "utf-8");
			String pname = new String(request.getParameter("pname").getBytes("ISO8859_1"), "utf-8");
			DeptEntity dept = new DeptEntity();
			dept.setEid(eid);
			dept.setPname(pname);

			deptdao.addDept(dept);
			List<DeptEntity> ar = deptdao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("dept/all.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("one"))
		{
			int pid = Integer.parseInt(request.getParameter("pid"));

			DeptEntity dept = deptdao.getOne(pid);
			List<CollegeEntity> ar = colldao.getAll();

			request.setAttribute("myallp", ar);// 所有部门
			request.setAttribute("myone", dept);// 当前这个人的信息

			request.getRequestDispatcher("dept/update.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("upp"))
		{
			int pid = Integer.parseInt(request.getParameter("pid"));
			int eid = Integer.parseInt(request.getParameter("eid"));
			String pname = new String(request.getParameter("pname").getBytes("ISO8859_1"), "utf-8");
			DeptEntity dept = new DeptEntity();
			dept.setPid(pid);
			dept.setEid(eid);
			dept.setPname(pname);

			deptdao.updateDept(dept);
			List<DeptEntity> ar = deptdao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("dept/all.jsp").forward(request, response);
		}
		else
		{
			// delete
			int pid = Integer.parseInt(request.getParameter("pid"));
			deptdao.delDept(pid);

			List<DeptEntity> ar = deptdao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("dept/all.jsp").forward(request, response);

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

}
