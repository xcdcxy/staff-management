package com.xmlAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*
 * ������
 */
public class Proxy {
	// ǰ��֪ͨ
	public  void before() {
		System.out.println("ǰ��֪ͨ...");
	}
	
	// ����֪ͨ
	public void afterRereturning(Object obj) {
		System.out.println("����֪ͨ" + obj);
	}
	
	// ����֪ͨ
	public Object around(ProceedingJoinPoint joinPoint ) throws Throwable {
		System.out.println("����ǰ֪ͨ");
		Object obj =	joinPoint.proceed();
		System.out.println("���ƺ�֪ͨ");
		return obj;
	}
}
