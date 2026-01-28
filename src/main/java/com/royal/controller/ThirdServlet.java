package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// SET MIME
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
//		out.println("<h1>ThirdServlet---service()</h1>");
		
		int no;
		
		no = 5;
		
		for (int i = 1; i <=10; i++) 
		{
			out.print(no + " * " + i + " = " + (no*i)+"<br>");
		} 
	}
}
