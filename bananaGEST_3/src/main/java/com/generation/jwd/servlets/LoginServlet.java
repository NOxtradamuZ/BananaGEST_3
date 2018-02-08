//package com.generation.jwd.servlets;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import javax.sql.DataSource;
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    public LoginServlet() {
//        super();
//    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		request.getRequestDispatcher("login.jsp").forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String email = request.getParameter("email");
//		String password = request.getParameter("password");
//		
//		if(email.isEmpty() || password.isEmpty()) {
//			
//			//Si el formulario estï¿½ vacï¿½o, manda un mensaje de error
//			request.setAttribute("error", "Usuario y/o contraseña están vacíos. Por favor, introduzca datos correctos");
//			request.getRequestDispatcher("/login").forward(request, response);
//			
//		} 
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			System.out.println("Where is your MySQL JDBC Driver?");
//			e.printStackTrace();
//			return;
//		}
//		
//		Connection conn;
//		ResultSet rs;
//		PreparedStatement stmt;
//		Context initContext;
//		Context envContext;
//		DataSource ds;
//		int id_user = 0;			
//			
//		try {	
//			
//			initContext = new InitialContext();
//			envContext = (Context)initContext.lookup("java:/comp/env");
//			ds = (DataSource)envContext.lookup("jdbc/banana_gest_new");
//			conn = (Connection) ds.getConnection();
//			stmt = (PreparedStatement)conn.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");				
//			stmt.setString(1, email);
//			stmt.setString(2, password);			
//			rs = stmt.executeQuery();
//				
//			if (rs.next()) {				
//			
//				id_user = rs.getInt("id");					
//			}			
//			
//			rs.close();
//			stmt.close();
//			conn.close();			
//			
//		} catch(Exception e) {
//			System.out.println("Excepcion SQL: " + e.getMessage());				
//		}
//		
//		if (id_user != 0) {		
//			
//			HttpSession session = (HttpSession)request.getSession();
//			session.setAttribute("id_user",id_user);		
//			request.getRequestDispatcher("/homeuser").forward(request, response);
//			
//		} else {
//			
//			request.setAttribute("error", "Usuario y/o contraseña son incorrectos. Por favor, vuelva a introducir los datos");
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//		
//		}				
//	}
//}

package com.generation.jwd.servlets;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.getRequestDispatcher("login.jsp").forward(request, response);
        System.out.println("Get");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if(email.isEmpty() || password.isEmpty()) {
            
            //Si el formulario estï¿½ vacï¿½o, manda un mensaje de error
            request.setAttribute("error", "El/los campo/s de usuario y/o la contraseña están vacíos. Inténtelo de nuevo.");
            request.getRequestDispatcher("/login").forward(request, response);
            
        } 
        
        String url = "jdbc:mysql://127.0.0.1:3306/banana_gest_3";
        String user = "root";
        String password1 = "Enrique123";
        
        Connection connection;
        ResultSet rs;
        PreparedStatement stmt;
        int id_user = 0;            
            
        try {    
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(url, user, password1);
            stmt = connection.prepareStatement("SELECT * FROM user WHERE email = ? AND password = ?");
            
            stmt.setString(1, email);
            stmt.setString(2, password);
            
            rs = stmt.executeQuery();
            
            if (rs.next()) {                
            
                id_user = rs.getInt("id");                    
            }            
            
            rs.close();
            stmt.close();
            connection.close();            
            
        } catch(Exception e) {
            System.out.println("Excepcion SQL: " + e.getMessage());                
        }
        
        if (id_user != 0) {        
            
            HttpSession session = (HttpSession)request.getSession();
            session.setAttribute("id_user",id_user);        
            request.getRequestDispatcher("/homeuser").forward(request, response);
            
        } else {
            
            request.setAttribute("error", "Usuario y/o contraseña incorrectos. Inténtelo de nuevo.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        
        }                
    }
}
 



 
