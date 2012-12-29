package net.slowvic.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter {

    private static final Log log = LogFactory.getLog(LogInterceptor.class);
    private ThreadLocal<Long> begin = new ThreadLocal<Long>();
    private ThreadLocal<Long> end = new ThreadLocal<Long>();

    @Override
    public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response, Object handler) throws Exception {
        begin.set(System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
        HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
        end.set(System.currentTimeMillis());
        log.debug(handler.getClass().getName() + "执行用时"
            + (end.get() - begin.get()) + "毫秒");
        super.afterCompletion(request, response, handler, ex);
    }

}
