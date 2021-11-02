<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="functions" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>flexEx3</title>
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<style type="text/css">
  #wrapper{
     width: 96%;
     margin: 0 auto;
  }
  header{
    width: 100%;
    height: 120px;
    background: pink;
    border-bottom: 1 px solid black;
  }
  .header-text{
    font-size: 32px;
    color: red;
    text-align: center;
    line-height: 120px;
  }
  .content{
     float: left;
     width: 62.5%;
     height: 400px;
     padding: 1.5625%;
     background-color:#ffd800;     
  }
  .content img{
   max-width: 100%;
   height: auto;
  }
  .right-side{
   float: right;
   width: 31.25%;
   height: 400px;
   padding: 1.5625%;
   background-color: red;
   
  }
   footer{
    clear:both;
    width: 100%;
    height: 120px;
    background-color: blue;    
  }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
  $(function(){
     
  });
</script>  
</head>
<body>
<div id="wrapper">
     <header>
       <h1 class="header-text">가변그리드 레이아웃</h1>
     </header>
     <section  class="content">
       <h4>본문</h4>
       <img alt="" src="/Web/imgBook/01TCSC2005.jpg">
     </section>
     <aside class="right-side">
       <h4>사이드바</h4>
     </aside>
     <footer>
        <h4>푸터</h4>
     </footer>
   </div>
</body>
</html>