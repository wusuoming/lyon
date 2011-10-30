package net.slowvic.biz.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspectTwo {

    @Pointcut("execution(* show*(..))")
    public void logPointcut() {

    }

    @Around(value = "logPointcut()")
    public void doBeforeOne(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("开始执行");
        joinPoint.proceed();
        System.out.println("执行完成");
    }
}
