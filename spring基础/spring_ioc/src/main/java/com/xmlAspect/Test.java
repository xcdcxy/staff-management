package com.xmlAspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * ������
 */
public class Test {
	
	@org.junit.Test
	public void test() {
		// ���������ļ�
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext2.xml");
		// ��ȡbean
	    CustomerDao customerDao = (CustomerDao) context.getBean("customerDao");
	    customerDao.update();
	    customerDao.delete();
	}
}
