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
var cfg = 	{
	    type: 'POST', 
	    data: {"userName":"winzip","age":26}, 
	    dataType: 'json',
	    contentType:'application/json;charset=UTF-8',	    
	    success: function(result) { 
	        alert(result.success); 
	    } 
	};

function doTestJson(actionName){
	cfg.url = actionName;
	$.ajax(cfg);
}
</script>
</head>
<body>
	<a href="#" onclick="javascript:postLink()">访问@RequestBody注解</a><br>
	<a href="#" onclick="javascript:doTestJson('/json/json2')">访问HttpEntity签名方法</a><br>
	<a href="/ask/toEmp">redirect跳转</a><br>
</body>
</html>