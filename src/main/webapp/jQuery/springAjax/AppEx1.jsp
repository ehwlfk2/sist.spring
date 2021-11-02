<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AppEx1</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function ajaxAction(url, type, dataType) {
		$.ajax({
			url : url,
			type : type,
			dataType : dataType,
			success : function(v) {
				console.log(v);
			}
		});
	}

	$(function() {
		$("button").click(function() {
			switch (this.id) {
			case "stud":
				console.log("click#stud");
				location.href = 'studAjax.do';
				break;
			case "map":
				console.log("click#map");
				ajaxAction('mapAjax.do', 'POST', 'json');
				break;
			case "object":
				console.log("click#object");
				ajaxAction('objectAjax.do', 'POST', 'json');
				break;

			}
		});
	})
</script>
</head>
<body>

	<h2>AppEx1</h2>
	<button id="stud">Student</button>
	<button id="map">MapJson</button>
	<button id="object">ObjectValue</button>

</body>
</html>