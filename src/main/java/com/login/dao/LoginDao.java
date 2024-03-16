package com.login.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Result;

public class LoginDao
{
	String sql="select*from login where uname=? and pass=?";
	String url="jdbc:mysql://127.0.0.1:3306/bhushan";
	String username="root";
	String password="bhushan";
	public boolean check(String uname,String pass) throws SQLException
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,uname);
			st.setString(2,pass);
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				return true;
			}
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
