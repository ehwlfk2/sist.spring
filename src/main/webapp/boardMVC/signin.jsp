<%@ page language="java" contentType="text/html; charset=EUC-KR"
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

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	let fail = "<%=request.getParameter("cmd")%>";
	if (fail === "fail"){
		alert("Id Or Pass Check!!");
	}

	let id;
	let password;
	let check;
	
	$(function() {
		id = $("input#id");
		password = $("input#password");
		check = $("span#check");
		
		$("a#signin").click(function() {
			alert($("input#id").val());
			if ($("input#id").val().length == 0 || $("input#password").val().length == 0) {
				initIdPassword("Id Or Pass Empty!");
				return false;
			}
			//$("form").submit();
			$.ajax({
				url : 'ajaxLogin.do',
				type : 'POST',
				dataType : 'text',
				data : {
					"id" : id.val(),
					"password" : password.val()
				},
				success : function(value) {
					console.log(value);
					if(value === "fail"){
						initIdPassword("plz check your Id or Pass!!");
					}else{
						document.location.href="replyView.do";
					}
				},
				error : function(request, status, error) {
					console.log("request.status : " + request.status);
					console.log("request.responseText : "
							+ request.responseText);
					console.log("status : " + status);
					console.log("error : " + error);
				}
			});	// ajax
		});	// a#signin.click
	});	// function()
	
	function initIdPassword(msg) {
		check[0].style.color = "red";
		check.text(msg);
		id.val('');
		password.val('');
	}
	
</script>

</head>
<body style="background-image: url(img/back.jpg)">
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container" style="margin-top: 120px">
		<div class="row">
			<div class="main">
				<h3>SAMPLE SIGN IN</h3>

				<!-- <form name="loginFrm" method="post" action="boardLogin.do">  -->
				<form name="loginFrm" method="post">
					<div class="form-group">
						<input type="email" placeholder="ID" class="form-control" id="id"
							name="id" />
					</div>
					<div class="form-group">
						<!--<a class="pull-right" href="#">Esqueci a senha</a>-->
						<input type="password" placeholder="PASSWORD" class="form-control"
							id="password" name="password" />
						
					</div>
					<div class="row">
						<!-- check 가운데 정렬... 개빡치네... @.,@ ㅋㅋㅋ -->
					 	<div style="display:flex; justify-content:center;">
					 		<span id="check" style="display: table-cell;"></span>
					 	</div>
						<div class="col-xs-12 col-sm-12 col-md-12">
							<a href="#" id="signin" class="btn btn-sm btn-danger btn-block">SIGN IN</a>
						</div>
					</div>
					<div class="login-or">
						<hr class="hr-or">
						<span class="span-or">or</span>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12">
							<a href="signup.jsp" class="btn btn-sm btn-info btn-block">SIGN UP</a>
						</div>
					</div>
					<h6 style="font-weight: 400; font-size: 0.85714rem; color: gray"
						align="center">
						비밀번호가 기억나지 않으세요? <a href="#"><i>비밀번호재설정</i></a>
					</h6>
				</form>
			</div>
		</div>
	</div>
	<!-- Footer -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>

<!-- 
placeholder : 
html5 에서부터 사용할 수 있는 attribute (hint)
-->