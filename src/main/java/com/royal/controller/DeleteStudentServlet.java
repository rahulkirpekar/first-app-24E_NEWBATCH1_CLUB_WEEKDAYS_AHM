package com.royal.controller;

import java.io.IOException;

import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteStudentServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		
		if(session == null)
		{
			request.setAttribute("invalidAccess", "<font color='red'>Invalid Access,Login First...!</font>");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		StudentDao dao = new StudentDao();
		
		int rowsAffected = dao.deleteStudent(id);
		
		RequestDispatcher rd = null;
		if (rowsAffected > 0) 
		{
			request.setAttribute("deleteStudentResult", "<font color='green'>Student record deleted.</font>");
			rd = request.getRequestDispatcher("ListStudentServlet");
		} else 
		{
			request.setAttribute("deleteStudentResult", "<font color='red'>Student record not deleted due to Databse serverdown.</font>");
			rd = request.getRequestDispatcher("ListStudentServlet");
		}
		rd.forward(request, response);
	}
}
