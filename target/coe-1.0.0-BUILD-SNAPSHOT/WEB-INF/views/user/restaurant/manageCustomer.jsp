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
</head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/screen.css" />"
	type="text/css" media="screen, projection"></link>
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/print.css" />" type="text/css"
	media="print"></link>
<body class="pic">
	<h1>Promote Your Delicious meal!</h1>
	<div id='cssmenu'>
		<ul>
			<li><a href='home.jsp'><span class="navSpan">Home</span></a></li>
			<li><a href='#'><span class="navSpan">Create Menu</span></a></li>
			<li><a href='#'><span class="navSpan">Edit
						Appointment Time</span></a></li>
			<li><a href='#'><span class="navSpan">Edit Profile</span></a></li>
			<li><a href='#' class='active'><span class="navSpan">View
						Customer</span></a></li>
			<li class='last'><a href='#'><span>Log Out</span></a></li>


		</ul>
	</div>
	<div class="n1">welcome to join us!</div>

	<div class="n2">
		<%-- <form:form class="inline" action="user/restaurant/viewCustomer" method="get">
<table>
<th>First Name</th>
<th>Last Name </th>
<th> Gender</th>
<th> Telephone</th>
<th> Email</th>

<c:forEach items="${customerList}" var="customer">
<tr>
<td>${customer.firstName }</td>
<td>${customer.lastName }</td>
<td>${customer.gender }</td>
<td>${customer.telephone }</td>
<td>${customer.email }</td>
<td> <input type="submit" name="manageCustomer" value="view Appointment Detail"></td>
</tr>
</c:forEach>

</table>
</form:form>
<br> --%>
		<%-- <form:form class="inline"  action="user/restaurant/viewOrder" method="get"> --%>

		<table>
			<th>appointment Start Time</th>
			<th>appointment End Time</th>
			<th>create Time</th>
			<th>Detail</th>


			<tr>
				<c:if test="${empty appointmentList}">
					<td>No Appointment Yet</td>
				</c:if>
				<c:if test="${ !empty appointmentList}">
					<c:forEach items="${appointmentList}" var="appointment">
						<td>${appointment.startTime}</td>
						<td>${appointment.endTime}</td>
						<td>${appointment.createTime}</td>
						<td>${appointment.detail}</td>
						<td><a
							href="manageCustomer/viewOrder/${appointment.appointmentId}"
							<%--  id="${customer.customerId}" --%>
					name="customerId">
								<!-- 		onclick="deleteCustomer(event)" --> Delete
						</a></td>
					</c:forEach>
				</c:if>
			</tr>

		</table>


		<%-- </form:form> --%>
		<br>

		<%-- <form:form class="inline" action="user/viewOrder" method="get">
<table>
<th>Ordered Food Name</th>
<th> Quantity</th>

<c:forEach items="${orderedFoodList}" var="orderedFood">
<tr>
<td>{orderedFood.name}</td>
<td>{orderedFood.quantity}</td>

</tr>
</c:forEach>
</table>
</form:form> --%>
		<iframe name="myframe" id="myframe" frameborder="1"> </iframe>
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
	</script>
</body>
</html>