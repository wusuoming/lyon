package net.slowvic.biz.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ExecutionAspect {

	@Pointcut("execution(public java.util.List *..service.*.get*(..))")
	public void mainPointcut() {

	}

	@Around("mainPointcut()")
	public Object culculateExecutionTimeLength(ProceedingJoinPoint joinPoint)
			throws Throwable {
		long begin = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		long end = System.currentTimeMillis();
		System.out.println("执行时长" + (end - begin) + "毫秒");
		return result;
	}
}
