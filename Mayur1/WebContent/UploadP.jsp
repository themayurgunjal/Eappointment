<%@page import="db.Conc"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page import="getset.*"%>


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
	String filePart = request.getParameter("image");
	String id	 = Get.getId();
	System.out.println("hiiifrmUpload"+id);
 	
 try
 {

		Connection con=Conc.getConnect();

			PreparedStatement statement = con.prepareStatement("update patients set pre=? where id='"+id+"'");
			File image=new File("D:/image/"+filePart);
			FileInputStream fs=new FileInputStream(image);
			
			statement.setBinaryStream(1,fs,fs.available());
			   int i=statement.executeUpdate();
				

 }
 catch(Exception e)
 {
 e.printStackTrace();
 }
finally
{
	response.sendRedirect("AddPre.jsp");
}

%>
</body>
</html>