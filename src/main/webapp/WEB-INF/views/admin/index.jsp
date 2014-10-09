<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Admin Page</title>
</head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/screen.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/screen.css" />"
	type="text/css" media="screen, projection"></link>
<body class="pic">
<h1>

</h1>
<div id='cssmenu'>
<ul>
   <li  ><a href='/coe' ><span class="navSpan">Home</span></a></li>
   
   <li><a href="admin/manageUsers" target="myframe"><span class="navSpan">Manage Users</span></a></li>
  
   <li class='last'><a href="<c:url value="/j_spring_security_logout" />"><span>Log out</span></a></li>
  
</ul>
</div>
<div class="n1">
<p class="p">
welcome!<br>
<sec:authentication property="principal.username"/>
</p>
</div>

<div class="n2">

<iframe name="myframe" id="myframe" frameborder="1" >

</iframe>
</div>

</body>
</html>