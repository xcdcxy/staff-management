package com.imooc.sm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.StaffService;

@Controller("staffController")
public class StaffController {
	
	@Autowired
	private StaffService staffService;

	/*
	 * չʾ����Ա����Ϣ
	 */
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ����Ա����Ϣ
		List<Staff> list = staffService.getAll();
		request.setAttribute("LIST", list);
		request.getRequestDispatcher("../staff_list.jsp").forward(request, response);
	}
	
	/*
	 * ɾ��Ա����Ϣ
	 */
	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ա�����
		Integer id = Integer.parseInt(request.getParameter("id"));
		// ɾ��Ա��
		staffService.remove(id);
		response.sendRedirect("list.do");
	}	
	
	/*
	 * �鿴Ա����Ϣ
	 */
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡԱ�����
		Integer id = Integer.parseInt(request.getParameter("id"));
		Staff staff = staffService.get(id);
		request.setAttribute("OBJ", staff);
		request.getRequestDispatcher("../staff_detail.jsp").forward(request, response);
	}	
	
	
}
