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
 * ��ͨ������
 */
@Controller("selfController")
public class SelfController {
	
	@Autowired
	private SelfService selfService;
	
	/*
	 * ��¼
	 */
	public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ת����¼����
		request.getRequestDispatcher("login.jsp").forward(request, response);
	} 
	
	/*
	 * ��¼��֤����
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ�˺ź�����
		String account = request.getParameter("account"); 
		String password = request.getParameter("password"); 
		// ��ѯ�û�
		Staff staff = selfService.login(account, password);
		if(staff == null) {
			// �û������������,�ض�������¼ҳ��
			response.sendRedirect(request.getContextPath() + "/toLogin.do");
		} else {
			// ��¼��֤ͨ��
			HttpSession session = request.getSession();
			session.setAttribute("USER", staff);
			response.sendRedirect(request.getContextPath() + "/main.do");
		}
	} 
	
	// ��ת��ҳ��
	 public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("index.jsp").forward(request,response);
	    }
}
