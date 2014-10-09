<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Join us</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="/coe/resources/jquery.simple-dtpicker.js"></script>
	<link type="text/css" href="/coe/resources/jquery.simple-dtpicker.css" rel="stylesheet" />
</head>




<%-- <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection"></link>
<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print"></link>
<body class="pic">
<h1>
	Promote Your Delicious meal!
</h1>
<div id='cssmenu'>
<ul>
   <li  ><a href='home.jsp' ><span class="navSpan">Home</span></a></li>
   <li><a href='#'><span class="navSpan">Create Menu</span></a></li>
   <li><a href='#' class='active'><span class="navSpan">Edit Appointment Time</span></a></li>
    <li><a href='#'><span class="navSpan">Edit Profile</span></a></li>
        <li><a href='#'><span class="navSpan">View Customer Appointment</span></a></li>
   <li class='last' ><a href='#'><span>Log Out</span></a></li>
  
</ul>
</div>
<div class="n1">

welcome!{restaurant.name}
</div> --%>

<div class="n2">

<form action="updateAppointment" method="post">
<table>
<th>Manage Appointment Time</th>
<tr>
<td> Start Time</td>
<td> 
<%-- <form:input path="restaurantName"/> --%>
<input type="text"  name ="startTime" value=""/><br>
<script type="text/javascript">
		$(function(){
			$('*[name=startTime]').appendDtpicker();
		});
	</script>
</td>
</tr>


<tr>
<td> End Time</td>
<td>
<%-- <form:input path="telephoneNo"/> --%>
<input type="text" name="endTime" value=""><br>
<script type="text/javascript">
		$(function(){
			$('*[name=endTime]').appendDtpicker();
		});
	</script>

</td>
</tr>

<tr>
<td> Detail</td>
<td>
<%-- <form:input path="details"/> --%>
<input type="text" name="detail">
 </td>
</tr>


<tr>
<td colspan="2"> 
<input type="reset" value=cancel>
<input type="submit"  value="save">
<!-- <input type="submit" name="action" value="delete"> -->
<!-- <input type="submit" name="action" value="Edit Address"> -->
</td>
</tr>
</table>
</form>

<table>
<th>Appointment Start Time</th>
<th>Appointment Start Time</th>
<th>Detail</th>
<th>Create Time</th>

<%-- <tr>
<td>{menu.menuName}</td>
<c:forEach items="${menuFood}" var="food">

<td>${food.foodName}</td>
<td>${food.price}</td>
</c:forEach>
</tr> --%>
 <%
    /*  List<Food> foodList = (List)request.getAttribute("menuFood"); 
 
    for(Food f: foodList){  */
        out.println("<tr>");
            out.println("<td>" +request.getParameter("menuName") + "</td>");
            out.println("<td>" +request.getParameter("foodName")+ "</td>");
            out.println("<td>" +request.getParameter("price")+ "</td>");    
            %> 
            <td> {createTime}</td>
            <%
        out.println("</tr>");
  /*    }  */
 
 %>
</table>


<%-- <table>
<form:form class="inline" action="restaurant/updateAppointment" method="post">
<tr>
<form:label path="startTime">Appointment Time:</form:label>
	<form:input path="startTime"/>
	</tr>
	<tr>
<form:label path="endTime">Appointment Time:</form:label>
	<form:input path="endTime"/>
	</tr>
	
	<tr>
<form:label path="createTime">Create Time:</form:label>
	<form:input path="createTime"/>
	</tr>
	<tr>
	<form:label path="detail">Detail:</form:label>
	<form:input path="detail"/>
	</tr>
<tr>
<td>
<input type="button" name="action" value="Add"/>
<span class="navSpan"></span>
<input type="button" name="action" value="Edit"/>
<span class="navSpan"></span>
<input type="button" name="action" value="Delete"/>
</td>
</tr>
</form:form>
</table>
<br>
<table>
<th>Appointment Time</th>
<th>Create Time</th>
<th>Detail</th>

<c:forEach items="${appointmentList}" var="appointment">
<tr>
<td>${appointment.appointmentTime}</td>
<td>{customer.appointment.createTime}</td>
<td>{customer.appointment.detail}</td>
</tr>
</c:forEach>

</table> --%>
<iframe name="myframe" id="myframe" frameborder="1" >

</iframe>
</div>
<div class="n3">
	<p>Now is
	${serverTime}
	</p>
</div>

</body>


</html>