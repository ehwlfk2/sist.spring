<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>flexEx7</title>
<!-- 반응형 웹의 기본. -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="style-result.css" rel="stylesheet" type="text/css">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function(){
		
	});
</script>
</head>
<body>
    <p><a href="flexEx8.jsp">flex8번으로 이동</a></p>
    <p><a href="flexEx6.jsp">flex6번으로 이동</a></p>

    <div id="container">
       <div class="card">
          <img alt="" src="../resources/upload/diva.png">
          <div class="words">
            <h2>Java는 객체지향언어</h2>
            <h3>김태라</h3>
          </div> 
       </div>
       
       <div class="card">
          <img alt="" src="../resources/upload/봄봄 니트 미니원피스.gif">
          <div class="words">
            <h2>Oracle은 DBMS</h2>
            <h3>도경진</h3>
          </div> 
       </div>
       
       <div class="card">
          <img alt="" src="../resources/img/rainbow/Rainbow07.jpg">
          <div class="words">
            <h2>Spring은 봄이다</h2>
            <h3>송민제</h3>
          </div> 
       </div>
    </div> 
    
</body>

</html>