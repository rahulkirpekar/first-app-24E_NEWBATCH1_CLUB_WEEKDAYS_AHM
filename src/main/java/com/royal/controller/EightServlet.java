package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EightServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = 	response.getWriter();
		
		ServletConfig config = getServletConfig();
		
		Enumeration<String> e = 	config.getInitParameterNames();
		
		while(e.hasMoreElements()) 
		{
			String paramName = e.nextElement();
			
			String paramValue = config.getInitParameter(paramName);
			
			out.print("<b>"+paramName+" : </b>"+paramValue+"<br>");
		}
	}
}
