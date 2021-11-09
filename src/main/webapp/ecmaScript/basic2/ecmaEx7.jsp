<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ecmaEx7</title>
<script type="text/javascript">
	/* 
	Closuer(클로저) 함수 
	내부에서 생성한 데이터와 그 유휴범위로 인해 발생하는 특수한 현상.
	 */
	var x = 50;
	function outer() {
		var x = 1;
		console.log("outer");
		return (function inner() {
			console.log("inner", x);
		});
		//inner();
	}
	console.log("outer() Run!");
	outer();
	console.log("outer()() Run!");
	outer()();
	console.log("----------");

	function a() {
		var x = 1;
		console.log("a");
		return function b() {
			console.log("b inner", x);
		}
	}
	console.log("a() Run!");
	a();
	console.log("a()() Run!");
	a()();
	console.log("----------");

	function c() {
		var x = 1;
		return {
			get : function() {
				console.log("getter", x);
				return x;
			},
			set : function(v) {
				console.log("setter", x);
				x = v;
			}
		}
	}
	console.log(c());
	var fc = c();
	fc.x = 10;
	console.log(fc.x);
	fc.get();
	fc.set(100);
	fc.get();
	console.log("----------");

	function outerFunc(arg1, arg2) {
		var local = 8;
		function innerFunc(innerArg) {
			console.log((arg1 + arg2) / (innerArg + local));
		}
		return innerFunc;
	}
	console.log(outerFunc(5, 9)(3));
	
</script>
</head>
<body>

	<h3>ecmaEx7</h3>
	<a type="button" href="ecmaEx8.jsp">ecmaEx8</a>
</body>
</html>