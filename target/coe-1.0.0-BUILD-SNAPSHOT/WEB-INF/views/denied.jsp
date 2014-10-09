<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>

<html>
<head>
<title>Access Denied</title>
</head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/screen.css" />"
	type="text/css" media="screen, projection"></link>
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/print.css" />" type="text/css"
	media="print"></link>

<body class="pic">

	<%-- <div id='cssmenu'>
		<ul>
			<li class='active'><a href='/coe'><span
					class="navSpan">Home</span></a></li>
			<li><a href='news' target="myframe"><span class="navSpan">News</span></a></li>
			<li><a href='about' target="myframe"><span class="navSpan">About</span></a></li>
			<li><a href='registerC' ><span class="navSpan">Customer Sign
						Up</span></a></li>
			<c:url var="register" value="user/register" />
			<li class='last' id="nav"><a href='registerE' ><span>Enterprise Sign
						Up</span></a> <ul>
  <c:url var="cRegister" value="user/customer/register" />
   <li class='last' id="cRegister"><a id="register"  href="{cRegister}" ><span>Customer Sign Up</span></a>
    <c:url var="eRegister" value="user/restaurant/register" />
    <li class='last' id="eRegister"><a id="register" href="{eRegister}" ><span>Enterprise Sign Up</span></a>
  </ul></li>

		</ul>

	</div> --%>


	<h1>Permission-Access Denied, Please login again!</h1>
	<div class="n1">
 <p>
<a href='/coe'>Back Home</a></p>

	</div>
</body>
</html> 