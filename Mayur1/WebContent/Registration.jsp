
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
<body id="login">
  <div class="login-logo">
    <h1 style="color:#000;"> New Registration </h1>
  </div>
  <h2 class="form-heading">Register</h2>
  <form class="form-signin app-cam" action="Register" method="post">
      
      <input type="text" class="form-control1" placeholder="Enter First Name" name="name" autofocus=""required>
       
	  <input type="text" class="form-control1" placeholder="Address" name="address" autofocus=""required>
	  
      <input type="text" class="form-control1" placeholder="Email" name="email" autofocus=""required>
      
      <input type="password" class="form-control1" placeholder="password" name="pass" autofocus=""required>
      
      
      <select name="Specialist">
									<option>Speacialist</option>
									<option>Physicians</option>
									<option>Cardiologist</option>
									<option>Dentist</option>
									<option>Dermatologists</option>
									<option>Gynecologist</option>
									<option>Pediatricians</option>
									
								</select></div> 
     <br><br>
     <h3><%if(session.getAttribute("insertStatus")!=null)
								out.print(session.getAttribute("insertStatus"));
								session.setAttribute("insertStatus",null);
								%></h3>
      <button class="btn btn-lg btn-success1 btn-block" type="submit">Register</button>
      <div class="registration">
          Already Registered?
          <a class="" href="DoctorLogin.jsp">
              Login
          </a>
      </div>
  </form>
   
</body>
</html>
