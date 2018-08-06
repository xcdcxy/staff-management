package com.imooc.sm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imooc.sm.dao.SelfDao;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.SelfService;

/*
 * 普通控制器
 */
@Controller("selfController")
public class SelfController {
	
	@Autowired
	private SelfService selfService;
	
	/*
	 * 登录
	 */
	public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 跳转至登录界面
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} 
	
	/*
	 * 登录验证程序
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取账号和密码
		String account = request.getParameter("account"); 
		String password = request.getParameter("password"); 
		// 查询用户
		Staff staff = selfService.login(account, password);
		if(staff == null) {
			// 用户名或密码错误,重定向至登录页面
			response.sendRedirect(request.getContextPath() + "/toLogin.do");
		} else {
			// 登录验证通过
			HttpSession session = request.getSession();
			session.setAttribute("USER", staff);
			response.sendRedirect(request.getContextPath() + "/main.do");
		}
	} 
	
	// 跳转主页面
	 public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("index.jsp").forward(request,response);
	    }
}
