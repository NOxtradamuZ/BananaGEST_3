package com.generation.jwd.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.generation.jwd.beans.Project;


@WebServlet("/createproject")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Connection connection;
	private ResultSet rs;
	private PreparedStatement stmt;
 
    public ProjectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map <Integer, String> users = new HashMap <Integer, String>();
	
		String url = "jdbc:mysql://127.0.0.1:3306/banana_gest_3";
        String user = "root";
        String password1 = "Enrique123";
        
		try {
		
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
	        connection = DriverManager.getConnection(url, user, password1);
			
			stmt = (PreparedStatement)connection.prepareStatement("SELECT id, name FROM user order by name asc");	
			rs = stmt.executeQuery();
		
			while(rs.next()) {
			
				users.put(rs.getInt("id"), rs.getString("name"));
			}		
		
			rs.close();
			stmt.close();
			connection.close();
		
		} catch (SQLException e) {		
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		request.setAttribute("userList", users.values());
		request.getRequestDispatcher("createproject.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Project project = new Project();
		
		project.setName(request.getParameter("name"));
		project.setDescription(request.getParameter("description"));
		project.setDate_start(request.getParameter("date_start"));
		project.setDate_end(request.getParameter("date_end"));
		project.setId_user(Integer.parseInt(request.getParameter("id_user")));
				
		String q = "INSERT INTO project"
				+ "(id, name, date_start, date_end, description, id_user)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		
		String url = "jdbc:mysql://127.0.0.1:3306/banana_gest_3";
        String user = "root";
        String password1 = "Enrique123";
		
		try {
				
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
	        connection = DriverManager.getConnection(url, user, password1);	
				
			stmt = (PreparedStatement)connection.prepareStatement(q);				
			stmt.setInt(1, project.getId());
			stmt.setString(2, project.getName());
			stmt.setString(3, project.getDate_start());
			stmt.setString(4, project.getDate_end());
			stmt.setString(5, project.getDescription());
			stmt.setInt(6, project.getId_user());
			stmt.executeUpdate();
				
			stmt.close();
			connection.close();
					
		    } catch (SQLException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
		    }
		     response.sendRedirect("homeuser");
	}
}