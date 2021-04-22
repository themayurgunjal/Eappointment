package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadPre
 */
public class UploadPre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPre() {
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
		
		 String filePart = request.getParameter("image");
		 int cid=2;		
		 PrintWriter out=response.getWriter();

		  try
		  {
		 
				Connection con=Conc.getConnect();

					PreparedStatement statement = con.prepareStatement("update patient set pre=? where id='"+cid+"'");
					File image=new File("D:/image/"+filePart);
					FileInputStream fs=new FileInputStream(image);
					
					statement.setBinaryStream(1,fs,fs.available());
					   int i=statement.executeUpdate();
					   out.print("hiiiiiiiiiiiii");
						response.sendRedirect("AddPre.jsp");

		  }
		  catch(Exception e)
		  {
		  e.printStackTrace();
		  }

		}

		}
