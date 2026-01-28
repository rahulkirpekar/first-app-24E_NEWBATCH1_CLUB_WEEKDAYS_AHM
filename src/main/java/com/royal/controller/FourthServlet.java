package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FourthServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		System.out.println("=========FourthServlet---service()=========");
		
//		RequestDispatcher rd = request.getRequestDispatcher("FifthServlet");
//		rd.forward(request, response);
//		rd.include(request, response);
		
		
		response.sendRedirect("https://www.google.com/");
	}
}
