<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>insert title name</title>
<style type="text/css">
button {
	margin: 10px;
}
</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("button").click(function() {
			switch ($(this).text()) {
			case "STUDENTLIST":
			case "EMPLIST":
			case "LOGIN":
				document.location.href = $(this).text() + '.do';
			}
		}); //	button.click
	})
</script>

</head>
<body>
	<button>EMPLIST</button>
	<br />
	<button>STUDENTLIST</button>
	<br />
	<button>LOGIN</button>
	<br />
</body>
</html>