<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
	<c:out value="${msg}" />
	<br>
	<a href="${pageContext.servletContext.contextPath}/logon/中文?prefix=您好">登录</a>
</body>
</html>