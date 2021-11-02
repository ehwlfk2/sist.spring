<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvcEx1</title>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	let button;
	let request;

	$(function() {
		button = $("button");

		button.click(function() {
			switch (this.id) {
			case "action1":
				request = "aopActionDemo1.do";
				break;
			case "action2":
				request = "aopActionDemo2.do";
				break;
			}

			alert(request);
			location.href = request;
		});
	});
</script>

</head>
<body>

	<h4>mvcEx1</h4>
	<br />
	<button id="action1">Action1 - file</button>
	<br />
	<button id="action2">Action2 - xml</button>

</body>
</html>