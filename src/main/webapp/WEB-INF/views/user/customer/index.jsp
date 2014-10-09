<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@ page session="false" %> --%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/screen.css" />"
	type="text/css" media="screen, projection"></link>
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/print.css" />" type="text/css"
	media="print"></link>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

<title>Customer Page</title>

<script type="text/javascript" src="/coe/resources/fullcalendar.js"></script>
<script type="text/javascript" src="/coe/resources/fullcalendar.min.js"></script>
<link type="text/css" href="/coe/resources/fullcalendar.css"
	rel="stylesheet" />
<link href="/coe/resources/bootstrap-3.2.0-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script type='text/javascript'>
	<br>
	$(document).ready(function() {
		<br>
		var date = new Date();
		<br>
		var d = date.getDate();
		<br>
		var m = date.getMonth();
		<br>
		var y = date.getFullYear();
		<br>
		$('#calendar').fullCalendar({
			editable : true,
			weekMode : 'liquid',
			url : '#',
			events : [ {
				title : 'Praent vestibulum',
				start : new Date(y, m, 1, 9, 00),
				end : new Date(y, m, 1, 10, 00),
				allDay : false
			}, {
				title : 'Vestibulum iaculis lacinia',
				start : new Date(y, m, 2, 16, 00),
				allDay : false
			}, {
				title : 'Integer rutrum ante eu lacus',
				start : new Date(y, m, 4, 16, 00),
				allDay : false
			}, {
				title : 'Aliquam erat volpat. Duis ac turpis',
				start : new Date(y, m, 9, 16, 00),
				allDay : false
			}, {
				title : 'Donec in velit vel ipsum',
				start : new Date(y, m, 10, 16, 00),
				allDay : false
			}, {
				title : 'Praent vestibulum',
				start : new Date(y, m, 13, 9, 00),
				allDay : false
			}, {
				title : 'Vestibulum iaculis lacinia',
				start : new Date(y, m, 15, 16, 00),
				allDay : false
			}, {
				title : 'Integer rutrum ante eu lacus',
				start : new Date(y, m, 17, 16, 00),
				allDay : false
			}, {
				title : 'nteger rutrum ante eu lacusi',
				start : new Date(y, m, 18, 16, 00),
				allDay : false
			}, {
				title : 'Integer rutrum ante eu lacus',
				start : new Date(y, m, 19, 16, 00),
				allDay : false
			}, {
				title : 'Integer rutrum ante eu lacus',
				start : new Date(y, m, 23, 16, 00),
				allDay : false
			}, {
				title : 'nteger rutrum ante eu lacus',
				start : new Date(y, m, 24, 16, 00),
				allDay : false
			}, {
				title : 'Integer rutrum ante eu lacus',
				start : new Date(y, m, 27, 16, 00),
				allDay : false
			}, {
				title : 'Integer rutrum ante eu lacus',
				start : new Date(y, m, 28, 16, 00),
				allDay : false
			}, {
				title : 'Vestibulum iaculis lacinia',
				start : new Date(y, m, 29, 16, 00),
				allDay : false
			}, {
				title : 'Praent vestibulum',
				start : new Date(y, m, 30, 9, 00),
				allDay : false
			} ]
		});

	});
</script>

</head>
<script src="/coe/resources/bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
<link
	href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap-theme.min.css"
	rel="stylesheet">
<body class="pic">
	


	<div id='cssmenu'>
		<ul>
			<li><a href='/coe' class='active'><span class="navSpan">Home</span></a></li>
			<li><a href="manageAppointment" target="myframe"><span class="navSpan">Manage
						Appointment</span></a></li>
						<!-- <li><a href="view"><span class="navSpan">Manage
						view order</span></a></li> -->
			<li><a href="viewRestaurant" target="myframe" ><span
					class="navSpan">View Restaurants</span></a></li>
			<li><a href="editProfile" target="myframe"><span
					class="navSpan">Edit Profile</span></a></li>
			<li class='last'><a
				href="<c:url value="/j_spring_security_logout" />"><span>Log
						out</span></a></li>
					<%-- <li class='last'>
					<a
				href="#"><span> Welcome
				<sec:authentication property="principal.username" />!
				</span></a></li> --%>

		</ul>
	</div>
	<div class="n1">
<%-- <p class="p">
		welcome!<br>
		<sec:authentication property="principal.username" />
		</p> --%>
		<div class="panel panel-success">
            <div class="panel-heading">
              <h3 class="panel-title">Logged in</h3>
            </div>
            <div class="panel-body">
            <p class="p">
		welcome!<br>
		<sec:authentication property="principal.username" />
		</p>
            </div>
    </div>
	</div>
	<div class="n2">
		<iframe name="myframe" id="myframe" frameborder="1"> </iframe>
	</div>
 <div class="n4">
 <div class="panel panel-info">
			<div class="panel-heading">
				<h3 class="panel-title">Welcome!</h3>
			</div>
			<div class="panel-body">
				<p class="c">Save Your Time For A Delicious Meal</p>

			</div>
		</div>
	</div>
<!-- 	<div id="calendar"></div> -->
	<script type="text/javascript">
		
	</script>
</body>
</html>