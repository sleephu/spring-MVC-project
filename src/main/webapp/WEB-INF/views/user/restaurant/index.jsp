<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page session="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Enterprise Page</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/screen.css" />"
	type="text/css" media="screen, projection"></link>
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/print.css" />" type="text/css"
	media="print"></link>
<link href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<script src="/coe/resources/bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
<link
	href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap-theme.min.css"
	rel="stylesheet">
<body class="pic">
	<!-- <h1>Promote Your Delicious meal!</h1> -->
	<div id='cssmenu'>
		<ul>
			<li><a href='/coe' class='active'><span class="navSpan">Home</span></a></li>
			<li><a href="manageMenu" target="myframe"><span
					class="navSpan">Manage Menu</span></a></li>
			<li><a href="editProfile" target="myframe"><span
					class="navSpan">Edit Profile</span></a></li>
			<li><a href="manageCustomer" ><span
					class="navSpan">View Customer Appointment</span></a></li>
			<li class='last'><a
				href="<c:url value="/j_spring_security_logout" />"><span>Log
						Out</span></a></li>

		</ul>
	</div>
	<div class="n1">

		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">Logged in</h3>
			</div>
			<div class="panel-body">
				<p class="p">
					welcome!<br>
					<sec:authentication property="principal.username" />
					<br>

				</p>
			</div>
		</div>
	</div>

	<div class="n2">

		<iframe name="myframe" id="myframe" frameborder="1"> </iframe>
	</div>
	<div class="n3">

		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Welcome!</h3>
			</div>
			<div class="panel-body">
				<p class="p">Promote Your Delicious meal!</p>

			</div>
		</div>
	</div>

</body>
</html>