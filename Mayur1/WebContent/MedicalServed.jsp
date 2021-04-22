<%@page import="db.Conc"%>
<%@page import="java.sql.*"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String approve = request.getParameter("did");
System.out.println("id"+approve);




try {
	
						Connection con=Conc.getConnect();
						PreparedStatement pstmt= con.prepareStatement("update patients set Disease=? where id='"+approve+"'");
						pstmt.setString(1,"Served");
						//System.out.println("approve");
		
						int n=pstmt.executeUpdate();
						
	
		} catch (SQLException e) {
			
				e.printStackTrace();
			}
finally
{
	response.sendRedirect("pre.jsp");
}

%></body>
</html>