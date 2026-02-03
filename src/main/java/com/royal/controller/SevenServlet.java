package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SevenServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// SevenServlet(Servlet)====>SevenServlet(Config) 
		
		ServletConfig config = getServletConfig();// SevenServlet(Config) 
		
		String urlName = config.getInitParameter("URLNAME");
		String driverClass = config.getInitParameter("DRIVERCLASS");
		String userName = config.getInitParameter("USERNAME");
		String password = config.getInitParameter("PASSWORD");
		
		PrintWriter out = response.getWriter();
		
		out.print("<b>SevenServlet : </b><br>");
		out.print("<b>SevenServlet Object : </b>"+this+" and SevenServletConfig Object : "+config+"<br>");
		
		out.print("<b>URLNAME : </b>" + urlName+"<br>");
		out.print("<b>DRIVERCLASS : </b>" + driverClass+"<br>");
		out.print("<b>USERNAME : </b>" + userName+"<br>");
		out.print("<b>PASSWORD : </b>" + password+"<br>");
	}
}
