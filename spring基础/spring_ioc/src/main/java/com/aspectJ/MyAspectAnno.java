package com.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
 * 定义切面类
 */
@Aspect
public class MyAspectAnno {
	
	// 前置通知
	/*@Before(value="execution(* com.aspectJ.ProductDao.save(..))")
	public void before(JoinPoint joinPoint) {
		// joinpint为可配置参数（连接点信息）
		System.out.println("前置增强..." + joinPoint);
	}*/
	
	// 后置通知
	@AfterReturning(value="myPointCut()",returning="ret")
	public void afterReturning(Object ret) {
		// ret是拦截的方法返回值
		System.out.println("后置增强" + ret);
	}
	
	// 环绕通知,拦截所有方法
/*	@Around(value="execution(* *(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {		
		System.out.println("环绕前增强");
		// 执行拦截到的方法
		Object object = joinPoint.proceed();
		System.out.println("环绕后增强");
		return object;
	}*/
	
	// 异常抛出通知
	/*@AfterThrowing(value="execution(* *(..))", throwing="e")
	public void throwing(Throwable e) {
		System.out.println("异常抛出通知" + e.getMessage());
	}*/
	
	// 最终通知
/*	@After(value="execution(* *(..))")
	public void after() {
		System.out.println("最终通知");
	}*/
	
	// 给拦截的方法起别名
	@Pointcut(value="execution(* com.aspectJ.ProductDao.update(..))")
	private void myPointCut() {}
}
