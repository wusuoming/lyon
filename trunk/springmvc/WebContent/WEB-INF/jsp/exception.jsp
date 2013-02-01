<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/header.jsp"%>
<title>异常</title>
<script type="text/javascript">
$(function(){
	if("${uploadEx}"=="true"){
		window.parent.uploadCallBack($("#err").text());
	}
})
</script>
</head>
<body>
	<div id="err">
		<spring:message code="${ex}" text="未知错误"></spring:message>
	</div>
</body>
</html>
