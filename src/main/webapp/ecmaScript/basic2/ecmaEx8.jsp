<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ecmaEx8</title>
<script type="text/javascript">
	console.log(this);
	function a(){
		// 왜 여기서 this를 찍어도 window가 출력되는 거지?
		console.log("a function", this);
	}
	a();
	
	function b(){
		function c(){
			console.log("c function", this);
		}
		c();
	}
	b();
	
	var d = {
			e : function (){
				function f(){
					console.log("f function", this);
				}
				f();
			}
	}
	d.e();
	
</script>
</head>
<body>

	<h3>ecmaEx8</h3>
	<a type="button" href="ecmaEx7.jsp">ecmaEx7</a>
	<a type="button" href="ecmaEx9.jsp">ecmaEx9</a>

</body>
</html>