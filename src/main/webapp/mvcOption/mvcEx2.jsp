<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvcEx2</title>

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	let headpath;
	
	$(function(){
		$("button").click(function(){
			alert("button click!!");
			
			switch (this.name) {
			case "h1":
				headpath = "headerEx1.do?keyWord=" + this.lang;
				break;
			case "h2":
				headpath = "headerEx2.do";
				break;
			case "h3":
				headpath = "nullPoint.do?no=" + this.lang;
				break;
			case "h4":
				headpath = "classCasting.do";
				break;
			case "h5":
				headpath = "numberFormat.do";
				break;
			case "h6":
				headpath = "arithmetic.do"
				break;
			case "h7":
				headpath = "arrayOutOfBounds.do"
				break;
			}
			
			alert(headpath);
			location.href = headpath;
		})
	});
</script>

</head>
<body>

	<button name="h1" lang="accept">accept</button>
	<button name="h2" lang="host">host</button>
	<button name="h3" lang="5">NullPoint 5</button>
	<button name="h3" lang="55">NullPoint 55</button>
	<button name="h4">ClassCasting</button>
	<button name="h5">NumberFormat</button>
	<button name="h6">Arithmetic</button>
	<button name="h7">ArrayOutOfBounds</button>
	
</body>
</html>