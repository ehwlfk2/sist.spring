<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mvcEx1Result</title>

<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
function getParameterByName(name) {
	console.log(name);
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    console.log(name);
    let regex = new RegExp("[\\?&]" + name + "=([^&#]*)");
    console.log(regex);
    let results = regex.exec(location.search);
    console.log(results);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

$(function(){
	let msg = getParameterByName('msg');
	console.log(msg);
	$("span").html(msg);
});
</script>

</head>
<body>
	
	<h2>Msg:<span></span></h2>
	<h4>${sList}</h4>
	<h4>${strList}</h4>
	<h4>${sv}</h4>

</body>

</html>