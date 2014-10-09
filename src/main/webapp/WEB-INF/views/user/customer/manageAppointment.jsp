<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>View Appointments</title>
<!-- 
<script type="text/javascript">
	function deleteAppointment(e) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
		  	xmlhttp = new XMLHttpRequest();
		}
		else { 
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
		    	location.reload(true);
		    }
		}
		xmlhttp.open("DELETE", "user/customer/manageAppointment/" + e.target.id, true);
		xmlhttp.send();
	}
</script> -->
<!-- <script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript"
	src="/coe/resources/jquery.simple-dtpicker.js"></script>
<link type="text/css" href="/coe/resources/jquery.simple-dtpicker.css"
	rel="stylesheet" /> -->
<link href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap.min.css"
	rel="stylesheet"></link>
	<script src="/coe/resources/bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
<link
	href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap-theme.min.css"
	rel="stylesheet"></link>
</head>




 <c:if test="${empty app}"> 
	<c:if test="${empty currentAppointment}">
		<c:if test="${empty currentOrderedFoodList}">
			<c:if test="${empty orderedFood}">
				<c:if test="${empty foodList}">
					<c:if test="${empty appointment}">
						<td>No Match Appointment Yet</td>
					</c:if>
				</c:if>
			</c:if>
		</c:if>
	</c:if>
	</c:if>
					
					<c:if test="${!empty appointment}">

						<table>
							<th>Appointment ID</th>
							<th>Appointment Start Time</th>
							<th>End Time</th>
							<th>Create Time</th>
							<th>Detail</th>
							<th>Booked Restaurant</th>

							<c:forEach items="${appointmentList}" var="appointment">
								<tr>
									<td>${appointment.appointmentId}</td>
									<td>${appointment.startTime}</td>
									<td>${appointment.endTime}</td>
									<td>${appointment.createTime}</td>
									<td>${appointment.detail}</td>
									<td>${appointment.restaurant.restaurantName}</td>
									<td>
										<%-- <a href="#" id="${appointment.appointmentId}" onclick="deleteAppointment(event)">Delete</a> --%>

										<a
										href="manageAppointment/delete/${appointment.appointmentId}"
										name="appointmentId"> Delete</a>
									</td>
									<td><a
										href="manageAppointment/${appointment.appointmentId}/orderFood"
										name="appointmentId"> Order Food</a></td>
									<td><a
										href="manageAppointment/${appointment.appointmentId}/viewOrderedFood"
										name="appointmentId">View Ordered Food</a></td>

								</tr>
							</c:forEach>
						</table>
						<%--  </form:form> --%>
					</c:if>

	<%-- </c:if> --%>
<!-- </div> -->

<c:if test="${empty appointment}">
<c:if test="${empty currentOrderedFood}">
<c:if test="${empty app}">
	<table>

		<th>Current Appointment</th>
		<th>Menu Name</th>
		<tr>
            
			<c:if test="${empty menu}">
				<td>No Menu Avaible</td>
			</c:if>
			
			<c:if test="${! empty currentAppointment}">
				<td>${currentAppointment.appointmentId}</td>
			</c:if>
		
			<c:if test="${! empty menu}">
				<%-- <c:forEach items="${menuList}" var="menu"> --%>
				<td>${menu.menuName}</td>
				<%-- 	</c:forEach> --%>
			</c:if>


		</tr>
		<c:if test="${! empty foodList}">
			<c:forEach items="${foodList}" var="food">
				<th>Dish Name</th>
				<th>Dish Price</th>

				<tr>
					<td>${food.foodName}</td>
					<td>${food.price}</td>
					<td><a href="orderFood/${food.foodId}/ordering" name="foodId">
							Add Dish</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
		</c:if>
	<%-- </form> --%>
	</c:if>

</c:if>

<c:if test="${empty appointment}">

	<c:if test="${empty currentOrderedFoodList}">
		<c:if test="${empty orderedFood}">
			<td>Do you want to order dish?</td>
		</c:if>
		<c:if test="${!empty orderedFood }">
			<table>
				<form:form class="inline" commandName="orderedFood" action="create"
					method="post">


					<tr>
						<form:label path="num">Number:</form:label>
						<form:input path="num" />
					</tr>
					<tr>
						<td>
							<td colspan="2"><input type="reset" value="cancel" /> <input
								type="submit" value="Add" /></td>
						</td>
					</tr>
				</form:form>
			</table>
		</c:if>
	</c:if>
</c:if>

<c:if test="${empty appointment}">
	<c:if test="${empty orderedFoodList}">
		<td></td>
	</c:if>

	<table>
		<c:if test="${! empty appointment}">
			<c:if test="${! empty orderedFood}">
				<th>Current Appointment</th>
				<td>${orderedFood.appointment.appointmentId}</td>
			</c:if>
		</c:if>
		<c:if test="${!empty orderedFoodList }">
			<th>Dish Name</th>
			<th>Dish Price</th>

			<tr>
				<c:forEach items="${orderedFoodList}" var="currentOrderedFood">
					<td>${orderedFood.food.foodName}</td>
					<td>${orderedFood.food.price}</td>
					<td>${orderedFood.num}</td>

				</c:forEach>
			</tr>
		</c:if>
	</table>

</c:if>

<c:if test="${empty appointment}">
<c:if test="${empty orderedFoodList}">
	<c:if test="${empty foodList}">
		<c:if test="${empty currentOrderedFood}">
		<c:if test="${empty app}">
			<td>No current Ordered Food</td>
			</c:if>
		</c:if>
	</c:if>
</c:if>
</c:if>

<%-- <c:if test="${!empty app }"> --%>
<c:if test="${!empty currentOrderedFood }">
	<%-- 	<c:if test="${!empty currentAppointment}"> --%>
	<table>
		<th>AppointmentId</th>

		<tr>
			<td>${currentOrderedFood.appointment.appointmentId}</td>
		</tr>
	</table>

	<table>

		<th>Dish Name</th>
		<th>Dish Price</th>
		<th>Dish Number</th>
		<c:forEach items="${currentOrderedFoodList}" var="currentOrderedFood">
		<tr>
			<%-- <td>${currentOrderedFood.appointment.appointmentId}</td> --%>

			
				<%-- 	<td>${currentOrderedFood.appointment.appointmentId}</td> --%>
				<td>${currentOrderedFood.food.foodName}</td>
				<td>${currentOrderedFood.food.price}</td>
				<td>${currentOrderedFood.num}</td>
				<%-- <td><a href="viewOrderedFood/${currentOrderedFood.foodId}/delete"
					name="foodId"> Delete</a></td> --%>
		
		</tr>
			</c:forEach>

	</table>
</c:if>
<%-- </c:if> --%>
<%-- </c:if> --%>





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
<!-- </body> -->
</html>