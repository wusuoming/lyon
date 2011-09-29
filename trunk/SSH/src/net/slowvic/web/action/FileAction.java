package net.slowvic.web.action;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.slowvic.web.form.FileForm;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;

public class FileAction extends DispatchAction {

	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//读取上传文件
		FileForm fileForm = (FileForm)form;
		FormFile uploadFile = fileForm.getUploadFile();
		String contentType = uploadFile.getContentType();
		String fileName = uploadFile.getFileName();
		int fileSize = uploadFile.getFileSize();
		byte[] fileData = uploadFile.getFileData();
		
		//保存上传文件到当前目录下
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
		bos.write(fileData);
		bos.close();
		
		HttpSession session = request.getSession();
		session.setAttribute("fileName", fileName);
		session.setAttribute("contentType", contentType);
		session.setAttribute("fileSize", fileSize);
		
		return mapping.findForward("download");
	}
	
	public ActionForward open(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return null;
	}
}
