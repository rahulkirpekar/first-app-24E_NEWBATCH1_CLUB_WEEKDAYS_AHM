package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.royal.bean.UserBean;
import com.royal.util.DBConnection;

public class UserDao 
{

	public UserBean authenticateLogin(String email, String password) 
	{
		String selectUserBeanByUP = "SELECT * FROM user WHERE email=? AND password=?";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserBean userBean = null;
		if (conn != null) 
		{
			try 
			{
				pstmt = conn.prepareStatement(selectUserBeanByUP);
			
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) 
				{
					userBean = new UserBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));	
				}
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("UserDao--- authenticateLogin() Db not connected : " + conn);
		}
		return userBean;
	}
	
//	public static void main(String[] args) 
//	{
//		
//		UserDao dao = new UserDao();
//		
//		UserBean userBean = dao.authenticateLogin("rahul@gmail.com", "rahul");
//		
//		System.out.println(userBean.getId()+" " + userBean.getUserName()+" " + userBean.getEmail()+" " + userBean.getPassword());
//	}
}
