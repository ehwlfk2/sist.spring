<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Start Simple Web</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<!-- <link href="css/login.css" rel="stylesheet"> -->
<link href="css/clean-blog.css" rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href='http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	let id, name, password;
	
    $(function(){
    	id = $("input#id");
    	name = $("input#name");
    	password = $("input#password");
    	
    	if(id != null) console.log("\'id\' link success");
    	if(name != null) console.log("\'name\' link success");
    	if(password != null) console.log("\'password\' link success");
    })
    
    function signUpCheck(){
    	let pass = $("input[name=pass]");
    	console.log(pass[0].value == pass[1].value);
    	
    	if(pass[0].value == pass[1].value){
    		password.value = pass[0].value;
    		return true;
    	}
    	
    	console.log(password.val());
    	return false;
    }
    </script>
</head>
<body style="background-image: url(img/back.jpg)">

	<jsp:include page="header.jsp"></jsp:include>

	<div class="container" style="margin-top: 120px">
		<div class="row">
			<div class="main">
				<h3>SAMPLE SIGN UP</h3>

				<form role="form">
					<div class="form-group">
						<input type="text" placeholder="아이디 또는 이메일" class="form-control"
							id="id" name="id" />

					</div>
					<div class="form-group">
						<input type="text" placeholder="이름(별명)" class="form-control"
							id="name" name="name"/>

					</div>
					<div class="form-group">
						<input type="text" placeholder="비밀번호" class="form-control"
							id="password1" name="pass" />
						<input type="hidden" id="password" name="password"> 
					</div>
					<div class="form-group">
						<!--<a class="pull-right" href="#">Esqueci a senha</a>-->
						<input type="password" placeholder="비밀번호 확인" class="form-control"
							id="password2" name="pass" />
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12">
							<a href="#" class="btn btn-sm btn-info btn-block" onclick="signUpCheck()">SIGN UP</a>
						</div>
					</div>
					<h6 style="font-weight: 400; font-size: 0.85714rem; color: gray"
						align="center">
						회원가입을 클릭함으로써 <br> <a href="#"><i>사용약관</i></a> 및 <a href="#"><i>개인정보취급방침</i></a>
						에 동의합니다.
					</h6>
				</form>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<!-- 	<footer>
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<ul class="list-inline text-center">
					<li><a href="#"> <span class="fa-stack fa-lg"> <i
								class="fa fa-circle fa-stack-2x"></i> <i
								class="fa fa-envelope-o fa-stack-1x fa-inverse"></i>
						</span>
					</a></li>
					<li><a href="#"> <span class="fa-stack fa-lg"> <i
								class="fa fa-circle fa-stack-2x"></i> <i
								class="fa fa-home fa-stack-1x fa-inverse"></i>
						</span>
					</a></li>
					<li><a href="#"> <span class="fa-stack fa-lg"> <i
								class="fa fa-circle fa-stack-2x"></i> <i
								class="fa fa-github fa-stack-1x fa-inverse"></i>
						</span>
					</a></li>
				</ul>
				<p class="copyright text-muted">Copyright &copy;2016 SIST. All
					rights reserved | code by milib</p>
			</div>
		</div>
	</div>
	</footer>
 -->
</body>

</html>