package com.imooc.sm.global;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ���Ŀ����� (GenericServlet��servlet���ȣ�ȱʧdoget,dopost����)
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ApplicationContext context;    


	public void init(ServletConfig config) throws ServletException {
		super.init();
		System.out.println("��ʼ��");
		// ����spring�����ļ�
		context = new ClassPathXmlApplicationContext("spring.xml");		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("����");
		/*
		 servlet����:   /staff/add.do    /login.do
		 ����������:   staffController
		 ����������: public void add(HttpServletRequest request, HttpServletResponse response){}		 
		 */
		
		// ȥ����·��/
		String path = request.getServletPath().substring(1);			//    staff/add.do
		String beanName = null;
		String methodName = null;
		int index = path.indexOf("/");
		
		if(index != -1) {
			beanName = path.substring(0, index) + "Controller";					// staff
			methodName = path.substring(index+1, path.indexOf(".do"));		// add
		} else {
			beanName = "selfController";						
			methodName = path.substring(0, path.indexOf(".do"));					// login
		}
		
		// ��ȡ������
		Object obj = context.getBean(beanName);		
		 try {
			// ͨ�������ȡ����
			Method method = obj.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			try {
				// ���÷���
				method.invoke(obj, request, response);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {

			e.printStackTrace();
		}
	}

}
