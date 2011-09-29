<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<body bgcolor="white">
	<html:form action="/file.snow?p=upload" method="post" enctype="multipart/form-data">
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
					<html:file property="uploadFile"></html:file>
				</td>
			</tr>
			<tr>
				<td align="center" clospan="2">
					<html:submit>上传</html:submit>
				</td>
			</tr>
		</table>
	</html:form>
</body>
</html>