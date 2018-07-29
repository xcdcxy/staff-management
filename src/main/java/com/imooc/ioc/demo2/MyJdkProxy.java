package com.imooc.ioc.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/*
 * JDK��̬����
 */
public class MyJdkProxy implements InvocationHandler {

	// �������
	UserDao userDao;
	
	public MyJdkProxy(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//��������
	public Object createProxy() {
		// ����������ӿ�..
		Object object = Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), this);		
		return object;		
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// save������ǿ
		if("save".equals(method.getName())) {
			System.out.println("save������ǿ...");
		}
		return method.invoke(userDao, args);		
	}

}
