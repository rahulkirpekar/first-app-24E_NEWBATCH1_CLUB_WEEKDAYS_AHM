package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EleventhServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		StudentBean sbean1 = new StudentBean(1, "Rahul Kirpekar", 12, 90);
		StudentBean sbean2 = new StudentBean(2, "Ankur Barot", 12, 100);
		StudentBean sbean3 = new StudentBean(3, "Krunal Patel", 10, 95);
		
		request.setAttribute("sbean1", sbean1);
		request.setAttribute("sbean2", sbean2);
		request.setAttribute("sbean3", sbean3);
		
		RequestDispatcher rd = request.getRequestDispatcher("TwelveServlet");
		rd.forward(request, response);
	}
}
