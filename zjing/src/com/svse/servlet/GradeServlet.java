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

@WebServlet("/GradeServlet")
public class GradeServlet extends HttpServlet
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		GradeDAO dao = new GradeDAO();

		String action = request.getParameter("action");
		if (action.equals("all"))
		{

			List<GradeEntity> ar = dao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("grade/all.jsp").forward(request, response);
		}
		else if (action.equals("add"))
		{
			String mname = new String(request.getParameter("mname").getBytes("iso8859_1"), "UTF-8");
			String mremark = new String(request.getParameter("mremark").getBytes("iso8859_1"), "UTF-8");
			GradeEntity coll = new GradeEntity();
			coll.setMname(mname);
			coll.setMremark(mremark);
			dao.addGrade(coll);
			List<GradeEntity> ar = dao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("grade/all.jsp").forward(request, response);
		}
		else if (action.equals("one"))
		{
			int gid = Integer.parseInt(request.getParameter("gid"));

			GradeEntity coll = dao.getOne(gid);
			request.setAttribute("myone", coll);
			request.getRequestDispatcher("grade/update.jsp").forward(request, response);
		}
		else
		{
			String mname = new String(request.getParameter("mname").getBytes("iso8859_1"), "UTF-8");
			String mremark = new String(request.getParameter("mremark").getBytes("iso8859_1"), "UTF-8");
			int gid = Integer.parseInt(request.getParameter("gid"));
			GradeEntity coll = new GradeEntity();
			coll.setMname(mname);
			coll.setMremark(mremark);
			coll.setGid(gid);
			dao.updateGrade(coll);
			
			List<GradeEntity> ar = dao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("grade/all.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

}
