package com.royal.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.royal.bean.StudentBean;
import com.royal.dao.StudentDao;
import com.royal.util.StringUtils;

public class UpdateStudentServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		System.out.println("UpdateStudentServlet --Id : " + id);
		
		StudentBean sbean = new StudentBean();
		
		sbean.setId(id);
		
		boolean flag=  false;
		
		// Backend Validation
		System.out.println("UpdateStudentServlet----service()");
		
		String  fullname =  request.getParameter("fullname");
		
		if(StringUtils.isValidString(fullname)) 
		{
			sbean.setFullname(fullname);
			
		}else 
		{
			// error msg store into request
			request.setAttribute("fullnameErr", "<font color='red'>Please enter valid Fullname.</font>");
			flag = true;
		}
		
		String  ageStr      =  request.getParameter("age");
		
		if(StringUtils.isValidString(ageStr)) 
		{
			sbean.setAge(Integer.parseInt(ageStr));
			
		}else 
		{
			// error msg store into request
			request.setAttribute("ageErr", "<font color='red'>Please enter valid Age.</font>");
			flag = true;
		}
		
		String course =  request.getParameter("course");
		
		if(StringUtils.isValidString(course)) 
		{
			sbean.setCourse(course);
			
		}else 
		{
			// error msg store into request
			request.setAttribute("courseErr", "<font color='red'>Please enter valid Course.</font>");
			flag = true;
		}
		
		
		String   gender   =  request.getParameter("gender");
		
		if(StringUtils.isValidString(gender)) 
		{
			sbean.setGender(gender);
			
		}else 
		{
			// error msg store into request
			request.setAttribute("genderErr", "<font color='red'>Please enter valid Gender.</font>");
			flag = true;
		}
		
		String   hobbies[]    =  request.getParameterValues("hobby");
		
		if(hobbies != null) 
		{
			sbean.setHobby(hobbies);
			
		}else 
		{
			// error msg store into request
			request.setAttribute("hobbyErr", "<font color='red'>Please enter valid Hobby.</font>");
			flag = true;
		}
		
		
		String   dob      =  request.getParameter("dob");
		
		if(StringUtils.isValidString(dob)) 
		{
			sbean.setDob(dob);
			
		}else 
		{
			// error msg store into request
			request.setAttribute("dobErr", "<font color='red'>Please enter valid DOB.</font>");
			flag = true;
		}
		
		String   email    =  request.getParameter("email");
		
		if(StringUtils.isValidString(email)) 
		{
			sbean.setEmail(email);
			
		}else 
		{
			// error msg store into request
			request.setAttribute("emailErr", "<font color='red'>Please enter valid Email.</font>");
			flag = true;
		}
		
		String   mobile   =  request.getParameter("mobile");
		
		if(StringUtils.isValidString(mobile)) 
		{
			sbean.setMobile(mobile);
			
		}else 
		{
			// error msg store into request
			request.setAttribute("mobileErr", "<font color='red'>Please enter valid Mobile.</font>");
			flag = true;
		}
		
		
		String   address  =  request.getParameter("address");
		
		if(StringUtils.isValidString(address)) 
		{
			sbean.setAddress(address);
			
		}else 
		{
			// error msg store into request
			request.setAttribute("addressErr", "<font color='red'>Please enter valid Address.</font>");
			flag = true;
		}
		
		request.setAttribute("sbean", sbean);
		
		RequestDispatcher rd = null;
		
		if(flag) 
		{
			rd = request.getRequestDispatcher("stureg.jsp");
		}else 
		{
			StudentDao dao = new StudentDao();
			
			int rowsAffected = dao.updateStudent(sbean,id);
			
			if(rowsAffected > 0) 
			{
				rd = request.getRequestDispatcher("ListStudentServlet");
			}else
			{
				request.setAttribute("dbErr", "<font color='red'>Data not Inserted due to Database Server Down.</font>");
				rd = request.getRequestDispatcher("editStudent.jsp");
			}
		}
		rd.forward(request, response);
	}
}
