<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<title>관리자</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=7" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="copyright" content="Copyright 2009 @ high1 all rights reserved" />

<link href="../css/contents.css" rel="stylesheet" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	function loginCheck(){
		var obj=document.login;
	  	if(!obj.id.value||!obj.password.value){
			alert('Id Or PassCheck');
		  	obj.id.value='';
		  	obj.password.value='';
		  	obj.id.focus();
		  	return false;
	  	}
	  	obj.submit();
  	}
  	$(function(){
  		alert('${id}'=='');
  		$("input#ck").prop( 'checked', '${id}'=='' ? false : true );
  	});
</script>
</head>

<body>
<form name="login" method="post" action="adminLogin.do">
 <div id="loginWrapper">
  <div class="loginForm">
   <fieldset>
    <legend>관리자 시스템 로그인</legend>
    <dl>
     <dt><img src="../img/common/th_id.gif" alt="아이디" /></dt>
     <dd><input type="text" name="id" class="text" id="user_id" value="${id}"/></dd>

     <dt><img src="../img/common/th_pw.gif" alt="비밀번호" /></dt>
     <dd><input type="password" name="password" class="text" id="user_passwd" /></dd>
    </dl>
    <div class="btn">
     <img id="btnSubmit" src="../img/button/btn_login.gif" alt="LOGIN" title="LOGIN"  onclick="loginCheck()" />
    </div>
    
    <div class="saveId"><input type="checkbox" id="ck" name="ck" /> 
     <img src="../img/common/save_id.gif" alt="아이디 저장" />
    </div>
   </fieldset>
  </div>
 </div>
</form>
</body>
</html>





