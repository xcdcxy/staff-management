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
	 * 展示所有员工信息
	 */
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取所有员工信息
		List<Staff> list = staffService.getAll();
		request.setAttribute("LIST", list);
		request.getRequestDispatcher("../staff_list.jsp").forward(request, response);
	}
	
	/*
	 * 删除员工信息
	 */
	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 员工编号
		Integer id = Integer.parseInt(request.getParameter("id"));
		// 删除员工
		staffService.remove(id);
		response.sendRedirect("list.do");
	}	
	
	/*
	 * 查看员工信息
	 */
	public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取员工编号
		Integer id = Integer.parseInt(request.getParameter("id"));
		Staff staff = staffService.get(id);
		request.setAttribute("OBJ", staff);
		request.getRequestDispatcher("../staff_detail.jsp").forward(request, response);
	}	
	
	
}
