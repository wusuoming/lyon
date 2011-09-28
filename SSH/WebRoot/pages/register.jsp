<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页</title>
</head>
<body>
<form action="/reg.snow?p=reg" method="post">
	姓名：<input type="text" name="userName"/><br>
	出生年月：<select name="bornYear">
				<option value="1986" selected>1986</option>
				<option value="1987">1987</option>
			  </select><br>
	性别：<input type="radio" name="gender" value="male"/>男
		  <input type="radio" name="gender" value="female"/>女<br>
	密码：<input type="password" name="password"/><br>
	邮箱：<input type="text" name="email"/><br>
	爱好：<input type="checkbox" name="favorites" value="novel"/>小说
		  <input type="checkbox" name="favorites" value="chess"/>棋类
		  <input type="checkbox" name="favorites" value="swim"/>游泳
		  <input type="checkbox" name="favorites" value="dance"/>跳舞<br>
	<input type="submit" value="注册"/>
</form>
</body>
</html>