package com.imooc.ioc.demo2;

public class Test {
	@org.junit.Test
	public void test() {
		UserDao userDao = new UserDaoImpl();
		
		UserDao proxy = (UserDao) new MyJdkProxy(userDao).createProxy();
		
		proxy.save();
		proxy.update();
	}
}
