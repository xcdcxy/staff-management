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
	 * չʾ���в�����Ϣ
	 */
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ���в�����Ϣ
		List<Department>list = departmentService.getAll();
		request.setAttribute("LIST", list);
		request.getRequestDispatcher("../department_list.jsp").forward(request, response);
	}
	
	/*
	 * ɾ��������Ϣ
	 */
	public void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ű��
		Integer id = Integer.parseInt(request.getParameter("id"));
		// ɾ������
		departmentService.remove(id);
		// �ض�����������Ϣ�б�ҳ��
		response.sendRedirect(request.getContextPath() + "/department/list.do");
	}
	
	/*
	 * ׼���޸Ĳ�����Ϣ
	 */
	public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���ű��
		Integer id = Integer.parseInt(request.getParameter("id"));
		Department department = departmentService.get(id);
		request.setAttribute("OBJ", department);
		response.sendRedirect(request.getContextPath() + "/department_edit.jsp");
	}
	
	/*
	 * �޸Ĳ�����Ϣ
	 */
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ������Ϣ
		Integer id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		Department department = new Department();
		// ���ò�����Ϣ
		department.setId(id);
		department.setName(name);
		department.setAddress(address);
		// �޸Ĳ�����Ϣ
		departmentService.edit(department);
		
		request.getRequestDispatcher("/department/list.do").forward(request, response);
	}
}
