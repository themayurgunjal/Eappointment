package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Medical
 */
public class Medical extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Medical() {
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
		String a=request.getParameter("email");
		String s=request.getParameter("password");
		try 
		{
			Connection con=Conc.getConnect();
			PrintWriter out=response.getWriter();
			PreparedStatement ps;
			ps = con.prepareStatement("select * from medical where email=? and password=?");
			 ps.setString(1, a);
			 ps.setString(2, s);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('Login Successfull');");
			    out.println("location='MedicalLogin.jsp';");
			    out.println("</script>");	
				response.sendRedirect("MedicalMenu.jsp");
				
			}
			else
			{
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('User or password incorrect');");
			    out.println("location='MedicalLogin.jsp';");
			    out.println("</script>");			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
