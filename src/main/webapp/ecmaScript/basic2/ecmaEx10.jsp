<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ecmaEx10</title>

<script type="text/javascript">
	<!-- Spread -->
	let one = [11, 12];
	let two = [21, 22, 23, 24, 25];
	
	console.log(one);
	console.log(two);
	
	// Array의 요소가 Array에 담긴 형태.
	let spreadObj = [51,...one, 52, ...two];
	console.log(spreadObj);
	
	// String 문자열의 연결.
	let spreadTwo = one + two;
	console.log(spreadTwo);

	// Array가  Array에 담긴 형태.
	let spreadThr = [one, two];
	console.log(spreadThr);
	
	<!-- Template -->
	// 연산자 (`) : 리터럴 템플릿
	console.log("1: ", `동해물과 백두산이 마르고 닳도록`);
	console.log("2: ", `라인1\n라인2`);
	console.log("3: ", `첫 번째 줄
			두번째 줄`);
	let a = 1, b = 2;
	console.log("4: ", `1+2 = ${(a+b)}이다`);
	
	let value = "AjaxStreamDataValue";
	let cnt = 50;
	console.log('Data=${value} cnt=${cnt}');
</script>

</head>
<body>

	<h3>ecmaEx10</h3>
	<a type="button" href="ecmaEx9.jsp">ecmaEx9</a>
	<a type="button" href="ecmaEx11.jsp">ecmaEx11</a>

</body>
</html>