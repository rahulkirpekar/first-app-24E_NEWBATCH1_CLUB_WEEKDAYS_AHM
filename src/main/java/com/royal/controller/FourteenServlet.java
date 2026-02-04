package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FourteenServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// 1. session create
		HttpSession session = request.getSession();

		StudentBean sbean1 = new StudentBean(1, "Rahul Kirpekar", 12, 100);
		StudentBean sbean2 = new StudentBean(2, "Krunal Patel", 10, 90);
		StudentBean sbean3 = new StudentBean(3, "Rakesh Shah", 11, 80);
		
		session.setAttribute("sbean1", sbean1);
		session.setAttribute("sbean2", sbean2);
		session.setAttribute("sbean3", sbean3);
		
		System.out.println("-------------------------");
		System.out.println("FourteenServlet : ");
		System.out.println("-------------------------");
		System.out.println("FourteenServlet store 3 student data in session scope.");
	}
}
