package com.adityaseries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.jdbc.PreparedStatement;

@Controller
public class RegisterController {
	@RequestMapping("/Register")
	public int insert(HttpServletRequest req,HttpServletResponse res) {
		
		
			PreparedStatement preparedStatement = null;
			Connection con=null;
			try {

				String fname=	req.getParameter("fname");
				String lname=	req.getParameter("lname");

				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				String sql = "INSERT INTO mysql.userdetails (fname,lname) VALUES (?, ?)";
				con=DriverManager.getConnection(  
						"jdbc:mysql://localhost:3306/mysql","root","root"); 

				preparedStatement=(PreparedStatement) con.prepareStatement(sql); 
				preparedStatement.setString(1, fname);
				
				preparedStatement.setString(2, lname);
				int updatedcount=	preparedStatement.executeUpdate();
				System.out.println(updatedcount);

				return updatedcount;

			}
			catch (SQLException e) {

				System.out.println(e.getMessage());

			}
			finally {

				if (preparedStatement != null) {
					try {
						preparedStatement.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			return 0;
		}
	}


