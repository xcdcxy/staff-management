package com.imooc.sm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

/*
 * ��ͨ������
 */
@Controller("selfController")
public class SelfController {
	
	/*
	 * ��¼
	 */
	public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ת����¼����
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} 
}
