<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>replyView.jsp</title>
<link rel="stylesheet" href="rss.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="replyView.js" charset="UTF-8"></script>
</head>
<body>
<div class="cmt_comm">
	<form id="ajaxForm" action="ajaxForm.do">
		<fieldset class="fld_cmt">
			<legend class="screen_out">댓글 작성</legend>
			<textarea name="contents" class="tf_cmt" cols="90" rows="5">한줄 토크를 달아주세요! (300자)</textarea>
			<!-- <button type="submit" class="img_sample btn_cmt">등록</button> -->
			<input type="button" value="등록" style="position: absolute;top: 50px; width: 100px; height: 54px;">
			<input type="hidden" name="id" value="${id}">
			<input type="hidden" name="job" value="new">
			<p class="info_append">
				<span class="screen_out">[id : ${id}]</span>
				<span class="screen_out">입력된 바이트 수 : </span>
				<span class="txt_byte">0</span> / <span class="txt_byte"></span>
				<span class="txt_bar">|</span>
				<a href="#none">댓글 운영원칙</a>
			</p>
		</fieldset>
	</form>

	<strong class="screen_out">전체 댓글</strong>

	<%--
	<div class="list_cmt">
		<div class="cmt_head"></div>
		<div class="cmt_body">
			<span class="info_append">
				<span class="txt_name">글쓴이</span>
				<span class="txt_bar">|</span>
				<span class="txt_time">2013.01.01 14:22</span>
			</span>
			<p class="txt_desc">
				댓글 내용이 나오는 곳...댓글댓글 내용이 나오는 곳...댓글 내용이 나오는 곳...댓글 내용이 나오는 곳...
			</p>
		</div>
		<div class="cmt_foot">
			<a href="#none">답글</a><span class="txt_bar">|</span><a href="#none">수정</a><span class="txt_bar">|</span><a href="#none">삭제</a><span class="txt_bar">|</span><a href="#none">신고</a>
		</div>
	</div>
	 --%>
	<div id=show></div>

</div>

</body>
</html>