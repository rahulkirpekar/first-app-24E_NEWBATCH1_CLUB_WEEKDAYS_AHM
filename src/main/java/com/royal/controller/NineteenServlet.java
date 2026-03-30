package com.royal.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class NineteenServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);
		
		session.setAttribute("name1", "Rahul Kirpekar");
		
		System.out.println("NineteenServlet : session created --"+session);
	}
}
