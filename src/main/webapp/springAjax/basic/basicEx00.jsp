<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>insert title name</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function ajaxProc(url, type, dataType){
		$.ajax({
			url:url,
			type:type,
			dataType:dataType,
			success:function(v){
				console.log(v);
			}
		});
	}
	$(function() {
		$("button#ajax1").click(function(){
			ajaxProc('/springWeb/ajaxMessage.do','GET','text');
		});
		$("button#ajax2").click(function(){
			ajaxProc('/springWeb/ajaxAlert.do','GET','script');
		});
		$("button#ajax3").click(function(){
			ajaxProc('/springWeb/ajaxJson.do','GET','json');
		});
		$("button[name=naver]").click(function(){
			location.href="naver" + this.lang + ".do";
		})
	});
</script>

</head>
<body>
<button id="ajax1">Ajax1</button>
<button id="ajax2">Ajax2</button>
<button id="ajax3">Ajax3</button>

<br/>
<br/>
<button name="naver" lang="01">External Connection to naver : String </button>
<br/>
<button name="naver" lang="02">External Connection to naver : ModelAndView </button>
<br/>
<button name="naver" lang="03">External Connection to naver : void </button>
<br/>
<button name="naver" lang="04">External Connection to naver : RedirectView </button>
<br/>
<button name="naver" lang="05">External Connection to naver : ResponseEntity&lt;Object&gt;</button>
<br/>
</body>
</html>