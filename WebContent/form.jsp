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
<nav class="navbar navbar-expand-md navbar-dark" style="background-color: #778899">
<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Context</a></li>
			</ul>
		</nav>

</header>
<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${model != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${model == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
				<h2>
						<c:if test="${model != null}">
            			Edit 
            		</c:if>
						<c:if test="${model == null}">
            			Add New 
            		</c:if>
					</h2>
				</caption>
								<c:if test="${model != null}">
					<input type="hidden" name="id" value="<c:out value='${model.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out value='${model.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Email</label> <input type="text"
						value="<c:out value='${model.email}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label>Address</label> <input type="text"
						value="<c:out value='${model.address}' />" class="form-control"
						name="address">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Phone</label> <input type="text"
						value="<c:out value='${model.phone}' />" class="form-control"
						name="phone">
				</fieldset>
				
				<fieldset class="form-group">
					<label>City</label> <input type="text"
						value="<c:out value='${model.city}' />" class="form-control"
						name="city">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Country</label> <input type="text"
						value="<c:out value='${model.country}' />" class="form-control"
						name="country">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Education</label> <input type="text"
						value="<c:out value='${model.education}' />" class="form-control"
						name="education">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Photo</label> <input type="file"
						value="<c:out value='${model.photo}' />" class="form-control"
						name="photo">
					<img src="getimage?id=<c:out value='${model.id}' />"width="125" height ="125"  border="1">
				</fieldset>
				
				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
	
	<input type="submit" value="Download PDF" name="download" onclick="window.print()" /> 
</body>
</html>