package com.imooc.sm.global;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aopalliance.intercept.Joinpoint;
import org.apache.catalina.tribes.util.Logs;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.imooc.sm.entity.Log;
import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.LogService;

/*
 * 日志信息代理类
 */
@Component("logAdvice")
@Aspect
public class LogAdvice {
	
	@Autowired
	private LogService logService;
	
	/*
	 * 操作日志
	 */
	@AfterReturning("execution(* com.imooc.sm.controller.*.*(..)) && !execution(* com.imooc.sm.controller.*.to*(..)) && !execution(* com.imooc.sm.controller.SelfController.*.*(..))")
	public void operationLog(JoinPoint joinPoint) {
		Log log = new Log();
		log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
		log.setOperation(joinPoint.getSignature().getName());
		HttpServletRequest request =  (HttpServletRequest) joinPoint.getArgs()[0];
		HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("USER");
		log.setOperator(staff.getAccount());
		log.setResult("正常");
		logService.addOperationLog(log);
	}
	
	/*
	 * 系统日志
	 */
	@AfterThrowing(throwing="e",pointcut="execution(* com.imooc.sm.controller.*.*(..)) && !execution(* com.imooc.sm.controller.SelfController.*(..))")
	public void systemLog(JoinPoint joinPoint, Throwable e) {
		Log log = new Log();
		log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
		log.setOperation(joinPoint.getSignature().getName());
		HttpServletRequest request =  (HttpServletRequest) joinPoint.getArgs()[0];
		HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("USER");
		log.setOperator(staff.getAccount());
		log.setResult(e.getClass().getSimpleName());
		logService.addSystemLog(log);
	}
	
	/*	
	 * 登录日志
	 */
	@After("execution(* com.imooc.sm.controller.SelfController.login(..))")
	public void loginLog(JoinPoint joinPoint) {
		System.out.println("login...");
		log(joinPoint);
	}
	
	/*
	 * 退出日志
	 */
	@Before("execution(* com.imooc.sm.controller.SelfController.logout(..))")
	public void logoutLog(JoinPoint joinPoint) {
		log(joinPoint);
	}
	
	
	// 可复用方法
	private void log(JoinPoint joinPoint) {
		Log log = new Log();
		log.setMoudle(joinPoint.getTarget().getClass().getSimpleName());
		log.setOperation(joinPoint.getSignature().getName());
		HttpServletRequest request = (HttpServletRequest) joinPoint.getArgs()[0];
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("USER");
		if(obj != null) {
			Staff staff = (Staff) obj;
			log.setOperator(staff.getAccount());
			log.setResult("正常");
		}
		logService.addLoginLog(log);
	}
	
	
}
