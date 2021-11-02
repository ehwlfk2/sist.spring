<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="functions" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- New Spring taglib -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>formPro</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<h2>Validate</h2>
	<spring:hasBindErrors name="command"/>
	<!-- path : hasBindError의 이름과 맞아야한다. -->
	<form:errors path="command"></form:errors>
	
	<div class="container">
		<h2>ValidateAction</h2>
		<form action="formValidate.do" method="POST">
			<div class="form-group">
				<label for="id">ID:</label> 
				<input type="text" class="form-control" id="id" placeholder="ID email" name="id" value="${test.id}">
				<font color="red">
				<!-- test는 action을 처리하는 controller의 매개변수에 연결한 
					@ModelAttribute("test") 과 같아야한다. -->
					<form:errors path="test.id"></form:errors>
				</font>
			</div>
			<div class="form-group">
				<label for="name">Name:</label> 
				<input type="text" class="form-control" id="name" placeholder="Enter email" name="name" value="${test.name}">
				<font color="red"><form:errors path="test.name"></form:errors></font>
			</div>
			<div class="form-group">
				<label for="addr">Addr:</label> 
				<input type="text" class="form-control" id="addr" placeholder="Enter email" name="addr" value="${test.addr}">
				<font color="red"><form:errors path="test.addr"></form:errors></font>
			</div>
			<div class="form-group">
				<label for="pwd">Password:</label> 
				<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" value="${test.pwd}">
				<font color="red"><form:errors path="test.pwd"></form:errors></font>
			</div>

			<button type="submit" class="btn btn-default">Submit</button>
		</form>
		<br/>
		<a href="start.do" class="btn btn-default">userForm 으로 이동</a>
	</div>

</body>
</html>