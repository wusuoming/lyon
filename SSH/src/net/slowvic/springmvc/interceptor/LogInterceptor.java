package net.slowvic.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LogInterceptor implements HandlerInterceptor {

	private static final Log LOG = LogFactory.getLog(LogInterceptor.class);

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object paramObject,
			Exception paramException) throws Exception {
		LOG.debug("渲染完成");
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object paramObject,
			ModelAndView paramModelAndView) throws Exception {
		LOG.debug("处理完成,尚未渲染");
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object paramObject) throws Exception {
		LOG.debug("预处理");
		return true;
	}
}
