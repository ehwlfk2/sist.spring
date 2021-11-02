<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
    <title></title>
    <script src="../../js/jquery.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            alert($("div p").html());
        });
    </script>
</head>
<body>
    <p>one</p>
        <div>
            <p>two</p>
        </div>
    <p>three</p>
</body>
</html>