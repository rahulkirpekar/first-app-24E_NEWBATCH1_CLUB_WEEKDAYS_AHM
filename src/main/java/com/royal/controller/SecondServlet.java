package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet
{
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("-------------------------------------------------------------");
		System.out.println("SecondServlet : init() SecondServlet Object : " + this);
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("System.out.println(\"SecondServlet---service() : ");
		System.out.println("SecondServlet object : " + this);
		System.out.println("request.getRemoteHost() : " + request.getRemoteHost());
		System.out.println("request : " + request);
		System.out.println("response : " + response);
	}
	@Override
	public void destroy() 
	{
		System.out.println("SecondServlet : destroy() SecondServlet Object : " + this);
		System.out.println("-------------------------------------------------------------");
	}
}