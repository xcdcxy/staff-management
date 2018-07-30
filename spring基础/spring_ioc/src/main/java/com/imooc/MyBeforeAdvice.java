package com.imooc;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.MethodBeforeAdvice;

public class MyBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
        System.out.println("ǰ����ǿ======================");

	}

	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("����֮ǰ��ǿ");
		Object object = arg0.proceed();
		System.out.println("����֮����ǿ");
		return object;
	}

}
