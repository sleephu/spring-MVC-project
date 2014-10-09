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

</head>
<%-- <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection"></link>
<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print"></link>
<body class="pic"> --%>
<!-- <h1>
	Save your time to have a nice meal!
</h1>
<div id='cssmenu'>
<ul>
   <li  ><a href='/coe' ><span class="navSpan">Home</span></a></li>
   <li><a href='#'><span class="navSpan">Make Appointment</span></a></li>
   <li><a href='#' class='active'><span class="navSpan">View Restaurants</span></a></li>
    <li><a href='#'  ><span class="navSpan">Edit Profile</span></a></li>
   <li class='last' ><a href='#'><span>Log out</span></a></li>
  
</ul>
</div>
<div class="n1">

welcome to join us!


</div> -->

<div class="n2">
	<%-- <form:form class="inline" commandName="restaurant" action="viewRestaurant" method="post"> --%>
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
					<c:if test="${empty addressList}">
						<td>Address Not Avaible</td>
					</c:if>
					<c:if test="${! empty addressList}">
						<c:forEach items="${addressList}" var="address">
							<td>${address.street},${address.city}, ${address.state},
								${address.country}, ${address.zipCode}</td>
						</c:forEach>
					</c:if>
					<td>${restaurant.menu.menuName}<a
						href="viewRestaurant/${restaurant.restaurantId}/viewMenu"
						<%--  id="${customer.customerId}" --%>
					name="restaurantId">
							<!-- 		onclick="deleteCustomer(event)" --> View Menu
					</a>
					</td>
					<td><a
						href="viewRestaurant/${restaurant.restaurantId}/create"
						id="${restaurant.restaurantId}" name="restaurantId"> 
						<!-- 		onclick="deleteCustomer(event)" -->
							Make Appointment
					</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<%-- </form:form> --%>
	<br>

	<c:if test="${! empty foodList}">
		<c:forEach items="${foodList}" var="food">
			<table>
				<th>Menu Name</th>
				<th>Dish Name</th>
				<th>Dish Price</th>
				<c:if test="${empty menu}">
					<td>No Menu Avaible</td>
				</c:if>
				<tr>
					<c:if test="${! empty menu}">
						<c:forEach items="${menuList}" var="menu">
							<td>${menu.menuName}</td>
						</c:forEach>
					</c:if>
					<td>${food.foodName}</td>
					<td>${food.price}</td>
			</table>
		</c:forEach>
	</c:if>
	
	
	







	<%-- <iframe name="myframe" id="myframe" frameborder="1" >



<form:form class="inline" action="user/customer/manageAppointment" method="post">
<table>
<th>Country Name</th>
<th>State</th>
<th>City</th>
<th>Street</th>
<c:forEach items="${appointmentList}" var="customer">
<tr>
<td>${address.country}</td>
<td>${address.state}</td>
<td>${address.city}</td>
<td>${address.street}</td>
<td><input type="submit" name="view" id="${restaurant.id}" value="Make Appointment"></td>
</tr>
</c:forEach>
</table>
</form:form>
</iframe> --%>
	</div>
<%-- <div class="n3">
	<p>Now is
	${serverTime}
	</p>
</div> --%>
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