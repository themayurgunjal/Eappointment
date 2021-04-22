package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApprovServlet
 */
public class ApprovServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApprovServlet() {
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
		System.out.println("idaaaaaaa");

		String approve = request.getParameter("aid");
		System.out.println("id"+approve);
		
		String disapprove = request.getParameter("did");
		System.out.println(disapprove);

		PrintWriter out=response.getWriter();

		try {
			Connection con=Conc.getConnect();
			if (approve != null) {
								PreparedStatement pstmt= con.prepareStatement("update signup set status=? where id='"+approve+"'");
								pstmt.setString(1,"approve");
								System.out.println("approve");
				
								int n=pstmt.executeUpdate();
								 if(n>0){
									 	out.println("<script type=\"text/javascript\">");
									    out.println("alert('Update comment');");
									    out.println("location='Approve.jsp';");
									    out.println("</script>"); }
								 else{ 
									 out.println("bye");
									 }
			}else	if (disapprove != null) {
								PreparedStatement pstmt= con.prepareStatement("update signup set status=? where id='"+disapprove+"'");
								pstmt.setString(1,"disapprove");
								System.out.println("disapprove");
			
								int n=pstmt.executeUpdate();
								 if(n>0){
									 	out.println("<script type=\"text/javascript\">");
									    out.println("alert('Update comment');");
									    out.println("location='approve.jsp';");
									    out.println("</script>"); }
								 else{
									 out.println("bye");
									 }

					 
			}
				} catch (SQLException e) {
					
						e.printStackTrace();
					}
			
	}
	}


