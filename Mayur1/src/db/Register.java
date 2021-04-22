package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String Specialist=request.getParameter("Specialist");
		String password=request.getParameter("pass");
		String status="pending";
		int id=0;
		PrintWriter out=response.getWriter();
		Connection con=Conc.getConnect();
		try {
			
		
		
			PreparedStatement ps = con.prepareStatement("insert into signup values(?,?,?,?,?,?,?)");
			 ps.setInt(1, id);
			 ps.setString(2, name);
			 ps.setString(3, address);
			 ps.setString(4, email);
			 ps.setString(5, Specialist);
			 ps.setString(6, password);
			 ps.setString(7, status);


			
		 int n=ps.executeUpdate();
		//ResultSet rs=ps.executeQuery();
		if (n>=1)
		{
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Done');");
		    out.println("location='Registration.jsp';");
		    out.println("</script>");
		   
		}
		else
		{
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('User or password incorrect');");
		    out.println("location='AdminLogin.html';");
		    out.println("</script>");			}
	
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

	

}
}