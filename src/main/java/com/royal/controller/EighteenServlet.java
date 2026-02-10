package com.royal.controller;

import java.io.IOException;

import com.royal.bean.StudentBean;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EighteenServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ServletContext applicationScope = getServletContext();
		
		StudentBean sbean1 =(StudentBean)applicationScope.getAttribute("student1");
		StudentBean sbean2 =(StudentBean)applicationScope.getAttribute("student2");
		StudentBean sbean3 =(StudentBean)applicationScope.getAttribute("student3");
		
		System.out.println("EighteenServlet - service() : ");
		System.out.println("----------------------------------------");
		System.out.println(sbean1.getRno()+" " + sbean1.getName()+" " + sbean1.getStd()+" " + sbean1.getMarks());
		System.out.println(sbean2.getRno()+" " + sbean2.getName()+" " + sbean2.getStd()+" " + sbean2.getMarks());
		System.out.println(sbean3.getRno()+" " + sbean3.getName()+" " + sbean3.getStd()+" " + sbean3.getMarks());
		
		
	}	
}
