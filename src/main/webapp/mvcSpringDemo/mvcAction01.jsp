<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>mvcAction01.jsp</title>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	let numClicks = 0;
	let timeOut;
	let id;
	let dbclick;

	// click과 dblclick을 분리하기 위한 process 
	function startClick(id) {
		dbclick = false;
		numClicks++;

		switch (numClicks) {
		case 2:
			doDouble(id);
			break;
		case 1:
			timeOut = setTimeout("doSingle()", 150);
		}
	}

	function doDouble() {
		dbclick = true;

		numClicks = 0;
		console.log("dblclick : " + id);

		let path = "";
		switch(id){
		case 'btn3':
			path = "/springWeb/actionView.do";
			break;
		}
		
		document.location.href = path;
	}

	function doSingle() {
		if (dbclick)
			return false;

		numClicks = 0;
		console.log("click : " + id);
		
		// 0. document.location.href 변경!
		// 1. DispatcherServlet 호출! ...in web.xml
		// 2. DispatcherServlet 에서 Controller(value="buttonList.do") 호출 ...in BasicController.java
		// 3. return ModelAndView
		
		let path = "";
		switch(id){
		case 'btn1':
			path = "/springWeb/buttonList.do"
			break;
		case 'btn2':
			path = "/springWeb/buttonSet.do"
			break;
		case 'btn3':
			path = "/springWeb/buttonMap.do"
			break;
		}
		document.location.href = path;
	}

	$(function() {
		$("button").click(function() {
			text = $(this).text();
			id = this.id;
			startClick();
		});
	});
</script>

</head>
<body>

	<button id="btn1">ListData</button>
	<button id="btn2">SetData</button>
	<button id="btn3">MapData</button>

</body>
</html>