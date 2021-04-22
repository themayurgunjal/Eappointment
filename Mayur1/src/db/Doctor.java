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
 * Servlet implementation class Doctor
 */
public class Doctor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doctor() {
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
			ps = con.prepareStatement("select * from signup where email=? and password=?");
			ps.setString(1, a);
			 ps.setString(2, s);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{	
				String dname=rs.getString(3);
			
				
				String sp=rs.getString(5);
				System.out.println("THanq");
					
				//request.setAttribute("myname",sp);
				//request.getRequestDispatcher("ViewPatient.jsp").forward(request, response);
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('User Login Successful');");
			    out.println("location='DoctorLogin.jsp';");
			    out.println("</script>");

				response.sendRedirect("DoctorMenu.jsp");
			}
			else
			{
					out.println("<script type=\"text/javascript\">");
				    out.println("alert('User or password incorrect');");
				    out.println("location='DoctorLogin.jsp';");
				    out.println("</script>");

			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
