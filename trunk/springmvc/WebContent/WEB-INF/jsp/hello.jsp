<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/header.jsp" %>
<title>Hello World</title>
</head>
<body>
    ${message}
    ${user.userName}
    ${other}
    <form action="${path}/error/abc?flag=2,3" method="post">
        <input type="text" name="other" value="${other}">
        <input type="text" name="userName" value="${user.userName}">
        <input type="password" name="password" value="${user.password}">
        <input type="submit" class="btn" value="提交">
    </form>
</body>
</html>
