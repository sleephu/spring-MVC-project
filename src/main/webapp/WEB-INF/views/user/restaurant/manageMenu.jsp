<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Manage Menu</title>
<link href="/coe/resources/bootstrap-3.2.0-dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<script src="/coe/resources/bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
<link
	href="/coe/resources/bootstrap-3.2.0-dist/css/bootstrap-theme.min.css"
	rel="stylesheet">

<c:if test="${empty menu}">
<c:if test="${empty restaurant}">
<c:if test="${empty foodList}">
<c:if test="${empty exsitedMenu}">
	<tr>
		<td>Edit Your profile first please</td>
	</tr>
</c:if>
</c:if>
</c:if>
</c:if>


	<c:if test="${!empty menu}">
	<c:if test="${empty exsitedMenu}">
		
	<table>
	<form:form class="inline" commandName="menu" action="manageMenu/updateMenu"
			method="post">
			<tr>
				<form:label path="menuName">Menu Name:</form:label>
				<form:input path="menuName" />
			</tr><br>
			
				<tr>
					<td colspan="2"><input type="reset" value=cancel> <input
						type="submit" value="Update"></td>
				</tr>
</form:form>
			</table>
	</c:if>
	</c:if>



<c:if test="${!empty food}">
	<table>
	
		<form:form class="inline" commandName="food" action="create"
			method="post">

			<tr>
				<form:label path="foodName">Dish Name:</form:label>
				<form:input path="foodName" />
			</tr><br>

			<tr>
				<form:label path="price">Price</form:label>
				<form:input path="price" />
			</tr><br>
			<tr>
				<td>
				<td colspan="2"><input type="reset" value="cancel" /> <input
					type="submit" value="save" /></td>
				</td>
			</tr>
		</form:form>
	</table>

</c:if>





	<c:if test="${!empty exsitedMenu}">
	<table>

		<th>Menu Name</th>
		<tr>
			<td>${exsitedMenu.menuName}</td>

			<td><a
				href="manageMenu/${exsitedMenu.menuId}/addFood"
				id="${exsitedMenu.menuId}" name="menuId"> 
					Add Food to Menu
			</a></td>
		</tr>
<c:if test="${!empty exsitedfood}">
		<th>Food Name</th>
		<th>Price</th>
		<c:forEach items="${menuFood}" var="exsitedfood">
		<tr>
		<td>${exsitedfood.foodName}</td>
			<td>${exsitedfood.price }</td>
		</tr>
		</c:forEach>
		</c:if>
		</table>
		
	</c:if>


</html>