<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/header.jsp" %>

<title>upload file</title>
<script type="text/javascript">
$(function(){
	alert("h");
	genUploadToken();
})
function uploadCallBack(msg){
	$("input[type=file]").val("");
	$("#uploadMsg").text(msg);
}
function genUploadToken(){
	$("#uploadToken").val("哈哈");
}
</script>
</head>
<body>
    <form action="${path}/doUpload" method="post" enctype="multipart/form-data" target="formTarget">
        <input type="hidden" id="uploadToken" name="uploadToken" value="123456789"/>
        <table>
            <tr>
                <td>
                    选择文件：
                </td>
                <td>
                    <input type="file" class="btn" name="uploadFile"/>
                    <span id="uploadMsg"></span>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" class="btn" value="提交">
                </td>
            </tr>
        </table>
    </form>
    <iframe name="formTarget" style="display:none;"></iframe>
</body>
</html>
