package com.royal.controller;

import java.io.IOException;

import com.royal.bean.UserBean;
import com.royal.dao.UserDao;
import com.royal.util.StringUtils;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email = request.getParameter("userName");
		String password = request.getParameter("password");

		System.out.println("LoginServlet service(): ");
		System.out.println("-----------------------------");
		System.out.println("Email : " + email);
		System.out.println("Password : " + password);
		
		RequestDispatcher rd = null;
		if(StringUtils.isValidString(email) && StringUtils.isValidString(password)) 
		{
			UserDao userDao = new UserDao();
			
			UserBean userBean = userDao.authenticateLogin(email,password);
			
			if (userBean != null) 
			{
				// session create 
				HttpSession session = request.getSession();
				
				session.setAttribute("userBean", userBean);
				
				rd = request.getRequestDispatcher("stureg.jsp");
			} else 
			{
				request.setAttribute("loginErr", "<font color='red'> Invalid Credentials,\n\tPlease enter valid userName and password. </font>");
				rd = request.getRequestDispatcher("login.jsp");
			}
		}else 
		{
			request.setAttribute("loginErr", "<font color='red'> Invalid Credentials,Please enter valid userName and password. </font>");
			rd = request.getRequestDispatcher("login.jsp");
		}
		rd.forward(request, response);
	}
}



