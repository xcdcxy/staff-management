package com.xmlAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * 代理类
 */
public class Proxy {
	// 前置通知
	public  void before() {
		System.out.println("前置通知...");
	}
	
	// 后置通知
	public void afterRereturning(Object obj) {
		System.out.println("后置通知" + obj);
	}
	
	// 环绕通知
	public Object around(ProceedingJoinPoint joinPoint ) throws Throwable {
		System.out.println("环绕前通知");
		Object obj =	joinPoint.proceed();
		System.out.println("环绕后通知");
		return obj;
	}
}
