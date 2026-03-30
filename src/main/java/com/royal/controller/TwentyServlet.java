package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class TwentyServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(false);
		System.out.println("TwentyServlet : Old session is --"+session);

		session.setAttribute("name1", "Ganesh");
		
		String name = (String)session.getAttribute("name1");

		System.out.println("TwentyServlet--Name : " + name);
		
		session.removeAttribute("name1");
		
		if(session!=null) 
		{
			session.invalidate();
			System.out.println("Session Destroyed : " + session);
		}else 
		{
			System.out.println("Session is NULL : " + session);
		}
		
	}
}