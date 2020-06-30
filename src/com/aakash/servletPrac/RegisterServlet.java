package com.aakash.servletPrac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegisterServlet extends HttpServlet {
      
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		res.setContentType("text/html");
		PrintWriter pw= res.getWriter();
		
		String name = req.getParameter("name");
		String username= req.getParameter("uName");
		String password= req.getParameter("pWord");
		String email= req.getParameter("eMail");
		
		//DataBase Steps
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eclipse","root","root123");
		PreparedStatement ps= con.prepareStatement("insert into userdata(UserName,Password,Email) values(?,?,?)");			
		ps.setString(1, username);
		ps.setString(2, password);
		ps.setString(3, email);
		
		int i= ps.executeUpdate();
		if(i>0)
		{
			pw.println("Successfully updated");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
  }

