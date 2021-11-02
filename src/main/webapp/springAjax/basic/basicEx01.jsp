<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert title name</title>

<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("button").click(function(){
			alert(this.lang);
			
			$.ajax({
				type: 'POST',
				contentType: 'application/json;charset=UTF-8',
				//url:'', //공란이면 자기자신의 uri를 던진다.
				url:'/springWeb/' + this.lang + '.do',
				dataType: 'json',
				data:{hi : '안녕하세요?'},
				success:function(value){
					console.log(value);
				},
				error:function(request, status, error){
					console.log("request.status : " + request.status); 
					console.log("request.responseText : " + request.responseText); 
					console.log("status : " + status);
					console.log("error : " + error);
				}
			});
		}); // button
	}); // window function
</script>

</head>
<body>
	<button lang="koreaEncoding">koreaGreet</button>
	<button lang="studentList">Student</button>
	<button lang="empList">EMP</button>
	<button lang="deptInfo">DEPT</button>
</body>
</html>