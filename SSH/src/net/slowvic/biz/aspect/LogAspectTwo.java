package net.slowvic.biz.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAspectTwo {
	
	@Pointcut("execution(* show*(..))")
	public void logPointcut(){
		
	}
	
	@Before(value = "logPointcut()")
	public void doBeforeOne(){
		System.out.println("do before one");
	}
}
