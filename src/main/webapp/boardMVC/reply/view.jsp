<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="cssview.css">
</head>
<body>
<div class="thumb_comm" >
	<ul class="list_thumb">
  <%
     for(int i=0;i<10;i++){
  %>
		<li>
			<a href="#none" class="link_thumb"><img src="../image/<%=(i+1)%>.jpg" class="thumb_img" width="300" height="300" alt=""   /></a>
			<div class="cont_info">
				<strong class="tit_subject"><a href="#none" class="link_tit">제목형</a></strong>
				<span class="txt_desc"><a href="#none" class="link_txt">내용이 들어갑니다.</a></span>
				<span class="txt_time">2013.03.01 18:00</span>
			</div>
		</li>
   <%
     }
   %>				
	</ul>
</div>

</body>
</html>