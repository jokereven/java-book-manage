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
@WebServlet("/MojarServlet")
public class MojarServlet extends HttpServlet
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");

		DeptDAO deptdao = new DeptDAO();
		MojarDAO mojardao = new MojarDAO();
//		System.out.println(action); //all

		if (action.equals("all"))
		{
			List<MojarEntity> ar = mojardao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("mojar/all.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("allp"))
		{
			// 全查询部门----下拉框的内容
			List<DeptEntity> ar = deptdao.getAll();
			request.setAttribute("myallp", ar);
			request.getRequestDispatcher("mojar/add.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("add"))
		{
		// get 专业名 专业备注 pid
			int pid = Integer.parseInt(request.getParameter("pid"));
//			String ename = new String(request.getParameter("ename").getBytes("ISO8859_1"), "utf-8");
			String mname = new String(request.getParameter("mname").getBytes("ISO8859_1"), "utf-8");
			String mremark = new String(request.getParameter("mremark").getBytes("ISO8859_1"), "utf-8");
			MojarEntity mojar = new MojarEntity();
			mojar.setPid(pid);
			mojar.setMname(mname);
			mojar.setMremark(mremark);

			mojardao.addMojar(mojar);
			List<MojarEntity> ar = mojardao.getAll();			
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("mojar/all.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("one"))
		{
			int mid = Integer.parseInt(request.getParameter("mid"));

			MojarEntity mojar = mojardao.getOne(mid);
			List<DeptEntity> ar = deptdao.getAll();

			request.setAttribute("myallp", ar);// 所有部门
			request.setAttribute("myone", mojar);// 当前这个人的信息

			request.getRequestDispatcher("mojar/update.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("upp"))
		{
			int pid = Integer.parseInt(request.getParameter("pid"));
			int mid = Integer.parseInt(request.getParameter("mid"));
			String mname = new String(request.getParameter("mname").getBytes("ISO8859_1"), "utf-8");
			String mremark = new String(request.getParameter("mremark").getBytes("ISO8859_1"), "utf-8");
			MojarEntity mojar = new MojarEntity();
			mojar.setMid(mid);
			mojar.setPid(pid);
			mojar.setMname(mname);
			mojar.setMremark(mremark);
			
			mojardao.updateMojar(mojar);
			List<MojarEntity> ar = mojardao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("mojar/all.jsp").forward(request, response);
		}
		else
		{
			// delete
			int mid = Integer.parseInt(request.getParameter("mid"));
			mojardao.delMojar(mid);

			List<MojarEntity> ar = mojardao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("mojar/all.jsp").forward(request, response);

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

}
