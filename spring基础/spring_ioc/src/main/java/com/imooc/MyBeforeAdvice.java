package com.imooc;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
        System.out.println("前置增强======================");

	}

	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("环绕之前增强");
		Object object = arg0.proceed();
		System.out.println("环绕之后增强");
		return object;
	}

}
