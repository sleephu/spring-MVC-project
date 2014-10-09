<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Welcome to Join us!</title>
<link href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap.min.css"
rel="stylesheet">
</head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/screen.css" />"
	type="text/css" media="screen, projection"></link>
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/print.css" />" type="text/css"
	media="print"></link>
<script src="/coe/resources/bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
<link
	href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap-theme.min.css"
	rel="stylesheet">
<body class="pic">

	<div id='cssmenu'>
		<ul>
			<li><a href='/coe'><span class="navSpan">Home</span></a></li>
			<!-- <li><a href='news' target="myframe"><span class="navSpan">News</span></a></li>
			<li><a href='about' target="myframe"><span class="navSpan">About</span></a></li>
			<li><a href='contact' target="myframe"><span class="navSpan">Contact</span></a></li> -->
			<%-- <c:url var="register" value="user/register" /> --%>
			<li class='active' id="nav"><a href='register'><span>Sign
						Up</span></a> <%-- <ul>
  <c:url var="cRegister" value="user/customer/register" />
   <li class='last' id="cRegister"><a id="register"  href="{cRegister}" ><span>Customer Sign Up</span></a>
    <c:url var="eRegister" value="user/restaurant/register" />
    <li class='last' id="eRegister"><a id="register" href="{eRegister}" ><span>Enterprise Sign Up</span></a>
  </ul> --%></li>
  <li><a  href="user/restaurant"><span class="navSpan">Enterprise Login</span></a></li>
		</ul>
	</div>
<!-- 	<h1>Welcome to Join us!</h1> -->
	<div class="n1">
		<!--  <p><a href="user/customer/index.jsp" target="myframe">Customer Login</a></p> -->
		<!-- <p>
			<a class="a" href="user/restaurant">Enterprise Login</a>
		</p> -->

	</div>
	<div class="n2" id="text">
		<form:form class="inline" action="registerE" modelAttribute="user"
			method="post">
			<form:label path="userName">User Name:</form:label>
			<form:input path="userName" />
			<br />
			<form:label path="password">Password:</form:label>
			<form:input type="password" path="password" />
			<br />
			<%-- 	<form:label path="role">Type:</form:label>
	<form:radiobutton path="role" value="customer"/>Customer
	<form:radiobutton path="role" value="restaurant"/>Restaurant<br/> --%>
			<input type="reset" class="btn btn-primary" value="Cancel" />
			<span class="navSpan"></span>
			<input type="submit" class="btn btn-primary" value="Register" />
		</form:form>



		<c:if test="${! empty user.userName}">
			<table>
				<th>User Name</th>
				<th>Password</th>

				<%-- <c:if test="${empty user.userName} ">
				<tr>
					<td>Not Sign up Yet!</td>
					</tr>
				</c:if> --%>
				<tr>
					<td>${user.userName}</td>
					<td>${user.password}</td>

				</tr>
			</table>
		</c:if>


		<iframe name="myframe" id="myframe"> </iframe>
	</div>
	<div class="n3">
		<div class="panel panel-info">
            <div class="panel-heading">
              <h3 class="panel-title"> Hello</h3>
            </div>
            <div class="panel-body">
            <p class="p">Welcome to Join us!</p>
            </div>
          </div>
	</div>




</body>
</html>
