<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息视图</title>
</head>
<body>
	<table>
		<tr>
			<td>Id：</td>
			<td><c:out value="${messages[0].id}"/></td>
		</tr>
		<tr>
			<td>UserId：</td>
			<td><c:out value="${messages[0].userId}"/></td>
		</tr>
		<tr>
			<td>Title：</td>
			<td><c:out value="${messages[0].title}"/></td>
		</tr>
		<tr>
			<td>Content：</td>
			<td><c:out value="${messages[0].content}"/></td>
		</tr>
	</table>
</body>
</html>