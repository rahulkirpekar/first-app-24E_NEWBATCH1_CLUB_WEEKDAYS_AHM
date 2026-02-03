package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.royal.bean.StudentBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TwelveServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
//		Object obj = request.getAttribute("sbean1");
//		StudentBean s1 = (StudentBean)obj;
		
		StudentBean s1 = (StudentBean)request.getAttribute("sbean1");
		StudentBean s2 = (StudentBean)request.getAttribute("sbean2");
		StudentBean s3 = (StudentBean)request.getAttribute("sbean3");
		
		System.out.println("TwelveServlet : service() -- " + s1.getRno()+" " + s1.getName()+" " + s1.getStd()+" " + s1.getMarks());
		System.out.println("TwelveServlet : service() -- " + s2.getRno()+" " + s2.getName()+" " + s2.getStd()+" " + s2.getMarks());
		System.out.println("TwelveServlet : service() -- " + s3.getRno()+" " + s3.getName()+" " + s3.getStd()+" " + s3.getMarks());

		
		request.removeAttribute("sbean3");
	
//		RequestDispatcher rd = request.getRequestDispatcher("ThirteenServlet");
//		rd.forward(request, response);
		
		request.getRequestDispatcher("ThirteenServlet").forward(request, response);
	}
}
