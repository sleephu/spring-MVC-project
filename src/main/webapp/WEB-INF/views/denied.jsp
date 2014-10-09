<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>

<html>
<head>
<title>Access Denied</title>
<link href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<script src="/coe/resources/bootstrap-3.1.1-dist/js/bootstrap.min.js"></script>
<link
	href="/coe/resources/bootstrap-3.1.1-dist/css/bootstrap-theme.min.css"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/screen.css" />"
	type="text/css" media="screen, projection"></link>
<link rel="stylesheet"
	href="<c:url value="/resources/blueprint/print.css" />" type="text/css"
	media="print"></link>

<body class="pic">

	<div id='cssmenu'>
		<ul>
			<li ><a href='/coe'><span
					class="navSpan">Home</span></a></li>

		</ul>
	</div>


	<h1>Permission-Access Denied, Please login again!</h1>
	<!-- <div class="n1">
 <p>
<a class="a" href='/coe'>Back Home</a></p>

	</div> -->
</body>
</html> 