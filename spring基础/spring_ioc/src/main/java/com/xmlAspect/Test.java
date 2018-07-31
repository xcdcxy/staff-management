package com.xmlAspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 测试类
 */
public class Test {
	
	@org.junit.Test
	public void test() {
		// 加载配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		// 获取bean
	    CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");
	    customerDao.update();
	    customerDao.delete();
	}
}
