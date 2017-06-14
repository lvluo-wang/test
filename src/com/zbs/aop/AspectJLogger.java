package com.zbs.aop;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AspectJLogger {
	
	public static final String EXECUTION ="execution(* com.zbs.aop.CommonEmployee.sign*(..))";
	
//	@Before(EXECUTION)
//	public void logBefore(){
//		System.out.println("before:����ʱ�䣺"+new Date());
//	}
//	@After(EXECUTION)
//	public void logAfter(){
//		System.out.println("after:����ʱ��:"+new Date());
//	}
	@Around(EXECUTION)
	public Object logAround(ProceedingJoinPoint joinPoint){
		System.out.println("around��ʼ��"+new Date());
		Object target = joinPoint.getTarget();
		System.out.println("�����ߣ�" +target);
		Object[] args = joinPoint.getArgs();
		Object object = null;
		try {
			object = joinPoint.proceed(args);
		} catch (Throwable e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("around����:"+new Date());
		return object;
	}

}
