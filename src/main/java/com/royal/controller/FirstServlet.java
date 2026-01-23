package com.royal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet
{
	@Override
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("-------------------------------------------------------------");
		System.out.println("FirstServlet : init() FirstServlet Object : " + this);
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		System.out.println("-------------------------------------------------------------");
		System.out.println("System.out.println(\"FirstServlet---service() : ");

		System.out.println("FirstServlet object : " + this);
		System.out.println("request.getRemoteHost() : " + request.getRemoteHost());
		System.out.println("request : " + request);
		System.out.println("response : " + response);		
	}
	@Override
	public void destroy() 
	{
		System.out.println("FirstServlet : destroy() SecondServlet Object : " + this);
		System.out.println("-------------------------------------------------------------");
	}
}
