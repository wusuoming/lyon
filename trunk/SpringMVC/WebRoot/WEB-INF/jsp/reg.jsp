<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
</head>
<body>
<form action="user.snow?p=display" method="post">
	<table>
		<tr>
			<td>Id：</td>
			<td><input type="text" name="id"/></td>
		</tr>
		<tr>
			<td>userName：</td>
			<td><input type="text" name="userName"/></td>
		</tr>
		<tr>
			<td>password：</td>
			<td><input type="password" name="password"/></td>
		</tr>
		<tr>
			<td>submit：</td>
			<td><input type="submit" value="submit"/></td>
		</tr>
	</table>
</form>
</body>
</html>