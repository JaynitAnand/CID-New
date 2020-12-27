package OnlineDemo ;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/OnlineDataBase")
public class OnlineDataBase extends HttpServlet 
{ 	
	private Connection con;
	private Statement stmt;
	private ResultSet rset;
	
	public OnlineDataBase()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12383824","sql12383824","sbaD9DyWSH");
			stmt= con.createStatement();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error in Connection"+" "+e);
		}
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		try
		{
		String name= request.getParameter("Name");
		String agee= request.getParameter("Age");
		String mob = request.getParameter("Mob");
		String email= request.getParameter("Email");
		String sql = "INSERT INTO `Demo` (`name`, `age`, `mob`, `email`) VALUES "+"('"+name+"', "+" '"+agee+"', '"+mob+"', "+" '"+email+"');";
		System.out.println(sql);
		System.out.println(email);
		//stmt=con.prepareStatement(sql);
		stmt.executeUpdate(sql);
		
		response.sendRedirect(requeest.getContextPath()+"/index.html");
	}
		catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("error in inserting data in Online database"+e);
		}
	}

	}


