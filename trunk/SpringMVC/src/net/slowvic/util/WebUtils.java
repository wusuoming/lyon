package net.slowvic.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class WebUtils {
	public static void writeResponse(HttpServletResponse response,
			String dataType, String content) throws IOException {
		response.setContentType("text/" + dataType + ";charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(content);
		pw.flush();
		pw.close();
	}
}
