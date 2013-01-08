<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<% String path = request.getContextPath();
   request.setAttribute("path", path);
%>
<link rel="stylesheet" type="text/css" href="<%=path%>/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap-responsive.min.css">
<script type="text/javascript" src="/bootstrap/js/bootstrap.min.js"></script>