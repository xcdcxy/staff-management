package com.imooc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	
	
	@org.junit.Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		StudentDao studentDao = (StudentDao) context.getBean("studentDaoProxy");
		studentDao.update();
		studentDao.delete();
		studentDao.save();
		studentDao.find();
	}
}
