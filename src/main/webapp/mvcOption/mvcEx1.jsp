<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvcEx1</title>

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("input[type='button']").eq(0).click(function() {
			document.location.href = 'JavaClick.do';
		});
		$("input[type='button']").eq(1).click(function() {
			document.location.href = 'XmlClick.do';
		});
		$("input[type='button']").eq(2).click(function() {
			document.location.href = 'OracleClick.do';
		});
	});
</script>
</head>
<body>
	<input type="button" value="Click1">
	<input type="button" value="Click2">
	<input type="button" value="Click3">

	<form action="modelArgDemo.do">
		<br/> no : <input type="text" name="no"> 
		<br/> id : <input type="text" name="id">
		<br/> scrapno : <input type="text" name="scrapno"> 
		<br/> <input type="submit" name="Send">
	</form>

</body>


</html>