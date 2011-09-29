<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
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
	<form>
	姓名：<c:out value="${user.userName}" /><br>
	出生年月：<c:out value="${user.bornYear}" /><br>
	性别：<input type="radio" name="gender" value="male" ${user.gender=="male"?"checked":""}/>男
		  <input type="radio" name="gender" value="female" ${user.gender=="female"?"checked":""}/>女<br>
	密码：<c:out value="${user.password}" /><br>
	邮箱：<c:out value="${user.email}" /><br>
	爱好：<input type="checkbox" name="favorites" value="novel"/>小说
		  <input type="checkbox" name="favorites" value="chess"/>棋类
		  <input type="checkbox" name="favorites" value="swim"/>游泳
		  <input type="checkbox" name="favorites" value="dance"/>跳舞
	</form>
</body>
</html>