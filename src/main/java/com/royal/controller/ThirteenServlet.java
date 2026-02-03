package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.StudentBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ThirteenServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		StudentBean s1 = (StudentBean)request.getAttribute("sbean1");
		StudentBean s2 = (StudentBean)request.getAttribute("sbean2");
		StudentBean s3 = (StudentBean)request.getAttribute("sbean3");// null
		
		PrintWriter out = response.getWriter();
		out.println("ThirteenServlet : service() -- " + s1.getRno()+" " + s1.getName()+" " + s1.getStd()+" " + s1.getMarks());
		out.println("ThirteenServlet : service() -- " + s2.getRno()+" " + s2.getName()+" " + s2.getStd()+" " + s2.getMarks());
		out.println("ThirteenServlet : service() -- " + s3.getRno()+" " + s3.getName()+" " + s3.getStd()+" " + s3.getMarks());

	}
}
