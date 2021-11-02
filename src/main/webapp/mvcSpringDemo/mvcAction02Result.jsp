<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>mvcAction02Result</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	const url = new URL(location.href);
	
	console.log(url);
	//console.log(decodeURI(url));
	//console.log(decodeURIComponent(url));
		
	const urlParams = url.searchParams;
	console.log(urlParams);
	
	console.log(urlParams.get('id'));
	console.log(urlParams.get('message'));
	console.log(urlParams.get('hi'));
})

</script>
</head>
<body bgcolor="${id}">
	<h2>This is mvcAction02Result.jsp</h2>
	<font color="white">
		ID is "${id}".
		<br /> 
		This color is "${message}".
	</font>
	<p/>
	<font color="black">
		id : ${id} <br/>
		message : ${message} <br/>
		hi : ${hi}
	</font>

</body>
</html>