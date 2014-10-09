<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@ page session="false" %> --%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

	<title>Register-Join us</title>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/blueprint/screen.css" />" type="text/css" media="screen, projection"></link>
<link rel="stylesheet" href="<c:url value="/resources/blueprint/print.css" />" type="text/css" media="print"></link>
</head>

<body class="pic">
<h1>
	Save Your Time For A Delicious Meal 
</h1>


<div id='cssmenu'>
<ul>
   <li  ><a href='/coe' class='active' ><span class="navSpan">Home</span></a></li>
    <li><a href="makeAppointment" ><span class="navSpan">Make Appointment</span></a></li>
   <li><a href="manageAppointment" target="myframe"><span class="navSpan">Manage Appointment</span></a></li>
   <li><a href="viewRestaurant" ><span class="navSpan">View Restaurants</span></a></li>
    <li><a href="editProfile" target="myframe"><span class="navSpan">Edit Profile</span></a></li>
   <li class='last' ><a href="<c:url value="/j_spring_security_logout" />" ><span>Log out</span></a></li>
  
</ul>
</div>
<div class="n1">

welcome!
<sec:authentication property="principal.username"/>
<%-- <c:redirect url="editProfile" /> --%>
</div>

<div class="n2">

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