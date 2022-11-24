<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Show Database Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>	
.button {
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
.button1 {background-color: #5F9EA0;}	
</style>
</head>
<body>
	<form method="post" action="./index.jsp"><button class="button button1">Home</button></form>
	<br><br><br>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #778899">
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">list</a></li>
			</ul>
			</nav>
	</header>
	<br>

	<div class="row">
	<div class="container">
			<h3 class="text-center">List of Data</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New User</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>City</th>
						<th>Status</th>
						<th>operation</th>
					</tr>
				</thead>
				<tbody>
				
					<c:forEach var="model" items="${listmodel}">

						<tr>
							<td><c:out value="${model.id}" /></td>
							<td><c:out value="${model.name}" /></td>
							<td><c:out value="${model.city}" /></td>
							<td><a href="view?id=<c:out value='${model.id}' />">view</a>
							<td><a href="edit?id=<c:out value='${model.id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${model.id}' />">Delete</a></td>
								
						</tr>
					</c:forEach>
		
				</tbody>

			</table>
		</div>
	</div>
	<input type="submit" value="Download PDF" name="download" onclick="window.print()" /> 
</body>
</html>