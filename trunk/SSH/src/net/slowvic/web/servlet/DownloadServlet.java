package net.slowvic.web.servlet;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 3054066981298011537L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String fileName = req.getParameter("fileName");
		resp.setContentType("application/x-msdownload");
		resp.setHeader("Content-Disposition", "attachment;fileName="
				+ new String(fileName.getBytes("gbk"), "8859_1"));
		// 该处使用字节流，如使用字符流会乱码
		ServletOutputStream sos = resp.getOutputStream();
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				new File(fileName)));
		byte[] byteBuffer = new byte[1024];
		while (bis.read(byteBuffer) != -1) {
			sos.write(byteBuffer);
		}
		sos.flush();
		sos.close();
		bis.close();
	}
}
