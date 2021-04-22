<%@page import="db.Conc"%>
<%@page import="java.sql.*"%>
<!DOCTYPE HTML>
<html>
<head>
<title></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!----webfonts--->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
<!---//webfonts--->  
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
</head>
<body>
<div id="wrapper">
     <!-- Navigation -->
        <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">E_Appoinment</a>
            </div>
            <!-- /.navbar-header -->
            
			
            <!-- /.navbar-header -->
                 <div class="log">
			     <a href="AdminLogin.jsp">Log Out</a>
			     </div>
			
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="approve.jsp">Approve Hospital</a>
                        </li>
                        <li>
                            <a href="#">Add Tips</a>
                            
                            <!-- /.nav-second-level -->
                        </li>
                        </ul>
                </div>
                <!-- /.sidebar-collapse -->
            
            <!-- /.navbar-static-side -->
        </nav>
        <div id="page-wrapper">
        <div class="graphs">
	     <div class="xs">
  	   <div class="table-responsive">
      <table class="table">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email Id</th>
            <th>Address</th>
            <th>Status</th>
            <th>Approve</th>
            <th>Disapper</th>
          </tr><%
                                          try{
                                       
                                         Connection con=null;
                                          Class.forName("com.mysql.jdbc.Driver");
      									System.out.println("Class execute");
      									con=DriverManager.getConnection("jdbc:mySql://localhost:3306/eappintment","root","");
      									Statement stmt=con.createStatement();
      									int i=1;
      									String name="pending";
      									
      									ResultSet rs=stmt.executeQuery("select * from signup where status='"+name+"'");
                                          while(rs.next()){
                                          %>
                                          <tbody>
                                                    <tr>
		                                                       <td><%=i++%></td>
														<td><%=rs.getString("name")%></td>
														<td><%=rs.getString("email")%></td>
														<td><%=rs.getString("password")%></td>
														<td><%=rs.getString("status")%></td>
													 
														<TD><a href="approveDocter.jsp?aid=<%=rs.getInt("id")%>">Approve</a>
														</TD>
														<TD><a href="approveDocter.jsp?did=<%=rs.getInt("id")%>">Disapprove</a>
														</TD>		 
                                                    </tr>
                                          </tbody>
                                                   <%
                                                   }
                                                   //connection.close();
                                                   } catch (Exception e) {
                                                   e.printStackTrace();
                                                   }
                                                   %>
         
</thead>

	
	</table>
	
					
					 
						
	
					
 
	
      
      
      
      
      
    </form>
  </div>
  </div>
  </div>
  </div>
      </div>
      <!-- /#page-wrapper -->
   </div>
    <!-- /#wrapper -->
<!-- Nav CSS -->
<link href="css/custom.css" rel="stylesheet">
<!-- Metis Menu Plugin JavaScript -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
</body>
</html>
