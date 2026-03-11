package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditStudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println("EditStudentServlet --Id : " + id);
		
		StudentDao dao = new StudentDao();
		
		StudentBean sbean = dao.getStudentById(id);
		
		RequestDispatcher rd = null;
		if (sbean != null) 
		{
			request.setAttribute("sbean", sbean);
			rd = request.getRequestDispatcher("editstudent.jsp");
		} else 
		{
			request.setAttribute("editStudent", "<font color='red'>Student record not edited due to Databse serverdown.</font>");
			rd = request.getRequestDispatcher("ListStudentServlet");
		}
		rd.forward(request, response);
	}
}
