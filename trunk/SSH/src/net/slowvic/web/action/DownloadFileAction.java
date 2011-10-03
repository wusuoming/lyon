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
     * 中文名需要转码，参考第26行<br>
     * 经测试，IE9以下会出现某些特殊字符乱码的问题。<br>
     * 原因在于IE会发送多次请求。
     */
	@Override
	protected StreamInfo getStreamInfo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String fileName = (String)session.getAttribute("fileName");
		if(fileName==null || "".equals(fileName)){
			fileName = request.getParameter("fileName");
		}
		String displayName = new String(fileName.getBytes("gbk"),"8859_1");
		response.setHeader("Content-disposition", "attachment;fileName="+displayName);
		File file = new File(fileName);
		return new FileStreamInfo("application/x-msdownload", file);
	}
}
