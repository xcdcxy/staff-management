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
	
	/*
	 * ׼���޸�Ա����Ϣ
	 */
	public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Ա�����
	     Integer id = Integer.parseInt(request.getParameter("id"));
	     Staff staff = staffService.get(id);
	     request.setAttribute("OBJ", staff);
	     // ���в�����Ϣ
	     List<Department> list = departmentService.getAll();
	     request.setAttribute("DLIST", list);
	     // ��ת���޸�Ա����Ϣ����
	     request.getRequestDispatcher("../staff_edit.jsp").forward(request, response);
	}
	
	/*
	 * �޸�Ա����Ϣ
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
        // �޸���Ϣ
        staffService.edit(staff);
        
        response.sendRedirect(request.getContextPath() + "/staff/list.do");
	}
	
	/*
	 * ׼�������µ�Ա����Ϣ
	 */
	public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���в�����Ϣ
	     List<Department> list = departmentService.getAll();
	     request.setAttribute("DLIST", list);
		 request.getRequestDispatcher("../staff_add.jsp").forward(request, response);
	}
	
	/*
	 * �����µ�Ա����Ϣ
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ��Ա����Ϣ
	     String account = request.getParameter("account");
	     String name = request.getParameter("name");
	     String sex = request.getParameter("sex");
	     String idNumber = request.getParameter("idNumber");
	     Date bornDate = null;
	     try {
			bornDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("bornDate"));
		} catch (ParseException e) {
			System.out.println("����ת��ʧ��!");
			e.printStackTrace();
		}
	     String info = request.getParameter("info");
	     Integer did = Integer.parseInt(request.getParameter("did"));
	     // ������Ա��
	     Staff staff = new Staff();
	     // ����Ա����Ϣ
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
