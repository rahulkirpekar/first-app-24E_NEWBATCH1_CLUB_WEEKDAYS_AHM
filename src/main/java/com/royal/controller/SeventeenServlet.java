package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SeventeenServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StudentBean sbean1 = new StudentBean(1, "Rahul Kirpekar", 12, 90);
		StudentBean sbean2 = new StudentBean(2, "Ankur Barot", 12, 100);
		StudentBean sbean3 = new StudentBean(3, "Krunal Patel", 10, 95);		
		
		ServletContext applicationScope = getServletContext();
		
		applicationScope.setAttribute("student1",sbean1);
		applicationScope.setAttribute("student2",sbean2);
		applicationScope.setAttribute("student3",sbean3);
		
		System.out.println("SeventeenServlet - service() Data Stord into ApplicationScope.");
	}
}