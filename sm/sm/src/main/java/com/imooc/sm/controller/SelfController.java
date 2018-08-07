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
 * ��ͨ������
 */
@Controller("selfController")
public class SelfController {
	
	// autowire���Զ�ȥIoC������Ѱ����ʵ��
	@Autowired
	private SelfService selfService;
	
	/*
	 * ��¼
	 */
	public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ת����¼����
		if(selfService == null)
			System.out.println("selfService is null!");
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
	
	/*
	 *  ��ת��ҳ��
	 */
	 public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.getRequestDispatcher("index.jsp").forward(request,response);
	 }
	 
	 /*
	  * �鿴������Ϣ
	  */
	 public void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.getRequestDispatcher("../info.jsp").forward(request,response);
	}
	 
	 /*
	  * �˳���¼
	  */
	 public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	// ע���û�
		 	HttpSession session = request.getSession();
		 	session.setAttribute("USER", null);
		 	// ��ת��¼����
		 	response.sendRedirect(request.getContextPath() + "/toLogin.do");		 	
		} 
	 	 
	 //     /self/toChangePassword.do
	 public void toChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // ��ת�������޸Ľ���
		 request.getRequestDispatcher("../change_password.jsp").forward(request, response);
	} 
	 
	 /*
	  * �޸�����
	  */
	 public void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String password = request.getParameter("password");
		 String password1 = request.getParameter("password1");
		 Staff staff = (Staff) request.getSession().getAttribute("USER");
		 if(!password.equals(staff.getPassword())) {
			 // ԭʼ�����������
			 response.sendRedirect("toChangePassword.do");
		 } else {
			 // �޸�����
			 selfService.changePassword(staff.getId(), password1);
			 // �˳���¼
			 response.sendRedirect(request.getContextPath() + "/logout.do");
		 }

	} 
}
