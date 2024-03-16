package com.login;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import com.login.dao.LoginDao;
@WebServlet("/Login")
public class Login extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		LoginDao dao=new LoginDao();
		
		try {
			if(dao.check(uname,pass))
			{
				HttpSession session=request.getSession();
				session.setAttribute("username", uname);
				response.sendRedirect("Index.jsp");
			}
			else
			{
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
