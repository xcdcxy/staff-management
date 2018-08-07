package com.imooc.sm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.PortableServer.SERVANT_RETENTION_POLICY_ID;
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
	
	// autowire会自动去IoC容器里寻找其实例
	@Autowired
	private SelfService selfService;
	
	/*
	 * 登录
	 */
	public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 跳转至登录界面
		if(selfService == null)
			System.out.println("selfService is null!");
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
	
	/*
	 *  跳转主页面
	 */
	 public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("index.jsp").forward(request,response);
	 }
	 
	 /*
	  * 查看个人信息
	  */
	 public void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("../info.jsp").forward(request,response);
	}
	 
	 /*
	  * 退出登录
	  */
	 public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	// 注销用户
		 	HttpSession session = request.getSession();
		 	session.setAttribute("USER", null);
		 	// 跳转登录界面
		 	response.sendRedirect(request.getContextPath() + "/toLogin.do");		 	
		} 
	 	 
	 //     /self/toChangePassword.do
	 public void toChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // 跳转至密码修改界面
		 request.getRequestDispatcher("../change_password.jsp").forward(request, response);
	} 
	 
	 /*
	  * 修改密码
	  */
	 public void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String password = request.getParameter("password");
		 String password1 = request.getParameter("password1");
		 Staff staff = (Staff) request.getSession().getAttribute("USER");
		 if(!password.equals(staff.getPassword())) {
			 // 原始密码输入错误
			 response.sendRedirect("toChangePassword.do");
		 } else {
			 // 修改密码
			 selfService.changePassword(staff.getId(), password1);
			 // 退出登录
			 response.sendRedirect(request.getContextPath() + "/logout.do");
		 }

	} 
}
