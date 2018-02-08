package com.generation.jwd.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.generation.jwd.beans.Task;
import com.generation.jwd.beans.User;

@WebServlet("/homeuser")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HomeServlet() {
        super();
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Task> taskList = new ArrayList<Task>();
		Task myTask ;
		HttpSession session = (HttpSession)request.getSession();
		int user_id = (Integer)session.getAttribute("id_user");

		String url = "jdbc:mysql://127.0.0.1:3306/banana_gest_3";
        String user = "root";
        String password1 = "Enrique123";
		
		try {
				        
	        Class.forName("com.mysql.jdbc.Driver").newInstance();
			
	        connection = DriverManager.getConnection(url, user, password1);
	        
			stmt = (PreparedStatement)connection.prepareStatement("SELECT * FROM task WHERE id_user = ?");
			stmt.setInt(1,user_id );
			rs = stmt.executeQuery();		
			 			
			while(rs.next()) {
				myTask = new Task();
				myTask.setId(rs.getInt(1));
				myTask.setName(rs.getString(2));
				myTask.setDate_start(rs.getString(3));
				myTask.setDescription(rs.getString(4));
				myTask.setState(rs.getString(5));				
				myTask.setHours(rs.getInt(6));
				myTask.setId_user(rs.getInt(7));
				taskList.add(myTask);	
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
		request.setAttribute("taskList",taskList);
		request.getRequestDispatcher("homeuser.jsp").forward(request, response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.doGet(request, response);
	}

}
