package net.slowvic.web.action;

import java.io.File;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DownloadAction;

public class DownloadFileAction extends DownloadAction {

    /**
     * 中文名需要转码，参考第26行<br>
     * IE在确认下载时会发出二次请求，此时发送回来的文件名可能乱码<br>
     * Webkit的浏览器则不会
     */
	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String fileName = (String)session.getAttribute("fileName");
		if(fileName==null || "".equals(fileName)){
			fileName = request.getParameter("fileName");
		}
		//String displayName = new String(fileName.getBytes("gbk"),"8859_1");
		String displayName = URLEncoder.encode(fileName, "UTF-8");
		response.setHeader("Content-disposition", "attachment;fileName="+displayName);
		File file = new File(fileName);
		return new FileStreamInfo("application/x-msdownload", file);
	}
}
