<%@page import="db.Conc"%>
<%@page import="java.sql.*"%>
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
String approve = request.getParameter("aid");
System.out.println("id"+approve);

String disapprove = request.getParameter("did");
System.out.println(disapprove);



try {
	
	Connection con=Conc.getConnect();
	if (approve != null) {
						PreparedStatement pstmt= con.prepareStatement("update signup set status=? where id='"+approve+"'");
						pstmt.setString(1,"approve");
						System.out.println("approve");
		
						int n=pstmt.executeUpdate();
						
	}else	if (disapprove != null) {
						PreparedStatement pstmt= con.prepareStatement("update signup set status=? where id='"+disapprove+"'");
						pstmt.setString(1,"disapprove");
						System.out.println("disapprove");
	
						int n=pstmt.executeUpdate();
	}
		} catch (SQLException e) {
			
				e.printStackTrace();
			}
finally
{
	response.sendRedirect("Approve.jsp");
}

%>
</body>
</html>