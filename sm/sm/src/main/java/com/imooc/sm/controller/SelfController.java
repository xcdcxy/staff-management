package com.imooc.sm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;

/*
 * 普通控制器
 */
@Controller("selfController")
public class SelfController {
	
	/*
	 * 登录
	 */
	public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 跳转至登录界面
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} 
}
