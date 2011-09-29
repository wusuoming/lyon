package net.slowvic.web.action;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;

public class DownloadFileAction extends DownloadAction {

    /**
     * 中文文件名会乱码，原因未知
     */
	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String fileName = (String)session.getAttribute("fileName");
		String contentType = (String)session.getAttribute("contentType");
		response.setContentType("application/octet-stream;charset=UTF-8");
		response.setHeader("Content-disposition", "attachment;fileName="+fileName);
		File file = new File(fileName);
		return new FileStreamInfo(contentType, file);
	}
}
