package com.imooc.sc.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.imooc.sc.entity.Course;

public class Test {
	@org.junit.Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Course course = new Course();
		course.setId(1003);
		course.setName("C”Ô—‘");
		course.setScore(5);
		CourseDao courseDao = (CourseDao) context.getBean("courseDao");
		courseDao.update(course);
				
		
	}
}
