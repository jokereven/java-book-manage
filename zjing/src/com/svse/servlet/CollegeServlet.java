package com.svse.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.dao.CollegeDAO;
import com.svse.entity.CollegeEntity;

@WebServlet("/CollegeServlet")
public class CollegeServlet extends HttpServlet
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		CollegeDAO dao = new CollegeDAO();

		String action = request.getParameter("action");
		if (action.equals("all"))
		{

			List<CollegeEntity> ar = dao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("college/all.jsp").forward(request, response);
		}
		else if (action.equals("add"))
		{
			String ename = new String(request.getParameter("ename").getBytes("iso8859_1"), "UTF-8");
			String eremark = new String(request.getParameter("eremark").getBytes("iso8859_1"), "UTF-8");
			CollegeEntity coll = new CollegeEntity();
			coll.setEname(ename);
			coll.setEremark(eremark);
			dao.addColl(coll);
			List<CollegeEntity> ar = dao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("college/all.jsp").forward(request, response);
		}
		else if (action.equals("one"))
		{
			int eid = Integer.parseInt(request.getParameter("eid"));

			CollegeEntity coll = dao.getOne(eid);
			request.setAttribute("myone", coll);
			request.getRequestDispatcher("college/update.jsp").forward(request, response);
		}
		else
		{
			String ename = new String(request.getParameter("ename").getBytes("iso8859_1"), "UTF-8");
			String eremark = new String(request.getParameter("eremark").getBytes("iso8859_1"), "UTF-8");
			int eid = Integer.parseInt(request.getParameter("eid"));
			CollegeEntity coll = new CollegeEntity();
			coll.setEname(ename);
			coll.setEremark(eremark);
			coll.setEid(eid);
			dao.updateColl(coll);
			
			List<CollegeEntity> ar = dao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("college/all.jsp").forward(request, response);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

}
