package com.aspectJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	@org.junit.Test
	public void test() {
		// ���������ļ�
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext1.xml");
		// ��ȡbean
		ProductDao productDao = (ProductDao) context.getBean("productDao");
		productDao.update();		
		productDao.delete();
	}
}
