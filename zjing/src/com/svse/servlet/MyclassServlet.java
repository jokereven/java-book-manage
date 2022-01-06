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
@WebServlet("/MyclassServlet")
public class MyclassServlet extends HttpServlet
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String action = request.getParameter("action");

		MojarDAO mojardao = new MojarDAO();
		GradeDAO gradedao = new GradeDAO();
		MyclassDAO myclassdao = new MyclassDAO();
//		System.out.println(action); all

		if (action.equals("all"))
		{
			List<MyclassEntity> ar = myclassdao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("myclass/all.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("allp"))
		{
			// 全查询部门----下拉框的内容
			List<MojarEntity> mojarar = mojardao.getAll();
			List<GradeEntity> gradear = gradedao.getAll();
			request.setAttribute("mojarallp", mojarar);
			request.setAttribute("gradeallp", gradear);
			request.getRequestDispatcher("myclass/add.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("add"))
		{
//			 get mid gid cid mname mremark
			int mid = Integer.parseInt(request.getParameter("mid"));
			int gid = Integer.parseInt(request.getParameter("gid"));
//			int cid = Integer.parseInt(request.getParameter("cid"));
			String mname = new String(request.getParameter("mname").getBytes("ISO8859_1"), "utf-8");
			String mremark = new String(request.getParameter("mremark").getBytes("ISO8859_1"), "utf-8");
			MyclassEntity myclass = new MyclassEntity();
			myclass.setMid(mid);
			myclass.setGid(gid);
//			myclass.setCid(cid);
			myclass.setMname(mname);
			myclass.setMremark(mremark);
			
			myclassdao.addMyclass(myclass);;
			List<MyclassEntity> ar = myclassdao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("myclass/all.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("one"))
		{
			int cid = Integer.parseInt(request.getParameter("cid"));

			MyclassEntity myclass = myclassdao.getOne(cid);
			List<MojarEntity> mojarar = mojardao.getAll();
			List<GradeEntity> gradear = gradedao.getAll();

			request.setAttribute("mojarallp", mojarar);
			request.setAttribute("gradeallp", gradear);
			request.setAttribute("myone", myclass);// 当前这个人的信息

			request.getRequestDispatcher("myclass/update.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("upp"))
		{
			int cid = Integer.parseInt(request.getParameter("cid"));
			int mid = Integer.parseInt(request.getParameter("mid"));
			int gid = Integer.parseInt(request.getParameter("gid"));
			String mname = new String(request.getParameter("mname").getBytes("ISO8859_1"), "utf-8");
			String mremark = new String(request.getParameter("mremark").getBytes("ISO8859_1"), "utf-8");
			
			MyclassEntity myclass = new MyclassEntity();
			myclass.setCid(cid);
			myclass.setMid(mid);
			myclass.setGid(gid);
			myclass.setMname(mname);
			myclass.setMremark(mremark);

			myclassdao.updateMyclass(myclass);
			List<MyclassEntity> ar = myclassdao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("myclass/all.jsp").forward(request, response);
		}
		else
		{
			// delete
			int cid = Integer.parseInt(request.getParameter("cid"));
			myclassdao.delMyclass(cid);

			List<MyclassEntity> ar = myclassdao.getAll();
			request.setAttribute("myar", ar);
			request.getRequestDispatcher("myclass/all.jsp").forward(request, response);

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}

}
