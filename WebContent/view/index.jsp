<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">
<title>Index</title>

<style type="text/css">
button {
	padding: 40px;
	margin: 200px 0 0 0;
	font-size: 30px;
}
*{
	text-align: center;
}
</style>

<script type="text/javascript">
	function list_go() {
		location.href = "/MyController?cmd=list";
	}
</script>

</head>

<body>
	<button onclick="list_go()">리스트 보기</button>
</body>
</html>