package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SixthServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// SixthServlet(Servlet)====>SixthServlet(Config) 
		
		ServletConfig config = getServletConfig();// SixthServlet(Config) 
		
		String urlName = config.getInitParameter("URLNAME");
		String driverClass = config.getInitParameter("DRIVERCLASS");
		String userName = config.getInitParameter("USERNAME");
		String password = config.getInitParameter("PASSWORD");
		
		
		PrintWriter out = response.getWriter();
		
		out.print("<b>SixthServlet : </b><br>");
		out.print("<b>SixthServlet Object : </b>"+this+" and SixthServletConfig Object : "+config+"<br>");
		
		out.print("<b>URLNAME : </b>" + urlName+"<br>");
		out.print("<b>DRIVERCLASS : </b>" + driverClass+"<br>");
		out.print("<b>USERNAME : </b>" + userName+"<br>");
		out.print("<b>PASSWORD : </b>" + password+"<br>");
		
		
	}
}
