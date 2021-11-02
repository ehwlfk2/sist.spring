<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvcEx3</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("button").click(function(){
			let path = null;
			switch (this.id) {
			case "c1":
				path = "clickAction.do";
			case "c2":
				path = "mouseAction.do";
			case "c3":
				path = "/springWeb/clickAction.do";
			}
			document.location.href = path;
		});
	});
</script>

</head>
<body>

	<button id=c1> BUTTON </button>
	<button id=c2> BUTTON </button>
	<button id=c3> BUTTON </button>
	
</body>
</html>