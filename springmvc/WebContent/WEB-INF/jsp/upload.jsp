<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/header.jsp" %>
<title>upload file</title>
</head>
<body>
    <form action="${path}/doUpload" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>
                    选择文件：
                </td>
                <td>
                    <input type="file" class="btn" name="uploadFile"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" class="btn" value="提交">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
