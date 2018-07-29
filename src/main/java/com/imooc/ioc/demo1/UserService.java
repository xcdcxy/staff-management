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
	@Value("���Ϻ�")
	private String username;
	// �Զ�װ��ע���������
	//@Autowired
	// ����ָ��bean��id
	//@Qualifier("userDao")
	// �ȼ�������2��		
	
	public void save() {
		System.out.println("������service��save����");		
	}
	
	// �ȼ���xml��init-method
	@PostConstruct
	public void init() {
		System.out.println("��ʼ�����");		
	}
	
	// �ȼ���xml��destroy-method
	@PreDestroy
	private void destroy() {
		System.out.println("������...");
	}
	
}
