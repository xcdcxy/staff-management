package com.imooc.sm.global;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.naming.Context;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 核心控制器 (GenericServlet是servlet祖先，缺失doget,dopost方法)
 */
public class DispatcherServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
	// 用于加载spring配置文件
	private ApplicationContext context;
	
	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		/*
		 servlet名字:   /staff/add.do    /login.do
		 控制器名字:   staffController
		 控制器方法: public void add(HttpServletRequest request, HttpServletResponse response){}		 
		 */
		
		// 去掉根路径/
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
		
		// 获取控制器
		Object obj = context.getBean(beanName);		
		 try {
			// 通过反射获取方法
			Method method = obj.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			try {
				// 调用方法
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

	
	
	@Override
	public void init() throws ServletException {
		super.init();
		// 加载spring配置文件
		context = new ClassPathXmlApplicationContext("spring.xml");		
	}

}
