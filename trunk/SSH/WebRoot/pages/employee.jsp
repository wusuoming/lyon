<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工资料</title>
<style>.errorClass{color:red}</style>
</head>
<body>
	<c:if test="${employee!=null}">
	姓名：<c:out value="${employee.userName}" /><br>
	年龄：<c:out value="${employee.age}" /><br>
	公司：<c:out value="${employee.company.companyName}" /><br>
	薪酬：<c:out value="${employee.salary}" /><br>
	</c:if>
	
	<form:form action="/emp/post" method="post" commandName="employee" >
	姓名：<form:input path="userName"/><form:errors cssClass="errorClass" path="userName"/><br>
	年龄：<form:input path="age"/><br>
	公司：<form:input path="company.companyName"/><br>
	薪酬：<form:input path="salary"/><form:errors cssClass="errorClass" path="salary"/><br>
	<input type="submit" value="提交">
	</form:form>
</body>
</html>