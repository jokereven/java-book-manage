package com.svse.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.svse.entity.UserEntity;
import com.svse.dao.UserDAO;
/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao = new UserDAO();
		String action=request.getParameter("action");
//		System.out.println(action); //login
		if(action.equalsIgnoreCase("login"))
		{
			String uname = new String(request.getParameter("uname").getBytes("iso8859_1"), "UTF-8");
			String upsw = new String(request.getParameter("upsw").getBytes("iso8859_1"), "UTF-8");
			UserEntity user = new UserEntity();
			user.setUname(uname);
			user.setUpsw(upsw);
			dao.getOne(1);
			if(
				user.getUname().toString().equals(dao.getOne(1).getUname().toString()) &
				user.getUpsw().toString().equals(dao.getOne(1).getUpsw().toString())){
			}else {
				response.sendRedirect("index.jsp");
				return;
			}
			request.getRequestDispatcher("main/main.jsp").forward(request, response);
		}
	}


	private String String(String uname) {
		// TODO Auto-generated method stub
		return null;
	}

}
