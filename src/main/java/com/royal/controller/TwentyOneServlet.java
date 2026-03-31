package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TwentyOneServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext context = getServletContext();
		
		System.out.println("TwentyOneServlet : name added in context.");
		context.setAttribute("name1", "Rahul Kirpekar");
		System.out.println("-----------------------------------");
		System.out.println("TwentyOneServlet : name replaced from context.");
		context.setAttribute("name1", "Ganesh");
		
		System.out.println("-----------------------------------");
		System.out.println("TwentyOneServlet : name removed from context.");
		context.removeAttribute("name1");
	}
}
