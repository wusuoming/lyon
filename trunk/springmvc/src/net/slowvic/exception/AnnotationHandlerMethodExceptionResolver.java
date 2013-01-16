package net.slowvic.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class AnnotationHandlerMethodExceptionResolver implements
    HandlerExceptionResolver {

    private static final Log LOG = LogFactory
        .getLog(AnnotationHandlerMethodExceptionResolver.class);

    private String defaultErrorView;

    public String getDefaultErrorView() {
        return defaultErrorView;
    }

    public void setDefaultErrorView(String defaultErrorView) {
        this.defaultErrorView = defaultErrorView;
    }

    public ModelAndView resolveException(
        HttpServletRequest request, HttpServletResponse response,
        Object handler, Exception ex) {
        // 一定要把异常记录下来，否则就被吞了。
        if (LOG.isErrorEnabled()) {
            LOG.error(ex);
        }
        if (handler != null) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            if (method != null) {
                ResponseBody responseBody = AnnotationUtils.findAnnotation(
                    method, ResponseBody.class);
                if (responseBody != null) {
                    return handleAjaxException(response, ex);
                }
            }
        }
        return handlePageException(request, ex);
    }

    private ModelAndView handlePageException(HttpServletRequest request,
        Exception ex) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("ex", ex.getClass().getName());
        mav.setViewName(defaultErrorView);
        return mav;
    }

    private ModelAndView handleAjaxException(HttpServletResponse response,
        Exception ex) {
        response.setContentType("text/json;charset=UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write("{\"err\":\"调用失败\"}");
            writer.close();
        }
        catch (IOException e) {

        }
        return null;
    }
}
