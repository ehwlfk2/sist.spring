<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC >
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
<link href="css/clean-blog.css" rel="stylesheet">
<link href="css/board.css" rel="stylesheet">
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
	$(function(){
		console.log("${job}");	
		no = "${boardInfo.no}";
		
		$("a.btn.btn-default.btn-xs").click(function(){
			if(this.lang == "") return false;
			
			let param = "?no=" + no + "&job=" + this.lang;
			let uri;
			console.log(param);
			
			switch (this.lang) {
			case 'list':
				uri = "boardList.do"; break;
			case 'del':
				if("${boardInfo.reply}" != "0"){
					alert("댓글이 달려 삭제할 수 없습니다.");
					return false;
				}
			case 'edit':
				uri = "passwordConfirm.jsp"; break;
			case 'reply':
				uri = "write.jsp"; break;
			case 'scrap':
				console.log("this is scrap click event."); break;
			}
		
			alert(uri+ param);
			location.href = uri + param;
		}); //click
	});

</script>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>


	<!-- Page Header -->
	<!-- Set your background image for this header on the line below. -->
	<header class="intro-header"
		style="background-image: url('img/about-bg.jpg'); height: 200px">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
					<div class="site-heading"
						style="margin-top: 10px; padding-top: 35px; padding-bottom: 35px">
						<h2>SAMPLE</h2>
						<span class="subheading">BULLETIN BOARD</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	<div class="board-field">
		<div class="list-group">
			<div class="list-group-item board-title">
				<div class="board-title">
					<span class="board-category">[Thanks.com]</span>
					<a href="#">${boardInfo.title }</a> 
				</div>
				<div class="board-meta"
					style="font-weight: 400; font-size: 1.2rem; color: #404040">
					<p>
						<i class="glyphicon glyphicon-user"></i> ${boardInfo.author }
						<i class="glyphicon glyphicon-comment"></i> ${boardInfo.ref }
						<i class="glyphicon glyphicon-ok"></i> ${boardInfo.hit }
						<i class="glyphicon glyphicon-time"></i> ${boardInfo.regdate }
					    <i class="glyphicon glyphicon-thumbs-up"></i> 0
						<i class="glyphicon glyphicon-thumbs-down"></i> 0
					</p>
				</div>
				<div class="clear"></div>
			</div>
			<div class="list-group-item">
				<p style="text-align: center; margin-top: 30px">
					<span>
						<c:if test="${boardInfo.fileName  ne null}">
							<img src="${pageContext.request.contextPath}/resources/upload/${boardInfo.fileName }" alt="FILE" height="500px">
							<br/>
							${pageContext.request.contextPath}/resources/upload/${boardInfo.fileName }
						</c:if>
					</span>
					<br/>
					<span class="board-contents">
				 		${boardInfo.contents }
					</span>
				</p>
				<p style="text-align: center; margin-top: 30px">
					<button class="btn btn-success">
						<i class="glyphicon glyphicon-thumbs-up"></i>&nbsp;공감
					</button>
					<button class="btn btn-warning">
						<i class="glyphicon glyphicon-thumbs-down"></i>&nbsp;비공감
					</button>
				</p>
			</div>
			<div class="bottom" style="margin: 10px;margin-top: 20px; text-align: right">
				<a href="#" lang="list" class="btn btn-default btn-xs pull-left">목록으로</a> 
				<a href="#" lang="edit" class="btn btn-default btn-xs" onclick="alert('수정페이지로 넘어갑니다!')">수정</a>
				<a href="#" lang="del" target="_action_frame_bbs"  class="btn btn-default btn-xs" >삭제</a> 
				<a href="#" lang="reply" class="btn btn-default btn-xs">답글</a>
				<a href="#" lang="scrap" class="btn btn-default btn-xs"><span id="scrap">스크랩</span></a> 
			</div>
			<div class="clear"></div>	
		</div>
	</div>
	<!-- Footer -->
	<footer>
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
	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/clean-blog.min.js"></script>
	
	<!-- Custom Script -->
	<script type="text/javascript">
		function editClick(){
			//alert("edit click()");
			$("form").submit();
		}
	</script>
	${boardInfo}
</body>

</html>
