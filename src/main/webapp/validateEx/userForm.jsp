<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- spring taglib -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>UserForm</title>
</head>
<body>

	<form:form action="saveUser.do" method="POST" modelAttribute="user">
		<table cellpadding="0" cellspacing="0" width="80%" border="1">
			<tr>
				<th>NAME</th>
				<td>
					<form:input path="name"/>
					<font color="red" size="4"><form:errors path="name"/></font>
				</td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td>
					<form:input path="email"/>
					<font color="red" size="4"><form:errors path="email"/></font>
				</td>
			</tr>
			<tr>
				<th>GENDER</th>
				<td>
					<form:radiobutton path="gender" value="Male" label="Male"/>
					<form:radiobutton path="gender" value="Female" label="Female"/>
					<font color="red" size="4"><form:errors path="item"/></font>
				</td>
			</tr>
			<tr>
				<th>ITEM</th>
				<td>
					<form:select path="item">
						<form:option value="USJava">Use Java</form:option>
						<form:option value="USOracle">Use Oracle</form:option>
						<form:option value="USSpring">Use Spring</form:option>
						<form:option value="USPyhon">Use Pyhon</form:option>
						<form:option value="USC++">Use C++</form:option>				
					</form:select>
					<font color="red" size="4">
             			<form:errors path="item"/>
					</font>
				</td>
			</tr>
			
			<tr>
				<th>Send</th>
				<td>
					<form:button type="submit">Send</form:button>
				</td>
			</tr>
		</table>

	</form:form>

</body>
</html>