package com.imooc.ioc.demo1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component("userDao")   注册bean，可以用service,repository,controller
@Repository("userDao")   
//@Scope("prototype")   声明作用域
public class UserDao {
	
	public UserDao() {
		System.out.println("UserDao构造...");
	}

	public void save() {
		System.out.println("调用了dao的save方法");
	}
}
