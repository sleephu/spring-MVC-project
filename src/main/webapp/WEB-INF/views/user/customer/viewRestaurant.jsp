<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>View Restaurant</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="/coe/resources/jquery.simple-dtpicker.js"></script>
<link type="text/css" href="/coe/resources/jquery.simple-dtpicker.css"
	rel="stylesheet" />

<script src="jquery.js" type="text/javascript"></script>
<script src="jquery.maskedinput.js" type="text/javascript"></script>
<link href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<script src="/coe/resources/bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
<link
	href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap-theme.min.css"
	rel="stylesheet">
<c:if test="${empty addressList}">
	<c:if test="${empty foodList}">
		<c:if test="${empty appointment}">
			<c:if test="${empty restaurantList}">
				<tr>
					<td>No Restaurant Yet</td>
				</tr>
			</c:if>
		</c:if>
	</c:if>
</c:if>

<c:if test="${empty addressList}">
	<c:if test="${empty foodList}">
		<c:if test="${empty appointment}">
			<table>
				<th>Restaurant Name</th>
				<th>Restaurant Telephone</th>
				<th>Details</th>
				<th>Address</th>
				<th>Menu</th>

				<c:if test="${! empty restaurantList}">
					<c:forEach items="${restaurantList}" var="restaurant">

						<tr>
							<td>${restaurant.restaurantName}</td>
							<td>${restaurant.telephone}</td>
							<td>${restaurant.detail}</td>
							<%-- <c:if test="${empty addressList}">
							<td>Address Not Avaible</td>
						</c:if> --%>
							<%-- <c:if test="${! empty addressList}"> --%>

							<%-- <c:forEach items="${addressList}" var="address">
								<td>${address.street},${address.city},${address.state},
									${address.country}, ${address.zipCode}</td>
							</c:forEach> --%>
							<td><a
								href="viewRestaurant/${restaurant.restaurantId}/viewAddress"
								name="restaurantId">Address </a></td>
							<%-- </c:if> --%>
							<td><a
								href="viewRestaurant/${restaurant.restaurantId}/viewMenu"
								name="restaurantId">${restaurant.menu.menuName} </a></td>
							<td><a
								href="viewRestaurant/${restaurant.restaurantId}/makeAppointment"
								id="${restaurant.restaurantId}" name="restaurantId"> <!-- 		onclick="deleteCustomer(event)" -->
									Make Appointment
							</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</table>
		</c:if>
	</c:if>
</c:if>
<br>


<c:if test="${!empty addressList}">
	<table>
		<th>Restaurant</th>
		<tr>
			<td>${address.restaurant.restaurantName}</td>
		</tr>

		<th>Country</th>
		<th>State</th>
		<th>City</th>
		<th>Street</th>
		<th>ZipCode</th>

		<c:if test="${empty addressList}">
			<td>Address Not Avaible</td>
		</c:if>
		<c:forEach items="${addressList}" var="address">
			<tr>
				<td>${address.country}</td>
				<td>${address.state}</td>
				<td>${address.city}</td>
				<td>${address.street}</td>
				<td>${address.zipCode}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>


<c:if test="${! empty menu}">
	<table>
		<th>Menu Name</th>
		<tr>
			<c:if test="${empty menu}">
				<td>No Menu Avaible</td>
			</c:if>
			<td>${menu.menuName}</td>
		</tr>
		<c:if test="${! empty foodList}">
			<th>Dish Name</th>
			<th>Dish Price</th>
			<c:forEach items="${foodList}" var="food">
				<tr>
					<td>${food.foodName}</td>
					<td>${food.price}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</c:if>



<c:if test="${empty appointment}">
	<td>Do you want to make an appointment?</td>
</c:if>
<c:if test="${!empty appointment }">
	<table>
		<form:form class="inline" commandName="appointment" action="create"
			method="post">
			<tr>
				<form:label path="startTime">Appointment Start Time:</form:label>
				<form:input path="startTime" id="st" value="" />
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
				<td>
				<td colspan="2"><input type="reset" value="cancel" /> <input
					type="submit" value="save" /></td>
				</td>
			</tr>
		</form:form>
	</table>
</c:if>
</html>