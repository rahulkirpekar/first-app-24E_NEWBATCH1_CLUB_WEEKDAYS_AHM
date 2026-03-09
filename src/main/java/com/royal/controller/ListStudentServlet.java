package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ListStudentServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("ListStudentServlet----service()");
		
		StudentDao studentDao = new StudentDao();
		
		ArrayList<StudentBean> list = studentDao.getAllStudentRecords();
		
		request.setAttribute("list", list);

		request.getRequestDispatcher("listofstudent.jsp").forward(request, response);
	}
}
