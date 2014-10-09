<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Edit Profile</title>
<!-- <script type="text/javascript">
	function deleteCustomer(e) {
		var xmlhttp;
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				location.reload(true);
			}
		}
		xmlhttp
				.open("DELETE", "user/customer/editProfile/" + e.target.id,
						true);
		xmlhttp.send();
	}
</script> -->
</head>
<%-- <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection"></link>
<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print"></link>
<body class="pic">
<h1>
	Save Your Time For A Delicious Meal 
</h1>
<div id='cssmenu'>
<ul>
    <li  ><a href='home.jsp' ><span class="navSpan">Home</span></a></li>
   <li><a href='#'><span class="navSpan">Make Appointment</span></a></li>
   <li><a href='#'><span class="navSpan">View Restaurants</span></a></li>
    <li><a href='#'  class='active'><span class="navSpan">Edit Profile</span></a></li>
   <li class='last' ><a href='#'><span>Log out</span></a></li>
  
</ul>
</div>
<div class="n1">
welcome!
<!-- <sec:authentication property="principal.username"/> -->
</div> --%>

<div class="n2">
	<form:form class="inline" commandName="customer" action="editProfile"
		method="post">
		<table>
			<th>Edit Your Profile</th>
			<tr>
				<td><form:label path="firstName" cssErrorClass="error">First Name</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>

			<tr>
				<td><form:label path="lastName" cssErrorClass="error">Last Name</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>

			<tr>
				<td><form:label path="gender" cssErrorClass="error">Gender</form:label></td>
				<td><form:radiobutton path="gender" value="M" /> Mr. <form:radiobutton
						path="gender" value="F" />Miss./Mrs.</td>
			</tr>

			<tr>
				<td><form:label path="telephoneNo" cssErrorClass="error">Telephone</form:label></td>
				<td><form:input path="telephoneNo" /></td>
			</tr>

			<tr>
				<td><form:label path="email" cssErrorClass="error">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="reset" value="cancel"/>
				 <input type="submit" value="save"/></td>
			</tr>
		</table>
	</form:form>
	<br>
	<table>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Gender</th>
		<th>Telephone</th>
		<th>Email</th>

		<c:if test="${! empty customerList}">
			<c:forEach items="${customerList}" var="customer">
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.gender}</td>
					<td>${customer.telephoneNo}</td>
					<td>${customer.email}</td>
					<td>
					<a href="editProfile/delete/${customer.customerId}"
					<%--  id="${customer.customerId}" --%>
					name="customerId">
				<!-- 		onclick="deleteCustomer(event)" -->
						Delete</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<!-- <iframe name="myframe" id="myframe" frameborder="1" >

</iframe> -->
</div>
<%-- <div class="n3">
	<p>Now is
	${serverTime}
	</p>
</div>
 --%>
</body>
</html>