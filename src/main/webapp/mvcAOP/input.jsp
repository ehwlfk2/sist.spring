<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Input</title>

<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	let $form;
	let $submit;
	let $list;
	let callBackVariable;

	function ajaxMethod(url, type, data, functions) {
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

	function refreshTransactionList(request) {
		ajaxMethod(request, 'POST', $form.serialize(), function(value) {
			//console.log(value);
			callBackVariable = value;
			console.log(callBackVariable);

			let temp = "";
			$.each(value, function(index, dom) {
				temp += "<div><b>" + dom.no + ". " + dom.msg + "</b><br/>"
						+ dom.regdate + "</div><br/>";
			})
			$list.html(temp);
		});
	}

	$(function() {
		$form = $("form");
		$submit = $("input[value=전송]");
		$update = $("input[value=수정]");
		$delete = $("input[value=삭제]");
		$list = $("div#List");

		console.log($form);
		console.log($submit);
		console.log($update);
		console.log($list);

		refreshTransactionList('aopTransactionActionDemoSelect.do');

		$submit.click(function() {
			refreshTransactionList($form[0].action);
		});
		$update.click(function(){
			refreshTransactionList('aopTransactionActionDemoUpdate.do');		
		});
		$delete.click(function(){
			refreshTransactionList('aopTransactionActionDemoDelete.do');
		});
	});
</script>

</head>
<body>
	<h4>Input</h4>

	<form action="/springWeb/mvcAOP/aopTransactionActionDemoInsert.do"
		method="post">
		<br /> <input type="text" name="no"> 
		<br /> <input type="text" name="msg">
		<br /> <input type="button" value="전송">
		<br /> <input type="button" value="수정">
		<br /> <input type="button" value="삭제">
	</form>

	<h5>List</h5>
	<div id="List"></div>
</body>
</html>