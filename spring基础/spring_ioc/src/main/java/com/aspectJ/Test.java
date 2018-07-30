package com.aspectJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	@org.junit.Test
	public void test() {
		// 加载配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
		// 获取bean
		ProductDao productDao = (ProductDao) context.getBean("productDao");
		productDao.update();		
		productDao.delete();
	}
}
