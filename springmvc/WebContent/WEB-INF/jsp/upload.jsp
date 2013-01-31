<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/header.jsp" %>

<title>upload file</title>
<script type="text/javascript">
var checkUploadObj = null;
function uploadCallBack(msg){
    $("input[type=file]").val("");
    // $("#uploadMsg").text(msg);
}
function genUploadToken(){
    if(!$("input[type=file]").val()){
        alert("请选择文件");
        return false;
    }
    var actionPath = "${path}/doUpload";
    var uploadToken = new Date().getTime();
    $("#frm").attr("action",actionPath+"?uploadToken="+uploadToken);
    $("#uploadToken").val(uploadToken);
    checkUploadObj = window.setInterval(checkUploadPercent, 1000);
    return true;
}
function checkUploadPercent(){
    $.post("${path}/checkUploadPercent?r="+new Date().getTime(),{"uploadToken":$("#uploadToken").val()},function(msg){
    	if(msg=="sizeExceeded"){
    		$("#uploadMsg").text("上传文件超过大小");
    	}else{
    		$("#uploadMsg").text(msg);
    	}
        if(msg=="sizeExceeded" || msg=="100%"){
            window.clearInterval(checkUploadObj);
        }
    },"text");
}
</script>
</head>
<body>
    <form id="frm" action="" method="post" enctype="multipart/form-data" target="formTarget" onsubmit="return genUploadToken()">
        <input type="hidden" id="uploadToken" name="uploadToken"/>
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
