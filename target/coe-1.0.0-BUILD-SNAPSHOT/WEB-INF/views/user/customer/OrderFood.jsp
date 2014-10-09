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
	<title>Register-Join us</title>
</head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection"></link>
<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print"></link>
<body class="pic">
<h1>
	Save Your Time for Delicious meal!
</h1>
<div id='cssmenu'>
<ul>
    <li  ><a href='home.jsp' ><span class="navSpan">Home</span></a></li>
   <li><a href='#' class='active'><span class="navSpan">Manage Menu</span></a></li>
   <li><a href='#' ><span class="navSpan">Edit Appointment Time</span></a></li>
    <li><a href='#'><span class="navSpan">Edit Profile</span></a></li>
        <li><a href='#' ><span class="navSpan">View Customer</span></a></li>
   <li class='last' ><a href='#'><span>Log Out</span></a></li>
  
  
</ul>
</div>
<div class="n1">

</div>

<div class="n2">
<form:form class="inline" action="user/customer/viewMenuFood" method="get">
<table>
<th>Dish Name</th>
<th>Dish Price</th>
<c:forEach id="{restaurant.restaurantId}" items="${foodList}" var="food">
<tr>
<td>${food.foodName}</td>
<td>${food.price}</td>
<td>
<input type="submit" name="manageFood" value="Add"/>
</td>

</tr>
</c:forEach>
</table>
</form:form>

<table>
<form:form class="inline" id="${food.id}" action="user/customer/viewOrderedFood" method="get">
<th>Dish Name</th>
<th>Food Price</th>

<c:forEach items="${foodList}" var="food">
<tr>
<td>${food.foodName}</td>
<td>${food.price}</td>
</tr>
</c:forEach>
<input type="button" name="action" value="Add"/>
<span class="navSpan"></span>
<input type="button" name="action" value="Delete"/>
</form:form>
</table>
<br>

<iframe name="myframe" id="myframe" frameborder="1" >


</iframe>
</div>
<div class="n3">
	<p>Now is
	${serverTime}
	</p>
</div>
<script type="text/javascript">
$("input[type=radio]").click(function(){
	 if(document.getElementById('customer').checked) {
	        {}
	    }else if(document.getElementById('restaurant').checked) {
	        
	    } 
	   
	});
</script>
</body>
</html>