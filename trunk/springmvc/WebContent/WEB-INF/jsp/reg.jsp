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
    <c:if test="${user != null}">
    <input type="text" value="<spring:bind path="user.birthday">${status.value}</spring:bind>" />
    </c:if>
    <form action="${path}/doReg" method="post">
        <table>
            <tr>
                <td>
                    姓名：
                </td>
                <td>
                    <input type="text" name="userName">
                </td>
            </tr>
            <tr>
                <td>
                    生日：
                </td>
                <td>
                    <input type="text" name="birthday">
                </td>
            </tr>
            <tr>
                <td>
                    密码：
                </td>
                <td>
                    <input type="password" name="password">
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
