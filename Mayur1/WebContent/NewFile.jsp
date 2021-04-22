<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@page import="db.Conc"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>

<html>
<head>
</head>
<% 
	int i=Integer.parseInt(request.getParameter("id"));
	System.out.println(request.getParameter("id"));
	System.out.println("menu"+i);
	
	%>
<body>
 <%


PreparedStatement stmt= null;
ResultSet rs = null;
%>

<%

try {
    //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
   
   
			  			Connection con=Conc.getConnect();

    stmt=con.prepareStatement("select * from patients where id = ?");
   stmt.setInt(1,i);
    rs = stmt.executeQuery();
    if (rs.next()) {
        byte[] imgData = rs.getBytes("pre");//Here r1.getBytes() extract byte data from resultSet 
        System.out.println(imgData);
        response.setHeader("expires", "0");
        response.setContentType("image/jpg");

        OutputStream os = response.getOutputStream(); // output with the help of outputStream 
        os.write(imgData);
        os.flush();
        os.close();
        
        
    }
    response.getOutputStream().flush();
    response.getOutputStream().close();
} catch (SQLException ex) {
    // String message = "ERROR: " + ex.getMessage();
    ex.printStackTrace();
} 
    

 %>

</body>
</html>