package db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import db.*;

/**
 * Servlet implementation class LoginMenu
 */
public class LoginMenu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMenu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Connection con=Conc.getConnect();

		String query="select * from signup where email='"+email+"' and password='"+password+"'";
		
		HttpSession session=request.getSession();
		try {
			
			ResultSet rs=Conc.selectQuery(query);
			if(rs.next())
			{
				if(!rs.getString("status").equals("pending"))
				{
				session.setAttribute("email", email);
				session.setAttribute("uid", rs.getString(1));
				response.sendRedirect("Managing.jsp");
				}
				else{
					session.setAttribute("invalid", "Wrong username and password");
				}
			}
			else if(email.equals("admin")&password.equals("admin"))
			{
				session.setAttribute("email", email);
			//	session.setAttribute("uid", rs.getString(1));
				
				response.sendRedirect("approv.jsp");
			}
			else if(email.equals("tpa")&password.equals("tpa"))
			{
				session.setAttribute("email", email);
			//	session.setAttribute("uid", rs.getString(1));
				
				response.sendRedirect("TpaAudit.jsp");
			}
			
			else
			{
				session.setAttribute("invalid", "Wrong username and password");
				response.sendRedirect("Aadmin.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 	}

}

