package com.imooc.ioc.demo1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//@Service("userService")
public class UserService {
	@Value("李孟浩")
	private String username;
	// 自动装配注入特殊对象
	//@Autowired
	// 主动指定bean的id
	//@Qualifier("userDao")
	// 等价于上面2句		
	
	public void save() {
		System.out.println("调用了service的save方法");		
	}
	
	// 等价于xml的init-method
	@PostConstruct
	public void init() {
		System.out.println("初始化完成");		
	}
	
	// 等价于xml的destroy-method
	@PreDestroy
	private void destroy() {
		System.out.println("销毁中...");
	}
	
}
