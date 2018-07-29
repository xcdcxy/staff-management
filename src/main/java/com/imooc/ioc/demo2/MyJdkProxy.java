package com.imooc.ioc.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


/*
 * JDK动态代理
 */
public class MyJdkProxy implements InvocationHandler {

	// 代理对象
	UserDao userDao;
	
	public MyJdkProxy(UserDao userDao) {
		this.userDao = userDao;
	}
	
	//创建代理
	public Object createProxy() {
		// 类加载器，接口..
		Object object = Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), this);		
		return object;		
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// save方法增强
		if("save".equals(method.getName())) {
			System.out.println("save方法增强...");
		}
		return method.invoke(userDao, args);		
	}

}
