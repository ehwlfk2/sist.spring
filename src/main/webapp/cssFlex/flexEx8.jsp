<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>flexEx8</title>
<!-- 반응형 웹의 기본. -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
body {
	background-color: red;
}
/* landscape is 가로 > 세로 */
@media screen and (orientation: landscape) {
	body {
		background-color: blue;
	}
}
/* portrait is 가로 <= 세로 */
@media screen and (orientation: portrait) {
	body {
		background-color: pink;
	}
}
</style>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {

	});
</script>
</head>
<body>
	<p><a href="flexEx9.jsp">flex9번으로 이동</a></p>
    <p><a href="flexEx7.jsp">flex7번으로 이동</a></p>
	<h1>Media Query</h1>

</body>
</html>