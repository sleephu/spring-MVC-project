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
<title>Edit Profile</title>
<link href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<script src="/coe/resources/bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
<link
	href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap-theme.min.css"
	rel="stylesheet">


<div class="n2">
	<form action="updateProfile" method="post">
		<table>
			<th>Edit Your Profile</th>
			<tr>
				<td>Restaurant Name</td>
				<td>
					<%-- <form:input path="restaurantName"/> --%> <input type="text"
					name="restaurantName"><br>
				</td>
			</tr>


			<tr>
				<td>Telephone</td>
				<td>
					<%-- <form:input path="telephoneNo"/> --%> <input type="text"
					name="telephoneNo">
				</td>
			</tr>

			<tr>
				<td>Details</td>
				<td>
					<%-- <form:input path="details"/> --%> <input type="text"
					name="details">
				</td>
			</tr>

			<!-- <th>Edit Address</th> -->
			<tr>
				<td>Country</td>
				<td><input type="text" name="country"></td>
			</tr>
			<tr>
				<td>State</td>
				<td>
					<%-- <form:input path="state"/>  --%> <input type="text"
					name="state">
				</td>
			</tr>
			<tr>
				<td>City</td>
				<td>
					<%-- <form:input path="city"/>  --%> <input type="text" name="city">
				</td>
			</tr>

			<tr>
				<td>Street</td>
				<td>
					<%-- <form:input path="street"/>  --%> <input type="text"
					name="street">
				</td>
			</tr>

			<tr>
				<td>ZipCode</td>
				<td>
					<%-- <form:input path="street"/>  --%> <input type="text"
					name="zipCode">
				</td>
			</tr>

			<tr>
				<td colspan="2"><input type="reset" value=cancel> <input
					type="submit" value="save"> <!-- <input type="submit" name="action" value="delete"> -->
					<!-- <input type="submit" name="action" value="Edit Address"> --></td>
			</tr>
		</table>
	</form>
	<%-- </form:form> --%>
	<br>

	<table>

		<%
			/*  List<Restaurant> restaurantList = (List)request.getAttribute("restaurant"); */

			/*  for(Restaurant restaurant: restaurantList){ */
			if (request.getParameter("restaurantName") == null) {
				out.println("No Profile Yet");
			} else {
		%>
		<th>Restaurant Name</th>
		<th>Telephone</th>
		<th>Details</th>
		<th>Country Name</th>
		<th>State</th>
		<th>City</th>
		<th>Street</th>
		<th>ZipCode</th>
		<%
			out.println("<tr>");
				out.println("<td>" + request.getParameter("restaurantName")
						+ "</td>");
				out.println("<td>" + request.getParameter("telephoneNo")
						+ "</td>");
				out.println("<td>" + request.getParameter("details") + "</td>");
				out.println("<td>" + request.getParameter("country") + "</td>");
				out.println("<td>" + request.getParameter("state") + "</td>");
				out.println("<td>" + request.getParameter("city") + "</td>");
				out.println("<td>" + request.getParameter("street") + "</td>");
				out.println("<td>" + request.getParameter("zipCode") + "</td>");
				out.println("</tr>");
			}
			/*  } */
		%>
		<%-- <c:if test="${restaurant ==null}">
<tr>
<td colspan="4">No Results found</td>
</tr>
</c:if>
<c:if test="${! empty restaurantId}">
<c:forEach items="${restaurantList}" var="restaurant">
<tr>
<td>${restaurant.restaurantName}</td>
<td>${restaurant.telephoneNo}</td>
<td>${restaurant.address.country}</td>
<td>${restaurant.address.state}</td>
<td>${restaurant.address.city}</td>
<td>${restaurant.address.street}</td>
</tr>
</c:forEach>
</c:if>  --%>
	</table>
	<!-- <iframe name="myframe" id="myframe" frameborder="1" > -->
	<%-- <form:form class="inline" action="user/restaurant/updateProfile" modelAttribute="restaurant" method="post"> --%>



	<%-- <form:form class="inline" action="user/restaurant/manageAddress" method="post">
<table>
<th>Edit Address</th>
<tr>
<td>Country</td>
<td><form:input path="country"/> </td>
</tr>
<tr>
<td>State</td>
<td><form:input path="state"/> </td>
</tr>
<tr>
<td>City</td>
<td><form:input path="city"/> </td>
</tr>
<tr>
<td>Street</td>
<td><form:input path="street"/> </td>
</tr>

<tr>
<td colspan="2"> 
<input type="submit" name="action" value="add">
<input type="submit" name="action" value="edit">
<input type="submit" name="action" id="${addressId}" value="delete">
</td>
</tr>

</table>
</form:form>
<br>
<table>
<th>Country Name</th>
<th>State</th>
<th>City</th>
<th>Street</th>
<c:if test="${empty Restaurant_Address_KEY}">
<tr>
<td colspan="4">No Results found</td>
</tr>
</c:if>
<c:if test="${! empty Restaurant_Address_KEY}">
<c:forEach items="${address}" var="address">
<tr>
<td>${address.country}</td>
<td>${address.state}</td>
<td>${address.city}</td>
<td>${address.street}</td>
</tr>
</c:forEach>
</c:if> 
</table> --%>

	<!-- </iframe> -->
</div>

</body>
</html>