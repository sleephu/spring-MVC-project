<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Register-Join us</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="/coe/resources/jquery.simple-dtpicker.js"></script>
<link type="text/css" href="/coe/resources/jquery.simple-dtpicker.css"
	rel="stylesheet" />
</head>
<%-- <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/screen.css" />"
	type="text/css" media="screen, projection"></link>
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/print.css" />" type="text/css"
	media="print"></link>
<body class="pic">
	<h1>Save your time to have a nice meal!</h1>
	<div id='cssmenu'>
		<ul>
			<li><a href='home.jsp'><span class="navSpan">Home</span></a></li>
			<li><a href='#' class='active'><span class="navSpan">Make
						Appointment</span></a></li>
			<li><a href='#'><span class="navSpan">View
						Restaurants</span></a></li>
			<li><a href='#'><span class="navSpan">Edit Profile</span></a></li>
			<li class='last'><a href='#'><span>Log out</span></a></li>

		</ul>
	</div>
	<div class="n1">welcome to join us!</div> --%>

<div class="n2">

<!-- 	<table> -->
		<%-- 	<form:form  commandName="restaurant"> --%>
		<%-- <form:select path="restaurantList" multiple="false" size="1">
<form:options items="${restaurantList}" itemValue="restaurant" itemLabel="restaurant"/>
</form:select> --%>
		<%-- </form:form> --%>
		<%-- 	<form:form class="inline" commandName="appointment" action="manageAppointment"
				method="post"> --%>
		<%-- 				
				<tr>
					<form:label path="restaurant">Restaurants:</form:label>
					<form:input path="restaurant" />
					<script type="text/javascript">
						$(function() {
							$('*[name=startTime]').appendDtpicker();
						});
					</script>
				<tr>
					<form:label path="endTime">End Time:</form:label>
					<form:input path="endTime" />
					<script type="text/javascript">
						$(function() {
							$('*[name=endTime]').appendDtpicker();
						});
					</script>
				</tr>
				
				<tr>
					<form:label path="startTime">Appointment Start Time:</form:label>
					<form:input path="startTime" value="" />
					<script type="text/javascript">
						$(function() {
							$('*[name=startTime]').appendDtpicker();
						});
					</script>
				<tr>
					<form:label path="endTime">End Time:</form:label>
					<form:input path="endTime" />
					<script type="text/javascript">
						$(function() {
							$('*[name=endTime]').appendDtpicker();
						});
					</script>
				</tr>
				<tr>
					<form:label path="detail">Detail:</form:label>
					<form:input path="detail" />
				</tr>
				<tr>
					<td><td colspan="2"><input type="reset" value="cancel"/>
				 <input type="submit" value="save"/></td></td>
				</tr>
			</form:form>
		</table>
		<br> --%>
		<%-- <form:form class="inline" action="manageAppointment"
			method="post"> --%>
		<c:if test="${empty appointment.createTime}">
			<td>No Appointment Yet</td>
		</c:if>
		<c:if test="${!empty appointment.createTime}">
			<table>
				<th>Appointment Start Time</th>
				<th>End Time</th>
				<th>Create Time</th>
				<th>Detail</th>
				<th>Booked Restaurant</th>

				<c:forEach items="${appointmentList}" var="appointment">
					<tr>
						<td>${appointment.startTime}</td>
						<td>${appointment.endTime}</td>
						<td>${appointment.createTime}</td>
						<td>${appointment.detail}</td>
						<td>${appointment.restaurant.restaurantName}}</td>
						<td><a
							href="manageAppointment/delete/${appointment.appointmentId}"
							name="appointmentId"> Delete</a></td>
						<td><a
							href="manageAppointment/${appointment.appointmentId}/orderFood"
							name="appointmentId"> Order Food</a></td>
							
					</tr>
				</c:forEach>
			</table>
		</c:if>
		</div>
		<%-- 		</form:form> --%>
		<%-- <iframe name="myframe" id="myframe" frameborder="1"> </iframe>
	</div>
	<div class="n3">
		<p>Now is ${serverTime}</p>
	</div>
	<script type="text/javascript">
		$("input[type=radio]").click(function() {
			if (document.getElementById('customer').checked) {
				{
				}
			} else if (document.getElementById('restaurant').checked) {

			}

		});
	</script> --%>
		</body>
</html>