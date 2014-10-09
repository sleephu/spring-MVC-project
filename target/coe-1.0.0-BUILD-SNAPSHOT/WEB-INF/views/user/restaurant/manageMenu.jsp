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
   <li><a href='#' class='active'><span class="navSpan">Manage Menu</span></a></li>
   <li><a href='#' ><span class="navSpan">Edit Appointment Time</span></a></li>
    <li><a href='#'><span class="navSpan">Edit Profile</span></a></li>
        <li><a href='#' ><span class="navSpan">View Customer</span></a></li>
   <li class='last' ><a href='#'><span>Log Out</span></a></li>
  
  
</ul>
</div>
<div class="n1">

welcome to join us!
</div> --%>

<div class="n2">
<form action="updateMenu" method="post">
<table>
<th>Manage menu</th>
<tr>
<td> menu Name</td>
<td> 
<%-- <form:input path="restaurantName"/> --%>
<input type="text" name="menuName"><br>
</td>
</tr>


<tr>
<td> food Name</td>
<td>
<%-- <form:input path="telephoneNo"/> --%>
<input type="text" name="foodName">
</td>
</tr>

<tr>
<td> Food Price</td>
<td>
<%-- <form:input path="details"/> --%>
<input type="text" name="price">
 </td>
</tr>


<tr>
<td colspan="2"> 
<input type="reset" value=cancel>
<input type="submit"  value="Add Food To Menu">
<!-- <input type="submit" name="action" value="delete"> -->
<!-- <input type="submit" name="action" value="Edit Address"> -->
</td>
</tr>
</table>
</form>

<table>
<th>Menu Name</th>
<th>Food Name</th>
<th>Food Price</th>

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
        out.println("</tr>");
  /*    }  */
 
 %>
</table>

<%-- <div class="container">
		<h1>
			Menu Manager
		</h1>
		<div class="span-12 last">	
			<form:form modelAttribute="menu" action="manageMenu" method="post">
			    <table>
				    <tr>
				        <td><form:label path="menuName" cssErrorClass="error">Title</form:label></td>
				        <td><form:input path="menuName" /> <form:errors path="menuName" /></td>
				    </tr>
				        <td colspan="2">
				            <input type="submit" value="Create Menu"/>
				        </td>
				    </tr>
				</table>
			</form:form>
			 
			<h3>Menu</h3>
			<c:if test="${!empty MenuList}">
				<table class="data">
					<tr>
					
			    		<th>Menu Name</th>
			    		
					</tr>
					<c:forEach items="${menuList}" var="menu">
			    		<tr>
			        		<td>${menu.menuName}</td>
			        		<td><a href="manageFood" id="${menuId}" >Add Food To Menu</a></td>
			    		</tr>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
	
<form:form class="inline" id="${menu.id}" action="manageFood" method="post">
<form:label path="foodName">Dish Name:</form:label>
	<form:input path="foodName"/><br />
	<form:label path="price">Price:</form:label>
	<form:input path="price"/><br />

<input type="button" name="action" value="Add"/>
<span class="navSpan"></span>
<input type="button" name="action" value="Edit"/>
<span class="navSpan"></span>
<input type="button" name="action" value="Delete"/>
</form:form>
<br>
<table id="foodTable">
<th>Dish Name</th>
<th>Food Price</th>

<c:forEach items="${foodList}" var="food">
<tr>
<td>${food.foodName}</td>
<td>${food.price}</td>
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