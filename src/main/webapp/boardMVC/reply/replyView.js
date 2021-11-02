/**
 * link to replyView.jsp
 */
console.log("link to replyView.js");
let rootContext = getContextPath();
alert("연결: "+rootContext.trim().replace("/",""));

let requestPath = rootContext+'/boardMVC/ajaxGetId.do';
let id = getIdFromSession();
let textArea;
let textCountNumber, textCount;
let textMaxSize = 30;
let ajaxForm;
let ajaxFormInput;
let replyList;

function getIdFromSession(){
	 /*
	  * length()
	  * setItem(key, value) : 세션에 데이터를 저장한다.
	  * getItem(key) : 세션의 데이터를 읽어온다.
	  * removeItem(key) : 세션에 지정한 key 값의 데이터를 삭제한다.
	  * clear() : 센션의 데이터를 전부 삭제한다.
	  * key(number) : 세션의 특정 순서의 데이터를 읽어온다.
	  * 
	  * But... session와 sessionStorage는 서버와 로컬로 저장 위치가 달라 접근이 불가하다.
	  * window.sessionStorage.getItem("id") = null...
	  */
	
	ajaxMethod(requestPath, 'POST', null, function(value){
		console.log(value); 
		id = value;
	});
}

function getContextPath() {
	//let rootContext = "${pageContext.request.contextPath}";
	var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}

function matchVariable() {
	textCountNumber = $("span.txt_byte");
	textCount = textCountNumber[0];
	textCountNumber[1].innerText = textMaxSize;
	textArea = $("textarea.tf_cmt");
	ajaxForm = $("form#ajaxForm");
	ajaxFormInput = ajaxForm.children("fieldset").children("input");
	replyList = $("div#show");
}

function ajaxMethod(url, type, data, functions){
	$.ajax({
		url : url,
		type : type,
		data : data,
		success : functions,
		error : function(request, status, error) {
			console.log("request.status : " + request.status);
			console.log("request.responseText : " + request.responseText);
			console.log("status : " + status);
			console.log("error : " + error);
		}
	});
}

printReplyList = function(value){
	let temp = "";
	$.each(value, function(index, dom) {
	temp += "<div class=\"list_cmt\">" + 
		"<div class=\"cmt_head\"></div>" + 
		"<div class=\"cmt_body\">" + 
		"<span class=\"info_append\">" + 
		"<span class=\"txt_name\">" + dom.id + "</span>" +
		"<span class=\"txt_bar\">|</span>" + 
		"<span class=\"txt_time\">" + dom.regdate + "</span></span>" +
		"<p class=\"txt_desc\">" + dom.contents +
		"</p>" +
		"</div>" +
		"<div class=\"cmt_foot\">" +
		"<a href=\"#none\">답글</a><span class=\"txt_bar\">|</span>" +
		"<a href=\"#none\">수정</a><span class=\"txt_bar\">|</span>" +
		"<a href=\"#none\">삭제</a><span class=\"txt_bar\">|</span>" +
		"<a href=\"#none\">신고</a>" +
		"</div>" + 
		"</div>";
	}); // each in temp
	
	replyList.html(temp);
}

insertReply = function(value){
	console.log(value);
	printReplyList(value);
	textArea.val("");
	textArea.focus();
}

$(function() {
	matchVariable();
	
	ajaxMethod(rootContext+'/boardMVC/ajaxReplySelect.do', 'POST', null, printReplyList);

	textArea.focus(function() {
		if (id == null || id == "") {
			this.blur();
			alert("로그인이 필요합니다!");
			location.href = "../signin.jsp"
			return;
		}
		$(this).text('');
	});

	textArea.keyup(function() {
		textCount.innerText = textArea.val().length;
		let bool = parseInt(textCount.innerText) >= textMaxSize;

		if (bool) { // boolean이 true인데 else로 자꾸 가네... 결국 변수로 뽑아 냈다.
			textArea.val(textArea.val().substring(0, textMaxSize));
			textCount.innerText = textMaxSize;

			// color
			textCount.style.color = "red";
		} else {
			textCount.style.color = "black";
		}
	}); // textArea.keyup()

	ajaxFormInput.click(function() {
		if(rootContext==null || rootContext =="") return;
		if(!(parseInt(textCount.innerText) > 0)){
			alert("댓글을 적어주세요!");
			textArea.focus();
			return;
		}
		ajaxMethod(rootContext+'/boardMVC/ajaxReplyInsert.do', 'POST', ajaxForm.serialize(), insertReply);
			
	}); // input#send.click()
});

