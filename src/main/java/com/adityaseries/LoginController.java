package com.adityaseries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req,HttpServletResponse res) throws SQLException, ClassNotFoundException
	{
		String fname=	req.getParameter("fname");
		String lname=	req.getParameter("lname");
		Class.forName("com.mysql.jdbc.Driver"); 
		String query = "select * from userdetails";
		Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/mysql","root","root");  
		Statement stmt=con.createStatement();  
		ResultSet rs = stmt.executeQuery(query);
		while(rs.next()) {
			if ((fname.equalsIgnoreCase(rs.getString("first_name"))) && (lname.equalsIgnoreCase(rs.getString("last_name")))) {

//				System.out.println("connection with the entered credentials got successed");
				String z="connection with the entered credentials got successed";
				ModelAndView mv=new ModelAndView();
				mv.setViewName("display.jsp");
				mv.addObject("result",z);
				return mv;
			}
			continue;
		}
		if(rs.next()==false) {

			System.out.println("credentials not found in database");
		}
		return null;



	}
}
