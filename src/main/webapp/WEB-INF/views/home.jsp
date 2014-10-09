<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Welcome to Picking Restaurant</title>
<link href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="/coe/resources/bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
<link
	href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/screen.css" />"
	type="text/css" media="screen, projection"></link>
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/print.css" />" type="text/css"
	media="print"></link>

<body class="pic">

	<div id='cssmenu' >
		<ul  >
			<li class='active'><a href='/coe'><span class="navSpan">Home</span></a></li>
			<li><a href='news' target="myframe"><span class="navSpan">News</span></a></li>
			<li><a href='about' target="myframe"><span class="navSpan">About</span></a></li>
			<li><a href='registerC'><span class="navSpan">Customer
						Sign Up</span></a></li>
			<%-- <c:url var="register" value="user/register" /> --%>
			<li class='last' id="nav"><a href='registerE'><span>Enterprise
						Sign Up</span></a> <%-- <ul>
  <c:url var="cRegister" value="user/customer/register" />
   <li class='last' id="cRegister"><a id="register"  href="{cRegister}" ><span>Customer Sign Up</span></a>
    <c:url var="eRegister" value="user/restaurant/register" />
    <li class='last' id="eRegister"><a id="register" href="{eRegister}" ><span>Enterprise Sign Up</span></a>
  </ul> --%></li>

            
		</ul>
	</div>
	<div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Login <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a  href="user/customer/">Customer Login</a></li>
                  <li><a href="user/restaurant/">Enterprise Login</a></li>
                  <li><a href="admin">Admin Login</a></li>
                 
                </ul>
              </li>
            </ul>
          </div><!--/.nav-collapse -->
 
 


	<h1></h1>
	<div class="n1">
		<!-- <p>
			<a class="a" href="user/customer/">Customer Login</a>
		</p>
		<p>
			<a class="a" href="user/restaurant">Enterprise Login</a>
		</p>
		<p>
			<a class="a" href="admin">Admin Login</a>
		</p> -->
		

	</div>

	<div class="n2">
		<iframe name="myframe" id="myframe">
			<!-- <div>
				<a id="getAll">Get user JSON </a>
				<table class="table table-hover">
					<thead>
						<tr>
							<td>User Name</td>
							<td>Last Name</td>
						</tr>
					</thead>
					<tbody></tbody>
				</table>
			</div> -->
		</iframe>
	</div>
	<div class="n3">
	<div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title">Welcome</h3>
            </div>
            <div class="panel-body">
            <p class="c">
            Save Your Time For A Delicious Meal@_@
            </p>
            Now is ${serverTime}
            </div>
          </div>
        </div><!-- /.col-sm-4 -->
		
	
  

</body>
</html>
