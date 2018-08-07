package com.imooc.sm.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imooc.sm.entity.Department;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.DepartmentService;
import com.imooc.sm.service.StaffService;

@Controller("staffController")
public class StaffController {
	
	@Autowired
	private StaffService staffService;

	@Autowired
	private DepartmentService departmentService;
	
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
	
	/*
	 * 准备修改员工信息
	 */
	public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 员工编号
	     Integer id = Integer.parseInt(request.getParameter("id"));
	     Staff staff = staffService.get(id);
	     request.setAttribute("OBJ", staff);
	     // 所有部门信息
	     List<Department> list = departmentService.getAll();
	     request.setAttribute("DLIST", list);
	     // 跳转至修改员工信息界面
	     request.getRequestDispatcher("../staff_edit.jsp").forward(request, response);
	}
	
	/*
	 * 修改员工信息
	 */
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Integer id =	Integer.parseInt(request.getParameter("id"));
		String account = request.getParameter("account");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String idNumber = request.getParameter("idNumber");
		String info = request.getParameter("info");
		Date bornDate = null;
		try {
			bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Integer did = 	Integer.parseInt(request.getParameter("did"));
		Staff staff = staffService.get(id);
		
		staff.setInfo(info);
        staff.setBornDate(bornDate);
        staff.setIdNumber(idNumber);
        staff.setDid(did);
        staff.setAccount(account);
        staff.setName(name);
        staff.setSex(sex);
        // 修改信息
        staffService.edit(staff);
        
        response.sendRedirect(request.getContextPath() + "/staff/list.do");
	}
	
	/*
	 * 准备增加新的员工信息
	 */
	public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 所有部门信息
	     List<Department> list = departmentService.getAll();
	     request.setAttribute("DLIST", list);
		 request.getRequestDispatcher("../staff_add.jsp").forward(request, response);
	}
	
	/*
	 * 增加新的员工信息
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取新员工信息
	     String account = request.getParameter("account");
	     String name = request.getParameter("name");
	     String sex = request.getParameter("sex");
	     String idNumber = request.getParameter("idNumber");
	     Date bornDate = null;
	     try {
			bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
		} catch (ParseException e) {
			System.out.println("日期转化失败!");
			e.printStackTrace();
		}
	     String info = request.getParameter("info");
	     Integer did = Integer.parseInt(request.getParameter("did"));
	     // 创建新员工
	     Staff staff = new Staff();
	     // 设置员工信息
	     staff.setAccount(account);
	     staff.setName(name);
	     staff.setSex(sex);
	     staff.setIdNumber(idNumber);
	     staff.setBornDate(bornDate);
	     staff.setInfo(info);
	     staff.setDid(did);
	     
	     staffService.add(staff);
	     response.sendRedirect(request.getContextPath() + "/staff/list.do");
	}
	
}
