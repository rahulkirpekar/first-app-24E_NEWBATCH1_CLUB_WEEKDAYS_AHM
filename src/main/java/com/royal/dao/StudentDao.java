package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.royal.bean.StudentBean;
import com.royal.util.DBConnection;

public class StudentDao 
{
	public int insertStudent(StudentBean sbean) 
	{
		String insertQuery = "INSERT INTO student(fullname,age,course,gender,hobbies,dob,email,mobile,address) VALUES (?,?,?,?,?,?,?,?,?)";
		
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		int rowsAffected = 0;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(insertQuery);
			
				pstmt.setString(1, sbean.getFullname());
				pstmt.setInt(2,sbean.getAge());
				pstmt.setString(3, sbean.getCourse());
				pstmt.setString(4, sbean.getGender());
				pstmt.setString(5, sbean.getHobbiesStr());
				pstmt.setString(6, sbean.getDob());
				pstmt.setString(7, sbean.getEmail());
				pstmt.setString(8, sbean.getMobile());
				pstmt.setString(9, sbean.getAddress());
				
				rowsAffected = pstmt.executeUpdate();
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("StudentDao : insertStudent() Db not connected");
		}
		return rowsAffected;
	}

	public ArrayList<StudentBean> getAllStudentRecords() 
	{
		String selectQuery = "select * from student";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentBean s = null;
		ArrayList<StudentBean> list = new ArrayList<StudentBean>();
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectQuery);
			
				rs = pstmt.executeQuery();
				
				while(rs.next()) 
				{
					int id = rs.getInt(1);
					String name = rs.getString(2);
					int age = rs.getInt(3);
					String course = rs.getString(4);
					String gender= rs.getString(5);
					String hobbiesStr= rs.getString(6);
					
					// convert hobbies string into string array.
					String hobbies[] = hobbiesStr.split(",");
					
					String dob= rs.getString(7);
					String email= rs.getString(8);
					String mobile= rs.getString(9);
					String address= rs.getString(10);
					
					
					s = new StudentBean(id, name, age, course, gender, hobbies, dob, email, mobile, address);
					
					list.add(s);
				}
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		} else 
		{
			System.out.println("StudentDao---Db not connected : "+conn);
		}
		return list;
	}
	
//	public static void main(String[] args) 
//	{
//		System.out.println("new StudentDao().getAllStudentRecords().size() : "+new StudentDao().getAllStudentRecords().size());
//		
//	}
	
	
}
