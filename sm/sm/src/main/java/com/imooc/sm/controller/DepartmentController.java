package com.imooc.sm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imooc.sm.entity.Department;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.DepartmentService;

@Controller("departmentController")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	/*
	 * 展示所有部门信息
	 */
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取所有部门信息
		List<Department>list = departmentService.getAll();
		request.setAttribute("LIST", list);
		request.getRequestDispatcher("../department_list.jsp").forward(request, response);
	}
	
	/*
	 * 删除部门信息
	 */
	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 部门编号
		Integer id = Integer.parseInt(request.getParameter("id"));
		// 删除部门
		departmentService.remove(id);
		// 重定向至部门信息列表页面
		response.sendRedirect(request.getContextPath() + "/department/list.do");
	}
	
	/*
	 * 准备修改部门信息
	 */
	public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 部门编号
		Integer id = Integer.parseInt(request.getParameter("id"));
		Department department = departmentService.get(id);
		request.setAttribute("OBJ", department);
		response.sendRedirect(request.getContextPath() + "/department_edit.jsp");
	}
	
	/*
	 * 修改部门信息
	 */
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取部门信息
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		Department department = new Department();
		// 设置部门信息
		department.setId(id);
		department.setName(name);
		department.setAddress(address);
		// 修改部门信息
		departmentService.edit(department);
		
		request.getRequestDispatcher("/department/list.do").forward(request, response);
	}
}
