package com.imooc.ioc.demo1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component("userDao")   ע��bean��������service,repository,controller
@Repository("userDao")   
//@Scope("prototype")   ����������
public class UserDao {
	
	public UserDao() {
		System.out.println("UserDao����...");
	}

	public void save() {
		System.out.println("������dao��save����");
	}
}
