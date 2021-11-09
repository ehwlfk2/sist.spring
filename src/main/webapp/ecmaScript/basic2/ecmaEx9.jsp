<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exmaEx9</title>
<script type="text/javascript">
	// lambda
	let get = value => value+10;
	
	let result = get(20);
	console.log(result);
	
	var Area = function(){};
	Area.version = 5.0;
	Area.triangle = function(base, height){
		return base * height / 2;
	}
	Area.diamond = function(width, height){
		return width * height / 2;
	} 
	console.log(Area, Area.version, Area.triangle(10,10), Area.diamond(10, 10));
	
	var a = Area();
	console.log(a.diamond(10,10)); //접근 불가. 위의 메소드는 정적인 메소드이다.
	
</script>
</head>
<body>

	<h3>ecmaEx9</h3>
	<a type="button" href="ecmaEx8.jsp">ecmaEx8</a>
	<a type="button" href="ecmaEx10.jsp">ecmaEx10</a>



</body>
</html>