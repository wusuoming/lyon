<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/header.jsp" %>
<title>register</title>
</head>
<body>
    <form action="${path}/doReg" method="post">
        <input type="text" name="userName">
        <input type="text" name="birthday">
        <input type="password" name="password">
        <input type="submit" value="提交">
    </form>
</body>
</html>
