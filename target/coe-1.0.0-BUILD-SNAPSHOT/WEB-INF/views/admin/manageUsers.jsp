<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Register-Join us</title>
</head>
<%-- <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/screen.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/screen.css" />"
	type="text/css" media="screen, projection"></link>
<body class="pic">
<h1>
	Promote Your Delicious meal!
</h1>
<div id='cssmenu'>
<ul>
    <li  ><a href='/coe' ><span class="navSpan">Home</span></a></li>
   <li><a href='#' class='active'><span class="navSpan">Manage Customer</span></a></li>
   <li class='last' ><a href="<c:url value="/j_spring_security_logout" />"><span>Log out</span></a></li>
</ul>
</div>
<div class="n1">

welcome to join us!
</div> --%>

<div class="n2">
<%--  <form:form class="inline" action="manageUsers/delete/${user.userId}" method="delete">  --%>
<table>
		<th>User Name</th>
		<th>Password </th>
		<th>Role</th>
<c:if test="${empty userList} ">
<td>No user!</td>
</c:if>
		<c:if test="${! empty userList}">
			<c:forEach items="${userList}" var="user">

				<tr>
					<td>${user.userName}</td>
					<td>${user.password}</td>
					<td>${user.role.role}</td>
					<%-- <td>
					<a href="manageUsers/delete/${user.userId}"
					 id="${customer.customerId}"
					name="userId">
				<!-- 		onclick="deleteCustomer(event)" -->
						Delete</a></td> --%>
					</tr>
					</c:forEach>
					</c:if>
					</table>
				<%-- 	</form:form>
 --%>
</div>

</body>
</html>