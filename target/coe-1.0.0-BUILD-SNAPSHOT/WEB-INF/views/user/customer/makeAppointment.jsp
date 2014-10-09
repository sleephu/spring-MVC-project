<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page import="edu.neu.coe.domain.*"%>
<%@ page import="java.util.List"%>
<%@ page import="edu.neu.coe.web.*"%>
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
<body>
	<h2>Make An Appointment!</h2>
	<form action="updateAppointment" method="post">
		<table>
			<tr>
				<td>Restaurant</td>
				<td><select name="restaurantList" id="restaurantId">
						<%
							Restaurant restaurant =(Restaurant)request.getAttribute("restaurant");
						List<Restaurant> restaurantList = (List)request.getAttribute("restaurantList");
						for(Restaurant r: restaurantList){
							 out.println("<option >");
						     out.println( r.getRestaurantName());
						 out.println("</option>");	
						}
						%>
				</select><br></td>
			</tr>

			<tr>
				<td>Start Time</td>
				<td><input type="text" name="startTime" value="" /><br> <script
						type="text/javascript">
					$(function() {
						$('*[name=startTime]').appendDtpicker();
					});
				</script></td>
			</tr>


			<tr>
				<td>End Time</td>
				<td>
					<%-- <form:input path="telephoneNo"/> --%> <input type="text"
					name="endTime" value=""><br> <script
						type="text/javascript">
						$(function() {
							$('*[name=endTime]').appendDtpicker();
						});
					</script>

				</td>
			</tr>

			<tr>
				<td>Detail</td>
				<td>
					<%-- <form:input path="details"/> --%> <input type="text"
					name="detail">
				</td>
			</tr>


			<tr>
				<td colspan="2"><input type="reset" value=cancel> <input
					type="submit" value="save"> <!-- <input type="submit" name="action" value="delete"> -->
					<!-- <input type="submit" name="action" value="Edit Address"> --></td>
			</tr>
		</table>
	</form>


	<table>
		<th>Appointment Start Time</th>
		<th>Appointment Start Time</th>
		<th>Detail</th>
		<th>Create Time</th>
		<th>Restaurant</th>

		<%--  <tr>
<td>{appointment.appointmentId}</td>
<c:forEach items="${appointmentList}" var="appointment">

<td>${appointment.startTime}</td>
<td>${appointment.endTime}</td>
<td>${appointment.restaurant.restaurantName}</td>
<td>${appointment.detail}</td>
<td>${appointment.createTime}</td>
</c:forEach>
</tr>  --%>
		<%
			Appointment appointment = (Appointment) request
					.getAttribute("appointment");

			out.println("<tr>");
			out.println("<td>" + request.getParameter("startTime") + "</td>");
			out.println("<td>" + request.getParameter("endTime") + "</td>");
			out.println("<td>" + appointment.getCreateTime() + "</td>");
			out.println("<td>" + request.getParameter("restaurant") + "</td>");


			out.println("</tr>");
		%>

	</table>


	<%-- <c:if test="${not empty message}">
		<div class="message green">${message}</div>
	</c:if>
	<form:form modelAttribute="makeAppointmentForm" action="makeAppointment">


		<table>
			<tr>
				<form:label path="restaurant">Restaurant:</form:label>
				<form:select path="restaurant" id="restaurant">
					<form:option value="">Select restaurant: </form:option>
					<c:forEach items="${restaurantList}" var="restaurant">
						<form:option value="${restaurant}">${restaurant}</form:option>
					</c:forEach>
				</form:select>
			</tr>

			<form:label path="appointment.startTime">Appointment Start Time:</form:label>
			<form:input path="appointment.startTime" value="" />
			<script type="text/javascript">
				$(function() {
					$('*[name=appointment.startTime]')
							.appendDtpicker();
				});
			</script>
			<tr>
				<form:label path="appointment.endTime">End Time:</form:label>
				<form:input path="appointment.endTime" />
				<script type="text/javascript">
					$(function() {
						$('*[name=appointment.endTime]')
								.appendDtpicker();
					});
				</script>
			</tr>
			<tr>
				<form:label path="makeAppointmentForm.appointment.detail">Detail:</form:label>
				<form:input path="makeAppointmentForm.appointment.detail" />
			</tr>
			<tr>
				<td>
				<td colspan="2"><input type="reset" value="cancel" /> <input
					type="submit" value="save" /></td>
				</td>
			</tr>
		</table>


	</form:form>
	<form:form class="inline" commandName="appointment"
		action="makeAppointment" method="post">

	</form:form>

	<br>

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
						href="makeAppointment/${appointment.appointmentId}/orderFood"
						name="appointmentId"> Order Food</a></td>

				</tr>
			</c:forEach>
		</table>
	</c:if> --%>



</body>
</html>