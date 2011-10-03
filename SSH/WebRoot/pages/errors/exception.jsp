<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>操作异常</title>
</head>
<body>
		${pageContext.errorData.throwable.cause}
		${pageContext.errorData.throwable.message}
</body>
</html>