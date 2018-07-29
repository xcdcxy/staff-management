package com.imooc.ioc.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * ≤‚ ‘¿‡
 */
public class SpringTest {
	@Test
	public void test() {
		ClassPathXmlApplicationContext applicationContext	=  new ClassPathXmlApplicationContext("applicationContext.xml");
		//UserDao userDao = (UserDao) applicationContext.getBean("userService");
		UserService userService = (UserService) applicationContext.getBean("userService");
		//System.out.println(userService);
		applicationContext.close();
		
	}

}
