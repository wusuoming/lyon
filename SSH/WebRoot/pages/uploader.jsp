<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件(使用SpringMVC)</title>
</head>
<body bgcolor="white">
	<form action="/upload/file" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td align="center" clospan="2">
					请输入以下信息：
				</td>
			</tr>
			<tr>
				<td align="left" clospan="2">
					<span style="color:red"><html:errors/></span>
				</td>
			</tr>
			<tr>
				<td align="right">
					文件名称
				</td>
				<td align="left">
					<input type="file" name="file"></file>
				</td>
			</tr>
			<tr>
				<td align="center" clospan="2">
					<input type="submit" value="上传" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>