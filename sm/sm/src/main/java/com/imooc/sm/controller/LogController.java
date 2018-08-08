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
	 * 操作日志
	 */
	public void operationLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取操作日志
	   List<Log> list = logService.getOperationLog();
	   request.setAttribute("LIST", list);
	   // 设置日志类型
	   request.setAttribute("TYPE", "操作");
	   request.getRequestDispatcher("../log_list.jsp").forward(request, response);
	}
	
	/*
	 * 系统日志
	 */
	public void systemLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取操作日志
	   List<Log> list = logService.getSystemLog();
	   request.setAttribute("LIST", list);
	   // 设置日志类型
	   request.setAttribute("TYPE", "系统");
	   request.getRequestDispatcher("../log_list.jsp").forward(request, response);
	}
	
	/*
	 * 登录日志
	 */
	public void loginLog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取操作日志
	   List<Log> list = logService.getLoginLog();
	   request.setAttribute("LIST", list);
	   // 设置日志类型
	   request.setAttribute("TYPE", "登录");
	   request.getRequestDispatcher("../log_list.jsp").forward(request, response);
	}
}
