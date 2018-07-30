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
 * ����������
 */
@Aspect
public class MyAspectAnno {
	
	// ǰ��֪ͨ
	/*@Before(value="execution(* com.aspectJ.ProductDao.save(..))")
	public void before(JoinPoint joinPoint) {
		// joinpintΪ�����ò��������ӵ���Ϣ��
		System.out.println("ǰ����ǿ..." + joinPoint);
	}*/
	
	// ����֪ͨ
	@AfterReturning(value="myPointCut()",returning="ret")
	public void afterReturning(Object ret) {
		// ret�����صķ�������ֵ
		System.out.println("������ǿ" + ret);
	}
	
	// ����֪ͨ,�������з���
/*	@Around(value="execution(* *(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {		
		System.out.println("����ǰ��ǿ");
		// ִ�����ص��ķ���
		Object object = joinPoint.proceed();
		System.out.println("���ƺ���ǿ");
		return object;
	}*/
	
	// �쳣�׳�֪ͨ
	/*@AfterThrowing(value="execution(* *(..))", throwing="e")
	public void throwing(Throwable e) {
		System.out.println("�쳣�׳�֪ͨ" + e.getMessage());
	}*/
	
	// ����֪ͨ
/*	@After(value="execution(* *(..))")
	public void after() {
		System.out.println("����֪ͨ");
	}*/
	
	// �����صķ��������
	@Pointcut(value="execution(* com.aspectJ.ProductDao.update(..))")
	private void myPointCut() {}
}
