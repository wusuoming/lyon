package net.slowvic.biz.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;

public class LogAspect {
    private static Log log = LogFactory.getLog(LogAspect.class);

    public void beginLog(JoinPoint joinPoint,String style) {
        System.out.println(joinPoint.getSignature());
        log.debug("开始执行,传入参数是"+style);
    }

    public void endLog(String style) {
        log.debug("执行完毕,传入参数是"+style);
    }
}
