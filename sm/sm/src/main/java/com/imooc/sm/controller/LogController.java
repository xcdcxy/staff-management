package com.imooc.sm.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.imooc.sm.entity.Log;
import com.imooc.sm.service.LogService;

@Controller("logController")
public class LogController {
	
	@Autowired
	private LogService logService;
	
	/*
	 * ������־
	 */
	public void operationLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ������־
	   List<Log> list = logService.getOperationLog();
	   request.setAttribute("LIST", list);
	   // ������־����
	   request.setAttribute("TYPE", "����");
	   request.getRequestDispatcher("../log_list.jsp").forward(request, response);
	}
	
	/*
	 * ϵͳ��־
	 */
	public void systemLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ������־
	   List<Log> list = logService.getSystemLog();
	   request.setAttribute("LIST", list);
	   // ������־����
	   request.setAttribute("TYPE", "ϵͳ");
	   request.getRequestDispatcher("../log_list.jsp").forward(request, response);
	}
	
	/*
	 * ��¼��־
	 */
	public void loginLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ������־
	   List<Log> list = logService.getLoginLog();
	   request.setAttribute("LIST", list);
	   // ������־����
	   request.setAttribute("TYPE", "��¼");
	   request.getRequestDispatcher("../log_list.jsp").forward(request, response);
	}
}
