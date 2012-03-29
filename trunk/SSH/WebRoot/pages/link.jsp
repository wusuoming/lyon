<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>各种请求链接</title>
<script type="text/javascript">
function postLink(){
	$.ajax({
		url:"/ask/handle01",
		type:"post",
		data:{"userName":"中文","age":26},
		contentType:"application/json;charset=utf-8",
		success:function(msg){
			alert(msg);
		}
	});
}
</script>
</head>
<body>
	<a href="#" onclick="javascript:postLink()">访问@RequestBody注解</a>
</body>
</html>