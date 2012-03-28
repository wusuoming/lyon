<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工资料</title>
</head>
<body>
	姓名：<c:out value="${employee.userName}" /><br>
	年龄：<c:out value="${employee.age}" /><br>
	籍贯：<c:out value="${employee.company.companyName}" /><br>
</body>
</html>