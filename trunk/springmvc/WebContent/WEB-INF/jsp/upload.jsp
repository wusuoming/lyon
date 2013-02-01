<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="template/header.jsp" %>
<script type="text/javascript" src="${path}/progressbar/js/jquery.progressbar.min.js"></script>
<title>upload file</title>
<script type="text/javascript">
var checkUploadObj = null;
var callbackMsg = null;
function uploadCallBack(msg){
    callbackMsg = msg;
    var uploadFile = document.getElementById("uploadFile");
    uploadFile.outerHTML += "";
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
    $("#uploadMsg").progressBar({barImage:'progressbar/images/progressbg_green.gif'});
    checkUploadObj = window.setInterval(checkUploadPercent, 1000);
    return true;
}
function checkUploadPercent(){
    $.post("${path}/checkUploadPercent?r="+new Date().getTime(),{"uploadToken":$("#uploadToken").val()},function(msg){
    	if(callbackMsg && callbackMsg !="100"){
    		$("#uploadMsg").text(callbackMsg);
    	}else{
    		$("#uploadMsg").progressBar(msg * 1);
    	}
        if(callbackMsg || msg=="100"){
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
                    <input type="file" class="btn" id="uploadFile" name="uploadFile"/>
                    <span id="uploadMsg"></span>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="left">
                    <input type="submit" class="btn" value="提交">
                </td>
            </tr>
        </table>
    </form>
    <iframe name="formTarget" style="display:none;"></iframe>
</body>
</html>
