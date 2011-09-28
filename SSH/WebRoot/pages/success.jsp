<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>成功</title>
</head>
<body>
	<h2 align="center">
		<bean:message key="reg.success"/>
	</h2>
	您的注册信息如下
	<hr>
	姓名：<c:out value="${user.userName}" /><br>
	出生年月：<c:out value="${user.bornYear}" /><br>
	性别：<input type="radio" name="gender" value="male" checked="<c:out value='${user.gender=="male"}'/>"/>男
		  <input type="radio" name="gender" value="female" checked=/>女<br>
	密码：<c:out value="${user.password}" /><br>
	邮箱：<c:out value="${user.email}" /><br>
	爱好：<c:out value="${user.favorites}" /><br>
</body>
</html>