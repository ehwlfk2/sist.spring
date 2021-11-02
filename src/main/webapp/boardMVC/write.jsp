<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC >
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>write</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
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
    
<link href="css/write.css" rel="stylesheet">
<style type="text/css">

</style>
</head>
<body>
<c:set var="job" value="${param.job}"></c:set> <!-- 답글에서 왔으면 job = reply -->

<c:choose>
	<c:when test="${job eq '' or job==null}">
		<c:set var="uri" value="boardInsert.do"></c:set>
	</c:when>
	<c:otherwise>
		<c:set var="uri" value="boardInsert.do?no=${param.no}"></c:set>
	</c:otherwise>
</c:choose>

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
	<!-- enctype="multipart/form-data"
		이미지를 전송하기위한 기본. -->
	<form action="${uri}" method="post" enctype="multipart/form-data">
	<div id="write-field">
		<div class="col-md-3"></div>
		<div class="col-md-6">
		<!-- 
			private int no;
			private String author;
			private String title;
			private String password;
			private String contents;
			private int hit;
			private int ref;
			private int step;
			private int lev;
			private int pnum;
			private int reply;
			private String regdate;
			private String fileName;
		 -->
			<table>
				<tr>
					<td class="td1">카테고리</td>
					<td class="td2"><select class="form-control" style="display: inline-block;">
							<option value="">&nbsp;+ 선택해주세요</option>
							<option value="">----------------------</option>
							<option value="카테고리1">ㆍ카테고리1(15)</option>
							<option value="카테고리2">ㆍ카테고리2(3)</option>
							<option value="카테고리3">ㆍ카테고리3(0)</option>
					</select></td>
				</tr>

				<tr>
					<td class="td2" colspan="2">
						<div class="row row-xs-bskr">
							<div class="col-md-6 col-sm-6 col-xs-bskr">
								<div class="input-title">작성자명</div>
								<div class="input-forms">
									<input size="20" type="text" name="author" value="${boardInfo.author}"
										class="form-control input-sm input-name bskr-font user" />
								</div>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-bskr">
								<div class="input-title">비밀번호</div>
								<div class="input-forms">
									<input size="20" type="password" name="password" value="${boardInfo.password}"
										class="form-control input-sm input-pwd bskr-font user" autocomplete="off" />
								</div>
							</div>
						</div>
					</td>
				</tr>


				<tr>
					<td class="td1">제목</td>
					<td class="td2" valign="middle">
						<input type="text" name="title" value="${boardInfo.title}" class="form-control input-sm bskr-font subject" />
						<input type="text" name="id" value="${id}">
						<c:choose>
							<c:when test="${job eq '' or job==null}">
								<input type="hidden" value="new" name="job">
							</c:when>
							<c:otherwise>
								<input type="hidden" value="${job}" name="job">
							</c:otherwise>
						</c:choose>	
					</td>
				</tr>


			</table>
			<div class="form-group">
				<table>
					<tr>
						<td class="td1"></td>
						<td class="td2"><textarea name="contents"  class="form-control col-sm-5"
								rows="20">${boardInfo.contents}</textarea></td>
					</tr>
					<tr>
					<td class="td1"></td>
						<td class="td2">
							<input type="file" id="InputFile" name="file" style="display: none;">
							<label for="InputFile" style="cursor: pointer; font-weight: inherit;">
								<img alt="FILE SELECT : " src="/springWeb/resources/img/icon/FileUpload.png" height="20em">
								<c:if test="${boardInfo.fileName eq null}">선택된 파일이 없습니다.</c:if>
								${boardInfo.fileName}
							</label>	
						</td>
					</tr>
				</table>
			</div>

			<div class="bottombox">
				<input type="button" value="취소" class="btn btn-default btn-sm"
					onclick="return cancelCheck();" />&nbsp;
				<button id="submitPost" type="submit" class="btn btn-primary btn-sm">
					확인<i class="glyphicon glyphicon-ok">&nbsp;</i>
				</button>
			</div>
		</div>
	</div>
	</form>
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
	
	<script type="text/javascript">
		$(function(){
			console.log("${uri}");
			console.log("${boardInfo}");
			console.log("${job}");
		})
		
		let job = "${job}";
		function cancelCheck(){
			if(job === "edit"){
				document.href = ""	
			}
			document.href = "write.do";
				
		}
	</script>
	${boardInfo}
</body>

</html>
